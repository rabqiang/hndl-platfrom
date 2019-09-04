package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareGameOrderDo;
import com.hndl.cn.dao.welfare.bean.WelfareGameOrderDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareGameOrderDoMapper {
    long countByExample(WelfareGameOrderDoExample example);

    int deleteByExample(WelfareGameOrderDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareGameOrderDo record);

    int insertSelective(WelfareGameOrderDo record);

    List<WelfareGameOrderDo> selectByExample(WelfareGameOrderDoExample example);

    WelfareGameOrderDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareGameOrderDo record, @Param("example") WelfareGameOrderDoExample example);

    int updateByExample(@Param("record") WelfareGameOrderDo record, @Param("example") WelfareGameOrderDoExample example);

    int updateByPrimaryKeySelective(WelfareGameOrderDo record);

    int updateByPrimaryKey(WelfareGameOrderDo record);
}