package com.hndl.cn.pay.sys.interceptor;

import com.hndl.cn.base.annotation.auth.core.WebTokenCore;
import com.hndl.cn.utils.http.HttpServletResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Classname 赵俊凯
 * @Description
 * @Date 2019/3/14 12:02
 * @Created by 湖南达联
 */
@Component
public class LoginInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //初始化定义
        HttpServletResponseUtil.initHttpResponse(response);
        WebTokenCore webTokenCore = new WebTokenCore(request,response,handler);

        return webTokenCore.jwtTokenAuthPassport();

    }





}
