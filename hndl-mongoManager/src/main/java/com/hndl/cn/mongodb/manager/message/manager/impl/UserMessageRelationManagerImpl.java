package com.hndl.cn.mongodb.manager.message.manager.impl;

import com.hndl.cn.mongodb.manager.message.bean.UserMessageRelationDo;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageRelationManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description 用户消息关系
 * @Date 2019年5月22日13:52:46
 * @Created by 湖南达联
 */
@Service
public class UserMessageRelationManagerImpl implements UserMessageRelationManager {

    @Resource
    private MongoDbService mongoDbService;

    /**
     * 存入
     */
    @Override
    public void insertUserMessageRelation(UserMessageRelationDo userMessageRelationDo) {
        mongoDbService.insert(userMessageRelationDo);
    }


    /**
     * 统计条数
     */
    public int countByMesRelationId(String mesRelationId) {

        Query query = new Query(Criteria.where("mesRelationId").is(mesRelationId));

        return (int) mongoDbService.count(query, UserMessageRelationDo.class);
    }

    @Override
    public void saveAllMsgRelation(List<UserMessageRelationDo> userMessageRelationDos) {
        mongoDbService.insertAll(userMessageRelationDos);
    }
}
