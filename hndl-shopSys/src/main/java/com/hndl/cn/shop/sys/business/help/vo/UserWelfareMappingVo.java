package com.hndl.cn.shop.sys.business.help.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname 用户助力VO
 * @Created by 湖南达联
 * @Date 2019/8/2 17 30
 * @Description:
 * @Author: 资龙茂
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "个人助力信息VO类")
public class UserWelfareMappingVo{

    private String id;

    @ApiModelProperty("期号")
    private String welfareNumber;//期号

    @ApiModelProperty("用户id")
    private Long userUniId;//用户id

    @ApiModelProperty("微信openId，发消息用")
    private String openId;//微信openId，发消息用

    @ApiModelProperty("用户昵称")
    private String userNickName;//用户昵称 冗余

    @ApiModelProperty("用户头像")
    private String userImg;//用户头像 冗余

    @ApiModelProperty("小程序提交的fromId 发消息用")
    private String fromId; //小程序提交的fromId 发消息用

    @ApiModelProperty("创建时间")
    private Long createTime;//创建时间

    @ApiModelProperty("助力值")
    private Integer helpCount;//助力值

    @ApiModelProperty("最后助力值")
    private Integer lastHelpCount;//最后助力值

    @ApiModelProperty("删除状态")
    private Integer isDelete;//是否删除

}
