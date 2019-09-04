package com.hndl.cn.mysql.manager.system.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.system.bean.SystemAppMenuNewDo;
import com.hndl.cn.dao.system.bean.SystemAppMenuNewDoExample;
import com.hndl.cn.dao.system.mapper.SystemAppMenuNewDoMapper;
import com.hndl.cn.mysql.manager.system.manager.SystemAppMenuNewManager;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/23 15:59
 * @Created by 湖南达联
 */
@Service
public class SystemAppMenuNewManagerImpl implements SystemAppMenuNewManager {

    @Resource
    private SystemAppMenuNewDoMapper systemAppMenuNewDoMapper;


    @Override
    public List<SystemAppMenuNewDo> findAppHomeSystemAppMenu() {
        SystemAppMenuNewDoExample example = new SystemAppMenuNewDoExample();
        SystemAppMenuNewDoExample.Criteria  criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        example.setOrderByClause(" order_number desc ");
        return systemAppMenuNewDoMapper.selectByExample(example);
    }

    @Override
    public List<SystemAppMenuNewDo> findByAppMenu(SystemAppMenuNewDo systemAppMenuNewDo,Integer pageStart, Integer pageSize) {
        SystemAppMenuNewDoExample example = new SystemAppMenuNewDoExample();
        SystemAppMenuNewDoExample.Criteria  criteria = example.createCriteria();
        criteria.andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
         if (StringUtils.isNotBlank(systemAppMenuNewDo.getTitle())){
         criteria.andTitleEqualTo(systemAppMenuNewDo.getTitle());
         }
       if (StringUtils.isNotBlank(systemAppMenuNewDo.getMenuType())){
           criteria.andMenuTypeEqualTo(systemAppMenuNewDo.getMenuType());
       }
       if (StringUtils.isNotBlank(systemAppMenuNewDo.getIsSelect())){
           criteria.andIsSelectEqualTo(systemAppMenuNewDo.getIsSelect());
       }
        if (StringUtils.isNotBlank(systemAppMenuNewDo.getType())) {
           criteria.andTypeEqualTo(systemAppMenuNewDo.getType());
        }
        if (StringUtils.isNotBlank(systemAppMenuNewDo.getOther1())){
           criteria.andOther1EqualTo(systemAppMenuNewDo.getOther1());
        }
        if (StringUtils.isNotBlank(systemAppMenuNewDo.getOther2())){
            criteria.andOther1EqualTo(systemAppMenuNewDo.getOther2());
        }
        List<SystemAppMenuNewDo> systemAppMenuNewDoList= systemAppMenuNewDoMapper.selectByExample(example);
        PageHelper.startPage(pageStart,pageSize,"order_number DESC");
        PageInfo<SystemAppMenuNewDo> systemAppMenuNewDoPageInfo=new PageInfo<>(systemAppMenuNewDoList);

        return null==systemAppMenuNewDoPageInfo? new ArrayList<>():systemAppMenuNewDoPageInfo.getList();
        }


    @Override
    public List<SystemAppMenuNewDo> findPageAppHomeSystemAppMenu(Integer pageStart, Integer pageSize) {
        SystemAppMenuNewDoExample example = new SystemAppMenuNewDoExample();
        PageHelper.startPage(pageStart,pageSize,"order_number DESC");
        example.createCriteria().andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        List<SystemAppMenuNewDo> systemAppMenuNewDoList= systemAppMenuNewDoMapper.selectByExample(example);
        PageInfo<SystemAppMenuNewDo> systemAppMenuNewDoPageInfo=new PageInfo<>(systemAppMenuNewDoList);

        return null==systemAppMenuNewDoPageInfo? new ArrayList<>():systemAppMenuNewDoPageInfo.getList();
    }

    @Override
    public boolean saveAppMenu(SystemAppMenuNewDo systemAppMenuNewDo) {
         systemAppMenuNewDo.setCreateTime(new Date());
         systemAppMenuNewDo.setIsDeleted(IsValidEnums.NO.getOldValue());
        return systemAppMenuNewDoMapper.insertSelective(systemAppMenuNewDo)>0;
    }

    @Override
    public boolean updateAppMenu(SystemAppMenuNewDo systemAppMenuNewDo) {

        systemAppMenuNewDo.setLastModifyTime(new Date());
        return systemAppMenuNewDoMapper.updateByPrimaryKeySelective(systemAppMenuNewDo)>0;
    }
}
