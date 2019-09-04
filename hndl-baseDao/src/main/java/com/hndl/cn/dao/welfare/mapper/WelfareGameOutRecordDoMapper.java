package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareGameOutRecordDo;
import com.hndl.cn.dao.welfare.bean.WelfareGameOutRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareGameOutRecordDoMapper {
    long countByExample(WelfareGameOutRecordDoExample example);

    int deleteByExample(WelfareGameOutRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareGameOutRecordDo record);

    int insertSelective(WelfareGameOutRecordDo record);

    List<WelfareGameOutRecordDo> selectByExample(WelfareGameOutRecordDoExample example);

    WelfareGameOutRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareGameOutRecordDo record, @Param("example") WelfareGameOutRecordDoExample example);

    int updateByExample(@Param("record") WelfareGameOutRecordDo record, @Param("example") WelfareGameOutRecordDoExample example);

    int updateByPrimaryKeySelective(WelfareGameOutRecordDo record);

    int updateByPrimaryKey(WelfareGameOutRecordDo record);
}