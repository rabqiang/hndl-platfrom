package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonGameInfoDo;
import com.hndl.cn.dao.common.bean.CommonGameInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonGameInfoDoMapper {
    long countByExample(CommonGameInfoDoExample example);

    int deleteByExample(CommonGameInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonGameInfoDo record);

    int insertSelective(CommonGameInfoDo record);

    List<CommonGameInfoDo> selectByExample(CommonGameInfoDoExample example);

    CommonGameInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonGameInfoDo record, @Param("example") CommonGameInfoDoExample example);

    int updateByExample(@Param("record") CommonGameInfoDo record, @Param("example") CommonGameInfoDoExample example);

    int updateByPrimaryKeySelective(CommonGameInfoDo record);

    int updateByPrimaryKey(CommonGameInfoDo record);
}