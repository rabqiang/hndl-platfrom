package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemVersionInfoDo;
import com.hndl.cn.dao.system.bean.SystemVersionInfoDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SystemVersionInfoDoMapper {
    long countByExample(SystemVersionInfoDoExample example);

    int deleteByExample(SystemVersionInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemVersionInfoDo record);

    int insertSelective(SystemVersionInfoDo record);

    List<SystemVersionInfoDo> selectByExample(SystemVersionInfoDoExample example);

    SystemVersionInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemVersionInfoDo record, @Param("example") SystemVersionInfoDoExample example);

    int updateByExample(@Param("record") SystemVersionInfoDo record, @Param("example") SystemVersionInfoDoExample example);

    int updateByPrimaryKeySelective(SystemVersionInfoDo record);

    int updateByPrimaryKey(SystemVersionInfoDo record);

}