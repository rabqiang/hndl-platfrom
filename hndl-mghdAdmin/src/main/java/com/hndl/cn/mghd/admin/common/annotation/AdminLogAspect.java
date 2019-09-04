package com.hndl.cn.mghd.admin.common.annotation;
import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.mongodb.manager.admin.bean.AdminRequestLog;
import com.hndl.cn.mongodb.manager.admin.manager.AdminRequestLogManager;
import com.hndl.cn.utils.request.RequestUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 20:59
 * @Created by 湖南达联
 */
@Aspect
@Component
public class AdminLogAspect {

    private final Logger logger = LoggerFactory.getLogger(AdminLogAspect.class);

    @Resource
    private AdminRequestLogManager adminRequestLogManager;

    @Pointcut(value = "@annotation(com.hndl.cn.mghd.admin.common.annotation.AdminLog)")
    public void logPointCut() {
    }

    @Before("logPointCut()")
    public void doBefore(JoinPoint joinPoint){

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();

        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();

        AdminRequestLog adminRequestLog = new AdminRequestLog();
        adminRequestLog.setAdminUserId(loginUser == null ? 0L : loginUser.getId());
        adminRequestLog.setRequestUrl(RequestUtil.getRequestPath(request));
        adminRequestLog.setIp(RequestUtil.getClientIP(request));
        Object[] args = joinPoint.getArgs();
        List<Object> argss = Arrays.stream(args).filter(bean -> !(bean instanceof HttpServletRequest) && !(bean instanceof HttpServletResponse))
                .collect(Collectors.toList());
        adminRequestLog.setArgs(JSONObject.toJSONString(argss));
        adminRequestLogManager.addLog(adminRequestLog);
    }
}
