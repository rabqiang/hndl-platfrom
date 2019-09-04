package com.hndl.cn.dao.task.mapper;

import com.hndl.cn.dao.task.bean.TaskEveryDayDoudouDo;
import com.hndl.cn.dao.task.bean.TaskEveryDayDoudouDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskEveryDayDoudouDoMapper {
    long countByExample(TaskEveryDayDoudouDoExample example);

    int deleteByExample(TaskEveryDayDoudouDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskEveryDayDoudouDo record);

    int insertSelective(TaskEveryDayDoudouDo record);

    List<TaskEveryDayDoudouDo> selectByExample(TaskEveryDayDoudouDoExample example);

    TaskEveryDayDoudouDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskEveryDayDoudouDo record, @Param("example") TaskEveryDayDoudouDoExample example);

    int updateByExample(@Param("record") TaskEveryDayDoudouDo record, @Param("example") TaskEveryDayDoudouDoExample example);

    int updateByPrimaryKeySelective(TaskEveryDayDoudouDo record);

    int updateByPrimaryKey(TaskEveryDayDoudouDo record);
}