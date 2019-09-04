package com.hndl.cn.chat.sys.easemob.enums;

import java.util.Arrays;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 16:03
 * @Created by 湖南达联
 */
public enum EaseMobTargetTypeEnums {

    USERS("users","给用户发送消息"),

    CHAT_GROUPS("chatgroups","给群聊发送消息"),

    CHAT_ROOMS("chatrooms","给聊天室发送消息"),;


    private String type;

    private String description;

    EaseMobTargetTypeEnums(String type,String description){
        this.type = type;
        this.description = description;
    }


    public String getDescription(){
           return  description;
    }

    public String getType(){
        return type;
    }




    /**
     * 是否包含
     *
     * @param type
     * @return
     */
    public static boolean contains(Integer type) {
        if (type == null) {
            return false;
        }
        return Arrays.stream(EaseMobTargetTypeEnums.values()).anyMatch(input -> input.type.equals(type));
    }


    public static EaseMobTargetTypeEnums eval(Integer type) {
        if (type == null) {
            return null;
        }
        return Arrays.stream(EaseMobTargetTypeEnums.values()).filter(
                input -> input.type.equals(type)).findFirst().orElseGet(null);
    }
}
