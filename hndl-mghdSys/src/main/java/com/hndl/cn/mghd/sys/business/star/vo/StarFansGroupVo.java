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
 * @description: 前端需要展示的粉丝会详细信息
 * @author: 易成贤
 * @create: 2019-04-24 11:12
 * @Created by 湖南达联
 **/
@ApiModel(value = "粉丝会详细信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarFansGroupVo implements Serializable {

    @ApiModelProperty(value = "明星id")
    private Long starId;

    @ApiModelProperty(value = "明星名称")
    private String starName;//明星名称

    @ApiModelProperty(value = "明星头像url")
    private String starImg;//明星头像

    @ApiModelProperty(value = "粉丝会当日票数")
    private Long voteCount;//投票总票数

    @ApiModelProperty(value = "投票用户数")
    private Integer voteUserCount;//投票总用户数

    @ApiModelProperty(value = "明星描述信息")
   private String starDescription;//明星描述

   // private String starType;//明星类型

   // private Integer starScore;//明星评分 //不用了

  //  private Integer sex;//明星性别

    @ApiModelProperty(value = "粉丝名称")
    private String fansName;//粉丝名称，就是给粉丝取一个统一的名称，分享时候用

   //  private Long mappingUserId;//映射用户id

    @ApiModelProperty(value = "微博id")
    private String weiboId;//微博id

    @ApiModelProperty(value = "总守护数")
    private Long guardCount;

    @ApiModelProperty(value = "当前日排名")
    private Integer currentRank;

    @ApiModelProperty(value = "是关注吗？1是0否")
    private Integer isRelation;
   // private Integer userCount;//加入粉丝会人数
}
