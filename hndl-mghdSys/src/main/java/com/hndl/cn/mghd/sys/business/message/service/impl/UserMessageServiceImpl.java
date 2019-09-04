package com.hndl.cn.mghd.sys.business.message.service.impl;


import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.message.service.UserMessageService;
import com.hndl.cn.mghd.sys.business.message.vo.ReUserMessageVo;
import com.hndl.cn.mghd.sys.business.message.vo.UserMessageVo;
import com.hndl.cn.mghd.sys.business.message.vo.UserMsgVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mongodb.manager.message.bean.MsgUserLastAckDo;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageRelationDo;
import com.hndl.cn.mongodb.manager.message.manager.MsgUserLastAckManager;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageManager;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageRelationManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.page.PageUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description 用户消息
 * @Date 2019年5月22日13:52:46
 * @Created by 湖南达联
 */
@Service
public class UserMessageServiceImpl implements UserMessageService {

    @Resource
    private UserMessageManager userMessageManager;

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private UserMessageRelationManager userMessageRelationManager;

    @Resource
    private MsgUserLastAckManager msgUserLastAckManager;


    @Override
    public void insertUserMessage(UserMessageVo userMessageVo) {
        UserMessageDo userMessageDo = SpringCglibBeanUtils.convert(userMessageVo, UserMessageDo.class);
        userMessageManager.insertUserMessageDo(userMessageDo);
    }

    @Override
    public Result<Object> findBySendUserIdMsg(CommonUserInfoDo commonUserInfoDo, Integer messageType, String id) {

        return ResultFactory.success(this.findBySendUserId(commonUserInfoDo.getSysUniId(), messageType, id));
    }

    @Override
    public ReUserMessageVo findBySendUserId(Long sendUserId, Integer messageType, String id) {

        if (id != null && !PageUtils.checkMongoDbObjId(id)) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        List<UserMessageDo> userMessageDoList = userMessageManager.findBySendUserId(sendUserId, messageType, id);
        if (CollectionUtils.isEmpty(userMessageDoList)) {
            return null;
        }
        List<UserMessageVo> userMessageVoList = SpringCglibBeanUtils.convertByList(userMessageDoList,UserMessageVo.class);

        for (int i=0;i<userMessageVoList.size();i++){
            userMessageVoList.get(i).setState(1);
        }

        ReUserMessageVo reuserMessageVo = new ReUserMessageVo();
        reuserMessageVo.setUserMessageVoList(userMessageVoList);

        reuserMessageVo.setCount((int)this.findMsgCount(sendUserId, messageType));

        //更新已读消息ID游标
        UserMessageVo userMessageVo = userMessageVoList.get(0);

        if (msgUserLastAckManager.countByHaveReadMessageId(userMessageVo.getMessageId()) == 0) {
            MsgUserLastAckDo msgUserLastAckDo = new MsgUserLastAckDo();
            msgUserLastAckDo.setSysUniId(sendUserId);
            msgUserLastAckDo.setMessageType(messageType);
            msgUserLastAckDo.setHaveReadMessageId(userMessageVo.getMessageId());
            msgUserLastAckManager.upsertMegUserLastAck(msgUserLastAckDo);
        }
        return reuserMessageVo != null ? reuserMessageVo : null;


    }

    @Override
    @SubmitLock(keys="messageId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public void insertUserRelation(CommonUserInfoDo commonUserInfoDo, String messageId, Integer messageType) {

        if (userMessageRelationManager.countByMesRelationId(this.toMesRelationId(commonUserInfoDo.getSysUniId().toString(), messageId)) == 0) {
            UserMessageRelationDo userMessageRelationDo = new UserMessageRelationDo();
            userMessageRelationDo.setMesRelationId(toMesRelationId(commonUserInfoDo.getSysUniId().toString(), messageId));
            userMessageRelationDo.setMessageType(messageType);
            userMessageRelationManager.insertUserMessageRelation(userMessageRelationDo);
        }

    }


    @Override
    public UserMsgVo findAllMessage(CommonUserInfoDo commonUserInfoDo) {


        UserMsgVo userMsgVo = new UserMsgVo();
        //获取每个类别的最新一条消息
        userMsgVo.setSysMsg(SpringCglibBeanUtils.convert(userMessageManager.findBySysUniIdAndMessageType(commonUserInfoDo.getSysUniId(), MessageTypeEnums.SYS_MSG.getType()), UserMessageVo.class));
        userMsgVo.setLikeMsg(SpringCglibBeanUtils.convert(userMessageManager.findBySysUniIdAndMessageType(commonUserInfoDo.getSysUniId(), MessageTypeEnums.LIKE_MSG.getType()), UserMessageVo.class));
        userMsgVo.setCommentMsg(SpringCglibBeanUtils.convert(userMessageManager.findBySysUniIdAndMessageType(commonUserInfoDo.getSysUniId(), MessageTypeEnums.COMMENT_MSG.getType()), UserMessageVo.class));
        //获取未读条数
        userMsgVo.setSysCount(this.findMsgCount(commonUserInfoDo.getSysUniId(), MessageTypeEnums.SYS_MSG.getType()));
        userMsgVo.setLikeCount(this.findMsgCount(commonUserInfoDo.getSysUniId(), MessageTypeEnums.LIKE_MSG.getType()));
        userMsgVo.setCommentCount(this.findMsgCount(commonUserInfoDo.getSysUniId(), MessageTypeEnums.COMMENT_MSG.getType()));
        userMsgVo.setCount(userMsgVo.getSysCount() + userMsgVo.getLikeCount() + userMsgVo.getCommentCount());


        return userMsgVo;
    }

    public String toMesRelationId(String sysUniId, String messageId) {

        return String.format("%s_%s", sysUniId, messageId);
    }


    public int toUnreadMessage(int messageSum, int messageRelationSum) {
        return messageSum - messageRelationSum;
    }

    //获取未读消息数
    public long findMsgCount(Long sendUserId, Integer messageType) {

        MsgUserLastAckDo msgUserLastAck = msgUserLastAckManager.findMsgUserLastAck(sendUserId, messageType);

        Long haveRead = null;

        if (null != msgUserLastAck) {
            haveRead = msgUserLastAck.getHaveReadMessageId();
        }
        return userMessageManager.countUnReadMsg(sendUserId, haveRead, messageType);
    }

}
