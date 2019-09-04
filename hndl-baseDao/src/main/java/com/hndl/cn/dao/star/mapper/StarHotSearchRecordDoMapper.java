package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarHotSearchRecordDo;
import com.hndl.cn.dao.star.bean.StarHotSearchRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarHotSearchRecordDoMapper {
    long countByExample(StarHotSearchRecordDoExample example);

    int deleteByExample(StarHotSearchRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarHotSearchRecordDo record);

    int insertSelective(StarHotSearchRecordDo record);

    List<StarHotSearchRecordDo> selectByExample(StarHotSearchRecordDoExample example);

    StarHotSearchRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarHotSearchRecordDo record, @Param("example") StarHotSearchRecordDoExample example);

    int updateByExample(@Param("record") StarHotSearchRecordDo record, @Param("example") StarHotSearchRecordDoExample example);

    int updateByPrimaryKeySelective(StarHotSearchRecordDo record);

    int updateByPrimaryKey(StarHotSearchRecordDo record);
}