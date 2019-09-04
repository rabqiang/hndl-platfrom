package com.hndl.cn.base.enums.welfare;

/**
 * @program:hndl-platform
 * @description:TODO 福利类型枚举
 * @author: 易成贤
 * @create: 2019/7/22 17:11
 * @Created by湖南达联
 **/
public enum WelfareTypeEnums {
    RotaryDraw(1,"大转盘福利"),
    HelpWelfare(2,"福利商城中奖福利"),
    ;

    /**
     *
     */
    private Integer value;
    /**
     *
     */
    private String description;

    WelfareTypeEnums(Integer value, String description) {
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
