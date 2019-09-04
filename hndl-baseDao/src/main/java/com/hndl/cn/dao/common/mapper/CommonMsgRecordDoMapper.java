package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonMsgRecordDo;
import com.hndl.cn.dao.common.bean.CommonMsgRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonMsgRecordDoMapper {
    long countByExample(CommonMsgRecordDoExample example);

    int deleteByExample(CommonMsgRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonMsgRecordDo record);

    int insertSelective(CommonMsgRecordDo record);

    List<CommonMsgRecordDo> selectByExample(CommonMsgRecordDoExample example);

    CommonMsgRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonMsgRecordDo record, @Param("example") CommonMsgRecordDoExample example);

    int updateByExample(@Param("record") CommonMsgRecordDo record, @Param("example") CommonMsgRecordDoExample example);

    int updateByPrimaryKeySelective(CommonMsgRecordDo record);

    int updateByPrimaryKey(CommonMsgRecordDo record);
}