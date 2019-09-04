package com.hndl.cn.mghd.sys.business.guard.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.guard.service.GuardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @program: hndl-platform
 * @description: 守护
 * @author: 易成贤
 * @create: 2019-05-10 14:38
 * @Created by 湖南达联
 **/
@Api(tags = "守护")
@RestController
@RequestMapping(path = "/{source}/star/guard")
public class GuardController {

    @Resource
    GuardService guardService;


    /**
     * 守护，每一个用户只能一天守护一次粉丝会，至多守护两个粉丝会
     *
     * @param commonUserInfoDo
     * @param starId
     * @return
     */
    @ApiOperation(value = "守护明星",notes = "用户必须登陆",httpMethod = "GET")
    @AuthPassport
    @GetMapping(path = "/updateGuardCount")
    public Result<Object> updateGuardCount(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                           @ApiParam(value = "明星id",required = true) @RequestParam Long starId) {
        return guardService.doGuard(commonUserInfoDo, starId);
    }
}
