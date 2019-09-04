package com.hndl.cn.mghd.admin.business.pay.service.impl;

import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayStatusEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.pay.bean.PaySysTradeDo;
import com.hndl.cn.mghd.admin.business.pay.service.PayService;
import com.hndl.cn.mghd.admin.business.pay.vo.PayChannelVo;
import com.hndl.cn.mghd.admin.business.pay.vo.PayStatusVo;
import com.hndl.cn.mghd.admin.business.pay.vo.PaySysTradeVo;
import com.hndl.cn.mongodb.manager.pay.manager.ApppleCallExceptionLogManager;
import com.hndl.cn.mysql.manager.pay.manager.PaySysTradeManager;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @program:hndl-platform
 * @description:TODO 支付管理
 * @author: 易成贤
 * @create: 2019/7/1 14:16
 * @Created by湖南达联
 **/
@Service
public class PayServiceImpl implements PayService {

    @Resource
    PaySysTradeManager paySysTradeManager;

    @Resource
    ApppleCallExceptionLogManager apppleCallExceptionLogManager;


    /**
     * 查询订单信息
     *
     * @param startTime   开始时间
     * @param endTime     结束时间
     * @param useUniId    用户id
     * @param channelType 支付类型
     * @param payStatus   支付状态
     * @param pageNo      当前页
     * @return
     */
    private List<PaySysTradeVo> findPayTrade(Long startTime, Long endTime, Long useUniId, Integer channelType, Integer payStatus, Integer pageNo) {

        List<PaySysTradeDo> paySysTrade = paySysTradeManager.findPaySysTrade(startTime, endTime, useUniId, PayChannelEnums.evalVal(channelType), PayStatusEnum.evalVal(payStatus), pageNo);

        return paySysTrade.stream().map(val -> {
            PaySysTradeVo convert = SpringCglibBeanUtils.convert(val, PaySysTradeVo.class);
            convert.setCreateTime(val.getCreateTime().getTime());
            Date callbackTime = val.getCallbackTime();
            if (null != callbackTime) {
                convert.setCallbackTime(callbackTime.getTime());
            }
            if (PayChannelEnums.APPLE_PAY.getChannelType().equals(val.getPayChannel())){
                convert.setMoneyNumber(NumberUtils.toLong(val.getExpand1()));
            }
            return convert;
        }).collect(Collectors.toList());

    }

    /**
     * 查询订单信息
     *
     * @param startTime   开始时间
     * @param endTime     结束时间
     * @param useUniId    用户id
     * @param channelType 支付类型
     * @param payStatus   支付状态
     * @param pageNo      当前页
     * @return
     */
    @Override
    public Result<Map<String, Object>> findPaySysTrade(Long startTime, Long endTime, Long useUniId, Integer channelType, Integer payStatus, Integer pageNo) {

        Map<String, Object> map = new HashMap(2);
        List<PaySysTradeVo> paySysTradeVos = findPayTrade(startTime, endTime, useUniId, channelType, payStatus, pageNo);
        Long MoneyNumberCount = findMoneyNumberCount(startTime, endTime, useUniId, channelType, payStatus);
        map.put("paySysTradeVos", paySysTradeVos);
        map.put("moneyNumberCount", MoneyNumberCount);
        return ResultFactory.success(map);
    }

    /**
     * 查询支付渠道
     *
     * @return
     */
    @Override
    public Result<List<PayChannelVo>> findPayChannel() {
        List<PayChannelVo> list = new ArrayList<>();
        for (PayChannelEnums payChannelEnums : PayChannelEnums.getPayChannel()) {
            PayChannelVo payChannelVo = new PayChannelVo(payChannelEnums.getChannelType(), payChannelEnums.getDescription());
            list.add(payChannelVo);
        }
        return ResultFactory.success(list);
    }

    /**
     * 查询支付状态
     *
     * @return
     */
    @Override
    public Result findPayStatus() {
        List<PayStatusVo> list = new ArrayList<>();
        for (PayStatusEnum payStatusEnum : PayStatusEnum.values()) {
            PayStatusVo payStatusVo = new PayStatusVo(payStatusEnum.getCode(), payStatusEnum.getValue());
            list.add(payStatusVo);
        }
        return ResultFactory.success(list);
    }

    /**
     * 苹果补单
     *
     * @return
     */
    @Override
    public Result appleReplacementOrder() {
        return null;
    }

    /**
     * 查询总金额
     *
     * @param startTime
     * @param endTime
     * @param useUniId
     * @param channelType
     * @param payStatus
     * @return
     */
    private Long findMoneyNumberCount(Long startTime, Long endTime, Long useUniId, Integer channelType, Integer payStatus) {

        Long count = paySysTradeManager.findPaySysCount(startTime, endTime, useUniId, PayChannelEnums.evalVal(channelType), PayStatusEnum.evalVal(payStatus));
        return count;
    }
}
