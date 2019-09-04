package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemOldNewDo;
import com.hndl.cn.dao.system.bean.SystemOldNewDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemOldNewDoMapper {
    long countByExample(SystemOldNewDoExample example);

    int deleteByExample(SystemOldNewDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemOldNewDo record);

    int insertSelective(SystemOldNewDo record);

    List<SystemOldNewDo> selectByExample(SystemOldNewDoExample example);

    SystemOldNewDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemOldNewDo record, @Param("example") SystemOldNewDoExample example);

    int updateByExample(@Param("record") SystemOldNewDo record, @Param("example") SystemOldNewDoExample example);

    int updateByPrimaryKeySelective(SystemOldNewDo record);

    int updateByPrimaryKey(SystemOldNewDo record);
}