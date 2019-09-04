package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareDonateRecordDo;
import com.hndl.cn.dao.welfare.bean.WelfareDonateRecordDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WelfareDonateRecordDoMapper {
    long countByExample(WelfareDonateRecordDoExample example);

    int deleteByExample(WelfareDonateRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareDonateRecordDo record);

    int insertSelective(WelfareDonateRecordDo record);

    List<WelfareDonateRecordDo> selectByExample(WelfareDonateRecordDoExample example);

    WelfareDonateRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareDonateRecordDo record, @Param("example") WelfareDonateRecordDoExample example);

    int updateByExample(@Param("record") WelfareDonateRecordDo record, @Param("example") WelfareDonateRecordDoExample example);

    int updateByPrimaryKeySelective(WelfareDonateRecordDo record);

    int updateByPrimaryKey(WelfareDonateRecordDo record);

    //统计-今天这个队伍捐赠次数
    int countTodayTeamDonateSize(@Param("teamId") Long teamId,@Param("createDate") String createDate);
}