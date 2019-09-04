package com.hndl.cn.shop.admin.business.turntable.controller;


import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.shop.admin.business.turntable.service.LuckyTurntableService;
import com.hndl.cn.shop.admin.business.turntable.vo.TurntableInfoVo;
import com.hndl.cn.shop.admin.common.annotation.AdminLog;
import com.hndl.cn.shop.admin.common.annotation.AuthPower;
import com.hndl.cn.shop.admin.common.util.AdminUtil;
import com.hndl.cn.shop.admin.exception.ShopAdminException;
import com.hndl.cn.shop.admin.exception.ShopAdminExceptionEnums;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 曹加丽
 * @Description 后台  幸运转盘管理
 * @Date 2019/7/5 19:57
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/LuckyTurntable")
@Api(value = "/LuckyTurntable")
public class LuckyTurntableController {
    @Resource
    LuckyTurntableService luckyTurntableService;

    /**
     * 增加奖品信息
     *
     * @return
     */
//    @AdminLog
//    @AuthPower
    @PostMapping("/addLuckyTurntable")
    @ApiOperation(value = "增加奖品信息")
    public Result<Object> addLuckyTurntable(@ApiParam(value = "奖品数据对象") @RequestBody @Valid TurntableInfoVo turntableInfoVo) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return luckyTurntableService.addLuckyTurntable(turntableInfoVo, loginUser.getId());
    }

    /**
     * 修改奖品信息
     *
     * @return
     */
//    @AdminLog
//    @AuthPower
    @PostMapping("/updateLuckyTurntable")
    @ApiOperation(value = "修改奖品信息")
    public Result<Object> updateLuckyTurntable(@ApiParam(value = "奖品数据对象") @RequestBody @Valid TurntableInfoVo turntableInfoVo) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return luckyTurntableService.updateLuckyTurntable(turntableInfoVo, loginUser.getId());
    }

    /**
     * 删除下架奖品信息
     *
     * @return
     */
//    @AdminLog
//    @AuthPower
    @PostMapping("/deleteLuckyTurntable")
    @ApiOperation(value = "下架奖品信息")
    public Result<Object> deleteLuckyTurntable(@ApiParam(value = "奖品对象id") @RequestParam Long prizeId) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return luckyTurntableService.deleteLuckyTurntable(prizeId, IsValidEnums.YES, loginUser.getId());
    }

    /**
     * 是否开启实物奖品
     *
     * @param isOpes
     * @return
     */
//    @AdminLog
//    @AuthPower
    @PostMapping("/luckyTurntableIsMaterialOpes")
    @ApiOperation(value = "是否开启实物奖品")
    public Result<Object> luckyTurntableIsMaterialOpes(@ApiParam(value = "是否开启实物抽奖? 1.是0,否") @RequestParam Integer isOpes) {
        IsValidEnums isValidEnums = IsValidEnums.evalVal(isOpes);
        if (isValidEnums == null) {
            throw new ShopAdminException(ShopAdminExceptionEnums.NUMBER_OF_VALUE_NOT_ENOUGH.getCode());
        }
        return luckyTurntableService.luckyTurntableIsMaterialOpes(isValidEnums);
    }

    /**
     * 查询奖品信息
     *
     * @return
     */
//    @AdminLog
//    @AuthPower
    @GetMapping("/findLuckyTurntableWinningPrize")
    @ApiOperation(value = "查询奖品信息")
    public Result<Object> findLuckyTurntableWinningPrize(@ApiParam(value = "第几页") @RequestParam Integer pagerNo,
                                                         @ApiParam(value = "每页几条") @RequestParam Integer pageSize) {

        return luckyTurntableService.findPrizeLuckyTurntable(pagerNo, pageSize);
    }

    /**
     * 查询奖品信息
     *
     * @return
     */
//    @AdminLog
//    @AuthPower
    @GetMapping("/findPrizeLuckyById")
    @ApiOperation(value = "查询单个奖品信息")

    public Result<Object> findPrizeLuckyById(@ApiParam(value = "奖品id") @RequestParam Long prizeId) {
        return luckyTurntableService.findPrizeLuckyById(prizeId);
    }

    /**
     * 查询所有用户中奖信息
     *
     * @return
     */
//    @AdminLog
//    @AuthPower
    @ApiOperation(value = "查询所有用户中奖信息", notes = "因为是从福利记录表中查询,经过去重所以返回数可能不对")
    @GetMapping("/findUserWinning")
    public Result<Object> findUserWinning(String id, @ApiParam(value = "每页几条") @RequestParam Integer pageSize) {
        return luckyTurntableService.findUserWinningThPrize(null, null, null, id, pageSize);

    }

    /**
     * 根据查询条件查询用户中奖信息
     *
     * @return
     */
//    @AdminLog
//    @AuthPower
    @ApiOperation(value = "查询用户中奖信息")
    @GetMapping("/findUserWinningThePrize")
    public Result<Object> findUserWinningThePrize(@ApiParam(value = "用户uniId") @RequestParam Long userUniId,
                                                  @ApiParam(value = "开始时间") @RequestParam(required = false) Long statTime,
                                                  @ApiParam(value = "结束时间") @RequestParam(required = false) Long endTime, String id,
                                                  @ApiParam(value = "每页几条") @RequestParam Integer pagerSize) {

        return luckyTurntableService.findUserWinningThPrize(userUniId, statTime, endTime, id, pagerSize);

    }


}
