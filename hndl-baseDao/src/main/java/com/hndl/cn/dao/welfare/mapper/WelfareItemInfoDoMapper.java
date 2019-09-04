package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareItemInfoDo;
import com.hndl.cn.dao.welfare.bean.WelfareItemInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareItemInfoDoMapper {
    long countByExample(WelfareItemInfoDoExample example);

    int deleteByExample(WelfareItemInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareItemInfoDo record);

    int insertSelective(WelfareItemInfoDo record);

    List<WelfareItemInfoDo> selectByExample(WelfareItemInfoDoExample example);

    WelfareItemInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareItemInfoDo record, @Param("example") WelfareItemInfoDoExample example);

    int updateByExample(@Param("record") WelfareItemInfoDo record, @Param("example") WelfareItemInfoDoExample example);

    int updateByPrimaryKeySelective(WelfareItemInfoDo record);

    int updateByPrimaryKey(WelfareItemInfoDo record);
}