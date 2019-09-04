package com.hndl.cn.mghd.admin.auth.user.controller;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.auth.user.service.AdminUserInfoService;
import com.hndl.cn.mghd.admin.auth.user.vo.AddUserInfoVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/20 17:03
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {

    @Resource
    private AdminUserInfoService adminUserInfoService;


    @AuthPower
    @GetMapping("/findUserInfoPage")
    @AdminLog
    public Result<Object> findUserInfoPage(Long userId,String loginName,@RequestParam Integer pageNo,Integer isDelete){
        if(isDelete!= null && !IsValidEnums.checkVal(isDelete)){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return adminUserInfoService.findUserInfoPage(userId, loginName, pageNo,isDelete);
    }

    @AuthPower
    @AdminLog
    @PostMapping("/addUserInfo")
    public Result<Object> addUserInfo(@RequestBody @Valid AddUserInfoVo addUserInfoVo){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return adminUserInfoService.addAdminUserInfo(addUserInfoVo,loginUser.getId());
    }

    @AuthPower
    @AdminLog
    @GetMapping("/updateAdminUserInfoState")
    public Result<Object> updateAdminUserInfoState(@RequestParam String loginName,@RequestParam Integer isDelete){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();

        if(isDelete!= null && !IsValidEnums.checkVal(isDelete)){
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        if(loginUser.getLoginName().equals(loginName)){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_USER_NOT_DEL_ME_EXCEPTION.getCode());
        }
        return adminUserInfoService.updateAdminUserInfoState(loginName,loginUser.getId(),isDelete);
    }

    @AuthPower
    @AdminLog
    @GetMapping("/refreshUserPassWord")
    public Result<Object> refreshUserPassWord(@RequestParam String loginName){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();

        if(loginUser.getLoginName().equals(loginName)){
              throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_USER_NOT_RE_ME_EXCEPTION.getCode());
        }

        return adminUserInfoService.refreshUserPassWord(loginName,loginUser.getId());
    }

    @AuthPower
    @AdminLog
    @GetMapping("/checkLoginName")
    public Result<Object> checkLoginName(@RequestParam String loginName){
        return adminUserInfoService.checkLoginName(loginName);
    }

}
