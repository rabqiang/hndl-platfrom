package com.hndl.cn.mghd.job.business.rank.job;

import com.hndl.cn.base.properties.BasePropertiesUtil;
import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.rank.service.FansDayRankJobService;
import com.hndl.cn.mghd.job.business.rank.service.FansMonthRankJobService;
import com.hndl.cn.mghd.job.business.rank.service.FansWeekRankJobService;
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
 * @author 赵俊凯
 * @Description 星粉榜数据
 * @Date 2019/4/30 14:53
 * @Created by 湖南达联
 */
@Component
public class FansRankCacheJob extends AStandardBaseJob {

    private static final Logger log = LoggerFactory.getLogger(FansRankCacheJob.class);


    @Resource
    private FansDayRankJobService fansDayRankJobService;

    @Resource
    private FansWeekRankJobService fansWeekRankJobService;

    @Resource
    private FansMonthRankJobService fansMonthRankJobService;

    @Resource
    private SystemJobInfoManager systemJobInfoManager;

    @Resource
    private ApplicationContext applicationContext; //注入applicationContext


    @Override
    public String initAppId() {
        return MghdJobConstants.APP_ID;
    }

    @Override
    public String initCronKey() {
        return applicationContext.getEnvironment().getProperty("mghd.job.fans.rank.cache.key");
    }

    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("mghd.job.fans.rank.cache.cron");
    }

    @Override
    public int initValidSign() {
        return Integer.valueOf(applicationContext.getEnvironment().getProperty("mghd.job.fans.rank.cache.sign"));
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String jobName = FansRankCacheJob.class.getSimpleName();
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

            log.info("=======================FansRankCacheJob初始化开始,开始时间为:{}======================================", LocalDateTime.now());
            fansDayRankJobService.refreshFansRankDayCache();
            fansWeekRankJobService.refreshFansRankWeekCache();
            fansMonthRankJobService.refreshFansRankMonthCache();
        }catch (Exception e){
            log.error("=======================FansRankCacheJob任务执行失败,结束时间为:{}======================================",LocalDateTime.now());
            e.printStackTrace();
        }finally {
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
            if(!flag){
                log.error("====修改任务状态失败:"+jobName+"====");
            }
            log.info("=======================FansRankCacheJob初始化完成,结束时间为:{}======================================",LocalDateTime.now());
        }
    }
}
