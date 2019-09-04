package com.hndl.cn.mghd.sys.business.hide.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.hide.service.HideService;
import com.hndl.cn.mghd.sys.business.hide.vo.HideVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @program:hndl-platform
 * @description: 隐藏相关接口
 * @author: 易成贤
 * @create: 2019-06-12 15:07
 * @Created by湖南达联
 **/
@RestController
@RequestMapping(path = "/{source}")
@Api(tags = "ios 隐藏")
public class HideController {


    @Resource
    HideService hideService;
    /**
     * ios隐藏相关
     * @return
     */
    @GetMapping("/hideIos")
    @AuthPassport(validate = false)
    @ApiOperation(value = "隐藏接口")
    public Result<HideVo> hideIos(@PathVariable String source, @ApiParam(value = "版本号") @RequestParam(required = true) String version){
        return  hideService.findIosHide(source,version);
    }
}
