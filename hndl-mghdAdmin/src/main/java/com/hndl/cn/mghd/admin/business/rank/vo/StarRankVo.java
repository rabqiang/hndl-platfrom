package com.hndl.cn.mghd.admin.business.rank.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description: 后台粉丝会vo
 * @author: 易成贤
 * @create: 2019-06-27 10:52
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "粉丝会排行榜vo")
public class StarRankVo implements Serializable {

    private String id;

    private Long createTime;//创建时间，每天23：50 提前刷入

    private Long rankTime;//榜单时间，精确到天

    private Long starId;//明星id

    private String starName;//明星名称

    private String starImg;//明星图像

    private Long voteCount;//总票数

    private Integer coinCount;//送心票数

    private Integer integralCount;//积分打榜

    private Integer gettingLoveCount;//爱心票数

    private Integer currentRank;//当前排名
}
