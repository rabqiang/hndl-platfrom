package com.hndl.cn.dao.shop.mapper;

import com.hndl.cn.dao.shop.bean.ShopCrmUserDo;
import com.hndl.cn.dao.shop.bean.ShopCrmUserDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopCrmUserDoMapper {
    long countByExample(ShopCrmUserDoExample example);

    int deleteByExample(ShopCrmUserDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(ShopCrmUserDo record);

    int insertSelective(ShopCrmUserDo record);

    List<ShopCrmUserDo> selectByExample(ShopCrmUserDoExample example);

    ShopCrmUserDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") ShopCrmUserDo record, @Param("example") ShopCrmUserDoExample example);

    int updateByExample(@Param("record") ShopCrmUserDo record, @Param("example") ShopCrmUserDoExample example);

    int updateByPrimaryKeySelective(ShopCrmUserDo record);

    int updateByPrimaryKey(ShopCrmUserDo record);
}