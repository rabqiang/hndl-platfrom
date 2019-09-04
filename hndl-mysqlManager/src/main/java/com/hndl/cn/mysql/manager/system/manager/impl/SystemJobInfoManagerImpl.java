package com.hndl.cn.mysql.manager.system.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.system.bean.SystemJobInfoDo;
import com.hndl.cn.dao.system.bean.SystemJobInfoDoExample;
import com.hndl.cn.dao.system.mapper.SystemJobInfoDoMapper;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description
 * @Date 2019/4/26 13:43
 * @Created by 湖南达联
 */
@Service
public class SystemJobInfoManagerImpl implements SystemJobInfoManager {

    @Resource
    private SystemJobInfoDoMapper systemJobInfoDoMapper;





    @Override
    public SystemJobInfoDo findByJobName(String jobName) {
        SystemJobInfoDoExample example = new SystemJobInfoDoExample();
        SystemJobInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andJobNameEqualTo(jobName);
        criteria.andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        List<SystemJobInfoDo> systemJobInfoDos = systemJobInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(systemJobInfoDos) ? null : systemJobInfoDos.get(0);
    }

    @Override
    public boolean updateJobStatus(String jobName,String jobStatus) {
        SystemJobInfoDoExample example = new SystemJobInfoDoExample();
        SystemJobInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andJobNameEqualTo(jobName);
        criteria.andIsDeletedEqualTo(IsValidEnums.NO.getOldValue());
        SystemJobInfoDo systemJobInfoDo = new SystemJobInfoDo();
        systemJobInfoDo.setStatus(jobStatus);
        systemJobInfoDo.setLastModifyTime(new Date());
        return systemJobInfoDoMapper.updateByExampleSelective(systemJobInfoDo,example) > 0;
    }

    @Override
    public boolean insertSystemJob(SystemJobInfoDo systemJobInfoDo) {
        systemJobInfoDo.setCreateTime(new Date());
        systemJobInfoDo.setIsDeleted(IsValidEnums.NO.getOldValue());
        return systemJobInfoDoMapper.insert(systemJobInfoDo) > 0;
    }

    @Override
    public boolean deleteSystemJob(String jobName, IsValidEnums isValidEnums) {
        SystemJobInfoDoExample example = new SystemJobInfoDoExample();
        SystemJobInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andJobNameEqualTo(jobName);
        SystemJobInfoDo systemJobInfoDo = new SystemJobInfoDo();
        systemJobInfoDo.setIsDeleted(IsValidEnums.NO.getOldValue());
        return systemJobInfoDoMapper.updateByExampleSelective(systemJobInfoDo,example) > 0;
    }
}
