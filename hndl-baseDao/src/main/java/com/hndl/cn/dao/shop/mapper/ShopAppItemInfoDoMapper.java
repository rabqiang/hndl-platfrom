package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopAppItemInfoDo;
import com.hndl.cn.dao.shop.bean.ShopAppItemInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopAppItemInfoDoMapper {
    long countByExample(ShopAppItemInfoDoExample example);

    int deleteByExample(ShopAppItemInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopAppItemInfoDo record);

    int insertSelective(ShopAppItemInfoDo record);

    List<ShopAppItemInfoDo> selectByExample(ShopAppItemInfoDoExample example);

    ShopAppItemInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopAppItemInfoDo record, @Param("example") ShopAppItemInfoDoExample example);

    int updateByExample(@Param("record") ShopAppItemInfoDo record, @Param("example") ShopAppItemInfoDoExample example);

    int updateByPrimaryKeySelective(ShopAppItemInfoDo record);

    int updateByPrimaryKey(ShopAppItemInfoDo record);
}