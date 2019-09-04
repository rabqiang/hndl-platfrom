package com.hndl.cn.mongodb.manager.star.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
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
 * @Description TODO
 * @Date 2019/4/25 14:58
 * @Created by 湖南达联
 */
@Service
public class StarDayRankManagerImpl implements StarDayRankManager {

    @Resource
    private MongoDbService mongoDbService;



    @Override
    public List<StarDayRankDo> findStarDayRankByRankDate(Long date,Integer limit) {

        Criteria criteria = Criteria.where("rankTime").is(date);
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("voteCount")));
        if(limit != null){
            query.limit(limit);
        }
        return mongoDbService.findAll(query,StarDayRankDo.class);
    }


    @Override
    public void increaseVote(VoteTypeEnums voteTypeEnums, Long starId, Long voteNum) {

        Long nowDate = DateUtil.beginOfDate(new Date()).getTime();

        Criteria criteria = Criteria.where("rankTime").is(nowDate).and("starId").is(starId);

        Update update = new Update();
        switch (voteTypeEnums){
            case LOVE_VOTE:
                update.inc("gettingLoveCount",voteNum);
                break;
            case INTEGRAL_VOTE:
                update.inc("integralCount",voteNum);
                break;
            case COIN_VOTE:
                update.inc("coinCount",voteNum);
                break;
                default:
                    return;
        }
        update.inc("voteCount",voteNum);
        mongoDbService.inc(new Query(criteria),update,StarDayRankDo.class);
    }

    @Override
    public void updateCurrentRank(String id,Integer currentRank) {
        Criteria criteria = Criteria.where("_id").is(id);
        StarDayRankDo starDayRankDo = new StarDayRankDo();
        starDayRankDo.setCurrentRank(currentRank);
        mongoDbService.update(new Query(criteria),starDayRankDo,StarDayRankDo.class);
    }

    @Override
    public void insertInBatch(List<StarDayRankDo> starDayRankDos) {
        mongoDbService.insertInBatch(starDayRankDos,StarDayRankDo.class);
    }

    /**
     * 查询一个明星的日榜数据
     *
     * @param starId
     * @return
     */
    @Override
    public StarDayRankDo findCurrentRankByStarId(Long starId) {
        Criteria criteria = Criteria.where("rankTime").is(LocalDateUtil.localDateToMilliSecond(LocalDate.now())).and("starId").is(starId);
        return mongoDbService.findOne(new Query(criteria),StarDayRankDo.class);
    }

    /**
     * 更新粉丝会头像
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
        mongoDbService.update(query,map,StarDayRankDo.class);
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

        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("createTime"))).limit(BaseConstants.UPDATE_MAX_LIMIT);
        mongoDbService.update(query,map,StarDayRankDo.class);
    }
}
