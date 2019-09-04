package com.hndl.cn.shop.sys.business.welfare.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

/**
 * @program:hndl-platform
 * @description:TODO
 * @author: 易成贤
 * @create: 2019/8/10 15:32
 * @Created by湖南达联
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel("提交收货地址vo")
public class SubmitAddressVo {

    @ApiModelProperty("期号")
    @NotBlank
    String welfareNumber;
    @ApiModelProperty("手机号")
    @NotBlank
    String phoneNumber;
    @ApiModelProperty(value = "收货人姓名")
    @NotBlank
    String receivingName;
    @ApiModelProperty(value = "收货地址")
    @NotBlank
    String receivingAddress;
    @ApiModelProperty("备注")
    String reason;
}
