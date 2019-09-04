package com.hndl.cn.mongodb.manager.star.manager;

import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarWeekRankDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description 周版数据
 * @Date 2019/4/26 14:54
 * @Created by 湖南达联
 */
public interface StarWeekRankManager {


    /**
     * 批量刷入月榜数据
     * @param starWeekRankDos
     */
    void insertInBatch(List<StarWeekRankDo> starWeekRankDos);


    /**
     * 查询周榜数据
     * @param rankTime
     * @return
     */
    List<StarWeekRankDo> findByRankDate(Long rankTime,Integer limit);


    /**
     * 周榜加票
     * @param voteTypeEnums
     * @param starId
     * @param voteNum
     */
    void increaseVote(VoteTypeEnums voteTypeEnums, Long starId, Long voteNum);

    /**
     * 修改明星头像
     * @param img
     * @param starId
     */
    void updateImgByStarId(String img, Long starId);

    /**
     * 修改明星名字
     * @param starName
     * @param starId
     */
    void updateStarNameByStarId(String starName, Long starId);
}
