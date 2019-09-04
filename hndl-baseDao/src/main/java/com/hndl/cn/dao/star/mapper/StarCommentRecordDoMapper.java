package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarCommentRecordDo;
import com.hndl.cn.dao.star.bean.StarCommentRecordDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StarCommentRecordDoMapper {
    long countByExample(StarCommentRecordDoExample example);

    int deleteByExample(StarCommentRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarCommentRecordDo record);

    int insertSelective(StarCommentRecordDo record);

    List<StarCommentRecordDo> selectByExample(StarCommentRecordDoExample example);

    StarCommentRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarCommentRecordDo record, @Param("example") StarCommentRecordDoExample example);

    int updateByExample(@Param("record") StarCommentRecordDo record, @Param("example") StarCommentRecordDoExample example);

    int updateByPrimaryKeySelective(StarCommentRecordDo record);

    int updateByPrimaryKey(StarCommentRecordDo record);

    //查询未弹幕的记录
    int selectIsBarrageCount(Long starId);

    //修改已弹幕的记录
    int updateIsBarrage(Long starId);
}