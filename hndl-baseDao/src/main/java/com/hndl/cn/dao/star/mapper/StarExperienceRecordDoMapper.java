package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarExperienceRecordDo;
import com.hndl.cn.dao.star.bean.StarExperienceRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarExperienceRecordDoMapper {
    long countByExample(StarExperienceRecordDoExample example);

    int deleteByExample(StarExperienceRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarExperienceRecordDo record);

    int insertSelective(StarExperienceRecordDo record);

    List<StarExperienceRecordDo> selectByExample(StarExperienceRecordDoExample example);

    StarExperienceRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarExperienceRecordDo record, @Param("example") StarExperienceRecordDoExample example);

    int updateByExample(@Param("record") StarExperienceRecordDo record, @Param("example") StarExperienceRecordDoExample example);

    int updateByPrimaryKeySelective(StarExperienceRecordDo record);

    int updateByPrimaryKey(StarExperienceRecordDo record);
}