package com.hndl.cn.mghd.admin.business.shop.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.shop.service.ShopAppDataService;
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
import java.util.Date;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/3 20 13
 * @Description:
 * @Author: 资龙茂
 */
@RestController
@RequestMapping("/statistics")
@Api(value = "后台 每日统计数据")
public class ShopAppDataController {

    @Resource
    private ShopAppDataService shopAppDataService;

    @GetMapping("/findCurrentShopAppData")
    @AdminLog
    @AuthPower
    @ApiOperation(value="管理后台查询今日统计数据", notes="查询今日统计数据")
    public Result<Object> findCurrentShopAppData() {
        return shopAppDataService.findCurrentShopAppData();
    }

    @GetMapping("/findShopAppDataByDate")
    @AuthPower
    @AdminLog
    @ApiOperation(value="管理后台查询每日统计数据", notes="查询每日统计数据")
    public Result<Object> findCurrentShopAppData(@ApiParam(value = "页码") @RequestParam(required = true) Integer pageNum,
                                                 @ApiParam(value = "每页数据量") @RequestParam(required = true) Integer pageSize,
                                                 @ApiParam(value = "开始时间") @RequestParam(required = false) Long startDate,
                                                 @ApiParam(value = "结束时间") @RequestParam(required = false) Long endDate) {
        return shopAppDataService.findShopAppDataByDate(pageNum, pageSize, startDate, endDate);
    }
}
