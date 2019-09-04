package com.hndl.cn.dao.task.mapper;

import com.hndl.cn.dao.task.bean.TaskListWechatDeatilDo;
import com.hndl.cn.dao.task.bean.TaskListWechatDeatilDoExample;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskListWechatDeatilDoMapper {
    long countByExample(TaskListWechatDeatilDoExample example);

    int deleteByExample(TaskListWechatDeatilDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TaskListWechatDeatilDo record);

    int insertSelective(TaskListWechatDeatilDo record);

    List<TaskListWechatDeatilDo> selectByExample(TaskListWechatDeatilDoExample example);

    List<TaskListWechatDeatilDo> selectByKey(Long id);

    TaskListWechatDeatilDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TaskListWechatDeatilDo record, @Param("example") TaskListWechatDeatilDoExample example);

    int updateByExample(@Param("record") TaskListWechatDeatilDo record, @Param("example") TaskListWechatDeatilDoExample example);

    int updateByPrimaryKeySelective(TaskListWechatDeatilDo record);

    int updateByPrimaryKey(TaskListWechatDeatilDo record);
}