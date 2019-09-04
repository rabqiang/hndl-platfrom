package com.hndl.cn.mongodb.manager.luckdraw.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.base.enums.welfare.WelfareTypeEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.FoucaultLogDo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 福卡日志操作
 * @author: 易成贤
 * @create: 2019/7/22 17:20
 * @Created by湖南达联
 **/
public interface FoucaultLogManager {
    /**
     * 插入一条福卡记录
     * @param userUniId
     * @param taskType
     * @param isIncome
     * @param foucaultCount
     */
    void insertFoucaultLog(Long userUniId, FoucaultGetTypeEnums taskType, IsValidEnums isIncome,Integer foucaultCount);


    /**
     * 用于限时抢福利的福卡记录
     * @param userUniId
     * @param taskType
     * @param isIncome
     * @param foucaultCount
     */
    void insertFoucaultLogs(Long userUniId, FoucaultGetTypeEnums taskType, IsValidEnums isIncome, Integer foucaultCount);

    /**
     * 获取今天的记录次数
     * @param userUniId
     * @param taskType
     * @param isIncome
     * @return
     */
    Integer findToDayCount(Long userUniId,FoucaultGetTypeEnums taskType,IsValidEnums isIncome);

    /**
     * 查询用户今天获取福卡的记录
     * @param userUniId
     * @return
     */
    List<FoucaultLogDo> findToDayFoucaultLog(@NotNull Long userUniId);

    /**
     *  根据时间查询用户获取的多少抽取福卡次数
     * @param userUniId  用户UniId
     * @param id          _id
     * @param starTime   开始时间
     * @param endTime   结束时间
     * @param isIncome  是支出吗? 支出1 \收入0
     * @return
     */
    List<FoucaultLogDo> findToDateGetCount(Long userUniId,String id ,Long starTime,Long endTime,IsValidEnums isIncome,Integer limit);

    /**
     * 根据时间倒序分页查询用户的福卡增加/删除记录
     * @param userUniId 用户唯一ID
     * @param isIncome 1为增加记录, 0为消费记录
     * @param id 分页标识
     * @param limit 分页数
     * @return
     */
    List<FoucaultLogDo> findFoucaultLogByUserId(Long userUniId, Integer isIncome, String id, Integer limit);

}
