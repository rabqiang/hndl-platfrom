package com.hndl.cn.chat.sys.easemob;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description 环信配置类
 * @Date 2019/3/21 13:22
 * @Created by 湖南达联
 */
@Getter
@Component
public class OrgInfoConfig {

    private static final Logger log = LoggerFactory.getLogger(OrgInfoConfig.class);

    private String orgName;

    private String appName;

    private String grantType;

    private String clientId;

    private String clientSecret;

    private String seaemobServerUrl;

    private String roomMasterId;


    @Resource
    private ApplicationContext applicationContext; //注入applicationContext

    @PostConstruct
    public void run(){
        //获取Environment与此组件关联的内容，利用Environment获取给定key关联的属性值，或者null无法解析key
        orgName = applicationContext.getEnvironment().getProperty("org_name"); //环信名称
        appName = applicationContext.getEnvironment().getProperty("app_name"); //app名称
        grantType = applicationContext.getEnvironment().getProperty("grant_type");
        clientId = applicationContext.getEnvironment().getProperty("client_id");
        clientSecret = applicationContext.getEnvironment().getProperty("client_secret");
        seaemobServerUrl = applicationContext.getEnvironment().getProperty("easemob_server_url");
        roomMasterId = applicationContext.getEnvironment().getProperty("room_master_id");

        /*orgName = BasePropertiesUtil.getPropertyValue("org_name");
         appName = BasePropertiesUtil.getPropertyValue("app_name");
        grantType = BasePropertiesUtil.getPropertyValue("grant_type");
        clientId = BasePropertiesUtil.getPropertyValue("client_id");
        clientSecret = BasePropertiesUtil.getPropertyValue("client_secret");
        seaemobServerUrl = BasePropertiesUtil.getPropertyValue("easemob_server_url");
        roomMasterId = BasePropertiesUtil.getPropertyValue("room_master_id");*/
        log.info("==========================OrgInfoConfig 配置成功============================================");

    }
}
