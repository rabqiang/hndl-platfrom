package com.hndl.cn.base.hystrix;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.netflix.hystrix.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <pre>
 *
 * 【标题】: Hystrix command
 * 【描述】:
 * 【版权】: 湖南达联
 * 【作者】: 赵俊凯
 * 【时间】: 2018-04-10 14:42
 * </pre>
 */
public class HttpHystrix<T> extends HystrixCommand<Object> {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpHystrix.class);


    private  ProceedingJoinPoint pjp;

    // 类名
    private  String className;

    // 方法名
    private  String methodName;

    // 注解
    private  com.hndl.cn.base.annotation.hystrix.HystrixCommand hystrixCommand;

    /**
     * @param pjp
     */
    public HttpHystrix(ProceedingJoinPoint pjp, String className, String methodName, com.hndl.cn.base.annotation.hystrix.HystrixCommand hystrixCommand) {
        // Hystrix uses the command group key to group together commands such as for reporting,
        // alerting, dashboards, or team/library ownership.
        // 同一个groupKey共用同一个线程池
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey(hystrixCommand.groupName()))
                .andCommandKey(HystrixCommandKey.Factory.asKey(methodName))
                // 超时时间
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(5000)
                        .withCircuitBreakerEnabled(true).withCircuitBreakerRequestVolumeThreshold(50)// 一个统计窗口内熔断触发的最小个数
                        .withCircuitBreakerSleepWindowInMilliseconds(1000)
                        .withCircuitBreakerErrorThresholdPercentage(50)
                        .withFallbackIsolationSemaphoreMaxConcurrentRequests(50)
                        .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
                        .withMetricsHealthSnapshotIntervalInMilliseconds(5000))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("server_thread"))
                .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter().withCoreSize(10)
                        .withMaxQueueSize(500).withQueueSizeRejectionThreshold(350))
        );
        this.pjp = pjp;
        this.className = className;
        this.methodName = methodName;
        this.hystrixCommand = hystrixCommand;
    }


    @Override
    protected Object run() throws Exception {
        try {
            return pjp.proceed();
        } catch (Throwable t) {
            throw new Exception(t);
        }
    }

    @Override
    protected Result<T> getFallback() {
        LOGGER.info(className + ":HystrixCommand===========server=======fallback!!!!!!!!!!!! the executed method is:" + methodName);
        return ResultFactory.failure();
    }
}
