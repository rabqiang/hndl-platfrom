package com.hndl.cn.pay.sys.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

/**
 * @Classname 赵俊凯
 * @Description pay sys业务异常类，异常码8位，20开头
 * @Date 2019/3/20 9:32
 * @Created by 湖南达联
 */
public enum PaySysExceptionEnums {

    PAY_SYS_EXCEPTION_ENUMS("15000000","这是一个例子，请参考"),

    EX_PRE_ORDER_WECAHT_ERROR("20001001","微信支付预下单失败"),

    EX_PRE_ORDER_WECAHT_MONEY_NUMBER_ERROR("20001002","支付预下单金额有误"),

    EX_PAY_CALLBACK_ERROR("20022001","微信回调失败"),

    EX_PAY_DATA_IS_NULL("20022101","苹果支付验证数据不能为空"),

    EX_PAY_IS_NOT_FIND("20022102","订单不存在"),

    EX_PAY_STATUS_IS_NOT_FIND("20022103","订单已经被处理"),

    EX_PAY_CHECK_ORDER("20022104","订单校验异常"),


    ;


    private String code;

    private String msg;

    PaySysExceptionEnums(String code, String message) {
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
        PaySysExceptionEnums exceptionEnums = null;
        for(PaySysExceptionEnums enums : PaySysExceptionEnums.values()){
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
