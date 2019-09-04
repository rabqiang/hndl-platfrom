package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemAttackInfoDo;
import com.hndl.cn.dao.system.bean.SystemAttackInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAttackInfoDoMapper {
    long countByExample(SystemAttackInfoDoExample example);

    int deleteByExample(SystemAttackInfoDoExample example);

    int deleteByPrimaryKey(String keyId);

    int insert(SystemAttackInfoDo record);

    int insertSelective(SystemAttackInfoDo record);

    List<SystemAttackInfoDo> selectByExample(SystemAttackInfoDoExample example);

    SystemAttackInfoDo selectByPrimaryKey(String keyId);

    int updateByExampleSelective(@Param("record") SystemAttackInfoDo record, @Param("example") SystemAttackInfoDoExample example);

    int updateByExample(@Param("record") SystemAttackInfoDo record, @Param("example") SystemAttackInfoDoExample example);

    int updateByPrimaryKeySelective(SystemAttackInfoDo record);

    int updateByPrimaryKey(SystemAttackInfoDo record);
}