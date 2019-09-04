package com.hndl.cn.mongodb.manager.star.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansDayStatisticsDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mongodb.utils.MongoDbUpdateUtils;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description
 * @Date 2019/4/25 11:37
 * @Created by 湖南达联
 */
@Service
public class StarFansDayStatisticsManagerImpl implements StarFansDayStatisticsManager {

    @Resource
    private MongoDbService mongoDbService;


    @Override
    public void initStarFansDayStatistics(Long userUniId, String userImg, String userNickName,
                                          Long starId, String starName, String starImg) {

        Long nowDate = DateUtil.beginOfDate(new Date()).getTime();

        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        boolean flag = mongoDbService.count(new Query(criteria), StarFansDayStatisticsDo.class) > 0;

        if (flag) {
            return;
        }

        //如果不存在则新建
        StarFansDayStatisticsDo starFansDayStatisticsDo = new StarFansDayStatisticsDo();
        starFansDayStatisticsDo.setUserUniId(userUniId);
        starFansDayStatisticsDo.setUserNickName(userNickName);
        starFansDayStatisticsDo.setUserImg(userImg);
        starFansDayStatisticsDo.setStarId(starId);
        starFansDayStatisticsDo.setCreateTime(nowDate);
        starFansDayStatisticsDo.setStarName(starName);
        starFansDayStatisticsDo.setStarImg(starImg);

        starFansDayStatisticsDo.setCommentCount(0);
        starFansDayStatisticsDo.setGuardCount(0);
        starFansDayStatisticsDo.setSummonCount(0);
        starFansDayStatisticsDo.setLikeCount(0);
        starFansDayStatisticsDo.setCallCount(0);

        starFansDayStatisticsDo.setCoinCount(0);
        starFansDayStatisticsDo.setIntegralCount(0);
        starFansDayStatisticsDo.setGettingLoveCount(0);
        starFansDayStatisticsDo.setVoteCount(0L);

        starFansDayStatisticsDo.setFansContribute(0L);
        mongoDbService.insert(starFansDayStatisticsDo);

    }

    @Override
    public void increaseVote(VoteTypeEnums voteTypeEnums, Long userUniId, Long starId, Long voteNum) {

        Long nowDate = DateUtil.beginOfDate(new Date()).getTime();

        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        Update update = new Update();
        MongoDbUpdateUtils.setVoteUpdate(update, voteTypeEnums, voteNum);

        mongoDbService.inc(new Query(criteria), update, StarFansDayStatisticsDo.class);
    }

    @Override
    public boolean upsertDayVote(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg, VoteTypeEnums voteTypeEnums, Long voteNum) {
        Long nowDate = DateUtil.beginOfDate(new Date()).getTime();

        Criteria criteria = Criteria.where("userUniId").is(userUinId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        Update update = new Update();
        MongoDbUpdateUtils.setVoteUpdate(update, voteTypeEnums, voteNum);
        StarFansDayStatisticsDo starFansDayStatisticsDo = new StarFansDayStatisticsDo();
        starFansDayStatisticsDo.setUserUniId(userUinId);
        starFansDayStatisticsDo.setUserNickName(userNickName);
        starFansDayStatisticsDo.setUserImg(userImg);
        starFansDayStatisticsDo.setStarId(starId);
        starFansDayStatisticsDo.setCreateTime(nowDate);
        starFansDayStatisticsDo.setStarName(starName);
        starFansDayStatisticsDo.setStarImg(starImg);
        return mongoDbService.upsertInc(new Query(criteria).limit(1),starFansDayStatisticsDo,update,StarFansDayStatisticsDo.class);
    }

    @Override
    public boolean increaseFansContribute(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg,FansGroupContributeEnums fansGroupContributeEnums) {
        Long nowDate = DateUtil.beginOfDate(new Date()).getTime();

        Criteria countCriteria = Criteria.where("userUniId").is(userUinId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        Update countUpdate = new Update();

        MongoDbUpdateUtils.setFansStatistics(countUpdate, fansGroupContributeEnums);

        StarFansDayStatisticsDo starFansDayStatisticsDo = new StarFansDayStatisticsDo();
        starFansDayStatisticsDo.setUserUniId(userUinId);
        starFansDayStatisticsDo.setUserNickName(userNickName);
        starFansDayStatisticsDo.setUserImg(userImg);
        starFansDayStatisticsDo.setStarId(starId);
        starFansDayStatisticsDo.setCreateTime(nowDate);
        starFansDayStatisticsDo.setStarName(starName);
        starFansDayStatisticsDo.setStarImg(starImg);

        //用户每天的行为
        return mongoDbService.upsertInc(new Query(countCriteria).limit(1),starFansDayStatisticsDo,countUpdate,StarFansDayStatisticsDo.class);

    }

    @Override
    public List<StarFansDayStatisticsDo> findByDate(LocalDate localDate, Integer limit) {

        Long nowDate = LocalDateUtil.localDateToMilliSecond(localDate);

        Criteria criteria = Criteria.where("createTime").is(nowDate).and("fansContribute").ne(0L).ne(null);

        Query query = new Query(criteria);

        query.limit(limit);

        query.with(Sort.by(Sort.Order.desc("fansContribute")));

        return mongoDbService.findAll(query, StarFansDayStatisticsDo.class);
    }

    @Override
    public List<StarFansDayStatisticsDo> findByDate(LocalDate localDate) {
        Long nowDate = LocalDateUtil.localDateToMilliSecond(localDate);
        Criteria criteria = Criteria.where("createTime").is(nowDate).and("fansContribute").ne(0L);
        Query query = new Query(criteria);

        query.with(Sort.by(Sort.Order.desc("fansContribute")));
        return mongoDbService.findAll(query, StarFansDayStatisticsDo.class);
    }

    /**
     * 查询数据
     *
     * @param userUinId
     */
    @Override
    public StarFansDayStatisticsDo findStarFansDayStatistics(Long userUinId, Long starId) {

        Long nowDate = DateUtil.beginOfDate(new Date()).getTime();

        Criteria criteria = Criteria.where("userUniId").is(userUinId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        return mongoDbService.findOne(new Query(criteria), StarFansDayStatisticsDo.class);
    }

    /**
     * 统计用户今天守护了几个明星
     *
     * @param userUniId
     * @return
     */
    @Override
    public Long countStarFansDayStatistics(Long userUniId) {

        Long nowDate = DateUtil.beginOfDate(new Date()).getTime();

        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("createTime").is(nowDate);

        return mongoDbService.count(new Query(criteria), StarFansDayStatisticsDo.class);
    }

    @Override
    public StarFansDayStatisticsDo findStarFansDayMaxContribute(Long userUinId) {
        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDate.now());

        Criteria criteria = Criteria.where("createTime").is(nowDate).and("userUniId").is(userUinId).and("fansContribute").ne(0L).ne(null);

        Query query = new Query(criteria);

        query.with(Sort.by(Sort.Direction.DESC, "fansContribute"));

        return mongoDbService.findOne(query, StarFansDayStatisticsDo.class);
    }


    @Override
    public void updateStarFansDayByNickName(Long userUniId, String value) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("userNickName", value);
        mongoDbService.inc(query, update, StarFansDayStatisticsDo.class);

    }

    @Override
    public void updateStarFansDayByImgUrl(Long userUniId, String value) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("userImg", value);
        mongoDbService.inc(query, update, StarFansDayStatisticsDo.class);


    }

    /**
     * 修改明星头像
     *
     * @param img
     * @param starId
     */
    @Override
    public void updateImgByStarId(String img, Long starId) {
        Criteria criteria = Criteria.where("starId").is(starId);
        Map map = new HashMap(1);
        map.put("starImg",img);
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
        mongoDbService.update(query,map,  StarFansDayStatisticsDo.class);
    }

    /**
     * 更新粉丝会名字
     *
     * @param starName
     * @param starId
     */
    @Override
    public void updateStarNameByStarId(String starName, Long starId) {
        Criteria criteria = Criteria.where("starId").is(starId);
        Map map = new HashMap(1);
        map.put("starName",starName);
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
        mongoDbService.update(query,map, StarFansDayStatisticsDo.class);
    }

    /**
     * 查询用户是否投过票
     *
     * @param starId
     * @param userUniId
     * @return
     */
    @Override
    public boolean findVote(Long starId, Long userUniId) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("starId").is(starId).and("voteCount").gt(0L);

        return   mongoDbService.count(new Query(criteria).limit(1),StarFansDayStatisticsDo.class) > 0;

    }
}
