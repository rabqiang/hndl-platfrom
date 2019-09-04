package com.hndl.cn.mghd.admin.business.star.service.impl;

import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.mghd.admin.business.star.service.StarActiveDataService;
import com.hndl.cn.mghd.admin.business.star.vo.StarActiveDataInfoVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.task.bean.UserDayTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/3 11 15
 * @Description:
 * @Author: 资龙茂
 */
@Service
public class StarActiveDataServiceImpl implements StarActiveDataService {

    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private HappyCoinBillInfoManger happyCoinBillInfoManger;

    @Resource
    private StarCallContentManger starCallContentManger;

    @Resource
    private UserDayTaskManager userDayTaskManager;

    @Resource
    private UserIntegralLogManager userIntegralLogManager;

    @Override
    public Result<Object> findStarActiveInfoByName(@NotNull String starName, Long startDate, Long endDate) {

        // 不能查询超过31天的数据
        if ((endDate - startDate) > 2678400000L) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_DATE_TOO_LONG.getCode());
        }
        // 结束时间不能小于开始时间
        if (endDate < startDate) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_DATE_ERROR.getCode());
        }

//        LocalDate startLocalDate = LocalDateUtil.milliSecondToLocalDate(startDate);
//        LocalDate endLocalDate = LocalDateUtil.milliSecondToLocalDate(endDate);
        // 1. 通过明星姓名精确查询明星集合
        List<StarFansGroupDo> starList = starFansGroupManager.findStarByStarName(starName);

        // 2. 判断集合size, 为零则直接返回
        if (starList.size() > 0) {
            List<StarActiveDataInfoVo> starActiveDataInfoVoList = new ArrayList<>();
            // 3. 遍历明星集合, 挨个查询各项数据
            for (StarFansGroupDo star : starList) {
                StarActiveDataInfoVo starActiveDataInfoVo = new StarActiveDataInfoVo();
                // id
                starActiveDataInfoVo.setStarId(star.getStarId());
                // 明星姓名
                starActiveDataInfoVo.setStarName(star.getStarName());
                // 积分打榜数
                starActiveDataInfoVo.setIntegralCount(userIntegralLogManager.findIntegralCountByStarId(startDate, endDate, star.getStarId().toString()));
                // 比心数
                starActiveDataInfoVo.setHeartCount(happyCoinBillInfoManger.queryCountByExample(startDate, endDate, star.getStarId()) / 100);
                // 守护数
                starActiveDataInfoVo.setGuardCount(userDayTaskManager.countTaskByStarId(UserDayTaskEnums.GUARD_TASK, star.getStarId(), startDate, endDate).intValue());
                // 守护人数
                starActiveDataInfoVo.setGuardUserCount(userDayTaskManager.countTaskUserByDate(startDate, endDate, UserDayTaskEnums.GUARD_TASK, null, star.getStarId()).intValue());
                // 打call数
                starActiveDataInfoVo.setCallCount(starCallContentManger.countByTime(star.getStarId(), startDate, endDate));
                // 召唤数
                starActiveDataInfoVo.setSummonCount(userDayTaskManager.countTaskByStarId(UserDayTaskEnums.SUMMON_TASK, star.getStarId(), startDate, endDate).intValue());
                // ---------------------
                starActiveDataInfoVoList.add(starActiveDataInfoVo);
            }
            // 4. 返回
            return ResultFactory.success(starActiveDataInfoVoList);
        }
        return ResultFactory.success();
    }

    /**
     * 去除user中的重复数据,只留下参与过的人数
     * @param userIntegralLogDoList
     * @return
     */
    int setIntegralLogValue(List<UserIntegralLogDo> userIntegralLogDoList) {
        for (int i = 0; i < userIntegralLogDoList.size() - 1; i++) {
            for (int j = userIntegralLogDoList.size() - 1; j > i; j--) {
                if (userIntegralLogDoList.get(j).getUserUniId().equals(userIntegralLogDoList.get(i).getUserUniId())) {
                    userIntegralLogDoList.remove(j);
                }
            }
        }
        return userIntegralLogDoList.size();
    }

    /**
     * 去除user中的重复数据,只留下参与过的人数
     * @param taskList
     * @return
     */
    int setValue(List<UserDayTaskDo> taskList) {
        for (int i = 0; i < taskList.size() - 1; i++) {
            for (int j = taskList.size() - 1; j > i; j--) {
                if (taskList.get(j).getUserUniId().equals(taskList.get(i).getUserUniId())) {
                    taskList.remove(j);
                }
            }
        }
        return taskList.size();
    }

    /**
     * 根据比心集合查询明星收到了多少比心
     * @param coinList
     * @return
     */
    Long getHeartCount(List<HappyCoinBillInfoDo> coinList) {
        if (coinList.size() < 1) {
            return 0L;
        }
        Long coinCount = 0L;
        for (HappyCoinBillInfoDo coin : coinList) {
            coinCount += coin.getCoinCount();
        }
        return coinCount;
    }

    /**
     * 根据积分集合查询明星收到了多少积分打榜
     * @param integralList
     * @return
     */
    Long getIntegralCount(List<UserIntegralLogDo> integralList) {
        if (integralList.size() < 1) {
            return 0L;
        }
        Long integralCount = 0L;
        for (UserIntegralLogDo userIntegralLogDo : integralList) {
            integralCount += userIntegralLogDo.getIntegralCount();
        }
        return integralCount;
    }
}
