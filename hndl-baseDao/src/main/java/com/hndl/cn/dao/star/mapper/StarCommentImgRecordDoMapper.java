package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarCommentImgRecordDo;
import com.hndl.cn.dao.star.bean.StarCommentImgRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarCommentImgRecordDoMapper {
    long countByExample(StarCommentImgRecordDoExample example);

    int deleteByExample(StarCommentImgRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarCommentImgRecordDo record);

    int insertSelective(StarCommentImgRecordDo record);

    List<StarCommentImgRecordDo> selectByExample(StarCommentImgRecordDoExample example);

    StarCommentImgRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarCommentImgRecordDo record, @Param("example") StarCommentImgRecordDoExample example);

    int updateByExample(@Param("record") StarCommentImgRecordDo record, @Param("example") StarCommentImgRecordDoExample example);

    int updateByPrimaryKeySelective(StarCommentImgRecordDo record);

    int updateByPrimaryKey(StarCommentImgRecordDo record);
}