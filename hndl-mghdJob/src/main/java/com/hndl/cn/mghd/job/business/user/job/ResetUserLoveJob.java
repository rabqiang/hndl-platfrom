//package com.hndl.cn.mghd.job.business.user.job;
//
//import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
//import com.hndl.cn.mghd.job.business.user.service.ResetUserLoveJobService;
//import com.hndl.cn.mghd.job.constants.MghdJobConstants;
//import com.hndl.cn.mghd.job.quartz.base.AStandardBaseJob;
//import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.context.ApplicationContext;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import java.time.LocalDateTime;
//
///**
// * @author 赵俊凯
// * @Description 每天定时清空爱心值
// * @Date 2019/4/30 15:06
// * @Created by 湖南达联
// */
//@Component
//public class ResetUserLoveJob extends AStandardBaseJob {
//
//    private static final Logger log = LoggerFactory.getLogger(ResetUserLoveJob.class);
//
//    @Resource
//    private ResetUserLoveJobService resetUserLoveJobService;
//
//    @Resource
//    private SystemJobInfoManager systemJobInfoManager;
//
//    @Resource
//    private ApplicationContext applicationContext;
//
//    @Override
//    public String initAppId() {
//        return MghdJobConstants.APP_ID;
//    }
//
//    @Override
//    public String initCronKey() {
//        return applicationContext.getEnvironment().getProperty("mghd.job.reset.user.love.key");
//    }
//
//    @Override
//    public String initCronValue() {
//        return applicationContext.getEnvironment().getProperty("mghd.job.reset.user.love.cron");
//    }
//
//    @Override
//    public int initValidSign() {
//        return Integer.valueOf(applicationContext.getEnvironment().getProperty("mghd.job.reset.user.love.sign"));
//    }
//
//    @Override
//    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
//
//        String jobName = ResetUserLoveJob.class.getSimpleName();
//        try {
//
//            final SystemJobInfoDo byJobName = systemJobInfoManager.findByJobName(jobName);
//
//            if (byJobName == null) {
//                log.error("====未定义经的job,请先配置:" + jobName + "====");
//                return;
//            }
//            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_RUN);
//
//            if (!flag) {
//                log.error("====修改任务状态失败:" + jobName + "====");
//                return;
//            }
//            Long startTime = System.currentTimeMillis();
//            resetUserLoveJobService.resetToDayUserLove();
//            Long endTime = System.currentTimeMillis();
//            log.info("==================每天定时清空爱心值耗时:{}===========================", endTime - startTime);
//        }catch (Exception e){
//            log.error("=======================ResetUserLoveJob任务执行失败,结束时间为:{}======================================",LocalDateTime.now());
//            e.printStackTrace();
//        }finally {
//            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
//            if(!flag){
//                log.error("====修改任务状态失败:"+jobName+"====");
//            }
//            log.info("=======================ResetUserLoveJob初始化完成,结束时间为:{}======================================",LocalDateTime.now());
//        }
//    }
//}
