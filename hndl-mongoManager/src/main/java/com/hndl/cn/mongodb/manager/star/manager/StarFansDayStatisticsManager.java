package com.hndl.cn.mongodb.manager.star.manager;

import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansDayStatisticsDo;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description 每日用户粉丝会行为数据
 * @Date 2019/4/25 11:10
 * @Created by 湖南达联
 */
public interface StarFansDayStatisticsManager {



    /**
     * 初始化每天的用户行为数据
     * @param userUinId
     * @param starId
     * @return
     */
    void initStarFansDayStatistics(Long userUinId,String userImg,String userNickName,
                                   Long starId,String starName,String starImg);


    /**
     *  每日打榜增加贡献 没有限制行为次数
     * @param voteTypeEnums 投票的方式
     * @param userUinId 用户uin id
     * @param starId 明星id
     * @param voteNum 投票数
     */
    void increaseVote(VoteTypeEnums voteTypeEnums,Long userUinId,Long starId,Long voteNum);


    boolean upsertDayVote(Long userUinId,String userImg,String userNickName,
                        Long starId,String starName,String starImg,VoteTypeEnums voteTypeEnums,Long voteNum);


    /**
     *    每日用户行为添加的贡献值 有限制的行为次数
     *
     * @param fansGroupContributeEnums
     * @param userUinId
     * @param starId
     */
    boolean increaseFansContribute(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg,FansGroupContributeEnums fansGroupContributeEnums);


    /**
     * 根据时间查询
     * @param localDate
     * @param limit
     * @return
     */
    List<StarFansDayStatisticsDo> findByDate(LocalDate localDate,Integer limit);


    /**
     * 根据时间查询
     * @param localDate
     * @return
     */
    List<StarFansDayStatisticsDo> findByDate(LocalDate localDate);

    /**
     * 查询数据
     * @param userUinId
     * @param starId
     */
    StarFansDayStatisticsDo findStarFansDayStatistics(Long userUinId, Long starId);

    /**
     * 统计用户今天守护了几个明星
     * @param userUinId
     * @return
     */
    Long countStarFansDayStatistics(Long userUinId);


    /**
     * 查询我今天
     * @param userUinId
     * @return
     */
    StarFansDayStatisticsDo findStarFansDayMaxContribute(Long userUinId);




    /**
     * 修改用户昵称
     * @param userUniId  用户id
     * @param value      属性值
     */
    void updateStarFansDayByNickName(Long userUniId,  String value);

    /**
     *修改用户头像
     * @param userUniId
     * @param value
     */
    void updateStarFansDayByImgUrl(Long userUniId,  String value);

    /**
     * 修改明星头像
     *
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

    /**
     * 查询用户是否投过票
     * @param starId
     * @param userUniId
     * @return
     */
    boolean findVote(Long starId,Long userUniId);
}
