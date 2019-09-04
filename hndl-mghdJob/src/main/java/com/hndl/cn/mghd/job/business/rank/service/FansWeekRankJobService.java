package com.hndl.cn.mghd.job.business.rank.service;

/**
 * @author 赵俊凯
 * @Description 每月刷新新粉榜
 * @Date 2019/4/30 14:44
 * @Created by 湖南达联
 */
public interface FansWeekRankJobService {

    /**
     * 刷新星粉榜数据
     */
    void refreshFansRankWeekCache();


    /**
     * 发送周榜奖励
     */
    void sendFansRankWeekReward();
}
