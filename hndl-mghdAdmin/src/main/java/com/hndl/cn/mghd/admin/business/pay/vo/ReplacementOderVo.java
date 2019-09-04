package com.hndl.cn.mghd.admin.business.pay.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description:TODO 补单信息vo
 * @author: 易成贤
 * @create: 2019/8/7 20:23
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "补单vo")
public class ReplacementOderVo implements Serializable {


    @ApiModelProperty("用户unId")
    @NotNull
    Long userUniId;

    @ApiModelProperty("本地订单号")
    @NotNull
    Long localOrder;

    @ApiModelProperty("备注信息")
    @NotBlank
    String remark;

    @ApiModelProperty("是否强制")
    @NotNull
    Integer isEnforcement;
}
