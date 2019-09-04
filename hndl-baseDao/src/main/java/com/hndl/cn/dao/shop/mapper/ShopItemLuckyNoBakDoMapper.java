package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopItemLuckyNoBakDo;
import com.hndl.cn.dao.shop.bean.ShopItemLuckyNoBakDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemLuckyNoBakDoMapper {
    long countByExample(ShopItemLuckyNoBakDoExample example);

    int deleteByExample(ShopItemLuckyNoBakDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemLuckyNoBakDo record);

    int insertSelective(ShopItemLuckyNoBakDo record);

    List<ShopItemLuckyNoBakDo> selectByExample(ShopItemLuckyNoBakDoExample example);

    ShopItemLuckyNoBakDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemLuckyNoBakDo record, @Param("example") ShopItemLuckyNoBakDoExample example);

    int updateByExample(@Param("record") ShopItemLuckyNoBakDo record, @Param("example") ShopItemLuckyNoBakDoExample example);

    int updateByPrimaryKeySelective(ShopItemLuckyNoBakDo record);

    int updateByPrimaryKey(ShopItemLuckyNoBakDo record);
}