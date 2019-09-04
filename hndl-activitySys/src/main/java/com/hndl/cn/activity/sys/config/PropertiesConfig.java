package com.hndl.cn.activity.sys.config;

import com.hndl.cn.base.properties.BasePropertiesUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

/**
 * @Classname 赵俊凯
 * @Description 读取spring 配置文件的bean,可以不依赖spring注入
 * @Date 2019/3/20 17:46
 * @Created by 湖南达联
 */
@Configuration
public class PropertiesConfig {


    @Bean
    public BasePropertiesUtil builderPropertiesUtil(){
        String path = System.getenv().get("HndlConfig") +"/activity_sys.properties";
        BasePropertiesUtil basePropertiesUtil = new BasePropertiesUtil();
        Resource resource = new FileSystemResource(path);
        basePropertiesUtil.setLocations(resource);
//        basePropertiesUtil.setFileEncoding("UTF-8");
        return basePropertiesUtil;
    }
}
