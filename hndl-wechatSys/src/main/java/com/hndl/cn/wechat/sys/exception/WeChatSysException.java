package com.hndl.cn.wechat.sys.exception;

import com.hndl.cn.base.exception.SysException;
import com.hndl.cn.base.exception.enums.ExceptionLevelEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;

/**
 * @Classname 赵俊凯
 * @Description 小程序系统异常
 * @Date 2019/3/13 15:32
 * @Created by 湖南达联
 */
public class WeChatSysException extends SysException {


    public WeChatSysException(String code) {
        super(ExceptionSysMarkEnum.WE_CHAT_SYS,code,WechatSysExceptionEnums.getExceptionMsg(code));
    }

    public WeChatSysException(String code, Throwable e) {
        super(ExceptionSysMarkEnum.WE_CHAT_SYS,code,WechatSysExceptionEnums.getExceptionMsg(code), e);
    }

    public WeChatSysException(String code, ExceptionLevelEnums errorLevel, Throwable e) {
        super(ExceptionSysMarkEnum.WE_CHAT_SYS,code,WechatSysExceptionEnums.getExceptionMsg(code),errorLevel, e);
    }
}
