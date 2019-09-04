package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonRegbagConfigRecordDo;
import com.hndl.cn.dao.common.bean.CommonRegbagConfigRecordDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonRegbagConfigRecordDoMapper {
    long countByExample(CommonRegbagConfigRecordDoExample example);

    int deleteByExample(CommonRegbagConfigRecordDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonRegbagConfigRecordDo record);

    int insertSelective(CommonRegbagConfigRecordDo record);

    List<CommonRegbagConfigRecordDo> selectByExample(CommonRegbagConfigRecordDoExample example);

    CommonRegbagConfigRecordDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonRegbagConfigRecordDo record, @Param("example") CommonRegbagConfigRecordDoExample example);

    int updateByExample(@Param("record") CommonRegbagConfigRecordDo record, @Param("example") CommonRegbagConfigRecordDoExample example);

    int updateByPrimaryKeySelective(CommonRegbagConfigRecordDo record);

    int updateByPrimaryKey(CommonRegbagConfigRecordDo record);
}