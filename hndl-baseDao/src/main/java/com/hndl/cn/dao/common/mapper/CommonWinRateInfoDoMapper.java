package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonWinRateInfoDo;
import com.hndl.cn.dao.common.bean.CommonWinRateInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonWinRateInfoDoMapper {
    long countByExample(CommonWinRateInfoDoExample example);

    int deleteByExample(CommonWinRateInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonWinRateInfoDo record);

    int insertSelective(CommonWinRateInfoDo record);

    List<CommonWinRateInfoDo> selectByExample(CommonWinRateInfoDoExample example);

    CommonWinRateInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonWinRateInfoDo record, @Param("example") CommonWinRateInfoDoExample example);

    int updateByExample(@Param("record") CommonWinRateInfoDo record, @Param("example") CommonWinRateInfoDoExample example);

    int updateByPrimaryKeySelective(CommonWinRateInfoDo record);

    int updateByPrimaryKey(CommonWinRateInfoDo record);
}