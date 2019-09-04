package com.hndl.cn.dao.welfare.mapper;

import com.hndl.cn.dao.welfare.bean.WelfareDonateCountDo;
import com.hndl.cn.dao.welfare.bean.WelfareDonateCountDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface WelfareDonateCountDoMapper {
    long countByExample(WelfareDonateCountDoExample example);

    int deleteByExample(WelfareDonateCountDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(WelfareDonateCountDo record);

    int insertSelective(WelfareDonateCountDo record);

    List<WelfareDonateCountDo> selectByExample(WelfareDonateCountDoExample example);

    WelfareDonateCountDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") WelfareDonateCountDo record, @Param("example") WelfareDonateCountDoExample example);

    int updateByExample(@Param("record") WelfareDonateCountDo record, @Param("example") WelfareDonateCountDoExample example);

    int updateByPrimaryKeySelective(WelfareDonateCountDo record);

    int updateByPrimaryKey(WelfareDonateCountDo record);
}