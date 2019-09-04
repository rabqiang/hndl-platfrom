package com.hndl.cn.mongodb.manager.easemob.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobFansGroupChatRoomDo;
import com.hndl.cn.mongodb.manager.easemob.manager.EaseMobFansGroupChatRoomManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/22 14:16
 * @Created by 湖南达联
 */
@Service
public class EaseMobFansGroupChatRoomManagerImpl implements EaseMobFansGroupChatRoomManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertFansGroupChatRoom(EaseMobFansGroupChatRoomDo easeMobFansGroupChatRoomDo) {
        Long nowTime = System.currentTimeMillis();
        easeMobFansGroupChatRoomDo.setRoomCount(1);
        easeMobFansGroupChatRoomDo.setCreateTime(nowTime);
        easeMobFansGroupChatRoomDo.setModifyTime(nowTime);
        easeMobFansGroupChatRoomDo.setIsValid(IsValidEnums.YES.getValue());
        mongoDbService.insert(easeMobFansGroupChatRoomDo);
    }

    @Override
    public EaseMobFansGroupChatRoomDo findGroupChatRoomByFansGroupId(Long fansGroupId) {
        Criteria criteria = Criteria.where("fansGroupId").is(fansGroupId)
                .and("isValid").is(IsValidEnums.YES.getValue());
        Query query = new Query(criteria);
        return mongoDbService.findOne(query,EaseMobFansGroupChatRoomDo.class);
    }

    @Override
    public EaseMobFansGroupChatRoomDo findGroupChatRoomByRoomId(String roomId) {
        Criteria criteria = Criteria.where("chatRoomId").is(roomId)
                .and("isValid").is(IsValidEnums.YES.getValue());
        Query query = new Query(criteria);
        return mongoDbService.findOne(query,EaseMobFansGroupChatRoomDo.class);
    }
}
