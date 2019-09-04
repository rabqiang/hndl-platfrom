package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareGameRecordDo;
import com.hndl.cn.dao.welfare.bean.WelfareGameRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareGameRecordDoMapper {
    long countByExample(WelfareGameRecordDoExample example);

    int deleteByExample(WelfareGameRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareGameRecordDo record);

    int insertSelective(WelfareGameRecordDo record);

    List<WelfareGameRecordDo> selectByExample(WelfareGameRecordDoExample example);

    WelfareGameRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareGameRecordDo record, @Param("example") WelfareGameRecordDoExample example);

    int updateByExample(@Param("record") WelfareGameRecordDo record, @Param("example") WelfareGameRecordDoExample example);

    int updateByPrimaryKeySelective(WelfareGameRecordDo record);

    int updateByPrimaryKey(WelfareGameRecordDo record);
}