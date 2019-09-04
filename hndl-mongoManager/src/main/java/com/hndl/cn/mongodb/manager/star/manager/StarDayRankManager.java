package com.hndl.cn.mongodb.manager.star.manager;

import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description 用户日版数据
 * @Date 2019/4/25 14:53
 * @Created by 湖南达联
 */
public interface StarDayRankManager {


    /**
     * 查询每天日版数据
     * @param date 毫秒 精确到天
     * @return
     */
    List<StarDayRankDo> findStarDayRankByRankDate(Long date,Integer limit);


    /**
     * 给今天的日版投票
     * @param voteTypeEnums
     * @param starId
     * @param voteNum
     */
    void increaseVote(VoteTypeEnums voteTypeEnums,Long starId,Long voteNum);


    /**
     * 更新当前排名
     */
    void updateCurrentRank(String id,Integer currentRank);


    /**
     * 批量刷入数据 批量初始化数据
     * @param starDayRankDos
     */
    void insertInBatch(List<StarDayRankDo> starDayRankDos);

    /**
     * 查询一个明星的日榜数据
     * @param starId
     * @return
     */
    StarDayRankDo findCurrentRankByStarId(Long starId);

    /**
     * 更新粉丝会头像
     * @param img
     * @param starId
     */

    void updateImgByStarId(String img, Long starId);

    /**
     * 更新粉丝会名字
     * @param starName
     * @param starId
     */
    void updateStarNameByStarId(String starName, Long starId);
}
