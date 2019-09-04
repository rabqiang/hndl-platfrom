package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarApplyMainpersonDo;
import com.hndl.cn.dao.star.bean.StarApplyMainpersonDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarApplyMainpersonDoMapper {
    long countByExample(StarApplyMainpersonDoExample example);

    int deleteByExample(StarApplyMainpersonDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarApplyMainpersonDo record);

    int insertSelective(StarApplyMainpersonDo record);

    List<StarApplyMainpersonDo> selectByExample(StarApplyMainpersonDoExample example);

    StarApplyMainpersonDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarApplyMainpersonDo record, @Param("example") StarApplyMainpersonDoExample example);

    int updateByExample(@Param("record") StarApplyMainpersonDo record, @Param("example") StarApplyMainpersonDoExample example);

    int updateByPrimaryKeySelective(StarApplyMainpersonDo record);

    int updateByPrimaryKey(StarApplyMainpersonDo record);
}