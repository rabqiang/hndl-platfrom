package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarBarrageInfoDo;
import com.hndl.cn.dao.star.bean.StarBarrageInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarBarrageInfoDoMapper {
    long countByExample(StarBarrageInfoDoExample example);

    int deleteByExample(StarBarrageInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarBarrageInfoDo record);

    int insertSelective(StarBarrageInfoDo record);

    List<StarBarrageInfoDo> selectByExample(StarBarrageInfoDoExample example);

    StarBarrageInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarBarrageInfoDo record, @Param("example") StarBarrageInfoDoExample example);

    int updateByExample(@Param("record") StarBarrageInfoDo record, @Param("example") StarBarrageInfoDoExample example);

    int updateByPrimaryKeySelective(StarBarrageInfoDo record);

    int updateByPrimaryKey(StarBarrageInfoDo record);
}