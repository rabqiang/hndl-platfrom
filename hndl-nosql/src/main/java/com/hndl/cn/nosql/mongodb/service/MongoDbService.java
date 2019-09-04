package com.hndl.cn.nosql.mongodb.service;

import com.mongodb.DBCollection;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description 操作MongoDB的服务接口
 * @Date 2019/3/20 9:48
 * @Created by 湖南达联
 */
public interface MongoDbService {

    /**
     * 插入一个对象到mongodb<br>
     * 1:如果有一个相同的_ID时，就会新增失败。
     *
     * @Description
     * @author 唐宋
     * @param <T>
     * @param object
     *            插入对象
     */
    <T> void insert(T object);


    /**
     * 插入一个对象到mongodb<br>
     * 1:如果有一个相同的_ID时，就会新增失败。
     * @param object
     * @param <T> 带返回值
     * @return
     */
    <T>  T  insertReturn(T object);

    /**
     * 通过一定的条件查询一个实体
     *
     * @Description
     * @author 唐宋
     * @param <T>
     * @param querWhere
     *            查询条件
     * @param entityClass
     *            实体类class
     * @return
     */
    <T> T findOne(Query querWhere, Class<T> entityClass);

    /**
     * 通过条件查询实体(集合)
     *
     * @Description
     * @author 唐宋
     * @param <T>
     * @param querWhere
     *            查询条件
     * @param entityClass
     *            实体类class
     * @return
     */
    <T> List<T> findAll(Query querWhere, Class<T> entityClass);

    /**
     * 通过条件查询更新数据
     *
     * @Description
     * @author 唐宋
     * @param <T>
     * @param queryWhere
     *            查询条件
     * @param data
     *            更新数据
     * @param entityClass
     *            实体类class
     */
    <T> void update(Query queryWhere, Object data, Class<T> entityClass);


    /**
     * by one
     * @param querWhere
     * @param data
     * @param entityClass
     * @param <T>
     */
    <T> boolean updateOne(Query querWhere, Object data, Class<T> entityClass);



    /**
     * 如果有就更新没有就插入
     *
     * @Description
     * @author 唐宋
     * @param <T>
     * @param queryWhere
     *            查询条件
     * @param data
     *            更新数据
     * @param entityClass
     *            实体类class
     */
    <T> void upsert(Query queryWhere, T data, Class<T> entityClass);

    /**
     * 根据ID删除一个实体
     *
     * @Description
     * @author 唐宋
     * @param <T>
     * @param deleteWhere
     *            删除条件
     * @param entityClass
     *            实体类class
     */
    <T> void delete(Query deleteWhere, Class<T> entityClass);

//    /**
//     * 获取mongo连接
//     *
//     * @Description
//     * @author 唐宋
//     * @param <T>
//     * @param entityClass
//     * @return
//     */
//    <T> DBCollection getMongoDBCollection(Class<T> entityClass);

    /**
     * 获取总数
     *
     * @param query
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> long count(Query query, Class<T> entityClass);

    /**
     * 批量插入
     * @param list
     * @param entityClass
     * @param <T>
     */
    <T> void insertInBatch(List<T> list,Class<T> entityClass);

    /**
     * 批量添加数据
     * 不是批量写入!!!!!!!!!!
     * @Description
     * @author 赵俊凯
     * @modified wuys
     * @param list
     */
    <T> void insertAll(List<T> list);


    /**
     *
     * @param query
     * @param update
     * @param entityClass
     * @param <T>
     */
    <T> void inc(Query query, Update update, Class<T> entityClass);


    <T> boolean upsertInc(Query query,T data, Update update, Class<T> entityClass);


    /**
     *
     * @param query
     * @param update
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> boolean incByResult(Query query, Update update, Class<T> entityClass);


    /**
     *
     * @param query
     * @param update
     * @param entityClass
     * @param <T>
     * @return
     */
    <T> T findAndModify(Query query, Update update, Class<T> entityClass);

    /**
     * 批量count
     * @param agg
     * @param name
     * @param classType
     * @param <T>
     * @return
     */
    <T> AggregationResults<T> aggregate(Aggregation agg, String name, Class<T> classType);


//
//    /**
//     * 普通的分页：这里注意如果向上翻，排序方式需要反转，拿到的数据也需要自己实现排序
//     *
//     * @Description
//     * @author 赵俊凯
//     * @param criteria
//     * @param pageScrollTypeEnums
//     * @param seqIdentifier
//     * @param curPage
//     * @param pageSize
//     * @param entityClass
//     * @param sort
//     * @return
//     * @throws Exception
//     */
//    <T> ResultVo<List<T>> getCommonPageList(Criteria criteria, PageScrollTypeEnums pageScrollTypeEnums,
//                                            RtKeyValuePair seqIdentifier, int curPage, int pageSize, Class<T> entityClass, Sort sort) throws Exception;
//
//    /**
//     * 获取下一页
//     *
//     * @param criteria
//     * @param pageScrollTypeEnums
//     * @param seqIdentifier
//     * @param curPage
//     * @param pageSize
//     * @param entityClass
//     * @param sort
//     * @param <T>
//     * @return
//     * @throws Exception
//     */
//    <T> ResultVo<List<T>> getNextPageList(Criteria criteria, PageScrollTypeEnums pageScrollTypeEnums,
//                                          RtKeyValuePair seqIdentifier, int curPage, int pageSize, Class<T> entityClass, Sort sort) throws Exception;
//
//    /**
//     * 普通的分页
//     *
//     * @param queryBuilder
//     * @param fieldsObject
//     * @param pageScrollTypeEnums
//     * @param seqIdentifier
//     * @param curPage
//     * @param pageSize
//     * @param entityClass
//     * @param sort
//     * @param <T>
//     * @return
//     * @throws Exception
//     */
//    <T> ResultVo<List<T>> getCommonPageList(QueryBuilder queryBuilder, BasicDBObject fieldsObject,
//                                            PageScrollTypeEnums pageScrollTypeEnums, RtKeyValuePair seqIdentifier, int curPage, int pageSize,
//                                            Class<T> entityClass, Sort sort) throws Exception;
//
//    /**
//     * 爆布流的分页
//     *
//     * @param queryBuilder
//     * @param fieldsObject
//     * @param pageScrollTypeEnums
//     * @param seqIdentifier
//     * @param curPage
//     * @param pageSize
//     * @param entityClass
//     * @param sort
//     * @param <T>
//     * @return
//     * @throws Exception
//     */
//    <T> ResultVo<List<T>> getNextPageList(QueryBuilder queryBuilder, BasicDBObject fieldsObject,
//                                          PageScrollTypeEnums pageScrollTypeEnums, RtKeyValuePair seqIdentifier, int curPage, int pageSize,
//                                          Class<T> entityClass, Sort sort) throws Exception;

}
