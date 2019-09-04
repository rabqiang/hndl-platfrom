package com.hndl.cn.activity.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.hndl.cn.activity.sys"),
        @ComponentScan("com.hndl.cn.nosql.mongodb"),
        @ComponentScan("com.hndl.cn.mongodb"),
        @ComponentScan("com.hndl.cn.nosql.redis"),
        @ComponentScan("com.hndl.cn.mysql")})
@MapperScan(basePackages = "com.hndl.cn.dao.**.mapper")
@EnableScheduling
@PropertySource(value={"file:${HndlConfig}/activity_sys.properties"})
public class HndlActivitySysApplication {

    private static final Logger log = LoggerFactory.getLogger(HndlActivitySysApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HndlActivitySysApplication.class, args);
        log.info("===============HndlActivitySysApplication 启动成功====================");
    }



//    @Bean
//    public TomcatServletWebServerFactory ServletWebServerFactoryservletContainer(){
//        TomcatServletWebServerFactory tomcatServletWebServerFactory = new TomcatServletWebServerFactory();
//        Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
//        connector.setPort(80);
//        tomcatServletWebServerFactory.addAdditionalTomcatConnectors(connector);
//        log.info("============================" + 80 + "绑定成功=================================");
//        return tomcatServletWebServerFactory;
//    }



}
