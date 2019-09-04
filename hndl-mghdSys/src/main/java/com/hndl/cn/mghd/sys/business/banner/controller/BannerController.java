package com.hndl.cn.mghd.sys.business.banner.controller;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.banner.service.BannerService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import io.swagger.annotations.*;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description 获取banner相关接口
 * @Date 2019/4/29 17:41
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/star/banner")
@Api(tags = "Banner")
public class BannerController {


    @Resource
    private BannerService bannerService;

    @GetMapping("/findBannerInfo")
    @ApiOperation(value="获取banner信息", notes="查询banner")
    public Result<Object> findBannerInfoByBannerEnums(@PathVariable String source,
                                                      @ApiParam(name="model",value="Banner类型",required=true)
                                                      @RequestParam String model){
         BannerEnums eval = BannerEnums.eval(model);

         if(eval == null){
             throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
         }

        return bannerService.findBannerInfoByBannerEnums(eval);
    }

}
