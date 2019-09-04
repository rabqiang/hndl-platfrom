package com.hndl.cn.mongodb.manager.user.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import org.aspectj.weaver.ast.Var;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/4/18 11:29
 * @Created by 湖南达联
 */
@Service
public class UserStatisticsDoManagerImpl implements UserStatisticsDoManager {


    //连接MongoDB的服务接口
    @Resource
    private MongoDbService mongoDbService;


    @Override
    public void deleteUser(Long userUniId) {
        mongoDbService.delete(new Query(Criteria.where("userUniId").is(userUniId)), UserStatisticsDo.class);
    }



    @Override
    public void initUserStatistics(UserStatisticsDo userStatisticsDo) {
        mongoDbService.insert(userStatisticsDo);
    }


    @Override
    public void userStatisticsAddEmpirical(Long userUniId, UserDayEmpiricalTypeEnums userDayEmpiricalTypeEnums) {
        Query query = new Query(Criteria.where("userUniId").is(userUniId));
        Update update = new Update();
        update.inc("empirical", userDayEmpiricalTypeEnums.getEmpirical());
        mongoDbService.inc(query, update, UserStatisticsDo.class);
    }

    @Override
    public void userStatisticsAddEmpirical(Long userUinId, Long empiricalNum) {
        Query query = new Query(Criteria.where("userUniId").is(userUinId));
        Update update = new Update();
        update.inc("empirical", empiricalNum);
        mongoDbService.inc(query, update, UserStatisticsDo.class);
    }

    @Override
    public void userAddFoucaultCount(Long userUniId, Integer foucaCount) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria);
        Update update = new Update();
        update.inc("foucaultCount",foucaCount);
        mongoDbService.inc(query,update, UserStatisticsDo.class);
    }

    @Override
    public boolean userUpdateFoucaultCount(Long userUinId, Integer foucaCount) {
        Criteria criteria = Criteria.where("userUniId").is(userUinId).and("foucaultCount").ne(0).ne(null).gte(foucaCount);
        Query query = new Query(criteria);
        Update update = new Update();
        update.inc("foucaultCount",- foucaCount);
        return mongoDbService.incByResult(query, update, UserStatisticsDo.class);
    }

    @Override
    public boolean userStatisticsAddIntegralCount(Long userUniId, Long integralCount, IsValidEnums isValidEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Update update = new Update();

        //如果是 一 是支出就还要判断原本有的值是否满足要扣除的值
        if (isValidEnums.getValue().equals(IsValidEnums.YES.getValue())) {
            criteria.and("integralCount").gte(integralCount);
            integralCount = -integralCount;
        }

        update.inc("integralCount", integralCount);
//        一支出,零收入
        return mongoDbService.incByResult(new Query(criteria), update, UserStatisticsDo.class);
    }

    @Override
    public UserStatisticsDo findAndAddIntegralCount(Long userUinId, Long integralCount, IsValidEnums isValidEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUinId);
        Update update = new Update();
        //如果是 一 是支出就还要判断原本有的值是否满足要扣除的值
        if (isValidEnums.getValue().equals(IsValidEnums.YES.getValue())) {
            criteria.and("integralCount").gte(integralCount);
            integralCount = -integralCount;
        }
        update.inc("integralCount", integralCount);
        return mongoDbService.findAndModify(Query.query(criteria),update,UserStatisticsDo.class);
    }

    @Override
    public void userStatisticsAddCumulativeReward(Long userUinId, Integer cumulativeReward) {
        Criteria criteria = Criteria.where("userUniId").is(userUinId);
        Query query = new Query(criteria);
        Update update = new Update();
        update.inc("cumulativeReward",cumulativeReward);
        mongoDbService.inc(query, update, UserStatisticsDo.class);
    }


    @Override
    public void userStatisticsAddSlaveCount(UserStatisticsDo userStatisticsDo) {
        Criteria criteria = Criteria.where("userUniId").is(userStatisticsDo.getUserUniId());
        Query query = new Query(criteria);
        Update update = new Update();
        update.inc("slaveCount", userStatisticsDo.getSlaveCount());
        mongoDbService.inc(query, update, UserStatisticsDo.class);
    }


    @Override
    public void userStatisticsAddSspreadCount(Long userUniId, Integer spreadCount) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId);
        Query query = new Query(criteria);
        Update update = new Update();
        update.inc("spreadCount", spreadCount);
        mongoDbService.inc(query, update, UserStatisticsDo.class);
    }


    @Override
    public boolean userStatisticsAddGettingLoveCount(Long userUniId, Long gettingLoveCount, IsValidEnums isValidEnums) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("gettingLoveTime").is(LocalDateTimeUtil.getNowMinTimeMilli());
        Update update = new Update();
        //如果是 一 是支出就还要判断原本有的值是否满足要扣除的值
        switch (isValidEnums) {
            case NO:
                gettingLoveCount = +gettingLoveCount;
                break;
            case YES:
                criteria.and("gettingLoveCount").gte(gettingLoveCount);
                gettingLoveCount = -gettingLoveCount;
                break;
            default:
                return false;
        }
//        一 是收入直接增加就好
        update.inc("gettingLoveCount", gettingLoveCount);
        update.inc("gettingLoveTime", LocalDateTimeUtil.getNowMinTimeMilli());

        return mongoDbService.incByResult(new Query(criteria), update, UserStatisticsDo.class);

    }


    @Override
    public void initUserGettingLoveCount() {
        mongoDbService.update(new Query(), new Update().inc("gettingLoveCount", 0), UserStatisticsDo.class);
    }

    @Override
    public void updateUserStatistics(UserStatisticsDo userStatisticsDo) {
        mongoDbService.update(new Query(Criteria.where("userUniId").is(userStatisticsDo.getUserUniId())), userStatisticsDo, UserStatisticsDo.class);
    }


    @Override
    public UserStatisticsDo findUserStatisticsByUserUinId(Long userUniId) {
        return mongoDbService.findOne(new Query(Criteria.where("userUniId").is(userUniId)), UserStatisticsDo.class);
    }

    @Override
    public Integer findUserGetFoucaultCountsByUserUinId(Long userUinId) {
        return mongoDbService.findOne(new Query(Criteria.where("userUniId").is(userUinId)),UserStatisticsDo.class).getFoucaultCount();
    }

    @Override
    public boolean getUser(Long userUniId) {

        return mongoDbService.findOne(new Query(Criteria.where("userUniId").is(userUniId)), UserStatisticsDo.class) != null;
    }


}
