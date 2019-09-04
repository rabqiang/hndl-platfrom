package com.hndl.cn.mghd.job.business.rank.service;

/**
 * @author 赵俊凯
 * @Description 每日刷新新粉榜
 * @Date 2019/4/29 18:02
 * @Created by 湖南达联
 */
public interface FansDayRankJobService {


    /**
     * 刷新星粉榜数据
     */
    void refreshFansRankDayCache();


}
