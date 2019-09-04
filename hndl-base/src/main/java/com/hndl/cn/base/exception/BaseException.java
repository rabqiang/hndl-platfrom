package com.hndl.cn.base.exception;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.utils.string.StringUtils;
import lombok.Getter;
import lombok.Setter;

/**
 * @Classname 赵俊凯
 * @Description 通用异常父类
 * @Date 2019/3/11 16:09
 * @Created by 湖南达联
 */
@Setter
@Getter
public class BaseException extends RuntimeException{

    private String errorCode;//异常代码

    private String msg;//异常信息

    private String errorSysCode;//异常系统代码

    private String errorLevel = ExceptionLevelEnums.INFO.getDescription();//异常等级,默认为info

    private Object errorData;//异常数据

    private Object[] args;//异常参数

    private Throwable sourceT;//异常

    public BaseException(String code, String msg,ExceptionSysMarkEnum sysMarkEnum) {
        super(getMessage(sysMarkEnum, code));
        this.errorCode = code;
        this.msg = msg;
        this.errorSysCode = sysMarkEnum.getMark();
    }

    public BaseException(String code, String msg,ExceptionSysMarkEnum sysMarkEnum,Throwable t) {
        super(getMessage(sysMarkEnum, code));
        this.errorCode = code;
        this.msg = msg;
        this.errorSysCode = sysMarkEnum.getMark();
        this.sourceT = t;
    }

    public BaseException(String code, String msg,ExceptionLevelEnums levelEnums, ExceptionSysMarkEnum sysMarkEnums) {
        super(getMessage(sysMarkEnums, code));
        this.errorCode = code;
        this.msg = msg;
        this.errorLevel = levelEnums.getDescription();
    }

    public BaseException(String code, String msg,ExceptionLevelEnums levelEnums, ExceptionSysMarkEnum sysMarkEnums,Throwable t) {
        super(getMessage(sysMarkEnums, code));
        this.errorCode = code;
        this.msg = msg;
        this.errorLevel = levelEnums.getDescription();
        this.sourceT = t;
    }


    public BaseException(String code, String msg,ExceptionLevelEnums levelEnums, ExceptionSysMarkEnum sysMarkEnums,
                              Object errorData) {
        super(getMessage(sysMarkEnums, code));
        this.errorCode = code;
        this.msg = msg;
        this.errorLevel = levelEnums.getDescription();
        this.errorData = errorData;
    }

    public BaseException(String code, String msg,ExceptionLevelEnums levelEnums, ExceptionSysMarkEnum sysMarkEnums,
                         Object errorData,Throwable t) {
        super(getMessage(sysMarkEnums, code));
        this.errorCode = code;
        this.msg = msg;
        this.errorLevel = levelEnums.getDescription();
        this.errorData = errorData;
        this.sourceT  = t;
    }

    public BaseException(String code, String msg,ExceptionLevelEnums levelEnums, ExceptionSysMarkEnum sysMarkEnums,
                         Object errorData,Object[] args) {
        super(getMessage(sysMarkEnums, code));
        this.errorCode = code;
        this.msg = msg;
        this.errorLevel = levelEnums.getDescription();
        this.errorData = errorData;
        this.args = args;
    }

    public BaseException(String code, String msg,ExceptionLevelEnums levelEnums, ExceptionSysMarkEnum sysMarkEnums,
                         Object errorData,Object[] args,Throwable t) {
        super(getMessage(sysMarkEnums, code));
        this.errorCode = code;
        this.msg = msg;
        this.errorLevel = levelEnums.getDescription();
        this.errorData = errorData;
        this.args = args;
        this.sourceT = t;
    }



    /**
     *  输出除了sourceT 之外的异常数据字符串
     * @return
     */
    public String toString(){

        StringBuilder sb = new StringBuilder();
        sb.append("[错误异常系统代码] = ").append(errorSysCode).append("[错误异常代码 = ]").append(errorCode)
                .append(" ,[错误异常信息] = ").append(msg).append(" , [异常等级] = ").append(errorLevel);

        if(errorData != null){
            sb.append(" , [异常数据] = ").append(errorData.toString());
        }
        if(args != null && args.length > 0){
            sb.append(" ,[异常参数 = ] ||");
            for(Object object : args){
                sb.append(JSONObject.toJSONString(object)).append(" || ");
            }
        }
        return sb.toString();
    }



    public static String getMessage(ExceptionSysMarkEnum sysMarkEnum, String code) {
        if (StringUtils.isNotEmpty(code)) {
            StringBuffer str = new StringBuffer();
            if (code.indexOf(sysMarkEnum.getMark()) == -1) {
                str.append(sysMarkEnum.getMark());
            }
            str.append(code);
            return str.toString();
        }
        return null;
    }





}
