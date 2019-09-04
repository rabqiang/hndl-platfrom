package com.hndl.cn.mghd.sys.business.message.service;

import com.hndl.cn.base.enums.message.FeedbackEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.message.vo.UserFeedbackVo;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/25 17:35
 * @Created by 湖南达联
 */
public interface UserFeedbackService {

    /**
     * 用户新增建议反馈信息
     * @return
     */
    Result<String> insertUserFeedback(Long userUniId, String objId,FeedbackEnums feedbackEnums, UserFeedbackVo userFeedbackVo);



}
