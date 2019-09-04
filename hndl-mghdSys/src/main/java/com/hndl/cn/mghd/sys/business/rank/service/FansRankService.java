package com.hndl.cn.mghd.sys.business.rank.service;

import com.hndl.cn.base.result.Result;

import java.time.LocalDate;

/**
 * @author 赵俊凯
 * @Description 星粉榜service
 * @Date 2019/5/6 10:25
 * @Created by 湖南达联
 */
public interface FansRankService {


    /**
     * 查询日榜实时数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<Object> findRunTimeDayFansRank(Long userUniId,Integer pageNo,Integer pageSize);


    /**
     * 查询周榜实时数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<Object> findRunTimeWeekFansRank(Long userUniId,Integer pageNo,Integer pageSize);


    /**
     * 查询月榜实时数据
     * @param pageNo
     * @param pageSize
     * @return
     */
    Result<Object> findRunTimeMonthFansRank(Long userUniId,Integer pageNo,Integer pageSize);



    /**
     * 查询历史日版数据
     * @param localDate
     * @return
     */
    Result<Object> findHistoryDayFansRank(Long userUniId,LocalDate localDate);


    /**
     * 查询历史周版数据
     * @param localDate
     * @return
     */
    Result<Object> findHistoryWeekFansRank(Long userUniId,LocalDate localDate);


    /**
     * 查询历史月版数据
     * @param localDate
     * @return
     */
    Result<Object> findHistoryMonthFansRank(Long userUniId,LocalDate localDate);



}
