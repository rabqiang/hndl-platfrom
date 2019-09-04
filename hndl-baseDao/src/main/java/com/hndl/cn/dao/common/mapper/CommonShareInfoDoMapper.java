package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonShareInfoDo;
import com.hndl.cn.dao.common.bean.CommonShareInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonShareInfoDoMapper {
    long countByExample(CommonShareInfoDoExample example);

    int deleteByExample(CommonShareInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonShareInfoDo record);

    int insertSelective(CommonShareInfoDo record);

    List<CommonShareInfoDo> selectByExample(CommonShareInfoDoExample example);

    CommonShareInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonShareInfoDo record, @Param("example") CommonShareInfoDoExample example);

    int updateByExample(@Param("record") CommonShareInfoDo record, @Param("example") CommonShareInfoDoExample example);

    int updateByPrimaryKeySelective(CommonShareInfoDo record);

    int updateByPrimaryKey(CommonShareInfoDo record);
}