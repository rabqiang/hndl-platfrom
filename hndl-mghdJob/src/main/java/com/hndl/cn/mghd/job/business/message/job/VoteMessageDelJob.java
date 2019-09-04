package com.hndl.cn.mghd.job.business.message.job;


import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.message.service.VoteMessageJobService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mghd.job.exception.MghdJobSysException;
import com.hndl.cn.mghd.job.exception.MghdJobSysExceptionEnums;
import com.hndl.cn.mghd.job.quartz.base.AStandardBaseJob;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author 尹争鸣
 * @Description 每日定时删除VoteMessage
 * @Date 2019年8月12日20:03:37
 * @Created by 湖南达联
 */

@Component
@Slf4j
public class VoteMessageDelJob extends AStandardBaseJob {

    @Resource
    private SystemJobInfoManager systemJobInfoManager;

    @Resource
    private ApplicationContext applicationContext; //注入applicationContext

    @Resource
    private VoteMessageJobService voteMessageJobService;


    @Override
    public String initAppId() {
        return MghdJobConstants.APP_ID;
    }

    @Override
    public String initCronKey() {
        return applicationContext.getEnvironment().getProperty("mghd.job.message.vote.reward.key");
    }

    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("mghd.job.message.vote.reward.cron");
    }

    @Override
    public int initValidSign() {
        return Integer.valueOf(applicationContext.getEnvironment().getProperty("mghd.job.message.vote.reward.sign"));
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        //JOB信息
        SystemJobInfoDo systemJobInfoDo = systemJobInfoManager.findByJobName(MghdJobConstants.VOTE_JOB_NAME);

        if (systemJobInfoDo == null) {
            throw new MghdJobSysException(MghdJobSysExceptionEnums.MGHD_JOB_NOJOB_EXCEPTION.getCode());
        }

        if (systemJobInfoDo.getStatus().equals(MghdJobConstants.JOB_STATUS_WAIT)) {
            //修改JOB状态
            systemJobInfoManager.updateJobStatus(MghdJobConstants.VOTE_JOB_NAME, MghdJobConstants.JOB_STATUS_RUN);
            //每日删除弹幕
            voteMessageJobService.delVoteMessage();
        }

        systemJobInfoManager.updateJobStatus(MghdJobConstants.VOTE_JOB_NAME, MghdJobConstants.JOB_STATUS_WAIT);
    }

}

