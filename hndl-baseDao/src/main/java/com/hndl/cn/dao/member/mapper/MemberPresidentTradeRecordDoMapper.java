package com.hndl.cn.dao.member.mapper;

import com.hndl.cn.dao.member.bean.MemberPresidentTradeRecordDo;
import com.hndl.cn.dao.member.bean.MemberPresidentTradeRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPresidentTradeRecordDoMapper {
    long countByExample(MemberPresidentTradeRecordDoExample example);

    int deleteByExample(MemberPresidentTradeRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberPresidentTradeRecordDo record);

    int insertSelective(MemberPresidentTradeRecordDo record);

    List<MemberPresidentTradeRecordDo> selectByExample(MemberPresidentTradeRecordDoExample example);

    MemberPresidentTradeRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberPresidentTradeRecordDo record, @Param("example") MemberPresidentTradeRecordDoExample example);

    int updateByExample(@Param("record") MemberPresidentTradeRecordDo record, @Param("example") MemberPresidentTradeRecordDoExample example);

    int updateByPrimaryKeySelective(MemberPresidentTradeRecordDo record);

    int updateByPrimaryKey(MemberPresidentTradeRecordDo record);
}