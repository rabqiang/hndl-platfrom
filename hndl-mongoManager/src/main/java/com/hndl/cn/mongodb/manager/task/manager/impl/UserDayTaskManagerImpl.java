package com.hndl.cn.mongodb.manager.task.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.mongodb.manager.task.bean.UserDayTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** @author 汪海 @Description TODO @Date 2019/4/22 0022 14:29 @Created by 湖南达联 */
@Service
public class UserDayTaskManagerImpl implements UserDayTaskManager {

  @Resource
  private MongoDbService mongoDbService;

  @Resource
  private MongoTemplate mongoTemplate;

  @Override
  public void insert(Long userUniId, Long starId, UserDayTaskEnums userDayTaskEnums) {
    Assert.notNull(userUniId, "userUniId must not be null!");
    Assert.notNull(starId, "starId must not be null!");
    UserDayTaskDo userDayTaskDo = new UserDayTaskDo();
    userDayTaskDo.setCreateTime(System.currentTimeMillis());
    userDayTaskDo.setIsDelete(IsValidEnums.NO.getValue());
    userDayTaskDo.setUserUniId(userUniId);
    userDayTaskDo.setStarId(starId);
    userDayTaskDo.setTaskType(userDayTaskEnums.getTaskType());
    mongoDbService.insert(userDayTaskDo);
  }

  /**
   *
   * @param userUniId
   * @param userDayTaskEnums
   * @return
   */
  @Override
  public Long countToDayTask(Long userUniId, UserDayTaskEnums userDayTaskEnums) {
    Criteria criteria = Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("userUniId").is(userUniId)
            .and("taskType").is(userDayTaskEnums.getTaskType());

    return mongoDbService.count(new Query(criteria), UserDayTaskDo.class);
  }

  /**
   *
   * @param userUniId
   * @return
   */
  @Override
  public List<UserDayTaskDo> findToDayTaskByUserUniId(Long userUniId) {
    Criteria criteria =
        Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("userUniId").is(userUniId);
    Query query = new Query(criteria);

    return mongoDbService.findAll(query, UserDayTaskDo.class);
  }

  /**
   * 查询用户指定任务记录
   *
   * @param userUniId
   * @param userDayTaskEnums
   * @return
   */
  @Override
  public List<UserDayTaskDo> findTaskByUserUniIdAndTaskType(Long userUniId, UserDayTaskEnums userDayTaskEnums) {
    Criteria criteria = Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("userUniId").is(userUniId)
            .and("taskType").is(userDayTaskEnums.getTaskType());
    Query query = new Query(criteria);

    return mongoDbService.findAll(query, UserDayTaskDo.class);
  }

  @Override
  public boolean toDayCanGetByUserUniId(Long userUniId, UserDayTaskEnums userDayTaskEnums) {
    Criteria criteria =
        Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("userUniId").is(userUniId)
            .and("taskType").is(userDayTaskEnums.getTaskType())
            .and("isDelete").is(IsValidEnums.NO.getValue());

    Query query = new Query(criteria);
    long count = mongoDbService.count(query, UserDayTaskDo.class);
    // 是否大于0，>0说明有任务完成
    return count > BaseConstants.STARTING_LONG_VALUE;
  }

  /**
   * @param userUniId
   * @param userDayTaskEnums
   * @return
   */
  @Override
  public boolean toDayIsCompleteByUserUniId(Long userUniId, UserDayTaskEnums userDayTaskEnums) {
    Criteria criteria =
        Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("userUniId").is(userUniId)
            .and("taskType").is(userDayTaskEnums.getTaskType());
    Query query = new Query(criteria);

    return mongoDbService.count(query, UserDayTaskDo.class) >= userDayTaskEnums.getDayCount();
  }

  /**
   * 领取每日奖励
   *
   * @param sysUniId
   * @param
   * @param userDayTaskEnums
   */
  @Override
  public boolean updateIsDelete(Long sysUniId, UserDayTaskEnums userDayTaskEnums) {
    Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue())
            .and("userUniId").is(sysUniId)
            .and("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("taskType").is(userDayTaskEnums.getTaskType());
    Map map = new HashMap<>(1);
    map.put("isDelete", IsValidEnums.YES.getValue());
    return mongoDbService.updateOne(new Query(criteria), map, UserDayTaskDo.class);
  }

  /**
   * 查询用户今天完成了多少此任务
   *
   * @param userUniId
   * @return
   */
  @Override
  public Long countToDayTaskByUserUniId(Long userUniId) {
    Criteria criteria =
        Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("userUniId").is(userUniId);
    Query query = new Query(criteria);
    return mongoDbService.count(query, UserDayTaskDo.class);
  }

  /**
   * 插入大量数据
   *
   * @param userDayTaskDos
   */
  @Override
  public void insertInBatch(List<UserDayTaskDo> userDayTaskDos) {
    mongoDbService.insertInBatch(userDayTaskDos, UserDayTaskDo.class);
  }

  /**
   * 查询用户昨天完成的任务的数据
   *
   * @param userUniId
   * @return
   */
  @Override
  public List<UserDayTaskDo> findToYesterdayTaskByUserUniId(Long userUniId) {
    Criteria criteria = Criteria.where("userUniId").is(userUniId)
            .and("createTime").gte(LocalDateTimeUtil.getYesterdayMinTimeMilli()).lte(LocalDateTimeUtil.getYesterdayMaxTimeMilli());
    Query query = new Query(criteria);

    return mongoDbService.findAll(query, UserDayTaskDo.class);
  }

  /**
   * 是否完成
   *
   * @param sysUniId
   * @param
   * @param userDayTaskEnums
   * @return
   */
  @Override
  public boolean toDayIsCompleteByUserUniIdAndStarId(
      Long sysUniId, UserDayTaskEnums userDayTaskEnums) {
    Criteria criteria =
        Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("userUniId").is(sysUniId)
            .and("taskType").is(userDayTaskEnums.getTaskType());

    Query query = new Query(criteria);
    return mongoDbService.count(query, UserDayTaskDo.class) < userDayTaskEnums.getDayCount();
  }

  /** 查询用户今日完成日常任务的次数,可获取的经验值 */
  @Override
  public boolean findUserDayTaskGetEmpirical(Long userUniId, UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums) {
    Criteria criteria =
        Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lte(LocalDateTimeUtil.getNowMaxTimeMilli())
            .and("userUniId").is(userUniId)
            .and("taskType").is(userDayEmpiricalTypeEnums.getTaskType());
    return mongoDbService.count(new Query(criteria), UserDayTaskDo.class)
        >= userDayEmpiricalTypeEnums.getDayCount();
  }

  @Override
  public UserDayTaskDo getUserLastLoginTime(Long userUniId) {
    Criteria criteria = Criteria.where("userUniId").is(userUniId)
            .and("taskType").is(UserDayEmpiricalTypeEnums.LOGIN_TASK.getTaskType());
    Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime")));
    return mongoDbService.findOne(query, UserDayTaskDo.class);

  }

  @Override
  public Long countTaskByStarId(UserDayTaskEnums userDayTaskEnums, Long starId, Long startDate, Long endDate) {
    Criteria criteria = new Criteria();
    criteria.and("starId").is(starId);
    if (null != startDate & null != endDate) {
      //>=开始时间 ; <= 结束时间;
      criteria.and("createTime").gte(startDate).lte(endDate);
    }
    // 任务中, 3为守护, 4为召唤
    criteria.and("taskType").is(userDayTaskEnums.getTaskType());
    return mongoDbService.count(new Query(criteria), UserDayTaskDo.class);
  }

  @Override
  public Long countTaskUserByDate (Long startDate, Long endDate, UserDayTaskEnums userDayTaskEnums, Integer isDelete, Long starId) {
    Criteria criteria = new Criteria();
    criteria.and("taskType").is(userDayTaskEnums.getTaskType());
    if (null != startDate & null != endDate) {
      //>=开始时间 ; <= 结束时间;
      criteria.and("createTime").gte(startDate).lte(endDate);
    }
    if (starId != null) {
      criteria.and("starId").is(starId);
    }
    if (isDelete != null) {
      criteria.and("isDelete").is(isDelete);
    }
    // if条件判断完后, 把criteria传进match函数里(因为在match里是无法ifnull的)
    Aggregation agg = Aggregation.newAggregation(
            Aggregation.match(criteria)
            , Aggregation.group("userUniId")
            , Aggregation.group("userUniId").count().as("count")
            , Aggregation.project("count")
    );
    Long count = 0L;
    AggregationResults<Map> results = mongoTemplate.aggregate(agg, "business_user_day_task", Map.class);
    // 得到结果
    List<Map> mappedResults = results.getMappedResults();
    if (CollectionUtils.isNotEmpty(mappedResults)) {
      Object obj  = mappedResults.get(0).get("count");
      count = (obj == null ? 0L : Long.valueOf(obj.toString()));
    }
    return count;
  }

}
