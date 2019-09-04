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
 * @description:TODO
 * @author: 易成贤
 * @create: 2019/7/15 20:17
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "消费类型vo")
public class PayReasonVo implements Serializable {

    @ApiModelProperty("消费类型")
    private Integer reasonType;

    @ApiModelProperty("解释说明")
    private String description;
}
