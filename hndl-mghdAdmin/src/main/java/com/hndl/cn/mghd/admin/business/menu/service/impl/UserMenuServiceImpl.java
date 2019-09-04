package com.hndl.cn.mghd.admin.business.menu.service.impl;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserMenuInfoDo;
import com.hndl.cn.mghd.admin.business.menu.service.UserMenuService;
import com.hndl.cn.mghd.admin.business.menu.vo.UserMenuVo;
import com.hndl.cn.mghd.admin.common.enums.MgHdRedisKeyEnums;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mysql.manager.common.manager.CommonUserMenuInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/5 14 46
 * @Description:
 * @Author: 资龙茂
 */
@Service
public class UserMenuServiceImpl implements UserMenuService {

    @Resource
    private RedisService redisService;

    @Resource
    private CommonUserMenuInfoManager commonUserMenuInfoManager;

    @Override
    public Result<Object> findUserMenuInfo() {
        List<CommonUserMenuInfoDo> commonUserMenuInfoDoList = commonUserMenuInfoManager.selectUserMenuInfo();
        if (commonUserMenuInfoDoList == null || commonUserMenuInfoDoList.size() < 1) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_USER_MENU_NOTFOUND.getCode());
        }
        List<UserMenuVo> userMenuVoList = SpringCglibBeanUtils.convertByList(commonUserMenuInfoDoList, UserMenuVo.class);
        return ResultFactory.success(userMenuVoList);
    }

    @Override
    public Result<Object> findUserMenuInfoSingle(Long id) {
        CommonUserMenuInfoDo commonUserMenuInfoDo = commonUserMenuInfoManager.findMenuInfoById(id);
        checkObjectIsNull(commonUserMenuInfoDo);
        return ResultFactory.success(commonUserMenuInfoDo);
    }

    @Override
    public Result<Object> deleteUserMenuById(AdminUserInfoDo adminUserInfoDo, Long id) {
        CommonUserMenuInfoDo commonUserMenuInfoDo = commonUserMenuInfoManager.findMenuInfoById(id);
        checkObjectIsNull(commonUserMenuInfoDo);
        commonUserMenuInfoDo.setLastModifyTime(new Date());
        commonUserMenuInfoDo.setLastOperator(adminUserInfoDo.getLoginName());
        commonUserMenuInfoDo.setIsDeleted("y");
        commonUserMenuInfoManager.updateUserMenuInfo(commonUserMenuInfoDo);

        refreshUserMenuRedis();
        return ResultFactory.success();
    }

    @Override
    public Result<Object> addUserMenu(AdminUserInfoDo adminUserInfoDo, UserMenuVo userMenuVo) {
        CommonUserMenuInfoDo commonUserMenuInfoDo = new CommonUserMenuInfoDo();
        checkObjectValue(userMenuVo);
        commonUserMenuInfoDo.setCreateOperator(adminUserInfoDo.getLoginName());
        commonUserMenuInfoDo.setCreateTime(new Date());
        setValue(adminUserInfoDo, userMenuVo, commonUserMenuInfoDo);
        commonUserMenuInfoManager.addUserMenuInfo(commonUserMenuInfoDo);

        refreshUserMenuRedis();
        return ResultFactory.success();
    }

    @Override
    public Result<Object> updateUserMenu(AdminUserInfoDo adminUserInfoDo, UserMenuVo userMenuVo) {
        CommonUserMenuInfoDo commonUserMenuInfoDo = commonUserMenuInfoManager.findMenuInfoById(userMenuVo.getId());
        checkObjectIsNull(commonUserMenuInfoDo);
        checkObjectValue(userMenuVo);
        setValue(adminUserInfoDo, userMenuVo, commonUserMenuInfoDo);
        commonUserMenuInfoManager.updateUserMenuInfo(commonUserMenuInfoDo);

        refreshUserMenuRedis();
        return ResultFactory.success();
    }

    /**
     * 检查对象是否为空
     * @param commonUserMenuInfoDo
     */
    private void checkObjectIsNull(CommonUserMenuInfoDo commonUserMenuInfoDo) {
        if (commonUserMenuInfoDo == null) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_USER_MENU_NOTFOUND.getCode());
        }
    }

    /**
     * 检查参数是否正确
     * @param userMenuVo
     */
    private void checkObjectValue(UserMenuVo userMenuVo) {
        if (userMenuVo.getImgUrl() == null || userMenuVo.getIsIosHide() == null || userMenuVo.getTitle() == null) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_USER_MENU_DATA_ERROR.getCode());
        }
    }

    /**
     * 赋值操作
     * @param adminUserInfoDo
     * @param userMenuVo
     * @param commonUserMenuInfoDo
     */
    private void setValue(AdminUserInfoDo adminUserInfoDo, UserMenuVo userMenuVo, CommonUserMenuInfoDo commonUserMenuInfoDo) {
        commonUserMenuInfoDo.setLastModifyTime(new Date());
        commonUserMenuInfoDo.setLastOperator(adminUserInfoDo.getLoginName());
        commonUserMenuInfoDo.setImgUrl(userMenuVo.getImgUrl());
        commonUserMenuInfoDo.setIsIosHide(userMenuVo.getIsIosHide());
        commonUserMenuInfoDo.setOrderNumber(userMenuVo.getOrderNumber());
        commonUserMenuInfoDo.setTitle(userMenuVo.getTitle());
        commonUserMenuInfoDo.setToUrl(userMenuVo.getToUrl());
    }

    /**
     * 刷新个人中心菜单的redis数据
     */
    public void refreshUserMenuRedis() {
        String key = MgHdRedisKeyEnums.MENU_CACHE_KEY.getCacheKey();
        List<CommonUserMenuInfoDo> commonUserMenuInfoDoList = commonUserMenuInfoManager.selectUserMenuInfo();
        redisService.set(key, commonUserMenuInfoDoList, MgHdRedisKeyEnums.MENU_CACHE_KEY.getExpireTime());
    }
}
