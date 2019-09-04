package com.hndl.cn.dao.star.mapper;

import com.hndl.cn.dao.star.bean.StarApplyMasterDo;
import com.hndl.cn.dao.star.bean.StarApplyMasterDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StarApplyMasterDoMapper {
    long countByExample(StarApplyMasterDoExample example);

    int deleteByExample(StarApplyMasterDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StarApplyMasterDo record);

    int insertSelective(StarApplyMasterDo record);

    List<StarApplyMasterDo> selectByExample(StarApplyMasterDoExample example);

    StarApplyMasterDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StarApplyMasterDo record, @Param("example") StarApplyMasterDoExample example);

    int updateByExample(@Param("record") StarApplyMasterDo record, @Param("example") StarApplyMasterDoExample example);

    int updateByPrimaryKeySelective(StarApplyMasterDo record);

    int updateByPrimaryKey(StarApplyMasterDo record);
}