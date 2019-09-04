package com.hndl.cn.mysql.manager.pay.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayStatusEnum;
import com.hndl.cn.dao.pay.bean.PaySysTradeDo;
import com.hndl.cn.dao.pay.bean.PaySysTradeDoExample;
import com.hndl.cn.dao.pay.mapper.PaySysTradeDoMapper;
import com.hndl.cn.mysql.manager.pay.manager.PaySysTradeManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @program:hndl-platform
 * @description: 支付交易
 * @author: 易成贤
 * @create: 2019-06-28 14:11
 * @Created by湖南达联
 **/
@Service
public class PaySysTradeManagerImpl implements PaySysTradeManager {

    @Resource
    PaySysTradeDoMapper paySysTradeDoMapper;
    /**
     * 查询订单
     *
     * @param startTime       开始时间
     * @param endTime         结束时间
     * @param useUniId        用户id
     * @param payChannelEnums 支付/消费渠道
     * @param payStatusEnum   订单状态
     * @return
     */
    @Override
    public List<PaySysTradeDo> findPaySysTrade( Long startTime,  Long endTime, Long useUniId, PayChannelEnums payChannelEnums, PayStatusEnum payStatusEnum,Integer pageNo) {
        PaySysTradeDoExample example = new PaySysTradeDoExample();

        PaySysTradeDoExample.Criteria criteria = example.createCriteria();
        if (null != startTime && null != endTime) {
          criteria .andCreateTimeBetween(new Date(startTime), new Date(endTime));
        }
        if (null != payChannelEnums ){
            criteria.andPayChannelEqualTo(payChannelEnums.getChannelType());
        }
        if (null != payStatusEnum){
            criteria.andPayStateEqualTo(payStatusEnum.getCode());
        }
        if (null != useUniId) {
            criteria.andCreateUserIdEqualTo(useUniId);
        }
        example.setOrderByClause("id DESC");
        PageHelper.startPage(pageNo, BaseConstants.DEFAULT_LIMIT);

        List<PaySysTradeDo> paySysTradeDos = paySysTradeDoMapper.selectByExample(example);
        //pageInfo为null,是因为pagehelper用错，==》 必须得先设置PageHelper，然后执行查询语句
        PageInfo pageInfo = new PageInfo(paySysTradeDos);

        return pageInfo.getList();
    }

    /**
     * 查询总金额
     * @param startTime
     * @param endTime
     * @param useUniId
     * @param payChannelEnums
     * @param payStatusEnum
     * @return
     */
    @Override
    public Long findPaySysCount(Long startTime, Long endTime, Long useUniId,  PayChannelEnums payChannelEnums, PayStatusEnum payStatusEnum) {
        PaySysTradeDoExample example = new PaySysTradeDoExample();

        PaySysTradeDoExample.Criteria criteria = example.createCriteria();
        if (null != startTime && null != endTime) {
            criteria.andCreateTimeBetween(new Date(startTime), new Date(endTime));
        }

        if (null != payChannelEnums ){
            criteria.andPayChannelEqualTo(payChannelEnums.getChannelType());
        }
        if (null != payStatusEnum){
            criteria.andPayStateEqualTo(payStatusEnum.getCode());
        }
        return paySysTradeDoMapper.countmoneyNumber(example);

    }

    @Override
    public boolean insertPayTrade(Long userId,Long localTradeNo,String remoteTradeNo,Long moneyNumber, String sign,PayChannelEnums payChannelEnums) {

        PaySysTradeDo paySysTradeDo = new PaySysTradeDo();
        paySysTradeDo.setCreateUserId(userId);
        paySysTradeDo.setLocalTradeNo(localTradeNo);
        paySysTradeDo.setRemoteTradeNo(remoteTradeNo);
        paySysTradeDo.setMoneyNumber(moneyNumber);
        paySysTradeDo.setCreateTime(new Date());
        paySysTradeDo.setPayChannel(payChannelEnums.getChannelType());
        paySysTradeDo.setPayState(PayStatusEnum.NOT_PAY.getCode());
        paySysTradeDo.setSign(sign);

        return  paySysTradeDoMapper.insert(paySysTradeDo) > 0;
    }

    @Override
    public boolean insertApplePayTrade(Long userId, Long localTradeNo, String remoteTradeNo, Long moneyNumber, String oldMoney) {
        PaySysTradeDo paySysTradeDo = new PaySysTradeDo();
        paySysTradeDo.setCreateUserId(userId);
        paySysTradeDo.setLocalTradeNo(localTradeNo);
        paySysTradeDo.setRemoteTradeNo(remoteTradeNo);
        paySysTradeDo.setMoneyNumber(moneyNumber);
        paySysTradeDo.setCreateTime(new Date());
        paySysTradeDo.setPayChannel(PayChannelEnums.APPLE_PAY.getChannelType());
        paySysTradeDo.setPayState(PayStatusEnum.NOT_PAY.getCode());
        paySysTradeDo.setExpand1(oldMoney);
        return paySysTradeDoMapper.insert(paySysTradeDo) > 0;
    }

    @Override
    public PaySysTradeDo findTradeByLocalTradeNo(Long localTradeNo, PayChannelEnums payChannelEnums) {
        PaySysTradeDoExample example = new PaySysTradeDoExample();
        PaySysTradeDoExample.Criteria criteria = example.createCriteria();
        criteria.andLocalTradeNoEqualTo(localTradeNo);
        List<PaySysTradeDo> paySysTradeDos = paySysTradeDoMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(paySysTradeDos)){
            return null;
        }
        return paySysTradeDos.get(0);
    }

    @Override
    public boolean updatePayState(Long tradeNo,String remoteTradeNo,PayChannelEnums payChannelEnums,PayStatusEnum payStatusEnum) {
        PaySysTradeDoExample example = new PaySysTradeDoExample();
        PaySysTradeDoExample.Criteria criteria = example.createCriteria();
        criteria.andLocalTradeNoEqualTo(tradeNo);
        PaySysTradeDo paySysTradeDo = new PaySysTradeDo();
        paySysTradeDo.setPayState(payStatusEnum.getCode());
        paySysTradeDo.setCallbackTime(new Date());
        if(StringUtils.isNotEmpty(remoteTradeNo)){
            paySysTradeDo.setRemoteTradeNo(remoteTradeNo);
        }

        return paySysTradeDoMapper.updateByExampleSelective(paySysTradeDo,example) > 0;
    }


}
