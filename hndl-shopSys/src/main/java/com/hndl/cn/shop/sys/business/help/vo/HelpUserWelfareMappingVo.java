package com.hndl.cn.shop.sys.business.help.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname 好友助力VO
 * @Created by 湖南达联
 * @Date 2019/8/2 17 31
 * @Description:
 * @Author: 资龙茂
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "好友助力VO类")
public class HelpUserWelfareMappingVo {

    private String id;

    @ApiModelProperty("期号")
    private String welfareNumber;//期号

    @ApiModelProperty("用户id")
    private Long userUniId;//用户id

    @ApiModelProperty("用户昵称")
    private String userNickName;//用户昵称 冗余

    @ApiModelProperty("用户头像")
    private String userImg;//用户头像 冗余

    @ApiModelProperty("被助力用户ID")
    private Long helpUserId;//被助力用户ID

    @ApiModelProperty("创建时间")
    private Long createTime;//创建时间

    @ApiModelProperty("助力值")
    private Integer helpCount;//助力值

    @ApiModelProperty("删除状态")
    private Integer isDelete;//是否删除
}

