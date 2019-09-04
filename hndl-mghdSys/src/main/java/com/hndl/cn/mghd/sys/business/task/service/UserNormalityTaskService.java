package com.hndl.cn.mghd.sys.business.task.service;

import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.task.vo.UserTaskVo;

import java.util.List;
import java.util.Map;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/6 10:03
 * @Created by 湖南达联
 */
public interface UserNormalityTaskService {

    /**
     * 查询
     *
     * @param userUinId
     * @return
     */
    Map<Integer, UserTaskVo> findUserNormalityTask(Long userUinId);

    /**
     * 查寻app常态任务列表
     *
     * @param userUinId
     * @return
     */
    Map<Integer,UserTaskVo> findAppUserNormalityTask(Long userUinId);

    /**
     * 查询wechat任务列表
     *
     * @param userUinId
     * @return
     */
    List<UserTaskVo> findWeChatUserNormalityTask(Long userUinId);

    /**
     * 查询用户完成的常态任务
     * 用户领取积分奖励,增加用户统计中的积分数和增加用户积分日志中
     *
     * @param userUinId
     * @return
     */
    Result<UserTaskVo> insertTaskAddIntegralCount(Long userUinId, UserNormalityTaskEnums userNormalityTaskEnums);

    /**
     * 查询任务列表中的显示信息
     * @param userUinId               用户信息
     * @param userNormalityTaskEnums  任务类型
     * @return
     */
    Result<UserTaskVo> findOneUserNormalityTask(Long userUinId, UserNormalityTaskEnums userNormalityTaskEnums);

    /**
     * 拜师
     *
     * @param commonUserInfoDo 用户id
     * @param lastId           师父id
     */
    Result<Object> insertUserNormalityTaskAddMaster(CommonUserInfoDo commonUserInfoDo, Long lastId);


    /**
     * 收徒完成后在统计表中加一个徒弟,发送消息通知师父1
     *
     * @param userByUniId
     * @param objId
     */
    void insertApprentice(CommonUserInfoDo userByUniId, Long objId);

    /**
     * 关注公众号
     *
     * @param userUinId
     * @param objId
     * @return
     */
    Result<Object> insertUserNormalityTaskAddPublic(Long userUinId, String objId);


    /**
     *  查询用户徒弟信息
     *
     * @param
     * @return
     */
    Result<Object> findMasterApprentice(CommonUserInfoDo commonUserInfoDo, Integer pageNo);

    /**
     * 查询推广任务
     * @param commonUserInfoDo
     * @return
     */
    Result<Object> findGeneralizeTask(CommonUserInfoDo commonUserInfoDo);

    /**
     * 回调接口
     * @param commonUserInfoDo
     * @param taskType
     * @return
     */
    Result<Object> reportGeneralizeTask(CommonUserInfoDo commonUserInfoDo, Integer taskType);
}
