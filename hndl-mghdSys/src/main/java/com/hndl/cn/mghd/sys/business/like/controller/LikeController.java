package com.hndl.cn.mghd.sys.business.like.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.like.service.LikeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @program:hndl-platform
 * @description: 点赞
 * @author: 易成贤
 * @create: 2019-05-09 10:57
 * @Created by 湖南达联
 **/
@RestController
@Api(tags = "点赞")
@RequestMapping("/{source}/star/like")
public class LikeController {

    @Resource
    LikeService likeService;

    /**
     * 点赞
     * @param commonUserInfoDo
     * @param starId
     * @param targetId
     * @return
     */
    @ApiOperation(value = "点赞",notes = "给某条打call或者爱豆说点赞<br/>用户必须登陆",httpMethod = "POST")
    @GetMapping("/addlike")
    @AuthPassport
    public Result<Object> addLike(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                  @ApiParam(value = "明星id",required = true) @RequestParam Long starId,
                                  @ApiParam(value = "点赞目标id/callId",required = true)@RequestParam Long targetId,
                                  @ApiParam(value = "发布这条打call/或者评论数据的用户id",required = true)@RequestParam Long userUniId){
        //直接点赞
        return  likeService.addLike(commonUserInfoDo, starId, targetId,userUniId);
    }
}
