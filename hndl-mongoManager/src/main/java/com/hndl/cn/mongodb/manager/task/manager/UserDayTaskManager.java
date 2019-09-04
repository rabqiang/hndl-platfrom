package com.hndl.cn.mongodb.manager.task.manager;

import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.mongodb.manager.task.bean.UserDayTaskDo;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author 汪海 @Description TODO @Date 2019/4/22 0022 14:27 @Created by 湖南达联
 */
public interface UserDayTaskManager {

    /**
     * 新增每天任务
     *
     * @param userUniId
     * @param starId
     * @param userDayTaskEnums
     */
    void insert( Long userUniId,Long starId, UserDayTaskEnums userDayTaskEnums);

    /**
     * 每日任务统计
     *
     * @param userUniId
     * @param userDayTaskEnums
     * @return
     */
    Long countToDayTask(Long userUniId, UserDayTaskEnums userDayTaskEnums);

    /**
     * 查询用户每天完成的任务
     *
     * @param userUniId
     * @return
     */
    List<UserDayTaskDo> findToDayTaskByUserUniId(Long userUniId);

    /**
     * 查询用户指定任务记录
     *
     * @param userUniId
     * @param userDayTaskEnums
     * @return
     */
    List<UserDayTaskDo> findTaskByUserUniIdAndTaskType(Long userUniId, UserDayTaskEnums userDayTaskEnums);

    /**
     * 是否可领取
     *
     * @param userUniId
     * @param
     * @param userDayTaskEnums
     * @return
     */
    boolean toDayCanGetByUserUniId(Long userUniId, @Valid UserDayTaskEnums userDayTaskEnums);

    /**
     * 查询用户是否完成此任务
     *
     * @param userUniId
     * @param userDayTaskEnums
     * @return
     */
    boolean toDayIsCompleteByUserUniId(Long userUniId, UserDayTaskEnums userDayTaskEnums);

    /**
     * 领取奖励
     *
     * @param sysUniId
     * @param
     * @param userDayTaskEnums
     */
    boolean updateIsDelete(Long sysUniId, UserDayTaskEnums userDayTaskEnums);

    /**
     * 查询用户今天完成了多少此任务
     *
     * @param userUniId
     * @return
     */
    Long countToDayTaskByUserUniId(Long userUniId);

    /**
     * 插入大量数据
     *
     * @param userDayTaskDos
     */
    void insertInBatch(List<UserDayTaskDo> userDayTaskDos);

    /**
     * 查询用户昨天完成的任务的数据
     *
     * @param userUniId
     * @return
     */
    List<UserDayTaskDo> findToYesterdayTaskByUserUniId(Long userUniId);

    /**
     * 是否完成
     *
     * @param sysUniId
     * @param
     * @param userDayTaskEnums
     * @return
     */
    boolean toDayIsCompleteByUserUniIdAndStarId(Long sysUniId, UserDayTaskEnums userDayTaskEnums);

    /**
     * 查询用户今日完成日常任务的次数,可获取的经验值
     */
    boolean findUserDayTaskGetEmpirical(Long userUniId, UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums);

    /**
     * 查询用户最后一次登陆时间
     */
    UserDayTaskDo getUserLastLoginTime(@NotNull Long userUniId);

    /**
     * 根据和枚举时间查询粉丝会对应用户完成任务数量(未根据用户去重)
     * @param starId
     * @param startDate
     * @param endDate
     * @return
     */
    Long countTaskByStarId(UserDayTaskEnums userDayTaskEnums, Long starId, Long startDate, Long endDate);

    /**
     * 根据和枚举时间查询粉丝会对应用户完成任务数量(已根据用户去重)
     * @param startDate
     * @param endDate
     * @param userDayTaskEnums
     * @param isDelete
     * @param starId
     * @return
     */
    Long countTaskUserByDate(Long startDate, Long endDate, UserDayTaskEnums userDayTaskEnums, Integer isDelete, Long starId);


}
