package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonPromiseInfoDo;
import com.hndl.cn.dao.common.bean.CommonPromiseInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonPromiseInfoDoMapper {
    long countByExample(CommonPromiseInfoDoExample example);

    int deleteByExample(CommonPromiseInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonPromiseInfoDo record);

    int insertSelective(CommonPromiseInfoDo record);

    List<CommonPromiseInfoDo> selectByExample(CommonPromiseInfoDoExample example);

    CommonPromiseInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonPromiseInfoDo record, @Param("example") CommonPromiseInfoDoExample example);

    int updateByExample(@Param("record") CommonPromiseInfoDo record, @Param("example") CommonPromiseInfoDoExample example);

    int updateByPrimaryKeySelective(CommonPromiseInfoDo record);

    int updateByPrimaryKey(CommonPromiseInfoDo record);
}