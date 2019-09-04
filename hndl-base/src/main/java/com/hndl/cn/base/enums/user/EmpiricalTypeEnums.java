package com.hndl.cn.base.enums.user;

/**
 * @author 赵俊凯
 * @Description 经验类型枚举
 * @Date 2019/4/18 20:35
 * @Created by 湖南达联
 */
public enum  EmpiricalTypeEnums {


    PLATFORM(10,"平台经验"),

    FANS_GROUP(20,"粉丝会经验");


    private Integer empiricalType;//经验类型

    private String description;//描述


    EmpiricalTypeEnums(Integer empiricalType,String description){
        this.empiricalType = empiricalType;
        this.description = description;
    }

    public Integer getEmpiricalType() {
        return empiricalType;
    }

    public String getDescription() {
        return description;
    }
}
