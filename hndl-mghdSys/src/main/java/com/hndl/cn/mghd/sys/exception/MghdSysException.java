package com.hndl.cn.mghd.sys.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname 赵俊凯
 * @Description 小程序系统异常
 * @Date 2019/3/13 15:32
 * @Created by 湖南达联
 */
public class MghdSysException extends SysException {


    public MghdSysException(String code) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,MghdSysExceptionEnums.getExceptionMsg(code));
    }

    public MghdSysException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,MghdSysExceptionEnums.getExceptionMsg(code), e);
    }

    public MghdSysException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,MghdSysExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
