package com.hndl.cn.mghd.sys.business.sign.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description  手机登陆入参VO
 * @Date 2019/4/23 13:43
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "手机登录入参")
public class MobileLoginParamVo implements Serializable {

    @NotBlank(message = "手机号不能为空")
    @ApiModelProperty(value = "手机号",required = true)
    private String mobile;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码",required = true)
    private String verifyCode;

    private String deviceNumber;

}
