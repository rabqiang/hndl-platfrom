package com.hndl.cn.base.redis.pay;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/19 16:06
 * @Created by 湖南达联
 */
public class RedisPayKey {


    private static final String PAY_NOTICE_REDIS_KEY = "pay_sys:redis_key_notice_";

    public static final Long OUT_TIME = 300L;


    public static String getPayNoticeRedisKey(Integer payChannel,Long localTradeNo){
        return  PAY_NOTICE_REDIS_KEY + payChannel + "_" + localTradeNo;
    }

//    public static void main(String[] args) {
//        System.out.println(RedisPayKey.getPayNoticeRedisKey(12345678L));
//    }
}
