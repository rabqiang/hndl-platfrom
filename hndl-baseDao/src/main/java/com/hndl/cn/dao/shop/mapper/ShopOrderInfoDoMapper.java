package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopOrderInfoDo;
import com.hndl.cn.dao.shop.bean.ShopOrderInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderInfoDoMapper {
    long countByExample(ShopOrderInfoDoExample example);

    int deleteByExample(ShopOrderInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopOrderInfoDo record);

    int insertSelective(ShopOrderInfoDo record);

    List<ShopOrderInfoDo> selectByExample(ShopOrderInfoDoExample example);

    ShopOrderInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopOrderInfoDo record, @Param("example") ShopOrderInfoDoExample example);

    int updateByExample(@Param("record") ShopOrderInfoDo record, @Param("example") ShopOrderInfoDoExample example);

    int updateByPrimaryKeySelective(ShopOrderInfoDo record);

    int updateByPrimaryKey(ShopOrderInfoDo record);
}