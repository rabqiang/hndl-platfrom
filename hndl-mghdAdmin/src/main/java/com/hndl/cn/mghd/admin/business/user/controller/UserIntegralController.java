package com.hndl.cn.mghd.admin.business.user.controller;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.user.service.UserInfoService;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
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
 * @Description   用户管理之积分操作
 * @Date 2019/6/28 18:43
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/UserIntegral")
@Api(value = "/UserIntegral",tags = "用户管理中积分操作")
public class UserIntegralController {
    //注入相关的service层
    @Resource
    private UserInfoService userInfoService;

    @ApiOperation(value = "用户管理之加积分", notes = "增加积分")
    @GetMapping("/addUserIntegral")
    @AuthPower
    @AdminLog
    public Result<Object> addUserIntegral(@RequestParam Long userUniId,
                                             @ApiParam(value = "需要修改的积分") @RequestParam Long integral,
                                             @ApiParam(value = "加分原因") @RequestParam String integralText) {

        return userInfoService.updateUserIntegral(userUniId, IsValidEnums.NO, integral,integralText);
    }
    @ApiOperation(value = "用户管理之减积分", notes = "减少积分")
    @GetMapping("/reduceUserIntegral")
    @AuthPower
    @AdminLog
    public Result<Object> reduceUserIntegral(@RequestParam Long userUniId,
                                             @ApiParam(value = "需要修改的积分") @RequestParam Long integral,
                                             @ApiParam(value = "减少积分原因") @RequestParam String integralText) {

        return userInfoService.updateUserIntegral(userUniId, IsValidEnums.YES, integral,integralText);
    }

    @ApiOperation(value = "用户管理之批量增加积分", notes = "批量增加积分就直接将要添加的直接输入进去用英文逗号分隔," +
            "如果是增加所有就不需要添加用户id")
    @AuthPower
    @AdminLog
    @GetMapping("/addUserAllGetIntegral")
    public Result<Object> addUserAllGetIntegral(@ApiParam(value = "输入用户id,注意多个用户id必须使用英文逗号分隔")@RequestParam String userUniId,
                                                @ApiParam(value = "需要增加的积分") @RequestParam Long integral,
                                                @ApiParam(value = "加分原因") @RequestParam String integralText) {

        return userInfoService.addUserAllGetIntegral(userUniId.split(","), integral);
    }
}
