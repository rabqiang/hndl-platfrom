package com.hndl.cn.dao.pay.mapper;

import com.hndl.cn.dao.pay.bean.RepairOrderLogsDo;
import com.hndl.cn.dao.pay.bean.RepairOrderLogsDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RepairOrderLogsMapper {
    long countByExample(RepairOrderLogsDoExample example);

    int deleteByExample(RepairOrderLogsDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(RepairOrderLogsDo record);

    int insertSelective(RepairOrderLogsDo record);

    List<RepairOrderLogsDo> selectByExample(RepairOrderLogsDoExample example);

    RepairOrderLogsDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") RepairOrderLogsDo record, @Param("example") RepairOrderLogsDoExample example);

    int updateByExample(@Param("record") RepairOrderLogsDo record, @Param("example") RepairOrderLogsDoExample example);

    int updateByPrimaryKeySelective(RepairOrderLogsDo record);

    int updateByPrimaryKey(RepairOrderLogsDo record);
}