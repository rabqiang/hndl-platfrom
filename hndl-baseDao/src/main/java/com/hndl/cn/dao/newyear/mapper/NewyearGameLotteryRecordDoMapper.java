package com.hndl.cn.dao.newyear.mapper;

import com.hndl.cn.dao.newyear.bean.NewyearGameLotteryRecordDo;
import com.hndl.cn.dao.newyear.bean.NewyearGameLotteryRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NewyearGameLotteryRecordDoMapper {
    long countByExample(NewyearGameLotteryRecordDoExample example);

    int deleteByExample(NewyearGameLotteryRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(NewyearGameLotteryRecordDo record);

    int insertSelective(NewyearGameLotteryRecordDo record);

    List<NewyearGameLotteryRecordDo> selectByExample(NewyearGameLotteryRecordDoExample example);

    NewyearGameLotteryRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") NewyearGameLotteryRecordDo record, @Param("example") NewyearGameLotteryRecordDoExample example);

    int updateByExample(@Param("record") NewyearGameLotteryRecordDo record, @Param("example") NewyearGameLotteryRecordDoExample example);

    int updateByPrimaryKeySelective(NewyearGameLotteryRecordDo record);

    int updateByPrimaryKey(NewyearGameLotteryRecordDo record);
}