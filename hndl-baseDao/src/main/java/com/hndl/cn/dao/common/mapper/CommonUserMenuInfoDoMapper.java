package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonUserMenuInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserMenuInfoDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonUserMenuInfoDoMapper {
    long countByExample(CommonUserMenuInfoDoExample example);

    int deleteByExample(CommonUserMenuInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonUserMenuInfoDo record);

    int insertSelective(CommonUserMenuInfoDo record);

    List<CommonUserMenuInfoDo> selectByExample(CommonUserMenuInfoDoExample example);

    CommonUserMenuInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonUserMenuInfoDo record, @Param("example") CommonUserMenuInfoDoExample example);

    int updateByExample(@Param("record") CommonUserMenuInfoDo record, @Param("example") CommonUserMenuInfoDoExample example);

    int updateByPrimaryKeySelective(CommonUserMenuInfoDo record);

    int updateByPrimaryKey(CommonUserMenuInfoDo record);

    List<CommonUserMenuInfoDo> selectUserMenuInfo();
}