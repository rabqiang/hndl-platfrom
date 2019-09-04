package com.hndl.cn.mongodb.manager.message.manager;

import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;

import java.util.List;

/**
 * @author 尹争鸣
 * @Description  用户消息
 * @Date 2019年5月22日13:52:46
 * @Created by 湖南达联
 */
public interface UserMessageManager {

    /**
     * 插入消息
     * */
    void insertUserMessageDo(UserMessageDo userMessageDo);

    /**
     * 根据SendUserId查询消息
     * */
    List<UserMessageDo> findBySendUserId(Long sendUserId ,Integer messageType,String id);


    /**
     * 统计条数
     * */
    int countBySendUserId(Long sendUserId ,Integer messageType);


    /**
     *  修改
     * */
    void updateByMessageId(UserMessageDo userMessageDo);


    /**
     * 根据条件查询
     * */

    List<UserMessageDo> findByUserMessage(UserMessageDo userMessageDo,Integer messageType, Long messageId,Integer limit);

    /**
     *  查询用户最新的一条消息
     * */

    UserMessageDo findBySysUniIdAndMessageType(Long sysUniId,Integer messageType);


    /**
     *  统计未读条数
     * */
    long countUnReadMsg(Long sendUserId,Long messageId,Integer messageType);

    /**
     *  根据接收人ID  消息类别 创建时间 查询一条消息
     */
   UserMessageDo selectBySendUserIdAndTimeAndType(Long sendUserId, Long createTime , Integer messageType);




}
