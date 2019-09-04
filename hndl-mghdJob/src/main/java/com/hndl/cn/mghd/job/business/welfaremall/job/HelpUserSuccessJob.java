package com.hndl.cn.mghd.job.business.welfaremall.job;

import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.welfaremall.service.WelfareMallJobService;
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
 * @Description TODO   福利商城的商品达到开奖条件,修改商品状态为开奖成功
 * @Date 2019/8/5 11:25
 * @Created by 湖南达联
 */

@Component
public class HelpUserSuccessJob extends AStandardBaseJob {
    private static final Logger log = LoggerFactory.getLogger(HelpUserSuccessJob.class);

    @Resource
    private WelfareMallJobService welfareMallJobService;

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
        return applicationContext.getEnvironment().getProperty("shop.job.welfare.success.key");
    }

    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("shop.job.welfare.success.cron");

    }

    @Override
    public int initValidSign() {
        return Integer.valueOf(applicationContext.getEnvironment().getProperty("shop.job.welfare.success.sign"));
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        String jobName = HelpUserSuccessJob.class.getSimpleName();
        try {
            final SystemJobInfoDo byJobName = systemJobInfoManager.findByJobName(jobName);
            if (byJobName == null) {
                log.error("=======未定义经的job,请先配置:" + jobName + "====");
                return;
            }
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_RUN);
            if (!flag) {
                log.error("修改福利商城的商品开奖的状态失败:" + jobName + "==========");
                return;
            }
            //开始执行定时任务时间戳
            long startTime = System.currentTimeMillis();
            //查询商品是否未达到开奖条件,如果未达到则将开奖设为失败
            welfareMallJobService.findHelpUserUpdateSuccess();
            //最后完成任务结束时间戳
            long endTime = System.currentTimeMillis();
            log.info("=======================HelpUserSuccessJob任务执行完毕,耗时为:{}======================================", endTime - startTime);


        } catch (Exception e) {
            log.error("=======================HelpUserSuccessJob任务执行失败,结束时间为:{}======================================", LocalDateTime.now());
            e.printStackTrace();
        } finally {
            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
            if (!flag) {
                log.error("======修改任务状态失败" + jobName + "=====");
            }
            log.info("===========================HelpUserSuccessJob初始化完成,结束时间为:{}======================================", LocalDateTime.now());
        }
    }
}
