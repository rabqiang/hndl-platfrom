package com.hndl.cn.mghd.sys.business.pay.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.pay.service.UserPayService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.utils.request.RequestUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author 赵俊凯
 * @Description 业务系统确认支付相关接口
 * @Date 2019/4/22 15:31
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/pay")
@Api(tags = "Pay")
public class UserPayController {

    @Resource
    private UserPayService userPayService;



    private static final Logger log = LoggerFactory.getLogger(UserPayController.class);

    @Value("${server.auth.ip}")
    private String serverAuthIp;


    @RequestMapping("/confirmPayNotice")
    @ApiIgnore
    @ApiOperation(value="[警告!!!]", notes="此接口用于服务之间的通信,前端不允许调用")
    public Result<Object>  confirmPayNotice(HttpServletRequest request,@RequestParam Integer payChannel, @RequestParam Long localTradeNo){
//
//        log.info("===============业务系统回调request ip: {}====================",RequestUtil.getClientIP(request));
//
//        log.info("是否包含" + (RequestUtil.getClientIP(request)));
        //这里需要校验来源ip
        if(!serverAuthIp.contains(RequestUtil.getClientIP(request))){
            log.error(serverAuthIp+"===============发现非法调用{}====================",RequestUtil.getClientIP(request));
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }

        if(!PayChannelEnums.checkVal(payChannel)){
            log.error("===============发现非法调用{}====================",RequestUtil.getClientIP(request));
            throw new MghdSysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
        }

        return userPayService.confirmPayNotice(payChannel,localTradeNo);
    }


    @GetMapping("/userPayConfirm")
    @AuthPassport
    @ApiOperation(value="支付确认", notes="支付确认接口")
    public Result<Object> userPayConfirm(@CurrentUser @ApiIgnore CommonUserInfoDo userInfoDo,
                                         @ApiParam(name="localTradeNo",value="支付本地订单号",required=true)
                                         @RequestParam Long localTradeNo){
        return userPayService.userPayConfirm(localTradeNo,userInfoDo.getSysUniId());
    }


    public static void main(String[] args) {
        String str = "120.27.149.138,113.246.127.15";
        String str1 = "113.246.127.15";
        System.out.println(str.contains(str1));
    }



}
