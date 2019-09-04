package com.hndl.cn.mghd.job.business.rank.job;

import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.rank.service.StarDayRankJobService;
import com.hndl.cn.mghd.job.business.rank.service.StarMonthRankJobService;
import com.hndl.cn.mghd.job.business.rank.service.StarWeekRankJobService;
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
 * @Description 刷新缓存任务
 * @Date 2019/4/26 15:01
 * @Created by 湖南达联
 */
@Component
public class StarRankCacheJob extends AStandardBaseJob {

    private static final Logger log = LoggerFactory.getLogger(StarRankCacheJob.class);

    @Resource
    private StarDayRankJobService starDayRankJobService;

    @Resource
    private StarMonthRankJobService starMonthRankJobService;

    @Resource
    private StarWeekRankJobService starWeekRankJobService;

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
        return applicationContext.getEnvironment().getProperty("mghd.job.star.rank.job.key");
    }

    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("mghd.job.star.rank.job.cron");
    }

    @Override
    public int initValidSign() {
        return Integer.valueOf(applicationContext.getEnvironment().getProperty("mghd.job.star.rank.job.sign"));
    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String jobName = StarRankCacheJob.class.getSimpleName();
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
            starDayRankJobService.refreshStarRankDayCache();
            log.info("====明星日榜数据刷新:refreshStarRankDayCache====");

            starWeekRankJobService.refreshStarRankWeekCache();
            log.info("====明星周榜数据刷新:refreshStarRankWeekCache====");

            starMonthRankJobService.refreshStarRankMonthCache();
            log.info("====明星月榜数据刷新:refreshStarRankMonthCache====");


        }catch (Exception e){
            log.info("====StarRankCacheJob刷新异常====");
            e.printStackTrace();
        }finally {
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
            if(!flag){
                log.error("====修改任务状态失败:"+jobName+"====");
            }
            log.info("======================="+jobName+"完成,结束时间为:{}======================================",LocalDateTime.now());
        }
    }
}
