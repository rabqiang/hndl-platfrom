package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemAddTaskDoudouDo;
import com.hndl.cn.dao.system.bean.SystemAddTaskDoudouDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAddTaskDoudouDoMapper {
    long countByExample(SystemAddTaskDoudouDoExample example);

    int deleteByExample(SystemAddTaskDoudouDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAddTaskDoudouDo record);

    int insertSelective(SystemAddTaskDoudouDo record);

    List<SystemAddTaskDoudouDo> selectByExample(SystemAddTaskDoudouDoExample example);

    SystemAddTaskDoudouDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAddTaskDoudouDo record, @Param("example") SystemAddTaskDoudouDoExample example);

    int updateByExample(@Param("record") SystemAddTaskDoudouDo record, @Param("example") SystemAddTaskDoudouDoExample example);

    int updateByPrimaryKeySelective(SystemAddTaskDoudouDo record);

    int updateByPrimaryKey(SystemAddTaskDoudouDo record);
}