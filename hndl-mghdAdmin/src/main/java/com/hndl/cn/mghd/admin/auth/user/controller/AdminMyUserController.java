package com.hndl.cn.mghd.admin.auth.user.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.auth.role.service.AdminPermissionService;
import com.hndl.cn.mghd.admin.auth.role.service.AdminRoleInfoService;
import com.hndl.cn.mghd.admin.auth.user.service.AdminUserInfoService;
import com.hndl.cn.mghd.admin.auth.user.vo.AdminUpdateEmailVo;
import com.hndl.cn.mghd.admin.auth.user.vo.AdminUpdateMobileVo;
import com.hndl.cn.mghd.admin.auth.user.vo.AdminUpdateNickNameVo;
import com.hndl.cn.mghd.admin.auth.user.vo.AdminUpdatePassWordVo;
import com.hndl.cn.mghd.admin.business.user.vo.UserInfoVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/18 17:05
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/my")
public class AdminMyUserController {

    @Resource
    private AdminUserInfoService adminUserInfoService;

    @Resource
    private AdminRoleInfoService adminRoleInfoService;

    @Resource
    private AdminPermissionService adminPermissionService;


    @GetMapping("/loginOut")
    @AdminLog
    public Result<Object> loginOut(){
        Subject subject = SecurityUtils.getSubject();

        if(subject.isAuthenticated()){
            subject.logout();
        }
        return ResultFactory.success();
    }


    @PostMapping("/updatePassWord")
    @AdminLog
    public Result<Object> updatePassWord(@RequestBody AdminUpdatePassWordVo vo){
        return adminUserInfoService.updatePassWord(vo);
    }


    @PostMapping("/updateNickName")
    @AdminLog
    public Result<Object> updateNickName(@RequestBody AdminUpdateNickNameVo vo){
        return adminUserInfoService.updateNickName(vo.getNickName());
    }

    @PostMapping("/updateMobile")
    @AdminLog
    public Result<Object> updateMobile(@RequestBody AdminUpdateMobileVo vo){
        return adminUserInfoService.updateMobile(vo.getMobile());
    }

    @PostMapping("/updateEmail")
    @AdminLog
    public Result<Object> updateEmail(@RequestBody AdminUpdateEmailVo vo){
        return adminUserInfoService.updateEmail(vo.getEmail());
    }

    @GetMapping("/findRoleIsMy")
    @AdminLog
    public Result<Object> findRoleIsMy(){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return ResultFactory.success(adminRoleInfoService.findRoleByUserId(loginUser.getId()));
    }

    @GetMapping("/findLoginUserMenu")
    @AdminLog
    public Result<Object> findLoginUserMenu(){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return adminPermissionService.findLoginUserMenu(loginUser.getId());
    }

    @GetMapping("/findLoginUser")
    @AdminLog
    public Result<Object> findLoginUser(){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return ResultFactory.success(SpringCglibBeanUtils.convert(loginUser, UserInfoVo.class));
    }
}
