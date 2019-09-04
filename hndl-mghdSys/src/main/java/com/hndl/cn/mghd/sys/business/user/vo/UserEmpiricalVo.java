package com.hndl.cn.mghd.sys.business.user.vo;

import com.hndl.cn.mongodb.manager.user.bean.UserEmpiricalLogDo;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/23 21:43
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户经验表")
public class UserEmpiricalVo implements Serializable {

    @ApiModelProperty(value = "用户经验值列表")
    private List<UserEmpiricalLogDo> list;//经验列表
    @ApiModelProperty(value = "用户经验描述")
    private String description;//经验描述

}
