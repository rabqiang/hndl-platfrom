package com.hndl.cn.mongodb.manager.luckdraw.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/24 16:26
 * @Created by 湖南达联
 */
@Service
public class HelpWelfareManagerImpl implements HelpWelfareManager {
    @Resource
    private MongoDbService mongoDbService;


    /**
     * 增加福利商品
     *
     * @param helpWelfareDo
     */
    @Override
    public void insertHelpWelfare(HelpWelfareDo helpWelfareDo) {
        helpWelfareDo.setCreateTime(System.currentTimeMillis());
        helpWelfareDo.setNowSumCount(0);                        //当前助力值
        helpWelfareDo.setIsSuccess(IsValidEnums.NO.getValue());  //设置未开奖
        helpWelfareDo.setSuccessUserUniId(new ArrayList<>());   //中奖人id
        helpWelfareDo.setSuccessTime(0L);                       //开奖时间
        helpWelfareDo.setIsDelete(IsValidEnums.NO.getValue()); //是否删除
        mongoDbService.insert(helpWelfareDo);
    }

    /**
     * 修改商品属性
     *
     * @param helpWelfareDo
     */
    @Override
    public void updateHelpWelfare(HelpWelfareDo helpWelfareDo) {
        Query query = new Query(Criteria.where("welfareNumber").is(helpWelfareDo.getWelfareNumber()));
        mongoDbService.update(query, helpWelfareDo, HelpWelfareDo.class);
    }


    /**
     * 增加当前助力值
     *
     * @param welfareNumber 福利商品期号
     * @param nowSumCount   助力值
     */
    @Override
    public void addHelpUserNowSumCount(String welfareNumber, Integer nowSumCount) {
        Criteria criteria = Criteria.where("welfareNumber").is(welfareNumber);
        Query query = new Query(criteria);
        Update update = new Update();
        update.inc("nowSumCount", nowSumCount);
        mongoDbService.inc(query, update, HelpWelfareDo.class);
    }

    /**
     * 给未达到开奖条件的奖品,状态修改为失效
     *
     * @param welfareNumber 福利商品期货
     */
    @Override
    public boolean updateHelpUserInvalid(String welfareNumber) {
        //查询商品已经超过开奖时间并且还是未开奖状态
        Criteria criteria = Criteria.where("welfareNumber").is(welfareNumber)
                .and("isSuccess").ne(IsValidEnums.YES.getValue());
        Update update = new Update();
        update.set("isSuccess", 2);
        update.set("successTime", System.currentTimeMillis());
        return mongoDbService.incByResult(new Query(criteria), update, HelpWelfareDo.class);
    }

    /**
     * 修改开奖状态
     *
     * @param welfareNumber    福利商品期号
     * @param successUserUniId 中奖人id
     */
    @Override
    public boolean updateHelpUserLottery(String welfareNumber,  List<Long> successUserUniId) {
        Criteria criteria = Criteria.where("welfareNumber").is(welfareNumber)
                .and("isSuccess").is(IsValidEnums.NO.getValue());
        Update update = new Update();
        update.set("isSuccess", IsValidEnums.YES.getValue());
        update.set("successTime", System.currentTimeMillis());
        update.set("successUserUniId", successUserUniId);
        return mongoDbService.incByResult(new Query(criteria), update, HelpWelfareDo.class);
    }


    /**
     * 查询福利商品
     *
     * @param id           _id
     * @param prizeName    奖品名称
     * @param isValidEnums 是否已开奖(0.否| 1.是 |2.开奖失败)
     * @param limit        分页大小
     * @return
     */
    @Override
    public List<HelpWelfareDo> findHelpUserById(String id, String prizeName, Integer isValidEnums, Integer limit) {
        Criteria criteria = new Criteria();
        if (id != null) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        if (prizeName != null) {
            criteria.and("prizeName").is(prizeName);
        }
        if (isValidEnums != null) {
            criteria.and("isSuccess").is(isValidEnums);
        }
        //根据_id倒序

        Sort sort = Sort.by(Sort.Order.desc("_id"));
        //加分页的页数
        Query query = new Query(criteria).with(sort);
        if (limit != null) {
            query.limit(limit);
        }
        return mongoDbService.findAll(query, HelpWelfareDo.class);
    }

    /**
     * 获取当日上传数量
     *
     * @return
     */
    @Override
    public Long countAddCommodity() {
        Criteria criteria = Criteria.where("createTime").gte(LocalDateTimeUtil.getNowMinTimeMilli())
                .lte(LocalDateTimeUtil.getNowMaxTimeMilli());
        Query query = new Query(criteria);
        return mongoDbService.count(query, HelpWelfareDo.class);
    }

    @Override
    public HelpWelfareDo findWelfarePrizeById(String id) {
        Criteria criteria = new Criteria().and("_id").is(new ObjectId(id));
        return mongoDbService.findOne(new Query(criteria), HelpWelfareDo.class);
    }

    @Override
    public List<HelpWelfareDo> findSuccessWelfarePrize(IsValidEnums isValidEnums, Long showTime, Long successTime) {
        Criteria criteria = new Criteria();
        if (isValidEnums != null) {
            criteria.and("isSuccess").is(isValidEnums.getValue());
        }
        if (showTime != null) {
            criteria.and("endTime").lte(showTime);
        }
        if (successTime != null) {
            criteria.and("successTime").gte(successTime);
        }
        criteria.and("isDelete").is(IsValidEnums.NO.getValue());
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "createTime");
        Sort sort = new Sort(order);
        Query query = new Query(criteria).with(sort);
        return mongoDbService.findAll(query, HelpWelfareDo.class);
    }

    @Override
    public List<HelpWelfareDo> findIsValidWelfarePrize(String id) {
        Criteria criteria = new Criteria();
        if (id != null) {
            criteria.and("_id").gt(new ObjectId(id));
        }
        criteria.and("isSuccess").is(IsValidEnums.NO.getValue());
        criteria.and("isDelete").is(IsValidEnums.NO.getValue());
        criteria.and("startTime").lt(System.currentTimeMillis()).and("endTime").gte(System.currentTimeMillis());
        // 这里本来是根据开抢时间倒序, 因为会出现分页bug, 修改成了根据创建时间正序
        Sort sort = Sort.by(Sort.Order.desc("createTime"));
        Query query = new Query(criteria).with(sort);
        query.limit(NumberEnums.TEN.getNumber());
        return mongoDbService.findAll(query, HelpWelfareDo.class);
    }

    @Override
    public HelpWelfareDo findWelfarePrizeByWelfareNumber(String welfareNumber) {
        Criteria criteria = new Criteria().and("welfareNumber").is(welfareNumber);
        return mongoDbService.findOne(new Query(criteria), HelpWelfareDo.class);
    }

    @Override
    public List<HelpWelfareDo> findSuccessAll(Long endTime) {
        Criteria criteria = Criteria.where("endTime").lte(DateUtil.subMinutes(new Date(endTime), 3).getTime())
                .and("isSuccess").is(IsValidEnums.NO.getValue());
        Query query = new Query(criteria);
        return mongoDbService.findAll(query, HelpWelfareDo.class);
    }
}
