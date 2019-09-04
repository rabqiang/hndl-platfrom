package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonGameLotteryRecordDo;
import com.hndl.cn.dao.common.bean.CommonGameLotteryRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonGameLotteryRecordDoMapper {
    long countByExample(CommonGameLotteryRecordDoExample example);

    int deleteByExample(CommonGameLotteryRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonGameLotteryRecordDo record);

    int insertSelective(CommonGameLotteryRecordDo record);

    List<CommonGameLotteryRecordDo> selectByExample(CommonGameLotteryRecordDoExample example);

    CommonGameLotteryRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonGameLotteryRecordDo record, @Param("example") CommonGameLotteryRecordDoExample example);

    int updateByExample(@Param("record") CommonGameLotteryRecordDo record, @Param("example") CommonGameLotteryRecordDoExample example);

    int updateByPrimaryKeySelective(CommonGameLotteryRecordDo record);

    int updateByPrimaryKey(CommonGameLotteryRecordDo record);
}