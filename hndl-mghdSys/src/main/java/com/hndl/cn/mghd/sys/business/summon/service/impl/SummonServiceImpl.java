package com.hndl.cn.mghd.sys.business.summon.service.impl;

import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.star.service.StarFansStatisticsService;
import com.hndl.cn.mghd.sys.business.summon.service.SummonService;
import com.hndl.cn.mghd.sys.business.task.service.UserDayTaskService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: hndl-platform
 * @description: 召唤
 * @author: 易成贤
 * @create: 2019-05-10 14:06
 * @Created by 湖南达联
 **/
@Service
public class SummonServiceImpl implements SummonService {
    private static final Logger log = LoggerFactory.getLogger(SummonServiceImpl.class);

    @Resource
    StarFansStatisticsService starFansStatisticsService;

    @Resource
    StarFansGroupManager starFansGroupManager;

    @Resource
    UserDayTaskManager userDayTaskManager;

    @Resource
    UserStatisticsDoManager userStatisticsManager;

    @Resource
    UserDayTaskService userDayTaskService;

    /**
     * 执行召唤
     * @param commonUserInfoDo
     * @param starId
     * @return
     */
    @Override
    @SubmitLock(keys = "commonUserInfoDo#sysUniId",sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<Object> doSummon(CommonUserInfoDo commonUserInfoDo, Long starId) {

        // 0，不管怎么操作只要调用了召唤接口，就算一次召唤，更新每日/周/月/总召唤数量
        StarFansGroupDo fansGroup = starFansGroupManager.findStarFansGroup(starId);
        if (fansGroup == null ){
            log.info("\t 指定粉丝会不存在："+starId);
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_FANS_NULL_EXCEPTION.getCode());
        }
        starFansStatisticsService.addConductStatistics(commonUserInfoDo, fansGroup, FansGroupContributeEnums.SUMMON);

        //2,如果任务已经完成不在进行插入操作
        if (userDayTaskManager.toDayIsCompleteByUserUniId(commonUserInfoDo.getSysUniId(), UserDayTaskEnums.SUMMON_TASK)) {
            //召唤完事
           return ResultFactory.success();
        }
        //3，插入任务记录
        userDayTaskService.insetTask(commonUserInfoDo.getSysUniId(), starId,UserDayTaskEnums.SUMMON_TASK);

        return ResultFactory.success();
    }
}
