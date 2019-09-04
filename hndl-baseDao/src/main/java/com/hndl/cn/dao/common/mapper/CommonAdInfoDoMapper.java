package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonAdInfoDo;
import com.hndl.cn.dao.common.bean.CommonAdInfoDoExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonAdInfoDoMapper {
    long countByExample(CommonAdInfoDoExample example);

    int deleteByExample(CommonAdInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonAdInfoDo record);

    int insertSelective(CommonAdInfoDo record);

    List<CommonAdInfoDo> selectByExample(CommonAdInfoDoExample example);

    CommonAdInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonAdInfoDo record, @Param("example") CommonAdInfoDoExample example);

    int updateByExample(@Param("record") CommonAdInfoDo record, @Param("example") CommonAdInfoDoExample example);

    int updateByPrimaryKeySelective(CommonAdInfoDo record);

    int updateByPrimaryKey(CommonAdInfoDo record);

    List<CommonAdInfoDo> queryByModel(String model);

    List<CommonAdInfoDo> queryBannerByShowTime(@Param("model")String model, @Param("showTime")Date showTime);
}