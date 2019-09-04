package com.hndl.cn.dao.member.mapper;

import com.hndl.cn.dao.member.bean.MemberCoinTradeRecordDo;
import com.hndl.cn.dao.member.bean.MemberCoinTradeRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberCoinTradeRecordDoMapper {
    long countByExample(MemberCoinTradeRecordDoExample example);

    int deleteByExample(MemberCoinTradeRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberCoinTradeRecordDo record);

    int insertSelective(MemberCoinTradeRecordDo record);

    List<MemberCoinTradeRecordDo> selectByExample(MemberCoinTradeRecordDoExample example);

    MemberCoinTradeRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberCoinTradeRecordDo record, @Param("example") MemberCoinTradeRecordDoExample example);

    int updateByExample(@Param("record") MemberCoinTradeRecordDo record, @Param("example") MemberCoinTradeRecordDoExample example);

    int updateByPrimaryKeySelective(MemberCoinTradeRecordDo record);

    int updateByPrimaryKey(MemberCoinTradeRecordDo record);
}