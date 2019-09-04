package com.hndl.cn.mghd.admin.business.pay.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description:TODO 快乐币vo
 * @author: 易成贤
 * @create: 2019/7/1 15:35
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "快乐币vo")
public class HappyCoinBillInfoVo implements Serializable {
    /**
     * 是否支出 0 收入 1 支出
     */
    private Integer isPay;

    /**
     * 对应的是充值通道
     */
    private String payType;

    /**
     * 单位为分
     */
    private Long coinCount;

    /**
     * 创建时间
     */
    private Long createTime;

    /*   * 本地订单id
     */
    private Long localTradeNo;

    /**
     * 第三方充值订单
     */
    private String remoteTradeNo;

    /**
     * 交易前的余额
     */
    private Long oldCoinCount;

    /**
     * 交易后的余额
     */
    private Long newCoinCount;

    /**
     * 创建用户id
     */
    private Long createUserId;

    /**
     * 消费的具体类型
     */
    private String reasonType;

    /**
     * 绑定id
     */
    private String reasonObjId;
}
