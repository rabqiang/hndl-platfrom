package com.hndl.cn.mghd.job.business.shop.job;

import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.shop.service.DataStatisticsService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mghd.job.quartz.base.AStandardBaseJob;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/10 11 56
 * @Description:
 * @Author: 资龙茂
 */
@Slf4j
@Component
public class DataStatisticsJob extends AStandardBaseJob {

    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private SystemJobInfoManager systemJobInfoManager;

    @Resource
    private DataStatisticsService dataStatisticsService;

    @Override
    public String initAppId() {
        return MghdJobConstants.APP_ID;
    }

    @Override
    public String initCronKey() {
        return applicationContext.getEnvironment().getProperty("mghd.job.data.statistics.key");
    }

    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("mghd.job.data.statistics.cron");
    }

    @Override
    public int initValidSign() {
        return Integer.valueOf(applicationContext.getEnvironment().getProperty("mghd.job.data.statistics.sign"));
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String jobName = DataStatisticsJob.class.getSimpleName();

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

            log.info("=======================DataStatisticsJob初始化开始,开始时间为:{}======================================", LocalDateTime.now());
            dataStatisticsService.writeData();
        } catch (Exception e){
            log.error("=======================DataStatisticsJob任务执行失败,结束时间为:{}======================================",LocalDateTime.now());
            e.printStackTrace();
        } finally {
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
            if(!flag){
                log.error("====修改任务状态失败:"+jobName+"====");
            }
            log.info("=======================DataStatisticsJob初始化完成,结束时间为:{}======================================",LocalDateTime.now());
        }
    }
}
