package com.hndl.cn.dao.member.mapper;

import com.hndl.cn.dao.member.bean.MemberHeartTradeRecordDo;
import com.hndl.cn.dao.member.bean.MemberHeartTradeRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberHeartTradeRecordDoMapper {
    long countByExample(MemberHeartTradeRecordDoExample example);

    int deleteByExample(MemberHeartTradeRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberHeartTradeRecordDo record);

    int insertSelective(MemberHeartTradeRecordDo record);

    List<MemberHeartTradeRecordDo> selectByExample(MemberHeartTradeRecordDoExample example);

    MemberHeartTradeRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberHeartTradeRecordDo record, @Param("example") MemberHeartTradeRecordDoExample example);

    int updateByExample(@Param("record") MemberHeartTradeRecordDo record, @Param("example") MemberHeartTradeRecordDoExample example);

    int updateByPrimaryKeySelective(MemberHeartTradeRecordDo record);

    int updateByPrimaryKey(MemberHeartTradeRecordDo record);
}