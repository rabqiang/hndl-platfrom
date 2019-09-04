package com.hndl.cn.mghd.admin.auth.user.service.impl;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.admin.auth.user.service.AdminOperationLogService;
import com.hndl.cn.mongodb.manager.admin.manager.AdminRequestLogManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/7/5 19:57
 * @Created by 湖南达联
 */
@Service
public class AdminOperationLogServiceImpl implements AdminOperationLogService {

    @Resource
    private AdminRequestLogManager adminRequestLogManager;

    @Override
    public Result<Object> findLogByPage(Long startTime, Long endTime, Long adminUserId, String id) {
        if(startTime == null && endTime != null){
            startTime = 0L;
        }
        if(startTime != null && endTime == null){
            endTime = new Date().getTime();
        }
        return ResultFactory.success(adminRequestLogManager.findAdminLogByPage(startTime, endTime, adminUserId, id));
    }
}
