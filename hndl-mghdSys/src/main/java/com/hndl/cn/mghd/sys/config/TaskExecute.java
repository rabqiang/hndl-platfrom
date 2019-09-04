package com.hndl.cn.mghd.sys.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author 赵俊凯
 * @Description 配置线程池
 * @Date 2019/4/24 13:38
 * @Created by 湖南达联
 */
@Configuration
public class TaskExecute {

    /**
     * 配置增加统计数的异步任务线程池
     *
     * @return
     */
    @Bean(name = "StatisticsTaskExecutePool")
    public ThreadPoolTaskExecutor initStatisticsTaskExecutePool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(30);//表示线程池核心线程，正常情况下开启的线程数量。
        executor.setMaxPoolSize(200);//最大线程数
        executor.setQueueCapacity(500);//当核心线程都在跑任务，还有多余的任务会存到此处。
        executor.setKeepAliveSeconds(30);//超时时间
        executor.setThreadNamePrefix("statistics-task-executor");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        executor.initialize();
        return executor;
    }


    /**
     * 配置前台查询Callable的任务线程池
     *
     * @return
     */


    @Bean(name = "CallableExecutePool")
    public ThreadPoolTaskExecutor initCallableExecutePool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50);//表示线程池核心线程，正常情况下开启的线程数量。
        executor.setMaxPoolSize(200);//最大线程数
        executor.setQueueCapacity(500);//当核心线程都在跑任务，还有多余的任务会存到此处。
        executor.setKeepAliveSeconds(30);//超时时间
        executor.setThreadNamePrefix("callable-task-executor");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }


    /**
     * 配置前台一键消息已读的任务线程池
     */


    @Bean(name = "ReadMsgExecutePool")
    public ThreadPoolTaskExecutor ReadMsgExecutePool() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50);//表示线程池核心线程，正常情况下开启的线程数量。
        executor.setMaxPoolSize(200);//最大线程数
        executor.setKeepAliveSeconds(30);//超时时间
        executor.setQueueCapacity(500);//当核心线程都在跑任务，还有多余的任务会存到此处。
        executor.setThreadNamePrefix("readmsg-task-executor");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }
}
