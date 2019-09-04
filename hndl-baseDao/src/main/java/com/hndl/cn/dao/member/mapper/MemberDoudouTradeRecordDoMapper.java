package com.hndl.cn.dao.member.mapper;

import com.hndl.cn.dao.member.bean.MemberDoudouTradeRecordDo;
import com.hndl.cn.dao.member.bean.MemberDoudouTradeRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberDoudouTradeRecordDoMapper {
    long countByExample(MemberDoudouTradeRecordDoExample example);

    int deleteByExample(MemberDoudouTradeRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberDoudouTradeRecordDo record);

    int insertSelective(MemberDoudouTradeRecordDo record);

    List<MemberDoudouTradeRecordDo> selectByExample(MemberDoudouTradeRecordDoExample example);

    MemberDoudouTradeRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberDoudouTradeRecordDo record, @Param("example") MemberDoudouTradeRecordDoExample example);

    int updateByExample(@Param("record") MemberDoudouTradeRecordDo record, @Param("example") MemberDoudouTradeRecordDoExample example);

    int updateByPrimaryKeySelective(MemberDoudouTradeRecordDo record);

    int updateByPrimaryKey(MemberDoudouTradeRecordDo record);
}