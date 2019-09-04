package com.hndl.cn.dao.admin.mapper;

import com.hndl.cn.dao.admin.bean.AdminRolePermissionInfoDo;
import com.hndl.cn.dao.admin.bean.AdminRolePermissionInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRolePermissionInfoMapper {
    long countByExample(AdminRolePermissionInfoDoExample example);

    int deleteByExample(AdminRolePermissionInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminRolePermissionInfoDo record);

    int insertSelective(AdminRolePermissionInfoDo record);

    List<AdminRolePermissionInfoDo> selectByExample(AdminRolePermissionInfoDoExample example);

    AdminRolePermissionInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminRolePermissionInfoDo record, @Param("example") AdminRolePermissionInfoDoExample example);

    int updateByExample(@Param("record") AdminRolePermissionInfoDo record, @Param("example") AdminRolePermissionInfoDoExample example);

    int updateByPrimaryKeySelective(AdminRolePermissionInfoDo record);

    int updateByPrimaryKey(AdminRolePermissionInfoDo record);
}