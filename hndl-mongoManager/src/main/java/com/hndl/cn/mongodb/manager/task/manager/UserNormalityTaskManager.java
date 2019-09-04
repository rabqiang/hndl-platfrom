package com.hndl.cn.mongodb.manager.task.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.mongodb.manager.task.bean.UserNormalityTaskDo;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;

import java.util.List;

/**
 * @author 汪海
 * @Description TODO
 * @Date 2019/4/22 0022 14:56
 * @Created by 湖南达联
 */
public interface UserNormalityTaskManager {


    /**
     * 添加任务完成记录
     *
     * @param userUniId              用户id
     * @param objId                  对象id(如果是跳转其他小程序就为0)
     * @param userNormalityTaskEnums 任务类型
     * @param isDelete               是否删除(1.是0.否)
     */

    void insert(Long userUniId, String objId, UserNormalityTaskEnums userNormalityTaskEnums, Integer isDelete);

    /**
     * 查询用户的任务完成状态
     *
     * @param userUinId
     * @return
     */

    List<UserNormalityTaskDo> findByUserUniId(Long userUinId);

    /**
     * 查询用户是否完成常态任务
     *
     * @param userUniId
     * @param userNormalityTaskEnums
     * @return
     */

    Long findToNormalityTaskByUserUniIdAndObjId(Long userUniId, UserNormalityTaskEnums userNormalityTaskEnums, IsValidEnums isValidEnums);


    /**
     * 查询用户完成任务可获取经验值
     */
    boolean findUserDayTaskGetEmpirical(Long userUniId, UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums);

    /**
     * 用户领取完奖励需要修改状态
     * 常态任务默认只有一次所以不用进行判断有多条完成的次数
     *
     * @param userUinId              用户id
     * @param userNormalityTaskEnums 常态任务枚举
     */
    boolean updateIsDelete(Long userUinId, UserNormalityTaskEnums userNormalityTaskEnums);

    /**
     * @param sysUniId
     * @param userNormalityTaskEnums
     * @return
     */
    List<UserNormalityTaskDo> findTaskByUserUniIdAndTaskType(Long sysUniId, UserNormalityTaskEnums userNormalityTaskEnums);

    /**
     * 根据用户id和任务查询用户常态任务信息
     *
     * @param sysUniId
     * @param userNormalityTaskEnums
     * @return
     */
    List<UserNormalityTaskDo> findTaskByUserUniIdAndTaskTypes(Long sysUniId, UserNormalityTaskEnums userNormalityTaskEnums);

    UserNormalityTaskDo findOne(Long userUinId, UserNormalityTaskEnums userNormalityTaskEnums);


    /**
     * 判断用户是否收过徒弟
     *
     * @param masterId
     * @param slaveId
     * @return
     */
    boolean findUserIsSlave(Long masterId, String slaveId);

    /**
     * 查询用户收徒任务完成的信息,从而获取徒弟id
     *
     * @param userUniId
     * @param userNormalityTaskEnums
     * @return
     */
    List<UserNormalityTaskDo> findSlaves(Long userUniId, UserNormalityTaskEnums userNormalityTaskEnums);

    /**
     * 增加师父获取的积分方法
     *
     * @param userUniId
     * @param integer
     */
    void UserGetCumulativeReward(String userUniId, Long integer);

    /**
     * 查询徒弟个数
     *
     * @return
     */
    Integer countApprentice(Long userUniId);

    /**
     * 查询徒弟id
     */
    List<UserNormalityTaskDo> getSlave(Long userUniId);

    /**
     * 查询徒弟id信息加分页
     *
     * @param id        _id
     * @param userUniId 用户uniid
     */
    List<UserNormalityTaskDo> getSlave(String id, Long userUniId);

    /**
     * 查询用户是否完成绑定手机号常态任务
     *
     * @param userUniId 用户UniId
     * @return 是否绑定?
     */
    boolean findUserByNumber(Long userUniId);

    void upsret(Long userUniId, String objId, UserNormalityTaskEnums userNormalityTaskEnums, Integer isDelete);
}
