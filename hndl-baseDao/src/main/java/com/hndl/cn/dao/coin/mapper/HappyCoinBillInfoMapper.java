package com.hndl.cn.dao.coin.mapper;

import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDoExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface HappyCoinBillInfoMapper {
    long countByExample(HappyCoinBillInfoDoExample example);

    int deleteByExample(HappyCoinBillInfoDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HappyCoinBillInfoDo record);

    int insertSelective(HappyCoinBillInfoDo record);

    List<HappyCoinBillInfoDo> selectByExample(HappyCoinBillInfoDoExample example);

    HappyCoinBillInfoDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HappyCoinBillInfoDo record, @Param("example") HappyCoinBillInfoDoExample example);

    int updateByExample(@Param("record") HappyCoinBillInfoDo record, @Param("example") HappyCoinBillInfoDoExample example);

    int updateByPrimaryKeySelective(HappyCoinBillInfoDo record);

    int updateByPrimaryKey(HappyCoinBillInfoDo record);

    Long queryCountByExample(HappyCoinBillInfoDoExample example);

    Long queryBillSum(HappyCoinBillInfoDoExample example);

    Long queryUserCount(HappyCoinBillInfoDoExample example);
}