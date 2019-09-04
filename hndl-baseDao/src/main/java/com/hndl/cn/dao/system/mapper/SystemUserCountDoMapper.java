package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemUserCountDo;
import com.hndl.cn.dao.system.bean.SystemUserCountDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserCountDoMapper {
    long countByExample(SystemUserCountDoExample example);

    int deleteByExample(SystemUserCountDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemUserCountDo record);

    int insertSelective(SystemUserCountDo record);

    List<SystemUserCountDo> selectByExample(SystemUserCountDoExample example);

    SystemUserCountDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemUserCountDo record, @Param("example") SystemUserCountDoExample example);

    int updateByExample(@Param("record") SystemUserCountDo record, @Param("example") SystemUserCountDoExample example);

    int updateByPrimaryKeySelective(SystemUserCountDo record);

    int updateByPrimaryKey(SystemUserCountDo record);
}