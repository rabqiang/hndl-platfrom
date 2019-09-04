package com.hndl.cn.mghd.sys.business.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/24 10:45
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "公众号显示用户信息")
public class UserInfoVo implements Serializable {
    /**
     * 快乐号
     */
    @ApiModelProperty(value = "用户快乐号")
    private Long id;

    /**
     * 用户昵称
     */
    @ApiModelProperty(value = "用户昵称")
    private String nickName;
    /**
     * 头像
     */
    @ApiModelProperty(value = "用户头像")
    private String imgMin;
}
