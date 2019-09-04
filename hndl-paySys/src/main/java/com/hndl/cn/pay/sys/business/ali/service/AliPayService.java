package com.hndl.cn.pay.sys.business.ali.service;

import com.hndl.cn.base.result.Result;

import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/20 10:58
 * @Created by 湖南达联
 */
public interface AliPayService {


    /**
     * 支付宝支付预下单
     * @param userId
     * @param orderNumber
     * @return
     */
    Result<Object> preOrderByAliPay(Long userId, Long orderNumber);


    /**
     * 支付宝回调处理
     * @param map
     * @return
     */
    String callBack(Map<String,String> map);
}
