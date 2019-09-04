package com.hndl.cn.shop.admin.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname
 * @Description
 * @Date
 * @Created by 湖南达联
 */
public class ShopAdminException extends SysException {


    public ShopAdminException(String code) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code, ShopAdminExceptionEnums.getExceptionMsg(code));
    }

    public ShopAdminException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code, ShopAdminExceptionEnums.getExceptionMsg(code), e);
    }

    public ShopAdminException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.MGHD_SYS,code, ShopAdminExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
