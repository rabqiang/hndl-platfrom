package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemAddEmpiricValueDo;
import com.hndl.cn.dao.system.bean.SystemAddEmpiricValueDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAddEmpiricValueDoMapper {
    long countByExample(SystemAddEmpiricValueDoExample example);

    int deleteByExample(SystemAddEmpiricValueDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAddEmpiricValueDo record);

    int insertSelective(SystemAddEmpiricValueDo record);

    List<SystemAddEmpiricValueDo> selectByExample(SystemAddEmpiricValueDoExample example);

    SystemAddEmpiricValueDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAddEmpiricValueDo record, @Param("example") SystemAddEmpiricValueDoExample example);

    int updateByExample(@Param("record") SystemAddEmpiricValueDo record, @Param("example") SystemAddEmpiricValueDoExample example);

    int updateByPrimaryKeySelective(SystemAddEmpiricValueDo record);

    int updateByPrimaryKey(SystemAddEmpiricValueDo record);
}