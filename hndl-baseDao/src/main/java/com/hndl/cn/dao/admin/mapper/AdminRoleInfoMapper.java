package com.hndl.cn.dao.admin.mapper;

import com.hndl.cn.dao.admin.bean.AdminRoleInfoDo;
import com.hndl.cn.dao.admin.bean.AdminRoleInfoDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRoleInfoMapper {
    long countByExample(AdminRoleInfoDoExample example);

    int deleteByExample(AdminRoleInfoDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AdminRoleInfoDo record);

    int insertSelective(AdminRoleInfoDo record);

    List<AdminRoleInfoDo> selectByExample(AdminRoleInfoDoExample example);

    AdminRoleInfoDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AdminRoleInfoDo record, @Param("example") AdminRoleInfoDoExample example);

    int updateByExample(@Param("record") AdminRoleInfoDo record, @Param("example") AdminRoleInfoDoExample example);

    int updateByPrimaryKeySelective(AdminRoleInfoDo record);

    int updateByPrimaryKey(AdminRoleInfoDo record);
}