package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonActivityInfoDo;
import com.hndl.cn.dao.common.bean.CommonActivityInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonActivityInfoDoMapper {
    long countByExample(CommonActivityInfoDoExample example);

    int deleteByExample(CommonActivityInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonActivityInfoDo record);

    int insertSelective(CommonActivityInfoDo record);

    List<CommonActivityInfoDo> selectByExample(CommonActivityInfoDoExample example);

    CommonActivityInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonActivityInfoDo record, @Param("example") CommonActivityInfoDoExample example);

    int updateByExample(@Param("record") CommonActivityInfoDo record, @Param("example") CommonActivityInfoDoExample example);

    int updateByPrimaryKeySelective(CommonActivityInfoDo record);

    int updateByPrimaryKey(CommonActivityInfoDo record);
}