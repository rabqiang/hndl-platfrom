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
 * @Classname 赵俊凯
 * @Description 每天明星榜单数据   资龙茂 同步历史数据
 * @Date 2019/4/17 20:36
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_star_day_rank")
@CompoundIndexes({@CompoundIndex(unique = true,name="star_day_rank_index",def = "{starId:1,rankTime:1}")})
public class StarDayRankDo implements Serializable {

    @Id
    private String id;

    private Long createTime;//创建时间，每天23：50 提前刷入

    private Long rankTime;//榜单时间，精确到天

    private Long starId;//明星id

    private String starName;//明星名称

    private String starImg;//明星图像

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long voteCount;//总票数

    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer coinCount;//送心票数

    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer integralCount;//积分打榜

//    @Indexed(direction = IndexDirection.DESCENDING)
//    private Integer loveCount;//爱心打榜
    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer gettingLoveCount;//爱心票数

    private Integer currentRank;//当前排名
//
//    private Integer cellCount;//打cell票数 暂时不考虑
//
//    private Integer guardCount;//守护票数 暂时不考虑
//
//    private Integer summonCount;//召唤票数 暂时不考虑

}
