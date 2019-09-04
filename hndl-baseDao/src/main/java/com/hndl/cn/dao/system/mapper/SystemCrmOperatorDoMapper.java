package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemCrmOperatorDo;
import com.hndl.cn.dao.system.bean.SystemCrmOperatorDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemCrmOperatorDoMapper {
    long countByExample(SystemCrmOperatorDoExample example);

    int deleteByExample(SystemCrmOperatorDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemCrmOperatorDo record);

    int insertSelective(SystemCrmOperatorDo record);

    List<SystemCrmOperatorDo> selectByExample(SystemCrmOperatorDoExample example);

    SystemCrmOperatorDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemCrmOperatorDo record, @Param("example") SystemCrmOperatorDoExample example);

    int updateByExample(@Param("record") SystemCrmOperatorDo record, @Param("example") SystemCrmOperatorDoExample example);

    int updateByPrimaryKeySelective(SystemCrmOperatorDo record);

    int updateByPrimaryKey(SystemCrmOperatorDo record);
}