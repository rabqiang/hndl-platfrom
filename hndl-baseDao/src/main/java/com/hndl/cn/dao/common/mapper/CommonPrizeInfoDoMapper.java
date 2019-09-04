package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonPrizeInfoDo;
import com.hndl.cn.dao.common.bean.CommonPrizeInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonPrizeInfoDoMapper {
    long countByExample(CommonPrizeInfoDoExample example);

    int deleteByExample(CommonPrizeInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonPrizeInfoDo record);

    int insertSelective(CommonPrizeInfoDo record);

    List<CommonPrizeInfoDo> selectByExample(CommonPrizeInfoDoExample example);

    CommonPrizeInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonPrizeInfoDo record, @Param("example") CommonPrizeInfoDoExample example);

    int updateByExample(@Param("record") CommonPrizeInfoDo record, @Param("example") CommonPrizeInfoDoExample example);

    int updateByPrimaryKeySelective(CommonPrizeInfoDo record);

    int updateByPrimaryKey(CommonPrizeInfoDo record);
}