package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemAddDoudouDo;
import com.hndl.cn.dao.system.bean.SystemAddDoudouDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAddDoudouDoMapper {
    long countByExample(SystemAddDoudouDoExample example);

    int deleteByExample(SystemAddDoudouDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAddDoudouDo record);

    int insertSelective(SystemAddDoudouDo record);

    List<SystemAddDoudouDo> selectByExample(SystemAddDoudouDoExample example);

    SystemAddDoudouDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAddDoudouDo record, @Param("example") SystemAddDoudouDoExample example);

    int updateByExample(@Param("record") SystemAddDoudouDo record, @Param("example") SystemAddDoudouDoExample example);

    int updateByPrimaryKeySelective(SystemAddDoudouDo record);

    int updateByPrimaryKey(SystemAddDoudouDo record);
}