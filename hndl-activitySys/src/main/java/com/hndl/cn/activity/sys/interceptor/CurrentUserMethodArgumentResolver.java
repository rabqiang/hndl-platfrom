package com.hndl.cn.activity.sys.interceptor;

import com.hndl.cn.activity.sys.exception.ActivitySysException;
import com.hndl.cn.activity.sys.exception.ActivitySysExceptionEnums;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.annotation.Resource;


/**
 * @Classname 赵俊凯
 * @Description 增加方法注入，将含有 @CurrentUser 注解的方法参数注入当前登录用户
 * @Date 2019/3/14 16:50
 * @Created by 湖南达联
 */

public class CurrentUserMethodArgumentResolver implements HandlerMethodArgumentResolver {

    private static final Logger log = LoggerFactory.getLogger(CurrentUserMethodArgumentResolver.class);

    @Resource
    private CommonUserInfoManager commonUserInfoManager;


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return parameter.hasParameterAnnotation(CurrentUser.class);
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        Long userId = (Long) webRequest.getAttribute(BaseConstants.REQUEST_LOGIN_USER_ID_KET, RequestAttributes.SCOPE_REQUEST);
        if (userId != null) {
            Long nowTime = System.currentTimeMillis();
            CommonUserInfoDo commonUserInfoDo = commonUserInfoManager.findUserByUniId(userId);
            log.info("开始查询 enums  耗时:"  + (System.currentTimeMillis() - nowTime));
           if(commonUserInfoDo == null){
               log.info("token user_id : " + userId);
               throw new ActivitySysException(ActivitySysExceptionEnums.ACTIVITY_SYS_USER_NOT_FIND_EX.getCode());
           }else {
                return commonUserInfoDo;
           }
        }
       return null;
    }
}
