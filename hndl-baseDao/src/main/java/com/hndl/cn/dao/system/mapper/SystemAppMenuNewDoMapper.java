package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemAppMenuNewDo;
import com.hndl.cn.dao.system.bean.SystemAppMenuNewDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAppMenuNewDoMapper {
    long countByExample(SystemAppMenuNewDoExample example);

    int deleteByExample(SystemAppMenuNewDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAppMenuNewDo record);

    int insertSelective(SystemAppMenuNewDo record);

    List<SystemAppMenuNewDo> selectByExample(SystemAppMenuNewDoExample example);

    SystemAppMenuNewDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAppMenuNewDo record, @Param("example") SystemAppMenuNewDoExample example);

    int updateByExample(@Param("record") SystemAppMenuNewDo record, @Param("example") SystemAppMenuNewDoExample example);

    int updateByPrimaryKeySelective(SystemAppMenuNewDo record);

    int updateByPrimaryKey(SystemAppMenuNewDo record);
}