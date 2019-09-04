package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TBaseOperatorDo;
import com.hndl.cn.dao.system.bean.TBaseOperatorDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TBaseOperatorDoMapper {
    long countByExample(TBaseOperatorDoExample example);

    int deleteByExample(TBaseOperatorDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBaseOperatorDo record);

    int insertSelective(TBaseOperatorDo record);

    List<TBaseOperatorDo> selectByExample(TBaseOperatorDoExample example);

    TBaseOperatorDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBaseOperatorDo record, @Param("example") TBaseOperatorDoExample example);

    int updateByExample(@Param("record") TBaseOperatorDo record, @Param("example") TBaseOperatorDoExample example);

    int updateByPrimaryKeySelective(TBaseOperatorDo record);

    int updateByPrimaryKey(TBaseOperatorDo record);
}