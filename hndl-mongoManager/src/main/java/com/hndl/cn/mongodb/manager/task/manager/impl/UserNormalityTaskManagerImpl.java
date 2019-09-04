package com.hndl.cn.mongodb.manager.task.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.mongodb.manager.task.bean.UserNormalityTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.UserNormalityTaskManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 汪海
 * @Description TODO
 * @Date 2019/4/22 0022 14:57
 * @Created by 湖南达联
 */
@Service
public class UserNormalityTaskManagerImpl implements UserNormalityTaskManager {

    @Resource
    private MongoDbService mongoDbService;


    @Override
    public void insert(Long userUniId, String objId, UserNormalityTaskEnums userNormalityTaskEnums, Integer isDelete) {
        UserNormalityTaskDo userNormalityTaskDo = new UserNormalityTaskDo();
        userNormalityTaskDo.setCreateTime(System.currentTimeMillis());
        userNormalityTaskDo.setIsDelete(isDelete);
        userNormalityTaskDo.setUserUniId(userUniId);
        userNormalityTaskDo.setObjId(objId);
        userNormalityTaskDo.setTaskType(userNormalityTaskEnums.getTaskType());
        userNormalityTaskDo.setCumulativeReward(0L);
        mongoDbService.insert(userNormalityTaskDo);
    }

    @Override
    public List<UserNormalityTaskDo> findByUserUniId(Long userUniId) {

        Criteria criteria = Criteria.where("userUniId").is(userUniId);

        Query query = new Query(criteria);

        return mongoDbService.findAll(query, UserNormalityTaskDo.class);
    }

    @Override
    public Long findToNormalityTaskByUserUniIdAndObjId(Long userUniId, UserNormalityTaskEnums userNormalityTaskEnums, IsValidEnums isValidEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("taskType").is(userNormalityTaskEnums.getTaskType());

        if (isValidEnums != null) {
            criteria.and("isDelete").is(isValidEnums.getValue());
        }
        Query query = new Query(criteria);

        return mongoDbService.count(query, UserNormalityTaskDo.class);
    }

    @Override
    public boolean findUserDayTaskGetEmpirical(Long userUniId, UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("taskType").is(userDayEmpiricalTypeEnums.getTaskType());
        Query query = new Query(criteria);

        return mongoDbService.count(query, UserNormalityTaskDo.class) >= userDayEmpiricalTypeEnums.getDayCount();
    }

    @Override
    public boolean updateIsDelete(Long userUniId, UserNormalityTaskEnums userNormalityTaskEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("taskType").is(userNormalityTaskEnums.getTaskType());
        Query query = new Query(criteria);
//        查询用户没有领取过的奖励，收徒奖励有多个就直接领取查询的第一个的积分
        UserNormalityTaskDo userNormalityTaskDo = new UserNormalityTaskDo();
        userNormalityTaskDo.setIsDelete(IsValidEnums.YES.getValue());
        return mongoDbService.updateOne(query, userNormalityTaskDo, UserNormalityTaskDo.class);
    }

    /**
     * @param sysUniId
     * @param userNormalityTaskEnums
     * @return
     */
    @Override
    public List<UserNormalityTaskDo> findTaskByUserUniIdAndTaskType(Long sysUniId, UserNormalityTaskEnums userNormalityTaskEnums) {
        Criteria criteria = Criteria.where("userUniId").is(sysUniId)
                .and("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli())
                .lte(LocalDateTimeUtil.getNowMaxTimeMilli())
                .and("taskType").is(userNormalityTaskEnums.getTaskType());
        Query query = new Query(criteria);

        return mongoDbService.findAll(query, UserNormalityTaskDo.class);
    }

    /**
     * 根据用户id和任务查询用户常态任务信息
     *
     * @param sysUniId
     * @param userNormalityTaskEnums
     * @return
     */
    @Override
    public List<UserNormalityTaskDo> findTaskByUserUniIdAndTaskTypes(Long sysUniId, UserNormalityTaskEnums userNormalityTaskEnums) {
        Criteria criteria = Criteria.where("userUniId").is(sysUniId)
                .and("taskType").is(userNormalityTaskEnums.getTaskType());
        Query query = new Query(criteria);

        return mongoDbService.findAll(query, UserNormalityTaskDo.class);
    }

    @Override
    public UserNormalityTaskDo findOne(Long userUinId, UserNormalityTaskEnums userNormalityTaskEnums) {
        return mongoDbService.findOne(new Query(Criteria.where("userUniId").is(userUinId).and("taskType").is(userNormalityTaskEnums.getTaskType())), UserNormalityTaskDo.class);
    }

    @Override
    public boolean findUserIsSlave(Long masterId, String slaveId) {
        Criteria criteria = Criteria.where("userUniId").is(masterId).and("objId").is(slaveId).and("taskType").is(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType());
        return mongoDbService.count(new Query(criteria), UserNormalityTaskDo.class) > 0;
    }

    /**
     * 返回徒弟列表信息
     *
     * @param userUniId
     * @param userNormalityTaskEnums
     * @return
     */
    @Override
    public List<UserNormalityTaskDo> findSlaves(Long userUniId, UserNormalityTaskEnums userNormalityTaskEnums) {

        return getSlave(userUniId, userNormalityTaskEnums);
    }

    /**
     * 增加师父获取的积分方法
     *
     * @param userUniId
     * @param integer
     */
    @Override
    public void UserGetCumulativeReward(String userUniId, Long integer) {
        Criteria criteria = Criteria.where("objId").is(userUniId)
                .and("taskType").is(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType());
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("cumulativeReward", integer);
        mongoDbService.inc(query, update, UserNormalityTaskDo.class);

    }

    @Override
    public Integer countApprentice(Long userUniId) {
        Criteria criteria = Criteria.where("taskType").is(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType());
        if (userUniId != null && userUniId != 0) {
            criteria.and("userUniId").is(userUniId);
        }
        Query query = new Query(criteria);
        return mongoDbService.findAll(query, UserNormalityTaskDo.class).size();
    }

    @Override
    public List<UserNormalityTaskDo> getSlave(Long userUniId) {
        Criteria criteria = Criteria.where("taskType").is(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType())
                .and("userUniId").is(userUniId);

        //将其设置倒序输出
        //实例化sort对象
        Sort sort = Sort.by(Sort.Order.desc("cumulativeReward"));
        Query query = new Query(criteria).with(sort);

        return mongoDbService.findAll(query, UserNormalityTaskDo.class);
    }

    @Override
    public List<UserNormalityTaskDo> getSlave(String id, Long userUniId) {
        Criteria criteria = Criteria.where("taskType").is(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType());
        if (userUniId != null) {
             criteria.and("userUniId").is(userUniId);
        }
        if (id != null) {
            criteria.and("_id").gt(new ObjectId(id));
        }
        Sort sort = Sort.by(Sort.Order.desc("cumulativeReward"));
        Query query = new Query(criteria).with(sort).limit(BaseConstants.DEFAULT_LIMIT);


        return mongoDbService.findAll(query, UserNormalityTaskDo.class);
    }

    @Override
    public boolean findUserByNumber(Long userUniId) {
        Query query = new Query(Criteria.where("userUniId").is(userUniId).and("objId").ne("0").and("taskType").is(UserNormalityTaskEnums.BIND_PHONE.getTaskType()));
        return mongoDbService.findOne(query,UserNormalityTaskDo.class) != null ? true :false;
    }

    @Override
    public void upsret(Long userUniId, String objId, UserNormalityTaskEnums userNormalityTaskEnums, Integer isDelete) {
        UserNormalityTaskDo userNormalityTaskDo = new UserNormalityTaskDo();
        userNormalityTaskDo.setCreateTime(System.currentTimeMillis());
        userNormalityTaskDo.setIsDelete(isDelete);
        userNormalityTaskDo.setUserUniId(userUniId);
        userNormalityTaskDo.setObjId(objId);
        userNormalityTaskDo.setTaskType(userNormalityTaskEnums.getTaskType());
        Criteria criteria = Criteria.where("userUniId").
                is(userUniId).and("objId").is(objId).and("taskType").is(userNormalityTaskEnums.getTaskType());

        mongoDbService.upsert(new Query(criteria), userNormalityTaskDo, UserNormalityTaskDo.class);
    }

    /**
     * 查询前一百个徒弟信息
     *
     * @param userUniId
     * @param userNormalityTaskEnums
     * @return
     */
    public List<UserNormalityTaskDo> getSlave(Long userUniId, UserNormalityTaskEnums userNormalityTaskEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("taskType").is(userNormalityTaskEnums.getTaskType());

        //实例化sort对象
        Sort sort = Sort.by(Sort.Order.desc("cumulativeReward"));;
        //查询用户积分日志,查询一百条数
        Query query = new Query(criteria).with(sort).limit(100);

        return mongoDbService.findAll(query, UserNormalityTaskDo.class);
    }
}
