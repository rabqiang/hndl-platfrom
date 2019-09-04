package com.hndl.cn.mghd.admin.business.star.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.admin.business.star.vo.ReceiveStarFansGroupVo;
import com.hndl.cn.mghd.admin.business.star.vo.StarFansGroupVo;
import com.hndl.cn.mghd.admin.business.star.vo.UpdateStarFansGroupVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.mghd.admin.common.vo.PageVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @program:hndl-platform
 * @description:TODO 粉丝会管理
 * @author: 易成贤
 * @create: 2019/7/3 17:10
 * @Created by湖南达联
 **/
@Api(tags = "粉丝会管理")
@RequestMapping("/star")
@RestController
public class StarFansGroupController {

    @Resource
    StarFansGroupService starFansGroupService;

    /**
     * 查询粉丝会
     *
     * @param objId
     * @param parameters
     * @return
     */
    @ApiOperation(value = "查询粉丝会")
    @GetMapping("/findstarFansGroup")
    @AdminLog
    @AuthPower
    public Result<PageVo<StarFansGroupVo>> findstarFansGroup(String objId, String parameters,Integer isDelete) {
        PageVo<StarFansGroupVo> starFansGroup = starFansGroupService.findStarFansGroup(objId, parameters,isDelete);
        return ResultFactory.success(starFansGroup);
    }

    @ApiOperation(value = "删除粉丝会")
    @GetMapping("/deleteStarFansGroup")
    @AdminLog
    @AuthPower
    public Result deleteStarFansGroup(@RequestParam Long starId) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return starFansGroupService.deleteStarFansGroup(loginUser, starId);

    }

    @ApiOperation(value = "加入推荐")
    @GetMapping("/addRecommendation")
    @AdminLog
    @AuthPower
    public Result addRecommendation(@RequestParam Long starId) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return starFansGroupService.addRecommendation(loginUser, starId);
    }

    @ApiOperation("更新粉丝会")
    @AdminLog
    @AuthPower
    @PostMapping("/updateStarFansGroup")
    public Result updateStarFansGroup(@RequestBody @Valid UpdateStarFansGroupVo updateStarFansGroupVo){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        return starFansGroupService.upsertStarFansGroup(loginUser,updateStarFansGroupVo);
    }

    @ApiOperation("插入粉丝会")
    @AdminLog
    @AuthPower
    @PostMapping("/insertStarFansGroup")
    public Result insertStarFansGroup(@RequestBody @Valid ReceiveStarFansGroupVo receiveStarFansGroupVo){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
      return   starFansGroupService.insertStarFansGroup(loginUser,receiveStarFansGroupVo);
    }
}
