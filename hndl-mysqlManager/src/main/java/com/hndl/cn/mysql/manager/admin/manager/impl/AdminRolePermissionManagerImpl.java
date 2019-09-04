package com.hndl.cn.mysql.manager.admin.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.admin.bean.AdminRolePermissionInfoDo;
import com.hndl.cn.dao.admin.bean.AdminRolePermissionInfoDoExample;
import com.hndl.cn.dao.admin.mapper.AdminRolePermissionInfoMapper;
import com.hndl.cn.mysql.manager.admin.manager.AdminRolePermissionManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 11:26
 * @Created by 湖南达联
 */
@Service
public class AdminRolePermissionManagerImpl implements AdminRolePermissionManager {

    @Resource
    private AdminRolePermissionInfoMapper adminRolePermissionInfoMapper;

    @Override
    public void addRolePermission(Long roleId, Long permissionId, Long loginUserId) {
        AdminRolePermissionInfoDo infoDo = new AdminRolePermissionInfoDo();
        Date now = new Date();
        infoDo.setAdminRoleId(roleId);
        infoDo.setAdminPermissionId(permissionId);
        infoDo.setCreateUserId(loginUserId);
        infoDo.setCreateTime(now);
        infoDo.setUpdateUserId(loginUserId);
        infoDo.setUpdateTime(now);
        infoDo.setIsDelete(IsValidEnums.NO.getValue());
        adminRolePermissionInfoMapper.insert(infoDo);
    }

    @Override
    public void removeRolePermission(Long roleId, Long permissionId, Long loginUserId) {
        AdminRolePermissionInfoDoExample example = new AdminRolePermissionInfoDoExample();
        example.createCriteria().andAdminRoleIdEqualTo(roleId).andAdminPermissionIdEqualTo(permissionId)
                .andIsDeleteEqualTo(IsValidEnums.NO.getValue());

        AdminRolePermissionInfoDo infoDo = new AdminRolePermissionInfoDo();
        infoDo.setIsDelete(IsValidEnums.YES.getValue());
        infoDo.setUpdateTime(new Date());
        infoDo.setUpdateUserId(loginUserId);
        adminRolePermissionInfoMapper.updateByExampleSelective(infoDo,example);
    }

    @Override
    public List<AdminRolePermissionInfoDo> findRolePermissionByRoleIdList(List<Long> roleIdList) {
        AdminRolePermissionInfoDoExample example = new AdminRolePermissionInfoDoExample();
        example.createCriteria().andAdminRoleIdIn(roleIdList)
                .andIsDeleteEqualTo(IsValidEnums.NO.getValue());
        return adminRolePermissionInfoMapper.selectByExample(example);
    }

    @Override
    public List<AdminRolePermissionInfoDo> findRolePermissionByRoleId(Long roleId) {
        AdminRolePermissionInfoDoExample example = new AdminRolePermissionInfoDoExample();
        example.createCriteria().andAdminRoleIdEqualTo(roleId)
                .andIsDeleteEqualTo(IsValidEnums.NO.getValue());
        return adminRolePermissionInfoMapper.selectByExample(example);
    }

    @Override
    public boolean checkRolePermission(Long roleId, Long permissionId) {
        AdminRolePermissionInfoDoExample example = new AdminRolePermissionInfoDoExample();
        example.createCriteria().andAdminRoleIdEqualTo(roleId)
                .andAdminPermissionIdEqualTo(permissionId)
                .andIsDeleteEqualTo(IsValidEnums.NO.getValue());
        return adminRolePermissionInfoMapper.countByExample(example) > 0;
    }
}
