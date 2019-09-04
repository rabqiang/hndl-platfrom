package com.hndl.cn.shop.admin.exception;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
/**
 * @Classname
 * @Description 异常码8位，19开头
 * @Date
 * @Created by 湖南达联
 */
public enum ShopAdminExceptionEnums {

    SHOP_SYS_EXCEPTION_ENUMS("19000000", "这是一个例子，请参考"),

    NUMBER_OF_DRAWS_NOT_ENOUGH("19010101", "查询不存在"),

    NUMBER_OF_VALUE_NOT_ENOUGH("19010102", "输入的数值不存在"),
    SHOP_ADMIN_DATE_ERROR("19010103","开始时间不能大于结束时间"),
    SHOP_ADMIN_START_DATE_ERROR("19010104","传入的开始时间有误"),
    SHOP_ADMIN_USER_RECEIVING("19010105","查询用户中奖商品收货地址失败"),
    SHOP_ADMIN_ADD_COMMODITY("19010106","已经有人进行操作"),
    SHOP_ADMIN_PIC_UPLOAD_FAIL_ERROR("19010107","图片地址不对,上传图片失败"),
    SHOP_ADMIN_OF_VALUE_NOT_ENOUGH("19010108", "输入的用户没有参与此次福利"),
    SHOP_ADMIN_SYSTEM_DATE_ERROR("19010109","开始时间不能小于当前时间"),
    //****图片**,
    MGHD_SYS_PIC_UPLOAD_FAIL_EXCEPTION("19020501","图片上传失败" ),
    ;


    private String code;

    private String msg;

    ShopAdminExceptionEnums(String code, String message) {
        this.code = code;
        this.msg = message;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static String getExceptionMsg(String code) {
        ShopAdminExceptionEnums exceptionEnums = null;
        for (ShopAdminExceptionEnums enums : ShopAdminExceptionEnums.values()) {
            if (enums.code.equals(code)) {
                return enums.getMsg();
            }
        }

        if (exceptionEnums == null) {
            return PublicExceptionCodeEnum.getMsg(code);
        }
        return "";
    }
}
