package com.hndl.cn.mghd.job;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScans({@ComponentScan("com.hndl.cn.mghd.job"),
        @ComponentScan("com.hndl.cn.mysql"),
        @ComponentScan("com.hndl.cn.mongodb"),
        @ComponentScan("com.hndl.cn.nosql.redis"),
        @ComponentScan("com.hndl.cn.ali.jpush"),
        @ComponentScan("com.hndl.cn.nosql.mongodb"),
        @ComponentScan("com.hndl.cn.base.plugin.snowflakeid.service")})
@MapperScan(basePackages = "com.hndl.cn.dao.*.mapper")
@PropertySource(value={"file:${HndlConfig}/mghd_job.properties"})
public class MghdJobApplication {

    public static void main(String[] args) {
        SpringApplication.run(MghdJobApplication.class, args);
    }

}
