package com.hndl.cn.mghd.admin.auth.role.controller;


import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.auth.role.service.AdminPermissionService;
import com.hndl.cn.mghd.admin.auth.role.vo.AddPermissionVo;
import com.hndl.cn.mghd.admin.auth.role.vo.RolePermissionVo;
import com.hndl.cn.mghd.admin.auth.role.vo.UpdatePermissionVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 20:37
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/admin/permission")
public class AdminPermissionController {


    @Resource
    private AdminPermissionService adminPermissionService;


    @PostMapping("/addPermission")
    @AuthPower
    @AdminLog
    public Result<Object> addRole(@RequestBody @Valid AddPermissionVo vo, HttpServletRequest request)  {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return adminPermissionService.addPermission(vo,loginUser.getId());
    }

    @PostMapping("/updatePermission")
    @AuthPower
    @AdminLog
    public Result<Object> updatePermission(@RequestBody @Valid UpdatePermissionVo vo, HttpServletRequest request)  {
        if(vo.getId()  == null){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return adminPermissionService.updatePermission(vo);
    }

    @PostMapping("/addRolePermission")
    @AuthPower
    @AdminLog
    public Result<Object> addRolePermission(@RequestBody @Valid RolePermissionVo vo, HttpServletRequest request)  {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return adminPermissionService.addRolePermission(vo,loginUser.getId());
    }

    @GetMapping("/findPermissionByPage")
    @AuthPower
    @AdminLog
    public Result<Object> findPermissionByPage(@RequestParam Integer pageNo ,
                                               @RequestParam(required = false)  Long pid, HttpServletRequest request)  {
        return adminPermissionService.findPermissionByPage(pageNo,pid);
    }

    @GetMapping("/findPermissionUrL")
    @AuthPower
    @AdminLog
    public Result<Object> findPermissionUrL(HttpServletRequest request)  {
        return adminPermissionService.findPermissionUrL();
    }


    @GetMapping("/findRolePermissionByRoleId")
    @AuthPower
    @AdminLog
    public Result<Object> findRolePermissionByRoleId(HttpServletRequest request,@RequestParam Long roleId)  {
        return adminPermissionService.findRolePermissionByRoleId(roleId);
    }





}
