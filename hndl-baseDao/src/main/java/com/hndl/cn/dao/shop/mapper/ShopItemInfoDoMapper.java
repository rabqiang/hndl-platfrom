package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopItemInfoDo;
import com.hndl.cn.dao.shop.bean.ShopItemInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemInfoDoMapper {
    long countByExample(ShopItemInfoDoExample example);

    int deleteByExample(ShopItemInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemInfoDo record);

    int insertSelective(ShopItemInfoDo record);

    List<ShopItemInfoDo> selectByExample(ShopItemInfoDoExample example);

    ShopItemInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemInfoDo record, @Param("example") ShopItemInfoDoExample example);

    int updateByExample(@Param("record") ShopItemInfoDo record, @Param("example") ShopItemInfoDoExample example);

    int updateByPrimaryKeySelective(ShopItemInfoDo record);

    int updateByPrimaryKey(ShopItemInfoDo record);
}