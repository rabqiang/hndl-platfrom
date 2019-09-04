package com.hndl.cn.mghd.job.business.weibo.job;

import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.dao.system.bean.SystemParameterInfoDo;
import com.hndl.cn.dao.weibo.WeiboDo;
import com.hndl.cn.mghd.job.business.weibo.service.GetWeiboService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mghd.job.quartz.base.AStandardBaseJob;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import com.hndl.cn.mysql.manager.system.manager.SystemParameterInfoManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

/**
 * @program:hndl-platform
 * @description: 自动获取微博数据
 * @author: 易成贤
 * @create: 2019-05-25 13:13
 * @Created by湖南达联
 **/
@Component
@Slf4j
public class GetWeiboJob extends AStandardBaseJob {


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
        return applicationContext.getEnvironment().getProperty("mghd.job.fans.weibo.key");
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
        return applicationContext.getEnvironment().getProperty("mghd.job.fans.weibo.cron");
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
        String sign = applicationContext.getEnvironment().getProperty("mghd.job.fans.weibo.sign");
        if ( null == sign){
            return 0;
        }
      return Integer.valueOf(sign);
    }

    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext){
        String jobName = GetWeiboJob.class.getSimpleName();
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
            log.info("=======================GetWeiboJob初始化开始,开始时间为:{}======================================", LocalDateTime.now());

            String userName = applicationContext.getEnvironment().getProperty("WeiBoUserName");
            String password = applicationContext.getEnvironment().getProperty("WeiBoPassword");
            //String token = applicationContext.getEnvironment().getProperty("WeiboToken");
            //假设token每次任务刷新，可能会增加封号风险,
          //  String token = getWeiboService.getToken(userName, password);
            SystemParameterInfoDo parameter = systemParameterInfoManager.findByParameterName("weibo_token");
            String token =parameter.getParameterValue();
           if (token == null){
                    log.info("获取weibo_token失败："+token);
                    return;
            }
            //每次任务只能查询2页200条
            for (int i = 1; i < 3 ; i++) {
                //查询第一页80条记录
                WeiboDo weibo = getWeiboService.getWeibo(token, String.valueOf(i), "100");
                if (null == weibo){
                   log.info("在线获取微博数据为null");
                   return;
                }
                //分析转换为站内数据
                List<StarCallContentDo> callContentDos = getWeiboService.analysisWeiboJson(weibo.getStatuses());
                if (CollectionUtils.isEmpty(callContentDos)) {
                    log.info("没有可用的微博数据可以插入！");
                    return;
                }
                //插入到数据库
                getWeiboService.insertWeiboCall(callContentDos);
                //伪随机休息时间 [50000-100000]ms -> 5''~10''
                int max = 100000;//10分钟
                int min = 50000;//5分中
                Random random = new Random();
                int time = random.nextInt(max-min)+min;
                Thread.sleep(time);
            }
        } catch (Exception e) {
            log.error("=======================GetWeiboJob任务执行失败,结束时间为:{}======================================", LocalDateTime.now());
            e.printStackTrace();

        } finally {

            boolean flag = systemJobInfoManager.updateJobStatus(jobName, MghdJobConstants.JOB_STATUS_WAIT);
            if (!flag) log.error("====修改任务状态失败:" + jobName + "====");
            log.info("=======================GetWeiboJob初始化完成,结束时间为:{}======================================", LocalDateTime.now());

        }

    }
}
