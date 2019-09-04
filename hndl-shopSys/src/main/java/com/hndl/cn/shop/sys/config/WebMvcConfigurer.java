package com.hndl.cn.shop.sys.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.hndl.cn.mysql.manager.prize.manager.LuckyTurntableManager;
import com.hndl.cn.shop.sys.interceptor.CurrentUserMethodArgumentResolver;
import com.hndl.cn.shop.sys.interceptor.LoginInterceptor;
import com.hndl.cn.shop.sys.task.LuckyTurntableTask;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
@Slf4j
public class WebMvcConfigurer extends WebMvcConfigurationSupport {



    @Resource
    private LoginInterceptor loginInterceptor;

    @Resource
    LuckyTurntableManager luckyTurntableManager;


    @Bean
    public LuckyTurntableConfig initluckyDraw(){
     return new LuckyTurntableConfig(luckyTurntableManager);
    }

    @Bean
    public LuckyTurntableTask flushPrize(){

        LuckyTurntableTask luckyTurntableTask = new LuckyTurntableTask();
        log.info("========================定时刷新奖品配置完成！================");
        return luckyTurntableTask;

    }



    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**");
        log.info("========================loginInterceptor注册成功===================================");

        super.addInterceptors(registry);
        log.info("========================InterceptorRegistry注册成功===================================");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");

        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentUserMethodArgumentResolver());
    }


    @Bean
    public CurrentUserMethodArgumentResolver currentUserMethodArgumentResolver() {
        return new CurrentUserMethodArgumentResolver();
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(this.longToStringConverter());
    }

    @Bean
    public MappingJackson2HttpMessageConverter longToStringConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addSerializer(Long.class, ToStringSerializer.instance);
        simpleModule.addSerializer(Long.TYPE, ToStringSerializer.instance);
        mapper.registerModule(simpleModule);
        converter.setObjectMapper(mapper);
        return converter;
    }

}
