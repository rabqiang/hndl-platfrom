package com.hndl.cn.mghd.sys.business.pay.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.pay.service.HappyCoinBillInfoService;
import com.hndl.cn.mghd.sys.business.pay.vo.HappyCoinBillInfoVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: hndl-platform
 * @description: 快乐币流水
 * @author: 易成贤
 * @create: 2019-05-22 16:56
 * @Created by 湖南达联
 **/
@RestController
@RequestMapping(path = "/{source}/user/happyCoinBill")
@Api(tags = "HappyCoinBill")
public class HappyCoinBillInfoController {

    @Resource
    HappyCoinBillInfoService happyCoinBillInfoService;

    /**
     * 查询用户快乐币流水
     * @param source
     * @param commonUserInfoDo
     * @param pageNo
     * @param isPay
     * @return
     */
    @ApiOperation(value = "查询用户快乐币流水",notes = "用户必须登陆<br/>IsPay参数是收入(0)还是支出(1)")
    @GetMapping("/findHappyCoinBillInfo")
    @AuthPassport
    public Result<List<HappyCoinBillInfoVo>> findHappyCoinBillInfo(
            @PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
            @ApiParam(value = "当前页") @RequestParam Integer pageNo,
            @ApiParam(value = "收入/消费")@RequestParam Integer isPay){
        //判断传入参数
        IsValidEnums enums = IsValidEnums.evalVal(isPay);
        if (enums == null) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        return happyCoinBillInfoService.findHappyCoinBillInfo(commonUserInfoDo,pageNo, enums);
    }

}
