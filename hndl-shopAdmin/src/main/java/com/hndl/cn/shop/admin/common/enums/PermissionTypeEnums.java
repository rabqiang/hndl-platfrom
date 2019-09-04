package com.hndl.cn.shop.admin.common.enums;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 10:30
 * @Created by 湖南达联
 */
public enum PermissionTypeEnums {

    MENU(1,"菜单"),

    BUTTON(2,"按钮"),


    ;

    PermissionTypeEnums(Integer type, String description) {
        this.type = type;
        this.description = description;
    }

    private Integer type;

    private String description;

    public Integer getType() {
        return type;
    }

    public String getDescription() {
        return description;
    }
}
