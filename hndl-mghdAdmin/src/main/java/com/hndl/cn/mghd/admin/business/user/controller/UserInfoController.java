package com.hndl.cn.mghd.admin.business.user.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.admin.business.user.service.UserInfoService;
import com.hndl.cn.mghd.admin.business.user.vo.UserInfoVo;
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
 * @author 曹加丽
 * @Description 后台管理  用户管理
 * @Date 2019/6/20 11:38
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/userInfo")
@Api(value = "/userInfo",tags = "用户管理")
public class UserInfoController {
    //注入相关的service层
    @Resource
    private UserInfoService userInfoService;

    /**
     * 查询用户详细的信息
     *
     * @return
     */
    @AdminLog
    @AuthPower
    @ApiOperation(value = "查询所有用户信息", notes = "没有查询条件")
    @GetMapping("/findUserInfo")
    public Result<Object> findUserInfo(@ApiParam(value = "页码") @RequestParam Integer pageNo) {
        return userInfoService.findUserInByLimit(null, pageNo);
    }


    /**
     * 查询用户详细的信息
     *
     * @return
     */
    @AuthPower
    @AdminLog
    @ApiOperation(value = "根据查询条件查询用户信息", notes = "查询用户信息,可以根据创建时间,快乐号,手机号,昵称,运营商,设备类型,手机型号查询")
    @GetMapping("/findUserInByLimit")
    public Result<Object> findUserInByLimit(@ApiParam(value = "页码") @RequestParam Integer pageNo,
                                            UserInfoVo userInfoVo) {
        CommonUserInfoDo commonUserInfoDo = new CommonUserInfoDo();
        if (userInfoVo.getCreateTime() != null) {
            commonUserInfoDo.setCreateTime(new Date(userInfoVo.getCreateTime()));//创建时间
        }
        if (userInfoVo.getLastTime() == null && userInfoVo.getCreateTime() != null) {
            commonUserInfoDo.setLastModifyTime(new Date()); //结束时间
        } else if (userInfoVo.getLastTime() != null) {
            commonUserInfoDo.setLastModifyTime(new Date(userInfoVo.getLastTime()));//结束时间
        }
        if (userInfoVo.getCellPhoneNumber() != null) {
            commonUserInfoDo.setPhoneNumPerson(Long.parseLong(userInfoVo.getCellPhoneNumber()));//手机号
        }
        commonUserInfoDo.setId(userInfoVo.getId()); //快乐号
        commonUserInfoDo.setNickName(userInfoVo.getUserName()); //昵称
        commonUserInfoDo.setNetType(userInfoVo.getNetType());//运营商
        commonUserInfoDo.setAppType(userInfoVo.getAppType());//设备类型(ios ,安卓)
        commonUserInfoDo.setPhoneName(userInfoVo.getPhoneName());//手机型号(类似iPhone)
        return userInfoService.findUserInByLimit(commonUserInfoDo, pageNo);

    }

}
