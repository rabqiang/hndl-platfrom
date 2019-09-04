package com.hndl.cn.base.enums.pay;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/4/9 16:40
 * @Created by 湖南达联
 */
public enum PayChannelEnums {

    WECHAT_PAY(100,"微信支付"),

    ALI_PAY(200,"支付宝支付"),

    APPLE_PAY(300,"苹果支付"),

    HAPPY_SYS_PAY(999,"快乐粉丝会(消费使用)");


    public static final String PAY_DEFAULT_ID = "888";//默认使用的ID,用于充值订单第三方id


    private Integer channelType;

    private String description;

    PayChannelEnums(Integer channelType,String description){
        this.channelType = channelType;
        this.description = description;
    }


    public Integer getChannelType(){
        return channelType;
    }
    public String getDescription(){
        return description;
    }


    public static boolean checkVal(Integer channelType){
         if(channelType == null){
              return false;
         }
         for(PayChannelEnums enums : PayChannelEnums.values()){
             if(enums.getChannelType().equals(channelType)){
                  return true;
             }
         }
         return false;
    }

    public static PayChannelEnums evalVal(Integer channelType) {
        for (PayChannelEnums payChannelEnums : PayChannelEnums.values()) {
            if (payChannelEnums.getChannelType().equals(channelType)){
                return payChannelEnums;
            }
        }
        return null;
    }

    /**
     *
     * @return
     */
    public  static List<PayChannelEnums> getPayChannel(){
        List<PayChannelEnums> list = new ArrayList<>();
        list.add( WECHAT_PAY);
        list.add(ALI_PAY);
        list.add(APPLE_PAY);
        return list;
    }

}
