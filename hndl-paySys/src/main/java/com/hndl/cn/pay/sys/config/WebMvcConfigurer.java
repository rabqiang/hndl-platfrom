package com.hndl.cn.pay.sys.config;

import com.hndl.cn.pay.sys.interceptor.CurrentUserMethodArgumentResolver;
import com.hndl.cn.pay.sys.interceptor.LoginInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description  注册登陆拦截器
 * @Date 2019/3/14 14:36
 * @Created by 湖南达联
 */
@Configuration
public class WebMvcConfigurer extends WebMvcConfigurationSupport {

    private static final Logger log = LoggerFactory.getLogger(WebMvcConfigurer.class);

    @Resource
    private LoginInterceptor loginInterceptor;



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
        super.addInterceptors(registry);
        log.info("========================loginInterceptor注册成功===================================");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
    }


    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

}
