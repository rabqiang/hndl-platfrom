package com.hndl.cn.mongodb.manager.comment.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.comment.CommentType;
import com.hndl.cn.mongodb.manager.comment.bean.UserCommentDo;
import com.hndl.cn.mongodb.manager.comment.manager.UserCommentManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.string.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/6 15:42
 * @Created by 湖南达联
 */
@Service
public class UserCommentManagerImpl implements UserCommentManager {

    @Resource
    private MongoDbService mongoDbService;


    @Override
    public void insertComment(UserCommentDo commentDo) {
        commentDo.setCreateTime(System.currentTimeMillis());
        commentDo.setIsDelete(IsValidEnums.NO.getValue());
        mongoDbService.insert(commentDo);
    }

    @Override
    public List<UserCommentDo> findPageCommentByTargetId(Long targetId, CommentType commentType, String objId) {
        Criteria criteria = Criteria.where("targetId").is(targetId)
               .and("isDelete").is(IsValidEnums.NO.getValue());

        if(StringUtils.isNotBlank(objId)){
            criteria.and("_id").lt(new ObjectId(objId));
        }

        Query query = new Query(criteria);
        query.with(new Sort(Sort.Direction.DESC, "createTime"));
        query.limit(BaseConstants.DEFAULT_LIMIT);
        return mongoDbService.findAll(query,UserCommentDo.class);
    }

    @Override
    public void  delCommentByCallId(Long callId){

        Criteria criteria = Criteria.where("targetId").is(callId).and("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
       Map map = new HashMap(1);
       map.put("isDelete",IsValidEnums.YES.getValue());
       query.limit(BaseConstants.UPDATE_MAX_LIMIT);
        mongoDbService.update(query,map,UserCommentDo.class);

    }

    @Override
    public  int  countCommentByCallId(Long callId){
        Criteria criteria = Criteria.where("targetId").is(callId).and("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
        UserCommentDo userCommentDo=new UserCommentDo();
        userCommentDo.setIsDelete(IsValidEnums.YES.getValue());
      return (int) mongoDbService.count(query,UserCommentDo.class);
    }

    /**
     * 通过评论id查询评论do
     *
     * @param id id
     * @return 返回评论数据
     */
    @Override
    public UserCommentDo findCommentByUniIdAndId(Long UniId,String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id)).and("userUniId").is(UniId).and("isDelete").is(IsValidEnums.NO.getValue());
        return mongoDbService.findOne(new Query(criteria),UserCommentDo.class);
    }

    @Override
    public UserCommentDo findCommentByCommentId(String id){
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id)).and("isDelete").is(IsValidEnums.NO.getValue());
        return mongoDbService.findOne(new Query(criteria),UserCommentDo.class);
    }

    /**
     * 通过id删除评论数据
     *
     * @param id
     */
    @Override
    public void delCommentById(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id)).and("isDelete").is(IsValidEnums.NO.getValue());
        //
        Map  map = new HashMap(1);
        map.put("isDelete",IsValidEnums.YES.getValue());
        //
        mongoDbService.updateOne(new Query(criteria),map,UserCommentDo.class);
    }

    @Override
    public  void insertCommentAll(List<UserCommentDo> commentDo){
        mongoDbService.insertAll(commentDo);
    }


    @Override
    public void  updateImgAndNameByUniId(Long userUniId,String userImg,String userNickName){
         UserCommentDo userCommentDo=new UserCommentDo();
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria);
        if (StringUtils.isNotBlank(userImg)){
            userCommentDo.setUserImg(userImg);
        }
        if (StringUtils.isNotBlank(userNickName)){
            userCommentDo.setUserNickName(userNickName);
        }
        query.limit(BaseConstants.UPDATE_MAX_LIMIT);

        mongoDbService.update(query,userCommentDo,UserCommentDo.class);

    }


}
