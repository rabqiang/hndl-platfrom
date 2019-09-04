package com.hndl.cn.dao.imsinger.mapper;

import com.hndl.cn.dao.imsinger.bean.ImsingerPensonEnrollRecordDo;
import com.hndl.cn.dao.imsinger.bean.ImsingerPensonEnrollRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImsingerPensonEnrollRecordDoMapper {
    long countByExample(ImsingerPensonEnrollRecordDoExample example);

    int deleteByExample(ImsingerPensonEnrollRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ImsingerPensonEnrollRecordDo record);

    int insertSelective(ImsingerPensonEnrollRecordDo record);

    List<ImsingerPensonEnrollRecordDo> selectByExample(ImsingerPensonEnrollRecordDoExample example);

    ImsingerPensonEnrollRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ImsingerPensonEnrollRecordDo record, @Param("example") ImsingerPensonEnrollRecordDoExample example);

    int updateByExample(@Param("record") ImsingerPensonEnrollRecordDo record, @Param("example") ImsingerPensonEnrollRecordDoExample example);

    int updateByPrimaryKeySelective(ImsingerPensonEnrollRecordDo record);

    int updateByPrimaryKey(ImsingerPensonEnrollRecordDo record);
}