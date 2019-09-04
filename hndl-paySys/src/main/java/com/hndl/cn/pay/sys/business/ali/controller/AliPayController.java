package com.hndl.cn.pay.sys.business.ali.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayConstants;
import com.alipay.api.internal.util.AlipaySignature;
import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.pay.sys.business.ali.service.AliPayService;
import com.hndl.cn.pay.sys.constants.PaySysConstants;
import com.hndl.cn.pay.sys.exception.PaySysException;
import com.hndl.cn.pay.sys.exception.PaySysExceptionEnums;
import com.hndl.cn.pay.sys.init.AliPayConfig;
import com.hndl.cn.utils.number.CoinUtils;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/20 15:51
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/ali")
public class AliPayController {

    private static final Logger log = LoggerFactory.getLogger(AliPayController.class);

    @Resource
    private AliPayService aliPayService;

    @Resource
    private AliPayConfig aliPayConfig;



    @AuthPassport()
    @GetMapping("/preOrderByAliPay")
    @CrossOrigin
    public Result<Object> preOrderByWechatPay(@Ignore @CurrentUser Long loginUserId, @RequestParam Long orderNumber){

        if(!CoinUtils.checkCoin(orderNumber)){
            log.info("==========下单用户:"+loginUserId+"下单金额为：" + orderNumber);
            throw new PaySysException(PaySysExceptionEnums.EX_PRE_ORDER_WECAHT_MONEY_NUMBER_ERROR.getCode());
        }

        return  aliPayService.preOrderByAliPay(loginUserId,orderNumber);
    }


    @PostMapping("/callBack")
    @CrossOrigin
    public String callBack(HttpServletRequest request){

        //获取支付宝POST过来反馈信息
        Map<String,String> params = new HashMap<String,String>();
        Map requestParams = request.getParameterMap();
        for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {
            String name = (String) iter.next();
            String[] values = (String[]) requestParams.get(name);
            String valueStr = "";
            for (int i = 0; i < values.length; i++) {
                valueStr = (i == values.length - 1) ? valueStr + values[i]
                        : valueStr + values[i] + ",";
            }
            //乱码解决，这段代码在出现乱码时使用。
            //valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
            params.put(name, valueStr);
        }
//        log.info("==========map============ {} ",params);
        log.info("========ali apy callBack =========");
        if(!PaySysConstants.ALI_PAY_TRADE_SUCCESS.equals(params.get("trade_status"))){
            return PaySysConstants.ALI_PAY_FAIL;
        }

        boolean signVerified;
        try {
            signVerified = AlipaySignature.rsaCheckV1(params,aliPayConfig.getAppKey(),AlipayConstants.CHARSET_UTF8,AlipayConstants.SIGN_TYPE_RSA2);
        } catch (AlipayApiException e) {
            e.printStackTrace();
            return PaySysConstants.ALI_PAY_FAIL;// 验签发生异常,则直接返回失败
        }
        //处理你的业务逻辑，更细订单状态等
        if (signVerified) {
            return aliPayService.callBack(params);
        } else {
            log.info("========ali apy callBack requestParams  {}: ",signVerified);
            //
            return PaySysConstants.ALI_PAY_FAIL;
        }

    }
}
