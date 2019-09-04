package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopOrderShowInfoDo;
import com.hndl.cn.dao.shop.bean.ShopOrderShowInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopOrderShowInfoDoMapper {
    long countByExample(ShopOrderShowInfoDoExample example);

    int deleteByExample(ShopOrderShowInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopOrderShowInfoDo record);

    int insertSelective(ShopOrderShowInfoDo record);

    List<ShopOrderShowInfoDo> selectByExample(ShopOrderShowInfoDoExample example);

    ShopOrderShowInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopOrderShowInfoDo record, @Param("example") ShopOrderShowInfoDoExample example);

    int updateByExample(@Param("record") ShopOrderShowInfoDo record, @Param("example") ShopOrderShowInfoDoExample example);

    int updateByPrimaryKeySelective(ShopOrderShowInfoDo record);

    int updateByPrimaryKey(ShopOrderShowInfoDo record);
}