package com.hndl.cn.mghd.job.business.rank.service.impl;

import com.hndl.cn.ali.jpush.service.JPushService;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.fans.FansRewardEnums;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.mghd.job.business.rank.service.FansRewardService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mghd.job.exception.MghdJobSysException;
import com.hndl.cn.mghd.job.exception.MghdJobSysExceptionEnums;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageManager;
import com.hndl.cn.mongodb.manager.star.bean.StarFansDayStatisticsDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansMonthStatisticsDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansMonthStatisticsManager;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.string.FansRankFormatUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description 粉丝奖励
 * @Date 2019年5月18日
 * @Created by 湖南达联
 */
@Service
public class FansRewardServiceImpl implements FansRewardService {


    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    @Resource
    private UserIntegralLogManager userIntegralLogManager;

    @Resource
    private StarFansDayStatisticsManager starFansDayStatisticsManager;

    @Resource
    private StarFansMonthStatisticsManager starFansMonthStatisticsManager;

    @Resource
    private UserMessageManager userMessageManager;
    @Resource
    private JPushService jPushService;


    /**
     * 粉丝榜每日奖励
     */
    @Override
    public void awardFansDayReward() {

        //获奖用户信息
        LocalDate localDate = LocalDateUtil.addDay(-1L);
        List<StarFansDayStatisticsDo> starFansExperienceCountDoList =
                starFansDayStatisticsManager.findByDate(localDate, BaseConstants.STAR_RANK_DEFAULT_LIMIT);
        if (CollectionUtils.isEmpty(starFansExperienceCountDoList)) {
            throw new MghdJobSysException(MghdJobSysExceptionEnums.MGHD_JOB_NOUSERDATA_EXCEPTION.getCode());
        }
        int ranKing = 1;
        for (StarFansDayStatisticsDo starFansExperienceCountDo : starFansExperienceCountDoList) {

            Long userUniId = starFansExperienceCountDo.getUserUniId();

            String rewardReason = FansRankFormatUtils.getRewardDayReason(ranKing);
            String rewardPushTitle = "";
            String rewardPushContent = "";
            //判断名次发放奖励
            if (MghdJobConstants.REWARD_TOP_ONE.equals(ranKing)) {
                // 2019年4月28日 17:51:19  需求变更，只加积分
                this.addReward(userUniId,  MghdJobConstants.REWARD_DAY_TOP_ONE_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardDayTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardDayPushContent(ranKing,  MghdJobConstants.REWARD_DAY_TOP_ONE_INTEGRAL);

            }   else if ( MghdJobConstants.REWARD_TOP_TWO.equals(ranKing)) {
                this.addReward(userUniId,  MghdJobConstants.REWARD_DAY_TOP_TWO_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardDayTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardDayPushContent(ranKing,  MghdJobConstants.REWARD_DAY_TOP_TWO_INTEGRAL);
            }  else if ( MghdJobConstants.REWARD_TOP_THREE.equals(ranKing)) {
                this.addReward(userUniId,  MghdJobConstants.REWARD_DAY_TOP_THREE_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardDayTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardDayPushContent(ranKing,  MghdJobConstants.REWARD_DAY_TOP_THREE_INTEGRAL);
            }  else if (ranKing <  MghdJobConstants.REWARD_TOP_TEN) {
                this.addReward(userUniId,  MghdJobConstants.REWARD_DAY_TOP_TEN_INTEGRAL,rewardReason );
                rewardPushTitle = FansRankFormatUtils.getRewardDayTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardDayPushContent(ranKing,  MghdJobConstants.REWARD_DAY_TOP_TEN_INTEGRAL );
            }  else {
                this.addReward(userUniId,  MghdJobConstants.REWARD_DAY_TOP_FIFTY_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardDayTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardDayPushContent(ranKing,  MghdJobConstants.REWARD_DAY_TOP_FIFTY_INTEGRAL);
            }

            //添加用户消息
           this.addUserMessage(userUniId,rewardPushTitle,rewardPushContent);


            ranKing++;
           jPushService.noticeToOne(userUniId, rewardPushTitle);
        }

    }

    /**
     * 粉丝榜每月奖励
     */
    @Override
    public void awardFansMonthReward() {
        //获取用户信息
        List<StarFansMonthStatisticsDo> starFansMonthStatisticsDoList =
                starFansMonthStatisticsManager.findByDate(LocalDateUtil.addMonth(-1L), BaseConstants.STAR_RANK_DEFAULT_LIMIT);

        if (CollectionUtils.isEmpty(starFansMonthStatisticsDoList)) {
            throw new MghdJobSysException(MghdJobSysExceptionEnums.MGHD_JOB_NOUSERDATA_EXCEPTION.getCode());
        }
        int ranKing = 1;
        for (StarFansMonthStatisticsDo starFansMonthStatisticsDo : starFansMonthStatisticsDoList) {

            Long userUniId = starFansMonthStatisticsDo.getUserUniId();

            String rewardReason = FansRankFormatUtils.getRewardMonthReason(ranKing);
            String rewardPushTitle = "";
            String rewardPushContent = "";
            //开始判断名次发放奖励
            if (MghdJobConstants.REWARD_TOP_ONE.equals(ranKing)) {

                this.addReward(userUniId,  MghdJobConstants.REWARD_MONTH_TOP_ONE_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardMonthTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardMonthPushContent(ranKing,  MghdJobConstants.REWARD_MONTH_TOP_ONE_INTEGRAL);

            }  else if (MghdJobConstants.REWARD_TOP_TWO.equals(ranKing)) {

                this.addReward(userUniId,  MghdJobConstants.REWARD_MONTH_TOP_TWO_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardMonthTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardMonthPushContent(ranKing,  MghdJobConstants.REWARD_MONTH_TOP_TWO_INTEGRAL);

            } else if (MghdJobConstants.REWARD_TOP_THREE.equals(ranKing)) {

                this.addReward(userUniId,  MghdJobConstants.REWARD_MONTH_TOP_THREE_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardMonthTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardMonthPushContent(ranKing,  MghdJobConstants.REWARD_MONTH_TOP_THREE_INTEGRAL);

            } else if (ranKing <  MghdJobConstants.REWARD_TOP_TEN) {

                this.addReward(userUniId,  MghdJobConstants.REWARD_MONTH_TOP_TEN_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardMonthTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardMonthPushContent(ranKing,  MghdJobConstants.REWARD_MONTH_TOP_TEN_INTEGRAL);

            } else {
                this.addReward(userUniId,  MghdJobConstants.REWARD_MONTH_TOP_FIFTY_INTEGRAL,rewardReason);
                rewardPushTitle = FansRankFormatUtils.getRewardMonthTopNumTitle(ranKing);
                rewardPushContent = FansRankFormatUtils.getRewardMonthPushContent(ranKing,  MghdJobConstants.REWARD_MONTH_TOP_FIFTY_INTEGRAL);

            }

            //添加用户消息
            this.addUserMessage(userUniId,rewardPushTitle,rewardPushContent);

            ranKing++;
            jPushService.noticeToOne(userUniId, rewardPushTitle);
        }

    }


    /**
     * 添加奖励
     */
    public void addReward(Long userId, Long integralCount,String rewardReason) {
        if (integralCount != 0) {
            //用户加积分
            userStatisticsDoManager.userStatisticsAddIntegralCount(userId, integralCount, IsValidEnums.NO);

            //增加积分记录
            userIntegralLogManager.insertUserIntegralLog(userId,"0", IsValidEnums.YES, FansRewardEnums.FANS_REWARD.getRewardType(), integralCount.intValue(),rewardReason);
        }
      
    }

    /**
     * 添加用户消息
     * */
    public void addUserMessage(Long userUniId ,String rewardPushTitle,String rewardPushContent){
        UserMessageDo userMessageDo=new UserMessageDo();
        userMessageDo.setCreateUserId(MghdJobConstants.MESSAGE_SYS_ID);
        userMessageDo.setSendUserId(userUniId);
        userMessageDo.setMessageType(MessageTypeEnums.SYS_MSG.getType());
        userMessageDo.setTitle(rewardPushTitle);
        userMessageDo.setContent(rewardPushContent);
        userMessageManager.insertUserMessageDo(userMessageDo);

    }
}
