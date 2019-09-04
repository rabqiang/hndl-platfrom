package com.hndl.cn.wechat.sys.business.user.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDoExample;
import com.hndl.cn.dao.common.mapper.CommonUserInfoDoMapper;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.wechat.sys.business.user.manager.CommonUserInfoManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description 用户实现类
 * @Date 2019/3/14 15:49
 * @Created by 湖南达联
 */
@Service
public class CommonUserInfoManagerImpl implements CommonUserInfoManager {

    @Resource
    private CommonUserInfoDoMapper commonUserInfoDoMapper;

    @Override
    public CommonUserInfoDo findUserByUserId(Long userId) {
        return commonUserInfoDoMapper.selectByPrimaryKey(userId);
    }

    @Override
    public CommonUserInfoDo findUserByXcxOpenId(String xcxOpenId) {

        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andXcxOpenIdEqualTo(xcxOpenId);
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public CommonUserInfoDo findUserByWeChatUniId(String weChatUniId) {

        CommonUserInfoDoExample example = new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = example.createCriteria();
        criteria.andWeixinUniIdEqualTo(weChatUniId);
        List<CommonUserInfoDo> commonUserInfoDos = commonUserInfoDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(commonUserInfoDos) ? null : commonUserInfoDos.get(0);
    }

    @Override
    public void addUserInfo(CommonUserInfoDo commonUserInfoDo) {
        commonUserInfoDoMapper.insert(commonUserInfoDo);
    }

    @Override
    public void updateUserInfo(CommonUserInfoDo commonUserInfoDo) {
        commonUserInfoDoMapper.updateByPrimaryKeySelective(commonUserInfoDo);
    }

    @Override
    public List<CommonUserInfoDo> findByUserPage(Integer pageNo, Integer pageSize) {

        PageHelper.startPage(pageNo,pageSize);

        List<CommonUserInfoDo> userInfoDos = commonUserInfoDoMapper.selectByExample(new CommonUserInfoDoExample());

        PageInfo<CommonUserInfoDo> pageInfo = new PageInfo<>(userInfoDos);

        return CollectionUtils.isEmpty(pageInfo.getList()) ? new ArrayList<>() : pageInfo.getList() ;
    }

    @Override
    public List<CommonUserInfoDo> findByUserPageByUniIdIsNull(Integer pageNo, Integer pageSize) {
        PageHelper.startPage(pageNo,pageSize);

        CommonUserInfoDoExample commonUserInfoDoExample =  new CommonUserInfoDoExample();
        CommonUserInfoDoExample.Criteria criteria = commonUserInfoDoExample.createCriteria();
        criteria.andSysUniIdIsNull();

        List<CommonUserInfoDo> userInfoDos = commonUserInfoDoMapper.selectByExample(commonUserInfoDoExample);

        PageInfo<CommonUserInfoDo> pageInfo = new PageInfo<>(userInfoDos);

        return CollectionUtils.isEmpty(pageInfo.getList()) ? new ArrayList<>() : pageInfo.getList() ;
    }


}
