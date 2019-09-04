package com.hndl.cn.mongodb.manager.message.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageManager;
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
 * @Description 用户消息
 * @Date 2019年5月22日13:52:46
 * @Created by 湖南达联
 */
@Service
public class UserMessageManagerImpl implements UserMessageManager {
    @Resource
    private MongoDbService mongoDbService;

    private ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;


    @Override
    public void insertUserMessageDo(UserMessageDo userMessageDo) {

        if (null==userMessageDo.getCreateTime()) {
            userMessageDo.setCreateTime(System.currentTimeMillis());
        }
        userMessageDo.setMessageId(iSnowflakeIdService.nextUserMessageId());
        userMessageDo.setIsDelete(IsValidEnums.NO.getValue());
        mongoDbService.insert(userMessageDo);
    }


    @Override
    public List<UserMessageDo> findBySendUserId(Long sendUserId, Integer messageType, String id) {
        Criteria criteria = null;
        //获取最近30天数据
        long currtime = System.currentTimeMillis();
        long starttime = currtime - (long) 30 * (long) 86400000;
        if (messageType.equals(10)) {
            criteria = Criteria.where("sendUserId").in(sendUserId, 0L).and("messageType").is(messageType);
        } else {
            criteria = Criteria.where("sendUserId").is(sendUserId).and("messageType").is(messageType);
        }
        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }

        criteria.and("createTime").gt(starttime).lte(currtime);
        criteria.and("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
        query.limit(BaseConstants.DEFAULT_LIMIT);
        query.with(new Sort(Sort.Direction.DESC, "_id"));

        return mongoDbService.findAll(query, UserMessageDo.class);
    }


    @Override
    public int countBySendUserId(Long sendUserId, Integer messageType) {

        long currtime = System.currentTimeMillis();
        long starttime = currtime - (long) 30 * (long) 86400000;
        Query query = new Query(Criteria.where("sendUserId").in(sendUserId, 0).and("messageType").is(messageType).and("isDelete").is(IsValidEnums.NO.getValue()).and("createTime").gt(starttime).lte(currtime));

        return (int) mongoDbService.count(query, UserMessageDo.class);
    }

    @Override
    public void updateByMessageId(UserMessageDo userMessageDo) {

         Criteria criteria =Criteria.where("messageId").is(userMessageDo.getMessageId());

         Query query=new Query(criteria);

        mongoDbService.updateOne(query,userMessageDo,UserMessageDo.class);
    }



    @Override
    public List<UserMessageDo> findByUserMessage(UserMessageDo userMessageDo,Integer messageType, Long messageId,Integer limit) {
        Criteria criteria = new Criteria();
        criteria=Criteria.where("isDelete").is(IsValidEnums.NO.getValue());

        if (null!=messageType&&!messageType.equals(0)){
            criteria.and("messageType").is(messageType);
        }
        if (StringUtils.isNotBlank(userMessageDo.getTitle())){
            criteria.and("title").is(userMessageDo.getTitle());
        }
        if (StringUtils.isNotBlank(userMessageDo.getContent())){
            criteria.and("content").is(userMessageDo.getContent());
        }
        if (null!=userMessageDo.getCreateTime()&&!userMessageDo.getCreateTime().equals(0L)){
            criteria.and("createTime").is(userMessageDo.getCreateTime());
        }
        if (null!=userMessageDo.getCreateUserId()){
            criteria.and("createUserId").is(userMessageDo.getCreateUserId());
        }
        if (null!=messageId&&!messageId.equals(0L)) {
                criteria.and("messageId").lt(messageId);
        }

        Query query = new Query(criteria);
        query.with(new Sort(Sort.Direction.DESC, "_id"));
        if (null!=limit&&!limit.equals(0)){
            query.limit(limit);
        }

        return  mongoDbService.findAll(query,UserMessageDo.class);
    }


    @Override
    public UserMessageDo findBySysUniIdAndMessageType(Long sysUniId, Integer messageType) {

        long currtime = System.currentTimeMillis();
        long starttime = currtime - (long) 30 * (long) 86400000;

        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue())
                             .and("sendUserId").is(sysUniId).and("messageType").is(messageType)
                              .and("createTime").gt(starttime).lte(currtime);
        Query query = new Query(criteria);
        query.with(new Sort(Sort.Direction.DESC, "createTime"));

        return mongoDbService.findOne(query,UserMessageDo.class);
    }


    @Override
    public long countUnReadMsg(Long sendUserId,Long messageId,Integer messageType) {

        long currtime = System.currentTimeMillis();
        long starttime = currtime - (long) 30 * (long) 86400000;

        Criteria criteria=Criteria.where("isDelete").is(IsValidEnums.NO.getValue())
                           .and("sendUserId").is(sendUserId).and("messageType").is(messageType)
                              .and("createTime").gt(starttime).lte(currtime);

        if (null!=messageId&&!messageId.equals(0)){
            criteria.and("messageId").gt(messageId);
        }
        return  mongoDbService.count(Query.query(criteria),UserMessageDo.class);
    }

    @Override
    public UserMessageDo selectBySendUserIdAndTimeAndType(Long sendUserId, Long createTime, Integer messageType) {
        Query query = new Query(
                Criteria.where("sendUserId").in(sendUserId, 0)
                        .and("createTime")
                        .gte(createTime - 35)
                        .lte(createTime + 35)
                        .and("messageType").is(messageType)
                        .and("isDelete").is(IsValidEnums.NO.getValue()));

        return mongoDbService.findOne(query, UserMessageDo.class);
    }
}
