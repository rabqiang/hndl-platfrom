package com.hndl.cn.mongodb.manager.message.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.message.FeedbackEnums;
import com.hndl.cn.mongodb.manager.message.bean.UserFeedbackDo;
import com.hndl.cn.mongodb.manager.message.manager.UserFeedbackManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 曹加丽
 * @Description 用户反馈表  dao层实现方法
 * @Date 2019/5/25 15:55
 * @Created by 湖南达联
 */
@Service
public class UserFeedbackManagerImpl implements UserFeedbackManager {
    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertUserFeedback(UserFeedbackDo userFeedbackDo) {
        userFeedbackDo.setIsTouch("ing");
        mongoDbService.insert(userFeedbackDo);
    }

    @Override
    public void insetUserFeedbackReply(UserFeedbackDo userFeedbackDo) {
        Criteria criteria = Criteria.where("userUniId").is(userFeedbackDo.getUserUniId())
                .and("objId").is(userFeedbackDo.getObjId())
                .and("contentType").is(userFeedbackDo.getContentType());
        Query query = new Query(criteria);
        UserFeedbackDo userFeedback = new UserFeedbackDo();
        userFeedback.setReplyContent(userFeedbackDo.getReplyContent());
        userFeedback.setReplyUserId(userFeedbackDo.getReplyUserId());
        userFeedback.setIsTouch("ok");
        mongoDbService.update(query, userFeedback, UserFeedbackDo.class);
    }


    @Override
    public UserFeedbackDo findUserFeedbackByObjId(Long sysUniId, String objId) {
        Criteria criteria = Criteria.where("userUniId").is(sysUniId)
                .and("objId").is(objId);
        Query query = new Query(criteria);
        return mongoDbService.findOne(query, UserFeedbackDo.class);
    }


    @Override
    public List<UserFeedbackDo> findUserFeedbackAll(String id, Long sysUniId, IsValidEnums isType, IsValidEnums isReply) {
        Criteria criteria = new Criteria();
        if (isType.getValue().equals(IsValidEnums.YES.getValue())) {
            criteria = Criteria.where("contentType").is(FeedbackEnums.FANS_SUGGESTIONS.getTypeId());
        }
        if (isType.getValue().equals(IsValidEnums.NO.getValue())) {
            criteria = Criteria.where("contentType").ne(FeedbackEnums.FANS_SUGGESTIONS.getTypeId());
            if (isReply.getValue().equals(IsValidEnums.YES.getValue())) {
                criteria.and("isTouch").is("ok");
            } else {
                criteria.and("isTouch").is("ing");
            }
        }
        if (sysUniId != null && sysUniId != 0) {
            criteria.and("userUniId").is(sysUniId);
        }
        if (id != null) {
            criteria.and("_id").gt(new ObjectId(id));
        }
        Query query = new Query(criteria).limit(BaseConstants.DEFAULT_LIMIT);
        return mongoDbService.findAll(query, UserFeedbackDo.class);
    }
}
