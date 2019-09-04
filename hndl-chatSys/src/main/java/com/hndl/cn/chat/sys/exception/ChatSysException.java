package com.hndl.cn.chat.sys.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname 赵俊凯
 * @Description 小程序系统异常
 * @Date 2019/3/13 15:32
 * @Created by 湖南达联
 */
public class ChatSysException extends SysException {


    public ChatSysException(String code) {
        super(ExceptionSysMarkEnum.CHAT_SYS,code,ChatSysExceptionEnums.getExceptionMsg(code));
    }

    public ChatSysException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.CHAT_SYS,code,ChatSysExceptionEnums.getExceptionMsg(code), e);
    }

    public ChatSysException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.CHAT_SYS,code,ChatSysExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
