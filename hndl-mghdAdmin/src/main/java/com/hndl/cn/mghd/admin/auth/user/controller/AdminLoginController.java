package com.hndl.cn.mghd.admin.auth.user.controller;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.auth.user.service.AdminUserInfoService;
import com.hndl.cn.mghd.admin.auth.user.vo.LoginInfoVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.utils.request.RequestUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/18 17:06
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/auth")
public class AdminLoginController {

    @Resource
    private AdminUserInfoService adminUserInfoService;


    @PostMapping("/login")
    @AdminLog
    public Result<Object> login(@RequestBody @Valid LoginInfoVo loginInfoVo, HttpServletRequest request) throws Exception {

        Subject subject = SecurityUtils.getSubject();

        if(subject.isAuthenticated()){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_LOGIN_EX.getCode());
        }
        UsernamePasswordToken token = new UsernamePasswordToken(loginInfoVo.getLoginName(), loginInfoVo.getPassWord());
        subject.login(token);
        return adminUserInfoService.loginSuccess(loginInfoVo.getLoginName(), RequestUtil.getClientIP(request));

    }

    @GetMapping("/error")
    public Result<Object> error() throws Exception {
        return ResultFactory.failure(PublicExceptionCodeEnum.EX_USER_NOT_LOGIN_ERROR.getCode(),
                PublicExceptionCodeEnum.EX_USER_NOT_LOGIN_ERROR.getMsg());

    }



}
