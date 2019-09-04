package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemParameterInfoDo;
import com.hndl.cn.dao.system.bean.SystemParameterInfoDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemParameterInfoDoMapper {
    long countByExample(SystemParameterInfoDoExample example);

    int deleteByExample(SystemParameterInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemParameterInfoDo record);

    int insertSelective(SystemParameterInfoDo record);

    List<SystemParameterInfoDo> selectByExample(SystemParameterInfoDoExample example);

    SystemParameterInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemParameterInfoDo record, @Param("example") SystemParameterInfoDoExample example);

    int updateByExample(@Param("record") SystemParameterInfoDo record, @Param("example") SystemParameterInfoDoExample example);

    int updateByPrimaryKeySelective(SystemParameterInfoDo record);

    int updateByPrimaryKey(SystemParameterInfoDo record);

    SystemParameterInfoDo selectByParameterName(@Param("parameterName")String parameterName );
}