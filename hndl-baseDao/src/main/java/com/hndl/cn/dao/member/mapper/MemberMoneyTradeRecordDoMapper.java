package com.hndl.cn.dao.member.mapper;

import com.hndl.cn.dao.member.bean.MemberMoneyTradeRecordDo;
import com.hndl.cn.dao.member.bean.MemberMoneyTradeRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMoneyTradeRecordDoMapper {
    long countByExample(MemberMoneyTradeRecordDoExample example);

    int deleteByExample(MemberMoneyTradeRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberMoneyTradeRecordDo record);

    int insertSelective(MemberMoneyTradeRecordDo record);

    List<MemberMoneyTradeRecordDo> selectByExample(MemberMoneyTradeRecordDoExample example);

    MemberMoneyTradeRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberMoneyTradeRecordDo record, @Param("example") MemberMoneyTradeRecordDoExample example);

    int updateByExample(@Param("record") MemberMoneyTradeRecordDo record, @Param("example") MemberMoneyTradeRecordDoExample example);

    int updateByPrimaryKeySelective(MemberMoneyTradeRecordDo record);

    int updateByPrimaryKey(MemberMoneyTradeRecordDo record);
}