package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerWhoLeaveRecordDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerWhoLeaveRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerWhoLeaveRecordDoMapper {
    long countByExample(ImsingerWhoLeaveRecordDoExample example);

    int deleteByExample(ImsingerWhoLeaveRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerWhoLeaveRecordDo record);

    int insertSelective(ImsingerWhoLeaveRecordDo record);

    List<ImsingerWhoLeaveRecordDo> selectByExample(ImsingerWhoLeaveRecordDoExample example);

    ImsingerWhoLeaveRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerWhoLeaveRecordDo record, @Param("example") ImsingerWhoLeaveRecordDoExample example);

    int updateByExample(@Param("record") ImsingerWhoLeaveRecordDo record, @Param("example") ImsingerWhoLeaveRecordDoExample example);

    int updateByPrimaryKeySelective(ImsingerWhoLeaveRecordDo record);

    int updateByPrimaryKey(ImsingerWhoLeaveRecordDo record);
}