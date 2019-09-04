package com.hndl.cn.mghd.job.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname 赵俊凯
 * @Description 芒果互动_JOB异常
 * @Date 2019/3/13 15:32
 * @Created by 湖南达联
 */
public class MghdJobSysException extends SysException {


    public MghdJobSysException(String code) {
        super(ExceptionSysMarkEnum.MGHD_JOB_SYS,code,MghdJobSysExceptionEnums.getExceptionMsg(code));
    }

    public MghdJobSysException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_JOB_SYS,code,MghdJobSysExceptionEnums.getExceptionMsg(code), e);
    }

    public MghdJobSysException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_JOB_SYS,code,MghdJobSysExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
