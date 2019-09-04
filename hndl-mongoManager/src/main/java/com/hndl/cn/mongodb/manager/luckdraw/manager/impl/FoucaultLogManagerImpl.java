package com.hndl.cn.mongodb.manager.luckdraw.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.FoucaultLogDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.FoucaultLogManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 福卡日志
 * @author: 易成贤
 * @create: 2019/7/22 17:21
 * @Created by湖南达联
 **/
@Service
@Slf4j
public class FoucaultLogManagerImpl implements FoucaultLogManager {

    @Resource
    MongoDbService mongoDbService;
    /**
     * 插入一条福卡记录
     *
     * @param userUniId
     * @param taskType
     * @param isIncome
     * @param foucaultCount
     */
    @Override
    public void insertFoucaultLog(Long userUniId, FoucaultGetTypeEnums taskType, IsValidEnums isIncome, Integer foucaultCount) {
        FoucaultLogDo build = FoucaultLogDo.builder()
                .createTime(System.currentTimeMillis())
                .userUniId(userUniId)
                .isIncome(isIncome.getValue())
                .foucaultCount(foucaultCount)
                .isDelete(IsValidEnums.NO.getValue())
                .build();
        if (null != taskType) {
            build.setTaskType(taskType.getTaskType());
        }

        mongoDbService.insert(build);
    }

    @Override
    public void insertFoucaultLogs(Long userUniId, FoucaultGetTypeEnums taskType, IsValidEnums isIncome, Integer foucaultCount) {
        FoucaultLogDo build = FoucaultLogDo.builder()
                .createTime(System.currentTimeMillis())
                .userUniId(userUniId)
                .isIncome(isIncome.getValue())
                .foucaultCount(foucaultCount)
                .isDelete(IsValidEnums.NO.getValue())
                .build();
        if (null != taskType) {
            build.setTaskType(taskType.getTaskType());
        }

        mongoDbService.insert(build);
    }

    @Override
    public Integer findToDayCount(Long userUniId, FoucaultGetTypeEnums taskType, IsValidEnums isIncome) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("createTime")
                .gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
                .and("taskType").is(taskType.getTaskType()).and("isIncome").is(isIncome.getValue())
                .and("isDelete").is(IsValidEnums.NO.getValue());

        List<FoucaultLogDo> all = mongoDbService.findAll(new Query(criteria), FoucaultLogDo.class);

        if(CollectionUtils.isEmpty(all)){
            return 0;
        }
        return all.stream().filter(logDo -> logDo != null && logDo.getFoucaultCount() != null).mapToInt( logDo -> logDo.getFoucaultCount()).sum();
    }

    /**
     * 查询用户今天获取福卡的记录
     *
     * @param userUniId
     * @return
     */
    @Override
    public List<FoucaultLogDo> findToDayFoucaultLog( Long userUniId) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("isIncome").is(IsValidEnums.YES.getValue());
        return mongoDbService.findAll(new Query(criteria),FoucaultLogDo.class);
    }

    /**
     * 根据时间查询某个时间节点的抽奖人数
     * @param userUniId  用户UniId
     * @param starTime   开始时间
     * @param endTime   结束时间
     * @param isIncome   是支出吗? 支出1 \收入0
     * @return
     */
    @Override
    public  List<FoucaultLogDo> findToDateGetCount(Long userUniId,String id, Long starTime, Long endTime, IsValidEnums isIncome,Integer limit) {
        Criteria criteria = new Criteria();
        if (userUniId != null){
            criteria.and("userUniId").is(userUniId);
        }
        if (starTime != null && endTime != null){
            criteria.and("createTime").gte(starTime).lte(endTime);
        }
        if (isIncome != null){
            criteria .and("isIncome").is(isIncome.getValue());
        }
        if (id != null){
            criteria.and("_id").gt(new ObjectId(id));
        }
        //根据创建时间倒序
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        //加分页的页数
        Query query = new Query(criteria).with(sort);
        if (limit != null){
            query.limit(limit);
        }
        return mongoDbService.findAll(query,FoucaultLogDo.class);
    }

    @Override
    public List<FoucaultLogDo> findFoucaultLogByUserId(Long userUniId, Integer isIncome, String id, Integer limit) {
        Criteria criteria = new Criteria();
        if (id != null) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        criteria.and("userUniId").is(userUniId);
        criteria.and("isIncome").is(isIncome);
        criteria.and("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
        query.with(new Sort(Sort.Direction.DESC, "createTime"));
        if (null != limit && !limit.equals(0)) {
            query.limit(limit);
        }
        return mongoDbService.findAll(query, FoucaultLogDo.class);
    }

}
