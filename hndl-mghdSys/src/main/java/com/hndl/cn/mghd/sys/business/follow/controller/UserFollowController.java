package com.hndl.cn.mghd.sys.business.follow.controller;


import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.follow.service.UserFollowService;
import com.hndl.cn.mghd.sys.business.follow.vo.UserFollowVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 尹争鸣
 * @Description
 * @Date 2019年5月28日11:45:22
 * @Created by 湖南达联
 */

@RestController
@RequestMapping("/{source}/follow")
@Api(value = "/{source}/follow",tags = "关注相关接口")
public class UserFollowController {

    @Resource
    private UserFollowService userFollowService;

    @PostMapping(path = "/addFollow")
    @ApiOperation(value = "添加关注")
    @AuthPassport
    public Result<Object> addFollow(@PathVariable String source,
                                    @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                    @RequestBody @Valid UserFollowVo userFollowVo){

        userFollowService.followUser(commonUserInfoDo,userFollowVo);
        return  ResultFactory.success();
    }


    @PostMapping(path = "/cancelFollow")
    @ApiOperation(value = "取消关注")
    @AuthPassport
    public Result<Object> cancelFollow(@PathVariable String source,
                                       @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                       @RequestBody @Valid UserFollowVo userFollowVo){
        userFollowService.cancelFollow(commonUserInfoDo,userFollowVo);
        return  ResultFactory.success();

    }


    @GetMapping(path = "/findFollow")
    @ApiOperation(value = "获取关注信息")
    @AuthPassport
    public  Result<Object> findFollow(@PathVariable String source,
                                      @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo){

        return   ResultFactory.success(userFollowService.findFollow(commonUserInfoDo));

    }

    @GetMapping(path = "/findFollowCount")
    @ApiOperation(value = "获取关注数和粉丝数信息")
    @AuthPassport
    public Result<Object> findFollowCount(@PathVariable String source,
                                          @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo){
        return   ResultFactory.success(userFollowService.findFollowCount(commonUserInfoDo));

    }

    @GetMapping(path = "/findFollowCall")
    @ApiOperation(value = "获取关注数和粉丝数信息")
    @AuthPassport
    public Result<Object>  findFollowCall(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                          @RequestParam Integer pageNo){

        if(pageNo > BaseConstants.FOLLOW_LIMIT){
            return ResultFactory.success();
        }

        return  ResultFactory.success(userFollowService.findFollowCall(commonUserInfoDo,pageNo));
    }


    @GetMapping(path = "/recommendedFollow")
    @ApiOperation(value = "为你推荐日榜前八")
    @AuthPassport
    public  Result<Object> recommendedFollow(@PathVariable String source){
        return  ResultFactory.success(userFollowService.recommendedFollow());
    }

}
