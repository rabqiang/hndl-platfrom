package com.hndl.cn.mongodb.manager.star.manager;

import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarMonthRankDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description 月榜
 * @Date 2019/4/26 14:45
 * @Created by 湖南达联
 */
public interface StarMonthRankManager {


    /**
     * 批量刷入月榜数据
     * @param starMonthRankDos
     */
    void insertInBatch(List<StarMonthRankDo> starMonthRankDos);


    /**
     * 时间查询
     * @param rankTime
     * @return
     */
    List<StarMonthRankDo> findByRankDate(Long rankTime,Integer limit);


    /**
     * 月榜加票
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
     * 更新明星名字
     * @param starName
     * @param starId
     */
    void updateStarNameByStarId(String starName, Long starId);
}
