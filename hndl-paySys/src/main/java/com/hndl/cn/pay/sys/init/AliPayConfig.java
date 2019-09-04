package com.hndl.cn.pay.sys.init;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Classname 赵俊凯
 * @Description ali pay 配置类
 * @Date 2019/4/10 11:42
 * @Created by 湖南达联
 */
@Getter
@Setter
public class AliPayConfig {

    private static final Logger log = LoggerFactory.getLogger(AliPayConfig.class);


    private String payUrl;//支付的url

    private String appId;//app id

    private String notifyUrl;

    private String appKey;

    private String appPublicKey;

    private String appPrivateKey;

    private String sellerId;

    private String partner;

    private  String businessPayNoticeUrl;

}
