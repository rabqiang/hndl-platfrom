package com.hndl.cn.chat.sys.business.room.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.chat.sys.business.room.service.SysUserInfoService;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 21:49
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/user")
public class SysChatUserController {

    @Resource
    private SysUserInfoService sysUserInfoService;


    @AuthPassport
    @PostMapping("/insertEaseMobUser")
    public Result<Object> insertEaseMobUser(@CurrentUser CommonUserInfoDo commonUserInfoDo){
         return sysUserInfoService.insertEaseMobUser(commonUserInfoDo);
    }


}
