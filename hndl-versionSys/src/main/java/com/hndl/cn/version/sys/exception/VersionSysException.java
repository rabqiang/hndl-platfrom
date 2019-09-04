package com.hndl.cn.version.sys.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname 赵俊凯
 * @Description 小程序系统异常
 * @Date 2019/3/13 15:32
 * @Created by 湖南达联
 */
public class VersionSysException extends SysException {


    public VersionSysException(String code) {
        super(ExceptionSysMarkEnum.VERSION_SYS,code, VersionSysExceptionEnums.getExceptionMsg(code));
    }

    public VersionSysException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.VERSION_SYS,code, VersionSysExceptionEnums.getExceptionMsg(code), e);
    }

    public VersionSysException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.VERSION_SYS,code, VersionSysExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
