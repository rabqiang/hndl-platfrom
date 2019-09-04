package com.hndl.cn.mysql.manager.system.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.system.bean.SystemJobInfoDo;

/**
 * @author 赵俊凯
 * @Description 自动任务Manager
 * @Date 2019/4/26 11:53
 * @Created by 湖南达联
 */
public interface SystemJobInfoManager {


    /**
     *  jobName 查询job配置
     * @param jobName
     * @return
     */
    SystemJobInfoDo findByJobName(String jobName);


    /**
     * 修改任务执行状态
     * @param jobStatus
     * @return
     */
    boolean updateJobStatus(String jobName,String jobStatus);


    /**
     * 新增任务
     * @param systemJobInfoDo
     * @return
     */
    boolean insertSystemJob(SystemJobInfoDo systemJobInfoDo);


    /**
     *  删除任务或执开启执行
     * @param jobName
     * @return
     */
    boolean deleteSystemJob(String jobName,IsValidEnums  isValidEnums);
}
