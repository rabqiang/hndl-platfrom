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
 * @description:TODO 查询支付状态Vo
 * @author: 易成贤
 * @create: 2019/7/3 16:24
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "支付状态vo")
public class PayStatusVo implements Serializable {
    @ApiModelProperty("代号")
    private Integer code;
    @ApiModelProperty("值")
    private String value;

}
