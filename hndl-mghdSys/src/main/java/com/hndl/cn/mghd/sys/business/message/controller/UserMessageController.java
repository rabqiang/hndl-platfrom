package com.hndl.cn.mghd.sys.business.message.controller;


import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.message.service.UserMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

@RestController
@RequestMapping("/{source}/message")
@Api(tags = "用户消息相关接口")
public class UserMessageController {

    @Resource
    private UserMessageService userMessageService;

    @GetMapping("/findSysBySendUserId")
    @ApiOperation(value = "获取系统消息")
    @AuthPassport
    public Result<Object> findSysBySendUserId(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @RequestParam(required=false) String id) {

        return userMessageService.findBySendUserIdMsg(commonUserInfoDo,MessageTypeEnums.SYS_MSG.getType(),id);
    }

    @GetMapping("/findLikeBySendUserId")
    @ApiOperation(value = "获取点赞消息")
    @AuthPassport
    public Result<Object> findLikeBySendUserId(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,@RequestParam(required=false) String id) {

        return userMessageService.findBySendUserIdMsg(commonUserInfoDo,MessageTypeEnums.LIKE_MSG.getType(),id);
    }

    @GetMapping("/findCommentBySendUserId")
    @ApiOperation(value = "获取评论消息")
    @AuthPassport
    public Result<Object> findCommentBySendUserId(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,@RequestParam(required=false) String id) {

        return userMessageService.findBySendUserIdMsg(commonUserInfoDo, MessageTypeEnums.COMMENT_MSG.getType(),id);
    }

    @GetMapping("/addUserMessageRelation")
    @ApiOperation(value = "插入用户消息关系")
    @AuthPassport
    public Result<Object> addUserMessageRelation(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @RequestParam Long messageId, @RequestParam Integer messageType) {
        userMessageService.insertUserRelation(commonUserInfoDo, messageId.toString(), messageType);
        return ResultFactory.success();
    }


    @GetMapping("/findAllMsg")
    @ApiOperation(value = "获取三种消息及未读数")
    @AuthPassport
    public Result<Object> findAllMsg(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo){

        return ResultFactory.success(userMessageService.findAllMessage(commonUserInfoDo));
    }

}
