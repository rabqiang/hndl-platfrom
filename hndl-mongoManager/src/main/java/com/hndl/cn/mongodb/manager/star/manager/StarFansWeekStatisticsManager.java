package com.hndl.cn.mongodb.manager.star.manager;

import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansWeekStatisticsDo;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description 用户周版数据
 * @Date 2019/4/29 19:47
 * @Created by 湖南达联
 */
public interface StarFansWeekStatisticsManager {



    /**
     * 初始化每周的用户行为数据
     * @param userUinId
     * @param starId
     * @return
     */
    void initStarFansWeekStatistics(Long userUinId,String userImg,String userNickName,
                                   Long starId,String starName,String starImg);


    /**
     *  每周打榜增加贡献 没有限制行为次数
     * @param voteTypeEnums 投票的方式
     * @param userUinId 用户uin id
     * @param starId 明星id
     * @param voteNum 投票数
     */
    void increaseVote(VoteTypeEnums voteTypeEnums, Long userUinId, Long starId, Long voteNum);




    boolean upsertWeekVote(Long userUinId,String userImg,String userNickName,
                        Long starId,String starName,String starImg,VoteTypeEnums voteTypeEnums,Long voteNum);


    /**
     *    每周用户行为添加的贡献值 有限制的行为次数
     *
     * @param fansGroupContributeEnums
     * @param userUinId
     * @param starId
     */
    boolean increaseFansContribute(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg,FansGroupContributeEnums fansGroupContributeEnums);

    /**
     * 查询每周的新粉榜数据
     * @param nowDate
     * @param limit
     * @return
     */
    List<StarFansWeekStatisticsDo> findByDate(LocalDate nowDate, Integer limit);



    /**
     * 查询当周最高贡献
     * @param userUniId
     * @return
     */
    StarFansWeekStatisticsDo findStarFansDayMaxContribute(Long userUniId);


    /**
     * 修改用户昵称
     */
    void updateStarFansWeekGetUserNickName(Long userUniId,String value);

    /**
     * 修改用户头像
     */
    void updateStarFansWeekGetUserImgUrl(Long userUniId,String value);

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
