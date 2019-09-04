package com.hndl.cn.dao.fans.mapper;

import com.hndl.cn.dao.fans.bean.FansRankRecordDo;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FansRankRecordDoMapper {
    int deleteByPrimaryKey(Long id);

    int insert(FansRankRecordDo record);

    int insertSelective(FansRankRecordDo record);

    FansRankRecordDo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(FansRankRecordDo record);

    int updateByPrimaryKey(FansRankRecordDo record);

    List<FansRankRecordDo> queryDayRankByDate(String date);

    List<FansRankRecordDo> queryWeekRankByDate(String date);

    List<FansRankRecordDo> queryWeekRankByDateAll(String date);

    List<FansRankRecordDo> queryMonthRankByDate(String date);

    List<FansRankRecordDo> queryMonthRankByDateAll(String date);
}