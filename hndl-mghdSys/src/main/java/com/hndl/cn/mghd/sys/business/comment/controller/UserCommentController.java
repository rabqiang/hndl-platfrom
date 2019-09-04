package com.hndl.cn.mghd.sys.business.comment.controller;


import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.comment.service.UserCommentService;
import com.hndl.cn.mghd.sys.business.comment.vo.UserCommentVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年5月8日 11:17:53
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/comment")
@Api(value = "/{source}/comment" , tags = "评论相关接口")

public class UserCommentController {

    @Resource
    private UserCommentService userCommentService;


    //新增评论
    @PostMapping(path = "/insertUserComment")
    @ApiOperation(value = "新增评论")
    @AuthPassport
    public Result<Object> insertUserComment(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @RequestBody @Valid UserCommentVo userCommentVo) {
        return userCommentService.insertUserComment(commonUserInfoDo, userCommentVo);

    }

    //删除评论
    @GetMapping(path = "/deleteComment")
    @ApiOperation(value = "删除评论",notes = "id为评论返回回来的id，用于唯一标识这条评论")
    @AuthPassport
    public Result<Object> deleteComment(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,@RequestParam String id) {

        return userCommentService.deleteComment(commonUserInfoDo,id);

    }


}
