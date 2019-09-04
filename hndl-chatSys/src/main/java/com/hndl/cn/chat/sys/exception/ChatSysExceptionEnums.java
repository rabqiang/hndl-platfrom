package com.hndl.cn.chat.sys.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;

import java.util.Arrays;

/**
 * @Classname 赵俊凯
 * @Description wecatsys业务异常类，异常码8位，14开头
 * @Date 2019/3/20 9:32
 * @Created by 湖南达联
 */
public enum ChatSysExceptionEnums {

    CHAT_SYS_EXCEPTION_ENUMS("14000000","这是一个例子，请参考"),

    CHAT_SYS_EX_EASE_MOB_CREATE_USER_ERROR("14001001","注册环信用户失败"),

    CHAT_SYS_EX_EASE_MOB_FIND_USER_ERROR("14001002","用户不存在"),

    CHAT_SYS_EX_EASE_MOB_CREATE_ROOM_ERROR("14001101","创建聊天室失败"),

    CHAT_SYS_EX_EASE_MOB_USER_TO_CREATE_ROOM_ERROR("14001102","用户加入聊天室失败"),

    CHAT_SYS_EX_EASE_MOB_CREATE_RUN_TIME_ROOM_ERROR("14001103","正在创建聊天室，请稍后"),

    CHAT_SYS_EX_EASE_MOB_SEND_MSG_ERROR("14001201","用户发送消息失败"),

    CHAT_SYS_EX_SEND_MSG_TASK_ERROR("14001202","已经完成发言任务"),

    CHAT_SYS_EX_USER_TO_FANS_GROUP_ERROR("14002001","用户没有加入粉丝会"),

    CHAT_SYS_EX_FANS_GROUP_NOT_FIND_ERROR("14002002","粉丝会不存在"),
    ;


    private String code;

    private String msg;

    ChatSysExceptionEnums(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public String getCode(){
        return code;
    }

    public String getMsg(){
        return msg;
    }

    public static String getExceptionMsg(String code){
        ChatSysExceptionEnums exceptionEnums = null;
        for(ChatSysExceptionEnums enums : ChatSysExceptionEnums.values()){
                if(enums.code.equals(code)){
                      return enums.getMsg();
                }
        }

        if(exceptionEnums == null){
           return PublicExceptionCodeEnum.getMsg(code);
        }
        return "";
    }
}
