package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareOrgInfoDo;
import com.hndl.cn.dao.welfare.bean.WelfareOrgInfoDoExample;
import com.hndl.cn.dao.welfare.bean.WelfareOrgInfoDoKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareOrgInfoDoMapper {
    long countByExample(WelfareOrgInfoDoExample example);

    int deleteByExample(WelfareOrgInfoDoExample example);

    int deleteByPrimaryKey(WelfareOrgInfoDoKey key);

    int insert(WelfareOrgInfoDo record);

    int insertSelective(WelfareOrgInfoDo record);

    List<WelfareOrgInfoDo> selectByExample(WelfareOrgInfoDoExample example);

    WelfareOrgInfoDo selectByPrimaryKey(WelfareOrgInfoDoKey key);

    int updateByExampleSelective(@Param("record") WelfareOrgInfoDo record, @Param("example") WelfareOrgInfoDoExample example);

    int updateByExample(@Param("record") WelfareOrgInfoDo record, @Param("example") WelfareOrgInfoDoExample example);

    int updateByPrimaryKeySelective(WelfareOrgInfoDo record);

    int updateByPrimaryKey(WelfareOrgInfoDo record);
}