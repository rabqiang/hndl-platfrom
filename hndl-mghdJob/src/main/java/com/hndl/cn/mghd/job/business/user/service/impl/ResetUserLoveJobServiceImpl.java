package com.hndl.cn.mghd.job.business.user.service.impl;

import com.hndl.cn.mghd.job.business.user.service.ResetUserLoveJobService;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/30 15:08
 * @Created by 湖南达联
 */
@Service
public class ResetUserLoveJobServiceImpl implements ResetUserLoveJobService {

    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;


    @Override
    public void resetToDayUserLove() {
        //每天清空爱心值
        userStatisticsDoManager.initUserGettingLoveCount();
    }
}
