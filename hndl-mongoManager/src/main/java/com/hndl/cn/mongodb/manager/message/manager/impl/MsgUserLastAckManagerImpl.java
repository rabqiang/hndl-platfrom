package com.hndl.cn.mongodb.manager.message.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.mongodb.manager.message.bean.MsgUserLastAckDo;
import com.hndl.cn.mongodb.manager.message.manager.MsgUserLastAckManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date
 * @Created by 湖南达联
 */

@Service
public class MsgUserLastAckManagerImpl implements MsgUserLastAckManager {


    @Resource
    private MongoDbService mongoDbService;

    @Override
    public MsgUserLastAckDo findMsgUserLastAck(Long sysUniId, Integer messageType) {

        Query query = new Query(Criteria.where("sysUniId").is(sysUniId).and("messageType").is(messageType));

        return mongoDbService.findOne(query, MsgUserLastAckDo.class);
    }


    @Override
    public void upsertMegUserLastAck(MsgUserLastAckDo msgUserLastAckDo) {
        Query query = new Query(Criteria.where("sysUniId").is(msgUserLastAckDo.getSysUniId()).and("messageType").is(msgUserLastAckDo.getMessageType()));
        query.limit(BaseConstants.UPDATE_MIN_LIMIT);
        mongoDbService.upsert(query, msgUserLastAckDo, MsgUserLastAckDo.class);
    }

    @Override
    public long countByHaveReadMessageId(Long haveReadMessageId) {

        Query query = new Query(Criteria.where("haveReadMessageId").is(haveReadMessageId));
        return mongoDbService.count(query, MsgUserLastAckDo.class);
    }
}
