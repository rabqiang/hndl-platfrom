package com.hndl.cn.mongodb.manager.activity.manager.impl;

import com.hndl.cn.mongodb.manager.activity.bean.HappyLibraryUserVoteDo;
import com.hndl.cn.mongodb.manager.activity.manager.HappyLibraryUserVoteManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 15:42
 * @Created by 湖南达联
 */
@Service
public class HappyLibraryUserVoteManagerImpl implements HappyLibraryUserVoteManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertHappyLibraryUserVote(HappyLibraryUserVoteDo happyLibraryUserVoteDo) {
        happyLibraryUserVoteDo.setVoteTime(LocalDateTimeUtil.getNowMinTimeMilli());
        mongoDbService.insert(happyLibraryUserVoteDo);
    }

    @Override
    public Long countHappyLibraryUserVoteByNowTime(Long userId) {
        Criteria criteria = Criteria.where("sysUniId").is(userId).and("voteTime").is(LocalDateTimeUtil.getNowMinTimeMilli());
        return mongoDbService.count(new Query(criteria),HappyLibraryUserVoteDo.class);
    }
}
