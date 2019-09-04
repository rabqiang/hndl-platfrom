package com.hndl.cn.pay.sys.interceptor;

import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.constants.BaseConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;



/**
 * @Classname 赵俊凯
 * @Description 增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 * @Date 2019/3/14 16:50
 * @Created by 湖南达联
 */

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger log = LoggerFactory.getLogger(CurrentUserMethodArgumentResolver.class);



    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    /**
     *
     * @param parameter
     * @param mavContainer
     * @param webRequest
     * @param binderFactory
     * @return
     * @throws Exception
     */
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Long userId = (Long) webRequest.getAttribute(BaseConstants.REQUEST_LOGIN_USER_ID_KET, RequestAttributes.SCOPE_REQUEST);
        //这里只获取用户id
        if (userId != null) {
           return  userId;
        }else {
            throw new MissingServletRequestPartException(BaseConstants.REQUEST_LOGIN_USER_ID_KET);
        }
    }
}
