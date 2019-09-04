package com.hndl.cn.activity.sys.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname 赵俊凯
 * @Description 活动系统异常
 * @Date 2019/3/13 15:32
 * @Created by 湖南达联
 */
public class ActivitySysException extends SysException {


    public ActivitySysException(String code) {
        super(ExceptionSysMarkEnum.ACTIVITY_SYS,code,ActivitySysExceptionEnums.getExceptionMsg(code));
    }

    public ActivitySysException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.ACTIVITY_SYS,code,ActivitySysExceptionEnums.getExceptionMsg(code), e);
    }

    public ActivitySysException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.ACTIVITY_SYS,code,ActivitySysExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
