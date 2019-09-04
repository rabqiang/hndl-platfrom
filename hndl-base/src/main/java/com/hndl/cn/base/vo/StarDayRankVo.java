package com.hndl.cn.base.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 前台展示V
 * @Date 2019/4/26 15:56
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarDayRankVo implements Serializable {

    private Long rankTime;//榜单时间，精确到天

    private Long starId;//明星id

    private String starName;//明星名称

    private String starImg;//明星图像

    private Long voteCount;//总票数

    private Integer coinCount;//送心票数

    private Integer integralCount;//积分打榜

    private Integer gettingLoveCount;//爱心票数

    private Integer currentRank;//当前排名

    private Integer lastRank;//上次排名
}
