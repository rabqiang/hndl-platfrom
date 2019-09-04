package com.hndl.cn.mghd.sys.business.home.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.RequestTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import com.hndl.cn.mghd.sys.business.home.service.AppHomeService;
import com.hndl.cn.mghd.sys.business.menu.service.AppHomeMenuService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.utils.string.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/23 14:31
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}")
@Api(tags = "app 主页")
public class AppHomeController {

    @Resource
    private AppHomeService appHomeService;

    @Resource
    private AppHomeMenuService appHomeMenuService;

    /**
     * App 首页接口
     * @return
     */
    @GetMapping("/initAppHomeData")
    @AuthPassport
    @ApiOperation(value="查询APP首页日榜接口")
    public Result<Object> initAppHomeData(@PathVariable String source,@RequestParam(required = false) String version,
                                         @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo){

        if(RequestTypeEnums.IOS.getValue().equals(source) && StringUtils.isBlank(version)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return appHomeService.initAppHomeData(version, source,commonUserInfoDo);
    }


    @GetMapping("/findAppHomeMenu")
    @ApiOperation(value="查询首页的菜单")
    public Result<Object> findAppHomeMenu(@PathVariable String source,
                                          @RequestParam String version){

        if(RequestTypeEnums.IOS.getValue().equals(source) && StringUtils.isBlank(version)){
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        return ResultFactory.success(appHomeMenuService.findAppHomeMenu(source,version));
    }

    /**
     *
     * @param source
     * @param commonUserInfoDo
     * @return
     */
    @GetMapping("/findHomeStarFansCircle")
    @AuthPassport
    @ApiOperation(value="查询app下滑数据", notes="下滑数据")
   public Result<List<StarCallContentVo>> findAppHomeStarFansCircle(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                                                    @ApiParam(value = "页数") @RequestParam Integer pageNo){
        return appHomeService.findAppHomeStarFansCircle(commonUserInfoDo,pageNo);
    }
}
