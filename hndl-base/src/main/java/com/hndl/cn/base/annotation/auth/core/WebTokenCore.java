package com.hndl.cn.base.annotation.auth.core;


import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.bean.UserAuthLogin;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.utils.cookie.CookieUtil;
import com.hndl.cn.utils.jwt.JwtTokenUtil;
import com.hndl.cn.utils.request.RequestUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/14 16:03
 * @Created by 湖南达联
 */

public class WebTokenCore {

    private HttpServletRequest request;

    private HttpServletResponse response;

    private Object handler;

    public WebTokenCore(HttpServletRequest request,HttpServletResponse response,Object handler){
        this.request = request;
        this.response = response;
        this.handler = handler;
    }


    public  boolean jwtTokenAuthPassport()throws Exception{
        //判断方法上是否有注解
        if (handler.getClass().isAssignableFrom(HandlerMethod.class)) {
            AuthPassport authPassport = ((HandlerMethod) handler).getMethodAnnotation(AuthPassport.class);

            //判断是否需要登陆权限
            if(authPassport == null || (authPassport.validate() == false && StringUtils.isBlank(RequestUtil.getRequestHeaderByKey(request,BaseConstants.JWT_TOKEN_COOKIE_KEY)))){
                return true;
            }else {
                //校验是否登陆逻辑

//                Cookie[] cookies = request.getCookies();

                //取出cookie的token
//                String token = CookieUtil.getCookieByKey(cookies,BaseConstants.JWT_TOKEN_COOKIE_KEY);

                String token =  RequestUtil.getRequestHeaderByKey(request,BaseConstants.JWT_TOKEN_COOKIE_KEY);

//                token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJib2R5Ijoie1wibG9naW5Vc2VySWRcIjoxMDEwNCxcInRpbWVPdXRcIjoxNTUzMDgzMTA5ODYyfSJ9.XEwn-enkN4OhFzBtCPBX5ej4z1FZmq52-8RKIiFlS0A";

                if(StringUtils.isBlank(token)){
                    //返回错误信息
                    responseWriterErrorMsg(response,PublicExceptionCodeEnum.EX_USER_NOT_LOGIN_ERROR);
                    return false;
                }

                //jwt解密
                String jsonObj;
                try{
                    jsonObj  =  JwtTokenUtil.decryption(token,BaseConstants.JWT_TOKEN_KEY);
                }catch (Exception e){
                    //解密失败，返回失败
                    responseWriterErrorMsg(response,PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST);
                    return false;
                }

                //转对象
                UserAuthLogin userAuthLogin =  JSONObject.parseObject(jsonObj,UserAuthLogin.class);

                if(userAuthLogin == null ||
                        userAuthLogin.getTimeOut() < System.currentTimeMillis()){
                    //解密失败，返回失败
                    responseWriterErrorMsg(response,PublicExceptionCodeEnum.EX_USER_NOT_LOGIN_ERROR);
                    return false;
                }

                //重置登陆时间
//                userAuthLogin.setTimeOut(System.currentTimeMillis() + BaseConstants.JWT_TOKEN_VALID_TIME);

//                String newToken = JwtTokenUtil.createToken(JSONObject.toJSONString(userAuthLogin),BaseConstants.JWT_TOKEN_KEY);

//                CookieUtil.setCookieByKey(cookies,BaseConstants.JWT_TOKEN_COOKIE_KEY,newToken);

                //用户信息id

                request.setAttribute(BaseConstants.REQUEST_LOGIN_USER_ID_KET,userAuthLogin.getLoginUserId());
//                System.out.println(userAuthLogin.toString());

            }
        }
        return true;

    }

    public static void main(String[] args) throws Exception{
        UserAuthLogin userAuthLogin = new UserAuthLogin();
        userAuthLogin.setLoginUserId(229667836187037696l);
        userAuthLogin.setTimeOut(System.currentTimeMillis() +  1000000000L);
        String json = JSONObject.toJSONString(userAuthLogin);
        System.out.println(json);
        String token = JwtTokenUtil.createToken(json,BaseConstants.JWT_TOKEN_KEY);
        System.out.println(token);
//        String jsonData = JwtTokenUtil.decryption("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJib2R5Ijoie1wibG9naW5Vc2VySWRcIjoyMjk2Njc2MTQ1MDU0ODgzODUsXCJ0aW1lT3V0XCI6MTU2MjMzMjU3NzkxOH0ifQ.lx23olCggQX_DqJteMqCRQX9W7CGBOoru36EqjnrVyg",BaseConstants.JWT_TOKEN_KEY);
//        System.out.println(jsonData);

    }


    /**
     * 返回前台错误信息
     */
    public static void responseWriterErrorMsg(HttpServletResponse response,PublicExceptionCodeEnum publicExceptionCodeEnum){
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
}