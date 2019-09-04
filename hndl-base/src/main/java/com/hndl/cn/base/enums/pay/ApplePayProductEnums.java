package com.hndl.cn.base.enums.pay;

import com.hndl.cn.utils.string.StringUtils;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/26 15:41
 * @Created by 湖南达联
 */
public enum ApplePayProductEnums {

    ONE("com.huliantongda.kuailefensihui.06",400L,600L),

    TWO("com.huliantongda.kuailefensihui.018",1200L,1800L),

    THREE("com.huliantongda.kuailefensihui.088",6000L,8800L),

    FOUR("com.huliantongda.kuailefensihui.00188",12800L,18800L),

    FIVE("com.huliantongda.kuailefensihui.0328",22800L,32800L),

    SIX("com.huliantongda.kuailefensihui.0618",42300L,61800L),

    ;


    private String productId;

    private Long  orderNum;

    private Long  actualSum;

    ApplePayProductEnums(String productId, Long orderNum,Long actualSum) {
        this.productId = productId;
        this.orderNum = orderNum;
        this.actualSum = actualSum;
    }

    public String getProductId() {
        return productId;
    }

    public Long getActualSum() {
        return actualSum;
    }

    public static ApplePayProductEnums getEnumsByProductId(String productId){
        if(StringUtils.isNotBlank(productId)){
            for(ApplePayProductEnums enums : ApplePayProductEnums.values()){
                 if(enums.getProductId().equals(productId)){
                        return enums;
                 }
            }
        }
        return null;
    }

   public static ApplePayProductEnums getByorderNum(Long orderNum){
        for (ApplePayProductEnums value : ApplePayProductEnums.values()) {
            if (value.getOrderNum().equals(orderNum)){
                return value;
            }
        }
        return null;
    }

    public Long getOrderNum() {
        return orderNum;
    }
}
