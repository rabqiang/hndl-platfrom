package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemSmsRecordDo;
import com.hndl.cn.dao.system.bean.SystemSmsRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemSmsRecordDoMapper {
    long countByExample(SystemSmsRecordDoExample example);

    int deleteByExample(SystemSmsRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemSmsRecordDo record);

    int insertSelective(SystemSmsRecordDo record);

    List<SystemSmsRecordDo> selectByExample(SystemSmsRecordDoExample example);

    SystemSmsRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemSmsRecordDo record, @Param("example") SystemSmsRecordDoExample example);

    int updateByExample(@Param("record") SystemSmsRecordDo record, @Param("example") SystemSmsRecordDoExample example);

    int updateByPrimaryKeySelective(SystemSmsRecordDo record);

    int updateByPrimaryKey(SystemSmsRecordDo record);
}