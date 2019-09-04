package com.hndl.cn.mghd.job.business.rank.service;

/**
 * @author 尹争鸣
 * @Description 粉丝奖励
 * @Date 2019年5月18日
 * @Created by 湖南达联
 */
public interface FansRewardService {


  /**
   * 粉丝榜每日奖励
   * */
  void awardFansDayReward();


  /**
   * 粉丝榜每月奖励
   * */
  void awardFansMonthReward();
}
