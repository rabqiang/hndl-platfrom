package com.hndl.cn.mghd.admin.business.user.controller;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.user.service.UserInfoService;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.nosql.redis.service.RedisService;
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
 * @Description TODO  用户管理之操作快乐币
 * @Date 2019/6/28 18:32
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/UserMangoCoin")
@Api(value = "/UserMangoCoin",tags = "用户管理中操作快乐币")
public class UserMangoCoinController {
    //注入相关的service层
    @Resource
    private UserInfoService userInfoService;

    @Resource
    private RedisService redisService;

    @ApiOperation(value = "用户管理之加快乐币", notes = "增加快乐币")
    @AdminLog
    @AuthPower
    @GetMapping("/addUserConiCount")
    public Result<Object> addUserConiCount(@ApiParam(value = "用户uniId") @RequestParam Long userUniId,
                                           @ApiParam(value = "需要增加的快乐币") @RequestParam Long mangoCount,
                                           @ApiParam(value = "加快乐币原因") @RequestParam String integralText) {
        return userInfoService.updateUserConiCount(userUniId, IsValidEnums.NO, mangoCount);
    }

    @ApiOperation(value = "用户管理之减快乐币", notes = "减少快乐币")
    @AdminLog
    @AuthPower
    @GetMapping("/reduceUserConiCount")
    public Result<Object> updateUserConiCount(@ApiParam(value = "用户uniId") @RequestParam Long userUniId,
                                              @ApiParam(value = "需要减少的快乐币") @RequestParam Long mangoCount,
                                              @ApiParam(value = "减少快乐币原因") @RequestParam String integralText) {

        return userInfoService.updateUserConiCount(userUniId, IsValidEnums.YES, mangoCount);
    }
}
