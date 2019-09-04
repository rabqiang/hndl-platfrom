package com.hndl.cn.mongodb.manager.star.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @author 赵俊凯
 * @Description 用户月榜统计
 * @Date 2019/4/29 20:16
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_star_fans_month_statistics")
@CompoundIndexes({@CompoundIndex(unique = true,name="fans_month_statistics_index",def = "{userUniId:1,starId:1,createTime:-1}")})
public class StarFansMonthStatisticsDo implements Serializable {

    @Id
    private String id;

    @Indexed
    private Long createTime;//创建时间 月初时间

    @Indexed
    private Long userUniId;//用户id

    private String userNickName;//用户昵称 冗余

    private String userImg;//用户图片

    @Indexed
    private Long starId;//明星id

    private String starName;//明星名称 冗余

    private String starImg;//明星图片

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long voteCount;//票数

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long fansContribute;//粉丝贡献


    private Integer callCount;//打casll数

    private Integer guardCount;//守护数

    private Integer summonCount;//召唤数

    private Integer likeCount;//点赞数

    private Integer commentCount;//评论数

    private Integer coinCount;//比心数

    private Integer integralCount;//积分数

    private Integer gettingLoveCount;//爱心数
}
