//package com.hndl.cn.mghd.admin.shiro;
//
//import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
//import AdminUserInfoService;
//import com.hndl.cn.mghd.admin.common.util.AdminUtil;
//import com.hndl.cn.utils.request.RequestUtil;
//import com.hndl.cn.utils.string.StringUtils;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.web.filter.PathMatchingFilter;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.Resource;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//
///**
// * @author 赵俊凯
// * @Description TODO
// * @Date 2019/6/19 17:32
// * @Created by 湖南达联
// */
//@Component
//public class MghdAdminUserFilter extends PathMatchingFilter {
//
//    @Resource
//    private AdminUserInfoService adminUserInfoService;
//
//
//    @Override
//    protected boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
//        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
//        if(loginUser == null){
//             String loginName = (String) SecurityUtils.getSubject().getPrincipal();
//             if(StringUtils.isBlank(loginName)){
//                  return true;
//             }
//
//            adminUserInfoService.updateUserLoginTimeAndIp(loginUser.getLoginName(), RequestUtil.getClientIP((HttpServletRequest) request));
//
//            loginUser =  adminUserInfoService.findUserByLoginName(loginName);
//        }
//        AdminUtil.setLoginUser(loginUser);
//        return true;
//    }
//}
