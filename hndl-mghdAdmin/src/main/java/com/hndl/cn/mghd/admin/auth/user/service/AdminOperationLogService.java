package com.hndl.cn.mghd.admin.auth.user.service;

import com.hndl.cn.base.result.Result;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/7/5 19:55
 * @Created by 湖南达联
 */
public interface AdminOperationLogService {


    /**
     * 查询后台操作日志
     * @return
     */
    Result<Object> findLogByPage(Long startTime,Long endTime,Long adminUserId,String id);
}
