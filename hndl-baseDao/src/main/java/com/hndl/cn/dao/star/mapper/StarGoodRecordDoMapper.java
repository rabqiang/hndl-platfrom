package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarGoodRecordDo;
import com.hndl.cn.dao.star.bean.StarGoodRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarGoodRecordDoMapper {
    long countByExample(StarGoodRecordDoExample example);

    int deleteByExample(StarGoodRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarGoodRecordDo record);

    int insertSelective(StarGoodRecordDo record);

    List<StarGoodRecordDo> selectByExample(StarGoodRecordDoExample example);

    StarGoodRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarGoodRecordDo record, @Param("example") StarGoodRecordDoExample example);

    int updateByExample(@Param("record") StarGoodRecordDo record, @Param("example") StarGoodRecordDoExample example);

    int updateByPrimaryKeySelective(StarGoodRecordDo record);

    int updateByPrimaryKey(StarGoodRecordDo record);
}