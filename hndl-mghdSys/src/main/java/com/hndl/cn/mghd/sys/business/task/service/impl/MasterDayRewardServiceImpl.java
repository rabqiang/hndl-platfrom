package com.hndl.cn.mghd.sys.business.task.service.impl;


import com.hndl.cn.mghd.sys.business.task.service.MasterDayRewardService;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mongodb.manager.task.bean.MasterDayReward;
import com.hndl.cn.mongodb.manager.task.manager.MasterDayRewardManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/7 16:53
 * @Created by 湖南达联
 */
@Service
public class MasterDayRewardServiceImpl implements MasterDayRewardService {

    @Resource
    private UserDayTaskManager userDayTaskManager;

    @Resource
    private MasterDayRewardManager masterDayRewardManager;


    @Override
    @Async("StatisticsTaskExecutePool")
    public void asyncInsertMasterDayReward(Long userUniId, Long masterId) {

        //如果没有师傅
        if (masterId == null) {
            return;
        }

        Long count = userDayTaskManager.countToDayTaskByUserUniId(userUniId);

        //如果没有任务没有到达门槛
        if (count < MghdSysConstants.TASK_COUNT_MASTER_REWARD_THRESHOLE) {
            return;
        }

        //如果没有记录
        if (!masterDayRewardManager.isExist(masterId, userUniId)) {
            MasterDayReward masterDayReward = new MasterDayReward();
            masterDayReward.setMasterId(masterId);
            masterDayReward.setSlaveId(userUniId);
            masterDayReward.setCreateTime(LocalDateUtil.localDateToMilliSecond(LocalDate.now()));
            masterDayRewardManager.insert(masterDayReward);
        }
    }
}
