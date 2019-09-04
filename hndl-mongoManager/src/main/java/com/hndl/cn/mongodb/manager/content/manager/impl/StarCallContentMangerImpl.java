package com.hndl.cn.mongodb.manager.content.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.content.bean.StarCallContentDo;
import com.hndl.cn.mongodb.manager.content.manager.StarCallContentManger;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: hndl-platform
 * @description: 星粉圈
 * @author: 易成贤
 * @create: 2019-05-08 20:33 @Created by 湖南达联
 */
@Service
public class StarCallContentMangerImpl implements StarCallContentManger {

    private final Long TIME = 0L;
    private final int UNIID_LENGTH = 18;
    /**
     * 48小时时间
     */
    private static final Long TWO_DAY = 172800000L;

    @Resource
    MongoDbService mongoDbService;


    /**
     * 查询爱豆下面的打call
     *
     * @param starId 粉丝会id
     * @param id     ObjId
     * @param limit  分页条数
     * @return 返回call内容列表
     */
    @Override
    public List<StarCallContentDo> findStarCallContent(Long starId, String id, Integer limit) {
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
            //如果传了id按照id排序 保证"stage"不为SORT
            sort =Sort.by(Sort.Order.desc("_id"));
        }
        query.with(sort).limit(limit);
        return mongoDbService.findAll(query, StarCallContentDo.class);
    }

    /**
     * 添加打call
     *
     * @param callId         callId，由service生成
     * @param userUniId      用户唯一标识
     * @param userNickName   用户昵称
     * @param userImg        用户头像【url】
     * @param starId         粉丝会id
     * @param content        内容
     * @param contentImgList 图片列表【包含的是图片url】
     */
    @Override
    public void addCall(Long callId, Long userUniId, String userNickName, String userImg, Long starId, String content, List<String> contentImgList) {
        StarCallContentDo aDo = new StarCallContentDo();
        // callId
        aDo.setCallId(callId);
        // 创建时间
        aDo.setCreateTime(System.currentTimeMillis());
        // 用户id
        aDo.setUserUniId(userUniId);
        // 昵称
        aDo.setUserNickName(userNickName);
        // 头像
        aDo.setUserImg(userImg);
        // 明星id
        aDo.setStarId(starId);
        // 内容
        aDo.setContent(content);
        // 图片
        aDo.setContentImgList(contentImgList);
        // 点赞数
        aDo.setLikeCount(BaseConstants.STARTING_INT_VALUE);
        // 评论数据
        aDo.setCommentCount(BaseConstants.STARTING_INT_VALUE);
        // 是否推荐
        aDo.setIsRecommen(TIME);
        aDo.setIsStarSaid(IsValidEnums.NO.getValue());
        // 删除状态
        aDo.setIsDelete(IsValidEnums.NO.getValue());
        mongoDbService.insert(aDo);
    }

    /**
     * 查爱豆说
     *
     * @param starId    粉丝会id
     * @param
     * @param id        objId
     * @param limit     分页条数
     * @return 返回爱豆call内容列表
     */
    @Override
    public List<StarCallContentDo> findStarSaidContent(Long starId,String id, Integer limit) {
        Criteria criteria = Criteria.where("starId").is(starId)
                        .and("isDelete").is(IsValidEnums.NO.getValue())
                        .and("isStarSaid").is(IsValidEnums.YES.getValue());
        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).with(sort).limit(limit);
        return mongoDbService.findAll(query, StarCallContentDo.class);
    }

    /**
     * 查询爱豆说 根据用户关注的粉丝会相关
     *
     * @param starIdList   明星列表
     * @param isValidEnums 是否爱豆说 1是0否
     * @param id           ObjId
     * @param limit        分页条数
     * @return 返回call内容
     */
    @Override
    public List<StarCallContentDo> findStarListSaidContent(Collection<Long> starIdList, IsValidEnums isValidEnums, String id, Integer limit) {
        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue());
        if (CollectionUtils.isNotEmpty(starIdList)) {
            criteria.and("starId").in(starIdList);
        }
        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        if (null != isValidEnums) {
            criteria.and("isStarSaid").is(isValidEnums.getValue());
        }
        // 降序排序
        Sort.Order order = Sort.Order.desc("_id");
        Query query = new Query(criteria).with(Sort.by(order)).limit(limit);
        return mongoDbService.findAll(query, StarCallContentDo.class);
    }

    @Override
    public List<StarCallContentDo> findUserListCallContent(Collection<Long> userUniIdList, String id, Integer limit) {
        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue());
        if (CollectionUtils.isNotEmpty(userUniIdList)) {
            criteria.and("userUniId").in(userUniIdList);
        }
        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        // 降序排序
        Sort.Order order = Sort.Order.desc("_id");

        Query query = new Query(criteria).with(Sort.by(order)).limit(limit);

        return mongoDbService.findAll(query, StarCallContentDo.class);
    }

    /**
     * 查询用户打call数据
     *
     * @param userUniId
     * @param id
     * @return
     */
    @Override
    public List<StarCallContentDo> findUserCallContent(Long userUniId, String id, Integer limit) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("isDelete").is(IsValidEnums.NO.getValue());
        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "_id");
        Query query = new Query(criteria).with(sort).limit(limit);
        return mongoDbService.findAll(query, StarCallContentDo.class);
    }

    /**
     * 是否打call数据
     *
     * @param targetId
     * @return
     */
    @Override
    public boolean isCall(Long targetId) {
        Criteria criteria = Criteria.where("callId").is(targetId);
        return mongoDbService.count(new Query(criteria), StarCallContentDo.class) > 0;
    }

    /**
     * 批量插入
     *
     * @param starCallContentDos
     */
    @Override
    public void inserBatch(List<StarCallContentDo> starCallContentDos) {
        mongoDbService.insertInBatch(starCallContentDos, StarCallContentDo.class);
    }

    @Override
    public void inserOne(StarCallContentDo starCallContentDo) {
        Criteria criteria = Criteria.where("callId").is(starCallContentDo.getCallId());
        mongoDbService.upsert(new Query(criteria), starCallContentDo, StarCallContentDo.class);
    }

    /**
     * 查询指定call数据
     *
     * @param callId
     * @return
     */
    @Override
    public StarCallContentDo findCallContent(Long callId) {
        Criteria criteria = Criteria.where("callId").is(callId).and("isDelete").is(IsValidEnums.NO.getValue());
        return mongoDbService.findOne(new Query(criteria), StarCallContentDo.class);
    }

    /**
     * 逻辑删除打call数据
     *
     * @param callId
     */
    @Override
    public void deleteCall(Long callId) {
        Criteria criteria = Criteria.where("callId").is(callId);
        Map map = new HashMap(1);
        map.put("isDelete", IsValidEnums.YES.getValue());
        mongoDbService.update(new Query(criteria), map, StarCallContentDo.class);
    }

    /**
     * 原子递增指定call的评论数
     *
     * @param callId
     */
    @Override
    public void incCommentCount(Long callId, IsValidEnums isValidEnums) {
        Criteria criteria = Criteria.where("callId").is(callId);
        Update update = new Update();
        if (isValidEnums.getValue().equals(IsValidEnums.NO.getValue())) {
            update.inc("commentCount", -1L);
        } else {
            update.inc("commentCount");
        }
        mongoDbService.inc(new Query(criteria), update, StarCallContentDo.class);
    }

    /**
     * 原子递增点赞数
     *
     * @param callId
     */
    @Override
    public void incLikeCount(Long callId) {
        Criteria criteria = Criteria.where("callId").is(callId);
        Update update = new Update();
        update.inc("likeCount");
        mongoDbService.inc(new Query(criteria), update, StarCallContentDo.class);
    }

    /**
     * 更新用户头像
     *
     * @param userUniId 用户唯一标识
     * @param newImg    新的图片地址
     */
    @Override
    public void updateUserImgByUniId(Long userUniId, String newImg) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Map map = new HashMap(1);
        map.put("userImg", newImg);
        Query query = new Query(criteria).limit(BaseConstants.UPDATE_MAX_LIMIT).with(Sort.by(Sort.Order.desc("createTime")));
        mongoDbService.update(query, map, StarCallContentDo.class);
    }

    /**
     * 修改用户昵称
     *
     * @param userUniId   用户唯一标识
     * @param newNickName 新的昵称
     */
    @Override
    public void updateUserNickNameByUniId(Long userUniId, String newNickName) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Map map = new HashMap(1);
        map.put("userNickName", newNickName);
        Query query = new Query(criteria).limit(BaseConstants.UPDATE_MAX_LIMIT).with(Sort.by(Sort.Order.desc("createTime")));
        mongoDbService.update(query, map, StarCallContentDo.class);
    }

    /**
     * 查询所有call数据
     *
     * @param starId    明星id【可不传】
     * @param userUniId 用户id【可不传】
     * @param limit     分页条数
     * @param
     * @return
     */
    @Override
    public List<StarCallContentDo> findAllCall(String id, Collection starId, Long userUniId, IsValidEnums isDelete,Integer limit) {
        Criteria criteria = new Criteria();
        if (null != starId) {
            criteria = Criteria.where("starId").in(starId);
        }
        if (null != userUniId) {
            criteria.and("userUniId").is(userUniId);
        }

        if (StringUtils.isNotBlank(id) ) {
                criteria.and("_id").lt(new ObjectId(id));
        }

        if (null != isDelete){
            criteria.and("isDelete").is(isDelete.getValue());
        }
        Query query  = new Query(criteria).limit(limit).with(Sort.by(Sort.Order.desc("createTime"))) ;


        return mongoDbService.findAll(query, StarCallContentDo.class);

    }

    /**
     * 按照时间段查询call数量
     *
     * @param starIdOrUniId
     * @param startTime
     * @param endTime
     * @return
     */
    @Override
    public Long countByTime(Long starIdOrUniId, Long startTime, Long endTime) {
        Criteria criteria = new Criteria();
        if (null != starIdOrUniId) {
            if (UNIID_LENGTH == starIdOrUniId.toString().length()) {
                criteria.and("userUniId").is(starIdOrUniId);
            } else {
                criteria.and("starId").is(starIdOrUniId);
            }
        }
        if (null != startTime & null != endTime) {
            //>=开始时间 ; <= 结束时间;
            criteria.and("createTime").gte(startTime).lte(endTime);
        }
        return mongoDbService.count(new Query(criteria), StarCallContentDo.class);
    }

    /**
     * 更新是否推荐值
     *
     * @param id
     */
    @Override
    public void updateIsRecommen(String id, Long value) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Map map = new HashMap(1);
        map.put("isRecommen", value);
        mongoDbService.update(new Query(criteria), map, StarCallContentDo.class);
    }

    /**
     * 根据粉丝会更新粉丝会的call删除状态
     *
     * @param starId
     * @param isDelete
     */
    @Override
    public void updateIsDeleteByStarId(Long starId, IsValidEnums isDelete) {
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        Map map = new HashMap(1);
        map.put("isDelete",isDelete.getValue());
        mongoDbService.update(new Query(criteria),map,StarCallContentDo.class);
    }

    /**
     * 查询推荐内容
     *
     * @param limit
     * @return
     */
    @Override
    public List<StarCallContentDo> findRecommenByUser(Integer limit) {
        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue())
                .and("isRecommen").gte(System.currentTimeMillis() - TWO_DAY)
                .and("isStarSaid").is(IsValidEnums.NO.getValue());
        Sort sort = Sort.by(Sort.Order.desc("isRecommen"));
        Query query = new Query(criteria).with(sort).limit(limit);
        return mongoDbService.findAll(query,StarCallContentDo.class);
    }

    /**
     * 查询用户当天第一条打call
     *
     * @param userUniId
     * @return
     */
    @Override
    public StarCallContentDo findFristCallByDay(Long userUniId) {

        Criteria criteria = Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli()).lt(LocalDateTimeUtil.getNowMaxTimeMilli());
        Sort sort = Sort.by(Sort.Order.desc("createTime"));

        return mongoDbService.findOne(new Query(criteria).with(sort),StarCallContentDo.class);
    }

}
