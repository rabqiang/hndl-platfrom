package com.hndl.cn.base.enums;

/**
 * @author 赵俊凯
 * @Description 请求来源
 * @Date 2019/4/18 16:48
 * @Created by 湖南达联
 */
public enum RequestTypeEnums {

     IOS("ios"),//ios

     ANDROID("android"),//安卓

     WECHAT_PROGRAM("wechat"),

     SERVER("server"),//小程序
    ;

     private String value;

    RequestTypeEnums(String value){
            this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static boolean checkVal(String value) {
        if (value != null) {
            for (RequestTypeEnums c : RequestTypeEnums.values()) {
                if (c.getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }
}
