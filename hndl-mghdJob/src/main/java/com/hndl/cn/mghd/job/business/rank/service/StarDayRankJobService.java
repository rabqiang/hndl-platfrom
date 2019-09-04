package com.hndl.cn.mghd.job.business.rank.service;

/**
 * @author 赵俊凯
 * @Description 明星日版排行榜
 * @Date 2019/4/25 20:19
 * @Created by 湖南达联
 */
public interface StarDayRankJobService {


    /**
     * 初始化日版数据
     */
    void initNextStarFansGroupDayRank();


    /**
     * 刷新日版缓存数据
     */
    void refreshStarRankDayCache();
}
