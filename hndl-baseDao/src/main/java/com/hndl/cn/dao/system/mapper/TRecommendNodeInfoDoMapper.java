package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TRecommendNodeInfoDo;
import com.hndl.cn.dao.system.bean.TRecommendNodeInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TRecommendNodeInfoDoMapper {
    long countByExample(TRecommendNodeInfoDoExample example);

    int deleteByExample(TRecommendNodeInfoDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRecommendNodeInfoDo record);

    int insertSelective(TRecommendNodeInfoDo record);

    List<TRecommendNodeInfoDo> selectByExample(TRecommendNodeInfoDoExample example);

    TRecommendNodeInfoDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRecommendNodeInfoDo record, @Param("example") TRecommendNodeInfoDoExample example);

    int updateByExample(@Param("record") TRecommendNodeInfoDo record, @Param("example") TRecommendNodeInfoDoExample example);

    int updateByPrimaryKeySelective(TRecommendNodeInfoDo record);

    int updateByPrimaryKey(TRecommendNodeInfoDo record);
}