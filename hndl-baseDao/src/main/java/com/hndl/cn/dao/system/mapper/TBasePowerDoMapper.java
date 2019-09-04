package com.hndl.cn.dao.system.mapper;

import com.hndl.cn.dao.system.bean.TBasePowerDo;
import com.hndl.cn.dao.system.bean.TBasePowerDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TBasePowerDoMapper {
    long countByExample(TBasePowerDoExample example);

    int deleteByExample(TBasePowerDoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBasePowerDo record);

    int insertSelective(TBasePowerDo record);

    List<TBasePowerDo> selectByExample(TBasePowerDoExample example);

    TBasePowerDo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBasePowerDo record, @Param("example") TBasePowerDoExample example);

    int updateByExample(@Param("record") TBasePowerDo record, @Param("example") TBasePowerDoExample example);

    int updateByPrimaryKeySelective(TBasePowerDo record);

    int updateByPrimaryKey(TBasePowerDo record);
}