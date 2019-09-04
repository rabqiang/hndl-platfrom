package com.hndl.cn.shop.sys.business.welfare.controller;

import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.shop.sys.business.welfare.service.WelfarePrizeService;
import com.hndl.cn.shop.sys.business.welfare.vo.SubmitAddressVo;
import com.hndl.cn.utils.string.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @Classname 福利商品控制器
 * @Created by 湖南达联
 * @Date 2019/8/1 10 50
 * @Description:
 * @Author: 资龙茂
 */
@RestController
@RequestMapping("/welfarePrize")
@Api(tags = "welfarePrize")
public class WelfarePrizeController {

    @Resource
    private WelfarePrizeService welfarePrizeService;

    @GetMapping("/findWelfarePrizeInfo")
    @ApiOperation(value="分页查询福利奖品列表", notes="分页查询福利奖品列表")
    public Result<Object> findWelfarePrizeInfo(@ApiParam(value = "页末对象id") String id) {
        if (StringUtils.isNotEmpty(id)) {
            return welfarePrizeService.findWelfarePrizeInfoByPage(id);
        }
        return welfarePrizeService.findWelfarePrizeInfo();
    }

    @GetMapping("/findMyWelfarePrizeSingle")
    @AuthPassport
    @ApiOperation(value="查询单个福利奖品(自己看自己)", notes="查询单个福利奖品(自己看自己)")
    public Result<Object> findMyWelfarePrizeSingle(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                                   @ApiParam(value = "福利奖品期号") @RequestParam String welfareNumber) {
        return welfarePrizeService.findMyWelfarePrizeSingle(commonUserInfoDo, welfareNumber);
    }

    @GetMapping("/findMyWelfarePrizeSingleTourist")
    @ApiOperation(value="查询单个福利奖品(自己看自己,不登录)", notes="查询单个福利奖品(自己看自己,不登录)")
    public Result<Object> findMyWelfarePrizeSingle(@ApiParam(value = "福利奖品期号") @RequestParam String welfareNumber) {
        return welfarePrizeService.findMyWelfarePrizeSingle(null, welfareNumber);
    }

    @GetMapping("/findFriendWelfarePrizeSingle")
    @AuthPassport
    @ApiOperation(value="查询单个福利奖品(自己看别人)", notes="查询单个福利奖品(自己看别人)")
    public Result<Object> findFriendWelfarePrizeSingle(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                                       @ApiParam(value = "抢福利操作ID") @RequestParam String userWelfareId) {
        return welfarePrizeService.findFriendWelfarePrizeSingle(commonUserInfoDo, userWelfareId);
    }

    @GetMapping("/findFriendWelfarePrizeSingleTourist")
    @ApiOperation(value="查询单个福利奖品(自己看别人,不登录)", notes="查询单个福利奖品(自己看别人,不登录)")
    public Result<Object> findFriendWelfarePrizeSingle(@ApiParam(value = "抢福利操作ID") @RequestParam String userWelfareId) {
        return welfarePrizeService.findFriendWelfarePrizeSingle(null, userWelfareId);
    }

    @GetMapping("/findSuccessPrizeInfo")
    @ApiOperation(value="查询已开奖时长不超过三天的奖品列表", notes="查询已开奖时长不超过三天的奖品列表")
    public Result<Object> findSuccessPrizeInfo() {
        return welfarePrizeService.findSuccessPrizeInfo();
    }

    @GetMapping("/findMyPrizeInfo")
    @AuthPassport
    @ApiOperation(value="查询自己的中奖记录列表", notes="查询自己的中奖记录列表")
    public Result<Object> findMyPrizeInfo(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                          @ApiParam(value = "页末对象id") String id) {
        return welfarePrizeService.findMyPrizeInfo(commonUserInfoDo, id);
    }

    @GetMapping("/findIsJoinUserInfo")
    @AuthPassport
    @ApiOperation(value="根据期号按照最后修改时间倒序查询参与抢福利的十个用户", notes="根据期号按照最后修改时间倒序查询参与抢福利的十个用户")
    public Result<Object> findIsJoinUserInfo(@ApiParam(value = "期号") @RequestParam String welfareNumber) {
        return welfarePrizeService.findIsJoinUserInfo(welfareNumber);
    }

    @GetMapping("/findLuckyUserInfo")
    @AuthPassport
    @ApiOperation(value="根据期号查询中奖用户", notes="根据期号查询中奖用户")
    public Result<Object> findLuckyUserInfo(@ApiParam(value = "期号") @RequestParam String welfareNumber) {
        return welfarePrizeService.findLuckyUserInfo(welfareNumber);
    }

    @PostMapping("/submitAddress")
    @AuthPassport
    @ApiOperation(value="中奖用户提交收货地址", notes="中奖用户提交收货地址")
    public Result<Object> submitAddress(@CurrentUser @ApiIgnore(value = "当前登录用户") CommonUserInfoDo commonUserInfoDo,
                                        @RequestBody @Valid SubmitAddressVo submitAddressVo) {
        return welfarePrizeService.submitAddress(commonUserInfoDo, submitAddressVo.getWelfareNumber(), submitAddressVo.getPhoneNumber(), submitAddressVo.getReceivingName(), submitAddressVo.getReceivingAddress(), submitAddressVo.getReason());
    }

}
