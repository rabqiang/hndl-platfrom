package com.hndl.cn.shop.sys.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname
 * @Description
 * @Date
 * @Created by 湖南达联
 */
public class ShopSysException extends SysException {


    public ShopSysException(String code) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,ShopSysExceptionEnums.getExceptionMsg(code));
    }

    public ShopSysException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,ShopSysExceptionEnums.getExceptionMsg(code), e);
    }

    public ShopSysException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code,ShopSysExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
