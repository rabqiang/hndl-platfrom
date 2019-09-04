package com.hndl.cn.pay.sys.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayConstants;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.domain.AlipayTradeAppPayModel;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.hndl.cn.pay.sys.init.AliPayConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname 赵俊凯
 * @Description 支付宝支付
 * @Date 2019/4/10 11:58
 * @Created by 湖南达联
 */
public class AliPayUtil {

    private static final Logger log = LoggerFactory.getLogger(AliPayUtil.class);


    /**
     * 支付宝下单
     * @param aliPayConfig
     * @param orderId
     * @param userUniId
     * @param moneyNum
     * @return
     */
    public static String aliPay(AliPayConfig aliPayConfig,Long orderId,Long userUniId,String moneyNum) {
        try {
            //实例化客户端 pay_url "https://openapi.alipay.com/gateway.do"
            AlipayClient alipayClient = new DefaultAlipayClient(aliPayConfig.getPayUrl(),aliPayConfig.getAppId(),aliPayConfig.getAppPrivateKey() ,
                    "json", "UTF-8",aliPayConfig.getAppPublicKey(),AlipayConstants.SIGN_TYPE_RSA2);

            AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();

            AlipayTradeAppPayModel model = new AlipayTradeAppPayModel();

            model.setPassbackParams(String.valueOf(userUniId));
            ////商品标题
            model.setSubject("快乐粉丝会");
            model.setOutTradeNo(String.valueOf(orderId));
            //超时关闭该订单时间
            model.setTimeoutExpress("30m");
            //订单总金额元
            model.setTotalAmount(moneyNum);
            //销售产品码，商家和支付宝签约的产品码，为固定值QUICK_MSECURITY_PAY
            model.setProductCode("QUICK_MSECURITY_PAY");
            model.setBody("充值");
            request.setBizModel(model);
            request.setNotifyUrl(aliPayConfig.getNotifyUrl());  //回调地址
            //这里和普通的接口调用不同，使用的是sdkExecute
            AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
            return response.getBody();
        } catch (Exception e1) {
            log.error("==========================aliPay error=================================");
            e1.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws UnsupportedEncodingException {

//        String str1 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk6qGgzALJlZ7UjjBfkaVT93OYqoYskp/KVvAWusD5SUK93lZAdJdZVjEf4M0BaVe9lKvqg7qgFK6wKVcovolbfSpT1GyYJ4sebJT4PT8Yo1tFqv5xVFRnzQYPEYcUA9ckrkomY/jPyVIZ6WBctQR3YSyKnmxqmXBSnLCDQzcFWPpe2S6s6MdogIbmv0IFJQ7nl0/vdSWdJw1JgdwITbHBw/VCkXhw9x+uBu5F9ipShJJQYjQwEME6aA/cKhOh7jCUKmwXT95wdfsc5r0lADFMPTLp/UXL6rzeSB84f1GJBQGChGkfzDUz7Cru0Y0Pddd8ue5NyK1Nxe6WHXaEJrHoQIDAQAB";
//
//        String str2 = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAk6qGgzALJlZ7UjjBfkaVT93OYqoYskp/KVvAWusD5SUK93lZAdJdZVjEf4M0BaVe9lKvqg7qgFK6wKVcovolbfSpT1GyYJ4sebJT4PT8Yo1tFqv5xVFRnzQYPEYcUA9ckrkomY/jPyVIZ6WBctQR3YSyKnmxqmXBSnLCDQzcFWPpe2S6s6MdogIbmv0IFJQ7nl0/vdSWdJw1JgdwITbHBw/VCkXhw9x+uBu5F9ipShJJQYjQwEME6aA/cKhOh7jCUKmwXT95wdfsc5r0lADFMPTLp/UXL6rzeSB84f1GJBQGChGkfzDUz7Cru0Y0Pddd8ue5NyK1Nxe6WHXaEJrHoQIDAQAB";
//
//        System.out.println(str1.equals(str2));
//
//        AliPayConfig aliPayConfig = new AliPayConfig();
//        aliPayConfig.setPayUrl("https://openapi.alipaydev.com/gateway.do");
//        aliPayConfig.setAppId("2018050302628295");
//        aliPayConfig.setAppKey("MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAheuXPxw8QYsKBZfecpP3lSNJrHgwir5ONqfrIWP4qpxknR4NYRAPIXrdORBVbiRviwDTYFT5MIT4QWLtqzbqCBtfRu5OF4P8iZXy/wh/ZyL2ilsFFayeD5AcFbDj6h+C7h0I8NZS3YAUlNQBBuuvUhrZaCimcJf5tzDkFrEqzTjpsYL5wX8XvOnKKhyBCkz3f7/ccFDQPhyrcuKSB28MIpK/jRBP574z2COHr+jn4xTunuaCiKpqBxyyypNpinmTO78LUxf1gxlEzZPR4AGgkGX9pk0u1t+Y4atcpVKk06dXlHXroUeKCtrq2ZnoasKyl6V6vRC+Nx2ynN3/rTKl3QIDAQAB");
//        aliPayConfig.setAppSecretKey("MIIEwAIBADANBgkqhkiG9w0BAQEFAASCBKowggSmAgEAAoIBAQDNJI4OLi6DG2JYak1DZ+TAuOLjRySBh8YZS0CktO9EIxWaf8twYSAw+OOxX88ediJ6640GBz3/j2zIqVnWiSojIRJWoNYfBWg+TnGqHN7V+runE6qamfc5NcSZj9+f6Ru3Yul3vDvtk/DS6VbM0Ucx9zBkE49NjD4Mw8NeLjcj2zyQQ+pkXDDZdZGLTPPbifLdCzbXoBVHQ6Ec4dU8JwHyfwtMaRcO8PBRLJEAjCTsDmU75wtvfImHTOY8j1/jgTNfhji+/7uTwgQODX+J+APBRTBgdktw2wfZxnozd9JjofBmAWxBvXYhZYQ5ReqlNbpfeCRJbGOb4VuI6n46/9zlAgMBAAECggEBAJlM+vdv3YROX4TxE4IOzqySvcLYdFhz7T8TtGAhcjg5+7f0TkRR4KuYIxd3IKGD6KpxAncBzHwBY2rk22TuJdYQrdKc6MZP1SHSnzBf2MqRT9BAaxqTemN/Ycbb9GJc4kB+Izg+K46UIsCKbTosHochUUFIOKvb5LbHSGVGJiCdKl0Rv+bjt8aHiXBDk+ErCBO1W78nIqS8W69szxn7E/tWu/+k6XqkpkC1NKIYVlYdCr0YJ6Ih3AZMCpJBn6JWNph6EEtV6Ix5vri4bhSFRoadOcCV0RrNMSvFVTTccFDAfKE5dD8upL1DJu30aNGXlPnYqlVwbdEH+LfHAL+PXbUCgYEA+ngGysP392YmX5c1Qq+SELqXDsb5s/sJY23u6CJxmewvOPvxLR47UXMH4eyxGLJBaOL+XF4tZaEkC1M3V013jlnCZoFOe6olktS9Blm5Sbg+kQUlv/3LSUpS2zT+SOoHGb6HC6JtXtgJhUsa4CSIE/fEosNhBDChaWPpxbNNv4sCgYEA0axJdF2oi4v+3pzcln5hTv8oXu013diM7q+/AIfmwDsSK7Jc8j+g3osIyj3UcuaFCjgup++vfIJODAo8w5fSKKDV5eCYfT2i2DJJy0wBLTtesrrCcNxkc1orKY9KLZSisAxF2j0/KnR9O/ukV/bAodA7A4nDHczPgCbq26ytY08CgYEArn/O45dye7d8Rp7XKXWegu8sbMwtjbn5CX++sZXFpaJKKB5HIdLtKsrElB9OJtGSBpwW8I1gfWyt6wH4DWfYQqHAcZ/m6PtaoBh89R6vm2+0j16RtVgBODeC0Fv0SSJa/hGijnWEU06aG3Z+6+gnshmtsmQChGPJIN7OMMHCCg8CgYEAgFL/idaghvehf0FlyD2E9MI5RQ/M/f/BEXxCW+LRGSmOD2xUcnb6z/kr4gtBcSkgl4aXF3UcZAmkFr5VPig3GWKGRvDUoyIL/mGYxHG57qL9bEndIxHf8LFo5UCrV4Y2o6R/Q/hkJmmxE/sJNETy1JYK6DlyT1TAUmB/MP9YBwUCgYEA0i/O8ZC3wQFiTHMHlcg+Fz3kJzTrvEbiOy05hYlNfnpiHhgImk3JI4TR8gT/yfGq5gq6+exRZ76xynfLWFCFpzx4W6jy+EwSH85Tnb57uDTGeQHwYv7w8QrFBAGfxy/0RLk4yI7Yx2kLB8sZlJNryXXHUxLm0fI/WtG+fLLsem8=");
//        aliPayConfig.setNotifyUrl("http://innertest.mangguohd.com/paySys/ali/callBack");
//        Map map  = aliPay(aliPayConfig,123123176121231L,12345L,"0.1");
//
//        map.keySet().stream().forEach(key -> {
//            System.out.println(key + " : "  + map.get(key));
//        });
    }

    public static Map<String,String> strDataToMap(String str){
        try {
            str = URLDecoder.decode(str,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String[] array = str.split("&");
        Map<String,String> map = new HashMap<>(array.length);
        for(String string : array){
            int index = string.indexOf("=");
            String key = string.substring(0,index);
            String val = string.substring(index + 1,string.length());
            map.put(key,val);
        }
        return map;
    }



//    public static void main(String[] args) {
//        String url = "app_id=2015052600090779&biz_content=%7B%22timeout_express%22%3A%2230m%22%2C%22seller_id%22%3A%22%22%2C%22product_code%22%3A%22QUICK_MSECURITY_PAY%22%2C%22total_amount%22%3A%220.02%22%2C%22subject%22%3A%221%22%2C%22body%22%3A%22%E6%88%91%E6%98%AF%E6%B5%8B%E8%AF%95%E6%95%B0%E6%8D%AE%22%2C%22out_trade_no%22%3A%22314VYGIAGG7ZOYY%22%7D&charset=utf-8&method=alipay.trade.app.pay&sign_type=RSA2&timestamp=2016-08-15%2012%3A12%3A15&version=1.0&sign=MsbylYkCzlfYLy9PeRwUUIg9nZPeN9SfXPNavUCroGKR5Kqvx0nEnd3eRmKxJuthNUx4ERCXe552EV9PfwexqW%2B1wbKOdYtDIb4%2B7PL3Pc94RZL0zKaWcaY3tSL89%2FuAVUsQuFqEJdhIukuKygrXucvejOUgTCfoUdwTi7z%2BZzQ%3D";
//        Map map = strDataToMap(url);
//        map.keySet().stream().forEach(key -> {
//            System.out.println(key + " : "  + map.get(key));
//        });
//    }
}
