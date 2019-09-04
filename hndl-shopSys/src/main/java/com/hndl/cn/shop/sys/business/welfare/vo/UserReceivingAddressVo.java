package com.hndl.cn.shop.sys.business.welfare.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname 用户中奖记录VO
 * @Created by 湖南达联
 * @Date 2019/8/6 14 16
 * @Description:
 * @Author: 资龙茂
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "中奖记录/收货地址VO类")
public class UserReceivingAddressVo {

    @ApiModelProperty("中奖记录id")
    private String id;

    @ApiModelProperty("用户id")
    private Long userUniId;//用户id

    @ApiModelProperty("期号")
    private String welfareNumber;//期号

    @ApiModelProperty("收货人手机号")
    private String phoneNumber;//收货人手机号

    @ApiModelProperty("收货人姓名")
    private String receivingName;//收货人姓名

    @ApiModelProperty("收货地址")
    private String receivingAddress;//收货地址

    @ApiModelProperty("是否发货")
    private Integer isDelivery;  //是否发货

    @ApiModelProperty("奖品封面图")
    private String prizeImg; // 奖品封面图

    @ApiModelProperty("奖品名")
    private String prizeName; // 奖品名

    @ApiModelProperty("创建(中奖)时间")
    private Long createTime; // 创建(中奖)时间

    @ApiModelProperty("备注")
    private String reason; // 备注
}