package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarCommentReportInfoDo;
import com.hndl.cn.dao.star.bean.StarCommentReportInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarCommentReportInfoDoMapper {
    long countByExample(StarCommentReportInfoDoExample example);

    int deleteByExample(StarCommentReportInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarCommentReportInfoDo record);

    int insertSelective(StarCommentReportInfoDo record);

    List<StarCommentReportInfoDo> selectByExample(StarCommentReportInfoDoExample example);

    StarCommentReportInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarCommentReportInfoDo record, @Param("example") StarCommentReportInfoDoExample example);

    int updateByExample(@Param("record") StarCommentReportInfoDo record, @Param("example") StarCommentReportInfoDoExample example);

    int updateByPrimaryKeySelective(StarCommentReportInfoDo record);

    int updateByPrimaryKey(StarCommentReportInfoDo record);
}