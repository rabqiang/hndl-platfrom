package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarHeartRecordDo;
import com.hndl.cn.dao.star.bean.StarHeartRecordDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarHeartRecordDoMapper {
    long countByExample(StarHeartRecordDoExample example);

    int deleteByExample(StarHeartRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarHeartRecordDo record);

    int insertSelective(StarHeartRecordDo record);

    List<StarHeartRecordDo> selectByExample(StarHeartRecordDoExample example);

    StarHeartRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarHeartRecordDo record, @Param("example") StarHeartRecordDoExample example);

    int updateByExample(@Param("record") StarHeartRecordDo record, @Param("example") StarHeartRecordDoExample example);

    int updateByPrimaryKeySelective(StarHeartRecordDo record);

    int updateByPrimaryKey(StarHeartRecordDo record);

    //查询未弹幕的记录
    int selectIsBarrageCount(Long starId);

    //修改已弹幕的记录
    int updateIsBarrage(Long starId);
}