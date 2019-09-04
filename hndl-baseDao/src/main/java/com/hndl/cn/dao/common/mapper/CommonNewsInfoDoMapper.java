package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonNewsInfoDo;
import com.hndl.cn.dao.common.bean.CommonNewsInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonNewsInfoDoMapper {
    long countByExample(CommonNewsInfoDoExample example);

    int deleteByExample(CommonNewsInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonNewsInfoDo record);

    int insertSelective(CommonNewsInfoDo record);

    List<CommonNewsInfoDo> selectByExample(CommonNewsInfoDoExample example);

    CommonNewsInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonNewsInfoDo record, @Param("example") CommonNewsInfoDoExample example);

    int updateByExample(@Param("record") CommonNewsInfoDo record, @Param("example") CommonNewsInfoDoExample example);

    int updateByPrimaryKeySelective(CommonNewsInfoDo record);

    int updateByPrimaryKey(CommonNewsInfoDo record);
}