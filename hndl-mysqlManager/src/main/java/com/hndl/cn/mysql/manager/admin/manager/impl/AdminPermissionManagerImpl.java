package com.hndl.cn.mysql.manager.admin.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.admin.bean.AdminPermissionInfoDo;
import com.hndl.cn.dao.admin.bean.AdminPermissionInfoDoExample;
import com.hndl.cn.dao.admin.mapper.AdminPermissionInfoMapper;
import com.hndl.cn.mysql.manager.admin.manager.AdminPermissionManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/21 15:10
 * @Created by 湖南达联
 */
@Service
public class AdminPermissionManagerImpl implements AdminPermissionManager {

    @Resource
    private AdminPermissionInfoMapper adminPermissionInfoMapper;


    @Override
    public void addPermission(AdminPermissionInfoDo adminPermissionInfoDo) {
        Date now = new Date();
        adminPermissionInfoDo.setCreateTime(now);
        adminPermissionInfoDo.setUpdateTime(now);
        adminPermissionInfoDo.setIsDelete(IsValidEnums.NO.getValue());
        adminPermissionInfoMapper.insert(adminPermissionInfoDo);
    }

    @Override
    public void delPermission(Long permissionId,Long loginUserId,IsValidEnums isValidEnums) {
        AdminPermissionInfoDo adminPermissionInfoDo = new AdminPermissionInfoDo();
        adminPermissionInfoDo.setId(permissionId);
        adminPermissionInfoDo.setIsDelete(isValidEnums.getValue());
        adminPermissionInfoDo.setUpdateTime(new Date());
        adminPermissionInfoDo.setUpdateUserId(loginUserId);
        adminPermissionInfoMapper.updateByPrimaryKeySelective(adminPermissionInfoDo);
    }

    @Override
    public void updatePermission(AdminPermissionInfoDo adminPermissionInfoDo) {
        adminPermissionInfoMapper.updateByPrimaryKeySelective(adminPermissionInfoDo);

    }

    @Override
    public PageInfo<AdminPermissionInfoDo> findPermissionByPage(Long pid, Integer pageNo,boolean isSort) {
        AdminPermissionInfoDoExample example = new AdminPermissionInfoDoExample();
        AdminPermissionInfoDoExample.Criteria criteria = example.createCriteria();

        if(pid != null){
            criteria.andPidEqualTo(pid);
        }

        if(isSort){
            example.setOrderByClause(" sort_num ASC ");
        }

        PageHelper.startPage(pageNo, BaseConstants.DEFAULT_LIMIT);
        List<AdminPermissionInfoDo> adminPermissionInfoDos = adminPermissionInfoMapper.selectByExample(example);
        return new PageInfo<>(adminPermissionInfoDos);
    }

    @Override
    public Integer getPermissionSortNum(Long pid) {
        AdminPermissionInfoDoExample example = new AdminPermissionInfoDoExample();
        example.setOrderByClause(" sort_num DESC ");
        example.setLimit(1);
        List<AdminPermissionInfoDo> adminPermissionInfoDos = adminPermissionInfoMapper.selectByExample(example);
        if(CollectionUtils.isNotEmpty(adminPermissionInfoDos)){
           return adminPermissionInfoDos.get(0).getSortNum() + 1;
        }else {
           return 1;
        }
    }

    @Override
    public void updateSotrNum(Long id, Integer sort) {

    }

    @Override
    public List<AdminPermissionInfoDo> findPermissionByIdList(List<Long> permissionIdList,Long pid) {
        AdminPermissionInfoDoExample example = new AdminPermissionInfoDoExample();
        AdminPermissionInfoDoExample.Criteria criteria = example.createCriteria().
                andIdIn(permissionIdList).andIsDeleteEqualTo(IsValidEnums.NO.getValue());
        if(pid != null){
            criteria.andPidNotEqualTo(pid);
         }

        return adminPermissionInfoMapper.selectByExample(example);
    }

    @Override
    public boolean checkPermission(Long id) {
        return  adminPermissionInfoMapper.selectByPrimaryKey(id) != null  ;
    }
}
