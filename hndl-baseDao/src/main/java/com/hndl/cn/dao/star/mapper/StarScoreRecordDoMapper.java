package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarScoreRecordDo;
import com.hndl.cn.dao.star.bean.StarScoreRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarScoreRecordDoMapper {
    long countByExample(StarScoreRecordDoExample example);

    int deleteByExample(StarScoreRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarScoreRecordDo record);

    int insertSelective(StarScoreRecordDo record);

    List<StarScoreRecordDo> selectByExample(StarScoreRecordDoExample example);

    StarScoreRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarScoreRecordDo record, @Param("example") StarScoreRecordDoExample example);

    int updateByExample(@Param("record") StarScoreRecordDo record, @Param("example") StarScoreRecordDoExample example);

    int updateByPrimaryKeySelective(StarScoreRecordDo record);

    int updateByPrimaryKey(StarScoreRecordDo record);
}