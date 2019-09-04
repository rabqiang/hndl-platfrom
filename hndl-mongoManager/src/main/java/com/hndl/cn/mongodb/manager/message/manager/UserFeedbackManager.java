package com.hndl.cn.mongodb.manager.message.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.message.FeedbackEnums;
import com.hndl.cn.mongodb.manager.message.bean.UserFeedbackDo;
import com.hndl.cn.mongodb.manager.user.bean.UserEmpiricalLogDo;

import java.util.List;

/**
 * @author 曹加丽
 * @Description     用户反馈表   dao层
 * @Date 2019/5/25 15:16
 * @Created by 湖南达联
 */

public interface UserFeedbackManager {
    /**
     * 新增用户 建议/反馈
     * @param userFeedbackDo
     */
    void insertUserFeedback(UserFeedbackDo userFeedbackDo);

    /**
     * 客服回复
     * @param userEmpiricalLogDo
     * @param feedbackEnums
     */
     void insetUserFeedbackReply(UserFeedbackDo userEmpiricalLogDo);

    /**
     * 查询用户反馈信息
     * @param sysUniId   用户id
     * @param objId      对象id
     * @return
     */
    UserFeedbackDo  findUserFeedbackByObjId(Long sysUniId,String objId);

    /**
     * 查询用户举报建议信息
     * @param sysUniId 用户id
     * @param isType  判断是否举报
     *
     * @return
     */
    List<UserFeedbackDo> findUserFeedbackAll(String id,Long sysUniId, IsValidEnums isType,IsValidEnums isReply);
}
