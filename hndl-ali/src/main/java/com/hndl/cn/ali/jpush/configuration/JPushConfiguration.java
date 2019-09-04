package com.hndl.cn.ali.jpush.configuration;

import cn.jpush.api.JPushClient;
import com.hndl.cn.ali.mq.configuration.RocketMQConfiguration;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/5 17:31
 * @Created by 湖南达联
 */
@Configuration
public class JPushConfiguration {

    private static final Logger log = LoggerFactory.getLogger(JPushConfiguration.class);

    /**
     * 为了确保配置文件属性读取生效 getEnvironment 的方式注入Properties属性
     */
    @Resource
    private ApplicationContext applicationContext; //注入applicationContext




    @Bean
    public JPushClient initJPushClient(){

         Environment environment = applicationContext.getEnvironment();
         String masterSecret = environment.getProperty("spring.boot.jpush.master.secret");
         if(StringUtils.isBlank(masterSecret)){
             log.error("==============spring.boot.jpush.master.secret:{}=========================",masterSecret);
             System.exit(0);
         }

         String appKey = environment.getProperty("spring.boot.jpush.app.key");
         if(StringUtils.isBlank(appKey)){
             log.error("==============spring.boot.jpush.app.key:{}=========================",appKey);
             System.exit(0);
         }
         return new JPushClient(masterSecret,appKey);
    }

}
