package com.hndl.cn.mghd.admin.business.menu.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserMenuInfoDo;
import com.hndl.cn.mghd.admin.business.menu.vo.UserMenuVo;

import java.util.List;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/5 14 38
 * @Description:
 * @Author: 资龙茂
 */
public interface UserMenuService {
    /**
     * 查询个人中心菜单列表
     * @return
     */
    Result<Object> findUserMenuInfo();

    /**
     * 根据ID查询个人中心菜单详情
     * @param id
     * @return
     */
    Result<Object> findUserMenuInfoSingle(Long id);

    /**
     * 根据ID删除个人中心菜单
     * @param adminUserInfoDo
     * @param id
     * @return
     */
    Result<Object> deleteUserMenuById(AdminUserInfoDo adminUserInfoDo, Long id);

    /**
     * 添加个人中心菜单
     * @param adminUserInfoDo
     * @param userMenuVo
     * @return
     */
    Result<Object> addUserMenu(AdminUserInfoDo adminUserInfoDo, UserMenuVo userMenuVo);

    /**
     * 修改个人中心菜单
     * @param adminUserInfoDo
     * @param userMenuVo
     * @return
     */
    Result<Object> updateUserMenu(AdminUserInfoDo adminUserInfoDo, UserMenuVo userMenuVo);
}
