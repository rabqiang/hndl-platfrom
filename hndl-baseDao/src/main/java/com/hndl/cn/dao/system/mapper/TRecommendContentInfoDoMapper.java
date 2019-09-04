package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TRecommendContentInfoDo;
import com.hndl.cn.dao.system.bean.TRecommendContentInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TRecommendContentInfoDoMapper {
    long countByExample(TRecommendContentInfoDoExample example);

    int deleteByExample(TRecommendContentInfoDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRecommendContentInfoDo record);

    int insertSelective(TRecommendContentInfoDo record);

    List<TRecommendContentInfoDo> selectByExample(TRecommendContentInfoDoExample example);

    TRecommendContentInfoDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRecommendContentInfoDo record, @Param("example") TRecommendContentInfoDoExample example);

    int updateByExample(@Param("record") TRecommendContentInfoDo record, @Param("example") TRecommendContentInfoDoExample example);

    int updateByPrimaryKeySelective(TRecommendContentInfoDo record);

    int updateByPrimaryKey(TRecommendContentInfoDo record);
}