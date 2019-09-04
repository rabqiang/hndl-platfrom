package com.hndl.cn.pay.sys.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/27 16:08
 * @Created by 湖南达联
 */
@Configuration
public class RfcConfig {

    @Value("${server.http.parser.request.target.allow}")
    private String targetAllow;

    @Bean
    public Integer setRfc()
    {
        System.setProperty("tomcat.util.http.parser.HttpParser.requestTargetAllow", targetAllow);
        return 0;
    }

}
