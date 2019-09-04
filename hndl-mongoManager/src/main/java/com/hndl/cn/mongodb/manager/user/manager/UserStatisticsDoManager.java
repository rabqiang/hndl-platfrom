package com.hndl.cn.mongodb.manager.user.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;

import java.util.List;


/**
 * @author 曹加丽
 * @Description ToDo
 * @Date 2019/4/18 10:53
 * @Created by 湖南达联
 */
public interface UserStatisticsDoManager {

    void deleteUser(Long userUniId);


    /**
     * 初始化UserStatisticsDo
     *
     * @param userStatisticsDo
     */
    void initUserStatistics(UserStatisticsDo userStatisticsDo);


    /**
     * 增加用户经验值
     *
     * @param userUinId
     * @param userDayEmpiricalTypeEnums
     */
    void userStatisticsAddEmpirical(Long userUinId, UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums);


    /**
     * 增加用户经验值
     *
     * @param userUinId
     */
    void userStatisticsAddEmpirical(Long userUinId, Long empiricalNum);

    /**
     * 增加福卡数
     *
     * @param userUinId       用户id
     * @param foucaultCount   福卡数
     * @return
     */
    void userAddFoucaultCount(Long userUinId, Integer foucaultCount);

    /**
     * 修改福卡数
     * @param userUinId       用户id
     * @param foucaultCount   福卡数
     * @return
     */
    boolean userUpdateFoucaultCount(Long userUinId,Integer foucaultCount);

    /**
     * 增加用户积分
     * 通过经验值判断用户等级，根据用户等级获取积分翻倍数。
     *
     * @param userUinId
     * @param integralCount
     * @param isValidEnums  积分的类型是支出(一) 还是收入(零)
     */
    boolean userStatisticsAddIntegralCount(Long userUinId, Long integralCount, IsValidEnums isValidEnums);


    /**
     * 查询并修改
     * @param userUinId
     * @param integralCount
     * @param isValidEnums
     * @return
     */
    UserStatisticsDo findAndAddIntegralCount(Long userUinId, Long integralCount, IsValidEnums isValidEnums);

    /**
     * 增加用户师徒奖励
     *
     * @param userUinId
     * @param cumulativeReward
     */
    void userStatisticsAddCumulativeReward(Long userUinId, Integer cumulativeReward);

    /**
     * 增加用户徒弟数,统计徒弟在粉丝会的贡献值,徒弟数只会增不会减
     * 根据徒弟个数进行额外的积分奖励
     */
    void userStatisticsAddSlaveCount(UserStatisticsDo userStatisticsDo);


    /**
     * 增加推广数
     *
     * @param userUinId
     * @param spreadCount
     */
    void userStatisticsAddSspreadCount(Long userUinId, Integer spreadCount);


    /**
     * 增加爱心值，
     * 根据用户唯一id和今天日期时间
     * 查询是否用户有爱心，有就进行增加没有就不做任何操作
     *
     * @param userUinId
     * @param gettingLoveCount
     * @param isValidEnums     爱心类型是收入还是支出
     */
    boolean userStatisticsAddGettingLoveCount(Long userUinId, Long gettingLoveCount, IsValidEnums isValidEnums);

    /**
     * 将所有用户的爱心值全部清零，爱心值修改零
     */
    void initUserGettingLoveCount();

    /**
     * 修改用户统计数据
     *
     * @param userStatisticsDo
     */
    void updateUserStatistics(UserStatisticsDo userStatisticsDo);

    /**
     * 根据用户id查询 用户积分、爱心值、用户id（快乐号）
     *
     * @param userUinId
     */
    UserStatisticsDo findUserStatisticsByUserUinId(Long userUinId);

    /**
     * 查询单个用户福卡数
     * @param userUinId
     * @return
     */
    Integer findUserGetFoucaultCountsByUserUinId(Long userUinId);

    /**
     * 判断用户存在
     * @param userUniId
     * @return
     */
    boolean getUser(Long userUniId);


}
