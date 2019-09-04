package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopItemTypeDo;
import com.hndl.cn.dao.shop.bean.ShopItemTypeDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemTypeDoMapper {
    long countByExample(ShopItemTypeDoExample example);

    int deleteByExample(ShopItemTypeDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemTypeDo record);

    int insertSelective(ShopItemTypeDo record);

    List<ShopItemTypeDo> selectByExample(ShopItemTypeDoExample example);

    ShopItemTypeDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemTypeDo record, @Param("example") ShopItemTypeDoExample example);

    int updateByExample(@Param("record") ShopItemTypeDo record, @Param("example") ShopItemTypeDoExample example);

    int updateByPrimaryKeySelective(ShopItemTypeDo record);

    int updateByPrimaryKey(ShopItemTypeDo record);
}