package com.hndl.cn.pay.sys.init;


import lombok.Getter;

/**
 * @Classname 赵俊凯
 * @Description 微信支付config
 * @Date 2019/4/9 19:15
 * @Created by 湖南达联
 */
@Getter
public class WeChatPayConfig{

    private  String commodityName;

    private  String payUrl;

    private  String appId;

    private  String notifyUrl;

    private  String signType;

    private  String appKey;

    private  String appPrivateKey;

    private  String businessPayNoticeUrl;



    public WeChatPayConfig(String commodityName, String payUrl, String appId, String notifyUrl, String signType, String appKey, String appPrivateKey, String businessPayNoticeUrl) {
        this.commodityName = commodityName;
        this.payUrl = payUrl;
        this.appId = appId;
        this.notifyUrl = notifyUrl;
        this.signType = signType;
        this.appKey = appKey;
        this.appPrivateKey = appPrivateKey;
        this.businessPayNoticeUrl = businessPayNoticeUrl;
    }
}
