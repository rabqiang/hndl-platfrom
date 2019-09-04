package com.hndl.cn.mghd.admin.business.message.controller;


import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.business.message.service.AdminMessageInfoService;
import com.hndl.cn.mghd.admin.business.message.vo.AdminMessageVo;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.Valid;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月26日19:45:30
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/AdminAddMessageController")
@Api(value = "/AdminAddMessageController", tags = "admin-message-controller")
public class AdminAddMessageController {

    @Resource
    private AdminMessageInfoService adminMessageInfoService;

    @ApiOperation(value="管理后台添加消息", notes="新增消息")
    @AdminLog
    @AuthPower
    @PostMapping("/saveAdminMessage")
    public Result<Object> saveAdminMessage(@RequestBody @Valid AdminMessageVo adminMessageVo) {
        adminMessageInfoService.saveMessage(adminMessageVo);
        return ResultFactory.success();
    }
}
