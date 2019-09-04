package com.hndl.cn.pay.sys.business.apple.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.pay.sys.business.apple.service.ApplePayService;
import com.hndl.cn.pay.sys.business.apple.vo.ApplePayVo;
import com.hndl.cn.base.enums.pay.ApplePayProductEnums;
import com.hndl.cn.pay.sys.exception.PaySysException;
import com.hndl.cn.pay.sys.exception.PaySysExceptionEnums;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/26 10:34
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/apple")
public class ApplePayController {

    private static final Logger log = LoggerFactory.getLogger(ApplePayController.class);

    @Resource
    private ApplePayService applePayService;






    @AuthPassport()
    @GetMapping("/preOrderByApplePay")
    @CrossOrigin
    public Result<Object> preOrderByApplePay(@Ignore @CurrentUser Long loginUserId, @RequestParam String product){
        ApplePayProductEnums enumsByProductId = ApplePayProductEnums.getEnumsByProductId(product);
        if(enumsByProductId == null){
            throw new PaySysException(PaySysExceptionEnums.EX_PRE_ORDER_WECAHT_MONEY_NUMBER_ERROR.getCode());
        }
        return applePayService.preOrderByApplePay(loginUserId,enumsByProductId);
    }

    @AuthPassport()
    @PostMapping("/confirmOfOrder")
    @CrossOrigin
    public Result<Object> confirmOfOrder(@Ignore @CurrentUser Long loginUserId,
                                              @RequestBody @Valid ApplePayVo vo){
//        log.info("pay data : {}",vo.getPayData());
        return applePayService.confirmOfOrder(loginUserId,vo.getOrderId(),vo.getPayData());
    }
}
