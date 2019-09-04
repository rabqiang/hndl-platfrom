package com.hndl.cn.shop.job.quartz.base;

import org.springframework.scheduling.quartz.QuartzJobBean;

/**
 * <pre>
 *
 * 【标题】: 标准job的父类
 * 【描述】:
 * 【版权】: 湖南达联
 * 【作者】: 赵俊凯
 * 【时间】: 2018-03-19 17:19
 * </pre>
 */
public abstract class AStandardBaseJob extends QuartzJobBean {

    /**
     * 初始化appid
     *
     * @Description
     * @author 唐宋
     * @return appId
     */
    public abstract String initAppId();

    /**
     * 初始化Cron表达式key
     *
     * @Description
     * @author 唐宋
     * @return cronKey
     */
    public abstract String initCronKey();

    /**
     * 初始化Cron表达式值
     *
     * @Description
     * @author 唐宋
     * @return 表达式值
     */
    public abstract String initCronValue();

    /**
     * 初始化有效标志
     *
     * @Description
     * @author 唐宋
     * @return 表达式值
     */
    public abstract int initValidSign();
}
