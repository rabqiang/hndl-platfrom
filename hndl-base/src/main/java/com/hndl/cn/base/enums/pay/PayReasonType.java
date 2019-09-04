package com.hndl.cn.base.enums.pay;

/**
 * @author 赵俊凯
 * @Description 消费类型
 * @Date 2019/5/9 10:36
 * @Created by 湖南达联
 */
public enum  PayReasonType {

    HAPPY_COIN_PAY(111,"充    值"),

    HAPPY_COIN_VOTE(11,"比心打榜"),

    HAPPY_SYSTEM_VOTE(1,"系统操作"),
    ;

    public static final String HAPPY_COIN_PAY_ID = "0000";//充值使用的默认消费id

    private Integer reasonType;

    private String description;

    PayReasonType(Integer reasonType,String description){
        this.reasonType = reasonType;
        this.description = description;
    }

    public static PayReasonType evalVal(Integer reasonType) {
        for (PayReasonType type : PayReasonType.values()) {
            if (type.getReasonType().equals(reasonType)) {
                return type;
            }
        }
        return null;
    }

    public Integer getReasonType(){
        return reasonType;
    }
    public String getDescription(){
        return description;
    }

}
