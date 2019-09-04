package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopAppItemCountDo;
import com.hndl.cn.dao.shop.bean.ShopAppItemCountDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopAppItemCountDoMapper {
    long countByExample(ShopAppItemCountDoExample example);

    int deleteByExample(ShopAppItemCountDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopAppItemCountDo record);

    int insertSelective(ShopAppItemCountDo record);

    List<ShopAppItemCountDo> selectByExample(ShopAppItemCountDoExample example);

    ShopAppItemCountDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopAppItemCountDo record, @Param("example") ShopAppItemCountDoExample example);

    int updateByExample(@Param("record") ShopAppItemCountDo record, @Param("example") ShopAppItemCountDoExample example);

    int updateByPrimaryKeySelective(ShopAppItemCountDo record);

    int updateByPrimaryKey(ShopAppItemCountDo record);
}