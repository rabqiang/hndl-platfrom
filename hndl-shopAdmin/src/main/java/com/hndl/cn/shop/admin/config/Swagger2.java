package com.hndl.cn.shop.admin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author 赵俊凯
 * @Description Swagger2 配置
 * @Date 2019/5/8 11:57
 * @Created by 湖南达联
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    @Value("${spring.boot.test.swagger}")
    private Boolean test;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .enable(test)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hndl.cn.shop.admin"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("[ShopAdmin站接口文档]")
                .description("描述")
                .version("1.0")
                .build();
    }
}
