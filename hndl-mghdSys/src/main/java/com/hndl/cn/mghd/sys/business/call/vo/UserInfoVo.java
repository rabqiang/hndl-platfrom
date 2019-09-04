package com.hndl.cn.mghd.sys.business.call.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description: 用于查询用户打call的头部信息展示
 * @author: 易成贤
 * @create: 2019-06-04 17:36
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "用户数据", description = "返回用户打call数据")
public class UserInfoVo implements Serializable {
    @ApiModelProperty(value = "用户头像url")
    private String userImgUrl;

    @ApiModelProperty(value = "用户昵称")
    private String userNickName;

    @ApiModelProperty(value = "个人签名")
    private String personalSignature;

    @ApiModelProperty(value = "是否关注")
    private Integer isFollow;
}
