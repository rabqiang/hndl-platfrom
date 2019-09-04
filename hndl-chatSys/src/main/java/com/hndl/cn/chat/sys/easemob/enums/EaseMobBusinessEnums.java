package com.hndl.cn.chat.sys.easemob.enums;


/**
 * @Classname 赵俊凯
 * @Description 环信业务枚举
 * @Date 2019/3/22 10:29
 * @Created by 湖南达联
 */
public enum EaseMobBusinessEnums {


    EASE_MOB_TOKEN("token","令牌相关"),
    EASE_MOB_USER("users","用户相关"),
    EASE_MOB_CHAT_ROOM("chatrooms","聊天室相关"),
    EASE_MOB_MSG("messages","消息相关");



    private String businessUrl;

    private String description;



    EaseMobBusinessEnums(String businessUrl,String description){
            this.businessUrl = businessUrl;
            this.description = description;
    }

    public String getBusinessUrl(){
        return businessUrl;
    }

    public static String getEasemobServeUrl(String[] strings){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < strings.length; i++){
            if(i == 0){
                stringBuilder.append(strings[i]);
            }else {
                stringBuilder.append("/").append(strings[i]);
            }

        }
        return stringBuilder.toString();
    }

}
