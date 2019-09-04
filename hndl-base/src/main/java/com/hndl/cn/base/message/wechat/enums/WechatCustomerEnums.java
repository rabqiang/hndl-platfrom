package com.hndl.cn.base.message.wechat.enums;


/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/26 15:02
 * @Created by 湖南达联
 */
public enum WechatCustomerEnums {

    TEXT(10,"text"),

    IMAGE(20,"image"),

    LINK(30,"link"),

    MINPROGRAMPAGE(40,"minprogrampage"),

    TRANSFER_CUSTOMER(50,"transfer_customer_service")
    ;

    WechatCustomerEnums(Integer code,String type){
        this.code = code;
        this.type = type;
    }

    private Integer code;


    private String type;




    public String getType(){
        return type;
    }

    public Integer getCode() {
        return code;
    }

    public static WechatCustomerEnums evalVal(String type) {
        for (WechatCustomerEnums wechatCustomerEnums : WechatCustomerEnums.values()) {
            if (wechatCustomerEnums.getType().equals(type)) {
                return wechatCustomerEnums;
            }
        }
        return null;
    }

    public static WechatCustomerEnums evalVal(Integer code) {
        for (WechatCustomerEnums wechatCustomerEnums : WechatCustomerEnums.values()) {
            if (wechatCustomerEnums.getCode().equals(code)) {
                return wechatCustomerEnums;
            }
        }
        return null;
    }

}
