package com.hndl.cn.ali.mq.enums;

/**
 * @author 赵俊凯
 * @Description RocketTag 的枚举
 * @Date 2019/4/24 16:59
 * @Created by 湖南达联
 */
public enum  RocketTagEnums {



    ;


    private String code;

    private String message;

    RocketTagEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
