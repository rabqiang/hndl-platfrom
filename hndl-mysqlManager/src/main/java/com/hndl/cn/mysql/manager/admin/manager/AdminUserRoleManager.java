package com.hndl.cn.mysql.manager.admin.manager;

import com.hndl.cn.dao.admin.bean.AdminUserRoleInfoDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/21 10:51
 * @Created by 湖南达联
 */
public interface AdminUserRoleManager {


    /**
     * 查询用户关联的角色
     * @param userId
     * @return
     */
    List<AdminUserRoleInfoDo> findUserRoleByUserId(Long userId);




    /**
     * 检查是否添加
     * @param userId
     * @param roleId
     * @return
     */
    boolean checkUserRole(Long userId,Long roleId);


    /**
     * 添加用户与角色的关系
     */
    void addUserRole(Long userId,Long roleId,Long loginUserId);


    /**
     * 移除关系
     * @param userId
     * @param roleId
     */
    void removeUserRole(Long userId,Long roleId,Long loginUserId);
}
