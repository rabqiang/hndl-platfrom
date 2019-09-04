package com.hndl.cn.mongodb.manager.user.manager.impl;

import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.mongodb.manager.user.bean.UserReceivingAddressDo;
import com.hndl.cn.mongodb.manager.user.manager.UserReceivingAddressManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/24 16:09
 * @Created by 湖南达联
 */
@Service
public class UserReceivingAddressManagerImpl implements UserReceivingAddressManager {
    @Resource
    private MongoDbService mongoDbService;

    /**
     * 增加和修改用户福利收货地址
     * 条件: 用户id和收获名称
     *
     * @param userReceiving 用户收货信息
     */
    @Override
    public void setUserReceiving(UserReceivingAddressDo userReceiving) {
        Criteria criteria = Criteria.where("userUniId").is(userReceiving.getUserUniId())
                .and("welfareNumber").is(userReceiving.getWelfareNumber());
        mongoDbService.upsert(new Query(criteria), userReceiving, UserReceivingAddressDo.class);
    }

    @Override
    public UserReceivingAddressDo findAddressByWelfareNumber(Long userUniId, String welfareNumber) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId)
                .and("welfareNumber").is(welfareNumber);
        return mongoDbService.findOne(new Query(criteria), UserReceivingAddressDo.class);
    }

    @Override
    public List<UserReceivingAddressDo> findPrizeInfoByUserId(Long userUniId, String id) {
        Criteria criteria = new Criteria();
        criteria.and("userUniId").is(userUniId);
        if (id != null) {
            criteria.and("_id").gt(new ObjectId(id));
        }
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "createTime");
        Sort sort = new Sort(order);
        // 分页二十条
        Query query = new Query(criteria).with(sort).limit(NumberEnums.TWENTY.getNumber());
        return mongoDbService.findAll(query, UserReceivingAddressDo.class);
    }

    @Override
    public List<UserReceivingAddressDo> findUserAddress(String id, String welfareNumber, Integer isDelivery, Integer limit) {
        Criteria criteria = new Criteria();
        if (id != null) {
            criteria.and("_id").lt(new ObjectId(id));
        }
        if (welfareNumber != null) {
            criteria.and("welfareNumber").is(welfareNumber);
        }
        if (isDelivery != null) {
            criteria.and("isDelivery").is(isDelivery);
        }
        //根据_id倒序
        Sort.Order order = new Sort.Order(Sort.Direction.DESC, "_id");
        Sort sort = new Sort(order);
        //加分页的页数
        Query query = new Query(criteria).with(sort);
        if (limit != null) {
            query.limit(limit);
        }
        return mongoDbService.findAll(query, UserReceivingAddressDo.class);
    }

    @Override
    public void submitAddress(UserReceivingAddressDo userReceivingAddressDo) {
        Criteria criteria = Criteria.where("userUniId").is(userReceivingAddressDo.getUserUniId())
                .and("welfareNumber").is(userReceivingAddressDo.getWelfareNumber());
        mongoDbService.upsert(new Query(criteria), userReceivingAddressDo, UserReceivingAddressDo.class);
    }

    @Override
    public Long countLuckyUser() {
        Criteria criteria = new Criteria();
        return mongoDbService.count(new Query(criteria), UserReceivingAddressDo.class);
    }
}
