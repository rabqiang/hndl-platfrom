package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopItemTempletDo;
import com.hndl.cn.dao.shop.bean.ShopItemTempletDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemTempletDoMapper {
    long countByExample(ShopItemTempletDoExample example);

    int deleteByExample(ShopItemTempletDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemTempletDo record);

    int insertSelective(ShopItemTempletDo record);

    List<ShopItemTempletDo> selectByExample(ShopItemTempletDoExample example);

    ShopItemTempletDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemTempletDo record, @Param("example") ShopItemTempletDoExample example);

    int updateByExample(@Param("record") ShopItemTempletDo record, @Param("example") ShopItemTempletDoExample example);

    int updateByPrimaryKeySelective(ShopItemTempletDo record);

    int updateByPrimaryKey(ShopItemTempletDo record);
}