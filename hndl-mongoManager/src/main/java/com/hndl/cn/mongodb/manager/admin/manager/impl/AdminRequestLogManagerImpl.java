package com.hndl.cn.mongodb.manager.admin.manager.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.mongodb.manager.admin.bean.AdminRequestLog;
import com.hndl.cn.mongodb.manager.admin.manager.AdminRequestLogManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/24 20:54
 * @Created by 湖南达联
 */
@Service
public class AdminRequestLogManagerImpl implements AdminRequestLogManager {

    @Resource
    private MongoDbService mongoDbService;


    @Override
    public void addLog(AdminRequestLog log) {
        log.setCreateTime(new Date().getTime());
        mongoDbService.insert(log);
    }

    @Override
    public List<AdminRequestLog> findAdminLogByPage(Long startTime, Long endTime, Long adminUserId,String id) {
        Criteria criteria = new Criteria();
        if(startTime != null && endTime != null){
            criteria.and("createTime").gt(startTime).lt(endTime);
        }
        if(adminUserId != null){
            criteria.and("adminUserId").is(adminUserId);
        }
        if(id != null){
            criteria.and("_id").lt(new ObjectId(id));
        }
        Query query = new Query(criteria);
        query.with(Sort.by(Sort.Order.desc("_id")));
        query.limit(BaseConstants.DEFAULT_LIMIT);
        return mongoDbService.findAll(query,AdminRequestLog.class);
    }
}
