package com.hndl.cn.mghd.admin.auth.user.controller;

import com.hndl.cn.base.result.Result;
 import com.hndl.cn.mghd.admin.auth.user.service.AdminOperationLogService;
import com.hndl.cn.mghd.admin.common.annotation.AdminLog;
import com.hndl.cn.mghd.admin.common.annotation.AuthPower;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/7/5 19:55
 * @Created by 湖南达联
 */
@RestController
@RequestMapping("/admin/log")
public class AdminOperationLogController {

    @Resource
    private AdminOperationLogService adminOperationLogService;


    @GetMapping("/findLogByPage")
    @AuthPower
    @AdminLog
    public Result<Object> findLogByPage(Long startTime,Long endTime,Long adminUserId,String id){
        return adminOperationLogService.findLogByPage(startTime, endTime, adminUserId, id);
    }
}
