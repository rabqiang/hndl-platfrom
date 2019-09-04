package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonReportInfoDo;
import com.hndl.cn.dao.common.bean.CommonReportInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonReportInfoDoMapper {
    long countByExample(CommonReportInfoDoExample example);

    int deleteByExample(CommonReportInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonReportInfoDo record);

    int insertSelective(CommonReportInfoDo record);

    List<CommonReportInfoDo> selectByExample(CommonReportInfoDoExample example);

    CommonReportInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonReportInfoDo record, @Param("example") CommonReportInfoDoExample example);

    int updateByExample(@Param("record") CommonReportInfoDo record, @Param("example") CommonReportInfoDoExample example);

    int updateByPrimaryKeySelective(CommonReportInfoDo record);

    int updateByPrimaryKey(CommonReportInfoDo record);
}