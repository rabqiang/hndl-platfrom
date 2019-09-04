package com.hndl.cn.mongodb.manager.message.manager;

import com.hndl.cn.mongodb.manager.message.bean.UserMessageRelationDo;

import java.util.List;

/**
 * @author 尹争鸣
 * @Description  用户消息关系
 * @Date 2019年5月22日13:52:46
 * @Created by 湖南达联
 */
public interface UserMessageRelationManager {

    /**
     * 插入消息关系
     * */
    void  insertUserMessageRelation(UserMessageRelationDo userMessageRelationDo);


    /**
     * 统计条数
     * */
    int  countByMesRelationId(String mesRelationId);


    void saveAllMsgRelation(List<UserMessageRelationDo> userMessageRelationDos);

}
