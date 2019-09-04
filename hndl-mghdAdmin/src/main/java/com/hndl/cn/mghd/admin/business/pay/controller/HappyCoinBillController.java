package com.hndl.cn.mghd.admin.business.pay.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.pay.service.HappyCoinBillInfoService;
import com.hndl.cn.mghd.admin.business.pay.vo.HappyCoinBillInfoVo;
import com.hndl.cn.mghd.admin.business.pay.vo.PayReasonVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 快乐币管理相关接口
 * @author: 易成贤
 * @create: 2019/7/15 20:10
 * @Created by湖南达联
 **/
@Api(tags = "快乐币管理/查询")
@RestController
@RequestMapping("/happyCoinBill")
public class HappyCoinBillController {
    @Resource
    HappyCoinBillInfoService happyCoinBillInfoService;
    @ApiOperation(value = "查询支付订单")
    @AdminLog
    @AuthPower
    @GetMapping("/findHappyCoinBill")
    Result<List<HappyCoinBillInfoVo>> findHappyCoinBill(Long startTime,Long endTime , Long userUniId, Integer payReason,@RequestParam Integer pageNo){
       return happyCoinBillInfoService.findHappyCoinBill(startTime,endTime,userUniId,payReason,pageNo);
    }

    /**
     *
     * @return
     */
    @ApiOperation(value = "查询消费类型")
    @AdminLog
    @AuthPower
    @GetMapping("/findPayReason")
    Result<List<PayReasonVo>> findPayReason(){
      return   happyCoinBillInfoService.findPayReason();
    }
}
