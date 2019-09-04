package com.hndl.cn.base.enums.permission;

/**
 * @program: hndl-platform
 * @description: 定义用户权限的枚举
 * @author: 易成贤
 * @create: 2019-04-18 14:08
 * @Created by 湖南达联
 **/
public enum  RelationPermissionEnum {

    FANS_ORDINARY(10,"普通粉丝"),
    FANS_MASTER(20,"粉丝大咖"),
    FANS_AMBASSADOR(30,"明星守护大使")
    ;
    private Integer value;//定义权限值
    private String description;//描述

    RelationPermissionEnum(Integer value, String description) {
        this.value = value;
        this.description = description;
    }

    public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
