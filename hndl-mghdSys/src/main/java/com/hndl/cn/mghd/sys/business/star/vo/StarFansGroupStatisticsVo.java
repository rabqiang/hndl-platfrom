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
 * @description: 用户相关统计数据
 * @author: 易成贤
 * @create: 2019-05-16 18:06
 * @Created by 湖南达联
 **/
@ApiModel(value = "用户与粉丝会统计数据")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarFansGroupStatisticsVo implements Serializable {

    @ApiModelProperty(value = "用户贡献值")
    private Long fansContribute;//粉丝贡献

    @ApiModelProperty(value = "粉丝会票数")
    private Long starVoteCount;

    @ApiModelProperty(value = "用户投票数")
    private Long fansVoteCount;//粉丝票数

    @ApiModelProperty(value = "累计投票天数")
    private Integer voteDayCount;//累计打榜天数
}
