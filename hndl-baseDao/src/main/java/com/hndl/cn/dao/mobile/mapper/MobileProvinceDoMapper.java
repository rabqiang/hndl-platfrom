package com.hndl.cn.dao.mobile.mapper;

import com.hndl.cn.dao.mobile.bean.MobileProvinceDo;
import com.hndl.cn.dao.mobile.bean.MobileProvinceDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MobileProvinceDoMapper {
    long countByExample(MobileProvinceDoExample example);

    int deleteByExample(MobileProvinceDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(MobileProvinceDo record);

    int insertSelective(MobileProvinceDo record);

    List<MobileProvinceDo> selectByExample(MobileProvinceDoExample example);

    MobileProvinceDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") MobileProvinceDo record, @Param("example") MobileProvinceDoExample example);

    int updateByExample(@Param("record") MobileProvinceDo record, @Param("example") MobileProvinceDoExample example);

    int updateByPrimaryKeySelective(MobileProvinceDo record);

    int updateByPrimaryKey(MobileProvinceDo record);
}