package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TOrderSendDo;
import com.hndl.cn.dao.system.bean.TOrderSendDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TOrderSendDoMapper {
    long countByExample(TOrderSendDoExample example);

    int deleteByExample(TOrderSendDoExample example);

    int deleteByPrimaryKey(String id);

    int insert(TOrderSendDo record);

    int insertSelective(TOrderSendDo record);

    List<TOrderSendDo> selectByExample(TOrderSendDoExample example);

    TOrderSendDo selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") TOrderSendDo record, @Param("example") TOrderSendDoExample example);

    int updateByExample(@Param("record") TOrderSendDo record, @Param("example") TOrderSendDoExample example);

    int updateByPrimaryKeySelective(TOrderSendDo record);

    int updateByPrimaryKey(TOrderSendDo record);
}