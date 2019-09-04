package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopItemInfoImgDo;
import com.hndl.cn.dao.shop.bean.ShopItemInfoImgDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemInfoImgDoMapper {
    long countByExample(ShopItemInfoImgDoExample example);

    int deleteByExample(ShopItemInfoImgDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemInfoImgDo record);

    int insertSelective(ShopItemInfoImgDo record);

    List<ShopItemInfoImgDo> selectByExample(ShopItemInfoImgDoExample example);

    ShopItemInfoImgDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemInfoImgDo record, @Param("example") ShopItemInfoImgDoExample example);

    int updateByExample(@Param("record") ShopItemInfoImgDo record, @Param("example") ShopItemInfoImgDoExample example);

    int updateByPrimaryKeySelective(ShopItemInfoImgDo record);

    int updateByPrimaryKey(ShopItemInfoImgDo record);
}