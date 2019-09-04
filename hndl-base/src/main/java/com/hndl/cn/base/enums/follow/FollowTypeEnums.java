package com.hndl.cn.base.enums.follow;

public enum FollowTypeEnums {


    STAR_FOLLOW(10,"star 粉丝会"),

    USER_FOLLOW(20,"user 普通用户"),


    ;

    private Integer type;

    private String description;


    FollowTypeEnums(Integer type, String description) {
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
