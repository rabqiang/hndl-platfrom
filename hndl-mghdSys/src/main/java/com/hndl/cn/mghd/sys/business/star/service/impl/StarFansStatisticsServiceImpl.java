package com.hndl.cn.mghd.sys.business.star.service.impl;

import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupRelationService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansStatisticsService;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupRelationManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansMonthStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansWeekStatisticsManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 20:35
 * @Created by 湖南达联
 */
@Service
public class StarFansStatisticsServiceImpl implements StarFansStatisticsService {

    private static final Logger log = LoggerFactory.getLogger(StarFansStatisticsServiceImpl.class);

    @Resource
    private StarFansDayStatisticsManager starFansDayStatisticsManager;

    @Resource
    private StarFansWeekStatisticsManager starFansWeekStatisticsManager;

    @Resource
    private StarFansMonthStatisticsManager starFansMonthStatisticsManager;

    @Resource
    private StarFansGroupRelationManager starFansGroupRelationManager;

    @Resource
    private StarFansGroupRelationService starFansGroupRelationService;

    @Override
    @Async("StatisticsTaskExecutePool")
    public void addVoteStatistics(CommonUserInfoDo commonUserInfoDo, StarFansGroupDo starFansGroupDo, VoteTypeEnums voteTypeEnums, Long voteNum) {

        try{
            //日榜部分
            boolean flag = starFansDayStatisticsManager.upsertDayVote(commonUserInfoDo.getSysUniId(),commonUserInfoDo.getPersonImgUrlMin(),commonUserInfoDo.getNickName(),
                    starFansGroupDo.getStarId(),starFansGroupDo.getStarName(),starFansGroupDo.getStarImg(),voteTypeEnums,voteNum);

            //增加累计打榜天数
            if (flag){
                starFansGroupRelationService.updateVoteDayCount(commonUserInfoDo.getSysUniId(),starFansGroupDo.getStarId(),voteTypeEnums);
            }
            //周榜部分
            if(flag){
                flag = starFansWeekStatisticsManager.upsertWeekVote(commonUserInfoDo.getSysUniId(),commonUserInfoDo.getPersonImgUrlMin(),commonUserInfoDo.getNickName(),
                        starFansGroupDo.getStarId(),starFansGroupDo.getStarName(),starFansGroupDo.getStarImg(),voteTypeEnums,voteNum);
            }

            if(flag){
                flag = starFansMonthStatisticsManager.upsertMonthVote(commonUserInfoDo.getSysUniId(),commonUserInfoDo.getPersonImgUrlMin(),commonUserInfoDo.getNickName(),
                        starFansGroupDo.getStarId(),starFansGroupDo.getStarName(),starFansGroupDo.getStarImg(),voteTypeEnums,voteNum);
            }

            if(flag){
                starFansGroupRelationManager.updateVote(commonUserInfoDo.getSysUniId(),starFansGroupDo.getStarId(),voteTypeEnums,voteNum);
            }
        }catch (Exception e){
            log.error("=====================addVoteStatistics error!==========================");
            log.error("=====userId : "+commonUserInfoDo.getSysUniId()+",starId "+starFansGroupDo.getStarId()
                    +",voteNum:"+voteNum+",voteTypeEnums:"+voteTypeEnums.getDescription()+"=======");
        }




    }

    @Override
    @Async("StatisticsTaskExecutePool")
    public void addConductStatistics(CommonUserInfoDo commonUserInfoDo, StarFansGroupDo starFansGroupDo,
                                     FansGroupContributeEnums fansGroupContributeEnums) {
        try{
            //日榜部分
            starFansDayStatisticsManager.increaseFansContribute(commonUserInfoDo.getSysUniId(),commonUserInfoDo.getPersonImgUrlMin(),commonUserInfoDo.getNickName(),
                    starFansGroupDo.getStarId(),starFansGroupDo.getStarName(),starFansGroupDo.getStarImg(),fansGroupContributeEnums);


            //周榜部分
            starFansWeekStatisticsManager.increaseFansContribute(commonUserInfoDo.getSysUniId(),commonUserInfoDo.getPersonImgUrlMin(),commonUserInfoDo.getNickName(),
                    starFansGroupDo.getStarId(),starFansGroupDo.getStarName(),starFansGroupDo.getStarImg(),fansGroupContributeEnums);

            //月榜部分
            starFansMonthStatisticsManager.increaseFansContribute(commonUserInfoDo.getSysUniId(),commonUserInfoDo.getPersonImgUrlMin(),commonUserInfoDo.getNickName(),
                    starFansGroupDo.getStarId(),starFansGroupDo.getStarName(),starFansGroupDo.getStarImg(),fansGroupContributeEnums);

        }catch (Exception e){
            log.error("=====================addConductStatistics error!==========================");
            log.error("=====userId : "+commonUserInfoDo.getSysUniId()+",starId "+starFansGroupDo.getStarId()
                    +",fansGroupContributeEnums:"+fansGroupContributeEnums.getDescription()+"=======");
        }

    }
}
