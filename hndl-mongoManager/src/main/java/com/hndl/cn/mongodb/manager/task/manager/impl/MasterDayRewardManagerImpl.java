package com.hndl.cn.mongodb.manager.task.manager.impl;

import com.hndl.cn.mongodb.manager.task.bean.MasterDayReward;
import com.hndl.cn.mongodb.manager.task.manager.MasterDayRewardManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/7 16:26
 * @Created by 湖南达联
 */
@Service
public class MasterDayRewardManagerImpl implements MasterDayRewardManager {

    @Resource
    private MongoDbService mongoDbService;


    @Override
    public void userDelete() {
        mongoDbService.delete(new Query(),MasterDayReward.class);
    }

    @Override
    public void insert(MasterDayReward masterDayReward) {
        mongoDbService.insert(masterDayReward);
    }

    @Override
    public boolean isExist(Long masterId, Long slaveId) {
        Criteria criteria = Criteria.where("masterId").is(masterId)
                .and("slaveId").is(slaveId).and("createTime")
                .is(LocalDateUtil.localDateToMilliSecond(LocalDate.now()));

        Query query = new Query(criteria);

        return mongoDbService.count(query, MasterDayReward.class) > 0;
    }

    @Override
    public List<MasterDayReward> findByDate(LocalDate localDate, String id,Integer limit) {
        Criteria criteria = Criteria.where("createTime")
                .is(LocalDateUtil.localDateToMilliSecond(localDate));
        if (StringUtils.isNotEmpty(id)) {
            criteria.and("_id").gt(new ObjectId(id));
        }
        Query query = new Query(criteria);
        query.limit(limit);
        query.with(Sort.by(Sort.Direction.ASC, "_id"));
        return mongoDbService.findAll(query, MasterDayReward.class);
    }


    @Override
    public List<MasterDayReward> findDaySlaveIdByMasterId(LocalDate localDate, Long masterId) {
        Criteria criteria = Criteria.where("createTime")
                .is(LocalDateUtil.localDateToMilliSecond(localDate)).and("masterId").is(masterId);

        Query query = new Query(criteria);

        return mongoDbService.findAll(query, MasterDayReward.class);
    }

    @Override
    public List<MasterDayReward> findSlaveIdByMasterId(Long masterId) {
        Criteria criteria = Criteria.where("masterId").is(masterId);
        Query query = new Query(criteria);

        return mongoDbService.findAll(query, MasterDayReward.class);
    }
}
