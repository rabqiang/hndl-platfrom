package com.hndl.cn.mongodb.manager.easemob.manager.impl;

import com.hndl.cn.mongodb.manager.easemob.bean.ChatRoomMsgInfoDo;
import com.hndl.cn.mongodb.manager.easemob.manager.ChatRoomMsgInfoManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/4/3 10:54
 * @Created by 湖南达联
 */
@Service
public class ChatRoomMsgInfoManagerImpl implements ChatRoomMsgInfoManager {

    @Resource
    private MongoDbService mongoDbService;


    @Override
    public List<ChatRoomMsgInfoDo> findChatRoomMsgInfoDoByRoomId(String roomId, Integer limit) {
        Criteria criteria = Criteria.where("roomId").is(roomId);
        Query query = new Query(criteria);
        query.limit(limit);
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC, "createTime")));
        return mongoDbService.findAll(query,ChatRoomMsgInfoDo.class);
    }

    @Override
    public void insertChatRoomMsgInfoDo(ChatRoomMsgInfoDo chatRoomMsgInfoDo) {
        chatRoomMsgInfoDo.setCreateTime(System.currentTimeMillis());
        mongoDbService.insert(chatRoomMsgInfoDo);
    }
}
