package com.hndl.cn.mghd.admin.business.banner.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.banner.service.BannerService;
import com.hndl.cn.mghd.admin.business.banner.vo.BannerVo;
import com.hndl.cn.mghd.admin.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.*;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/6/24 22 09
 * @Description:
 * @Author: 资龙茂
 */
@RestController
@RequestMapping("/banner")
@Api(value = "后台 banner")
public class BannerController {

    @Resource
    private BannerService bannerService;

    @PostMapping("/addBanner")
    @AuthPower
    @AdminLog
    @ApiOperation(value="管理后台添加banner", notes="新增banner")
    public Result<Object> addBanner(@ApiParam(value = "banner数据对象") @RequestBody @Valid BannerVo bannerVo) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return bannerService.addBanner(loginUser, bannerVo);
    }

    @DeleteMapping("/deleteBanner")
    @AuthPower
    @AdminLog
    @ApiOperation(value="管理后台删除banner", notes="删除banner")
    public Result<Object> deleteBanner(@ApiParam(value = "banner对应ID") @RequestParam(required = true) Long id) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return bannerService.deleteBanner(loginUser, id);
    }

    @ApiOperation(value="管理后台修改banner", notes="修改banner")
    @AuthPower
    @AdminLog
    @PutMapping("/updateBanner")
    public Result<Object> updateBanner(@ApiParam(value = "banner数据对象") @RequestBody @Valid BannerVo bannerVo) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return bannerService.updateBanner(loginUser, bannerVo);
    }

    @AuthPower
    @AdminLog
    @GetMapping("/findBannerInfo")
    @ApiOperation(value="管理后台获取banner列表", notes="查询banner列表")
    public Result<Object> findBannerInfoByLimit(
             String model,
             Integer pageNo,
             Integer order,
             Long showTime) {
        Map<String, Object> resultMap = new HashMap<>();
        List<BannerVo> bannerVoList;
        // 如果传入了时间戳, 则是预览轮播图, 不需要分页, 否则需要分页
        if (showTime == null) {
            bannerVoList = bannerService.findBannerInfo(model, pageNo, order);
        } else {
            bannerVoList = bannerService.findBannerInfoByTime(model, showTime);
        }
        resultMap.put("bannerList", bannerVoList);
        return ResultFactory.success(resultMap);
    }

    @AuthPower
    @AdminLog
    @GetMapping("/findBannerSingle")
    @ApiOperation(value="管理后台查询单条banner", notes="查询单条banner")
    public Result<Object> findBannerSingle(@ApiParam(value = "bannerID") @RequestParam(required = true) Long id){
        return bannerService.findBannerInfoSingle(id);
    }

    @AuthPower
    @AdminLog
    @GetMapping("/refreshAllBanner")
    @ApiOperation(value="管理后台刷新所有banner缓存", notes="刷新所有banner缓存")
    public Result<Object> refreshAllBanner() {
        return bannerService.refreshAllBanner();
    }

}