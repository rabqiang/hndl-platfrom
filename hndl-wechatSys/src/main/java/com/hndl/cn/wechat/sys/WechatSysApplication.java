package com.hndl.cn.wechat.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@ComponentScans({@ComponentScan("com.hndl.cn.wechat.sys"),
        @ComponentScan("com.hndl.cn.dao"),
        @ComponentScan("com.hndl.cn.nosql.redis"),
        @ComponentScan("com.hndl.cn.base.plugin.snowflakeid.service")})
@MapperScan(basePackages = "com.hndl.cn.dao.**.mapper")
@PropertySource(value={"file:${HndlConfig}/wechat.properties"})
public class WechatSysApplication {


    public static void main(String[] args) {
        SpringApplication.run(WechatSysApplication.class, args);
    }

}
