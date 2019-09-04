package com.hndl.cn.mghd.sys.business.pay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program: hndl-platform
 * @description: 快乐币流水vo
 * @author: 易成贤
 * @create: 2019-05-22 16:58
 * @Created by 湖南达联
 **/
@ApiModel(value = "快乐币流水")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class HappyCoinBillInfoVo {

    /**
     * 是否支出 0 收入 1 支出
     */
    @ApiModelProperty(value = "是否支出: <b>0收入|1支出</b>")
    private Integer isPay;

    /**
     * 对应的是充值通道,如果是支出，那么就应该是系统消费PayChannelEnums.
     */
    @ApiModelProperty(value = "充值类型/消费类型")
    private Integer payType;

    /**
     * 单位为分
     */
    @ApiModelProperty(value = "快乐币数量<b>单位分</b>")
    private Long coinCount;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    /**
     * 本地订单id
     */
    @ApiModelProperty(value = "本地订单id")
    private Long localTradeNo;

    /**
     * 第三方充值订单
     */
    @ApiModelProperty(value = "第三方充值订单")
    private String remoteTradeNo;

    /**
     * 交易前的余额
     */
    @ApiModelProperty(value = "交易前的余额")
    private Long oldCoinCount;

    /**
     * 交易后的余额
     */
    @ApiModelProperty(value = "交易后的余额")
    private Long newCoinCount;

    /**
     * 消费的具体类型
     */
    @ApiModelProperty(value = "消费的具体类型")
    private Integer reasonType;

    /**
     * 解释说明
     */
    @ApiModelProperty(value = "收入/支出的文案")
    private String payReasonDescription;
    /**
     * 绑定id
     */
    @ApiModelProperty(value = "消费类型绑定的id")
    private String reasonObjId;



}
