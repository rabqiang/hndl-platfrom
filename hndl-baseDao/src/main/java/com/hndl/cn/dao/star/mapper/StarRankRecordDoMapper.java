package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarRankRecordDo;
import com.hndl.cn.dao.star.bean.StarRankRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarRankRecordDoMapper {
    long countByExample(StarRankRecordDoExample example);

    int deleteByExample(StarRankRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarRankRecordDo record);

    int insertSelective(StarRankRecordDo record);

    List<StarRankRecordDo> selectByExample(StarRankRecordDoExample example);

    StarRankRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarRankRecordDo record, @Param("example") StarRankRecordDoExample example);

    int updateByExample(@Param("record") StarRankRecordDo record, @Param("example") StarRankRecordDoExample example);

    int updateByPrimaryKeySelective(StarRankRecordDo record);

    int updateByPrimaryKey(StarRankRecordDo record);

    List<StarRankRecordDo> queryDayRankByDate(String date);

    List<StarRankRecordDo> queryWeekRankByDate(String date);

    List<StarRankRecordDo> queryWeekRankByDateAll(String date);

    List<StarRankRecordDo> queryMonthRankByDate(String date);

    List<StarRankRecordDo> queryMonthRankByDateAll(String date);

}