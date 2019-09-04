package com.hndl.cn.mghd.sys.business.wechat.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.wechat.service.WechatHomeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 曹加丽
 * @Description 小程序首页
 * @Date 2019/5/23 9:53
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/wechatHome")
@Api(value = "/{source}/wechatHome",tags = "小程序首页 相关接口")
public class WechatHomeController {

    @Resource
    private WechatHomeService wechatHomeService;

    /**
     * 查询小程序首页的信息
     * @return
     */
    @GetMapping("/findWechatHomePage")
    @AuthPassport(validate = false)
    @ApiOperation(value="查询小程序首页日榜接口", notes="首页实时数据")
    public Result<Object>  findWechatHome(@PathVariable String source){
        return  wechatHomeService.initfindWechatGeHome();
    }
}
