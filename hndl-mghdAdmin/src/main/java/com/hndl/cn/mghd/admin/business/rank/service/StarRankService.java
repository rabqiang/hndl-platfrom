package com.hndl.cn.mghd.admin.business.rank.service;

import com.hndl.cn.mghd.admin.business.rank.vo.StarRankVo;

import java.util.List;

/**
 * @program:hndl-platform
 * @description: 明星排名数据
 * @author: 易成贤
 * @create: 2019-06-27 10:32
 * @Created by湖南达联
 **/
public interface StarRankService {
    /**
     * 查询日榜数据
     * @param
     * @return
     */
    List<StarRankVo> findStarDayRank();

    /**
     * 查询周榜数据
     * @return
     */
    List<StarRankVo> findStarWeekRank();

    /**
     * 查询月榜数据
     * @return
     */
    List<StarRankVo> findStarMouthRank();

    /**
     * 初始化日周月榜数据
     * @param starRankVo
     */
    void initStarRank(StarRankVo starRankVo);
}
