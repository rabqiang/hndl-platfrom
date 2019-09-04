package com.hndl.cn.mghd.admin.shiro;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.common.constants.MgdAdminConstants;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.utils.http.HttpServletResponseUtil;
import com.hndl.cn.utils.request.RequestUtil;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Set;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 16:24
 * @Created by 湖南达联
 */
@Component
public class AuthPowerInterceptor extends HandlerInterceptorAdapter {

    private static final Logger log = LoggerFactory.getLogger(AuthPowerInterceptor.class);


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpServletResponseUtil.initHttpResponse(response);
        String requestPath = RequestUtil.getRequestPath(request);

        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();

        //每次请求重置过期时间
        if(loginUser != null){
            SecurityUtils.getSubject().getSession().setTimeout(MgdAdminConstants.DEFAULT_SESSION_TIME_OUT);
        }

        //判断方法上是否有注解
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            AuthPower authPower = ((HandlerMethod) handler).getMethodAnnotation(AuthPower.class);
            //不需要验证权限
            if(authPower == null){
                return true;
            }
            Set<String> loginUserPermission = AdminUtil.getLoginUserPermission();



            boolean auth = false;

            if(authPower.isLikeAuth()){
                for(String str : loginUserPermission){
                    if(requestPath.contains(str)){
                        auth =  true;
                        break;
                    }
                }
            }else {
                //这本是权限粒度到按钮
                for(String str : loginUserPermission){
                    if(requestPath.equals(str)){
                        auth =  true;
                        break;
                    }
                }
            }
            if(!auth){
                responseWriterErrorMsg(response,PublicExceptionCodeEnum.EX_JURISDICTION_LESS);
            }
            return auth;
        }
        return true;
    }



    /**
     * 返回前台错误信息
     */
    private static void responseWriterErrorMsg(HttpServletResponse response, PublicExceptionCodeEnum publicExceptionCodeEnum){
        PrintWriter out = null;
        try {
            out = response.getWriter();
            Result<Object> rs = ResultFactory.failure(publicExceptionCodeEnum.getCode(),
                    publicExceptionCodeEnum.getMsg());
            out.append(JSONObject.toJSONString(rs));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }

    }

    public static void main(String[] args) {
        String str = "/happyCoinBill";
        String[] split = str.split("/");
        System.out.println(split.length);
        for(String string : split){
            System.out.println(string);
        }
    }
}
