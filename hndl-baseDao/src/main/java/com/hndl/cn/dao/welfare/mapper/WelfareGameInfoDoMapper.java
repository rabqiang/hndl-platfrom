package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareGameInfoDo;
import com.hndl.cn.dao.welfare.bean.WelfareGameInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareGameInfoDoMapper {
    long countByExample(WelfareGameInfoDoExample example);

    int deleteByExample(WelfareGameInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareGameInfoDo record);

    int insertSelective(WelfareGameInfoDo record);

    List<WelfareGameInfoDo> selectByExample(WelfareGameInfoDoExample example);

    WelfareGameInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareGameInfoDo record, @Param("example") WelfareGameInfoDoExample example);

    int updateByExample(@Param("record") WelfareGameInfoDo record, @Param("example") WelfareGameInfoDoExample example);

    int updateByPrimaryKeySelective(WelfareGameInfoDo record);

    int updateByPrimaryKey(WelfareGameInfoDo record);
}