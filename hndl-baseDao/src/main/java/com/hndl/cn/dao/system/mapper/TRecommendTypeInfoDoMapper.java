package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TRecommendTypeInfoDo;
import com.hndl.cn.dao.system.bean.TRecommendTypeInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TRecommendTypeInfoDoMapper {
    long countByExample(TRecommendTypeInfoDoExample example);

    int deleteByExample(TRecommendTypeInfoDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRecommendTypeInfoDo record);

    int insertSelective(TRecommendTypeInfoDo record);

    List<TRecommendTypeInfoDo> selectByExample(TRecommendTypeInfoDoExample example);

    TRecommendTypeInfoDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRecommendTypeInfoDo record, @Param("example") TRecommendTypeInfoDoExample example);

    int updateByExample(@Param("record") TRecommendTypeInfoDo record, @Param("example") TRecommendTypeInfoDoExample example);

    int updateByPrimaryKeySelective(TRecommendTypeInfoDo record);

    int updateByPrimaryKey(TRecommendTypeInfoDo record);
}