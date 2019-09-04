package com.hndl.cn.mghd.sys.business.task.service;

/**
 * @author 赵俊凯
 * @Description 师傅奖励相关
 * @Date 2019/5/7 16:43
 * @Created by 湖南达联
 */
public interface MasterDayRewardService {


    /**
     * 异步添加需要奖励的师傅记录，注意此任务是异步的
     * @param userUniId
     * @param masterId
     */
    void asyncInsertMasterDayReward(Long userUniId,Long masterId);



}
