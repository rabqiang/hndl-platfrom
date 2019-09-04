package com.hndl.cn.mghd.admin.business.feedback.controller;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.feedback.service.FeedbackService;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/20 16:42
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/feedback")
@Api(value = "/feedback",tags = "用户反馈管理")
public class FeedbackController {

    @Resource
    private FeedbackService feedbackService;


    /**
     * 查询举报信息
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户反馈信息", notes = "查询用户举报信息")
    @AdminLog
    @AuthPower
    @GetMapping("/findUserProposalAll")
    public Result<Object> findUserProposalAll(String id,
                                              @ApiParam(value = "用户uniId,如果查询所有就输入零") @RequestParam Long userUniId,
                                              @ApiParam(value = "是否处理? 一是零否") @RequestParam Integer isPay) {
        IsValidEnums isValidEnums1 = IsValidEnums.evalVal(isPay);
        if (isValidEnums1 == null) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return feedbackService.findUserReportAll(id, userUniId,isValidEnums1);
    }

    /**
     * 查询建议信息
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户建议信息", notes = "查询用户建议信息")
    @AdminLog
    @AuthPower
    @GetMapping("/findUserReportAll")
    public Result<Object> findUserReportAll(String id, @ApiParam(value = "用户uniId,查询所有就输入零") @RequestParam Long userUniId) {
        return feedbackService.findUserProposalAll(id, userUniId);

    }

//    /**
//     * 客服回复
//     *
//     * @return
//     */
//    @ApiOperation(value = "客服回复", notes = "客服回复")
//    @AdminLog
//    @PostMapping("/ReplyUser")
//    public Result<Object> ReplyUser(@ApiParam(value = "获取用户举报信息") @RequestBody UserFeedbackDo userFeedbackDo,
//                                    @ApiParam(value = "获取操作人id") @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {
//        //保存是谁处理了条举报信息
//        userFeedbackDo.setReplyUserId(commonUserInfoDo.getSysUniId());
//        return feedbackService.ReplyUser(userFeedbackDo);
//
//    }
}
