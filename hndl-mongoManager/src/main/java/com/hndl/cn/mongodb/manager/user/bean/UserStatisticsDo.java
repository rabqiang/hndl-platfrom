package com.hndl.cn.mongodb.manager.user.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

/**
 * @Classname 赵俊凯
 * @Description 用户统计相关，全平台 曹佳丽
 * @Date 2019/4/17 19:27
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "business_user_statistics")
public class UserStatisticsDo implements Serializable {

    @Id
    private String id;//mongo obj id

    @Indexed(unique = true)
    private Long userUniId;//用户唯一标识id

    @Indexed
    private Long createTime;//创建时间

    private Long empirical;//用户经验值,贡献值

    private Long integralCount;//积分

    private Long gettingLoveTime;//获取爱心的时间,精确到天

    private Long gettingLoveCount;//爱心值

    private Integer slaveCount;//徒弟数

    /**
     *  徒弟粉丝会贡献值(此功能暂时不开发)
     *  第一步 先查询用户在 某个粉丝会的
     *  在获取用户在该粉丝会的所有徒弟，再进行查询用户徒弟的经验值即贡献值，
     *  在进行增加经验值，保存到用户的徒弟粉丝会总贡献值中。
     */
    @Indexed(direction = IndexDirection.DESCENDING)
    private Long slaveFansContribute;//所有徒弟在粉丝会的贡献总值

    private Integer spreadCount;//推广数，拉新人 考虑之后的业务

    private Integer foucaultCount; //福卡数

    @Indexed(direction = IndexDirection.DESCENDING)
    private  Long  cumulativeReward = 0L;//师父获取额外积分


}
