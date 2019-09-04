package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerWhoComeRecordDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerWhoComeRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerWhoComeRecordDoMapper {
    long countByExample(ImsingerWhoComeRecordDoExample example);

    int deleteByExample(ImsingerWhoComeRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerWhoComeRecordDo record);

    int insertSelective(ImsingerWhoComeRecordDo record);

    List<ImsingerWhoComeRecordDo> selectByExample(ImsingerWhoComeRecordDoExample example);

    ImsingerWhoComeRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerWhoComeRecordDo record, @Param("example") ImsingerWhoComeRecordDoExample example);

    int updateByExample(@Param("record") ImsingerWhoComeRecordDo record, @Param("example") ImsingerWhoComeRecordDoExample example);

    int updateByPrimaryKeySelective(ImsingerWhoComeRecordDo record);

    int updateByPrimaryKey(ImsingerWhoComeRecordDo record);
}