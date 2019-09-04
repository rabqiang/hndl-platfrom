package com.hndl.cn.mghd.sys.business.message.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.message.vo.ReUserMessageVo;
import com.hndl.cn.mghd.sys.business.message.vo.UserMessageVo;
import com.hndl.cn.mghd.sys.business.message.vo.UserMsgVo;

/**
 * @author 尹争鸣
 * @Description 用户消息
 * @Date 2019年5月22日13:52:46
 * @Created by 湖南达联
 */
public interface UserMessageService {


    /**
     * 查询用户消息
     */
    Result<Object> findBySendUserIdMsg(CommonUserInfoDo commonUserInfoDo, Integer messageType,String id);

    /**
     * 根据SendUserId查询用户消息
     */
    ReUserMessageVo findBySendUserId( Long sendUserId, Integer messageType,String id);



    /**
     * 插入用户消息
     */
    void insertUserMessage(UserMessageVo userMessageVo);


    /**
     * 插入用户消息关系
     */
    void insertUserRelation(CommonUserInfoDo commonUserInfoDo, String messageId, Integer messageType);




    /**
     *  获取三种消息以及未读数
     * */

    UserMsgVo findAllMessage(CommonUserInfoDo commonUserInfoDo);



}
