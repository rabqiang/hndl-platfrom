package com.hndl.cn.mghd.admin.business.message.controller;


import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.message.service.AdminMessageInfoService;
import com.hndl.cn.mghd.admin.business.message.vo.AdminMessageVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月26日19:45:30
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/adminMessage")
@Api(value = "/adminMessage", tags = "admin-message-controller")
public class AdminMessageInfoController {

    @Resource
    private AdminMessageInfoService adminMessageInfoService;


    @ApiOperation(value="管理后台删除消息", notes="删除消息")
    @AdminLog
    @AuthPower
    @GetMapping("/removeAdminMessage")
    public Result<Object> removeAdminMessage(@RequestParam Long messageId) {
        adminMessageInfoService.removeMessage(messageId);
        return ResultFactory.success();
    }

    @ApiOperation(value="管理后台修改消息", notes="修改消息")
    @AdminLog
    @AuthPower
    @PostMapping("/updateAdminMessage")
    public Result<Object> updateAdminMessage(@RequestBody @Valid AdminMessageVo adminMessageVo) {
        adminMessageInfoService.updateMessage(adminMessageVo);
        return ResultFactory.success();
    }

    @ApiOperation(value="管理后台查询消息", notes="查询消息")
    @AdminLog
    @AuthPower
    @GetMapping("/findByAdminMessage")
    public Result<Object> findByAdminMessage( AdminMessageVo adminMessageVo, Long id ) {

        return ResultFactory.success(adminMessageInfoService.findByMessage(adminMessageVo, id));
    }


}
