package com.hndl.cn.shop.sys.business.welfare.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.shop.sys.business.welfare.service.FoucaultLogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.constraints.Min;

/**
 * @Classname 用户福卡记录控制器
 * @Created by 湖南达联
 * @Date 2019/8/1 10 50
 * @Description:
 * @Author: 资龙茂
 */
@RestController
@RequestMapping("/foucaultLog")
@Api(tags = "foucaultLog")
public class FoucaultLogController {

    @Resource
    private FoucaultLogService foucaultLogService;

    @GetMapping("/findFoucaultAddInfo")
    @AuthPassport
    @ApiOperation(value="用户查询福卡增加记录", notes="用户查询福卡增加记录")
    public Result<Object> findFoucaultAddInfo(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                              @ApiParam(value = "上一页的最后一条记录的id, 根据此字段分页") String id) {
        return foucaultLogService.findFoucaultAddInfo(commonUserInfoDo, id);
    }

    @GetMapping("/findFoucaultRedInfo")
    @AuthPassport
    @ApiOperation(value="用户查询福卡消费记录", notes="用户查询福卡消费记录")
    public Result<Object> findFoucaultRedInfo(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                              @ApiParam(value = "上一页的最后一条记录的id, 根据此字段分页") String id) {
        return foucaultLogService.findFoucaultRedInfo(commonUserInfoDo, id);
    }



}
