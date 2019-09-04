package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonPrizeCountDo;
import com.hndl.cn.dao.common.bean.CommonPrizeCountDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonPrizeCountDoMapper {
    long countByExample(CommonPrizeCountDoExample example);

    int deleteByExample(CommonPrizeCountDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonPrizeCountDo record);

    int insertSelective(CommonPrizeCountDo record);

    List<CommonPrizeCountDo> selectByExample(CommonPrizeCountDoExample example);

    CommonPrizeCountDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonPrizeCountDo record, @Param("example") CommonPrizeCountDoExample example);

    int updateByExample(@Param("record") CommonPrizeCountDo record, @Param("example") CommonPrizeCountDoExample example);

    int updateByPrimaryKeySelective(CommonPrizeCountDo record);

    int updateByPrimaryKey(CommonPrizeCountDo record);
}