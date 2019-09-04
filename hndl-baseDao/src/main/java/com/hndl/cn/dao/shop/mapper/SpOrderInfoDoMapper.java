package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.SpOrderInfoDo;
import com.hndl.cn.dao.shop.bean.SpOrderInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpOrderInfoDoMapper {
    long countByExample(SpOrderInfoDoExample example);

    int deleteByExample(SpOrderInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpOrderInfoDo record);

    int insertSelective(SpOrderInfoDo record);

    List<SpOrderInfoDo> selectByExample(SpOrderInfoDoExample example);

    SpOrderInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpOrderInfoDo record, @Param("example") SpOrderInfoDoExample example);

    int updateByExample(@Param("record") SpOrderInfoDo record, @Param("example") SpOrderInfoDoExample example);

    int updateByPrimaryKeySelective(SpOrderInfoDo record);

    int updateByPrimaryKey(SpOrderInfoDo record);
}