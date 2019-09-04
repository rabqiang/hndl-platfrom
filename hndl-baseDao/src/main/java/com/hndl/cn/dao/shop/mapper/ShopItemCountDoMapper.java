package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopItemCountDo;
import com.hndl.cn.dao.shop.bean.ShopItemCountDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemCountDoMapper {
    long countByExample(ShopItemCountDoExample example);

    int deleteByExample(ShopItemCountDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemCountDo record);

    int insertSelective(ShopItemCountDo record);

    List<ShopItemCountDo> selectByExample(ShopItemCountDoExample example);

    ShopItemCountDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemCountDo record, @Param("example") ShopItemCountDoExample example);

    int updateByExample(@Param("record") ShopItemCountDo record, @Param("example") ShopItemCountDoExample example);

    int updateByPrimaryKeySelective(ShopItemCountDo record);

    int updateByPrimaryKey(ShopItemCountDo record);
}