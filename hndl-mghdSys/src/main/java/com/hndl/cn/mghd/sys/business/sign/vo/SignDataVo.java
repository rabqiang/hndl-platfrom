package com.hndl.cn.mghd.sys.business.sign.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 登陆返回值
 * @Date 2019/8/23 14:35
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "登陆返回数据")
public class SignDataVo implements Serializable {

    @ApiModelProperty(value = "返回的token")
    private String token;

    @ApiModelProperty(value = "是否是新用户 1 是 0 否")
    private Integer isNewUser;
}
