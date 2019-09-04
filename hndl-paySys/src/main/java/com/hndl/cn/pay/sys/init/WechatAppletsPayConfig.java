package com.hndl.cn.pay.sys.init;

import lombok.Getter;

/**
 * @author 赵俊凯
 * @Description
 * @Date 2019/5/24 13:01
 * @Created by 湖南达联
 */
@Getter
public class WechatAppletsPayConfig {

    private  String commodityName;

    private  String payUrl;

    private  String appId;

    private  String notifyUrl;

    private  String signType;

    private  String appMid;

    private  String appPrivateKey;


    public WechatAppletsPayConfig(String commodityName, String payUrl, String appId, String notifyUrl, String signType, String appMid, String appPrivateKey) {
        this.commodityName = commodityName;
        this.payUrl = payUrl;
        this.appId = appId;
        this.notifyUrl = notifyUrl;
        this.signType = signType;
        this.appMid = appMid;
        this.appPrivateKey = appPrivateKey;
    }
}
