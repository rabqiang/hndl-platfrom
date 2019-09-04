package com.hndl.cn.base.enums.fans;

/**
 * @author 赵俊凯
 * @Description 粉丝会行为贡献
 * @Date 2019/4/25 14:19
 * @Created by 湖南达联
 */
public enum  FansGroupContributeEnums {

    GUARD(1,20,"守护贡献值"),

    SUMMON(1,20,"召唤贡献值"),

    CALL(1,10,"打CALL贡献值"),

    COMMENT(1,10,"打CALL贡献值"),

    LIKE(1,10,"点赞贡献值"),



    ;

    private Integer dayCount;//每天的次数

    private Integer contributeCount;//每次获得的经验值

    private String description;//描述

    FansGroupContributeEnums(Integer dayCount, Integer contributeCount, String description) {
        this.dayCount = dayCount;
        this.contributeCount = contributeCount;
        this.description = description;
    }


    public Integer getDayCount() {
        return dayCount;
    }

    public Integer getContributeCount() {
        return contributeCount;
    }

    public String getDescription() {
        return description;
    }
}
