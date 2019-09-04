package com.hndl.cn.nosql.mongodb.service.impl;

import com.hndl.cn.nosql.mongodb.service.MongoDbService;

import com.hndl.cn.utils.collection.MapUtils;
import com.mongodb.client.result.UpdateResult;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @Classname 赵俊凯
 * @Description mongoDB的实现类
 * @Date 2019/3/20 9:49
 * @Created by 湖南达联
 */
@Service
public class MongoDbServiceImpl implements MongoDbService {
    @Resource
    private MongoTemplate mongoTemplate;

    @Override
    public <T> void insert(T object) {
        mongoTemplate.insert(object);
    }

    @Override
    public <T> T insertReturn(T object) {
        return mongoTemplate.insert(object);
    }

    @Override
    public <T> T findOne(Query querWhere, Class<T> entityClass) {
        return mongoTemplate.findOne(querWhere, entityClass);
    }

    @Override
    public <T> List<T> findAll(Query querWhere, Class<T> entityClass) {
        return mongoTemplate.find(querWhere, entityClass);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> void update(Query querWhere, Object data, Class<T> entityClass) {
        // 1：变量定义
        Map<String, Object> dataMap = null;
        // 2:将对象数据转成map
        if (data instanceof Map) {
            dataMap = (Map<String, Object>) data;
        } else {
            dataMap = (Map<String, Object>) MapUtils.objectToMap(data);
        }

        // 3:遍历map,设置更新数据
        if (MapUtils.isNotEmpty(dataMap)) {
            Update update =   this.builderUpdate(dataMap,null);
            // 4： 执行更新操作
            mongoTemplate.updateMulti(querWhere, update, entityClass);
        }
    }

    @Override
    public <T> boolean updateOne(Query querWhere, Object data, Class<T> entityClass) {
        boolean flag = false;
        // 1：变量定义
        Map<String, Object> dataMap = null;
        // 2:将对象数据转成map
        if (data instanceof Map) {
            dataMap = (Map<String, Object>) data;
        } else {
            dataMap = (Map<String, Object>) MapUtils.objectToMap(data);
        }

        // 3:遍历map,设置更新数据
        if (MapUtils.isNotEmpty(dataMap)) {
            Update update =   this.builderUpdate(dataMap,null);
            // 4： 执行更新操作
            flag = mongoTemplate.updateFirst(querWhere, update, entityClass).getModifiedCount() > 0;
        }
        return flag;
    }

    @Override
    public <T> void upsert(Query queryWhere, T data, Class<T> entityClass) {
        // 1：变量定义
        Map<String, Object> dataMap = null;
        // 2:将对象数据转成map
        if (data instanceof Map) {
            dataMap = (Map<String, Object>) data;
        } else {
            dataMap = (Map<String, Object>) MapUtils.objectToMap(data);
        }

        // 3:遍历map,设置更新数据
        if (MapUtils.isNotEmpty(dataMap)) {
            Update update =  this.builderUpdate(dataMap,null);
            mongoTemplate.upsert(queryWhere,update,entityClass);
        }

    }

    @Override
    public <T> void delete(Query deleteWhere, Class<T> entityClass) {
        mongoTemplate.remove(deleteWhere, entityClass);
    }

//    @Override
//    public <T> DBCollection getMongoDBCollection(Class<T> entityClass) {
//        return mongoTemplate.getCollection(mongoTemplate.getCollectionName(entityClass));
//    }

    @Override
    public <T> long count(Query query, Class<T> entityClass) {
        return mongoTemplate.count(query, entityClass);
    }

    @Override
    public <T> void insertInBatch(List<T> list, Class<T> entityClass) {
        mongoTemplate.insert(list,entityClass);
    }

    @Override
    public <T> void insertAll(List<T> list) {
        mongoTemplate.insertAll(list);
    }

    @Override
    public <T> void inc(Query query, Update update, Class<T> entityClass) {
        mongoTemplate.updateMulti(query,update,entityClass);
    }

    @Override
    public <T> boolean upsertInc(Query query, T data, Update update, Class<T> entityClass) {

        // 1：变量定义
        Map<String, Object> dataMap = null;
        // 2:将对象数据转成map
        if (data instanceof Map) {
            dataMap = (Map<String, Object>) data;
        } else {
            dataMap = (Map<String, Object>) MapUtils.objectToMap(data);
        }
        // 3:遍历map,设置更新数据
        if (MapUtils.isNotEmpty(dataMap)) {
            update = this.builderUpdate(dataMap,update);
            UpdateResult upsert = mongoTemplate.upsert(query, update, entityClass);
            return upsert.getUpsertedId() != null ? true: upsert.getModifiedCount() > 0;
        }
        return false;
    }


    @Override
    public <T> boolean incByResult(Query query, Update update, Class<T> entityClass) {
        try {
            return mongoTemplate.updateMulti(query,update,entityClass).getModifiedCount() > 0;
        }catch (Exception e){
            return false;
        }

    }

    @Override
    public <T> T findAndModify(Query query, Update update, Class<T> entityClass) {
        return mongoTemplate.findAndModify(query, update, entityClass);
    }

    @Override
    public <T> AggregationResults<T> aggregate(Aggregation agg, String name, Class<T> classType) {
        return mongoTemplate.aggregate(agg,name,classType);
    }


    private Update builderUpdate(Map<String, Object> dataMap,Update update){
        if(update == null){
            update = new Update();
        }
        Iterator<Map.Entry<String, Object>> entries = dataMap.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, Object> entry = entries.next();
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value == null) {// 注意，此方法并不会把为null的值写入数据库，更新字符串时请用""。
                continue;
            }
            update.set(key, value);
        }
        return update;
    }
}
