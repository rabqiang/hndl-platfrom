package com.hndl.cn.mongodb.manager.content.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.content.bean.ContentLikeDo;
import com.hndl.cn.mongodb.manager.content.manager.ContentLikeManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/7 11:05
 * @Created by 湖南达联
 */
@Service
public class ContentLikeManagerImpl implements ContentLikeManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertLike(Long userUniId, Long targetId) {
        ContentLikeDo contentLikeDo = new ContentLikeDo();
        contentLikeDo.setCreateTime(System.currentTimeMillis());
        contentLikeDo.setUserUniId(userUniId);
        contentLikeDo.setTargetId(targetId);
        mongoDbService.insert(contentLikeDo);
    }


    @Override
    public boolean isLike(Long userUniId, Long targetId) {

        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("targetId").is(targetId);
        Query query = new Query(criteria);
        return mongoDbService.findOne(query,ContentLikeDo.class) != null;
    }


    @Override
    public Map<Long, Integer> findBatchIsLike(Long userUniId,Collection<Long> idList) {

        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("targetId").in(idList);

        Query query = new Query(criteria);

        List<ContentLikeDo> likeDoList = mongoDbService.findAll(query,ContentLikeDo.class);



        //如果为空，则用户没有点过赞
        if(CollectionUtils.isNotEmpty(likeDoList)){
            Map<Long,Integer> map = new HashMap<>(idList.size());
            Map<Long, Long> collect = likeDoList.stream().filter(bean -> bean != null)
                    .collect(Collectors.toMap(bean -> bean.getTargetId(), bean -> bean.getUserUniId()));

            //循环id,把点过赞的都放进去
            idList.stream().filter(id ->collect.get(id) != null).forEach(id -> map.put(id,IsValidEnums.YES.getValue()));

            return map;
        }else {
            return null;
        }
    }

    /**
     * 删除点赞数据
     *
     * @param targetId
     */
    @Override
    public void deleteLike(Long targetId) {
        Criteria criteria = Criteria.where("targetId").is(targetId);
        ContentLikeDo likeDo = mongoDbService.findOne(new Query(criteria), ContentLikeDo.class);
        if (null == likeDo) {
            return;
        }
        mongoDbService.delete(new Query(criteria),ContentLikeDo.class);
    }
}
