package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarGuardRecordDo;
import com.hndl.cn.dao.star.bean.StarGuardRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarGuardRecordDoMapper {
    long countByExample(StarGuardRecordDoExample example);

    int deleteByExample(StarGuardRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarGuardRecordDo record);

    int insertSelective(StarGuardRecordDo record);

    List<StarGuardRecordDo> selectByExample(StarGuardRecordDoExample example);

    StarGuardRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarGuardRecordDo record, @Param("example") StarGuardRecordDoExample example);

    int updateByExample(@Param("record") StarGuardRecordDo record, @Param("example") StarGuardRecordDoExample example);

    int updateByPrimaryKeySelective(StarGuardRecordDo record);

    int updateByPrimaryKey(StarGuardRecordDo record);
}