package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemPushRecordDo;
import com.hndl.cn.dao.system.bean.SystemPushRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemPushRecordDoMapper {
    long countByExample(SystemPushRecordDoExample example);

    int deleteByExample(SystemPushRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemPushRecordDo record);

    int insertSelective(SystemPushRecordDo record);

    List<SystemPushRecordDo> selectByExample(SystemPushRecordDoExample example);

    SystemPushRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemPushRecordDo record, @Param("example") SystemPushRecordDoExample example);

    int updateByExample(@Param("record") SystemPushRecordDo record, @Param("example") SystemPushRecordDoExample example);

    int updateByPrimaryKeySelective(SystemPushRecordDo record);

    int updateByPrimaryKey(SystemPushRecordDo record);
}