package com.hndl.cn.shop.sys.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

/**
 * @Classname
 * @Description 异常码8位，18开头
 * @Date
 * @Created by 湖南达联
 */
public enum ShopSysExceptionEnums {

    SHOP_SYS_EXCEPTION_ENUMS("18000000","这是一个例子，请参考"),

    NUMBER_OF_DRAWS_NOT_ENOUGH("18010101","福卡不足，抽奖失败"),

    PRIZE_NOT_FOUND("18020001", "该奖品不存在"),

    PRIZE_IS_OVERDUE("18020002", "该奖品助力时间已过, 请查看开奖信息"),

    FOUCAULT_COUNT_TOO_LITTLE("18020003", "福卡数量不足, 参与抢福利失败"),

    YOUR_FRIEND_NOT_PARTICIPATION("18020004", "您的好友暂未参与抢福利"),

    YOUR_BEEN_INVOLVED("18020005", "您已参与过对此用户这期抢福利的助力"),

    YOUR_HELP_TOO_MUCH("18020006", "您今天已经助力过三次, 请明天再试"),

    YOU_ARE_NOT_PRIZE("18020007", "您并没有中奖, 请刷新后重试"),

    PRIZE_NOT_OPEN("18020008", "该奖品暂未开奖, 请刷新后重试"),

    YOU_ARE_CRAZY("18020009", "记挤不能助力寄几"),
    ;





    private String code;

    private String msg;

    ShopSysExceptionEnums(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public static String getExceptionMsg(String code){
        ShopSysExceptionEnums exceptionEnums = null;
        for(ShopSysExceptionEnums enums : ShopSysExceptionEnums.values()){
                if(enums.code.equals(code)){
                      return enums.getMsg();
                }
        }

        if(exceptionEnums == null){
           return PublicExceptionCodeEnum.getMsg(code);
        }
        return "";
    }
}
