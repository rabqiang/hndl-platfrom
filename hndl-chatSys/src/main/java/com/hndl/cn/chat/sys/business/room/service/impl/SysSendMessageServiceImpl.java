package com.hndl.cn.chat.sys.business.room.service.impl;

import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.chat.sys.business.room.service.SysSendMessageService;
import com.hndl.cn.chat.sys.business.room.vo.EaseMobMessageVo;
import com.hndl.cn.chat.sys.common.constants.ChatSysConstants;
import com.hndl.cn.chat.sys.exception.ChatSysException;
import com.hndl.cn.chat.sys.exception.ChatSysExceptionEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.easemob.bean.ChatRoomMsgInfoDo;
import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobFansGroupChatRoomDo;
import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobUserInfoDo;
import com.hndl.cn.mongodb.manager.easemob.manager.ChatRoomMsgInfoManager;
import com.hndl.cn.mongodb.manager.easemob.manager.EaseMobFansGroupChatRoomManager;
import com.hndl.cn.mongodb.manager.easemob.manager.EaseMobUserInfoManager;
import com.hndl.cn.mongodb.manager.easemob.manager.UserIsToRoomInfoManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.string.SensitiveWordFilter;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

import static java.util.Comparator.comparing;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 20:20
 * @Created by 湖南达联
 */
@Service
public class SysSendMessageServiceImpl implements SysSendMessageService {


    @Resource
    private EaseMobUserInfoManager easeMobUserInfoManager;

    @Resource
    private UserDayTaskManager userDayTaskManager;


    @Resource
    private UserIsToRoomInfoManager userIsToRoomInfoManager;

    @Resource
    private EaseMobFansGroupChatRoomManager easeMobFansGroupChatRoomManager;


    @Resource
    private ChatRoomMsgInfoManager chatRoomMsgInfoManager;


    @Resource
    private RedisService redisService;

    @Override
    public Result<Object> sendTxtMessage(Long sysUinId,String msg, String roomId) {

        this.checkIsValid(sysUinId,roomId);

        return ResultFactory.success();
    }

    @Override
    public Result<Object> reportMessageRewardTask(CommonUserInfoDo commonUserInfoDo,EaseMobMessageVo easeMobMessageVo) {

        this.checkIsValid(commonUserInfoDo.getSysUniId(),easeMobMessageVo.getRoomId());

        String msg = SensitiveWordFilter.INSTANCE.replaceSensitiveWord(easeMobMessageVo.getMsg(),SensitiveWordFilter.minMatchTYpe);

        ChatRoomMsgInfoDo chatRoomMsgInfoDo = ChatRoomMsgInfoDo.builder().nickName(commonUserInfoDo.getNickName())
                .userUinId(commonUserInfoDo.getSysUniId()).userId(commonUserInfoDo.getId())
                .msg(msg).faceImg(commonUserInfoDo.getPersonImgUrlMin())
                .roomId(easeMobMessageVo.getRoomId()).build();


        //每次上报都生成聊天室信息，利用mongo无事务特性
        chatRoomMsgInfoManager.insertChatRoomMsgInfoDo(chatRoomMsgInfoDo);


        Long count = userDayTaskManager.countToDayTask(commonUserInfoDo.getSysUniId(), UserDayTaskEnums.ROOM_TASK);

        if(ChatSysConstants.TO_DAY_SEND_MSG_MAX_COUNT <= count){
            return ResultFactory.success(msg);
        }

        EaseMobFansGroupChatRoomDo groupChatRoomByRoomId = easeMobFansGroupChatRoomManager.findGroupChatRoomByRoomId(easeMobMessageVo.getRoomId());

        if(groupChatRoomByRoomId == null){
            throw new ChatSysException(
                    ChatSysExceptionEnums.CHAT_SYS_EX_SEND_MSG_TASK_ERROR.getCode());
        }

        userDayTaskManager.insert(commonUserInfoDo.getSysUniId(),groupChatRoomByRoomId.getFansGroupId(),UserDayTaskEnums.ROOM_TASK);

        return ResultFactory.success(msg);
    }

    @Override
    public Result<Object> findHistoryChatMessageByRoomId(String roomId) {

        String key = ChatSysConstants.HISTORY_CHAT_ROOM_MSG_KEY + roomId;

        //先走缓存
        List<ChatRoomMsgInfoDo> msgList = redisService.get(key);

        //不为空则返回，因为我们会设置一个key放到缓存中防止击穿缓存
        if(msgList == null){
            //查询数据
            msgList = chatRoomMsgInfoManager.findChatRoomMsgInfoDoByRoomId(roomId,ChatSysConstants.HISTORY_CHAT_ROOM_LIMIT);
            //保存查询的数据，如果没有也保存一个值，防止缓存击穿
            if(CollectionUtils.isNotEmpty(msgList)){
                msgList.sort(comparing((ChatRoomMsgInfoDo info) -> info.getCreateTime()));
            }
            redisService.set(key,msgList,ChatSysConstants.HISTORY_CHAT_ROOM_KEY_TIME_OUT);
        }

        return ResultFactory.success(msgList);
    }

    private void checkIsValid(Long sysUinId,String roomId){
        //查询用户是否加入聊天室
//        boolean userIsToRoom = userIsToRoomInfoManager.userIsToRoom(sysUinId,roomId);
//
//        if(!userIsToRoom){
//            throw new ChatSysException(
//                    ChatSysExceptionEnums.CHAT_SYS_EX_USER_TO_FANS_GROUP_ERROR.getCode());
//        }

        EaseMobUserInfoDo userInfoDo = easeMobUserInfoManager.findEaseMobUserInfoBySysUniId(sysUinId);

        if(userInfoDo == null){
            throw new ChatSysException(
                    ChatSysExceptionEnums.CHAT_SYS_EX_EASE_MOB_FIND_USER_ERROR.getCode());
        }
    }
}
