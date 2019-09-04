package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareGameJobRecordDo;
import com.hndl.cn.dao.welfare.bean.WelfareGameJobRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareGameJobRecordDoMapper {
    long countByExample(WelfareGameJobRecordDoExample example);

    int deleteByExample(WelfareGameJobRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareGameJobRecordDo record);

    int insertSelective(WelfareGameJobRecordDo record);

    List<WelfareGameJobRecordDo> selectByExample(WelfareGameJobRecordDoExample example);

    WelfareGameJobRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareGameJobRecordDo record, @Param("example") WelfareGameJobRecordDoExample example);

    int updateByExample(@Param("record") WelfareGameJobRecordDo record, @Param("example") WelfareGameJobRecordDoExample example);

    int updateByPrimaryKeySelective(WelfareGameJobRecordDo record);

    int updateByPrimaryKey(WelfareGameJobRecordDo record);
}