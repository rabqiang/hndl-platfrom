package com.hndl.cn.activity.sys.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

/**
 * @Classname 赵俊凯
 * @Description ActivitySys业务异常类，异常码8位，15开头
 * @Date 2019/3/20 9:32
 * @Created by 湖南达联
 */
public enum ActivitySysExceptionEnums {

    ACTIVITY_SYS_EXCEPTION_ENUMS("15000000","这是一个例子，请参考"),

    ACTIVITY_SYS_USER_NOT_FIND_EX("15000001","该用户不存在"),

    NOW_HAPPY_LIBRARY_COUNT_EX("15000101","今天的分享次数已经用完。"),

    ACTIVITY_END_EX("15000201","活动没有开始或已经结束"),


    ;


    private String code;

    private String msg;

    ActivitySysExceptionEnums(String code, String message) {
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
        ActivitySysExceptionEnums exceptionEnums = null;
        for(ActivitySysExceptionEnums enums : ActivitySysExceptionEnums.values()){
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
