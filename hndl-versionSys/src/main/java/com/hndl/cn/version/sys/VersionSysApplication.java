package com.hndl.cn.version.sys;

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
        @ComponentScan("com.hndl.cn.dao"),
        @ComponentScan("com.hndl.cn.mysql"),
        @ComponentScan("com.hndl.cn.nosql.redis")})
@MapperScan(basePackages = "com.hndl.cn.dao.*.mapper")

@EnableAsync
@PropertySource(value = {"file:${HndlConfig}/version.properties"})
public class VersionSysApplication {
    private static final Logger log = LoggerFactory.getLogger(VersionSysApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(VersionSysApplication.class, args);

        log.info("====================VersionApplication启动成功============================");
    }
}
