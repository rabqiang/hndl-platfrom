package com.hndl.cn.base.exception;


import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * <pre>
 *
 * 【标题】: 系统异常
 * 【描述】:
 * 【版权】: 湖南达联
 * 【作者】: 赵俊凯
 * 【时间】: 2018-01-08 11:12
 * </pre>
 */
public abstract  class SysException extends BaseException {

    public SysException(ExceptionSysMarkEnum exceptionSysMarkEnum, String code,String msg) {
        super(code, msg,exceptionSysMarkEnum);
    }

    public SysException(ExceptionSysMarkEnum exceptionSysMarkEnum, String code, String mag,Throwable e) {
        super(code, mag,exceptionSysMarkEnum, e);
    }

    public SysException(ExceptionSysMarkEnum exceptionSysMarkEnum, String code,String msg, ExceptionLevelEnums errorLevel, Throwable e) {
        super(code, msg,errorLevel,exceptionSysMarkEnum, e);
    }

}
