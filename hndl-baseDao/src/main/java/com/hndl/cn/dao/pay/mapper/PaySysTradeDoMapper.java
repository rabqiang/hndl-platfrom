package com.hndl.cn.dao.pay.mapper;

import com.hndl.cn.dao.pay.bean.PaySysTradeDo;
import com.hndl.cn.dao.pay.bean.PaySysTradeDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaySysTradeDoMapper {
    long countByExample(PaySysTradeDoExample example);

    int deleteByExample(PaySysTradeDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PaySysTradeDo record);

    int insertSelective(PaySysTradeDo record);

    List<PaySysTradeDo> selectByExample(PaySysTradeDoExample example);

    PaySysTradeDo selectByPrimaryKey(Integer id);

    long countmoneyNumber(PaySysTradeDoExample example);

    int updateByExampleSelective(@Param("record") PaySysTradeDo record, @Param("example") PaySysTradeDoExample example);

    int updateByExample(@Param("record") PaySysTradeDo record, @Param("example") PaySysTradeDoExample example);

    int updateByPrimaryKeySelective(PaySysTradeDo record);

    int updateByPrimaryKey(PaySysTradeDo record);
}