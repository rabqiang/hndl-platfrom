package com.hndl.cn.mghd.admin.auth.user.service.impl;

import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminRoleInfoDo;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.auth.role.service.AdminPermissionService;
import com.hndl.cn.mghd.admin.auth.role.service.AdminRoleInfoService;
import com.hndl.cn.mghd.admin.auth.role.vo.MenuVo;
import com.hndl.cn.mghd.admin.auth.user.service.AdminUserInfoService;
import com.hndl.cn.mghd.admin.auth.user.vo.AddUserInfoVo;
import com.hndl.cn.mghd.admin.auth.user.vo.AdminUpdatePassWordVo;
import com.hndl.cn.mghd.admin.auth.user.vo.AdminUserMenuVo;
import com.hndl.cn.mghd.admin.auth.user.vo.AdminUserVo;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.mghd.admin.common.util.ShiroMD5Utils;
import com.hndl.cn.mghd.admin.common.vo.PageVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mysql.manager.admin.manager.AdminUserInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.md5.MD5Utils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/18 17:01
 * @Created by 湖南达联
 */
@Service
public class AdminUserInfoServiceImpl implements AdminUserInfoService {


    @Resource
    private AdminUserInfoManager adminUserInfoManager;

    @Resource
    private AdminRoleInfoService adminRoleInfoService;

    @Resource
    private AdminPermissionService adminPermissionService;

    @Resource
    private RedisService redisService;

    @Override
    public Result<Object> loginSuccess(String loginName,String ip) {
        AdminUserInfoDo userByLoginName = this.findUserByLoginName(loginName);
        AdminUtil.setLoginUser(userByLoginName);
        adminUserInfoManager.updateUserLoginIp(loginName, ip);
        AdminUserMenuVo adminUserMenuVo = new AdminUserMenuVo();
        adminUserMenuVo.setAdminUserVo(SpringCglibBeanUtils.convert(userByLoginName,AdminUserVo.class));
        adminUserMenuVo.setMenuVoList(adminPermissionService.getLoginUserMenu(userByLoginName.getId()));
        return ResultFactory.success(adminUserMenuVo);
    }


    @Override
    public AdminUserInfoDo findUserByLoginName(String loginName) {
        return adminUserInfoManager.findUserByLoginName(loginName);
    }

    @Override
    public AdminUserInfoDo findUserById(Long userId) {
        return adminUserInfoManager.findUserById(userId);
    }

    @Override
    public Result<Object> addAdminUserInfo(AddUserInfoVo vo,Long loginUserId) {
        AdminUserInfoDo userByLoginName = this.findUserByLoginName(vo.getLoginName());

        if(userByLoginName != null){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_LOGIN_NAME_EXCEPTION.getCode());
        }

        AdminUserInfoDo newUserInfo = SpringCglibBeanUtils.convert(vo,AdminUserInfoDo.class);
        String passWord = StringUtils.getRandomString();
        newUserInfo.setPassWord(ShiroMD5Utils.encryptPassword(vo.getLoginName(),passWord));
        newUserInfo.setCreateUserId(loginUserId);
        newUserInfo.setUpdateUserId(loginUserId);
        newUserInfo.setMaxWeight(0);
        adminUserInfoManager.addUserInfo(newUserInfo);

        return ResultFactory.success(passWord);
    }

    @Override
    public Result<Object> updateAdminUserInfoState(String loginName,Long loginUserId,Integer isDelete) {

        AdminUserInfoDo userByLoginName = this.findUserByLoginName(loginName);

        if(userByLoginName == null){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_USER_NOT_FIND_EXCEPTION.getCode());
        }

        //检查用户权限
        adminRoleInfoService.checkUserRoleWeight(loginUserId,userByLoginName.getId());

        adminUserInfoManager.removeAdminUserInfo(loginName,loginUserId,isDelete);

        return ResultFactory.success();
    }



    @Override
    public Result<Object> updatePassWord(AdminUpdatePassWordVo vo) {
        AdminUserInfoDo userInfoDo = AdminUtil.getLoginUser();
        if(!ShiroMD5Utils.encryptPassword(userInfoDo.getLoginName(),vo.getOldPassWord()).equals(userInfoDo.getPassWord())){
            throw new MghdAdminException(PublicExceptionCodeEnum.EX_LOGIN_USER_PWD_ERROR.getCode());
        }
        userInfoDo.setId(userInfoDo.getId());
        userInfoDo.setUpdateUserId(userInfoDo.getId());
        userInfoDo.setUpdateTime(new Date());
        userInfoDo.setPassWord(ShiroMD5Utils.encryptPassword(userInfoDo.getLoginName(),vo.getNewPassWord()));
        adminUserInfoManager.updateAdminUserInfoById(userInfoDo);
        return ResultFactory.success();
    }

    @Override
    public Result<Object> updateNickName(String nickName) {
        AdminUserInfoDo userInfoDo = AdminUtil.getLoginUser();
        userInfoDo.setId(userInfoDo.getId());
        userInfoDo.setUpdateUserId(userInfoDo.getId());
        userInfoDo.setUpdateTime(new Date());
        userInfoDo.setNickName(nickName);
        adminUserInfoManager.updateAdminUserInfoById(userInfoDo);
        AdminUtil.setLoginUser(userInfoDo);
        return ResultFactory.success();
    }

    @Override
    public Result<Object> updateMobile( String mobile) {
        AdminUserInfoDo userInfoDo = AdminUtil.getLoginUser();
        userInfoDo.setId(userInfoDo.getId());
        userInfoDo.setUpdateUserId(userInfoDo.getId());
        userInfoDo.setUpdateTime(new Date());
        userInfoDo.setMobile(mobile);
        adminUserInfoManager.updateAdminUserInfoById(userInfoDo);
        AdminUtil.setLoginUser(userInfoDo);
        return ResultFactory.success();
    }

    @Override
    public Result<Object> updateEmail(String email) {
        AdminUserInfoDo userInfoDo = AdminUtil.getLoginUser();
        userInfoDo.setId(userInfoDo.getId());
        userInfoDo.setUpdateUserId(userInfoDo.getId());
        userInfoDo.setUpdateTime(new Date());
        userInfoDo.setEmail(email);
        adminUserInfoManager.updateAdminUserInfoById(userInfoDo);
        AdminUtil.setLoginUser(userInfoDo);
        return ResultFactory.success();
    }

    @Override
    public Result<Object> refreshUserPassWord(String loginName,Long loginUserId) {
        AdminUserInfoDo userByLoginName = this.findUserByLoginName(loginName);
        if(userByLoginName == null){
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_USER_NOT_FIND_EXCEPTION.getCode());
        }
        //检查用户权限
        adminRoleInfoService.checkUserRoleWeight(loginUserId,userByLoginName.getId());
        String passWord = StringUtils.getRandomString();
        userByLoginName.setPassWord(ShiroMD5Utils.encryptPassword(userByLoginName.getLoginName(),passWord));
        userByLoginName.setUpdateTime(new Date());
        userByLoginName.setUpdateUserId(loginUserId);
        adminUserInfoManager.updateAdminUserInfoById(userByLoginName);
        return ResultFactory.success(passWord);
    }

    @Override
    public Result<Object> findUserInfoPage(Long userId, String loginName, Integer pageNo,Integer isDelete) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        PageInfo<AdminUserInfoDo> adminUserPage = adminUserInfoManager.findAdminUserPage(userId, loginName,loginUser.getMaxWeight(), pageNo,isDelete);
        PageVo page = new PageVo();
        page.setDataList(SpringCglibBeanUtils.convertByList(adminUserPage.getList(), AdminUserVo.class));
        page.setTotal(adminUserPage.getTotal());
        return ResultFactory.success(page);
    }

    @Override
    public Result<Object> checkLoginName(String loginName) {
        return  ResultFactory.success(this.findUserByLoginName(loginName)== null ? false:true);
    }

    @Override
    public void updateUserWeight(Long userId,Long loginUserId, Integer weight) {
        adminUserInfoManager.updateUserWeight(userId,loginUserId,weight);
    }
}
