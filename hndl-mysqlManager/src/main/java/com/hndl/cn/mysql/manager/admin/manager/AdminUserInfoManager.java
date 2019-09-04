package com.hndl.cn.mysql.manager.admin.manager;

import com.github.pagehelper.PageInfo;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;

import java.util.Date;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/18 16:25
 * @Created by 湖南达联
 */
public interface AdminUserInfoManager {


    /**
     * 通过用户登陆名称查询用户
     * @param loginName
     * @return
     */
    AdminUserInfoDo findUserByLoginName(String loginName);


    /**
     * id查询用户
     * @param userId
     * @return
     */
    AdminUserInfoDo findUserById(Long userId);


    /**
     * 修改用户权限
     * @param userId
     * @param weight
     */
    void updateUserWeight(Long userId,Long loginUserId,Integer weight);


    /**
     * 修改用户最后一次登陆ip
     * @param loginName
     * @param ip
     * @return
     */
    boolean updateUserLoginIp(String loginName,String ip);


    /**
     * 添加用户
     * @param adminUserInfoDo
     */
    void  addUserInfo(AdminUserInfoDo adminUserInfoDo);


    /**
     * 修改用户
     */
    void  removeAdminUserInfo(String loginName,Long loginUserId,Integer isDelete);

    /**
     * 修改用户
     */
    void  updateAdminUserInfoById(AdminUserInfoDo adminUserInfoDo);


    /**
     * 分页查询后台用户
     * @param userId
     * @param loginName
     * @param pageNo
     * @return
     */
    PageInfo<AdminUserInfoDo> findAdminUserPage(Long userId,String loginName,Integer maxWeight,Integer pageNo,Integer isDelete);
}
