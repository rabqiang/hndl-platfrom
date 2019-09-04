package com.hndl.cn.pay.sys.config;

import com.hndl.cn.pay.sys.init.AliPayConfig;
import com.hndl.cn.pay.sys.init.WeChatPayConfig;
import com.hndl.cn.pay.sys.init.WechatAppletsPayConfig;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/19 15:09
 * @Created by 湖南达联
 */
@Configuration
public class PayConfig {

    private static final Logger log = LoggerFactory.getLogger(PayConfig.class);


    private static final String commodityName = "芒果充值";

    private static final String signType = "RSA2";

    @Resource
    private ApplicationContext applicationContext;

    @Bean
    public WeChatPayConfig initWeChatPayConfig(){

         Environment environment = applicationContext.getEnvironment();
         String payUrl = environment.getProperty("wechat.pay.prepay.url");
         //获取pay url
         if(StringUtils.isBlank(payUrl)){
            log.error("wechat payUrl is null  : {}", payUrl);
            System.exit(0);//关闭程序
         }

        String appId = environment.getProperty("wechat.pay.app.id");
        //appId
        if(StringUtils.isBlank(appId)){
            log.error("wechat appId is null  : {}", appId);
            System.exit(0);//关闭程序
        }

        String callBackUrl = environment.getProperty("wechat.pay.callback.url");
        //callBackUrl
        if(StringUtils.isBlank(callBackUrl)){
            log.error("wechat callBackUrl is null  : {}", callBackUrl);
            System.exit(0);//关闭程序
        }


        String mchId = environment.getProperty("wechat.pay.mch.id");
        //mchId
        if(StringUtils.isBlank(callBackUrl)){
            log.error("wechat mchId is null  : {}", mchId);
            System.exit(0);//关闭程序
        }

        String appSecret = environment.getProperty("wechat.pay.app.secret");
        //app secret
        if(StringUtils.isBlank(appSecret)){
            log.error("wechat appSecret is null  : {}", appSecret);
            System.exit(0);//关闭程序
        }

        String businessNoticePayUrl =  environment.getProperty("wechat.pay.business.notice.pay.url");

        if(StringUtils.isBlank(businessNoticePayUrl)){
            log.error("business_notice_pay_url is null  : {}", businessNoticePayUrl);
            System.exit(0);//关闭程序
        }
        log.info("====================WeChatPayConfig init Success==========================");

        return new WeChatPayConfig(commodityName,payUrl,appId,callBackUrl,signType,mchId,appSecret,businessNoticePayUrl);
    }


    @Bean
    public AliPayConfig initAliPayConfig(){

        Environment environment = applicationContext.getEnvironment();

        String payUrl = environment.getProperty("ali.pay.prepay.url");
        //获取pay url
        if(StringUtils.isBlank(payUrl)){
            log.error("ali payUrl is null  : {}", payUrl);
            System.exit(0);//关闭程序
        }

        String appId = environment.getProperty("ali.pay.app.id");
        //appId
        if(StringUtils.isBlank(appId)){
            log.error("ali appId is null  : {}", appId);
            System.exit(0);//关闭程序
        }

        String appKey = environment.getProperty("ali.pay.app.key");
        //appKey
        if(StringUtils.isBlank(appKey)){
            log.error("ali appKey is null  : {}", appKey);
            System.exit(0);//关闭程序
        }

        String appPublicKey = environment.getProperty("ali.pay.app.public.key");
        //appPublicKey
        if(StringUtils.isBlank(appPublicKey)){
            log.error("ali appPublicKey is null  : {}", appPublicKey);
            System.exit(0);//关闭程序
        }

        String appPrivateKey = environment.getProperty("ali.pay.app.private.key");
        //appPrivateKey
        if(StringUtils.isBlank(appPrivateKey)){
            log.error("ali appPrivateKey is null  : {}", appPrivateKey);
            System.exit(0);//关闭程序
        }

        String sellerId = environment.getProperty("ali.pay.seller.id");
        //sellerId
        if(StringUtils.isBlank(sellerId)){
            log.error("ali sellerId is null  : {}", sellerId);
            System.exit(0);//关闭程序
        }

        String product = environment.getProperty("ali.pay.partner");
        //product
        if(StringUtils.isBlank(product)){
            log.error("ali product is null  : {}", product);
            System.exit(0);//关闭程序
        }

        String callbackUrl = environment.getProperty("ali.pay.callback.url");
        //callbackUrl
        if(StringUtils.isBlank(callbackUrl)){
            log.error("ali callbackUrl is null  : {}", callbackUrl);
            System.exit(0);//关闭程序
        }

        String businessNoticePayUrl = environment.getProperty("ali.pay.business.notice.pay.url");
        //callbackUrl
        if(StringUtils.isBlank(businessNoticePayUrl)){
            log.error("ali businessNoticePayUrl is null  : {}", businessNoticePayUrl);
            System.exit(0);//关闭程序
        }


        AliPayConfig aliPayConfig = new AliPayConfig();
        aliPayConfig.setAppId(appId);
        aliPayConfig.setPayUrl(payUrl);
        aliPayConfig.setAppKey(appKey);
        aliPayConfig.setAppPublicKey(appPublicKey);
        aliPayConfig.setAppPrivateKey(appPrivateKey);
        aliPayConfig.setNotifyUrl(callbackUrl);
        aliPayConfig.setSellerId(sellerId);
        aliPayConfig.setPartner(product);
        aliPayConfig.setBusinessPayNoticeUrl(businessNoticePayUrl);

        log.info("====================AliPayConfig init Success==========================");

        return aliPayConfig;
    }

    @Bean
    public WechatAppletsPayConfig initWechatAppletsPayConfig(){
        Environment environment = applicationContext.getEnvironment();

        String payUrl = environment.getProperty("wechat.pay.prepay.url");
        //获取pay url
        if(StringUtils.isBlank(payUrl)){
            log.error("wechat.applets.pay.prepay.url is null  : {}", payUrl);
            System.exit(0);//关闭程序
        }

        String appId = environment.getProperty("wechat.applets.pay.app.id");
        //获取pay url
        if(StringUtils.isBlank(appId)){
            log.error("wechat.applets.pay.app.id is null  : {}", appId);
            System.exit(0);//关闭程序
        }

        String callback = environment.getProperty("wechat.pay.callback.url");
        //获取pay url
        if(StringUtils.isBlank(callback)){
            log.error("wechat.pay.callback.url is null  : {}", callback);
            System.exit(0);//关闭程序
        }

        String mchId = environment.getProperty("wechat.applets.pay.mch.id");
        //mchId
        if(StringUtils.isBlank(mchId)){
            log.error("wechat.applets.pay.mch.id is null  : {}", mchId);
            System.exit(0);//关闭程序
        }

        String appSecret = environment.getProperty("wechat.applets.pay.app.secret");
        //app secret
        if(StringUtils.isBlank(appSecret)){
            log.error("wechat.applets.pay.app.secret  is null  : {}", appSecret);
            System.exit(0);//关闭程序
        }

        return new WechatAppletsPayConfig(commodityName,payUrl,appId,callback,"MD5",mchId,appSecret);
    }
}
