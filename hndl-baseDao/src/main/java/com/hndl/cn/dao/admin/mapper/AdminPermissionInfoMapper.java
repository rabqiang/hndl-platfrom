package com.hndl.cn.dao.admin.mapper;

import com.hndl.cn.dao.admin.bean.AdminPermissionInfoDo;
import com.hndl.cn.dao.admin.bean.AdminPermissionInfoDoExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminPermissionInfoMapper {
    long countByExample(AdminPermissionInfoDoExample example);

    int deleteByExample(AdminPermissionInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminPermissionInfoDo record);

    int insertSelective(AdminPermissionInfoDo record);

    List<AdminPermissionInfoDo> selectByExample(AdminPermissionInfoDoExample example);

    AdminPermissionInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminPermissionInfoDo record, @Param("example") AdminPermissionInfoDoExample example);

    int updateByExample(@Param("record") AdminPermissionInfoDo record, @Param("example") AdminPermissionInfoDoExample example);

    int updateByPrimaryKeySelective(AdminPermissionInfoDo record);

    int updateByPrimaryKey(AdminPermissionInfoDo record);
}