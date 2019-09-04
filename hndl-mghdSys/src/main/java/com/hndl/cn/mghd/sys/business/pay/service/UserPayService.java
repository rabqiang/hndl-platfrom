package com.hndl.cn.mghd.sys.business.pay.service;

import com.hndl.cn.base.result.Result;

/**
 * @author 赵俊凯
 * @Description 用户支付service
 * @Date 2019/4/22 11:47
 * @Created by 湖南达联
 */
public interface UserPayService {


    /**
     *  业务系统处理支付系统的回调
     * @param localTradeNo
     * @return
     */
    Result<Object> confirmPayNotice(Integer payChannel,Long localTradeNo);


    /**
     * 确认支付订单
     * @return
     */
    Result<Object> userPayConfirm(Long localTradeNo,Long userUniId);


}
