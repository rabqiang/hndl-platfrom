package com.hndl.cn.mghd.admin.business.user.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.user.service.UserIntegralService;
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
 * @Description  后台 积分管理
 * @Date 2019/6/21 20:41
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/UserIntegral")
@Api(value = "/UserIntegral",tags = "积分流水管理")
public class IntegralController {

    @Resource
    private UserIntegralService userIntegralService;

    /**
     * 查询单个用户积分值
     *
     * @return
     */
    @ApiOperation(value = "查询单个用户积分值", notes = "查询单个用户积分值信息")
    @AdminLog
    @AuthPower
    @GetMapping("/findUserIntegralById")
    public Result<Object> findUserIntegralById(@ApiParam(value = "用户id")@RequestParam Long userUniId,
                                               @ApiParam(value = "上一页的最后一条记录的id, 根据此字段分页") @RequestParam(required = false) String id) {

            return userIntegralService.findUserIntegralById(userUniId,  id);

    }
    @ApiOperation(value = "查询所有用户积分值信息", notes = "查询最近用户积分记录信息")
    @AdminLog
    @AuthPower
    @GetMapping("/findUserIntegralAll")
    public Result<Object> findUserIntegralAll(@ApiParam(value = "上一页的最后一条记录的id, 根据此字段分页") @RequestParam(required = false) String id) {

        return userIntegralService.findUserIntegralById(0L,id);

    }
}
