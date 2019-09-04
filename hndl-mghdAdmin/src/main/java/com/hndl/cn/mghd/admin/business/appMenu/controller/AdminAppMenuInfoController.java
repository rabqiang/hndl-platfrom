package com.hndl.cn.mghd.admin.business.appMenu.controller;


import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.appMenu.service.AdminAppMenuInfoService;
import com.hndl.cn.mghd.admin.business.appMenu.vo.SystemAppMenuNewVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月15日15:07:29
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/appMenu")
@Api(value = "/appMenu", tags = "admin-appmenu-controller")
public class AdminAppMenuInfoController {

    @Resource
    private AdminAppMenuInfoService adminAppMenuInfoService;


    /**
     * 分页查询首页头部菜单
     */

    @ApiOperation(value="管理后台查询菜单", notes="查询首页头部菜单")
    @AuthPower
    @AdminLog
    @GetMapping("/findPageAppMenu")
    public Result<Object> findPageAppMenu(Integer pageStart) {

        return ResultFactory.success(adminAppMenuInfoService.findPageAppMenu(pageStart));
    }


    /**
     * 条件查询首页头部菜单
     */
    @ApiOperation(value = "管理后台查询菜单", notes = "条件查询首页头部菜单")
    @AuthPower
    @AdminLog
    @GetMapping("/findByAppMenu")
    public Result<Object> findByAppMenu(SystemAppMenuNewVo systemAppMenuNewVo, Integer pageStart) {
        return ResultFactory.success(adminAppMenuInfoService.findByAppMenu(systemAppMenuNewVo, pageStart));
    }


}
