package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopItemLuckyNoDo;
import com.hndl.cn.dao.shop.bean.ShopItemLuckyNoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemLuckyNoDoMapper {
    long countByExample(ShopItemLuckyNoDoExample example);

    int deleteByExample(ShopItemLuckyNoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemLuckyNoDo record);

    int insertSelective(ShopItemLuckyNoDo record);

    List<ShopItemLuckyNoDo> selectByExample(ShopItemLuckyNoDoExample example);

    ShopItemLuckyNoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemLuckyNoDo record, @Param("example") ShopItemLuckyNoDoExample example);

    int updateByExample(@Param("record") ShopItemLuckyNoDo record, @Param("example") ShopItemLuckyNoDoExample example);

    int updateByPrimaryKeySelective(ShopItemLuckyNoDo record);

    int updateByPrimaryKey(ShopItemLuckyNoDo record);
}