package com.hndl.cn.mghd.admin.business.appMenu.controller;


import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.appMenu.service.AdminAppMenuInfoService;
import com.hndl.cn.mghd.admin.business.appMenu.vo.SystemAppMenuNewVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月15日15:07:29
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/appMenuEdit")
@Api(value = "/appMenuEdit", tags = "admin-appmenu-controller")
public class AdminAppMenuEditController {

    @Resource
    private AdminAppMenuInfoService adminAppMenuInfoService;



    /**
     * 新增首页头部菜单
     */
    @ApiOperation(value = "管理后台新增菜单", notes = "新增首页头部菜单")
    @AdminLog
    @AuthPower
    @PostMapping("/saveAppMenu")
    public Result<Object> saveAppMenu(@RequestBody @Valid SystemAppMenuNewVo systemAppMenuNewVo) {
        return ResultFactory.success(adminAppMenuInfoService.saveAppMenu(systemAppMenuNewVo));
    }

    /**
     * 修改首页头部菜单
     */
    @ApiOperation(value = "管理后台修改菜单", notes = "修改首页头部菜单")
    @AdminLog
    @AuthPower
    @PostMapping("/updateAppMenu")
    public Result<Object> updateAppMenu(@RequestBody @Valid SystemAppMenuNewVo systemAppMenuNewVo) {

        return ResultFactory.success(adminAppMenuInfoService.updateAppMenu(systemAppMenuNewVo));
    }

    /**
     * 删除首页头部菜单
     */
    @ApiOperation(value = "管理后台删除菜单", notes = "删除首页头部菜单")
    @AdminLog
    @AuthPower
    @GetMapping("/removeAppMenu")
    public Result<Object> removeAppMenu(@RequestParam Long id) {

        return ResultFactory.success(adminAppMenuInfoService.removeAppMenu(id));
    }
}
