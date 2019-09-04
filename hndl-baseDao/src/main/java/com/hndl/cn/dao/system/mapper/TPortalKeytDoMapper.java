package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TPortalKeytDo;
import com.hndl.cn.dao.system.bean.TPortalKeytDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TPortalKeytDoMapper {
    long countByExample(TPortalKeytDoExample example);

    int deleteByExample(TPortalKeytDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPortalKeytDo record);

    int insertSelective(TPortalKeytDo record);

    List<TPortalKeytDo> selectByExample(TPortalKeytDoExample example);

    TPortalKeytDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPortalKeytDo record, @Param("example") TPortalKeytDoExample example);

    int updateByExample(@Param("record") TPortalKeytDo record, @Param("example") TPortalKeytDoExample example);

    int updateByPrimaryKeySelective(TPortalKeytDo record);

    int updateByPrimaryKey(TPortalKeytDo record);
}