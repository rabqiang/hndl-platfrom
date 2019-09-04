package com.hndl.cn.mongodb.manager.luckdraw.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.UserWelfareMappingManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/24 16:21
 * @Created by 湖南达联
 */
@Service
public class UserWelfareMappingManagerImpl implements UserWelfareMappingManager {
    @Resource
    private MongoDbService mongoDbService;

    /**
     * 增加用户参与助力数
     *
     * @param userWelfareMappingDo
     */
    @Override
    public void addUserWelfareMapping(UserWelfareMappingDo userWelfareMappingDo) {
        userWelfareMappingDo.setCreateTime(System.currentTimeMillis()); //设置创建时间
        userWelfareMappingDo.setIsDelete(IsValidEnums.NO.getValue()); //设置未删除
        userWelfareMappingDo.setLastModifyTime(System.currentTimeMillis());//设置最后修改时间
        mongoDbService.insert(userWelfareMappingDo);
    }

    /**
     * 增加个人某商品助力值
     *
     * @param userUniId     用户id
     * @param welfareNumber 商品期号
     * @param helpCount     增加的助力数
     */
    @Override
    public void addUserWelfareGetHelpCount(Long userUniId, String welfareNumber, Integer helpCount, Integer lastHelpCount) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("welfareNumber").is(welfareNumber);
        Update update = new Update();
        update.inc("helpCount", helpCount);
        update.set("lastModifyTime", System.currentTimeMillis());
        update.set("lastHelpCount",lastHelpCount);
        mongoDbService.inc(new Query(criteria), update, UserWelfareMappingDo.class);
    }

    @Override
    public List<UserWelfareMappingDo> findUserWelfareByWelfareNumber(String welfareNumber, Integer limit) {
        Criteria criteria = Criteria.where("welfareNumber").is(welfareNumber);
        //根据助力值倒序
        Sort sort = Sort.by(Sort.Order.desc("helpCount"));
        Query query = new Query(criteria).with(sort);
        if (limit != null && limit != 0) {
            query.limit(limit);
        }
        return mongoDbService.findAll(query, UserWelfareMappingDo.class);
    }

    @Override
    public UserWelfareMappingDo queryHelpCountByUserId(String welfareNumber, Long userUniId) {
        Criteria criteria = new Criteria();
        criteria.and("welfareNumber").is(welfareNumber);
        criteria.and("userUniId").is(userUniId);
        return mongoDbService.findOne(new Query(criteria), UserWelfareMappingDo.class);
    }

    @Override
    public UserWelfareMappingDo queryUserWelfareById(String userWelfareId) {
        Criteria criteria = new Criteria();
        criteria.and("_id").is(userWelfareId);
        return mongoDbService.findOne(new Query(criteria), UserWelfareMappingDo.class);
    }

    @Override
    public List<UserWelfareMappingDo> findIsJoinUserInfo(String welfareNumber) {
        Criteria criteria = Criteria.where("welfareNumber").is(welfareNumber);
        criteria.and("helpCount").ne(0);
        //根据最后修改时间倒序
        Sort sort = Sort.by(Sort.Order.desc("lastModifyTime"));
        Query query = new Query(criteria).with(sort);
        query.limit(NumberEnums.TEN.getNumber());
        return mongoDbService.findAll(query, UserWelfareMappingDo.class);
    }

    @Override
    public Long countIsPartakePersonCount(String welfareNumber) {
        Criteria criteria = new Criteria().and("welfareNumber").is(welfareNumber);
        return mongoDbService.count(new Query(criteria), UserWelfareMappingDo.class);
    }

    @Override
    public List<UserWelfareMappingDo> findUserWelfare(String welfareNumber, List<Long> userUniIdList, Integer limit) {
        Criteria criteria = Criteria.where("welfareNumber").is(welfareNumber).and("helpCount").gt(0);
        //去除指定用户id的信息
         if (userUniIdList.size() != 0) {
             criteria.and("userUniId").nin(userUniIdList);
         }
        //根据助力值倒序
        Sort sort=Sort.by(Sort.Order.desc("helpCount"));
        Query query = new Query(criteria).with(sort);
        if (limit != null && limit != 0) {
            query.limit(limit);
        }
        return mongoDbService.findAll(query, UserWelfareMappingDo.class);
    }

    @Override
    public void updateUserImgByUserId(Long userUniId, String userImg) {
        Query query = new Query(Criteria.where("userUniId").is(userUniId));
        Update update = new Update();
        update.set("userImg",userImg);
        mongoDbService.update(query,update,UserWelfareMappingDo.class);
    }

    @Override
    public void updateUserNameByUserId(Long userUniId, String userNickName) {
        Query query = new Query(Criteria.where("userUniId").is(userUniId));
        Update update = new Update();
        update.set("userNickName",userNickName);
        mongoDbService.update(query,update,UserWelfareMappingDo.class);
    }
}
