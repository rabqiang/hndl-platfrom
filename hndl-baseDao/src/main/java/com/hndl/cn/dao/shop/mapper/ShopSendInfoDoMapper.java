package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopSendInfoDo;
import com.hndl.cn.dao.shop.bean.ShopSendInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopSendInfoDoMapper {
    long countByExample(ShopSendInfoDoExample example);

    int deleteByExample(ShopSendInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopSendInfoDo record);

    int insertSelective(ShopSendInfoDo record);

    List<ShopSendInfoDo> selectByExample(ShopSendInfoDoExample example);

    ShopSendInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopSendInfoDo record, @Param("example") ShopSendInfoDoExample example);

    int updateByExample(@Param("record") ShopSendInfoDo record, @Param("example") ShopSendInfoDoExample example);

    int updateByPrimaryKeySelective(ShopSendInfoDo record);

    int updateByPrimaryKey(ShopSendInfoDo record);
}