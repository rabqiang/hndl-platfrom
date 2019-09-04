package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemUserFeedbackDo;
import com.hndl.cn.dao.system.bean.SystemUserFeedbackDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemUserFeedbackDoMapper {
    long countByExample(SystemUserFeedbackDoExample example);

    int deleteByExample(SystemUserFeedbackDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemUserFeedbackDo record);

    int insertSelective(SystemUserFeedbackDo record);

    List<SystemUserFeedbackDo> selectByExample(SystemUserFeedbackDoExample example);

    SystemUserFeedbackDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemUserFeedbackDo record, @Param("example") SystemUserFeedbackDoExample example);

    int updateByExample(@Param("record") SystemUserFeedbackDo record, @Param("example") SystemUserFeedbackDoExample example);

    int updateByPrimaryKeySelective(SystemUserFeedbackDo record);

    int updateByPrimaryKey(SystemUserFeedbackDo record);
}