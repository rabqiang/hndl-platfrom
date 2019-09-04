package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarActivityInfoDo;
import com.hndl.cn.dao.star.bean.StarActivityInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarActivityInfoDoMapper {
    long countByExample(StarActivityInfoDoExample example);

    int deleteByExample(StarActivityInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarActivityInfoDo record);

    int insertSelective(StarActivityInfoDo record);

    List<StarActivityInfoDo> selectByExample(StarActivityInfoDoExample example);

    StarActivityInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarActivityInfoDo record, @Param("example") StarActivityInfoDoExample example);

    int updateByExample(@Param("record") StarActivityInfoDo record, @Param("example") StarActivityInfoDoExample example);

    int updateByPrimaryKeySelective(StarActivityInfoDo record);

    int updateByPrimaryKey(StarActivityInfoDo record);
}