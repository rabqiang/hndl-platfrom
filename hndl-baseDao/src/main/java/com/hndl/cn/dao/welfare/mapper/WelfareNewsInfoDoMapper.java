package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareNewsInfoDo;
import com.hndl.cn.dao.welfare.bean.WelfareNewsInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareNewsInfoDoMapper {
    long countByExample(WelfareNewsInfoDoExample example);

    int deleteByExample(WelfareNewsInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareNewsInfoDo record);

    int insertSelective(WelfareNewsInfoDo record);

    List<WelfareNewsInfoDo> selectByExample(WelfareNewsInfoDoExample example);

    WelfareNewsInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareNewsInfoDo record, @Param("example") WelfareNewsInfoDoExample example);

    int updateByExample(@Param("record") WelfareNewsInfoDo record, @Param("example") WelfareNewsInfoDoExample example);

    int updateByPrimaryKeySelective(WelfareNewsInfoDo record);

    int updateByPrimaryKey(WelfareNewsInfoDo record);
}