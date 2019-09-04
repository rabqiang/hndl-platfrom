package com.hndl.cn.ali.mq.configuration;

import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author 赵俊凯
 * @Description RocketMQ 配置
 * @Date 2019/4/24 14:14
 * @Created by 湖南达联
 */
@Configuration
public class RocketMQConfiguration {

    private static final Logger log = LoggerFactory.getLogger(RocketMQConfiguration.class);

    /**
     * 为了确保配置文件属性读取生效 getEnvironment 的方式注入Properties属性
     */
    @Resource
    private ApplicationContext applicationContext; //注入applicationContext


    /**
     * 初始化Properties
     * @return
     */
    @Bean
    public Properties initRocketMQProperties(){
        Environment environment = applicationContext.getEnvironment();
        Properties properties = new Properties();
        String accessKey = environment.getProperty("spring.boot.rocket.mq.access.key");
        if(StringUtils.isBlank(accessKey)){
            log.error("properties spring.boot.rocket.access.key value is not null! spring.boot.rocket.access.key ：{} ",accessKey);
            System.exit(0);
        }
        properties.put(PropertyKeyConst.AccessKey,accessKey);
        String secretKey = environment.getProperty("spring.boot.rocket.mq.secret.key");

        if(StringUtils.isBlank(secretKey)){
            log.error("properties spring.boot.rocket.mq.secret.key value is not null! spring.boot.rocket.mq.secret.key：{} ",accessKey);
            System.exit(0);
        }
        properties.put(PropertyKeyConst.SecretKey,secretKey);

        String timeOut = environment.getProperty("spring.boot.rocket.mq.send.msg.time.out.millis");

        if(StringUtils.isBlank(timeOut)){
            log.error("properties spring.boot.rocket.mq.send.msg.time.out.millis value is not null! spring.boot.rocket.mq.send.msg.time.out.millis：{} ",timeOut);
            System.exit(0);
        }
        properties.put(PropertyKeyConst.SendMsgTimeoutMillis,timeOut);
        String namesrvAddr = environment.getProperty("spring.boot.rocket.mq.namesrv.addr");
        if(StringUtils.isBlank(namesrvAddr)){
            log.error("properties spring.boot.rocket.mq.namesrv.addr value is not null! spring.boot.rocket.mq.namesrv.addr：{} ",timeOut);
            System.exit(0);
        }
        properties.put(PropertyKeyConst.NAMESRV_ADDR,namesrvAddr);
        log.info("================initRocketMQProperties成功====================");
        return properties;
    }


}
