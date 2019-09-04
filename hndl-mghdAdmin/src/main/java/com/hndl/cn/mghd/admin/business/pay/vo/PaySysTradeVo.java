package com.hndl.cn.mghd.admin.business.pay.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description:TODO 支付订单vo
 * @author: 易成贤
 * @create: 2019/7/1 15:34
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "支付订单vo")
public class PaySysTradeVo  implements Serializable {
    /**
     * 支付管道
     */
    private Integer payChannel;

    /**
     * 本地系统订单id
     */
    private Long localTradeNo;

    /**
     * 第三方交易id
     */
    private String remoteTradeNo;

    /**
     * 交易创建时间
     */
    private Long createTime;

    /**
     * 回调时间
     */
    private Long callbackTime;

    /**
     * 创建用户id
     */
    private Long createUserId;

    /**
     * MD5
     */
    private String sign;

    /**
     * 交易金额（单位为分）
     */
    private Long moneyNumber;

    /**
     * 支付状态
     */
    private Integer payState;
}
