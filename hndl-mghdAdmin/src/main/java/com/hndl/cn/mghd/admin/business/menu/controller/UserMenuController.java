package com.hndl.cn.mghd.admin.business.menu.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.menu.service.UserMenuService;
import com.hndl.cn.mghd.admin.business.menu.vo.UserMenuVo;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/5 16 40
 * @Description:
 * @Author: 资龙茂
 */
@RestController
@RequestMapping("/userMenu")
@Api(value = "后台 个人中心菜单")
public class UserMenuController {

    @Resource
    private UserMenuService userMenuService;

    @PostMapping("/addUserMenu")
    @ApiOperation(value="管理后台添加个人中心菜单", notes="新增menu")
    public Result<Object> addUserMenu(@ApiParam(value = "menu数据对象") @RequestBody @Valid UserMenuVo userMenuVo) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return userMenuService.addUserMenu(loginUser, userMenuVo);
    }

    @DeleteMapping("/deleteUserMenu")
    @ApiOperation(value="管理后台删除个人中心菜单", notes="删除menu")
    public Result<Object> deleteUserMenu(@ApiParam(value = "menu对应ID") @RequestParam(required = true) Long id) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return userMenuService.deleteUserMenuById(loginUser, id);
    }

    @ApiOperation(value="管理后台修改个人中心菜单", notes="修改menu")
    @PutMapping("/updateUserMenu")
    public Result<Object> updateUserMenu(@ApiParam(value = "menu数据对象") @RequestBody @Valid UserMenuVo userMenuVo) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return userMenuService.updateUserMenu(loginUser, userMenuVo);
    }

    @GetMapping("/findMenuInfo")
    @ApiOperation(value="管理后台获取menu列表", notes="查询menu列表")
    public Result<Object> findMenuInfo(){
        return ResultFactory.success(userMenuService.findUserMenuInfo());
    }

    @GetMapping("/findMenuInfoSingle")
    @ApiOperation(value="管理后台查询单条menu", notes="查询单条menu")
    public Result<Object> findMenuInfoSingle(@ApiParam(value = "menuID") @RequestParam(required = true) Long id){
        return userMenuService.findUserMenuInfoSingle(id);
    }
}
