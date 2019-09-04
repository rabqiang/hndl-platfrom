package com.hndl.cn.mghd.admin.auth.role.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.auth.role.service.AdminRoleInfoService;
import com.hndl.cn.mghd.admin.auth.role.vo.AddRoleVo;
import com.hndl.cn.mghd.admin.auth.role.vo.UserRoleVo;
import com.hndl.cn.mghd.admin.auth.role.vo.AdminRoleVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/21 10:30
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/admin/role")
public class AdminRoleController {


    @Resource
    private AdminRoleInfoService adminRoleInfoService;

    @PostMapping("/addRole")
    @AuthPower
    @AdminLog
    public Result<Object> addRole(@RequestBody @Valid AddRoleVo vo, HttpServletRequest request)  {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return adminRoleInfoService.addRole(vo,loginUser.getId());
    }

    @GetMapping("/findRoleByPage")
    @AuthPower
    @AdminLog
    public Result<Object> findRoleByPage(@RequestParam Integer pageNo, HttpServletRequest request)  {
        return adminRoleInfoService.findRoleByPage(pageNo);
    }

    @GetMapping("/checkRoleName")
    @AuthPower
    @AdminLog
    public Result<Object> checkRoleName(@RequestParam String roleName, HttpServletRequest request)  {
        return ResultFactory.success(adminRoleInfoService.checkRoleName(roleName));
    }

    @GetMapping("/findRoleByUserId")
    @AuthPower
    @AdminLog
    public Result<Object> findRoleByUserId(@RequestParam Long userId, HttpServletRequest request)  {
        return ResultFactory.success(SpringCglibBeanUtils.convertByList(adminRoleInfoService.findRoleByUserId(userId), AdminRoleVo.class));
    }

    @PostMapping("/addUserRole")
    @AuthPower
    @AdminLog
    public Result<Object> addUserRole(@RequestBody @Valid UserRoleVo vo, HttpServletRequest request)  {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return adminRoleInfoService.addUserRole(vo.getUserId(),vo.getRoleIdList(),loginUser.getId());
    }

//    @PostMapping("/removeUserRole")
//    public Result<Object> removeUserRole(@RequestBody @Valid UserRoleVo vo, HttpServletRequest request)  {
//        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
//        return adminRoleInfoService.removeUserRole(vo.getUserId(),vo.getRoleIdList(),loginUser.getId());
//    }


}
