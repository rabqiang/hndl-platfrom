package com.hndl.cn.mghd.admin.business.feedback.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.message.FeedbackEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.feedback.service.FeedbackService;
import com.hndl.cn.mghd.admin.business.feedback.vo.FeedbackVo;
import com.hndl.cn.mongodb.manager.message.bean.UserFeedbackDo;
import com.hndl.cn.mongodb.manager.message.manager.UserFeedbackManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/19 16:58
 * @Created by 湖南达联
 */
@Service
public class FeedbackServiceImpl implements FeedbackService {
    @Resource
    UserFeedbackManager userFeedbackManager;

    @Override
    public Result<Object> findUserReportAll(String id,Long userUniId, IsValidEnums isValidEnums) {
        List<FeedbackVo> list = new ArrayList<>();
        List<UserFeedbackDo> feedbackAll = userFeedbackManager.findUserFeedbackAll(id,userUniId, IsValidEnums.NO, isValidEnums);
        if (feedbackAll == null) {
            return null;
        }
        for (UserFeedbackDo userFeedbackDo : feedbackAll) {
            FeedbackVo vo = new FeedbackVo();
            vo.setId(userFeedbackDo.getId());
            vo.setUserId(userFeedbackDo.getUserUniId());
            vo.setObjId(userFeedbackDo.getObjId());
            vo.setCreateTime(userFeedbackDo.getCreateTime().toString());
            vo.setUserContent(userFeedbackDo.getContentText());
            vo.setPictureSet(userFeedbackDo.getImgList());
            vo.setCellPhoneNumber(userFeedbackDo.getPhone());
            vo.setQqNumber(userFeedbackDo.getQq());
            vo.setFeedbackType(FeedbackEnums.evalVal(userFeedbackDo.getContentType()).getDescription());
            vo.setReportContent(userFeedbackDo.getReplyContent());
            if ("ing".equals(userFeedbackDo.getIsTouch())) {
                vo.setIsHandle("待处理");
            } else {
                vo.setIsHandle("已处理");
            }
            list.add(vo);
        }
        return ResultFactory.success(list);
    }

    @Override
    public Result<Object> findUserProposalAll(String id,Long userByUniId) {
        List<FeedbackVo> list = new ArrayList<>();
        List<UserFeedbackDo> feedbackAll = userFeedbackManager.findUserFeedbackAll(id,userByUniId, IsValidEnums.YES, null);
        if (feedbackAll == null) {
            return null;
        }
        for (UserFeedbackDo userFeedbackDo : feedbackAll) {
            FeedbackVo vo = new FeedbackVo();
            vo.setId(userFeedbackDo.getId());
            vo.setUserId(userFeedbackDo.getUserUniId());
            vo.setCreateTime(userFeedbackDo.getCreateTime().toString());
            vo.setUserContent(userFeedbackDo.getContentText());
            vo.setFeedbackType(FeedbackEnums.evalVal(userFeedbackDo.getContentType()).getDescription());
            vo.setPictureSet(userFeedbackDo.getImgList());
            vo.setCellPhoneNumber(userFeedbackDo.getPhone());
            vo.setQqNumber(userFeedbackDo.getQq());
            list.add(vo);
        }

        return ResultFactory.success(list);
    }

    /**
     * 客服回复
     *
     * @param feedbackDo 用户信息
     * @return
     */
    @Override
    public Result<Object> ReplyUser(UserFeedbackDo feedbackDo) {
        userFeedbackManager.insetUserFeedbackReply(feedbackDo);
        return ResultFactory.success("回复成功");
    }
}
