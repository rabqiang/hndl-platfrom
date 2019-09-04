package com.hndl.cn.mghd.admin.business.feedback.service;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.message.FeedbackEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mongodb.manager.message.bean.UserFeedbackDo;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/19 16:56
 * @Created by 湖南达联
 */
public interface FeedbackService {
    /**
     * 查询用户举报信息
     *
     * @param userUniId 用户信息
     * @param isValidEnums     是否处理
     * @return
     */
    Result<Object> findUserReportAll(String id,Long userUniId, IsValidEnums isValidEnums);

    /**
     * 查询用户的建议
     *
     * @param commonUserInfoDo 用户信息
     * @return
     */
    Result<Object> findUserProposalAll(String id,Long commonUserInfoDo);

    /**
     * 客服回复
     * @param feedbackDo 用户信息
     * @return
     */
    Result<Object>  ReplyUser(UserFeedbackDo feedbackDo);
}
