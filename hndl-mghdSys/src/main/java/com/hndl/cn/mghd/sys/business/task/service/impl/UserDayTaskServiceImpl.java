package com.hndl.cn.mghd.sys.business.task.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.task.service.MasterDayRewardService;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.business.task.vo.UserTaskVo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.mongodb.manager.task.bean.UserDayTaskDo;
import com.hndl.cn.mongodb.manager.task.bean.UserNormalityTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.task.manager.UserNormalityTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.number.LevelUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @program: hndl-platform
 * @description: 用户每日任务
 * @author: 易成贤
 * @create: 2019-05-06 13:50 @Created by 湖南达联
 */
@Service
@Slf4j
public class UserDayTaskServiceImpl implements UserDayTaskService {


    @Resource
    UserDayTaskManager userDayTaskManager;

    @Resource
    UserStatisticsDoManager userStatisticsDoManager;

    @Resource
    UserIntegralLogManager userIntegralLogManager;

    @Resource
    MasterDayRewardService masterDayRewardService;

    @Resource
    StarFansGroupRelationManager starFansGroupRelationManager;

    @Resource
    RedisService redisService;

    @Resource
    UserNormalityTaskManager userNormalityTaskManager;

    @Resource
    StarCallContentManger starCallContentManger;

    /**
     * 查询用户任务数据
     *
     * @param commonUserInfoDo
     * @return
     */
    @Override
    public Map<Integer, UserTaskVo> findUserDayTask(CommonUserInfoDo commonUserInfoDo) {

        // 用户存储对象用户列表
        final Map<Integer, UserTaskVo> userTaskMap = new ConcurrentHashMap<>();
        // 分组查询用户列表
        Map<Integer, List<UserDayTaskDo>> map =
                userDayTaskManager.findToDayTaskByUserUniId(commonUserInfoDo.getSysUniId()).stream()
                        .collect(Collectors.groupingBy(UserDayTaskDo::getTaskType));
        // 设置任务列表
        if (map != null && map.size() > MghdSysConstants.ZERO) {
            map.forEach(
                    (k, val) -> {
                        UserTaskVo vo = new UserTaskVo();
                        // 判断是app还是wechat并且写入对应描述，数据错误，描述则为null
                        UserDayTaskEnums userDayTaskEnums = UserDayTaskEnums.getWeChat().get(k);
                        if (null == userDayTaskEnums) {
                            userDayTaskEnums = UserDayTaskEnums.getApp().get(k);
                        }

                        //不为空
                        if (null != userDayTaskEnums) {
                            vo.setTaskDescription(userDayTaskEnums.getDescription()); // 任务描述
                            vo.setCountTask(userDayTaskEnums.getDayCount()); // 任务总条数
                            vo.setTaskImg(userDayTaskEnums.getTaskImg());
                            vo.setTaskIntegral(userDayTaskEnums.getIntegralCount());

                            // 还有多少奖励没有领取
                            Long aLong = val.stream().filter(userDayTaskDo -> userDayTaskDo.getIsDelete().equals(IsValidEnums.NO.getValue())).count();
                            //超限纠正
                            aLong = aLong > userDayTaskEnums.getDayCount() ? userDayTaskEnums.getDayCount() : aLong;
                            // 任务类型
                            vo.setTaskType(k);
                            // 完成多少条[超限纠正]
                            vo.setFinished(val.size() > userDayTaskEnums.getDayCount() ? userDayTaskEnums.getDayCount() : val.size());
                            vo.setNoGetted(aLong.intValue());
                            userTaskMap.put(k, vo);
                        }
                    });
            // 设置查不到的数据
            return setNoTask(userTaskMap);
        } else {
            return setNoTask(userTaskMap);
        }
    }

    // 设置没有做过任务的数据
    private Map<Integer, UserTaskVo> setNoTask(Map<Integer, UserTaskVo> map) {
        for (UserDayTaskEnums enums : UserDayTaskEnums.values()) {
            if (map.get(enums.getTaskType()) == null) {
                UserTaskVo vo = new UserTaskVo();
                // 任务类型
                vo.setTaskType(enums.getTaskType());
                // 完成多少条
                vo.setFinished(MghdSysConstants.ZERO);
                vo.setNoGetted(MghdSysConstants.ZERO);
                // 描述
                vo.setTaskDescription(enums.getDescription());
                // 任务总数
                vo.setCountTask(enums.getDayCount());
                vo.setTaskImg(enums.getTaskImg());
                vo.setTaskIntegral(enums.getIntegralCount());
                map.put(enums.getTaskType(), vo);
            }
        }
        return map;
    }

    /**
     * 查询APP任务列表
     *
     * @param
     * @return
     */
    @Override
    public  Map<Integer, UserTaskVo> findAppUserDayTask(CommonUserInfoDo commonUserInfoDo) {

        Map<Integer, UserTaskVo>  userTaskVos= new HashMap<>();

        Map<Integer, UserTaskVo> map = this.findUserDayTask(commonUserInfoDo);

        for (UserDayTaskEnums enums : UserDayTaskEnums.getApp().values()) {
            UserTaskVo taskVo = map.get(enums.getTaskType());
            if (taskVo != null) {
                userTaskVos.put(taskVo.getTaskType(),taskVo);
            }
        }
        return userTaskVos;
    }

    /**
     * 查询weChat任务列表
     *
     * @param
     * @return
     */
    @Override
    public List<UserTaskVo> findWeChatUserDayTask(CommonUserInfoDo commonUserInfoDo) {
        List<UserTaskVo> userTaskVos = new ArrayList<>();
        Map<Integer, UserTaskVo> map = this.findUserDayTask(commonUserInfoDo);
        for (UserDayTaskEnums enums : UserDayTaskEnums.getWeChat().values()) {
            UserTaskVo taskVo = map.get(enums.getTaskType());
            if (taskVo != null) {
                userTaskVos.add(taskVo);
            }
        }
        return userTaskVos;
    }

    /**
     * 用户领取积分
     *
     * @param sysUniId         用户唯一id
     * @param userDayTaskEnums 每日任务枚举
     * @return 返回对应领取任务后数据
     */
    @Override
    @SubmitLock(keys = "sysUniId", sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<UserTaskVo> getIntegralCount(Long sysUniId, UserDayTaskEnums userDayTaskEnums) {

        // 1，判断传入枚举是否参数异常
        if (userDayTaskEnums == null) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        // 4 判断是否有当天任务可以领取
        if (!userDayTaskManager.toDayCanGetByUserUniId(sysUniId, userDayTaskEnums)) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_GET_FAILURE_EXCEPTION.getCode());
        }
        // 修改领取的字段
        if (!userDayTaskManager.updateIsDelete(sysUniId, userDayTaskEnums)) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_GET_FAILURE_EXCEPTION.getCode());
        }
        // 查询用户并且获取领取积分会获取多少积分
        UserStatisticsDo userStatisticsDo = userStatisticsDoManager.findUserStatisticsByUserUinId(sysUniId);

      Integer integralCount = userDayTaskEnums.getIntegralCount();

      //判断是否打call任务
      if (UserDayTaskEnums.CALL_TASK.equals(userDayTaskEnums)) {
        //查询打call第一条是否为带图
        StarCallContentDo fristCallByDay = starCallContentManger.findFristCallByDay(sysUniId);
        //设置积分为30积分
       integralCount = CollectionUtils.isNotEmpty(fristCallByDay.getContentImgList()) ? 30 : integralCount;
      }

      Long integral = LevelUtil.getTaskAward(userStatisticsDo.getEmpirical().intValue(), integralCount);



        // 增加用户积分数
        userStatisticsDoManager.userStatisticsAddIntegralCount(sysUniId, integral, IsValidEnums.NO);
        // 插入用户积分获取记录表
        userIntegralLogManager.insertUserIntegralLog(sysUniId, "0", IsValidEnums.YES, userDayTaskEnums.getTaskType(), integral.intValue());
        // 查询该任务
        UserTaskVo dayTaskVo = findOneDayTask(sysUniId, userDayTaskEnums);
        //设置获取了多少积分
        dayTaskVo.setGetIntegral(integral);
        //返回成功数据
        return ResultFactory.success(dayTaskVo);
    }

    /**
     * 查询单个任务记录
     *
     * @param
     * @param
     * @param userDayTaskEnums
     * @return
     */
    private UserTaskVo findOneDayTask(Long sysUniId, UserDayTaskEnums userDayTaskEnums) {
        List<UserDayTaskDo> task =
                userDayTaskManager.findTaskByUserUniIdAndTaskType(sysUniId, userDayTaskEnums);
        UserTaskVo taskVo = new UserTaskVo();
        // 任务类型
        taskVo.setTaskType(userDayTaskEnums.getTaskType());
        if (task == null) {
            // 查不到任务
            taskVo.setNoGetted(MghdSysConstants.ZERO);
            taskVo.setFinished(MghdSysConstants.ZERO);
        } else {
            // 计算可领取数据
            Long collect =
                    task.stream()
                            .filter(
                                    userDayTaskDo -> IsValidEnums.NO.getValue().equals(userDayTaskDo.getIsDelete()))
                            .count();
            taskVo.setNoGetted(collect.intValue());
            // 任务记录条数
            taskVo.setFinished(task.size());
        }
        // 任务总数
        taskVo.setCountTask(userDayTaskEnums.getDayCount());
        // 任务描述
        taskVo.setTaskDescription(userDayTaskEnums.getDescription());
        return taskVo;
    }

    /**
     * @param
     * @param starId
     * @param userDayTaskEnums
     */
    @Override
    public void insetTask(Long sysUniId, Long starId, UserDayTaskEnums userDayTaskEnums) {
        // 4,判断是否完成，完成不做任务记录
        if (!userDayTaskManager.toDayIsCompleteByUserUniIdAndStarId(sysUniId, userDayTaskEnums)) {
            return;
        }
        // 5,判断用户在不在粉丝会
        if (!starId.equals(0L)) {
            StarFansGroupRelationDo relation =
                    starFansGroupRelationManager.findStarFansGroupRelation(sysUniId, starId);
            if (null == relation || IsValidEnums.YES.getValue().equals(relation.getIsDelete())) {
                return;
            }
        }

        // 6,插入任务记录
        userDayTaskManager.insert(sysUniId, starId, userDayTaskEnums);
        UserNormalityTaskDo userNormalitytask =
                userNormalityTaskManager.findOne(sysUniId, UserNormalityTaskEnums.OBEY_MASTER);
        // 7,插入师傅额外奖励记录
        if (null != userNormalitytask) {
            masterDayRewardService.asyncInsertMasterDayReward(
                    sysUniId, Long.valueOf(userNormalitytask.getObjId()));
        }
    }

    public static void main(String[] args) {
    }
}
