package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarCommentVideoRecordDo;
import com.hndl.cn.dao.star.bean.StarCommentVideoRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarCommentVideoRecordDoMapper {
    long countByExample(StarCommentVideoRecordDoExample example);

    int deleteByExample(StarCommentVideoRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarCommentVideoRecordDo record);

    int insertSelective(StarCommentVideoRecordDo record);

    List<StarCommentVideoRecordDo> selectByExample(StarCommentVideoRecordDoExample example);

    StarCommentVideoRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarCommentVideoRecordDo record, @Param("example") StarCommentVideoRecordDoExample example);

    int updateByExample(@Param("record") StarCommentVideoRecordDo record, @Param("example") StarCommentVideoRecordDoExample example);

    int updateByPrimaryKeySelective(StarCommentVideoRecordDo record);

    int updateByPrimaryKey(StarCommentVideoRecordDo record);
}