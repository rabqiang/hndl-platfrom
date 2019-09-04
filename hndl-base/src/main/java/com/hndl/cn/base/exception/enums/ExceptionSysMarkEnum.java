package com.hndl.cn.base.exception.enums;

/**
 * <pre>
 *  
 *
 * 【标题】: 异常-系统标识-枚举
 * 【描述】: 
 * 【版权】: 润投科技
 * 【作者】: 赵俊凯
 * 【时间】: 2017年6月21日 上午10:29:56
 * </pre>
 */
public enum ExceptionSysMarkEnum {


    /**
     * mghd后台管理中心异常标识
     */
    MGHD_ADMIN_MARK("MGHD_ADMIN"),
    /**
     * 小程序
     */
    WE_CHAT_SYS("WE_CHAT_SYS"),


    /**
     * MGHD的jobW
     */
    MGHD_JOB_SYS("MGHD_JOB_SYS"),


    MGHD_SYS("MGHD_SYS"),

    /**
     * 聊天系统
     */
    CHAT_SYS("CHAT_SYS"),


    /**
     * 聊天系统
     */
    ACTIVITY_SYS("ACTIVITY_SYS"),


    /**
     * 支付系统
     */
    PAY_SYS("PAY_SYS"),


    VERSION_SYS("VERSION_SYS"),

    SHOP_SYS("SHOP_SYS")
    ;

    
    private String mark;

    ExceptionSysMarkEnum(String mark) {
        this.mark = mark;

    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

}
