package com.hndl.cn.mongodb.manager.message.manager.impl;

import com.hndl.cn.mongodb.manager.message.bean.TurntableMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.TurntableMessageManager;
import com.hndl.cn.nosql.mongodb.service.MongoDbService;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description  转盘消息表 DAO
 * @Date  2019年7月5日17:41:20
 * @Created by 湖南达联
 */
@Service
public class TurntableMessageManagerImpl implements TurntableMessageManager {

    @Resource
    private MongoDbService mongoDbService;

    @Override
    public void insertTurnTable(TurntableMessageDo TurntableMessageDo) {
        TurntableMessageDo.setCreateTime(System.currentTimeMillis());
        mongoDbService.insert(TurntableMessageDo);

    }

    @Override
    public List<TurntableMessageDo> findByEntityType(Integer isEntity,Integer limit) {
        Query query = new Query(Criteria.where("isEntity").is(isEntity));
        if (null!=limit&&!limit.equals(0)) {
            query.limit(limit);
        }
        query.with(new Sort(Sort.Direction.DESC, "createTime"));
        return  mongoDbService.findAll(query,TurntableMessageDo.class);
    }
}
