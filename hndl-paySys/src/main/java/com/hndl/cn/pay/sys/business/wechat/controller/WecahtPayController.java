package com.hndl.cn.pay.sys.business.wechat.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.pay.sys.business.wechat.service.WechatPayService;
import com.hndl.cn.pay.sys.business.wechat.service.impl.WechatPayServiceImpl;
import com.hndl.cn.pay.sys.exception.PaySysException;
import com.hndl.cn.pay.sys.exception.PaySysExceptionEnums;
import com.hndl.cn.pay.sys.util.WeChatPayUtil;
import com.hndl.cn.utils.number.CoinUtils;
import com.hndl.cn.utils.request.RequestUtil;
import com.hndl.cn.utils.string.StringUtils;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/4/12 16:15
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/wechat")
public class WecahtPayController {

    private static final Logger log = LoggerFactory.getLogger(WecahtPayController.class);

    @Resource
    private WechatPayService wechatPayService;


    @AuthPassport()
    @GetMapping("/preOrderByWechatPay")
    @CrossOrigin
    public Result<Object> preOrderByWechatPay(@Ignore @CurrentUser Long loginUserId,@RequestParam Long orderNumber){

        if(!CoinUtils.checkCoin(orderNumber)){
            log.info("==========下单用户:"+loginUserId+"下单金额为：" + orderNumber);
            throw new PaySysException(PaySysExceptionEnums.EX_PRE_ORDER_WECAHT_MONEY_NUMBER_ERROR.getCode());
        }

        return  wechatPayService.preOrderByWechatPay(loginUserId,orderNumber);
    }

    @AuthPassport()
    @GetMapping("/preOrderByWechatAppletsPay")
    @CrossOrigin
    public Result<Object> preOrderByWechatPay(@Ignore @CurrentUser Long loginUserId,
                                              @RequestParam Long orderNumber,
                                              @RequestParam String openId){

        if(!CoinUtils.checkCoin(orderNumber) || StringUtils.isBlank(openId)){
            throw new PaySysException(PaySysExceptionEnums.EX_PRE_ORDER_WECAHT_MONEY_NUMBER_ERROR.getCode());
        }

        return  wechatPayService.preOrderByWechatAppletsPay(loginUserId, orderNumber, openId);
    }

    @GetMapping("/preOrderByWechatSubscriptionPay")
    @AuthPassport()
    @CrossOrigin
    public Result<Object> preOrderByWechatSubscriptionPay(@RequestParam Long userOldId,
                                              @RequestParam Long orderNumber,
                                              @RequestParam String openId){

        if(!CoinUtils.checkCoin(orderNumber) || StringUtils.isBlank(openId)){
            throw new PaySysException(PaySysExceptionEnums.EX_PRE_ORDER_WECAHT_MONEY_NUMBER_ERROR.getCode());
        }

        return  wechatPayService.preOrderByWechatSubscriptionPay(userOldId, orderNumber, openId);
    }

    @RequestMapping("/callBack")
    @CrossOrigin
    public String callBack(HttpServletRequest request){
        log.info("=================获取到微信callBack=====================");
        InputStream inStream;
        String result = null;
        Map<String, String> map = new HashMap<String, String>();
        try {
            inStream = request.getInputStream();
            ByteArrayOutputStream outSteam = new ByteArrayOutputStream();
            byte[] buffer = new byte[1024];
            int len = 0;
            while ((len = inStream.read(buffer)) != -1) {
                outSteam.write(buffer, 0, len);
            }
            result = new String(outSteam.toByteArray(), "utf-8");// 获取微信调用我们notify_url的返回信息

            Document document = DocumentHelper.parseText(result);
            Element root = document.getRootElement();
            for (Iterator i = root.elementIterator(); i.hasNext(); ) {
                Element element = (Element) i.next();
                String name = element.getName();
                String text = element.getText();
                map.put(name, text);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("=====================request url : "+RequestUtil.getErrorMsg(request));
        }
        return wechatPayService.callBack(map);
    }

}
