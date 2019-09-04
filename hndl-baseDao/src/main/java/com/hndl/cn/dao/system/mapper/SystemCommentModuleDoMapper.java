package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemCommentModuleDo;
import com.hndl.cn.dao.system.bean.SystemCommentModuleDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemCommentModuleDoMapper {
    long countByExample(SystemCommentModuleDoExample example);

    int deleteByExample(SystemCommentModuleDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemCommentModuleDo record);

    int insertSelective(SystemCommentModuleDo record);

    List<SystemCommentModuleDo> selectByExample(SystemCommentModuleDoExample example);

    SystemCommentModuleDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemCommentModuleDo record, @Param("example") SystemCommentModuleDoExample example);

    int updateByExample(@Param("record") SystemCommentModuleDo record, @Param("example") SystemCommentModuleDoExample example);

    int updateByPrimaryKeySelective(SystemCommentModuleDo record);

    int updateByPrimaryKey(SystemCommentModuleDo record);
}