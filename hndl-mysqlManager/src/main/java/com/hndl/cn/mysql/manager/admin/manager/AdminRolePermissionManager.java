package com.hndl.cn.mysql.manager.admin.manager;

import com.hndl.cn.dao.admin.bean.AdminRolePermissionInfoDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 11:21
 * @Created by 湖南达联
 */
public interface AdminRolePermissionManager {

    /**
     * 添加关系
     */
    void addRolePermission(Long roleId,Long permissionId,Long loginUserId);


    /**
     * 移除关系
     */
    void removeRolePermission(Long roleId,Long permissionId,Long loginUserId);

    /**
     *
     * @return
     */
    List<AdminRolePermissionInfoDo> findRolePermissionByRoleIdList(List<Long> roleIdList);


    /**
     * ID 查询关系
     * @param roleId
     * @return
     */
    List<AdminRolePermissionInfoDo> findRolePermissionByRoleId(Long roleId);


    /**
     * 查询是否存在
     * @param roleId
     * @param permissionId
     * @return
     */
    boolean checkRolePermission(Long roleId,Long permissionId);
}
