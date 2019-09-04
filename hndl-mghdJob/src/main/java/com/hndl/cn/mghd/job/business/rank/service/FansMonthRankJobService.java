package com.hndl.cn.mghd.job.business.rank.service;

/**
 * @author 赵俊凯
 * @Description 星粉榜月榜
 * @Date 2019/4/30 14:48
 * @Created by 湖南达联
 */
public interface FansMonthRankJobService {

    /**
     * 刷新星粉榜数据
     */
    void refreshFansRankMonthCache();


    /**
     * 发送月榜奖励
     */
    void sendFansRankMonthReward();
}
