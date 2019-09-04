package com.hndl.cn.mghd.admin.business.star.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.star.service.StarActiveDataService;
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
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/3 20 13
 * @Description:
 * @Author: 资龙茂
 */
@RestController
@RequestMapping("/starActiveInfo")
@Api(tags = "明星每日数据查询")
public class StarActiveDataController {

    @Resource
    private StarActiveDataService starActiveDataService;

    @GetMapping("/findStarActiveInfo")
    @AdminLog
    @AuthPower
    @ApiOperation(value="管理后台查询明星每日数据", notes="查询明星每日数据")
    public Result<Object> findStarActiveInfo(@ApiParam(value = "明星姓名") @RequestParam(required = true) String starName,
                                             @ApiParam(value = "开始时间") @RequestParam(required = true) Long startDate,
                                             @ApiParam(value = "结束时间") @RequestParam(required = true) Long endDate) {
        return starActiveDataService.findStarActiveInfoByName(starName, startDate, endDate);
    }
}
