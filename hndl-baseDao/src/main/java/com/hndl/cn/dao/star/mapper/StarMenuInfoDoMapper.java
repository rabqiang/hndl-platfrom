package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarMenuInfoDo;
import com.hndl.cn.dao.star.bean.StarMenuInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarMenuInfoDoMapper {
    long countByExample(StarMenuInfoDoExample example);

    int deleteByExample(StarMenuInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarMenuInfoDo record);

    int insertSelective(StarMenuInfoDo record);

    List<StarMenuInfoDo> selectByExample(StarMenuInfoDoExample example);

    StarMenuInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarMenuInfoDo record, @Param("example") StarMenuInfoDoExample example);

    int updateByExample(@Param("record") StarMenuInfoDo record, @Param("example") StarMenuInfoDoExample example);

    int updateByPrimaryKeySelective(StarMenuInfoDo record);

    int updateByPrimaryKey(StarMenuInfoDo record);
}