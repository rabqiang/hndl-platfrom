package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerGameLotteryRecordDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerGameLotteryRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerGameLotteryRecordDoMapper {
    long countByExample(ImsingerGameLotteryRecordDoExample example);

    int deleteByExample(ImsingerGameLotteryRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerGameLotteryRecordDo record);

    int insertSelective(ImsingerGameLotteryRecordDo record);

    List<ImsingerGameLotteryRecordDo> selectByExample(ImsingerGameLotteryRecordDoExample example);

    ImsingerGameLotteryRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerGameLotteryRecordDo record, @Param("example") ImsingerGameLotteryRecordDoExample example);

    int updateByExample(@Param("record") ImsingerGameLotteryRecordDo record, @Param("example") ImsingerGameLotteryRecordDoExample example);

    int updateByPrimaryKeySelective(ImsingerGameLotteryRecordDo record);

    int updateByPrimaryKey(ImsingerGameLotteryRecordDo record);
}