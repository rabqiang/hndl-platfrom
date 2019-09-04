package com.hndl.cn.mghd.admin.business.user.controller;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.user.service.UserInfoService;
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
 * @Description TODO 用户管理之封号
 * @Date 2019/7/16 14:45
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/closeUser")
@Api(value = "/closeUser",tags = "用户管理中封号管理")
public class CloseUserController {

    @Resource
    UserInfoService userInfoService;

    @ApiOperation(value = "用户管理之封号", notes = "用户封号方法")
    @GetMapping("/userClose")
    @AdminLog
    @AuthPower
    public Result<Object> userClose(@ApiParam(value = "用户uniId")@RequestParam Long userUniId,
                                             @ApiParam(value = "封号原因") @RequestParam String integralText) {

        return userInfoService.userInfoSealNumber(userUniId, IsValidEnums.YES);
    }

    @ApiOperation(value = "用户管理之解封", notes = "用户解封方法")
    @GetMapping("/userOpes")
    @AdminLog
    @AuthPower
    public Result<Object> userOpes(@ApiParam(value = "用户uniId")@RequestParam Long userUniId,
                                             @ApiParam(value = "解封原因") @RequestParam String integralText) {

        return userInfoService.userInfoSealNumber(userUniId, IsValidEnums.NO);
    }
}
