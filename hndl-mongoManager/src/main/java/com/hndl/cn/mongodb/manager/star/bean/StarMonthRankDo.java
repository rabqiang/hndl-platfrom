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
 * @Description 每月明星榜单数据 资龙茂
 * @Date 2019/4/18 11:40
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_star_month_rank")
@CompoundIndexes({@CompoundIndex(unique = true,name="star_month_rank_index",def = "{starId:1,rankTime:1}")})
public class StarMonthRankDo implements Serializable {

    @Id
    private String id;

    private Long createTime;//创建时间，每月最后一天 23：30 提前刷入

    @Indexed
    private Long rankTime;//榜单时间，精确到每月的第一天

    private Long starId;//明星id

    private String starName;//明星名称

    private String starImg;//明星图像

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long voteCount;//总票数

    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer coinCount;//送心票数

    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer integralCount;//积分打榜

    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer gettingLoveCount;//爱心票数
}
