
package com.hndl.cn.mongodb.manager.follow.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.follow.bean.UserFollowDo;
import com.hndl.cn.mongodb.manager.follow.manager.UserFollowManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.string.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description 关注用户
 * @Date 2019年5月24日17:33:42
 * @Created by 湖南达联
 */
@Service
public class UserFollowManagerImpl implements UserFollowManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertFollow(UserFollowDo userFollowDo) {
        userFollowDo.setCreateTime(System.currentTimeMillis());
        userFollowDo.setIsDelete(IsValidEnums.NO.getValue());
        mongoDbService.insert(userFollowDo);
    }


    @Override
    public void delFollow(Long userUniId, Long followId) {
        Query query = new Query(Criteria.where("createUserId").is(userUniId).and("followUserId").is(followId));
        UserFollowDo userFollowDo = new UserFollowDo();
        userFollowDo.setIsDelete(IsValidEnums.YES.getValue());
        mongoDbService.updateOne(query, userFollowDo, UserFollowDo.class);
    }


    @Override
    public List<UserFollowDo> findFollowByUniId(Long userUniId, int followType, String id, Integer limit) {
        Criteria criteria;
        if (followType == 0) {
            criteria = Criteria.where("createUserId").is(userUniId).and("isDelete").is(IsValidEnums.NO.getValue());
        } else {
            criteria = Criteria.where("createUserId").is(userUniId).and("followType").is(followType).and("isDelete").is(IsValidEnums.NO.getValue());
        }
        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("createTime")));
        if (null != limit && !limit.equals(0)) {
            query.limit(limit);
        }
        return mongoDbService.findAll(query, UserFollowDo.class);
    }

    @Override
    public boolean eachotherFollow(Long userUniId, Long followId) {
        Query query = new Query(Criteria.where("createUserId").is(userUniId).and("followUserId").is(followId).and("isDelete").is(IsValidEnums.NO.getValue()));
        return  mongoDbService.findOne(query, UserFollowDo.class) != null;
    }

    @Override
    public UserFollowDo findFollowByUniIdAndFollowId(Long userUniId, Long followId) {
        Query query = new Query(Criteria.where("createUserId").is(userUniId).and("followUserId").is(followId).and("isDelete").is(IsValidEnums.NO.getValue()));
        return mongoDbService.findOne(query, UserFollowDo.class);
    }

    @Override
    public List<UserFollowDo> findFollowByFollowId(Long followId, String id, int limit) {
        Criteria criteria = new Criteria();
        criteria.and("followUserId").is(followId).and("isDelete").is(IsValidEnums.NO.getValue());
        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("createTime")));
        if (limit != 0) {
            query.limit(limit);
        }
        return mongoDbService.findAll(query, UserFollowDo.class);
    }

    @Override
    public int countFollowByUniId(Long userUniId) {
        Query query = new Query(Criteria.where("createUserId").is(userUniId).and("isDelete").is(IsValidEnums.NO.getValue()));

        return (int) mongoDbService.count(query, UserFollowDo.class);
    }


    @Override
    public int countFansByFollowId(Long followId) {

        Query query = new Query(Criteria.where("followUserId").is(followId).and("isDelete").is(IsValidEnums.NO.getValue()));

        return (int) mongoDbService.count(query, UserFollowDo.class);
    }

    @Override
    public int countFriendByUniId(Long userUniId) {
        int friendCount = 0;
        List<UserFollowDo> followByFollowId = this.findFollowByFollowId(userUniId, null, 0);
        for (UserFollowDo userFollowDo : followByFollowId) {
            if (this.eachotherFollow(userUniId, userFollowDo.getCreateUserId())) {
                friendCount++;
            }
        }
        return friendCount;
    }

    @Override
    public void insertFollowAll(List<UserFollowDo> userFollowDos) {

        mongoDbService.insertAll(userFollowDos);
    }


    @Override
    public List<UserFollowDo> findPageFollowByUniId(Long userUniId, int followType, String id, Integer limit) {
        Criteria criteria ;
        if (followType == 0) {
            criteria = Criteria.where("createUserId").is(userUniId).and("isDelete").is(IsValidEnums.NO.getValue());
        } else {
            criteria = Criteria.where("createUserId").is(userUniId).and("followType").is(followType).and("isDelete").is(IsValidEnums.NO.getValue());
        }

        if (null != id) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("createTime")));
        if (null != limit && !limit.equals(0)) {
            query.limit(limit);
        }

        return mongoDbService.findAll(query, UserFollowDo.class);

    }

    @Override
    public List<UserFollowDo> findPageFollowByFollowId(Long followId, String id, int limit) {
        Criteria criteria = Criteria.where("followUserId").is(followId).and("isDelete").is(IsValidEnums.NO.getValue());
        if (null != id) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("createTime")));
        if (limit != 0) {
            query.limit(limit);
        }
        return mongoDbService.findAll(query, UserFollowDo.class);
    }
}
