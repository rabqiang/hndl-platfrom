package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemAttackIpDo;
import com.hndl.cn.dao.system.bean.SystemAttackIpDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemAttackIpDoMapper {
    long countByExample(SystemAttackIpDoExample example);

    int deleteByExample(SystemAttackIpDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemAttackIpDo record);

    int insertSelective(SystemAttackIpDo record);

    List<SystemAttackIpDo> selectByExample(SystemAttackIpDoExample example);

    SystemAttackIpDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemAttackIpDo record, @Param("example") SystemAttackIpDoExample example);

    int updateByExample(@Param("record") SystemAttackIpDo record, @Param("example") SystemAttackIpDoExample example);

    int updateByPrimaryKeySelective(SystemAttackIpDo record);

    int updateByPrimaryKey(SystemAttackIpDo record);
}