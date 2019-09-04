package com.hndl.cn.ali.mq.enums;

/**
 * @author 赵俊凯
 * @Description 发送模式
 * @Date 2019/4/24 17:52
 * @Created by 湖南达联
 */
public enum  RocketSendTypeEnums {

    SYNCH("同步方式"),

    ASYNC("异步方式"),

    ONEWAY("单向发送"),

    ;

    private String description;


    RocketSendTypeEnums(String description) {
        this.description = description;
    }


}
