package com.hndl.cn.mongodb.manager.topic.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.mongodb.manager.topic.bean.TopicCommentDo;
import com.hndl.cn.mongodb.manager.topic.manager.TopicCommentManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.string.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 尹争鸣
 * @Description 话题评论
 * @Date 2019年7月24日17:24:41
 * @Created by 湖南达联
 */


@Service
public class TopicCommentManagerImpl implements TopicCommentManager {

    @Resource
    private MongoDbService mongoDbService;

    ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;
    @Override
    public void insertTopicComment(TopicCommentDo topicCommentDo) {
        //创建时间
        topicCommentDo.setCreateTime(System.currentTimeMillis());

        //未删除状态
        topicCommentDo.setIsDelete(IsValidEnums.NO.getValue());

        //评论id
        topicCommentDo.setCommentId(iSnowflakeIdService.nextCommentId());

        mongoDbService.insert(topicCommentDo);

    }

    @Override
    public void delTopicCommentById(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id)).and("isDelete").is(IsValidEnums.NO.getValue());

        //
        Map map = new HashMap(1);
        map.put("isDelete", IsValidEnums.YES.getValue());
        //
        mongoDbService.updateOne(new Query(criteria), map, TopicCommentDo.class);

    }

    @Override
    public void delTopicCommentByTopicCommentId(Long replyCommentId) {
        Criteria criteria = Criteria.where("replyCommentId").is(replyCommentId).and("isDelete").is(IsValidEnums.NO.getValue());
        //
        Map map = new HashMap(1);
        map.put("isDelete", IsValidEnums.YES.getValue());
        //
        Query query=new Query(criteria);
        query.limit(BaseConstants.UPDATE_MAX_LIMIT);
        mongoDbService.update(query, map, TopicCommentDo.class);

    }

    @Override
    public void updateImgAndNameByUniId(Long userUniId, String userImg, String userNickName) {

        TopicCommentDo topicCommentDo = new TopicCommentDo();
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria);
        if (StringUtils.isNotBlank(userImg)) {
            topicCommentDo.setUserImg(userImg);
        }
        if (StringUtils.isNotBlank(userNickName)) {
            topicCommentDo.setUserNickName(userNickName);
        }
        //修改时间靠前的
        query.limit(BaseConstants.UPDATE_MAX_LIMIT).with(Sort.by(Sort.Order.desc("createTime")));
        mongoDbService.update(query, topicCommentDo, TopicCommentDo.class);
    }

    @Override
    public TopicCommentDo findTopicCommentById(Long commentId) {

        Criteria criteria = Criteria.where("commentId").is(commentId).and("isDelete").is(IsValidEnums.NO.getValue());

        return mongoDbService.findOne(new Query(criteria), TopicCommentDo.class);
    }

    @Override
    public List<TopicCommentDo> findTopicCommentByUserUniId(Long userUniId, Long  replyCommentId, Integer limit) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("isDelete").is(IsValidEnums.NO.getValue())
                .and("replyCommentId").is(replyCommentId);

        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("createTime")));
        query.limit(limit);

        return mongoDbService.findAll(query, TopicCommentDo.class);
    }

    @Override
    public List<TopicCommentDo> findPageTopicCommentByTopicCommentId(String topicId, String objId, IsValidEnums isHot,Long replyCommentId, Integer limit) {
/*
       Criteria criteria = Criteria.where("topicId").is(topicId).and("isDelete").is(IsValidEnums.NO.getValue())
                .and("topicCommentId").is(topicCommentId);
*/

        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue());
        if (StringUtils.isNotBlank(objId)) {
            criteria.and("_id").lt(new ObjectId(objId));
        }

        if (StringUtils.isNotBlank(topicId)) {
            criteria.and("topicId").is(topicId);
        }
        if (null!=replyCommentId&&!replyCommentId.equals(0)) {
            criteria.and("replyCommentId").is(replyCommentId);
        } else {
            criteria.and("replyCommentId").is(null);
        }
        Query query = new Query(criteria);
        if (IsValidEnums.YES.equals(isHot)) {
            query.with(Sort.by(Sort.Order.desc("hotCount")));
        } else {
            query.with(Sort.by(Sort.Order.desc("createTime")));
        }
        query.limit(limit);

        return mongoDbService.findAll(query, TopicCommentDo.class);
    }


    @Override
    public void incLikeCountById(Long commentId) {
        Criteria criteria = Criteria.where("commentId").is(commentId).and("isDelete").is(IsValidEnums.NO.getValue());
        Update update = new Update();
        update.inc("likeCount");
        mongoDbService.inc(new Query(criteria), update, TopicCommentDo.class);
    }

    @Override
    public void incHotCountById(Long commentId) {
        Criteria criteria = Criteria.where("commentId").is(commentId).and("isDelete").is(IsValidEnums.NO.getValue());
        Update update = new Update();
        update.inc("hotCount");
        mongoDbService.inc(new Query(criteria), update, TopicCommentDo.class);
    }

    @Override
    public boolean incCommentCountById(Long commentId, Integer value) {
        Criteria criteria = Criteria.where("commentId").is(commentId).and("isDelete").is(IsValidEnums.NO.getValue());

        if (value < 0) {
            criteria.and("commentCount").ne(0);
        }

        Update update = new Update();
        update.inc("commentCount", value);
        return mongoDbService.incByResult(new Query(criteria), update, TopicCommentDo.class);
    }

    @Override
    public TopicCommentDo selectTopicCommentByIdAndUserUniId(String id, Long userUniId) {

        Criteria criteria = Criteria.where("_id").is(new ObjectId(id)).and("userUniId").is(userUniId).and("isDelete").is(IsValidEnums.NO.getValue());


        return mongoDbService.findOne(new Query(criteria), TopicCommentDo.class);
    }

    @Override
    public List<TopicCommentDo> findTopicComment(String id, String nikeName, String topicId, Long userUniId) {
        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue());

        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }

        if (null != userUniId && !userUniId.equals(0)) {
            criteria.and("userUniId").is(userUniId);
        }

        if (StringUtils.isNotBlank(nikeName)) {
            criteria.and("userNickName").is(nikeName);
        }

        if (StringUtils.isNotBlank(topicId)) {
            criteria.and("topicId").is(topicId);
        }
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("createTime")));
        query.limit(BaseConstants.DEFAULT_LIMIT);

        return mongoDbService.findAll(query, TopicCommentDo.class);
    }
}
