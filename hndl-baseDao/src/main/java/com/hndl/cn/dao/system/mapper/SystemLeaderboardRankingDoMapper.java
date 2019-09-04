package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemLeaderboardRankingDo;
import com.hndl.cn.dao.system.bean.SystemLeaderboardRankingDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemLeaderboardRankingDoMapper {
    long countByExample(SystemLeaderboardRankingDoExample example);

    int deleteByExample(SystemLeaderboardRankingDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemLeaderboardRankingDo record);

    int insertSelective(SystemLeaderboardRankingDo record);

    List<SystemLeaderboardRankingDo> selectByExample(SystemLeaderboardRankingDoExample example);

    SystemLeaderboardRankingDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemLeaderboardRankingDo record, @Param("example") SystemLeaderboardRankingDoExample example);

    int updateByExample(@Param("record") SystemLeaderboardRankingDo record, @Param("example") SystemLeaderboardRankingDoExample example);

    int updateByPrimaryKeySelective(SystemLeaderboardRankingDo record);

    int updateByPrimaryKey(SystemLeaderboardRankingDo record);
}