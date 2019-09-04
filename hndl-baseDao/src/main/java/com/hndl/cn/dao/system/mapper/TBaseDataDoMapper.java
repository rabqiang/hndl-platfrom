package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TBaseDataDo;
import com.hndl.cn.dao.system.bean.TBaseDataDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TBaseDataDoMapper {
    long countByExample(TBaseDataDoExample example);

    int deleteByExample(TBaseDataDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBaseDataDo record);

    int insertSelective(TBaseDataDo record);

    List<TBaseDataDo> selectByExample(TBaseDataDoExample example);

    TBaseDataDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBaseDataDo record, @Param("example") TBaseDataDoExample example);

    int updateByExample(@Param("record") TBaseDataDo record, @Param("example") TBaseDataDoExample example);

    int updateByPrimaryKeySelective(TBaseDataDo record);

    int updateByPrimaryKey(TBaseDataDo record);
}