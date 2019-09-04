package com.hndl.cn.mysql.manager.star.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.star.bean.StarActivityInfoDo;
import com.hndl.cn.dao.star.bean.StarActivityInfoDoExample;
import com.hndl.cn.dao.star.mapper.StarActivityInfoDoMapper;
import com.hndl.cn.mysql.manager.star.manager.StarActivityInfoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StarActivityInfoManagerImpl implements StarActivityInfoManager {

   @Resource
   private StarActivityInfoDoMapper starActivityInfoDoMapper;

    @Override
    public List<StarActivityInfoDo> findActivity(String typeKey,Long pageStart,Integer pageSize) {
        StarActivityInfoDoExample example= new StarActivityInfoDoExample();
        PageHelper.startPage(pageStart.intValue(),pageSize,"order_num DESC");
        example.createCriteria().andIsDeletedEqualTo(IsValidEnums.NO.getOldValue()).andTypeKeyEqualTo(typeKey);
        List<StarActivityInfoDo> starActivityInfoDos = starActivityInfoDoMapper.selectByExample(example);
        PageInfo<StarActivityInfoDo> starActivityInfoDoPageInfo = new PageInfo<>(starActivityInfoDos);
        return null == starActivityInfoDoPageInfo ? new ArrayList<>(1): starActivityInfoDoPageInfo.getList();
    }
}
