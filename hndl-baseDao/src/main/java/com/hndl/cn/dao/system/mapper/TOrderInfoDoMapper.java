package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TOrderInfoDo;
import com.hndl.cn.dao.system.bean.TOrderInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TOrderInfoDoMapper {
    long countByExample(TOrderInfoDoExample example);

    int deleteByExample(TOrderInfoDoExample example);

    int deleteByPrimaryKey(String orderid);

    int insert(TOrderInfoDo record);

    int insertSelective(TOrderInfoDo record);

    List<TOrderInfoDo> selectByExample(TOrderInfoDoExample example);

    TOrderInfoDo selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") TOrderInfoDo record, @Param("example") TOrderInfoDoExample example);

    int updateByExample(@Param("record") TOrderInfoDo record, @Param("example") TOrderInfoDoExample example);

    int updateByPrimaryKeySelective(TOrderInfoDo record);

    int updateByPrimaryKey(TOrderInfoDo record);
}