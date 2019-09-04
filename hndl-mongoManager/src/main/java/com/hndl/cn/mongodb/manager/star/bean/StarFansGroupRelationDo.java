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
 * @Description 用户加入粉丝会关联信息记录 userUinId,starId联合唯一索引 易成贤
 * @Date 2019/4/17 19:35
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_star_fans_group_relation")
@CompoundIndexes({@CompoundIndex(unique = true,name="fans_relation_index",def = "{userUniId:1,starId:1}")})
public class StarFansGroupRelationDo implements Serializable {

    @Id
    private String id;

    private Long createTime;//创建时间
    @Indexed
    private Long userUniId;//用户id
    @Indexed
    private Long starId;//明星id

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long fansContribute;//粉丝贡献

    @Indexed(direction = IndexDirection.DESCENDING)
    private Long voteCount;//粉丝票数

    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer coinCount;//比心票数

    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer integralCount;//积分打榜

    @Indexed(direction = IndexDirection.DESCENDING)
    private Integer gettingLoveCount;//爱心数

    private Integer voteDayCount;//累计打榜天数

    @Indexed
    private Integer power;//权限

    private Integer spreadCount;//拉入粉丝会数，考虑之后的业务

    private Integer isDelete;//是否删除








}
