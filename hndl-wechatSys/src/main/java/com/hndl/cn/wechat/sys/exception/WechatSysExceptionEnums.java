package com.hndl.cn.wechat.sys.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

import java.util.Arrays;

/**
 * @Classname 赵俊凯
 * @Description wecatsys业务异常类，异常码8位，13开头
 * @Date 2019/3/20 9:32
 * @Created by 湖南达联
 */
public enum WechatSysExceptionEnums {

    WECHAT_SYS_EXCEPTION_ENUMS("13000000","这是一个例子，请参考"),;


    private String code;

    private String msg;

    WechatSysExceptionEnums(String code, String message) {
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
        WechatSysExceptionEnums exceptionEnums = null;
        for(WechatSysExceptionEnums enums : WechatSysExceptionEnums.values()){
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
