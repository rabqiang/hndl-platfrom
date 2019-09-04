package com.hndl.cn.mghd.admin.business.user.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.user.service.UserEmpiricalService;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 曹加丽
 * @Description   后台管理   经验值管理
 * @Date 2019/6/21 20:41
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/userEmpirical")
@Api(value = "/userEmpirical",tags = "经验值管理")
public class UserEmpiricalController {

    @Resource
    private UserEmpiricalService userEmpiricalService;

    /**
     * 查询单个用户经验值信息
     *
     * @return
     */
    @ApiOperation(value = "查询单个用户经验值信息", notes = "查询单个用户经验值信息")
    @AdminLog
    @AuthPower
    @GetMapping("/findUserEmpiricalById")
    public Result<Object> findUserEmpiricalById(@ApiParam(value = "用户id")@RequestParam Long userUniId,String id){

        return userEmpiricalService.findUserEmpiricalById(userUniId,id);

    }

    /**
     * 查询所有用户经验值信息,查询最近用户经验值记录
     *
     * @return
     */
    @ApiOperation(value = "查询所有用户经验值信息", notes = "查询所有用户经验值信息<br/>从最近记录开始输出")
    @AdminLog
    @AuthPower
    @GetMapping("/findUserEmpiricalAll")
    public Result<Object> findUserEmpiricalAll(String id){

        return userEmpiricalService.findUserEmpiricalById(null,id);

    }
}
