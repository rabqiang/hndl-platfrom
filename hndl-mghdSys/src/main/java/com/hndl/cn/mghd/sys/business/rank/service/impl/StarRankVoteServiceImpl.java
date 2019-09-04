package com.hndl.cn.mghd.sys.business.rank.service.impl;

import com.hndl.cn.base.enums.pay.PayReasonType;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mghd.sys.business.rank.service.StarRankVoteService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupRelationService;
import com.hndl.cn.mongodb.manager.star.manager.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/28 21:50
 * @Created by 湖南达联
 */
@Service
public class StarRankVoteServiceImpl implements StarRankVoteService {

    private static final Logger log = LoggerFactory.getLogger(StarRankVoteServiceImpl.class);

    @Resource
    private StarDayRankManager starDayRankManager;

    @Resource
    private StarWeekRankManager starWeekRankManager;

    @Resource
    private StarMonthRankManager starMonthRankManager;

    @Resource
    private StarFansGroupManager starFansGroupManager;



    @Override
    @Async("StatisticsTaskExecutePool")
    public void asyncIncreaseAllVote(VoteTypeEnums voteTypeEnums,Long userUniId,Long starId, Long voteNum) {
        try{
            //日榜加票
            starDayRankManager.increaseVote(voteTypeEnums, starId, voteNum);
            //周榜加票
            starWeekRankManager.increaseVote(voteTypeEnums, starId, voteNum);
            //月榜加票
            starMonthRankManager.increaseVote(voteTypeEnums, starId, voteNum);
            //总榜加票
            starFansGroupManager.updateVoteCount(starId,voteNum);

        }catch (Exception e){
            log.error("===================asyncIncreaseAllVote error !===================================");
            log.error("voteTypeEnums:"+ voteTypeEnums+";"+"starId : "+ starId +";"+ "voteNum:"+ voteNum);
            e.printStackTrace();
        }
    }
}
