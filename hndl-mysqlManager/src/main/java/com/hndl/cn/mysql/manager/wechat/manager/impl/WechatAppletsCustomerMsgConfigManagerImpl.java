package com.hndl.cn.mysql.manager.wechat.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.wechat.bean.WechatAppletsCustomerMsgConfigDo;
import com.hndl.cn.dao.wechat.bean.WechatAppletsCustomerMsgConfigDoExample;
import com.hndl.cn.dao.wechat.mapper.WechatAppletsCustomerMsgConfigDoMapper;
import com.hndl.cn.mysql.manager.wechat.manager.WechatAppletsCustomerMsgConfigManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/8/26 15:46
 * @Created by 湖南达联
 */
@Service
public class WechatAppletsCustomerMsgConfigManagerImpl implements WechatAppletsCustomerMsgConfigManager {

    @Resource
    private WechatAppletsCustomerMsgConfigDoMapper wechatAppletsCustomerMsgConfigDoMapper;

    @Override
    public WechatAppletsCustomerMsgConfigDo findMsgByContent(Integer msgType, String content) {
        WechatAppletsCustomerMsgConfigDoExample example = new WechatAppletsCustomerMsgConfigDoExample();
        WechatAppletsCustomerMsgConfigDoExample.Criteria criteria = example.createCriteria();
        criteria.andClientMsgTypeEqualTo(msgType);
        criteria.andClientMsgEqualTo(content);
        criteria.andIsDeleteEqualTo(IsValidEnums.NO.getValue());
        List<WechatAppletsCustomerMsgConfigDo> wechatAppletsCustomerMsgConfigDos = wechatAppletsCustomerMsgConfigDoMapper.selectByExample(example);
        return CollectionUtils.isEmpty(wechatAppletsCustomerMsgConfigDos) ? null : wechatAppletsCustomerMsgConfigDos.get(0);
    }

    @Override
    public void inserWechatAppletsCustomerMsgConfig(WechatAppletsCustomerMsgConfigDo msgConfigDo) {
        msgConfigDo.setCreateTime(new Date());
        msgConfigDo.setUpdateUserId(msgConfigDo.getCreateUserId()); //因为是第一次创建最后修改人就是创建人
        msgConfigDo.setUpdateTime(new Date());                      //时间也是如此
        msgConfigDo.setIsDelete(IsValidEnums.NO.getValue());
        wechatAppletsCustomerMsgConfigDoMapper.insertSelective(msgConfigDo);
    }

    @Override
    public void updateWechatAppletesCustomerMsgConfigById(WechatAppletsCustomerMsgConfigDo msgConfigDo) {
        msgConfigDo.setUpdateTime(new Date());
        wechatAppletsCustomerMsgConfigDoMapper.updateByPrimaryKeySelective(msgConfigDo);
    }

    @Override
    public void deleteWechatAppletesCustomerMsgById(Long id) {
        wechatAppletsCustomerMsgConfigDoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<WechatAppletsCustomerMsgConfigDo> findWechatAppletesCustomerMsgAll(Integer msgType, Long createUserId, Integer staTime, Integer endTime) {
        WechatAppletsCustomerMsgConfigDoExample example = new WechatAppletsCustomerMsgConfigDoExample();
        WechatAppletsCustomerMsgConfigDoExample.Criteria criteria = example.createCriteria();
        criteria.andIsDeleteEqualTo(IsValidEnums.NO.getValue());
        if (msgType != null) {
            criteria.andClientMsgTypeEqualTo(msgType);
        }
        if (createUserId != null) {
            criteria.andCreateUserIdbigEqualTo(createUserId);
        }
        example.setOrderByClause(" id asc");
        PageHelper.startPage(staTime, endTime);
        List<WechatAppletsCustomerMsgConfigDo> msgConfigDos = wechatAppletsCustomerMsgConfigDoMapper.selectByExample(example);
        PageInfo<WechatAppletsCustomerMsgConfigDo> pageInfo = new PageInfo<>(msgConfigDos);
        return null != pageInfo.getList() ? pageInfo.getList() : null;
    }
}
