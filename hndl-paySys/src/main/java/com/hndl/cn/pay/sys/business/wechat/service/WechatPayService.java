package com.hndl.cn.pay.sys.business.wechat.service;

import com.hndl.cn.base.result.Result;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/4/11 19:38
 * @Created by 湖南达联
 */
public interface WechatPayService {


    /**
     * 微信支付预下单接口
     * @return
     */
    Result<Object> preOrderByWechatPay(Long userId,Long orderNumber);


    /**
     * 小程序下单
     * @param userId
     * @param orderNumber
     * @return
     */
    Result<Object> preOrderByWechatAppletsPay(Long userId,Long orderNumber,String openId);


    /**
     * 公众号下单
     * @param userOldId
     * @param orderNumber
     * @param openId
     * @return
     */
    Result<Object> preOrderByWechatSubscriptionPay(Long userOldId,Long orderNumber,String openId);


    /**
     * 微信回调方法
     * @return
     */
    String callBack(Map<String,String> map);
}
