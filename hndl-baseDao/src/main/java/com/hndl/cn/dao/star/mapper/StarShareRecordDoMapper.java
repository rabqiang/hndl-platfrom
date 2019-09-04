package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarShareRecordDo;
import com.hndl.cn.dao.star.bean.StarShareRecordDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarShareRecordDoMapper {
    long countByExample(StarShareRecordDoExample example);

    int deleteByExample(StarShareRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarShareRecordDo record);

    int insertSelective(StarShareRecordDo record);

    List<StarShareRecordDo> selectByExample(StarShareRecordDoExample example);

    StarShareRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarShareRecordDo record, @Param("example") StarShareRecordDoExample example);

    int updateByExample(@Param("record") StarShareRecordDo record, @Param("example") StarShareRecordDoExample example);

    int updateByPrimaryKeySelective(StarShareRecordDo record);

    int updateByPrimaryKey(StarShareRecordDo record);

    //查询未弹幕的记录
    int selectIsBarrageCount(Long starId);

    //修改已弹幕的记录
    int updateIsBarrage(Long starId);
}