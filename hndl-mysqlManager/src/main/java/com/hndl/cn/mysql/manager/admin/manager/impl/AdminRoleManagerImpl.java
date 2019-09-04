package com.hndl.cn.mysql.manager.admin.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.admin.bean.AdminRoleInfoDo;
import com.hndl.cn.dao.admin.bean.AdminRoleInfoDoExample;
import com.hndl.cn.dao.admin.mapper.AdminRoleInfoMapper;
import com.hndl.cn.mysql.manager.admin.manager.AdminRoleManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/20 20:34
 * @Created by 湖南达联
 */
@Service
public class AdminRoleManagerImpl implements AdminRoleManager {

    @Resource
    private AdminRoleInfoMapper adminRoleInfoMapper;

    @Override
    public void addRole(AdminRoleInfoDo adminRoleInfoDo) {
        adminRoleInfoDo.setIsDelete(IsValidEnums.NO.getValue());
        adminRoleInfoDo.setCreateTime(new Date());
        adminRoleInfoDo.setUpdateTime(new Date());
        adminRoleInfoMapper.insert(adminRoleInfoDo);
    }

    @Override
    public void delRole(Long id,Long loginUserId) {
        AdminRoleInfoDo adminRoleInfoDo = new AdminRoleInfoDo();
        adminRoleInfoDo.setId(id);
        adminRoleInfoDo.setUpdateUserId(loginUserId);
        adminRoleInfoDo.setUpdateTime(new Date());
        adminRoleInfoDo.setIsDelete(IsValidEnums.YES.getValue());
        adminRoleInfoMapper.updateByPrimaryKeySelective(adminRoleInfoDo);
    }

    @Override
    public PageInfo<AdminRoleInfoDo> findRoleByPage(Integer maxLoginWeight,Integer pageNo) {
        AdminRoleInfoDoExample example = new AdminRoleInfoDoExample();
        example.createCriteria().andRoleWeightLessThan(maxLoginWeight);
        example.setOrderByClause("id ASC");
        PageHelper.startPage(pageNo, BaseConstants.DEFAULT_LIMIT);
        List<AdminRoleInfoDo> adminRoleInfoDos = adminRoleInfoMapper.selectByExample(example);
        return new PageInfo(adminRoleInfoDos);
    }

    @Override
    public void updateRole() {

    }

    @Override
    public AdminRoleInfoDo findRoleById(Long id) {
        AdminRoleInfoDoExample example = new AdminRoleInfoDoExample();
        AdminRoleInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        criteria.andIsDeleteEqualTo(IsValidEnums.NO.getValue());
        List<AdminRoleInfoDo> adminRoleInfoDos = adminRoleInfoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(adminRoleInfoDos) ? null : adminRoleInfoDos.get(0);
    }

    @Override
    public List<AdminRoleInfoDo> findRoleByIdList(List<Long> idList) {
        AdminRoleInfoDoExample example = new AdminRoleInfoDoExample();
        AdminRoleInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andIdIn(idList);
        criteria.andIsDeleteEqualTo(IsValidEnums.NO.getValue());
        example.setOrderByClause("id ASC");
        return adminRoleInfoMapper.selectByExample(example);
    }

    @Override
    public List<AdminRoleInfoDo> findAll() {
        return adminRoleInfoMapper.selectByExample(new AdminRoleInfoDoExample());
    }

    @Override
    public boolean checkRoleName(String roleName) {
        AdminRoleInfoDoExample example = new AdminRoleInfoDoExample();
        AdminRoleInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo(roleName);
        return adminRoleInfoMapper.countByExample(example) > 0;
    }


}
