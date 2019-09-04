package com.hndl.cn.mghd.job.business.task.job;

import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.task.service.MentorRewardJobService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mghd.job.quartz.base.AStandardBaseJob;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @author 曹加丽
 * @Description 刷入所有用户的师徒奖励
 * @Date 2019/5/16 11:55
 * @Created by 湖南达联
 */
@Component
public class MentorRewardJob extends AStandardBaseJob {

    private static final Logger log = LoggerFactory.getLogger(MentorRewardJob.class);

    @Resource
    private MentorRewardJobService mentorRewardJobService;

    @Resource
    private SystemJobInfoManager systemJobInfoManager;

    @Resource
    private ApplicationContext applicationContext;


    @Override
    public String initAppId() {
        return MghdJobConstants.APP_ID;
    }

    @Override
    public String initCronKey() {
        return applicationContext.getEnvironment().getProperty("mghd.job.mentor.reward.job.key");
    }

    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("mghd.job.mentor.reward.job.cron");
    }

    @Override
    public int initValidSign() {
        return Integer.valueOf(applicationContext.getEnvironment().getProperty("mghd.job.mentor.reward.job.sign"));
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String jobName = MentorRewardJob.class.getSimpleName();
        try {
            final SystemJobInfoDo byJobName = systemJobInfoManager.findByJobName(jobName);
            if (byJobName == null) {
                log.error("====未定义经的job,请先配置:" + jobName + "====");
                return;
            }
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_RUN);
            if (!flag) {
                log.error("====修改任务状态失败:" + jobName + "====");
                return;
            }
            //开始执行的时间
            long startTime = System.currentTimeMillis();
            //开始查询所有用户完成的师徒任务
            mentorRewardJobService.userGetMentorReward();
            //完成任务时间
            long endTime = System.currentTimeMillis();
            log.info("=======================MentorRewardJob刷入所有用户的师徒奖励,耗时为:{}======================================", endTime - startTime);


        } catch (Exception e) {
            log.error("=======================MentorRewardJob任务执行失败,结束时间为:{}======================================", LocalDateTime.now());
            e.printStackTrace();
        } finally {
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
            if (!flag) {
                log.error("======修改任务状态失败" + jobName + "=====");
            }
            log.info("===========================MentorRewardJob初始化完成,结束时间为:{}======================================", LocalDateTime.now());
        }
    }
}
