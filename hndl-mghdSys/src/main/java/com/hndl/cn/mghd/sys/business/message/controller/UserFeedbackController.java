package com.hndl.cn.mghd.sys.business.message.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.message.FeedbackEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.message.service.UserFeedbackService;
import com.hndl.cn.mghd.sys.business.message.vo.UserFeedbackTypeVo;
import com.hndl.cn.mghd.sys.business.message.vo.UserFeedbackVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/27 10:12
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/userFeedback")
@Api(value = "/{source}/userFeedback",tags = "用户反馈")
public class UserFeedbackController {

    @Resource
    private UserFeedbackService userFeedbackService;


    @ApiOperation(value = "查询反馈建议类型", notes = "获取举报类型")
    @AuthPassport
    @CrossOrigin
    @GetMapping("/findUserFeedbackType")
    public Result<List<UserFeedbackTypeVo>> findUserFeedbackType(@PathVariable String source) {
        List<UserFeedbackTypeVo> userFeedbackTypeVoList = new ArrayList<>();
        for (FeedbackEnums value : FeedbackEnums.getFeedback().values()) {
            //将从枚举中查询出来的信息放入vo对象中去
            UserFeedbackTypeVo userFeedbackTypeVo = new UserFeedbackTypeVo();
            userFeedbackTypeVo.setType(value.getTypeId());
            userFeedbackTypeVo.setDescription(value.getDescription());
            userFeedbackTypeVoList.add(userFeedbackTypeVo);
        }
        return ResultFactory.success(userFeedbackTypeVoList);
    }

    @ApiOperation(value = "增加用户建议信息 ", notes = "必须先登陆")
    @CrossOrigin
    @AuthPassport
    @PostMapping("/insertUserFeedback")
    public Result<String> insertUserFeedback(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                             @RequestBody @Valid UserFeedbackVo userFeedbackVo) {
        //用户建议信息类型默认为9,粉丝反馈
        return userFeedbackService.insertUserFeedback(commonUserInfoDo.getSysUniId(), null, FeedbackEnums.FANS_SUGGESTIONS, userFeedbackVo);
    }

    @ApiOperation(value = "增加用户举报信息 ", notes = "必须先登陆")
    @CrossOrigin
    @AuthPassport
    @PostMapping("/insertUserReport")
    public Result<String> insertUserReport(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                           @ApiParam(value = "(被举报人id/或者举报的内容(callId))") @RequestParam String objId,
                                           @ApiParam(value = "反馈类型(调用获取举报类型接口)") @RequestParam Integer integralType,
                                           @RequestBody @Valid UserFeedbackVo userFeedbackVo) {
        FeedbackEnums feedbackEnums = FeedbackEnums.evalVal(integralType);
        if (feedbackEnums == null) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return userFeedbackService.insertUserFeedback(commonUserInfoDo.getSysUniId(), objId, feedbackEnums, userFeedbackVo);
    }
}
