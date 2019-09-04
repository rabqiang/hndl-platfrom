package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TBaseRoleDo;
import com.hndl.cn.dao.system.bean.TBaseRoleDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TBaseRoleDoMapper {
    long countByExample(TBaseRoleDoExample example);

    int deleteByExample(TBaseRoleDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBaseRoleDo record);

    int insertSelective(TBaseRoleDo record);

    List<TBaseRoleDo> selectByExample(TBaseRoleDoExample example);

    TBaseRoleDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBaseRoleDo record, @Param("example") TBaseRoleDoExample example);

    int updateByExample(@Param("record") TBaseRoleDo record, @Param("example") TBaseRoleDoExample example);

    int updateByPrimaryKeySelective(TBaseRoleDo record);

    int updateByPrimaryKey(TBaseRoleDo record);
}