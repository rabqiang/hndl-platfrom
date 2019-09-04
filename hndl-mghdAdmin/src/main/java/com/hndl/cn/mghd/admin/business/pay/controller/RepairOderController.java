package com.hndl.cn.mghd.admin.business.pay.controller;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.pay.service.RepairOderService;
import com.hndl.cn.mghd.admin.business.pay.vo.ReplacementOderVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @program:hndl-platform
 * @description:TODO 补单
 * @author: 易成贤
 * @create: 2019/8/5 21:27
 * @Created by湖南达联
 **/
@Api(tags = "补单")
@RequestMapping("/replacementOder")
@RestController
public class RepairOderController {

    @Resource
    RepairOderService repairOderService;

    /**
     * 苹果补单
     * @return
     */
    @ApiOperation(value = "苹果补单")
    @AdminLog
    @AuthPower
    @PostMapping("/AppleRepairOder")
    Result AppleReplacementOder(@Valid @RequestBody ReplacementOderVo replacementOderVo){
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
      return   repairOderService.appleRepairOder(loginUser.getId(),replacementOderVo.getUserUniId(),replacementOderVo.getLocalOrder(),replacementOderVo.getIsEnforcement(),replacementOderVo.getRemark());
    }

}
