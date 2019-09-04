package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TBasePowerRoleDo;
import com.hndl.cn.dao.system.bean.TBasePowerRoleDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TBasePowerRoleDoMapper {
    long countByExample(TBasePowerRoleDoExample example);

    int deleteByExample(TBasePowerRoleDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBasePowerRoleDo record);

    int insertSelective(TBasePowerRoleDo record);

    List<TBasePowerRoleDo> selectByExample(TBasePowerRoleDoExample example);

    TBasePowerRoleDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBasePowerRoleDo record, @Param("example") TBasePowerRoleDoExample example);

    int updateByExample(@Param("record") TBasePowerRoleDo record, @Param("example") TBasePowerRoleDoExample example);

    int updateByPrimaryKeySelective(TBasePowerRoleDo record);

    int updateByPrimaryKey(TBasePowerRoleDo record);
}