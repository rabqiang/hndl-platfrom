package com.hndl.cn.mghd.job.business.rank.service;

/**
 * @author 赵俊凯
 * @Description 明星周榜数据相关
 * @Date 2019/4/25 20:23
 * @Created by 湖南达联
 */
public interface StarWeekRankJobService {

    /**
     * 初始化日版数据
     */
    void initNextStarFansGroupWeekRank();

    /**
     * 刷新周榜数据
     */
    void refreshStarRankWeekCache();
}
