package com.hndl.cn.mysql.manager.common.manager.impl;

import com.hndl.cn.dao.common.bean.CommonUserMenuInfoDo;
import com.hndl.cn.dao.common.mapper.CommonUserMenuInfoDoMapper;
import com.hndl.cn.mysql.manager.common.manager.CommonUserMenuInfoManager;
import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import java.util.List;

@Service
public class CommonUserMenuInfoManagerImpl implements CommonUserMenuInfoManager {

    @Resource
    private CommonUserMenuInfoDoMapper commonUserMenuInfoDoMapper;

    @Override
    public List<CommonUserMenuInfoDo> selectUserMenuInfo(){
        return commonUserMenuInfoDoMapper.selectUserMenuInfo();
    }

    @Override
    public CommonUserMenuInfoDo findMenuInfoById(Long id) {
        return commonUserMenuInfoDoMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateUserMenuInfo(CommonUserMenuInfoDo commonUserMenuInfoDo) {
        return commonUserMenuInfoDoMapper.updateByPrimaryKey(commonUserMenuInfoDo);
    }

    @Override
    public int addUserMenuInfo(CommonUserMenuInfoDo commonUserMenuInfoDo) {
        return commonUserMenuInfoDoMapper.insertSelective(commonUserMenuInfoDo);
    }


}
