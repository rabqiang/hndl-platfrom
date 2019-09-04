package com.hndl.cn.mghd.sys.business.summon.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.summon.service.SummonService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @program: hndl-platform
 * @description: 召唤
 * @author: 易成贤
 * @create: 2019-05-10 13:59
 * @Created by 湖南达联
 **/
@Api(tags ="召唤")
@RestController
@RequestMapping("/{source}/star/summon")
public class SummonController {

    //服务层
    @Resource
    SummonService summonService;

    //召唤/分享
    @ApiOperation(value = "召唤/分享粉丝会",notes = "用户必须登陆<br/>",httpMethod = "GET")
    @AuthPassport
    @GetMapping(path = "/summonTask")
    public Result<Object> summonTask(@PathVariable String source ,@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo, @ApiParam(value = "明星id") @RequestParam Long starId) {
        return summonService.doSummon(commonUserInfoDo, starId);
    }
}
