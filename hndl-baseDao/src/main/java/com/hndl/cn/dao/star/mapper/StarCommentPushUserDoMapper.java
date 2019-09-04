package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarCommentPushUserDo;
import com.hndl.cn.dao.star.bean.StarCommentPushUserDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarCommentPushUserDoMapper {
    long countByExample(StarCommentPushUserDoExample example);

    int deleteByExample(StarCommentPushUserDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarCommentPushUserDo record);

    int insertSelective(StarCommentPushUserDo record);

    List<StarCommentPushUserDo> selectByExample(StarCommentPushUserDoExample example);

    StarCommentPushUserDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarCommentPushUserDo record, @Param("example") StarCommentPushUserDoExample example);

    int updateByExample(@Param("record") StarCommentPushUserDo record, @Param("example") StarCommentPushUserDoExample example);

    int updateByPrimaryKeySelective(StarCommentPushUserDo record);

    int updateByPrimaryKey(StarCommentPushUserDo record);
}