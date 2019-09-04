package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarCommentRunUserDo;
import com.hndl.cn.dao.star.bean.StarCommentRunUserDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarCommentRunUserDoMapper {
    long countByExample(StarCommentRunUserDoExample example);

    int deleteByExample(StarCommentRunUserDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarCommentRunUserDo record);

    int insertSelective(StarCommentRunUserDo record);

    List<StarCommentRunUserDo> selectByExample(StarCommentRunUserDoExample example);

    StarCommentRunUserDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarCommentRunUserDo record, @Param("example") StarCommentRunUserDoExample example);

    int updateByExample(@Param("record") StarCommentRunUserDo record, @Param("example") StarCommentRunUserDoExample example);

    int updateByPrimaryKeySelective(StarCommentRunUserDo record);

    int updateByPrimaryKey(StarCommentRunUserDo record);
}