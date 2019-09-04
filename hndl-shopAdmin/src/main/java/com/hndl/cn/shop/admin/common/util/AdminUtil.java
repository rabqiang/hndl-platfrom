package com.hndl.cn.shop.admin.common.util;

import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.shop.admin.common.constants.MgdAdminConstants;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.session.Session;

import java.util.Set;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/18 17:17
 * @Created by 湖南达联
 */
public class AdminUtil {


    public static AdminUserInfoDo getLoginUser(){
        Session session = SecurityUtils.getSubject().getSession();

        if(session == null){
            return null;
        }
        return (AdminUserInfoDo)session.getAttribute(MgdAdminConstants.LOGIN_USER_SESSION_KEY);
    }

    public static void setLoginUser(AdminUserInfoDo adminUserInfoDo){
        Session session = SecurityUtils.getSubject().getSession();

        if(session == null){
            return;
        }
        session.setAttribute(MgdAdminConstants.LOGIN_USER_SESSION_KEY,adminUserInfoDo);
    }

    public static Set<String> getLoginUserRole(){
        SimpleAuthorizationInfo attribute = getLoginUserSimpleAuthorizationInfo();
        if(attribute == null){
             return null;
        }
        return attribute.getRoles();
    }

    public static boolean loginUserContainsByRole(Long roleId){
        if(roleId == null){
           return false;
        }
        Set<String> loginUserRole = getLoginUserRole();
        if(CollectionUtils.isEmpty(loginUserRole)){
            return false;
        }
        return loginUserRole.contains(String.valueOf(roleId));
    }

    public static Set<String> getLoginUserPermission(){
        SimpleAuthorizationInfo attribute = getLoginUserSimpleAuthorizationInfo();
        if(attribute == null){
            return null;
        }
        return attribute.getStringPermissions();
    }


    public static void setLoginUserPermission(Set<String> permission){
        Session session = SecurityUtils.getSubject().getSession();
        if(session == null){
            return;
        }
        SimpleAuthorizationInfo attribute = getLoginUserSimpleAuthorizationInfo();
        if(attribute == null ){
            return;
        }
        attribute.setStringPermissions(permission);

        session.setAttribute(MgdAdminConstants.AUTHORIZATIONINFO,attribute);
    }


    public static void setLoginUserRole(Set<String> role){
        Session session = SecurityUtils.getSubject().getSession();
        if(session == null){
            return;
        }

        SimpleAuthorizationInfo attribute = getLoginUserSimpleAuthorizationInfo();
        if(attribute == null ){
            return;
        }
        attribute.setRoles(role);
        session.setAttribute(MgdAdminConstants.AUTHORIZATIONINFO,attribute);
    }

    public static boolean loginUserContainsByPermission(Long permissionId){

        if(permissionId == null){
            return false;
        }

        Set<String> loginUserPermission = getLoginUserPermission();
        if(CollectionUtils.isEmpty(loginUserPermission)){
            return false;
        }

        return loginUserPermission.contains(String.valueOf(permissionId));
    }

    private static SimpleAuthorizationInfo getLoginUserSimpleAuthorizationInfo(){

        Session session = SecurityUtils.getSubject().getSession();

        if(session == null){
            return null;
        }

        return (SimpleAuthorizationInfo) session.getAttribute(MgdAdminConstants.AUTHORIZATIONINFO);
    }
}
