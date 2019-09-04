package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.SystemItemIspushInfoDo;
import com.hndl.cn.dao.system.bean.SystemItemIspushInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SystemItemIspushInfoDoMapper {
    long countByExample(SystemItemIspushInfoDoExample example);

    int deleteByExample(SystemItemIspushInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SystemItemIspushInfoDo record);

    int insertSelective(SystemItemIspushInfoDo record);

    List<SystemItemIspushInfoDo> selectByExample(SystemItemIspushInfoDoExample example);

    SystemItemIspushInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") SystemItemIspushInfoDo record, @Param("example") SystemItemIspushInfoDoExample example);

    int updateByExample(@Param("record") SystemItemIspushInfoDo record, @Param("example") SystemItemIspushInfoDoExample example);

    int updateByPrimaryKeySelective(SystemItemIspushInfoDo record);

    int updateByPrimaryKey(SystemItemIspushInfoDo record);
}