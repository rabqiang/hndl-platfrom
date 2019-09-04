package com.hndl.cn.dao.admin.mapper;

import com.hndl.cn.dao.admin.bean.AdminUserRoleInfoDo;
import com.hndl.cn.dao.admin.bean.AdminUserRoleInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminUserRoleInfoMapper {
    long countByExample(AdminUserRoleInfoDoExample example);

    int deleteByExample(AdminUserRoleInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminUserRoleInfoDo record);

    int insertSelective(AdminUserRoleInfoDo record);

    List<AdminUserRoleInfoDo> selectByExample(AdminUserRoleInfoDoExample example);

    AdminUserRoleInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminUserRoleInfoDo record, @Param("example") AdminUserRoleInfoDoExample example);

    int updateByExample(@Param("record") AdminUserRoleInfoDo record, @Param("example") AdminUserRoleInfoDoExample example);

    int updateByPrimaryKeySelective(AdminUserRoleInfoDo record);

    int updateByPrimaryKey(AdminUserRoleInfoDo record);
}