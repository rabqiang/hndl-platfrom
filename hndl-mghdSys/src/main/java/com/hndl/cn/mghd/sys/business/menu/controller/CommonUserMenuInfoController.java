package com.hndl.cn.mghd.sys.business.menu.controller;

import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.RequestTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.sys.business.menu.service.CommonUserMenuInfoService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.utils.string.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年5月10日 11:17:53
 * @Created by 湖南达联
 */

@RestController
@RequestMapping("/{source}/menu")
@Api(tags = "菜单相关接口")
public class CommonUserMenuInfoController {

    @Resource
    private CommonUserMenuInfoService commonUserMenuInfoService;

    /**
     *  IOS根据版本号决定是否显示功能
     * */
    @GetMapping(path = "/getUserMenuInfo")
    @ApiOperation(value="获取菜单按钮", notes="IOS根据版本号决定显示的菜单按钮")
    public Result<Object> getUserMenuInfo(@PathVariable String source,
                                          @ApiParam(name="version",value="版本号,ios必传,android 可以不传")
                                          @RequestParam(required = false) String version){

        if(RequestTypeEnums.IOS.getValue().equals(source) && StringUtils.isBlank(version)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return commonUserMenuInfoService.getUserMenuInfo(version) ;
    }

}
