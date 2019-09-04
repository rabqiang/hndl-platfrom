package com.hndl.cn.ali.mq.producer.configuration;

import com.aliyun.openservices.ons.api.bean.ProducerBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;
import java.util.Properties;

/**
 * @author 赵俊凯
 * @Description 消息生产者配置
 * @Date 2019/4/24 15:39
 * @Created by 湖南达联
 */
@Configuration
public class ProducerConfiguration {

    private static final Logger log = LoggerFactory.getLogger(ProducerConfiguration.class);

    @Resource
    private Properties properties;

    @Bean(initMethod="start",destroyMethod="shutdown")
    public ProducerBean initProducerBean(){
        ProducerBean producerBean = new ProducerBean();
        producerBean.setProperties(properties);
        log.info("=============producerBean init成功=================");
        return producerBean;
    }
}
