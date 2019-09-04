package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TGoodsInfoDo;
import com.hndl.cn.dao.system.bean.TGoodsInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TGoodsInfoDoMapper {
    long countByExample(TGoodsInfoDoExample example);

    int deleteByExample(TGoodsInfoDoExample example);

    int deleteByPrimaryKey(String goodscode);

    int insert(TGoodsInfoDo record);

    int insertSelective(TGoodsInfoDo record);

    List<TGoodsInfoDo> selectByExample(TGoodsInfoDoExample example);

    TGoodsInfoDo selectByPrimaryKey(String goodscode);

    int updateByExampleSelective(@Param("record") TGoodsInfoDo record, @Param("example") TGoodsInfoDoExample example);

    int updateByExample(@Param("record") TGoodsInfoDo record, @Param("example") TGoodsInfoDoExample example);

    int updateByPrimaryKeySelective(TGoodsInfoDo record);

    int updateByPrimaryKey(TGoodsInfoDo record);
}