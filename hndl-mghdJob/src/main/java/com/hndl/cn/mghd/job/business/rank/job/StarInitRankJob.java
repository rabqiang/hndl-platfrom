package com.hndl.cn.mghd.job.business.rank.job;

import com.hndl.cn.base.properties.BasePropertiesUtil;
import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.rank.service.StarDayRankJobService;
import com.hndl.cn.mghd.job.business.rank.service.StarMonthRankJobService;
import com.hndl.cn.mghd.job.business.rank.service.StarWeekRankJobService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mghd.job.quartz.base.AStandardBaseJob;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * @author 赵俊凯
 * @Description 提前刷入明星排行榜数据 每天23：30执行
 * @Date 2019/4/25 20:13
 * @Created by 湖南达联
 */
@Component
public class StarInitRankJob extends AStandardBaseJob {

    private static final Logger log = LoggerFactory.getLogger(StarInitRankJob.class);

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
        return applicationContext.getEnvironment().getProperty("mghd.job.init.rank.job.key");
    }

    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("mghd.job.init.rank.job.cron");
    }

    @Override
    public int initValidSign() {
        return Integer.valueOf(applicationContext.getEnvironment().getProperty("mghd.job.init.rank.job.sign"));
    }

    /**
     * 这里注意，需要同步更新缓存数据
     * @param context
     * @throws JobExecutionException
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String jobName = StarInitRankJob.class.getSimpleName();
        try{


            final SystemJobInfoDo byJobName = systemJobInfoManager.findByJobName(jobName);

            if(byJobName == null){
                log.error("====未定义经的job,请先配置:"+jobName+"====");
                return;
            }
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_RUN);

            if(!flag){
                log.error("====修改任务状态失败:"+jobName+"====");
                return;
            }

            log.info("=======================StarInitRankJob初始化开始,开始时间为:{}======================================",LocalDateTime.now());

            //1 提前初始化日版数据。
            starDayRankJobService.initNextStarFansGroupDayRank();
            log.info("=======================StarInitRankJob日版数据初始化完成======================================");

            //2 判断今天是否是星期天，如果是，则初始化下周的周榜数据
            if(LocalDateUtil.isSUNDAY()){
                starWeekRankJobService.initNextStarFansGroupWeekRank();
                log.info("=======================StarInitRankJob周榜版数据初始化完成======================================");
            }

            //3 判断今天是否是这个月的最后一天，如果是，则初始化下月的月榜数据
            if(LocalDateUtil.isLastDayOfMonth()){
                starMonthRankJobService.initNextStarFansGroupDayRank();
                log.info("=======================StarInitRankJob月榜版数据初始化完成======================================");
            }


        }catch (Exception e){
            log.error("=======================StarInitRankJob任务执行失败,结束时间为:{}======================================",LocalDateTime.now());
            e.printStackTrace();
        }finally {
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
            if(!flag){
                log.error("====修改任务状态失败:"+jobName+"====");
            }
            log.info("=======================StarInitRankJob初始化完成,结束时间为:{}======================================",LocalDateTime.now());
        }



    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());
        System.out.println(localDate.getDayOfWeek().equals(DayOfWeek.THURSDAY));
        LocalDate lastDay =localDate.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(localDate);
        System.out.println(lastDay);
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.getDayOfYear());
        System.out.println(localDate.getDayOfMonth());
    }
}
