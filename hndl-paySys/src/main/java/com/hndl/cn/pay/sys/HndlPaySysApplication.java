package com.hndl.cn.pay.sys;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@ComponentScans({
        @ComponentScan("com.hndl.cn.mysql"),
        @ComponentScan("com.hndl.cn.pay.sys"),
        @ComponentScan("com.hndl.cn.nosql"),
        @ComponentScan("com.hndl.cn.utils.spring"),
        @ComponentScan("com.hndl.cn.base.plugin.snowflakeid.service"),
})
@MapperScan(basePackages = "com.hndl.cn.dao.**.mapper")
@PropertySource(value={"file:${HndlConfig}/pay_sys.properties"})
public class HndlPaySysApplication {

    private static final Logger log = LoggerFactory.getLogger(HndlPaySysApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(HndlPaySysApplication.class, args);
        log.info("===================HndlPaySysApplication 启动成功=============================");
    }

}
