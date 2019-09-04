package com.hndl.cn.mghd.sys.business.star.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: hndl-platform
 * @description: 展示粉丝会相关信息给前端
 * @author: 易成贤
 * @create: 2019-04-23 16:09
 * @Created by 湖南达联
 **/
@ApiModel(value = "粉丝会与粉丝会关系数据")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarFansGroupRelationVo implements Serializable {


    @ApiModelProperty(value = "明星id")
    private Long starId;//明星id

    @ApiModelProperty(value = "用户贡献值")
    private Long fansContribute;//粉丝贡献

    @ApiModelProperty(value = "用户投票数")
    private Long voteCount;//粉丝票数

    @ApiModelProperty(value = "用户送心票数")
    private Integer coinCount;//送心票数

    @ApiModelProperty(value = "用户积分打榜票数")
    private Integer integralCount;//积分打榜票数

    @ApiModelProperty(value = "用户公益送爱心数")
    private Integer gettingLoveCount;//爱心数

    @ApiModelProperty(value = "用户权限")
    private Integer power;//权限
}
