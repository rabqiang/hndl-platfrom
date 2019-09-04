package com.hndl.cn.base.enums.pay;

/**
 * <pre>
 *
 * 【标题】:
 * 【描述】: 支付状态
 * 【版权】: 湖南达联
 * 【作者】: 赵俊凯
 * 【时间】: 2017/11/29 0029 9:43
 * </pre>
 */
public enum PayStatusEnum {

    PAY(11, "支付完成"),//业务系统响应成功
    NOT_PAY(0, "未支付"),//未接到微信的回调
    FAIL_PAY(2, "异常订单");//接收到微信回调,但是业务系统异常

    private Integer code;

    private String value;

    public static PayStatusEnum eval(Integer code) {
        for (PayStatusEnum type : PayStatusEnum.values()) {
            if (type.getCode().equals(code)) {
                return type;
            }
        }
        return null;
    }

    public static boolean contains(Integer code) {
        for (PayStatusEnum type : PayStatusEnum.values()) {
            if (type.getCode().equals(code)) {
                return true;
            }
        }
        return false;
    }

    PayStatusEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static PayStatusEnum evalVal(Integer payStatusCode) {
        for (PayStatusEnum payStatusEnum : PayStatusEnum.values()) {
            if (payStatusEnum.getCode().equals(payStatusCode)) {
                return payStatusEnum;
            }
        }
        return null;
    }
}
