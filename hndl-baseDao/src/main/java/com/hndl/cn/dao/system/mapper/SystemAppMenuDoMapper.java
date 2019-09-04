package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemAppMenuDo;
import com.hndl.cn.dao.system.bean.SystemAppMenuDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAppMenuDoMapper {
    long countByExample(SystemAppMenuDoExample example);

    int deleteByExample(SystemAppMenuDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAppMenuDo record);

    int insertSelective(SystemAppMenuDo record);

    List<SystemAppMenuDo> selectByExample(SystemAppMenuDoExample example);

    SystemAppMenuDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAppMenuDo record, @Param("example") SystemAppMenuDoExample example);

    int updateByExample(@Param("record") SystemAppMenuDo record, @Param("example") SystemAppMenuDoExample example);

    int updateByPrimaryKeySelective(SystemAppMenuDo record);

    int updateByPrimaryKey(SystemAppMenuDo record);
}