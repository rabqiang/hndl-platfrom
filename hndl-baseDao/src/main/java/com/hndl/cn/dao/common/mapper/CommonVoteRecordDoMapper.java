package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonVoteRecordDo;
import com.hndl.cn.dao.common.bean.CommonVoteRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonVoteRecordDoMapper {
    long countByExample(CommonVoteRecordDoExample example);

    int deleteByExample(CommonVoteRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonVoteRecordDo record);

    int insertSelective(CommonVoteRecordDo record);

    List<CommonVoteRecordDo> selectByExample(CommonVoteRecordDoExample example);

    CommonVoteRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonVoteRecordDo record, @Param("example") CommonVoteRecordDoExample example);

    int updateByExample(@Param("record") CommonVoteRecordDo record, @Param("example") CommonVoteRecordDoExample example);

    int updateByPrimaryKeySelective(CommonVoteRecordDo record);

    int updateByPrimaryKey(CommonVoteRecordDo record);
}