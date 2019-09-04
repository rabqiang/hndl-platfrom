package com.hndl.cn.mongodb.manager.easemob.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.easemob.bean.UserIsToRoomInfoDo;
import com.hndl.cn.mongodb.manager.easemob.manager.UserIsToRoomInfoManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 19:26
 * @Created by 湖南达联
 */
@Service
public class UserIsToRoomInfoManagerImpl implements UserIsToRoomInfoManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertUserIsToRoomMapping(UserIsToRoomInfoDo userIsToRoomInfoDo) {
        userIsToRoomInfoDo.setCreateTime(System.currentTimeMillis());
        mongoDbService.insert(userIsToRoomInfoDo);
    }

    @Override
    public boolean userIsToRoom(Long sysUniUserId, String roomId) {
        Criteria criteria = Criteria.where("sysUniUserId").is(sysUniUserId)
                .and("chatRoomId").is(roomId);
        Query query = new Query(criteria);
        return mongoDbService.count(query,UserIsToRoomInfoDo.class) > 0;
    }
}
