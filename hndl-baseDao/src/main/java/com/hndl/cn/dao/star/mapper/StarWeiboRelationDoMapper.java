package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarWeiboRelationDo;
import com.hndl.cn.dao.star.bean.StarWeiboRelationDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarWeiboRelationDoMapper {
    long countByExample(StarWeiboRelationDoExample example);

    int deleteByExample(StarWeiboRelationDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarWeiboRelationDo record);

    int insertSelective(StarWeiboRelationDo record);

    List<StarWeiboRelationDo> selectByExample(StarWeiboRelationDoExample example);

    StarWeiboRelationDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarWeiboRelationDo record, @Param("example") StarWeiboRelationDoExample example);

    int updateByExample(@Param("record") StarWeiboRelationDo record, @Param("example") StarWeiboRelationDoExample example);

    int updateByPrimaryKeySelective(StarWeiboRelationDo record);

    int updateByPrimaryKey(StarWeiboRelationDo record);
}