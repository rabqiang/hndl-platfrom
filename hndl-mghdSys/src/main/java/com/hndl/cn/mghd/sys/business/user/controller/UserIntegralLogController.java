package com.hndl.cn.mghd.sys.business.user.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.user.service.UserIntegralLogService;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * @author 曹加丽
 * @Description   查询用户积分信息
 * @Date 2019/5/20 11:47
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/{source}/user")
@Api(value = "/{source}/user", tags = "用户积分信息")
public class UserIntegralLogController {

    @Resource
    private UserIntegralLogService userIntegralLogService;

    /**
     * 查询用户积分日志
     *
     * @param commonUserInfoDo 用户基本信息lei
     * @param isPay   积分类型
     * @param pageNo       分多少页
     * @return
     */
    @ApiOperation(value = "获取用户积分明细", notes = "必须先登陆,否则无法获取用户积分明细")
    @AuthPassport
    @CrossOrigin
    @GetMapping("/findUserIntegralLog")
    public Result<Object> findUserIntegralLog(@PathVariable String source, @CurrentUser @ApiIgnore  CommonUserInfoDo commonUserInfoDo,
                                              @ApiParam(value = "页码")  Integer pageNo,
                                              @ApiParam(value = "1 消费记录 / 0 加分记录") @RequestParam Integer isPay, @ApiParam(value = "分页游标") String id) {

        IsValidEnums isValidEnums = IsValidEnums.evalVal(isPay);
        if (null == isValidEnums){
            throw  new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }

        if (IsValidEnums.YES.equals(isValidEnums)) {
            isValidEnums = IsValidEnums.NO;
        }else {
            isValidEnums = IsValidEnums.YES;
        }
        return userIntegralLogService.findUserIntegralLog(commonUserInfoDo.getSysUniId(),isValidEnums, pageNo,id);
    }
}
