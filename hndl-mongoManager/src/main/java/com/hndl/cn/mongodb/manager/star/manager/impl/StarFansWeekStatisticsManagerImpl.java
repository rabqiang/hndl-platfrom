package com.hndl.cn.mongodb.manager.star.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansWeekStatisticsDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansWeekStatisticsManager;
import com.hndl.cn.mongodb.utils.MongoDbUpdateUtils;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 19:49
 * @Created by 湖南达联
 */
@Service
public class StarFansWeekStatisticsManagerImpl implements StarFansWeekStatisticsManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void initStarFansWeekStatistics(Long userUniId, String userImg, String userNickName, Long starId, String starName, String starImg) {

        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfWeek());

        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        boolean flag = mongoDbService.count(new Query(criteria), StarFansWeekStatisticsDo.class) > 0;

        if (flag) {
            return;
        }

        //如果不存在则新建
        StarFansWeekStatisticsDo starFansWeekStatisticsDo = new StarFansWeekStatisticsDo();
        starFansWeekStatisticsDo.setUserUniId(userUniId);
        starFansWeekStatisticsDo.setUserNickName(userNickName);
        starFansWeekStatisticsDo.setUserImg(userImg);

        starFansWeekStatisticsDo.setStarImg(starImg);
        starFansWeekStatisticsDo.setStarName(starName);
        starFansWeekStatisticsDo.setStarId(starId);

        starFansWeekStatisticsDo.setCreateTime(nowDate);

        starFansWeekStatisticsDo.setCoinCount(0);
        starFansWeekStatisticsDo.setCommentCount(0);
        starFansWeekStatisticsDo.setGuardCount(0);
        starFansWeekStatisticsDo.setSummonCount(0);
        starFansWeekStatisticsDo.setLikeCount(0);
        starFansWeekStatisticsDo.setCallCount(0);

        starFansWeekStatisticsDo.setCoinCount(0);
        starFansWeekStatisticsDo.setIntegralCount(0);
        starFansWeekStatisticsDo.setGettingLoveCount(0);
        starFansWeekStatisticsDo.setVoteCount(0L);

        starFansWeekStatisticsDo.setFansContribute(0L);

        mongoDbService.insert(starFansWeekStatisticsDo);
    }

    @Override
    public void increaseVote(VoteTypeEnums voteTypeEnums, Long userUniId, Long starId, Long voteNum) {

        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfWeek());

        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        Update update = new Update();

        MongoDbUpdateUtils.setVoteUpdate(update, voteTypeEnums, voteNum);

        mongoDbService.inc(new Query(criteria), update, StarFansWeekStatisticsDo.class);
    }

    @Override
    public boolean upsertWeekVote(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg, VoteTypeEnums voteTypeEnums, Long voteNum) {
        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfWeek());

        Criteria criteria = Criteria.where("userUniId").is(userUinId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        //如果不存在则新建
        StarFansWeekStatisticsDo starFansWeekStatisticsDo = new StarFansWeekStatisticsDo();
        starFansWeekStatisticsDo.setUserUniId(userUinId);
        starFansWeekStatisticsDo.setUserNickName(userNickName);
        starFansWeekStatisticsDo.setUserImg(userImg);
        starFansWeekStatisticsDo.setStarImg(starImg);
        starFansWeekStatisticsDo.setStarName(starName);
        starFansWeekStatisticsDo.setStarId(starId);
        starFansWeekStatisticsDo.setCreateTime(nowDate);
        Update update = new Update();
        MongoDbUpdateUtils.setVoteUpdate(update, voteTypeEnums, voteNum);
        return mongoDbService.upsertInc(new Query(criteria).limit(1), starFansWeekStatisticsDo, update, StarFansWeekStatisticsDo.class);
    }

    @Override
    public boolean increaseFansContribute(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg, FansGroupContributeEnums fansGroupContributeEnums) {

        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfWeek());

        Criteria countCriteria = Criteria.where("userUniId").is(userUinId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        Update countUpdate = new Update();

        MongoDbUpdateUtils.setFansStatistics(countUpdate, fansGroupContributeEnums);

        StarFansWeekStatisticsDo starFansWeekStatisticsDo = new StarFansWeekStatisticsDo();
        starFansWeekStatisticsDo.setUserUniId(userUinId);
        starFansWeekStatisticsDo.setUserNickName(userNickName);
        starFansWeekStatisticsDo.setUserImg(userImg);
        starFansWeekStatisticsDo.setStarId(starId);
        starFansWeekStatisticsDo.setCreateTime(nowDate);
        starFansWeekStatisticsDo.setStarName(starName);
        starFansWeekStatisticsDo.setStarImg(starImg);
        //用户每天的行为
        return mongoDbService.upsertInc(new Query(countCriteria).limit(1), starFansWeekStatisticsDo, countUpdate, StarFansWeekStatisticsDo.class);
    }

    @Override
    public List<StarFansWeekStatisticsDo> findByDate(LocalDate nowDate, Integer limit) {
        Criteria criteria = Criteria.where("createTime").is(LocalDateUtil.localDateToMilliSecond(nowDate)).and("fansContribute").ne(0L).ne(null);

        Query query = new Query(criteria);
        query.limit(limit);
        query.with(Sort.by(Sort.Order.desc("fansContribute")));

        return mongoDbService.findAll(query, StarFansWeekStatisticsDo.class);
    }

    @Override
    public StarFansWeekStatisticsDo findStarFansDayMaxContribute(Long userUniId) {
        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth());

        Criteria criteria = Criteria.where("createTime").is(nowDate).and("userUniId").is(userUniId).and("fansContribute").ne(0L);

        Query query = new Query(criteria);

        query.with(Sort.by(Sort.Order.desc("fansContribute")));

        return mongoDbService.findOne(query, StarFansWeekStatisticsDo.class);
    }


    @Override
    public void updateStarFansWeekGetUserNickName(Long userUniId, String value) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
        Map map = new HashMap(1);
        map.put("userNickName", value);
        mongoDbService.update(query, map, StarFansWeekStatisticsDo.class);
    }

    @Override
    public void updateStarFansWeekGetUserImgUrl(Long userUniId, String value) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
        Map map = new HashMap(1);
        map.put("userImg", value);
        mongoDbService.update(query, map, StarFansWeekStatisticsDo.class);
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
        map.put("starImg", img);
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
        mongoDbService.update(query, map, StarFansWeekStatisticsDo.class);
    }

    /**
     * 修改明星名字
     *
     * @param starName
     * @param starId
     */
    @Override
    public void updateStarNameByStarId(String starName, Long starId) {
        Criteria criteria = Criteria.where("starId").is(starId);
        Map map = new HashMap(1);
        map.put("starName", starName);
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
        mongoDbService.update(query, map, StarFansWeekStatisticsDo.class);
    }

}
