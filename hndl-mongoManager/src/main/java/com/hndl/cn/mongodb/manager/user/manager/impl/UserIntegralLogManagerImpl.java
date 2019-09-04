package com.hndl.cn.mongodb.manager.user.manager.impl;


import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.number.LevelUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author 汪海
 * @Description TODO
 * @Date 2019/4/22  11:43
 * @Created by 湖南达联
 */
@Service
public class UserIntegralLogManagerImpl implements UserIntegralLogManager {
    @Resource
    private MongoDbService mongoDbService;

    @Resource
    private MongoTemplate mongoTemplate;


    @Override
    public void userDelete(Long userUniId, String time, UserDayEmpiricalTypeEnums s) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("getIntegralType").is(s.getTaskType());
        mongoDbService.delete(new Query(criteria), UserIntegralLogDo.class);
    }

    /**
     * 积分
     *
     * @param userUniId       用户id
     * @param IntegralCount   积分值
     * @param getIntegralType 积分类型
     * @param isValidEnums    1 收入还是 0 支出
     */
    @Override
    public void insertUserIntegralLog(Long userUniId,String objId, IsValidEnums isValidEnums, Integer getIntegralType, Integer IntegralCount) {
        UserIntegralLogDo aDo = new UserIntegralLogDo();
        aDo.setUserUniId(userUniId);
        aDo.setCreateTime(System.currentTimeMillis());
        aDo.setGetIntegralType(getIntegralType);
        aDo.setIsIncome(isValidEnums.getValue());
        aDo.setIntegralCount(IntegralCount);
        aDo.setIsDelete(IsValidEnums.NO.getValue());
        aDo.setObjId(objId);
        if (isValidEnums.getValue().equals(IsValidEnums.YES.getValue())){
            aDo.setDescription(UserDayEmpiricalTypeEnums.evalVal(getIntegralType).getDescription()+"奖励");
        } else {
            aDo.setDescription(UserDayEmpiricalTypeEnums.evalVal(getIntegralType).getDescription());
        }
        mongoDbService.insert(aDo);
    }
    /**
     * 积分
     *
     * @param userUniId       用户id
     * @param objId           消费对象
     * @param IntegralCount   积分值
     * @param getIntegralType 积分类型
     * @param isValidEnums    收入(一)还是 支出 (零)
     * @param description     获取积分描述
     */
    @Override
    public void insertUserIntegralLog(Long userUniId, String objId, IsValidEnums isValidEnums, Integer getIntegralType, Integer IntegralCount, String description) {
        UserIntegralLogDo aDo = new UserIntegralLogDo();
        aDo.setUserUniId(userUniId);
        aDo.setCreateTime(System.currentTimeMillis());
        aDo.setGetIntegralType(getIntegralType);
        aDo.setIsIncome(isValidEnums.getValue());
        aDo.setIntegralCount(IntegralCount);
        aDo.setIsDelete(IsValidEnums.NO.getValue());
        aDo.setObjId(objId);
        aDo.setDescription(description);
        mongoDbService.insert(aDo);
    }




    /**
     * 获取用户详细积分日志
     *
     * @param userUniId    用户id
     * @param isValidEnums 判断是收入(一)还是 支出 (零)
     * @param
     * @param
     * @return
     */
    @Override
    public List<UserIntegralLogDo> userIntegralLogAll(Long userUniId,Integer pageNo, IsValidEnums isValidEnums,  String id) {


        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue());
        if (userUniId != 0) {
            criteria.and("userUniId").is(userUniId);
        }
        if (isValidEnums != null)  {
            criteria.and("isIncome").is(isValidEnums.getValue());
        }

        if (StringUtils.isNotBlank(id)){
            criteria.lt(new ObjectId(id));
        }
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).with(sort);
        if (null != pageNo){
            //兼容旧版50条数据
            query.limit(50);
        }else {
            query.limit(BaseConstants.DEFAULT_LIMIT);
        }
        //将其设置倒序输出
        return mongoDbService.findAll(query, UserIntegralLogDo.class);
    }
    /**
     * 后台查询用户详细积分日志
     *
     * @param userUniId    用户id
     * @param isValidEnums 判断是收入(一)还是 支出 (零)
     * @param pageNo       从分页
     * @param pageSize     分页大小
     * @return
     */
    @Override
    public List<UserIntegralLogDo> userIntegralLogAll(Long userUniId, IsValidEnums isValidEnums, String pageNo, Integer pageSize) {
        //如果分页数大于零，那就直接查询所有
        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue());
        if (userUniId != 0) {
            criteria.and("userUniId").is(userUniId);
        }
        if (pageNo != null && pageNo != ""){
            criteria.and("_id").lt(new ObjectId(pageNo));
        }
        if (isValidEnums != null)  {
            criteria.and("isIncome").is(isValidEnums.getValue());
        }
        //实例化sort对象
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).with(sort).limit(pageSize);

        //将其设置倒序输出
        return mongoDbService.findAll(query, UserIntegralLogDo.class);
    }
    /**
     * 查询用户日常任务的积分值
     *
     * @param userUniId 用户id
     * @return
     */
    @Override
    public Long findYesterdayTeskUserAll(Long userUniId) {
        Long sum = 0L;
        //实例化Criteria
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("getIntegralType").is(UserDayEmpiricalTypeEnums.MENTOR_REWARD.getTaskType());

        Query query = new Query(criteria);
        List<UserIntegralLogDo> all = mongoDbService.findAll(query, UserIntegralLogDo.class);
        for (int i = 0; i < all.size(); i++) {
            sum += all.get(i).getIntegralCount();
        }
        return sum;
    }
    /**
     * 查询用户日常任务的积分值
     *
     * @param userUniId 用户id
     * @return
     */
    @Override
    public Long findTeskUserAll(Long userUniId,UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums) {
        Long sum = 0L;
        //实例化Criteria
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("getIntegralType").is(userDayEmpiricalTypeEnums.getTaskType());
        Query query = new Query(criteria);
        List<UserIntegralLogDo> all = mongoDbService.findAll(query, UserIntegralLogDo.class);
        for (int i = 0; i < all.size(); i++) {
            sum += all.get(i).getIntegralCount();
        }
        return sum;
    }
    /**
     * 根据时间查询用户的为明星打榜的积分纪录
     *
     * @param userUniId
     * @param isValidEnums              是支出还是收入
     * @param userDayEmpiricalTypeEnums 积分类型
     * @return
     */
    @Override
    public UserIntegralLogDo findUserInategralOne(Long userUniId, IsValidEnums isValidEnums, UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("isIncome").is(isValidEnums.getValue())
                .and("getIntegralType").is(userDayEmpiricalTypeEnums.getTaskType());
        //将其倒序输出
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).with(sort);
        return mongoDbService.findOne(query, UserIntegralLogDo.class);
    }
    /**
     * 根据用户经验值获取用户可获取的积分
     * @param integral   用户当前应该获取的积分数
     * @param empirical  用户经验值
     * @return
     */
    @Override
    public Long getUserIntegral(Long empirical, Integer integral) {
        int contributionLevel = LevelUtil.getContributionLevel(empirical.intValue());
        Double coefficient = LevelUtil.getContributionlevelCoefficient(contributionLevel);
        Float sum = (float) integral * coefficient.floatValue();
        return sum.longValue();
    }

    @Override
    public Long getIntegralInfo(Long userId, IsValidEnums isValidEnums) {
        Long sum = 0L;
        List<UserIntegralLogDo> all = mongoDbService.findAll(new Query(Criteria.where("userUniId").is(userId).and("isIncome").is(isValidEnums.getValue())), UserIntegralLogDo.class);
        for (UserIntegralLogDo userIntegralLogDo : all) {
            sum += userIntegralLogDo.getIntegralCount();
        }

        return sum;
    }

    @Override
    public List<UserIntegralLogDo> findRecordByStarId(Long startDate, Long endDate, String objId) {
        Criteria criteria = Criteria.where("objId").is(objId)
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("createTime").gte(startDate).lte(endDate);
        Query query = new Query(criteria);
        return mongoDbService.findAll(query, UserIntegralLogDo.class);
    }

    @Override
    public List<UserIntegralLogDo> findRecordByDate(Long startDate, Long endDate) {
        Criteria criteria = Criteria.where("isDelete")
                .is(IsValidEnums.NO.getValue())
                .and("createTime").gte(startDate).lte(endDate)
                .and("isIncome").is(IsValidEnums.NO.getValue())
                .and("getIntegralType").is(2);
        Query query = new Query(criteria);
        return mongoDbService.findAll(query, UserIntegralLogDo.class);
    }

    @Override
    public List<UserIntegralLogDo> findRecordByDate(Long startDate, Long endDate, Long userUniId,UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums, IsValidEnums isValidEnums) {
        Criteria criteria = Criteria.where("isDelete")
                .is(IsValidEnums.NO.getValue())
                .and("userUniId").is(userUniId)
                .and("createTime").gt(startDate).lte(endDate)
                .and("isIncome").is(isValidEnums.getValue())
                .and("getIntegralType").is(userDayEmpiricalTypeEnums.getTaskType());
        Query query = new Query(criteria);
        return mongoDbService.findAll(query, UserIntegralLogDo.class);
    }

    @Override
    public Long findIntegralCountByStarId (Long startDate, Long endDate, String objId) {
        Criteria criteria = new Criteria();
        //>=开始时间 ; <= 结束时间;
        criteria.and("createTime").gte(startDate).lte(endDate);
        criteria.and("objId").is(objId);
        criteria.and("isIncome").is(IsValidEnums.NO.getValue());
        // if条件判断完后, 把criteria传进match函数里(因为在match里是无法ifnull的)
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(criteria)
                , Aggregation.group("objId").sum("IntegralCount").as("totalIntegral")
        );
        AggregationResults<Map> results = mongoTemplate.aggregate(agg, "business_user_integral_log", Map.class);
        Long totalIntegral = 0L;
        // 得到结果
        List<Map> mappedResults = results.getMappedResults();
        if (CollectionUtils.isNotEmpty(mappedResults)) {
            Object obj  = mappedResults.get(0).get("totalIntegral");
            totalIntegral = (obj == null ? 0L : Long.valueOf(obj.toString()));
        }
        return totalIntegral;
    }

    @Override
    public Long findIntegralCountAll(Long startDate, Long endDate) {
        Criteria criteria = new Criteria();
        //>=开始时间 ; <= 结束时间;
        criteria.and("createTime").gte(startDate).lte(endDate);
        criteria.and("isIncome").is(IsValidEnums.NO.getValue());
        // if条件判断完后, 把criteria传进match函数里(因为在match里是无法ifnull的)
        Aggregation agg = Aggregation.newAggregation(
                Aggregation.match(criteria)
                , Aggregation.group("isIncome").sum("IntegralCount").as("totalIntegral")
        );
        AggregationResults<Map> results = mongoTemplate.aggregate(agg, "business_user_integral_log", Map.class);
        Long totalIntegral = 0L;
        // 得到结果
        List<Map> mappedResults = results.getMappedResults();
        if (CollectionUtils.isNotEmpty(mappedResults)) {
            Object obj  = mappedResults.get(0).get("totalIntegral");
            totalIntegral = (obj == null ? 0L : Long.valueOf(obj.toString()));
        }
        return totalIntegral;
    }


}
