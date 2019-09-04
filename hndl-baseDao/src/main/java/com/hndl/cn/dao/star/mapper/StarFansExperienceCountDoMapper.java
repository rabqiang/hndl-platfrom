package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarFansExperienceCountDo;
import com.hndl.cn.dao.star.bean.StarFansExperienceCountDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarFansExperienceCountDoMapper {
    long countByExample(StarFansExperienceCountDoExample example);

    int deleteByExample(StarFansExperienceCountDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarFansExperienceCountDo record);

    int insertSelective(StarFansExperienceCountDo record);

    List<StarFansExperienceCountDo> selectByExample(StarFansExperienceCountDoExample example);

    StarFansExperienceCountDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarFansExperienceCountDo record, @Param("example") StarFansExperienceCountDoExample example);

    int updateByExample(@Param("record") StarFansExperienceCountDo record, @Param("example") StarFansExperienceCountDoExample example);

    int updateByPrimaryKeySelective(StarFansExperienceCountDo record);

    int updateByPrimaryKey(StarFansExperienceCountDo record);
}