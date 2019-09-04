package com.hndl.cn.mghd.job.business.weibo.job;

import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.mghd.job.business.weibo.service.GetWeiboService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mghd.job.quartz.base.AStandardBaseJob;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import com.hndl.cn.mysql.manager.system.manager.SystemParameterInfoManager;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;

/**
 * @program:hndl-platform
 * @description: 定时刷新token
 * @author: 易成贤
 * @create: 2019-06-09 15:42
 * @Created by湖南达联
 **/
@Slf4j
@Component
public class FlushTokenJob extends AStandardBaseJob {

    @Resource
    private SystemJobInfoManager systemJobInfoManager;
    @Resource
    private GetWeiboService getWeiboService;
    @Resource
    private ApplicationContext applicationContext;

    @Resource
    private SystemParameterInfoManager systemParameterInfoManager;

    /**
     * 初始化appid
     *
     * @return appId
     * @Description
     * @author 唐宋
     */
    @Override
    public String initAppId() {
        return MghdJobConstants.APP_ID;
    }

    /**
     * 初始化Cron表达式key
     *
     * @return cronKey
     * @Description
     * @author 唐宋
     */
    @Override
    public String initCronKey() {
        return applicationContext.getEnvironment().getProperty("mghd.job.fans.flushWeiboToken.key");
    }

    /**
     * 初始化Cron表达式值
     *
     * @return 表达式值
     * @Description
     * @author 唐宋
     */
    @Override
    public String initCronValue() {
        return applicationContext.getEnvironment().getProperty("mghd.job.fans.flushWeiboToken.cron");
    }

    /**
     * 初始化有效标志
     *
     * @return 表达式值
     * @Description
     * @author 唐宋
     */
    @Override
    public int initValidSign() {
        String sign = applicationContext.getEnvironment().getProperty("mghd.job.fans.flushWeiboToken.sign");
        if ( null == sign){
            return 0;
        }
        return Integer.valueOf(sign);
    }

    /**
     * Execute the actual job. The job data map will already have been
     * applied as bean property values by execute. The contract is
     * exactly the same as for the standard Quartz execute method.
     *
     * @param context
     * @see #execute
     */
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        String jobName = FlushTokenJob.class.getSimpleName();
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
            log.info("=======================flushWeiboTokenJob初始化开始,开始时间为:{}======================================", LocalDateTime.now());

            String userName = applicationContext.getEnvironment().getProperty("WeiBoUserName");
            String password = applicationContext.getEnvironment().getProperty("WeiBoPassword");

            String token = getWeiboService.getToken(userName, password);
            log.info("weibo_token值是:"+token+"\n");
            if (!systemParameterInfoManager.updateValueByParameterName("weibo_token",token)) {
                log.info("获取token成功，但修改token失败，token ："+token);
            }



        } catch (Exception e) {
            log.error("=======================flushWeiboTokenJob任务执行失败,结束时间为:{}======================================", LocalDateTime.now());
            e.printStackTrace();

        } finally {

            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
            if (!flag) log.error("====修改任务状态失败:" + jobName + "====");
            log.info("=======================flushWeiboTokenJob初始化完成,结束时间为:{}======================================", LocalDateTime.now());

        }
    }
}
