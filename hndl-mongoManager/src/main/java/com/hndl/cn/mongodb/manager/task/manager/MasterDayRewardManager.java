package com.hndl.cn.mongodb.manager.task.manager;

import com.hndl.cn.mongodb.manager.task.bean.MasterDayReward;

import java.time.LocalDate;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description 达到每日分红的师傅列表
 * @Date 2019/5/7 16:22
 * @Created by 湖南达联
 */
public interface MasterDayRewardManager {

    void userDelete();

    /**
     * 添加师傅列表
     * 因为时间需要有调用方控制
     * @param masterDayReward
     */
    void insert(MasterDayReward masterDayReward);


    /**
     * 判断今天是否以及加入
     * @param masterId
     * @param slaveId
     * @return
     */
    boolean isExist(Long masterId,Long slaveId);


    /**
     * 查询某一天的能获得奖励的集合
     * @return
     */
    List<MasterDayReward> findByDate(LocalDate localDate,String id,Integer limit);


    /**
     * 师父id查询可以奖励徒弟id
     * @param masterId
     * @return
     */
    List<MasterDayReward> findDaySlaveIdByMasterId(LocalDate localDate,Long masterId);

    /**
     * 查询用户的徒弟信息
     * @param masterId
     * @return
     */
    List<MasterDayReward> findSlaveIdByMasterId(Long masterId);
}
