package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareGameRankDo;
import com.hndl.cn.dao.welfare.bean.WelfareGameRankDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareGameRankDoMapper {
    long countByExample(WelfareGameRankDoExample example);

    int deleteByExample(WelfareGameRankDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareGameRankDo record);

    int insertSelective(WelfareGameRankDo record);

    List<WelfareGameRankDo> selectByExample(WelfareGameRankDoExample example);

    WelfareGameRankDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareGameRankDo record, @Param("example") WelfareGameRankDoExample example);

    int updateByExample(@Param("record") WelfareGameRankDo record, @Param("example") WelfareGameRankDoExample example);

    int updateByPrimaryKeySelective(WelfareGameRankDo record);

    int updateByPrimaryKey(WelfareGameRankDo record);
}