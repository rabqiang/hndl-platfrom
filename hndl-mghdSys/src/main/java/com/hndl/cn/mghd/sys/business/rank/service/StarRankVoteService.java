package com.hndl.cn.mghd.sys.business.rank.service;

import com.hndl.cn.base.enums.vote.VoteTypeEnums;

/**
 * @author 赵俊凯
 * @Description 榜单投票
 * @Date 2019/4/28 21:48
 * @Created by 湖南达联
 */
public interface StarRankVoteService {


    /**
     * 异步加票，同时更新 日 周 月榜
     * @param voteTypeEnums
     * @param userUniId
     * @param starId
     * @param voteNum
     */
    void asyncIncreaseAllVote(VoteTypeEnums voteTypeEnums,Long userUniId,Long starId, Long voteNum);
}
