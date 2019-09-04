package com.hndl.cn.mghd.job.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

import java.util.Arrays;

/**
 * @Classname 赵俊凯
 * @Description MGHD_JOB，异常码8位，15开头
 * @Date 2019/3/20 9:32
 * @Created by 湖南达联
 */
public enum MghdJobSysExceptionEnums {

    MGHD_JOB_SYS_EXCEPTION_ENUMS("15000000","这是一个例子，请参考"),

    MGHD_JOB_NOUSERDATA_EXCEPTION("15000100","没有用户信息"),

    MGHD_JOB_NOJOB_EXCEPTION("15000200","没有Job信息"),

    MGHD_JOB_JOBRUN_EXCEPTION("15000201","该Job是运行状态"),

    SEND_WECHAT_MESSAGE_FAIL("15000202","小程序消息推送失败"),

    ;


    private String code;

    private String msg;

    MghdJobSysExceptionEnums(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public static String getExceptionMsg(String code){
        MghdJobSysExceptionEnums exceptionEnums = Arrays.stream(MghdJobSysExceptionEnums.values())
                .filter(wechatSysExceptionEnums -> wechatSysExceptionEnums.code.equals(code))
                  .findFirst().orElseGet(null);
        if(exceptionEnums == null){
           return PublicExceptionCodeEnum.getMsg(code);
        }
        return "";
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
