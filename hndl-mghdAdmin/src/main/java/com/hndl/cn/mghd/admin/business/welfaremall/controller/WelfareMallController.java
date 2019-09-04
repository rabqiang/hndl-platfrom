package com.hndl.cn.mghd.admin.business.welfaremall.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.welfaremall.service.WelfareMallService;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.CommodityVo;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.HelpCommodityVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 曹加丽
 * @Description 后台  限时抢福利 后台管理
 * @Date 2019/7/5 19:57
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/WelfareMall")
@Api(value = "/WelfareMall",tags = "限时抢福利")
public class WelfareMallController {
    @Resource
    WelfareMallService welfareMallService;

    @AdminLog
    @AuthPower
    @PostMapping("/welfareMallAddCommodity")
    @ApiOperation(value = "增加奖品信息", notes = "需要填写奖品基本信息")
    public Result<Object> welfareMallAddCommodity(@ApiParam(value = "奖品数据对象")
                                                  @RequestBody @Valid CommodityVo commodityVo) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return welfareMallService.welfareMallAddCommodity(commodityVo, loginUser.getId());
    }

    @AdminLog
    @AuthPower
    @PostMapping("/welfareMallUpdateCommodity")
    @ApiOperation(value = "修改奖品信息", notes = "只能设置前多少名(不能为负数,最小为0)才可以获得奖励,\n\r以及设置默认中奖人id(id为UserUniId) ")
    public Result<Object> welfareMallUpdateCommodity(@ApiParam(value = "奖品数据对象") @RequestBody @Valid HelpCommodityVo helpCommodityVo) {
        return welfareMallService.welfareMallUpdateCommodity(helpCommodityVo);
    }

    @AdminLog
    @AuthPower
    @GetMapping("/findWelfareMallById")
    @ApiOperation(value = "根据福利商品名和是否已经开奖查询奖品信息", notes = "福利商品名和是否已经开奖可不传")
    public Result<Object> findWelfareMall(@ApiParam(value = "上一页的最后一条记录的id, 根据此字段分页") @RequestParam(required = false) String id,
                                          @ApiParam(value = "奖品名称") @RequestParam(required = false) String prizeName,
                                          @ApiParam(value = "是否已开奖?(0.否 , 1.是, 2.开奖失败)") @RequestParam(required = false) Integer isSuccess,
                                          @ApiParam(value = "分页数") @RequestParam Integer pageSize) {
        return welfareMallService.findWelfareMall(id, prizeName, isSuccess, pageSize);
    }

    @AdminLog
    @AuthPower
    @GetMapping("/updateUserAddress")
    @ApiOperation(value = "修改用户发货状态")
    public Result<Object> updateUserAddress(@ApiParam(value = "奖品期号") @RequestParam String welfareNumber,
                                            @ApiParam(value = "中奖用户uniId") @RequestParam Long userUniId,
                                            @ApiParam(value = "快递单号") @RequestParam Long receivingNumber) {
        return welfareMallService.updateUserAddress(welfareNumber, userUniId, receivingNumber);
    }

    @AdminLog
    @AuthPower
    @GetMapping("/findPrizeUserAddressAll")
    @ApiOperation(value = "查询中奖用户的收货信息", notes = "期号不传,就查询所有的收货信息")
    public Result<Object> updateUserAddress(@ApiParam(value = "上一页的最后一条记录的id, 根据此字段分页") @RequestParam(required = false) String id,
                                            @ApiParam(value = "奖品期号") @RequestParam(required = false) String welfareNumber,
                                            @ApiParam(value = "是否发货(0.已中奖  1.未发货, 2,已发货)") @RequestParam(required = false) Integer isDelivery,
                                            @ApiParam(value = "每页分几条") @RequestParam Integer pageSize) {
        return welfareMallService.findPrizeUserAddressAll(id, welfareNumber, isDelivery, pageSize);
    }
}
