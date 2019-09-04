package com.hndl.cn.base.enums.message;

/**
 * @author 赵俊凯
 * @Description 消息类型
 * @Date 2019/5/22 10:22
 * @Created by 湖南达联
 */
public enum MessageTypeEnums {


    SYS_MSG(10,"系统消息"),

    LIKE_MSG(20,"点赞消息"),

    COMMENT_MSG(30,"评论消息"),


    ;

    private Integer type;

    private String description;


    MessageTypeEnums(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    public Integer getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
