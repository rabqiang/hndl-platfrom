package com.hndl.cn.mongodb.manager.extend.manager.impl;

import com.hndl.cn.mongodb.manager.extend.bean.OtherWechatUserInfoDo;
import com.hndl.cn.mongodb.manager.extend.manager.OtherWechatUserInfoManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/28 18:51
 * @Created by 湖南达联
 */
@Service
public class OtherWechatUserInfoManagerImpl implements OtherWechatUserInfoManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public boolean isExist(Long userUniId, String channelName) {
        Query query = new Query(Criteria.where("userUniId").is(userUniId).and("channelName").is(channelName));
        return mongoDbService.count(query,OtherWechatUserInfoDo.class) > 0;
    }

    @Override
    public void insertOtherWechatUserInfo(Long userUniId, String channelName, String ipAddress) {
        OtherWechatUserInfoDo otherWechatUserInfoDo = new OtherWechatUserInfoDo();
        otherWechatUserInfoDo.setChannelName(channelName);
        otherWechatUserInfoDo.setCreateTime(System.currentTimeMillis());
        otherWechatUserInfoDo.setIpAddress(ipAddress);
        otherWechatUserInfoDo.setUserUniId(userUniId);
        mongoDbService.insert(otherWechatUserInfoDo);
    }
}
