package com.hndl.cn.mongodb.manager.star.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarMonthRankDo;
import com.hndl.cn.mongodb.manager.star.manager.StarMonthRankManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/26 14:46
 * @Created by 湖南达联
 */
@Service
public class StarMonthRankManagerImpl implements StarMonthRankManager {

    @Resource
    private MongoDbService mongoDbService;


    @Override
    public void insertInBatch(List<StarMonthRankDo> starMonthRankDos) {
        mongoDbService.insertInBatch(starMonthRankDos,StarMonthRankDo.class);
    }

    @Override
    public List<StarMonthRankDo> findByRankDate(Long rankTime,Integer limit) {
        Criteria criteria = Criteria.where("rankTime").is(rankTime);
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("voteCount")));
        if(limit != null){
            query.limit(limit);
        }
        return mongoDbService.findAll(query,StarMonthRankDo.class);
    }

    @Override
    public void increaseVote(VoteTypeEnums voteTypeEnums, Long starId, Long voteNum) {
        Long rankTime  = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth());

        Criteria criteria = Criteria.where("rankTime").is(rankTime)
                .and("starId").is(starId);


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
        mongoDbService.inc(new Query(criteria),update,StarMonthRankDo.class);
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
        Query query = new Query(criteria).limit(BaseConstants.UPDATE_MAX_LIMIT).with(Sort.by(Sort.Order.desc("createTime")));
        mongoDbService.update(query,map, StarMonthRankDo.class);
    }

    /**
     * 更新明星名字
     *
     * @param starName
     * @param starId
     */
    @Override
    public void updateStarNameByStarId(String starName, Long starId) {
        Criteria criteria = Criteria.where("starId").is(starId);
        Map map = new HashMap(1);
        map.put("starName",starName);
        Query query = new Query(criteria).limit(BaseConstants.UPDATE_MAX_LIMIT).with(Sort.by(Sort.Order.desc("createTime")));
        mongoDbService.update(query,map,StarMonthRankDo.class);
    }
}
