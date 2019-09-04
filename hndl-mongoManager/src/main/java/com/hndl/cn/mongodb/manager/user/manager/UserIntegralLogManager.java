package com.hndl.cn.mongodb.manager.user.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 汪海
 * @Description 积分明细操作
 * @Date 2019/4/22  11:41
 * @Created by 湖南达联
 */
public interface UserIntegralLogManager {

    void userDelete(Long userUniId, String time, UserDayEmpiricalTypeEnums userDayTaskEnums);

    /**
     * 积分
     *
     * @param userUinId       用户id
     * @param objId           消费对象
     * @param IntegralCount   积分值
     * @param getIntegralType 积分类型
     * @param isValidEnums    收入(一)还是 支出 (零)
     *
     */
    void insertUserIntegralLog(Long userUinId,String objId, IsValidEnums isValidEnums, Integer getIntegralType, Integer IntegralCount);
    /**
     * 积分
     *
     * @param userUinId       用户id
     * @param objId           消费对象
     * @param IntegralCount   积分值
     * @param getIntegralType 积分类型
     * @param isValidEnums    收入(一)还是 支出 (零)
     * @param description     获取积分描述
     */
    void insertUserIntegralLog(Long userUinId,String objId, IsValidEnums isValidEnums, Integer getIntegralType, Integer IntegralCount,String description);

    /**
     * 查询用户积分详细信息
     *
     * @param userUniId    用户id
     * @param isValidEnums 判断是收入(一)还是 支出 (零)
     * @param
     * @param
     * @param id 分页游标
     */
    List<UserIntegralLogDo> userIntegralLogAll(Long userUniId, Integer pageNo,IsValidEnums isValidEnums,String id);

    /**
     * 后台管理查询用户积分详细信息
     *
     * @param userUniId    用户id
     * @param isValidEnums 判断是收入(一)还是 支出 (零)
     * @param pageNo
     * @param pageSize     分页大小
     */
    List<UserIntegralLogDo> userIntegralLogAll(Long userUniId, IsValidEnums isValidEnums, String pageNo, Integer pageSize) ;

    /**
     * 查询用户日常任务的积分值
     *
     * @param userUinId 用户id
     * @return
     */
    Long findYesterdayTeskUserAll(Long userUinId);
    /**
     * 查询用户日常任务的积分值
     *
     * @param userUinId 用户id
     * @return
     */
    Long findTeskUserAll(Long userUinId,UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums);

    /**
     * 根据时间查询用户的为明星打榜的积分纪录
     *
     * @param userUinId                 用户id
     * @param isValidEnums              是收入(一)还是 支出 (零)
     * @param userDayEmpiricalTypeEnums 积分类型
     */
    UserIntegralLogDo findUserInategralOne(Long userUinId, IsValidEnums isValidEnums, UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums);

    /**
     * 根据用户经验值获取用户可获取的积分
     * @param integral   用户当前应该获取的积分数
     * @param empirical  用户经验值
     * @return
     */
    Long getUserIntegral(Long empirical, Integer integral);

    /**
     * 获取用户积分记录信息
     * @param userId        用户uniId
     * @param isValidEnums  是收入?()
     * @return
     */
    Long getIntegralInfo(Long userId,IsValidEnums isValidEnums);

    /**
     * 查询
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @param objId     对象id
     * @return
     */
    List<UserIntegralLogDo> findRecordByStarId(Long startDate, Long endDate, String objId);

    /**
     * 根据时间查询积分打榜总数
     * @param startDate 开始时间
     * @param endDate   结束时间
     * @return
     */
    List<UserIntegralLogDo> findRecordByDate(Long startDate, Long endDate);



    List<UserIntegralLogDo> findRecordByDate(Long startDate, Long endDate,Long userUniId,UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums,IsValidEnums isValidEnums);

    /**
     * 根据时间和明星id查询该明星时间段内总打榜票数
     * @param startDate         开始时间
     * @param endDate           结束时间
     * @param objId             对象id
     * @return
     */
    Long findIntegralCountByStarId(@NotNull Long startDate, @NotNull Long endDate, @NotNull String objId);

    /**
     * 根据时间和查询时间段内总打榜票数
     * @param startDate  开始时间
     * @param endDate    结束时间
     * @return
     */
    Long findIntegralCountAll(@NotNull Long startDate, @NotNull Long endDate);

}
