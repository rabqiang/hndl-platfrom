package com.hndl.cn.version.sys.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

/**
 * @Classname 赵俊凯
 * @Description wecatsys业务异常类，异常码8位，14开头
 * @Date 2019/3/20 9:32
 * @Created by 湖南达联
 */
public enum VersionSysExceptionEnums {

    CHAT_SYS_EXCEPTION_ENUMS("14000000","这是一个例子，请参考"),

    MGHD_SYS_MENU_NULL_PARAMETER_VALUE_EXCEPTION("16100002","parametervalue为空"),

    ;


    private String code;

    private String msg;

    VersionSysExceptionEnums(String code, String message) {
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
        VersionSysExceptionEnums exceptionEnums = null;
        for(VersionSysExceptionEnums enums : VersionSysExceptionEnums.values()){
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
