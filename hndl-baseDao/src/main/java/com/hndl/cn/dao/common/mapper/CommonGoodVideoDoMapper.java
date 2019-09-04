package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonGoodVideoDo;
import com.hndl.cn.dao.common.bean.CommonGoodVideoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonGoodVideoDoMapper {
    long countByExample(CommonGoodVideoDoExample example);

    int deleteByExample(CommonGoodVideoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonGoodVideoDo record);

    int insertSelective(CommonGoodVideoDo record);

    List<CommonGoodVideoDo> selectByExample(CommonGoodVideoDoExample example);

    CommonGoodVideoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonGoodVideoDo record, @Param("example") CommonGoodVideoDoExample example);

    int updateByExample(@Param("record") CommonGoodVideoDo record, @Param("example") CommonGoodVideoDoExample example);

    int updateByPrimaryKeySelective(CommonGoodVideoDo record);

    int updateByPrimaryKey(CommonGoodVideoDo record);
}