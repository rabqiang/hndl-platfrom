package com.hndl.cn.mghd.job.business.rank.service;

/**
 * @author 赵俊凯
 * @Description 初始化月榜数据
 * @Date 2019/4/25 20:24
 * @Created by 湖南达联
 */
public interface StarMonthRankJobService {

    /**
     * 初始化日版数据
     */
    void initNextStarFansGroupDayRank();


    /**
     * 刷新月榜数据缓存
     */
    void refreshStarRankMonthCache();
}
