package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareTeamInfoDo;
import com.hndl.cn.dao.welfare.bean.WelfareTeamInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareTeamInfoDoMapper {
    long countByExample(WelfareTeamInfoDoExample example);

    int deleteByExample(WelfareTeamInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareTeamInfoDo record);

    int insertSelective(WelfareTeamInfoDo record);

    List<WelfareTeamInfoDo> selectByExample(WelfareTeamInfoDoExample example);

    WelfareTeamInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareTeamInfoDo record, @Param("example") WelfareTeamInfoDoExample example);

    int updateByExample(@Param("record") WelfareTeamInfoDo record, @Param("example") WelfareTeamInfoDoExample example);

    int updateByPrimaryKeySelective(WelfareTeamInfoDo record);

    int updateByPrimaryKey(WelfareTeamInfoDo record);
}