package com.hndl.cn.mghd.sys.business.guard.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.guard.service.GuardService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansStatisticsService;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansDayStatisticsDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: hndl-platform
 * @description: 守护
 * @author: 易成贤
 * @create: 2019-05-10 14:43
 * @Created by 湖南达联
 **/
@Service
@Slf4j
public class GuardServiceImpl implements GuardService {

    @Resource
    StarFansGroupRelationManager starFansGroupRelationManager;
    @Resource
    StarFansDayStatisticsManager starFansDayStatisticsManager;
    @Resource
    UserDayTaskManager userDayTaskManager;
    @Resource
    StarFansGroupManager starFansGroupManager;
    @Resource
    StarFansStatisticsService starFansStatisticsService;
    @Resource
    UserDayTaskService userDayTaskService;

    /**
     * 用户守护明星
     * @param commonUserInfoDo 用户对象
     * @param starId 明星id
     * @return 成功
     */
    @Override
    @SubmitLock(keys = "commonUserInfoDo#sysUniId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<Object> doGuard(CommonUserInfoDo commonUserInfoDo, Long starId) {

        //1,查询用户与粉丝会关系表
        StarFansGroupRelationDo relation = starFansGroupRelationManager.findStarFansGroupRelation(commonUserInfoDo.getSysUniId(), starId);
        //2，用户不在粉丝会
        if ( null == relation  || IsValidEnums.YES.getValue().equals(relation.getIsDelete())) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANSGOUP_NOT_FIND_EXCEPTION.getCode());
        }
        //3，判断守护任务是否全部完成
        if (userDayTaskManager.toDayIsCompleteByUserUniId(commonUserInfoDo.getSysUniId(), UserDayTaskEnums.GUARD_TASK)) {
            //守护已达上限
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_ADD_MAX_GUARD_EXCEPTION.getCode());
        }
        //4，判断当日任务
        StarFansDayStatisticsDo dayStatisticsDo = starFansDayStatisticsManager.findStarFansDayStatistics(commonUserInfoDo.getSysUniId(), starId);

        if ( null != dayStatisticsDo && null != dayStatisticsDo.getGuardCount() && dayStatisticsDo.getGuardCount() > MghdSysConstants.ZERO) {
            //查询今日守护数大于0，那么已经守护过了
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_ADD_IS_GUARD_EXCEPTION.getCode());
        }
        //任务记录
        userDayTaskService.insetTask(commonUserInfoDo.getSysUniId(),starId,UserDayTaskEnums.GUARD_TASK);

        //更新粉丝会日周月总统计守护数
        StarFansGroupDo fansGroup = starFansGroupManager.findStarFansGroup(starId);

        if (fansGroup == null) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }
        starFansStatisticsService.addConductStatistics(commonUserInfoDo, fansGroup, FansGroupContributeEnums.GUARD);

        //更新粉丝会总守护数
        starFansGroupManager.updateGuardCount(starId);

        //成功
        return ResultFactory.success();
    }
}
