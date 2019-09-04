package com.hndl.cn.dao.common.mapper;

import com.hndl.cn.dao.common.bean.CommonUserAddressInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserAddressInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CommonUserAddressInfoDoMapper {
    long countByExample(CommonUserAddressInfoDoExample example);

    int deleteByExample(CommonUserAddressInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CommonUserAddressInfoDo record);

    int insertSelective(CommonUserAddressInfoDo record);

    List<CommonUserAddressInfoDo> selectByExample(CommonUserAddressInfoDoExample example);

    CommonUserAddressInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CommonUserAddressInfoDo record, @Param("example") CommonUserAddressInfoDoExample example);

    int updateByExample(@Param("record") CommonUserAddressInfoDo record, @Param("example") CommonUserAddressInfoDoExample example);

    int updateByPrimaryKeySelective(CommonUserAddressInfoDo record);

    int updateByPrimaryKey(CommonUserAddressInfoDo record);
}