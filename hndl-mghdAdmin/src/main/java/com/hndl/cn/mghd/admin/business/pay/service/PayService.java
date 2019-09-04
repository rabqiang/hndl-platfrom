package com.hndl.cn.mghd.admin.business.pay.service;

import com.hndl.cn.base.result.Result;

import java.util.Map;

/**
 * @program:hndl-platform
 * @description:TODO 支付管理
 * @author: 易成贤
 * @create: 2019/7/1 14:07
 * @Created by湖南达联
 **/
public interface PayService {
    /**
     * 查询订单信息
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param useUniId 用户id
     * @param channelType 支付类型
     * @param payStatus 支付状态
     * @param pageNo 当前页
     * @return
     */
    Result<Map<String,Object>> findPaySysTrade(Long startTime, Long endTime, Long useUniId, Integer channelType, Integer payStatus, Integer pageNo);

    /**
     * 查询支付渠道
     * @return
     */
    Result findPayChannel();

    /**
     * 查询支付状态
     * @return
     */
    Result findPayStatus();

    /**
     * 苹果补单
     * @return
     */
    Result appleReplacementOrder();
}
