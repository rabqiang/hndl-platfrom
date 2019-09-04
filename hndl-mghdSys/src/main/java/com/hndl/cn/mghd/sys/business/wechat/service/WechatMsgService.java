package com.hndl.cn.mghd.sys.business.wechat.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/26 15:26
 * @Created by 湖南达联
 */
public interface WechatMsgService {


    /**
     * 验证
     * @param request
     * @param response
     */
    void signature(HttpServletRequest request, HttpServletResponse response);


    /**
     * 接收消息
     * @param request
     * @param response
     */
    void receiveMsg(HttpServletRequest request, HttpServletResponse response);

}
