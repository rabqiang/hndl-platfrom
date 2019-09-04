package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopItemTempletImgDo;
import com.hndl.cn.dao.shop.bean.ShopItemTempletImgDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopItemTempletImgDoMapper {
    long countByExample(ShopItemTempletImgDoExample example);

    int deleteByExample(ShopItemTempletImgDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopItemTempletImgDo record);

    int insertSelective(ShopItemTempletImgDo record);

    List<ShopItemTempletImgDo> selectByExample(ShopItemTempletImgDoExample example);

    ShopItemTempletImgDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopItemTempletImgDo record, @Param("example") ShopItemTempletImgDoExample example);

    int updateByExample(@Param("record") ShopItemTempletImgDo record, @Param("example") ShopItemTempletImgDoExample example);

    int updateByPrimaryKeySelective(ShopItemTempletImgDo record);

    int updateByPrimaryKey(ShopItemTempletImgDo record);
}