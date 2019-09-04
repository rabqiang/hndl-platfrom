package com.hndl.cn.mongodb.manager.star.manager;

import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansMonthStatisticsDo;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description 月用户操作数据
 * @Date 2019/4/29 20:18
 * @Created by 湖南达联
 */
public interface StarFansMonthStatisticsManager {

    /**
     * 初始化每月的用户行为数据
     *
     * @param userUinId
     * @param starId
     * @return
     */
    void initStarFansMonthStatistics(Long userUinId, String userImg, String userNickName,
                                     Long starId, String starName, String starImg);


    /**
     * 每月打榜增加贡献 没有限制行为次数
     *
     * @param voteTypeEnums 投票的方式
     * @param userUinId     用户uin id
     * @param starId        明星id
     * @param voteNum       投票数
     */
    void increaseVote(VoteTypeEnums voteTypeEnums, Long userUinId, Long starId, Long voteNum);


    /**
     * 每月用户行为添加的贡献值 有限制的行为次数
     *
     * @param fansGroupContributeEnums
     * @param userUinId
     * @param starId
     */
    boolean increaseFansContribute(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg,FansGroupContributeEnums fansGroupContributeEnums);


    /**
     * 新建并增加贡献值
     * @param userUinId
     * @param userImg
     * @param userNickName
     * @param starId
     * @param starName
     * @param starImg
     * @param voteTypeEnums
     * @param voteNum
     */
    boolean upsertMonthVote(Long userUinId,String userImg,String userNickName,
                       Long starId,String starName,String starImg,VoteTypeEnums voteTypeEnums,Long voteNum);
    /**
     * 查询每月的新粉榜数据
     *
     * @param nowDate
     * @param limit
     * @return
     */
    List<StarFansMonthStatisticsDo> findByDate(LocalDate nowDate, Integer limit);


    /**
     * 查询当月最高贡献
     *
     * @param userUniId
     * @return
     */
    StarFansMonthStatisticsDo findStarFansDayMaxContribute(Long userUniId);


    /**
     * 修改用户昵称
     */
    void updateStarFansMonthGetUserNickName(Long userUniId,String value);

    /**
     * 修改用户头像
     */
    void updateStarFansMonthGetUserImgUrl(Long userUniId,String value);

    /**
     * 修改明星头像
     * @param img
     * @param starId
     */
    void updateImgByStarId(String img, Long starId);

    /**
     * 更新明星明星
     * @param starName
     * @param starId
     */
    void updateStarNameByStarId(String starName, Long starId);
}
