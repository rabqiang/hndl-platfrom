package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.dao.system.bean.SystemJobInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemJobInfoDoMapper {
    long countByExample(SystemJobInfoDoExample example);

    int deleteByExample(SystemJobInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemJobInfoDo record);

    int insertSelective(SystemJobInfoDo record);

    List<SystemJobInfoDo> selectByExample(SystemJobInfoDoExample example);

    SystemJobInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemJobInfoDo record, @Param("example") SystemJobInfoDoExample example);

    int updateByExample(@Param("record") SystemJobInfoDo record, @Param("example") SystemJobInfoDoExample example);

    int updateByPrimaryKeySelective(SystemJobInfoDo record);

    int updateByPrimaryKey(SystemJobInfoDo record);
}