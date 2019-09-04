package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TBaseOperatelogDo;
import com.hndl.cn.dao.system.bean.TBaseOperatelogDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TBaseOperatelogDoMapper {
    long countByExample(TBaseOperatelogDoExample example);

    int deleteByExample(TBaseOperatelogDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBaseOperatelogDo record);

    int insertSelective(TBaseOperatelogDo record);

    List<TBaseOperatelogDo> selectByExample(TBaseOperatelogDoExample example);

    TBaseOperatelogDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBaseOperatelogDo record, @Param("example") TBaseOperatelogDoExample example);

    int updateByExample(@Param("record") TBaseOperatelogDo record, @Param("example") TBaseOperatelogDoExample example);

    int updateByPrimaryKeySelective(TBaseOperatelogDo record);

    int updateByPrimaryKey(TBaseOperatelogDo record);
}