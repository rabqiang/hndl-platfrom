package com.hndl.cn.chat.sys.business.room.service.impl;

import com.hndl.cn.base.lock.RedisLockKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestRoomParam;
import com.hndl.cn.chat.sys.business.maesmob.service.EaseMobChatRoomService;
import com.hndl.cn.chat.sys.business.room.service.SysChatRoomService;
import com.hndl.cn.chat.sys.common.constants.ChatSysConstants;
import com.hndl.cn.chat.sys.easemob.OrgInfoConfig;
import com.hndl.cn.chat.sys.exception.ChatSysException;
import com.hndl.cn.chat.sys.exception.ChatSysExceptionEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobFansGroupChatRoomDo;
import com.hndl.cn.mongodb.manager.easemob.manager.EaseMobFansGroupChatRoomManager;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 9:31
 * @Created by 湖南达联
 */
@Service
public class SysChatRoomServiceImpl implements SysChatRoomService {

    private static final Logger log = LoggerFactory.getLogger(SysChatRoomServiceImpl.class);

    @Resource
    private EaseMobFansGroupChatRoomManager easeMobFansGroupChatRoomManager;


    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private StarFansGroupRelationManager starFansGroupRelationManager;

    @Resource
    private EaseMobChatRoomService easeMobChatRoomService;


    @Resource
    private RedisService redisService;

    @Resource
    private OrgInfoConfig orgInfoConfig;



    @Override
    public Result<Object> addFansGroupChatRoomOrUserToRoom(CommonUserInfoDo commonUserInfoDo, Long fansGroupId) {
        String roomId = null;

        //判断用户是否加入粉丝会
        StarFansGroupRelationDo starFansGroupRelation = starFansGroupRelationManager.
                findStarFansGroupRelation(commonUserInfoDo.getSysUniId(), fansGroupId);

        if(starFansGroupRelation == null){
            throw new ChatSysException(
                    ChatSysExceptionEnums.CHAT_SYS_EX_USER_TO_FANS_GROUP_ERROR.getCode());
        }

        //判断粉丝会是否创建聊天室
        EaseMobFansGroupChatRoomDo roomDo =  easeMobFansGroupChatRoomManager.findGroupChatRoomByFansGroupId(fansGroupId);

        if(roomDo == null){

            //查询粉丝会 这里需要加锁
            StarFansGroupDo starFansGroup = starFansGroupManager.findStarFansGroup(fansGroupId);

            if(starFansGroup == null){
                throw new ChatSysException(
                        ChatSysExceptionEnums.CHAT_SYS_EX_FANS_GROUP_NOT_FIND_ERROR.getCode());
            }

            String lockKey = RedisLockKey.builderRedisKey(ChatSysConstants.INIT_CHAT_ROOM_REDIS_PACKAGE_NAME,starFansGroup.getStarId());


            boolean exists = redisService.exists(lockKey);
            log.info("锁是否存在:"+exists+"  lockKey:" + lockKey);
            if(exists){
                throw new ChatSysException(
                        ChatSysExceptionEnums.CHAT_SYS_EX_EASE_MOB_CREATE_RUN_TIME_ROOM_ERROR.getCode());
            }
            //加锁,因为redis是单线程的，如果失败，则是因为这个锁已经存在
            boolean nxFlag = false;
            try{

                nxFlag =  redisService.setNX(lockKey,RedisLockKey.DEFAULT_VALUE,ChatSysConstants.INIT_CHAT_ROOM_REDIS_TIME_OUT);
                log.info("是否成功获取到锁:"+nxFlag+"  lockKey:" + lockKey);
                  if(!nxFlag){
                        throw new ChatSysException(ChatSysExceptionEnums.CHAT_SYS_EX_EASE_MOB_CREATE_RUN_TIME_ROOM_ERROR.getCode());
                   }

                //构造聊天室参数
                EaesMobRequestRoomParam requestRoomParam = EaesMobRequestRoomParam.builder().name(starFansGroup.getStarName())
                        .description(starFansGroup.getStarDescription()).owner(orgInfoConfig.getRoomMasterId()).maxusers(ChatSysConstants.ROOM_MAX_NUMBER).build();

                //创建聊天室
                roomId = easeMobChatRoomService.createChatRoom(requestRoomParam);

                //构造聊天室参数
                EaseMobFansGroupChatRoomDo fansGroupChatRoomDo =  EaseMobFansGroupChatRoomDo.builder().
                        chatRoomId(roomId).fansGroupId(fansGroupId)
                        .roomMaster(orgInfoConfig.getRoomMasterId()).build();

                //保存聊天室信息
                easeMobFansGroupChatRoomManager.insertFansGroupChatRoom(fansGroupChatRoomDo);

//                EaseMobUserInfoDo easeMobUserInfoDo = easeMobUserInfoManager.findEaseMobUserInfoBySysUniId(commonUserInfoDo.getSysUniId());

                //加入聊天室,可以异步
//                easeMobChatRoomService.addSingleUserToChatRoom(roomId,easeMobUserInfoDo.getEaseMobUserName());

//                this.insertUserIsToRoomMapping(roomId,commonUserInfoDo.getSysUniId());
            }finally {
                //删除锁
                if(nxFlag){
                    boolean isDelNX = redisService.delNX(lockKey);
                    log.info("是否成功删除锁:"+ isDelNX + "  lockKey : " + lockKey);
                }
            }

        }else {
            roomId = roomDo.getChatRoomId();
            log.info(" room_id : "+ roomDo.getChatRoomId());
        }
        return ResultFactory.success(roomId);
    }


//    /**
//     * 加入关联关系
//     * @param roomId
//     * @param sysUniId
//     */
//    private void insertUserIsToRoomMapping(String roomId,Long sysUniId){
//        //建立关联关系,可以异步
//        UserIsToRoomInfoDo roomInfoDo = UserIsToRoomInfoDo.builder().chatRoomId(roomId)
//                .sysUniUserId(sysUniId).build();
//        userIsToRoomInfoManager.insertUserIsToRoomMapping(roomInfoDo);
//
//    }


}
