package com.hndl.cn.dao.video.mapper;

import com.hndl.cn.dao.video.bean.ExclusiveVideoDo;
import com.hndl.cn.dao.video.bean.ExclusiveVideoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ExclusiveVideoMapper {
    long countByExample(ExclusiveVideoDoExample example);

    int deleteByExample(ExclusiveVideoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ExclusiveVideoDo record);

    int insertSelective(ExclusiveVideoDo record);

    List<ExclusiveVideoDo> selectByExample(ExclusiveVideoDoExample example);

    ExclusiveVideoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ExclusiveVideoDo record, @Param("example") ExclusiveVideoDoExample example);

    int updateByExample(@Param("record") ExclusiveVideoDo record, @Param("example") ExclusiveVideoDoExample example);

    int updateByPrimaryKeySelective(ExclusiveVideoDo record);

    int updateByPrimaryKey(ExclusiveVideoDo record);
}