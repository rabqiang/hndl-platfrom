package com.hndl.cn.mghd.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@ComponentScans({
        @ComponentScan("com.hndl.cn.mysql"),
        @ComponentScan("com.hndl.cn.mongodb"),
        @ComponentScan("com.hndl.cn.nosql"),
        @ComponentScan("com.hndl.cn.ali.oss"),
        @ComponentScan("com.hndl.cn.utils.spring"),
//        @ComponentScan("com.hndl.cn.base.plugin.snowflakeid.service")
})
@MapperScan(basePackages = "com.hndl.cn.dao.*.mapper")
@EnableAsync
@PropertySource(value={"file:${HndlConfig}/mghd_sys.properties"},ignoreResourceNotFound= true)
public class MghdSysApplication {

    private static final Logger log = LoggerFactory.getLogger(MghdSysApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(MghdSysApplication.class, args);
        log.info("====================MghdSysApplication启动成功============================");
    }



}
