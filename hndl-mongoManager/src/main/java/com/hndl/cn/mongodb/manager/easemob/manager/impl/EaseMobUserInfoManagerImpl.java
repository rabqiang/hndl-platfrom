package com.hndl.cn.mongodb.manager.easemob.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobUserInfoDo;
import com.hndl.cn.mongodb.manager.easemob.manager.EaseMobUserInfoManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 11:20
 * @Created by 湖南达联
 */
@Service
public class EaseMobUserInfoManagerImpl implements EaseMobUserInfoManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertEaseMobUserInfo(EaseMobUserInfoDo easeMobUserInfoDo) {
         //默认有效
         easeMobUserInfoDo.setIsValid(IsValidEnums.YES.getValue());
         mongoDbService.insert(easeMobUserInfoDo);
    }

    @Override
    public EaseMobUserInfoDo findEaseMobUserInfoBySysUniId(Long sysUniUserId) {
        Criteria criteria = Criteria.where("sysUniUserId").is(sysUniUserId)
                .and("isValid").is(IsValidEnums.YES.getValue());
        Query query = new Query(criteria);
        return mongoDbService.findOne(query,EaseMobUserInfoDo.class);
    }
}
