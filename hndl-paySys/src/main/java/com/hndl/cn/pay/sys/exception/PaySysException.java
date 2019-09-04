package com.hndl.cn.pay.sys.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname 赵俊凯
 * @Description 小程序系统异常
 * @Date 2019/3/13 15:32
 * @Created by 湖南达联
 */
public class PaySysException extends SysException {


    public PaySysException(String code) {
        super(ExceptionSysMarkEnum.PAY_SYS,code,PaySysExceptionEnums.getExceptionMsg(code));
    }

    public PaySysException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.PAY_SYS,code,PaySysExceptionEnums.getExceptionMsg(code), e);
    }

    public PaySysException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.PAY_SYS,code,PaySysExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
