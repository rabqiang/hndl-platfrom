package com.hndl.cn.dao.member.mapper;

import com.hndl.cn.dao.member.bean.MemberExperienceRecordDo;
import com.hndl.cn.dao.member.bean.MemberExperienceRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberExperienceRecordDoMapper {
    long countByExample(MemberExperienceRecordDoExample example);

    int deleteByExample(MemberExperienceRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MemberExperienceRecordDo record);

    int insertSelective(MemberExperienceRecordDo record);

    List<MemberExperienceRecordDo> selectByExample(MemberExperienceRecordDoExample example);

    MemberExperienceRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MemberExperienceRecordDo record, @Param("example") MemberExperienceRecordDoExample example);

    int updateByExample(@Param("record") MemberExperienceRecordDo record, @Param("example") MemberExperienceRecordDoExample example);

    int updateByPrimaryKeySelective(MemberExperienceRecordDo record);

    int updateByPrimaryKey(MemberExperienceRecordDo record);
}