package com.hndl.cn.mghd.sys.business.rank.service;

import com.hndl.cn.base.result.Result;

import java.time.LocalDate;

/**
 * @author 赵俊凯
 * @Description 明星排行榜
 * @Date 2019/4/28 11:44
 * @Created by 湖南达联
 */
public interface StarRankService {


    Result<Object> initRunTimeDayStarRank(Long userUniId);


    /**
     * 查询日版实时数据
     * @return
     */
    Result<Object> findRunTimeDayStarRank(Integer pageNo,Integer pageSize);


    /**
     * 查询历史日版数据
     * @param localDate
     * @return
     */
    Result<Object> findHistoryDayStarRank(LocalDate localDate);


    /**
     * 查询周版实时数据
     * @return
     */
    Result<Object> findRunTimeWeekStarRank(Integer pageNo,Integer pageSize);


    /**
     * 查询周榜历史数据
     * @param localDate
     * @return
     */
    Result<Object> findHistoryWeekStarRank(LocalDate localDate);


    /**
     * 查询月榜实时数据
     * @return
     */
    Result<Object> findRunTimeMonthStarRank(Integer pageNo,Integer pageSize);


    /**
     * 查询月榜历史数据
     * @param localDate
     * @return
     */
    Result<Object> findHistoryMonthStarRank(LocalDate localDate);
}
