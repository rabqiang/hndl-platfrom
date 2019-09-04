package com.hndl.cn.mghd.sys.business.wechat.controller;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.message.wechat.enums.WechatCustomerEnums;
import com.hndl.cn.mghd.sys.business.wechat.service.WechatMsgService;
import com.hndl.cn.utils.http.HttpServletResponseUtil;
import com.hndl.cn.utils.request.RequestUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/23 16:00
 * @Created by 湖南达联
 */
@Controller
@RequestMapping("/{source}/wechatMsg")
public class WechatMsgController {

    private static final Logger log = LoggerFactory.getLogger(WechatMsgController.class);

    @Resource
    private WechatMsgService wechatMsgService;


    /**
     * 微信消息通知-请求校验（确认请求来自微信服务器）
     *
     * @return
     */
    @RequestMapping(value = "/signature")
    public void signature(HttpServletRequest request, HttpServletResponse response) {

        boolean isGet = request.getMethod().toLowerCase().equals("get");
        PrintWriter writer = null;
        if(isGet){
            //验证
            wechatMsgService.signature(request, response);
        }else {
            //发送消息
            wechatMsgService.receiveMsg(request, response);
        }
    }



}