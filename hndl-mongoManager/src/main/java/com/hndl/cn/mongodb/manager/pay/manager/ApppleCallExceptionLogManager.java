package com.hndl.cn.mongodb.manager.pay.manager;

import com.hndl.cn.mongodb.manager.pay.bean.AppleCallLogDo;

/**
 * @program:hndl-platform
 * @description:TODO 苹果支付异常回调日志
 * @author: 易成贤
 * @create: 2019/8/5 21:14
 * @Created by湖南达联
 **/
public interface ApppleCallExceptionLogManager {
    /**
     * 插入苹果回调日志
     * @param userUniId
     * @param orderId
     * @param data
     */
    void insertApppleCallLog( Long userUniId,Long orderId,String data);

    /**
     * 根据用户和本地订单号查询补单日志
     * @param userUniId
     * @param localOrder
     * @return
     */
    AppleCallLogDo findApppleCallExceptionLog(Long userUniId, Long localOrder);
}
