package com.hndl.cn.mongodb.manager.star.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.fans.FansGroupContributeEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansMonthStatisticsDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansMonthStatisticsManager;
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
 * @Date 2019/4/29 20:22
 * @Created by 湖南达联
 */
@Service
public class StarFansMonthStatisticsManagerImpl implements StarFansMonthStatisticsManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void initStarFansMonthStatistics(Long userUniId, String userImg, String userNickName, Long starId, String starName, String starImg) {

        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth());

        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        boolean flag = mongoDbService.count(new Query(criteria), StarFansMonthStatisticsDo.class) > 0;

        if (flag) {
            return;
        }

        //如果不存在则新建
        StarFansMonthStatisticsDo starFansMonthStatisticsDo = new StarFansMonthStatisticsDo();
        starFansMonthStatisticsDo.setUserUniId(userUniId);
        starFansMonthStatisticsDo.setUserNickName(userNickName);
        starFansMonthStatisticsDo.setUserImg(userImg);
        starFansMonthStatisticsDo.setStarImg(starImg);
        starFansMonthStatisticsDo.setStarName(starName);
        starFansMonthStatisticsDo.setStarId(starId);
        starFansMonthStatisticsDo.setCreateTime(nowDate);

        starFansMonthStatisticsDo.setCoinCount(0);
        starFansMonthStatisticsDo.setCommentCount(0);
        starFansMonthStatisticsDo.setGuardCount(0);
        starFansMonthStatisticsDo.setSummonCount(0);
        starFansMonthStatisticsDo.setLikeCount(0);
        starFansMonthStatisticsDo.setCallCount(0);

        starFansMonthStatisticsDo.setCoinCount(0);
        starFansMonthStatisticsDo.setIntegralCount(0);
        starFansMonthStatisticsDo.setGettingLoveCount(0);
        starFansMonthStatisticsDo.setVoteCount(0L);

        starFansMonthStatisticsDo.setFansContribute(0L);
        mongoDbService.insert(starFansMonthStatisticsDo);
    }

    @Override
    public void increaseVote(VoteTypeEnums voteTypeEnums, Long userUniId, Long starId, Long voteNum) {
        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth());

        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        Update update = new Update();

        MongoDbUpdateUtils.setVoteUpdate(update, voteTypeEnums, voteNum);

//        System.out.println("月榜打榜数nowDate == "+nowDate +"," + voteNum);

        mongoDbService.inc(new Query(criteria), update, StarFansMonthStatisticsDo.class);
    }

    @Override
    public boolean increaseFansContribute(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg,FansGroupContributeEnums fansGroupContributeEnums) {
        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth());

        Criteria criteria = Criteria.where("userUniId").is(userUinId).and("starId").is(starId)
                .and("createTime").is(nowDate);


        Update conduct = new Update();

        MongoDbUpdateUtils.setFansStatistics(conduct, fansGroupContributeEnums);

        //如果不存在则新建
        StarFansMonthStatisticsDo starFansMonthStatisticsDo = new StarFansMonthStatisticsDo();
        starFansMonthStatisticsDo.setUserUniId(userUinId);
        starFansMonthStatisticsDo.setUserNickName(userNickName);
        starFansMonthStatisticsDo.setUserImg(userImg);
        starFansMonthStatisticsDo.setStarImg(starImg);
        starFansMonthStatisticsDo.setStarName(starName);
        starFansMonthStatisticsDo.setStarId(starId);
        starFansMonthStatisticsDo.setCreateTime(nowDate);

        return mongoDbService.upsertInc(new Query(criteria).limit(1),starFansMonthStatisticsDo,conduct,StarFansMonthStatisticsDo.class);
    }

    @Override
    public boolean upsertMonthVote(Long userUinId, String userImg, String userNickName, Long starId, String starName, String starImg, VoteTypeEnums voteTypeEnums, Long voteNum) {
        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth());

        Criteria criteria = Criteria.where("userUniId").is(userUinId).and("starId").is(starId)
                .and("createTime").is(nowDate);

        Update update = new Update();

        MongoDbUpdateUtils.setVoteUpdate(update, voteTypeEnums, voteNum);

        //如果不存在则新建
        StarFansMonthStatisticsDo starFansMonthStatisticsDo = new StarFansMonthStatisticsDo();
        starFansMonthStatisticsDo.setUserUniId(userUinId);
        starFansMonthStatisticsDo.setUserNickName(userNickName);
        starFansMonthStatisticsDo.setUserImg(userImg);
        starFansMonthStatisticsDo.setStarImg(starImg);
        starFansMonthStatisticsDo.setStarName(starName);
        starFansMonthStatisticsDo.setStarId(starId);
        starFansMonthStatisticsDo.setCreateTime(nowDate);

        return mongoDbService.upsertInc(new Query(criteria).limit(1),starFansMonthStatisticsDo,update,StarFansMonthStatisticsDo.class);
    }

    @Override
    public List<StarFansMonthStatisticsDo> findByDate(LocalDate nowDate, Integer limit) {
        Criteria criteria = Criteria.where("createTime").is(LocalDateUtil.localDateToMilliSecond(nowDate)).and("fansContribute").ne(0L).ne(null);

        Query query = new Query(criteria);
        query.limit(limit);
        query.with(Sort.by(Sort.Order.desc("fansContribute")));
        return mongoDbService.findAll(query, StarFansMonthStatisticsDo.class);
    }

    @Override
    public StarFansMonthStatisticsDo findStarFansDayMaxContribute(Long userUniId) {
        Long nowDate = LocalDateUtil.localDateToMilliSecond(LocalDate.now());

        Criteria criteria = Criteria.where("createTime").is(nowDate).and("userUniId").is(userUniId).and("fansContribute").ne(0L);

        Query query = new Query(criteria);

        query.with(Sort.by(Sort.Order.desc("fansContribute")));

        return mongoDbService.findOne(query, StarFansMonthStatisticsDo.class);
    }


    @Override
    public void updateStarFansMonthGetUserImgUrl(Long userUniId, String value) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
       Map map = new HashMap(1);
        map.put("userImg", value);
        mongoDbService.update(query, map, StarFansMonthStatisticsDo.class);

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
        mongoDbService.update(query,map, StarFansMonthStatisticsDo.class);
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
        mongoDbService.update(query,map, StarFansMonthStatisticsDo.class);
    }

    @Override
    public void updateStarFansMonthGetUserNickName(Long userUniId, String value) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria).with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
        Map map = new HashMap(1);
        map.put("userNickName", value);
        mongoDbService.update(query, map, StarFansMonthStatisticsDo.class);

    }
}
