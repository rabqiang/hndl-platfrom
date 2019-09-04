package com.hndl.cn.mghd.admin.business.pay.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.pay.service.PayService;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description:TODO 支付订单
 * @author: 易成贤
 * @create: 2019/7/3 10:03
 * @Created by湖南达联
 **/
@Api(tags = "支付管理/查询")
@RequestMapping("/paySysTrade")
@RestController
public class PaySysTradeController {

    @Resource
    PayService payService;
    /**
     * 查询订单查询
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param useUniId 用户id
     * @param channelType 支付渠道
     * @param payStatus 订单状态
     * @param pageNo 页码
     * @return
     */
    @ApiOperation(value = "查询支付订单")
    @AdminLog
    @AuthPower
    @GetMapping("/findPaySysTrade")
    Result<Map<String,Object>> findPaySysTrade(Long startTime, Long endTime, Long useUniId, Integer channelType, Integer payStatus, @RequestParam Integer pageNo) {
        return payService.findPaySysTrade(startTime, endTime, useUniId, channelType, payStatus, pageNo);
    }

    @ApiOperation(value = "查询支付渠道")
    @AdminLog
    @AuthPower
    @GetMapping("/findPayChannel")
    Result findPayChannel(){
        return payService.findPayChannel();
    }

    @ApiOperation(value = "查询支付状态")
    @AdminLog
    @AuthPower
    @GetMapping("/findPayStatus")
    Result findPayStatus(){
        return payService.findPayStatus();
    }
}
