package com.hndl.cn.shop.sys;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ComponentScans({
        @ComponentScan("com.hndl.cn.mysql"),
        @ComponentScan("com.hndl.cn.mongodb"),
        @ComponentScan("com.hndl.cn.nosql"),
        @ComponentScan("com.hndl.cn.utils.spring"),
})
@MapperScan(basePackages = "com.hndl.cn.dao.*.mapper")
@EnableAsync
@PropertySource(value={"file:${HndlConfig}/shop_sys.properties"},ignoreResourceNotFound= true)
@Slf4j
@EnableScheduling
public class ShopSysApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopSysApplication.class, args);
        log.info("=================== [ShopSysApplication 启动成功]=================================");
    }

}
