package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopOrderInfoPayDo;
import com.hndl.cn.dao.shop.bean.ShopOrderInfoPayDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderInfoPayDoMapper {
    long countByExample(ShopOrderInfoPayDoExample example);

    int deleteByExample(ShopOrderInfoPayDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopOrderInfoPayDo record);

    int insertSelective(ShopOrderInfoPayDo record);

    List<ShopOrderInfoPayDo> selectByExample(ShopOrderInfoPayDoExample example);

    ShopOrderInfoPayDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopOrderInfoPayDo record, @Param("example") ShopOrderInfoPayDoExample example);

    int updateByExample(@Param("record") ShopOrderInfoPayDo record, @Param("example") ShopOrderInfoPayDoExample example);

    int updateByPrimaryKeySelective(ShopOrderInfoPayDo record);

    int updateByPrimaryKey(ShopOrderInfoPayDo record);
}