package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonUserGetPrizeInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserGetPrizeInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonUserGetPrizeInfoDoMapper {
    long countByExample(CommonUserGetPrizeInfoDoExample example);

    int deleteByExample(CommonUserGetPrizeInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonUserGetPrizeInfoDo record);

    int insertSelective(CommonUserGetPrizeInfoDo record);

    List<CommonUserGetPrizeInfoDo> selectByExample(CommonUserGetPrizeInfoDoExample example);

    CommonUserGetPrizeInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonUserGetPrizeInfoDo record, @Param("example") CommonUserGetPrizeInfoDoExample example);

    int updateByExample(@Param("record") CommonUserGetPrizeInfoDo record, @Param("example") CommonUserGetPrizeInfoDoExample example);

    int updateByPrimaryKeySelective(CommonUserGetPrizeInfoDo record);

    int updateByPrimaryKey(CommonUserGetPrizeInfoDo record);
}