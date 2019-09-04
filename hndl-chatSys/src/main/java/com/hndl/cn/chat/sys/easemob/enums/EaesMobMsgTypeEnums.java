package com.hndl.cn.chat.sys.easemob.enums;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 16:52
 * @Created by 湖南达联
 */
public enum EaesMobMsgTypeEnums {

    TXT("txt","文本消息"),

    IMG("img","给群聊发送消息"),

    IOC("loc","位置消息"),

    AUDIO("audio","语音消息"),

    VIDEO("video","视频消息"),

    FILE("file","文件消息"),

    ;


    private String type;

    private String description;

    EaesMobMsgTypeEnums(String type,String description){
        this.type = type;
        this.description = description;
    }


    public String getDescription(){
        return  description;
    }

    public String getType(){
        return type;
    }
}
