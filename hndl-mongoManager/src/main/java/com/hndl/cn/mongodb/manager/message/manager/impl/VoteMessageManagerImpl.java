package com.hndl.cn.mongodb.manager.message.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.mongodb.manager.message.bean.VoteMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.VoteMessageManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class VoteMessageManagerImpl implements VoteMessageManager {


    @Resource
    private MongoDbService mongoDbService;


    public List<VoteMessageDo> findByCreateTime(Long createTime) {
        Query query = null;

        if (createTime == null) {
            query = new Query();
        } else {
            query = new Query(Criteria.where("createTime").lt(createTime));
        }

        query.with(new Sort(Sort.Direction.DESC, "createTime"));
        query.limit(BaseConstants.BARRAGE_MSG_DEFAULT_LIMIT);

        return mongoDbService.findAll(query, VoteMessageDo.class);
    }


    public void insertVoteMessageDo(Long starId, String msgContent) {
        VoteMessageDo voteMessageDo = new VoteMessageDo();
        voteMessageDo.setMsgContent(msgContent);
        voteMessageDo.setCreateTime(System.currentTimeMillis());
        voteMessageDo.setStarId(starId);
        mongoDbService.insert(voteMessageDo);
    }

    @Override
    public void delVoteMessageLtId(String id) {

        Criteria criteria = Criteria.where("_id").lt(new ObjectId(id));

        mongoDbService.delete(new Query(criteria), VoteMessageDo.class);
    }

    @Override
    public VoteMessageDo findVoteMessage() {
        Criteria criteria = new Criteria();
        Query query = new Query(criteria);
        query.with(new Sort(Sort.Direction.DESC, "createTime"));
        //查询第200条
        query.skip(BaseConstants.BARRAGE_MSG_MAX_LIMIT);

        return mongoDbService.findOne(query, VoteMessageDo.class);
    }
}
