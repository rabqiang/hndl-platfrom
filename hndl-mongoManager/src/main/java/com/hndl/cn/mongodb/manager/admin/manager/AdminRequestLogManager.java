package com.hndl.cn.mongodb.manager.admin.manager;

import com.hndl.cn.mongodb.manager.admin.bean.AdminRequestLog;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 20:54
 * @Created by 湖南达联
 */
public interface AdminRequestLogManager {


    /**
     * 添加日志
     * @param log
     */
    void addLog(AdminRequestLog log);


    /**
     * 查询后台日志
     * @return
     */
    List<AdminRequestLog> findAdminLogByPage(Long startTime,Long endTime,Long adminUserId,String id);
}
