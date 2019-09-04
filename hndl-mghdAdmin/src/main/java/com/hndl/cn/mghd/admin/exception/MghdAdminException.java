package com.hndl.cn.mghd.admin.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname 赵俊凯
 * @Description 芒果互动后台异常
 * @Date 2019/3/13 15:32
 * @Created by 湖南达联
 */
public class MghdAdminException extends SysException {


    public MghdAdminException(String code) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,MghdAdminExceptionEnums.getExceptionMsg(code));
    }

    public MghdAdminException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,MghdAdminExceptionEnums.getExceptionMsg(code), e);
    }

    public MghdAdminException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,MghdAdminExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
