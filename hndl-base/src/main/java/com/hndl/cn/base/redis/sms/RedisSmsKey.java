package com.hndl.cn.base.redis.sms;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/19 16:06
 * @Created by 湖南达联
 */
public class RedisSmsKey {


    private static  final String PHONE_SMS_KEY = "sms:phone_sms_key";//手机验证码

    public static final Long OUT_TIME = 90L;


    public static String getSmsCodeKey(String code){
        return  PHONE_SMS_KEY + code;
    }

    public static void main(String[] args) {
    }
}
