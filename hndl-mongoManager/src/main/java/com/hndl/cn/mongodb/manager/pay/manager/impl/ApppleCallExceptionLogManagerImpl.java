package com.hndl.cn.mongodb.manager.pay.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.mongodb.manager.pay.bean.AppleCallLogDo;
import com.hndl.cn.mongodb.manager.pay.manager.ApppleCallExceptionLogManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program:hndl-platform
 * @description:TODO 苹果异常回调
 * @author: 易成贤
 * @create: 2019/8/5 21:15
 * @Created by湖南达联
 **/
@Service
public class ApppleCallExceptionLogManagerImpl implements ApppleCallExceptionLogManager {

    @Resource
    MongoDbService mongoDbService;
    /**
     * 插入苹果回调日志
     * @param userUniId
     * @param orderId
     * @param data
     */
    @Override
    public void insertApppleCallLog(Long userUniId, Long orderId, String data) {
        mongoDbService.insert(AppleCallLogDo.builder().createTime(System.currentTimeMillis()).userUniId(userUniId).orderId(orderId).receiptData(data).isDelete(IsValidEnums.NO.getValue()).build());
    }

    /**
     * 根据用户和本地订单号查询补单日志
     *
     * @param userUniId
     * @param localOrder
     * @return
     */
    @Override
    public AppleCallLogDo findApppleCallExceptionLog(Long userUniId, Long localOrder) {
        Criteria criteria = Criteria.where("userUniId").is(userUniId).and("orderId").is(localOrder).and("isDelete").is(IsValidEnums.NO.getValue());
        return mongoDbService.findOne(new Query(criteria),AppleCallLogDo.class);
    }
}
