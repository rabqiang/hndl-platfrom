package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonHomeManageInfoDo;
import com.hndl.cn.dao.common.bean.CommonHomeManageInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonHomeManageInfoDoMapper {
    long countByExample(CommonHomeManageInfoDoExample example);

    int deleteByExample(CommonHomeManageInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonHomeManageInfoDo record);

    int insertSelective(CommonHomeManageInfoDo record);

    List<CommonHomeManageInfoDo> selectByExample(CommonHomeManageInfoDoExample example);

    CommonHomeManageInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonHomeManageInfoDo record, @Param("example") CommonHomeManageInfoDoExample example);

    int updateByExample(@Param("record") CommonHomeManageInfoDo record, @Param("example") CommonHomeManageInfoDoExample example);

    int updateByPrimaryKeySelective(CommonHomeManageInfoDo record);

    int updateByPrimaryKey(CommonHomeManageInfoDo record);
}