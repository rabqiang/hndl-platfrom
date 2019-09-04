package com.hndl.cn.mghd.sys.interceptor;

import com.hndl.cn.base.annotation.auth.core.WebTokenCore;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.RequestTypeEnums;
import com.hndl.cn.utils.http.HttpServletResponseUtil;
import com.hndl.cn.utils.string.SensitiveWordFilter;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;
import java.util.Set;

/**
 * @author 赵俊凯
 * @Description 拦截请求来源
 * @Date 2019/4/23 16:29
 * @Created by 湖南达联
 */
@Component
public class RequestSourceInterceptor extends HandlerInterceptorAdapter {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String path = request.getRequestURL().toString();

        if(path.contains("swagger") || path.contains("v2/api-docs")){
           return true;
        }


        //初始化定义
        HttpServletResponseUtil.initHttpResponse(response);


        Map pathVariables = (Map) request.getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);

        String requestType = (String)pathVariables.get("source");

        boolean flag = RequestTypeEnums.checkVal(requestType);

        if(!flag){
            WebTokenCore.responseWriterErrorMsg(response,PublicExceptionCodeEnum.Type_MissMatch_Error);
        }
        return flag;
    }

    public static void main(String[] args) {
//        System.out.println(SensitiveWordFilter.INSTANCE.sensitiveWordMap.size());
        String string = "资龙茂";
        System.out.println("待检测语句字数：" + string.length());
        long beginTime = System.currentTimeMillis();
        boolean flag =  SensitiveWordFilter.INSTANCE.isContaintSensitiveWord(string,SensitiveWordFilter.maxMatchType);
        long endTime = System.currentTimeMillis();
        System.out.println("语句中是否包含敏感词：" + flag);
        System.out.println("总共消耗时间为：" + (endTime - beginTime));
        Set<String> sensitiveWord = SensitiveWordFilter.INSTANCE.getSensitiveWord(string, SensitiveWordFilter.maxMatchType);
        System.out.println(sensitiveWord.size() +" ====== " + sensitiveWord);
        System.out.println(SensitiveWordFilter.INSTANCE.replaceSensitiveWord(string,SensitiveWordFilter.minMatchTYpe));
    }
}
