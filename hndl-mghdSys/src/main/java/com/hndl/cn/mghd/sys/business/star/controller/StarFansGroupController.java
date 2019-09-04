package com.hndl.cn.mghd.sys.business.star.controller;


import com.hndl.cn.base.annotation.auth.AuthPassport;
import com.hndl.cn.base.annotation.auth.CurrentUser;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupRelationService;
import com.hndl.cn.mghd.sys.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupStatisticsVo;
import com.hndl.cn.mghd.sys.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.sys.business.star.vo.UserInfoVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @program: hndl-platform
 * @description: 粉丝会详细
 * @author: 易成贤
 * @create: 2019-04-23 16:09
 * @Created by 湖南达联
 **/
@Api(tags = "粉丝会")
@RestController
@RequestMapping(path = "/{source}/star")
public class StarFansGroupController {

    @Resource
    StarFansGroupService starFansGroupService;


    @Resource
    StarFansGroupRelationService starFansGroupRelationService;


    /**
     * 查看单个粉丝会详细信息  //前端
     *
     * @param starId
     * @return
     */
    @CrossOrigin
    @ApiOperation(value = "查询粉丝会基本信息",notes = "exp:用户点击粉丝会查看到的数据")
    @AuthPassport(validate = false)
    @GetMapping(path = "/findStarFansGroup")
    public Result<StarFansGroupVo> findStarFansGroup(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
            @ApiParam(value = "明星id",required = true) @RequestParam Long starId) {
        //返回粉丝会详细数据
        return ResultFactory.success(starFansGroupService.findStarFansGroupDetail(commonUserInfoDo,starId));
    }


    /**
     * 查询用户关注的粉丝会详细信息列表
     *
     * @param commonUserInfoDo
     * @return
     */
    @ApiOperation(value = "获取用户关注的粉丝会", notes = "返回用户关注的粉丝会列表<br/>返回的数据不应该多余8条")
    @AuthPassport
    @GetMapping(path = "/findListStarFansGroup")
    public Result<List<StarFansGroupVo>> findListStarFansGroup(@CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo) {
        List<StarFansGroupVo> starFansGroupVos = starFansGroupService.findListStarFansGroup(commonUserInfoDo.getSysUniId());
        return ResultFactory.success(starFansGroupVos);
    }

    /**
     * 新增StarFansGroupRelation
     * exp:一个用户加入到粉丝会
     * @param commonUserInfoDo
     * @param starId
     */
    @ApiOperation(value = "加入粉丝会" ,notes = "用户必须登陆<br/>exp:用户点击关注(加入)粉丝会")
    @GetMapping(path = "/addStarFansGroup")
    @AuthPassport
    public Result<StarFansGroupVo> addStarFansGroup(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,
                                           @ApiParam(value = "粉丝会id",required = true) @RequestParam Long starId){
        //新增执行
        StarFansGroupVo starFansGroupVo = starFansGroupRelationService.addStarFansGroupRelation(commonUserInfoDo.getSysUniId(), starId);
        return ResultFactory.success(starFansGroupVo);
    }
    /**
     * 新增StarFansGroupRelation
     * exp:一个用户加入到多个粉丝会
     * @param commonUserInfoDo
     * @param starIds
     */
    @ApiOperation(value = "批量加入粉丝会" ,notes = "如果传入粉丝会>")
    @PostMapping(path = "/batchAddStarFansGroup")
    @AuthPassport
    public Result<List<StarFansGroupVo>> batchAddStarFansGroup(@PathVariable String source, @CurrentUser @ApiIgnore CommonUserInfoDo commonUserInfoDo,@RequestParam List<Long> starIds){
        //新增执行
        return starFansGroupRelationService.batchAddStarFansGroup(commonUserInfoDo.getSysUniId(), starIds);
    }


    /**
     * 用户退出粉丝会
     * @param commonUserInfoDo
     * @param starId
     * @return
     */
    @ApiOperation(value = "退出粉丝会",notes = "用户必须登陆<br/>exp:用户点击退出粉丝会")
    @GetMapping(path = "/exitFansGroup")
    @AuthPassport
    public  Result<Object> exitFansGroup(@PathVariable String source ,@ApiIgnore@CurrentUser CommonUserInfoDo commonUserInfoDo ,
                                         @ApiParam(value = "粉丝会id" ,required = true) @RequestParam Long starId){
        //
        starFansGroupRelationService.exitFansGroup(starId,commonUserInfoDo.getSysUniId());
        //更新成功
        return ResultFactory.success();
    }

    /**
     * 查询粉丝会相关统计数据
     * @param source
     * @param commonUserInfoDo
     * @param starId
     * @return
     */
    @ApiOperation(value = "查询用户与粉丝会统计的信息",notes = "用户必须登陆<br/>exp:包含贡献值，投票数，累计打榜天数")
    @GetMapping(path = "/findStarFansStatistics")
    @AuthPassport
    public  Result<StarFansGroupStatisticsVo> findStarFansStatistics(@PathVariable String source , @ApiIgnore@CurrentUser CommonUserInfoDo commonUserInfoDo ,
                                                                     @ApiParam(value = "粉丝会id",required = true) @RequestParam Long starId){
        StarFansGroupStatisticsVo statistics = starFansGroupRelationService.findStarFansStatistics(commonUserInfoDo.getSysUniId(), starId);
        return ResultFactory.success(statistics);
    }

    @ApiOperation(value = "粉丝大咖和守护大师/超级星粉数据")
    @GetMapping(path = "/findGuard")
    @AuthPassport
    public Result<Map<String, List<UserInfoVo>>> findGroup(@PathVariable String source ,
                                                           @ApiParam(value = "粉丝会id",required = true) @RequestParam Long starId){
        Map<String, List<UserInfoVo>> goupMan = starFansGroupRelationService.findGuard(starId);
        return ResultFactory.success(goupMan);
    }
    @ApiOperation(value = "查询推荐粉丝会")
    @GetMapping(path = "/findRecommendStar")
    @AuthPassport
    public Result<List<StarFansGroupVo>> findRecommendStar( @ApiIgnore@CurrentUser CommonUserInfoDo commonUserInfoDo){

        List<StarFansGroupVo> starFansGroupVos = starFansGroupService.findRecommendStar(commonUserInfoDo);
        return ResultFactory.success(starFansGroupVos);
    }
}
