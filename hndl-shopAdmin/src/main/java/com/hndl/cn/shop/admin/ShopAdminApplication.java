package com.hndl.cn.shop.admin;

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
        @ComponentScan("com.hndl.cn.nosql"),
        @ComponentScan("com.hndl.cn.mysql"),
        @ComponentScan("com.hndl.cn.ali.oss"),
        @ComponentScan("com.hndl.cn.utils.spring"),
        @ComponentScan("com.hndl.cn.mongodb"),
})
@MapperScan(basePackages = "com.hndl.cn.dao.*.mapper")
@PropertySource(value={"file:${HndlConfig}/shop_admin.properties"})
public class ShopAdminApplication {
    private static final Logger log = LoggerFactory.getLogger(ShopAdminApplication.class);

    public static void main(String[] args) {

        SpringApplication.run(ShopAdminApplication.class, args);
        log.info("=================== [ShopAdminApplication 启动成功]=================================");
    }

}
