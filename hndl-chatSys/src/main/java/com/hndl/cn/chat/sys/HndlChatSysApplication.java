package com.hndl.cn.chat.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.hndl.cn.chat.sys"),
        @ComponentScan("com.hndl.cn.nosql.mongodb"),
        @ComponentScan("com.hndl.cn.mongodb"),
        @ComponentScan("com.hndl.cn.nosql.redis"),
        @ComponentScan("com.hndl.cn.dao"),
        @ComponentScan("com.hndl.cn.mysql"),
        @ComponentScan("com.hndl.cn.base.plugin.snowflakeid.service")})
@MapperScan(basePackages = "com.hndl.cn.dao.**.mapper")
@PropertySource(value={"file:${HndlConfig}/chat_sys.properties"})
public class HndlChatSysApplication {

    private static final Logger log = LoggerFactory.getLogger(HndlChatSysApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HndlChatSysApplication.class,args);
        log.info("===========================HndlChatSysApplication启动成功==================================");
    }

}
