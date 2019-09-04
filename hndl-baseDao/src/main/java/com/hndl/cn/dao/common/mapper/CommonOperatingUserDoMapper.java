package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonOperatingUserDo;
import com.hndl.cn.dao.common.bean.CommonOperatingUserDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonOperatingUserDoMapper {
    long countByExample(CommonOperatingUserDoExample example);

    int deleteByExample(CommonOperatingUserDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonOperatingUserDo record);

    int insertSelective(CommonOperatingUserDo record);

    List<CommonOperatingUserDo> selectByExample(CommonOperatingUserDoExample example);

    CommonOperatingUserDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonOperatingUserDo record, @Param("example") CommonOperatingUserDoExample example);

    int updateByExample(@Param("record") CommonOperatingUserDo record, @Param("example") CommonOperatingUserDoExample example);

    int updateByPrimaryKeySelective(CommonOperatingUserDo record);

    int updateByPrimaryKey(CommonOperatingUserDo record);
}