package com.hndl.cn.shop.sys.interceptor;

import com.hndl.cn.base.annotation.auth.core.WebTokenCore;
import com.hndl.cn.utils.http.HttpServletResponseUtil;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class LoginInterceptor extends HandlerInterceptorAdapter {



    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //初始化定义
        HttpServletResponseUtil.initHttpResponse(response);
        WebTokenCore webTokenCore = new WebTokenCore(request,response,handler);

        return webTokenCore.jwtTokenAuthPassport();

    }





}
