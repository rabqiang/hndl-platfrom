package com.hndl.cn.mghd.sys.business.star.service;

import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;

/**
 * @author 赵俊凯
 * @Description 用户在粉丝会内的操作
 * @Date 2019/4/29 20:28
 * @Created by 湖南达联
 */
public interface StarFansStatisticsService {


    /**
     * 打榜增加统计数据,注意这个方法是异步操作
     * @param commonUserInfoDo
     * @param starFansGroupDo
     * @param voteTypeEnums
     * @param voteNum
     */
    void addVoteStatistics(CommonUserInfoDo commonUserInfoDo, StarFansGroupDo starFansGroupDo,
                                VoteTypeEnums voteTypeEnums,Long voteNum );


    /**
     * 增加用户行为的统计数据,注意这个方法是异步操作
     * @param commonUserInfoDo
     * @param starFansGroupDo
     * @param fansGroupContributeEnums
     */
    void addConductStatistics(CommonUserInfoDo commonUserInfoDo, StarFansGroupDo starFansGroupDo,
                              FansGroupContributeEnums fansGroupContributeEnums);
}
