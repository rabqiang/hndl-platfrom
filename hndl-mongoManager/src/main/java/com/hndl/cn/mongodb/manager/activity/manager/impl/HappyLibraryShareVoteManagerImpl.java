package com.hndl.cn.mongodb.manager.activity.manager.impl;

import com.hndl.cn.mongodb.manager.activity.bean.HappyLibraryShareVoteDo;
import com.hndl.cn.mongodb.manager.activity.manager.HappyLibraryShareVoteManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 13:54
 * @Created by 湖南达联
 */
@Service
public class HappyLibraryShareVoteManagerImpl implements HappyLibraryShareVoteManager {


    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertHappyLibraryShareVote(HappyLibraryShareVoteDo happyLibraryShareVoteDo) {
         happyLibraryShareVoteDo.setVoteCount(0L);
         mongoDbService.insert(happyLibraryShareVoteDo);
    }

    @Override
    public HappyLibraryShareVoteDo findHappyLibraryShareVoteByVersionDesc() {
        Query query =  new Query();
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "version")));
        return mongoDbService.findOne(query,HappyLibraryShareVoteDo.class);
    }

    @Override
    public List<HappyLibraryShareVoteDo> findHappyLibraryShareVoteByVoteCountDesc(Integer version) {
        Query query = new Query(Criteria.where("version").is(version));
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "voteCount")));
        return mongoDbService.findAll(query,HappyLibraryShareVoteDo.class);
    }

    @Override
    public HappyLibraryShareVoteDo findHappyLibraryShareVoteByGroupId(Long groupId) {
        Query query = new Query(Criteria.where("groupId").is(groupId));
        return mongoDbService.findOne(query,HappyLibraryShareVoteDo.class);
    }

    @Override
    public void increaseVoteCount(Integer version,Long groupId,Long voteCount) {
        Criteria criteria = Criteria.where("version").is(version).and("groupId").is(groupId);
        Query query = new Query(criteria);
        Update update = new Update();
        update.inc("voteCount",voteCount);
        mongoDbService.inc(query,update,HappyLibraryShareVoteDo.class);
    }

    @Override
    public void updateGroupNameAndFaceImg(HappyLibraryShareVoteDo happyLibraryShareVoteDo) {
        Criteria criteria = Criteria.where("groupId").is(happyLibraryShareVoteDo.getGroupId());
        Query query = new Query(criteria);
        mongoDbService.update(query,happyLibraryShareVoteDo,HappyLibraryShareVoteDo.class);
    }
}
