package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonCrmUserDo;
import com.hndl.cn.dao.common.bean.CommonCrmUserDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonCrmUserDoMapper {
    long countByExample(CommonCrmUserDoExample example);

    int deleteByExample(CommonCrmUserDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonCrmUserDo record);

    int insertSelective(CommonCrmUserDo record);

    List<CommonCrmUserDo> selectByExample(CommonCrmUserDoExample example);

    CommonCrmUserDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonCrmUserDo record, @Param("example") CommonCrmUserDoExample example);

    int updateByExample(@Param("record") CommonCrmUserDo record, @Param("example") CommonCrmUserDoExample example);

    int updateByPrimaryKeySelective(CommonCrmUserDo record);

    int updateByPrimaryKey(CommonCrmUserDo record);
}