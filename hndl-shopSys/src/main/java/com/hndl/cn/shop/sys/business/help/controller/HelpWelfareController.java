package com.hndl.cn.shop.sys.business.help.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.shop.sys.business.help.service.HelpWelfareService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @Classname 用户助力控制器
 * @Created by 湖南达联
 * @Date 2019/8/4 16 57
 * @Description:
 * @Author: 资龙茂
 */
@RestController
@RequestMapping("/helpWelfare")
@Api(tags = "helpWelfare")
public class HelpWelfareController {

    @Resource
    private HelpWelfareService helpWelfareService;

    /**
     * 这里(还有下面的帮助助力接口)本来是post请求, 但架不住小程序工程师百般撒娇, 改成了get
     * @param commonUserInfoDo
     * @param prizeId
     * @param formId
     * @return
     */
    @GetMapping("/askForHelp")
    @AuthPassport
    @ApiOperation(value="邀请好友助力", notes="邀请好友助力")
    public Result<Object> askForHelp(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                     @ApiParam(value = "奖品ID") @RequestParam(required = true) String prizeId,
                                     @ApiParam(value = "FormId") @RequestParam(required = true) String formId,
                                     @ApiParam(value = "openId") @RequestParam(required = true) String openId) {
        return helpWelfareService.askForHelp(commonUserInfoDo, prizeId, formId, openId);
    }

    @GetMapping("/helpFriend")
    @AuthPassport
    @ApiOperation(value="帮助好友助力", notes="帮助好友助力")
    public Result<Object> helpFriend(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                     @ApiParam(value = "抢福利操作ID") String userWelfareId) {
        return helpWelfareService.helpFriend(commonUserInfoDo, userWelfareId);
    }

    @GetMapping("/findHelpMeFriend")
    @AuthPassport
    @ApiOperation(value="查询帮助自己助力过的好友列表 & 好友人数", notes="查询帮助自己助力过的好友列表 & 好友人数")
    public Result<Object> findHelpMeFriend(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                           @ApiParam(value = "抢福利操作ID") String userWelfareId) {
        return helpWelfareService.findHelpMeFriend(commonUserInfoDo, userWelfareId);
    }
}
