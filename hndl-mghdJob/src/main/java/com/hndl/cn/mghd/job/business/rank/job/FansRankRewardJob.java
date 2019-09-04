package com.hndl.cn.mghd.job.business.rank.job;

import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.rank.service.FansRewardService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mghd.job.exception.MghdJobSysException;
import com.hndl.cn.mghd.job.exception.MghdJobSysExceptionEnums;
import com.hndl.cn.mghd.job.quartz.base.AStandardBaseJob;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description 星粉榜奖励
 * @Date 2019/5/6 10:01
 * @Created by 湖南达联
 */
@Component
public class FansRankRewardJob extends AStandardBaseJob {


    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private SystemJobInfoManager systemJobInfoManager;

    @Resource
    private FansRewardService fansRewardService;

    @Override
    public String initAppId() {
        return MghdJobConstants.APP_ID;
    }

    @Override
    public String initCronKey() {
        return applicationContext.getEnvironment().getProperty("mghd.job.fans.rank.reward.key");
    }

    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("mghd.job.fans.rank.reward.cron");
    }

    @Override
    public int initValidSign() {
        return Integer.valueOf(applicationContext.getEnvironment().getProperty("mghd.job.fans.rank.reward.sign"));}

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
         //JOB信息
        SystemJobInfoDo systemJobInfoDo=systemJobInfoManager.findByJobName( MghdJobConstants.JOB_NAME);

        if (systemJobInfoDo==null){
            throw new  MghdJobSysException(MghdJobSysExceptionEnums.MGHD_JOB_NOJOB_EXCEPTION.getCode());
        }

        if (systemJobInfoDo.getStatus().equals( MghdJobConstants.JOB_STATUS_WAIT)){
             //修改JOB状态
            systemJobInfoManager.updateJobStatus( MghdJobConstants.JOB_NAME, MghdJobConstants.JOB_STATUS_RUN);
            //每日星粉榜奖励
            fansRewardService.awardFansDayReward();
        }

          systemJobInfoManager.updateJobStatus( MghdJobConstants.JOB_NAME, MghdJobConstants.JOB_STATUS_WAIT);
    }
}
