package com.hndl.cn.mongodb.manager.topic.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.topic.TopicStatusEnums;
import com.hndl.cn.mongodb.manager.topic.bean.TopicDo;
import com.hndl.cn.mongodb.manager.topic.manager.TopicManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * @program:hndl-platform
 * @description:TODO 话题
 * @author: 易成贤
 * @create: 2019/7/29 14:47
 * @Created by湖南达联
 **/
@Service
@Slf4j
public class TopicManagerImpl implements TopicManager {


    @Resource
    MongoDbService mongoDbService;

    /**
     * 查询推荐话题
     *
     * @return
     */
    @Override
    public List<TopicDo> findRecommenTopic(Long time) {
        Criteria criteria = Criteria.where("isRecommen").gt(0L)
                .and("endRecommendTime").gte(time)
                .and("publishTime").lte(time)
                .and("audit").is(TopicStatusEnums.PUBLISHED.getType())
                .and("isDelete").is(IsValidEnums.NO.getValue());

        Sort sort = Sort.by(Sort.Order.desc("publishTime"));

        Query query = new Query(criteria).limit(10).with(sort);

        return mongoDbService.findAll(query, TopicDo.class);
    }

    /**
     * 查询过往话题
     *
     * @return
     */
    @Override
    public List<TopicDo> findPastTopic(Long time) {
        Criteria criteria = Criteria.where("publishTime").lt(time)
                .and("endRecommendTime").lt(time)
                .and("audit").is(TopicStatusEnums.PUBLISHED.getType())
                .and("isDelete").is(IsValidEnums.NO.getValue());

        Sort sort = Sort.by(Sort.Order.desc("publishTime"));

        Query query = new Query(criteria).limit(100).with(sort);
        return mongoDbService.findAll(query, TopicDo.class);
    }

    /**
     * 通过主键id查询发布话题
     *
     * @param id
     * @return
     */
    @Override
    public TopicDo findTopicById(String id) {
            Criteria criteria = Criteria.where("_id").is(new ObjectId(id))
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("audit").is(TopicStatusEnums.PUBLISHED.getType());
        return mongoDbService.findOne(new Query(criteria), TopicDo.class);
    }

    /**
     * 通过id查询话题<br/>
     *
     * @param id
     * @return
     */
    @Override
    public TopicDo findTopic(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        return mongoDbService.findOne(new Query(criteria), TopicDo.class);
    }

    /**
     * 通过in的方式查询话题
     *
     * @param ids
     * @return
     */
    @Override
    public List<TopicDo> findTopicByIds(Collection<String> ids) {
        Criteria criteria = Criteria.where("_id").in(ids);
        return  Optional.ofNullable(mongoDbService.findAll(new Query(criteria),TopicDo.class)).orElse(new ArrayList<>());
    }

    /**
     * 原子更新评论数
     *
     * @param id
     * @return
     */
    @Override
    public boolean incTopicCommentCount(String id, Integer value) {

        Criteria criteria = Criteria.where("audit").is(TopicStatusEnums.PUBLISHED.getType())
                .and("isDelete").is(IsValidEnums.NO.getValue())
                .and("_id").is(new ObjectId(id));

        Update update = new Update();
        if (value < 0){
            criteria.and("commentCount").gte(-value);
        }

        update.inc("commentCount", value);
        return mongoDbService.incByResult(new Query(criteria), update, TopicDo.class);
    }

    /**
     * 查询所有话题
     *
     * @param id
     * @param parameter
     * @param topicStatusEnums
     * @param isRecommen
     * @param isDelete
     * @param limit
     * @return
     */
    @Override
    public List<TopicDo> findAllTopic(String id, String parameter, TopicStatusEnums topicStatusEnums, IsValidEnums isRecommen, IsValidEnums isDelete, Integer limit) {

        //Criteria criteria = createCriteriaBykeyWord(parameter);
Criteria criteria =new Criteria();

        if (null != topicStatusEnums) {
            criteria.and("audit").is(topicStatusEnums.getType());
        }

        if (StringUtils.isNotBlank(id)) {
            criteria.and("_id").lt(new ObjectId(id));
        }

        if (null != isDelete) {
            criteria.and("isDelete").is(isDelete.getValue());
        }

        //判断查询是推荐的
        long timeMillis = System.currentTimeMillis();
        if (IsValidEnums.YES.equals(isRecommen)) {
            criteria.and("isRecommen").gt(0L).and("endRecommendTime").gte(timeMillis);
        }
        //判断查询是不推荐的
        if (IsValidEnums.NO.equals(isRecommen)) {
            criteria.and("endRecommendTime").lt(timeMillis);
        }
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).with(sort).limit(limit);
        return mongoDbService.findAll(query, TopicDo.class);
    }

    /**
     * 插入话题
     *
     * @param topicDo
     */
    @Override
    public void insertTopic(TopicDo topicDo) {
        mongoDbService.insert(topicDo);
    }

    /**
     * 更新话题
     *
     * @param topicDo
     */
    @Override
    public void upsertTopic(TopicDo topicDo) {

        Criteria criteria = Criteria.where("_id").is(new ObjectId(topicDo.getId()));

        topicDo.setId(null);

        mongoDbService.update(new Query(criteria), topicDo, TopicDo.class);
    }

    /**
     * 更新话题
     *
     * @param topicDo
     */
    @Override
    public void updateTopic(TopicDo topicDo) {

        Criteria criteria = Criteria.where("_id").is(new ObjectId(topicDo.getId()));

        topicDo.setId(null);
        mongoDbService.updateOne(new Query(criteria), topicDo, TopicDo.class);
    }

    /**
     * 统计推荐话题个数
     *
     * @return
     */
    @Override
    public Long countByRecommen(IsValidEnums isRecommen) {

        Criteria criteria = Criteria.where("isRecommen").gte(0L)
                .and("audit").is(TopicStatusEnums.PUBLISHED.getType())
                .and("isDelete").is(IsValidEnums.NO.getValue());
        long currentTimeMillis = System.currentTimeMillis();
        if (IsValidEnums.YES.equals(isRecommen)) {

            criteria.and("endRecommendTime").gte(currentTimeMillis);
        } else {
            criteria.and("endRecommendTime").lt(currentTimeMillis);
        }
        return mongoDbService.count(new Query(criteria), TopicDo.class);
    }

    @Override
    public void incTopicLikeCount(String id) {
        Criteria criteria = Criteria.where("_id").is(new ObjectId(id));
        Update update = new Update();
        update.inc("likeCount");
        mongoDbService.inc(new Query(criteria), update, TopicDo.class);

    }


    /**
     * 查询所有话题
     *
     * @param id
     * @param topicStatusEnums
     * @param isDelete
     * @param defaultLimit
     * @return
     */
    @Override
    public List<TopicDo> findAllTopic(String id, Collection<Integer> topicStatusEnums, IsValidEnums isDelete, Integer defaultLimit) {
        Criteria criteria = Criteria.where("audit").in(topicStatusEnums);

        if (null != isDelete) {
            criteria.and("isDelete").is(isDelete.getValue());
        }
        if (StringUtils.isNotBlank(id)) {
                criteria.and("_id").lte(new ObjectId(id));
        }

        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).limit(defaultLimit).with(sort);
        return mongoDbService.findAll(query, TopicDo.class);
    }

    /**
     * 根据标题查找话题
     *
     * @param title
     * @return
     */
    @Override
    public TopicDo findTopicByTitle(String title) {

        Criteria criteria = Criteria.where("title").is(title);
        return mongoDbService.findOne(new Query(criteria), TopicDo.class);
    }


    private Criteria createCriteriaBykeyWord(String keyWord) {
        if (StringUtils.isBlank(keyWord)) {
            return new Criteria();
        }

        // 去空格
        keyWord = keyWord.replaceAll(" ", "");

        boolean flag;
        // 中文+英文不超过8
        flag = keyWord.matches("[\\u4e00-\\u9fa5a-zA-Z]{1,8}");
        // 如果校验中+英不出来继续校验
        if (!flag) {
            // 英文12位
            flag = keyWord.matches("[a-zA-Z]{1,12}");
        }
        //中文+数字
        if (!flag) {
            flag = keyWord.matches("[\\u4e00-\\u9fa50-9]{1,8}");
        }

        if (flag) {
            // 左匹配忽略大小写
            return Criteria.where("title").regex("^" + keyWord + ".*$", "i");
        } else {
            return new Criteria();
        }

    }


}
