package com.hndl.cn.mongodb.manager.star.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.string.StringUtils;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @program: hndl-platform
 * @description: 粉丝信息记录表操作的实现类
 * @author: 易成贤
 * @create: 2019-04-19 14:53 @Created by 湖南达联
 */
@Service
public class StarFansGroupManagerImpl implements StarFansGroupManager {

    @Resource
    private MongoDbService mongoDbService;

    /**
     * 根据明星()查询粉丝会基础信息<br>
     * exp：一个明星()只有一个粉丝会
     *
     * @param starId
     * @return
     */
    @Override
    public StarFansGroupDo findStarFansGroup(Long starId) {
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        return mongoDbService.findOne(new Query(criteria), StarFansGroupDo.class);
    }

    /**
     * 插入粉丝会
     *
     * @param starFansGroupDo 粉丝会do
     */
    @Override
    public void upsert(@NotNull StarFansGroupDo starFansGroupDo) {
        Criteria criteria = Criteria.where("starId").is(starFansGroupDo.getStarId());
        mongoDbService.upsert(new Query(criteria), starFansGroupDo, StarFansGroupDo.class);
    }

    /**
     * 批量插入数据
     *
     * @param starFansGroupDos
     */
    @Override
    public void insertInBatchStarFansGroup(List<StarFansGroupDo> starFansGroupDos) {
        mongoDbService.insertInBatch(starFansGroupDos, StarFansGroupDo.class);
    }

    /**
     * 更新投票总数
     *
     * @param starId
     * @param voteCount
     */
    @Override
    public void updateVoteCount(Long starId, Long voteCount) {
        // 构建criteria
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        // 实例化query
        Query query = new Query(criteria).limit(1);
        Update update = new Update();
        update.inc("voteCount", voteCount);
        mongoDbService.inc(query, update, StarFansGroupDo.class);
    }

    /**
     * 更新总守护数
     *
     * @param starId 一个用户一天只能守护这个明星一次
     */
    @Override
    public void updateGuardCount(Long starId) {
        // 构建criteria
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        // 实例化query
        Query query = new Query(criteria).limit(1);
        Update update = new Update();
        update.inc("guardCount");
        mongoDbService.inc(query, update, StarFansGroupDo.class);
    }

    /**
     * 更新总守护数
     *
     * @param starId
     * @param number
     */
    @Override
    public void updateGuardCount(Long starId,Long number) {
        // 构建criteria
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        // 实例化query
        Query query = new Query(criteria).limit(1);
        Update update = new Update();
        update.inc("guardCount",number);
        mongoDbService.inc(query, update, StarFansGroupDo.class);
    }


    /**
     * 更新加入粉丝会人数
     *
     * @param starId
     * @param userCount
     */
    @Override
    public boolean updateUserCount(Long starId, Integer userCount) {
        // 构建criteria
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        // 实例化query
        Query query = new Query(criteria).limit(1);
        Update update = new Update();
        update.inc("userCount", userCount);
        return mongoDbService.incByResult(query, update, StarFansGroupDo.class);
    }

    /**
     * 更新投票总用户数
     *
     * @param starId
     * @param
     */
    @Override
    public void incVoteUserCount(@NotNull Long starId) {
        Criteria criteria = Criteria.where("starId").is(starId).and("isDelete").is(IsValidEnums.NO.getValue());
        // 实例化query
        Query query = new Query(criteria).limit(1);
        Update update = new Update();
        update.inc("voteUserCount");
        mongoDbService.inc(query, update, StarFansGroupDo.class);
    }

    /**
     * 更新是否删除
     *
     * @param starId
     * @param isValidEnums
     */
    @Override
    public void updateIsDelete(Long starId, IsValidEnums isValidEnums) {
        // 构建criteria
        Criteria criteria = Criteria.where("starId").is(starId);
        // 创建query
        Query query = new Query(criteria);
        // 更新是否删除
        Map map = new HashMap(1);
        map.put("isDelete", isValidEnums.getValue());

        mongoDbService.updateOne(query, map, StarFansGroupDo.class);
    }

    /**
     * 查询所有粉丝会详细信息
     *
     * @return
     */
    @Override
    public List<StarFansGroupDo> findAll() {
        // 查询所有没有被删除的粉丝详细信息
        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
        // 查询返回数据
        return mongoDbService.findAll(query, StarFansGroupDo.class);
    }

    /**
     * 查询所有粉丝会带分页
     *
     * @param id
     * @param keyWord
     * @param
     * @param limit
     * @return
     */
    @Override
    public List<StarFansGroupDo> findAllStarFansGroup(String keyWord, String id,IsValidEnums isDelete,  @NotNull Integer limit) {
        Criteria criteria = new Criteria();

        if (StringUtils.isNotBlank(keyWord)) {
            criteria = createCriteriaBykeyWord(keyWord);
        }
        if (StringUtils.isNotBlank(id) ) {
                criteria.and("_id").lt(new ObjectId(id));
        }
        if (null !=isDelete){
            criteria.and("isDelete").is(isDelete.getValue());
        }
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).limit(limit).with(sort);

        return mongoDbService.findAll(query, StarFansGroupDo.class);
    }

    /**
     * 统计关键字搜索的个数
     *
     * @param keyWord
     * @return
     */
    @Override
    public Long countByKeyWords(String keyWord) {
        Criteria criteria = createCriteriaBykeyWord(keyWord);
        return mongoDbService.count(new Query(criteria), StarFansGroupDo.class);
    }


    @Override
    public List<StarFansGroupDo> findStarFansGroupById(Collection<Long> idList) {
        // 查询没有被删除的
        Criteria criteria = Criteria.where("isDelete").is(IsValidEnums.NO.getValue()).and("starId").in(idList);
        Query query = new Query(criteria);
        return mongoDbService.findAll(query, StarFansGroupDo.class);
    }

    /**
     * @param keyWord
     * @return
     */
    @Override
    public List<StarFansGroupDo> findFansGroupByKeyword(String keyWord) {

        Criteria criteria = createCriteriaBykeyWord(keyWord);
        criteria.and("isDelete").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria).limit(100);
        return mongoDbService.findAll(query, StarFansGroupDo.class);

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
        // 如果校验中+英不出来继续校验是否为外国明星
        if (!flag) {
            // 英文12位
            flag = keyWord.matches("[a-zA-Z]{1,12}");
        }
        //中文+数字
        if (!flag){
            flag = keyWord.matches("[\\u4e00-\\u9fa50-9]{1,8}");
        }

        if (flag) {
            // 左匹配忽略大小写
            return Criteria.where("starName").regex("^" + keyWord + ".*$", "i");
            // 模糊匹配
            //return Criteria.where("starName").regex("^.*"+keyWord+".*$","i");
        } else {
            return new Criteria();
        }

    }

    /**
     * 微博id查询明星粉丝会
     *
     * @param weiboId
     * @return
     */
    @Override
    public StarFansGroupDo findFansGroupByWeiboId(String weiboId) {
        Criteria criteria = Criteria.where("weiboId").is(weiboId);
        criteria.and("isDelete").is(IsValidEnums.NO.getValue());
        StarFansGroupDo one = mongoDbService.findOne(new Query(criteria), StarFansGroupDo.class);
        return one;
    }

    @Override
    public Long findMaxStarId() {
        Sort.Order order = Sort.Order.desc("starId");
        return Optional.of(mongoDbService
                .findOne(new Query().limit(1).with(Sort.by(order)), StarFansGroupDo.class)
                .getStarId()).orElse(0L);
    }

    /**
     * 统计粉丝会记录数
     *
     * @return
     */
    @Override
    public Long countStarFansGroup() {
        return mongoDbService.count(new Query(), StarFansGroupDo.class);
    }

    /**
     * 更新粉丝会推荐值
     *
     * @param starId
     * @param value
     */
    @Override
    public void updateRecommend(Long starId, long value) {
        Criteria criteria = Criteria.where("starId").is(starId);
        Map map = new HashMap(1);
        map.put("recommend", value);
        mongoDbService.updateOne(new Query(criteria), map, StarFansGroupDo.class);
    }

    @Override
    public void updatelastAdminUserId(Long starId, String lastAdminUserId) {
        Criteria criteria = Criteria.where("starId").is(starId);
        Map map = new HashMap(2);
        map.put("lastAdminUserId", lastAdminUserId);
        map.put("updateTime", System.currentTimeMillis());
        mongoDbService.update(new Query(criteria), map, StarFansGroupDo.class);
    }

    @Override
    public List<StarFansGroupDo> findStarByStarName(String starName) {
        Criteria criteria = Criteria.where("starName").is(starName);
        Query query = new Query(criteria);
        // 查询返回数据
        return mongoDbService.findAll(query, StarFansGroupDo.class);
    }

    /**
     * 查询粉丝会，不管删除不删除
     *
     * @param starId
     * @return
     */
    @Override
    public StarFansGroupDo findOneStarFansGroup(Long starId) {
        Criteria criteria = Criteria.where("starId").is(starId);
        return mongoDbService.findOne(new Query(criteria),StarFansGroupDo.class);
    }

    /**
     * 查询推荐的明星
     *
     * @return
     */
    @Override
    public List<StarFansGroupDo> findRecommendStar() {
        Sort sort = Sort.by(Sort.Order.desc("recommend"), Sort.Order.desc("createTime"));
        return mongoDbService.findAll(new Query().with(sort).limit(8),StarFansGroupDo.class);
    }

}
