package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TBaseConfigDo;
import com.hndl.cn.dao.system.bean.TBaseConfigDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TBaseConfigDoMapper {
    long countByExample(TBaseConfigDoExample example);

    int deleteByExample(TBaseConfigDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBaseConfigDo record);

    int insertSelective(TBaseConfigDo record);

    List<TBaseConfigDo> selectByExample(TBaseConfigDoExample example);

    TBaseConfigDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBaseConfigDo record, @Param("example") TBaseConfigDoExample example);

    int updateByExample(@Param("record") TBaseConfigDo record, @Param("example") TBaseConfigDoExample example);

    int updateByPrimaryKeySelective(TBaseConfigDo record);

    int updateByPrimaryKey(TBaseConfigDo record);
}