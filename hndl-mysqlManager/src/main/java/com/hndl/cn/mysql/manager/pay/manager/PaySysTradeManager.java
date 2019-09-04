package com.hndl.cn.mysql.manager.pay.manager;

import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayStatusEnum;
import com.hndl.cn.dao.pay.bean.PaySysTradeDo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program:hndl-platform
 * @description: 支付交易记录
 * @author: 易成贤
 * @create: 2019-06-28 14:10
 * @Created by湖南达联
 **/
public interface PaySysTradeManager {
    /**
     * 查询订单
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param useUniId 用户id
     * @param payChannelEnums 支付/消费渠道
     * @param payStatusEnum 订单状态
     * @return
     */
    List<PaySysTradeDo> findPaySysTrade(Long startTime, Long endTime, Long useUniId, PayChannelEnums payChannelEnums,PayStatusEnum payStatusEnum,@NotNull Integer pageNo);

    /**
     * 查询总金额
     * @param startTime
     * @param endTime
     * @param useUniId
     * @param payChannelEnums
     * @param payStatusEnum
     * @return
     */
    Long findPaySysCount(Long startTime, Long endTime, Long useUniId,  PayChannelEnums payChannelEnums, PayStatusEnum payStatusEnum);


    /**
     * 生成订单
     * @param userId 用户id
     * @param moneyNumber  支付金额
     * @param payChannelEnums 支付方式
     * @return
     */
    boolean insertPayTrade(Long userId,Long localTradeNo,String remoteTradeNo, Long  moneyNumber,String sign,PayChannelEnums payChannelEnums);


    /**
     * 生成订单
     * @param userId 用户id
     * @param moneyNumber  支付金额
     * @return
     */
    boolean insertApplePayTrade(Long userId,Long localTradeNo,String remoteTradeNo, Long  moneyNumber,String oldMoney);


    /**
     * 订单编号查询订单
     * @param localTradeNo 订单编号
     * @param payChannelEnums 支付方式
     * @return
     */
    PaySysTradeDo findTradeByLocalTradeNo(Long localTradeNo, PayChannelEnums payChannelEnums);


    /**
     * 修改订单状态
     * @param tradeNo
     * @return
     */
    boolean updatePayState(Long tradeNo, String remoteTradeNo, PayChannelEnums payChannelEnums, PayStatusEnum payStatusEnum);
}
