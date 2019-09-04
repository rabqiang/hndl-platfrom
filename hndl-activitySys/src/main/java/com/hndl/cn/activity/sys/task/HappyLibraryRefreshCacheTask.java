package com.hndl.cn.activity.sys.task;

import com.hndl.cn.activity.sys.business.library.service.HappyLibraryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description 自动刷新缓存task
 * @Date 2019/3/31 18:19
 * @Created by 湖南达联
 */
@Component
public class HappyLibraryRefreshCacheTask {

    private static final Logger log = LoggerFactory.getLogger(HappyLibraryRefreshCacheTask.class);

//    @Resource
//    private HappyLibraryService happyLibraryService;
//
//
//
//    @Scheduled(cron="0 0/3 * * * ?")
//    public void happyLibraryRefreshCache(){
//        happyLibraryService.happyLibraryRefreshCache();
//        log.info("===================HappyLibraryRefreshCacheTask task 成功============================");
//    }

}
