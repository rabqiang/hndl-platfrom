package com.hndl.cn.mghd.sys.business.task.service;

import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.task.vo.UserTaskVo;

import java.util.List;
import java.util.Map;


/**
 * @program: hndl-platform
 * @description: 用户每日任务
 * @author: 易成贤
 * @create: 2019-05-06 13:49
 * @Created by 湖南达联
 **/
public interface UserDayTaskService {


    /**
     * 查询用户任务数据
     *
     * @param commonUserInfoDo
     * @return
     */
    Map<Integer, UserTaskVo> findUserDayTask(CommonUserInfoDo commonUserInfoDo);

    /**
     * 查询app任务
     *
     * @param commonUserInfoDo
     * @return
     */
    Map<Integer, UserTaskVo> findAppUserDayTask(CommonUserInfoDo commonUserInfoDo);

    /**
     * 查询wechat任务
     *
     * @param commonUserInfoDo
     * @return
     */
    List<UserTaskVo> findWeChatUserDayTask(CommonUserInfoDo commonUserInfoDo);

    /**
     * 用户领取积分
     *
     * @param sysUniId         用户唯一id
     * @param userDayTaskEnums 每日任务枚举
     * @return 返回对应领取任务后数据
     */
    Result<UserTaskVo> getIntegralCount(Long sysUniId, UserDayTaskEnums userDayTaskEnums);

    /**
     * 插入任务记录
     *
     * @param
     * @param starId
     * @param userDayTaskEnums
     */
    void insetTask(Long sysUniId, Long starId, UserDayTaskEnums userDayTaskEnums);
}
