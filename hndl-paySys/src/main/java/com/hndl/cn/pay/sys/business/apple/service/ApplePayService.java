package com.hndl.cn.pay.sys.business.apple.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.enums.pay.ApplePayProductEnums;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/26 11:51
 * @Created by 湖南达联
 */
public interface ApplePayService {


    /**
     * 苹果预下单
     * @param userUniId
     * @return
     */
    Result<Object> preOrderByApplePay(Long userUniId, ApplePayProductEnums applePayProductEnums);


    /**
     * 订单确认
     * @param data
     * @return
     */
    Result<Object> confirmOfOrder(Long userUniId,Long orderId,String data);
}
