package com.hndl.cn.mysql.manager.admin.manager;

import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.admin.bean.AdminPermissionInfoDo;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/21 15:03
 * @Created by 湖南达联
 */
public interface AdminPermissionManager {


    /**
     * 增加权限
     */
    void addPermission(AdminPermissionInfoDo adminPermissionInfoDo);

    /**
     * 删除权限
     */
    void delPermission(Long permissionId, Long loginUserId, IsValidEnums isValidEnums);

    /**
     * 修改权限
     */
    void updatePermission(AdminPermissionInfoDo adminPermissionInfoDo);
    /**
     * 查询权限菜单
     * @param pid
     * @param pageNo
     * @return
     */
    PageInfo<AdminPermissionInfoDo> findPermissionByPage(Long pid,Integer pageNo,boolean isSort);


    /**
     * 查询排序值
     * @param pid
     * @return
     */
    Integer getPermissionSortNum(Long pid);

    /**
     * 修改排序值
     * @param id
     * @param sort
     */
    void updateSotrNum(Long id,Integer sort);


    /**
     * 查询权限菜单
     * @param permissionIdList
     * @return
     */
    List<AdminPermissionInfoDo> findPermissionByIdList(List<Long> permissionIdList,Long pid);


    /**
     * 校验是否存在
     * @param id
     * @return
     */
    boolean checkPermission(Long id);
}
