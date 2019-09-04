package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.SpOrderCallbackInfoDo;
import com.hndl.cn.dao.shop.bean.SpOrderCallbackInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SpOrderCallbackInfoDoMapper {
    long countByExample(SpOrderCallbackInfoDoExample example);

    int deleteByExample(SpOrderCallbackInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SpOrderCallbackInfoDo record);

    int insertSelective(SpOrderCallbackInfoDo record);

    List<SpOrderCallbackInfoDo> selectByExample(SpOrderCallbackInfoDoExample example);

    SpOrderCallbackInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SpOrderCallbackInfoDo record, @Param("example") SpOrderCallbackInfoDoExample example);

    int updateByExample(@Param("record") SpOrderCallbackInfoDo record, @Param("example") SpOrderCallbackInfoDoExample example);

    int updateByPrimaryKeySelective(SpOrderCallbackInfoDo record);

    int updateByPrimaryKey(SpOrderCallbackInfoDo record);
}