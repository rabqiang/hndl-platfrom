package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopAppDataDo;
import com.hndl.cn.dao.shop.bean.ShopAppDataDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopAppDataDoMapper {
    long countByExample(ShopAppDataDoExample example);

    int deleteByExample(ShopAppDataDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopAppDataDo record);

    int insertSelective(ShopAppDataDo record);

    List<ShopAppDataDo> selectByExample(ShopAppDataDoExample example);

    ShopAppDataDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopAppDataDo record, @Param("example") ShopAppDataDoExample example);

    int updateByExample(@Param("record") ShopAppDataDo record, @Param("example") ShopAppDataDoExample example);

    int updateByPrimaryKeySelective(ShopAppDataDo record);

    int updateByPrimaryKey(ShopAppDataDo record);
}