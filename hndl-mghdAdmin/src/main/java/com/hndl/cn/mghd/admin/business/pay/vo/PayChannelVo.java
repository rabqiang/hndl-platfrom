package com.hndl.cn.mghd.admin.business.pay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description:TODO 支付渠道vo
 * @author: 易成贤
 * @create: 2019/7/3 16:16
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "支付渠道vo")
public class PayChannelVo implements Serializable {

    @ApiModelProperty("代码")
    private Integer channelType;

    @ApiModelProperty("解释")
    private String description;
}
