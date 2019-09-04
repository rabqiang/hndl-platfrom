package com.hndl.cn.mghd.admin.business.appMenu.service.impl;


import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.dao.system.bean.SystemAppMenuNewDo;
import com.hndl.cn.mghd.admin.business.appMenu.service.AdminAppMenuInfoService;
import com.hndl.cn.mghd.admin.business.appMenu.vo.SystemAppMenuNewVo;
import com.hndl.cn.mghd.admin.common.constants.MgdAdminConstants;
import com.hndl.cn.mghd.admin.common.util.AdminUtil;
import com.hndl.cn.mysql.manager.system.manager.SystemAppMenuNewManager;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年6月19日14:07:29
 * @Created by 湖南达联
 */
@Service
public class AdminAppMenuInfoServiceImpl implements AdminAppMenuInfoService {

    @Resource
    private SystemAppMenuNewManager systemAppMenuNewManager;

    @Override
    public List<SystemAppMenuNewVo> findPageAppMenu(Integer pageStart) {

        return SpringCglibBeanUtils.convertByList(systemAppMenuNewManager.findPageAppHomeSystemAppMenu(pageStart, MgdAdminConstants.PAGE_LIMIT), SystemAppMenuNewVo.class);
    }

    @Override
    public List<SystemAppMenuNewVo> findByAppMenu(SystemAppMenuNewVo systemAppMenuNewVo, Integer pageStart) {

        SystemAppMenuNewDo systemAppMenuNewDo = SpringCglibBeanUtils.convert(systemAppMenuNewVo, SystemAppMenuNewDo.class);
        List<SystemAppMenuNewDo> byAppMenu = systemAppMenuNewManager.findByAppMenu(systemAppMenuNewDo, pageStart, MgdAdminConstants.PAGE_LIMIT);
        return byAppMenu != null ? SpringCglibBeanUtils.convertByList(byAppMenu, SystemAppMenuNewVo.class) : new ArrayList<>();
    }

    @Override
    public boolean saveAppMenu(SystemAppMenuNewVo systemAppMenuNewVo) {

        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();

        SystemAppMenuNewDo systemAppMenuNewDo = SpringCglibBeanUtils.convert(systemAppMenuNewVo, SystemAppMenuNewDo.class);
        systemAppMenuNewDo.setCreateOperator(loginUser.getNickName());
        return systemAppMenuNewManager.saveAppMenu(systemAppMenuNewDo);
    }

    @Override
    public boolean updateAppMenu(SystemAppMenuNewVo systemAppMenuNewVo) {

        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();

        SystemAppMenuNewDo systemAppMenuNewDo = SpringCglibBeanUtils.convert(systemAppMenuNewVo, SystemAppMenuNewDo.class);
        systemAppMenuNewDo.setLastOperator(loginUser.getNickName());
        return systemAppMenuNewManager.updateAppMenu(systemAppMenuNewDo);
    }

    @Override
    public boolean removeAppMenu(Long id) {
        AdminUserInfoDo loginUser = AdminUtil.getLoginUser();
        SystemAppMenuNewDo systemAppMenuNewDo = new SystemAppMenuNewDo();
        systemAppMenuNewDo.setId(id);
        systemAppMenuNewDo.setLastOperator(loginUser.getNickName());
        systemAppMenuNewDo.setIsDeleted(IsValidEnums.YES.getOldValue());
        return systemAppMenuNewManager.updateAppMenu(systemAppMenuNewDo);
    }


}
