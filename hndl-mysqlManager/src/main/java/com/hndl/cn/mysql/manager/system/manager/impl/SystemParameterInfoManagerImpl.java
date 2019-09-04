package com.hndl.cn.mysql.manager.system.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.system.bean.SystemParameterInfoDo;
import com.hndl.cn.dao.system.bean.SystemParameterInfoDoExample;
import com.hndl.cn.dao.system.mapper.SystemParameterInfoDoMapper;
import com.hndl.cn.mysql.manager.system.manager.SystemParameterInfoManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class SystemParameterInfoManagerImpl implements SystemParameterInfoManager {

    @Resource
    private SystemParameterInfoDoMapper systemParameterInfoDoMapper;

    @Override
    public SystemParameterInfoDo findByParameterName(String parameterName){
        SystemParameterInfoDoExample example=new SystemParameterInfoDoExample();
        example.createCriteria().andParameterNameEqualTo(parameterName).andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        List<SystemParameterInfoDo> systemParameterInfoDos = systemParameterInfoDoMapper.selectByExample(example);
        SystemParameterInfoDo systemParameterInfoDo=new SystemParameterInfoDo();
        if (CollectionUtils.isNotEmpty(systemParameterInfoDos)){
        systemParameterInfoDo= systemParameterInfoDoMapper.selectByExample(example).get(0);
        }
        return systemParameterInfoDo!=null?systemParameterInfoDo:null ;
    }

    /**
     *
     *
     * @param parameterName
     * @param value
     * @return
     */
    @Override
    public boolean updateValueByParameterName(String parameterName, String value) {
        SystemParameterInfoDoExample example=new SystemParameterInfoDoExample();
        example.createCriteria().andParameterNameEqualTo(parameterName);
        SystemParameterInfoDo systemParameterInfoDo = new SystemParameterInfoDo();
        systemParameterInfoDo.setLastModifyTime(new Date());
        systemParameterInfoDo.setParameterValue(value);
        return  systemParameterInfoDoMapper.updateByExampleSelective(systemParameterInfoDo,example) > 0;
    }

    @Override
    public SystemParameterInfoDo selectByKey(String key) {
        SystemParameterInfoDoExample example = new SystemParameterInfoDoExample();
        SystemParameterInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andParameterNameEqualTo(key);
        List<SystemParameterInfoDo> systemParameterInfoDos = systemParameterInfoDoMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(systemParameterInfoDos)){
            return null;
        }
        return systemParameterInfoDos.get(0);
    }
}
