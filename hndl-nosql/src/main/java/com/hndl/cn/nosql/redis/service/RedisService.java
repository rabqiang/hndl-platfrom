package com.hndl.cn.nosql.redis.service;

import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.ZSetOperations;

import java.util.Set;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/13 16:54
 * @Created by 湖南达联
 */
public interface RedisService {
    

    /**
     * 获取key的类型
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @return
     */
    DataType getkeyType(String key);

    /**
     * 设置key的值成功则true，否则false
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @param value
     * @return
     */

    <T> Boolean setIfAbsent(String key, T value);

    /**
     * 设置key的值成功则true，否则false
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @param value
     * @param unixTime
     *            过期时间,单位毫秒
     * @return
     */
    <T> Boolean setIfAbsent(String key, T value, long unixTime);

    /**
     * 插入数据
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @param value
     */
    <T> void set(String key, T value);


    /**
     * 插入数据（指定过期时间，单位秒）
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @param value
     * @param timeout
     *            过期时间
     */
    <T> void set(String key, T value, Long timeout);

    /**
     * 获取指定 key值
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @return
     */
    <T> T get(String key);


    /**
     * 删除指定key
     *
     * @param key
     * @return
     */
    boolean del(String key);


    /**
     * 删除lock
     * @param key
     * @return
     */
    boolean delNX(String key);

    /**
     * 判断KEY是否存在
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @return
     */
    boolean exists(final String key);

    /**
     * 设置指定key的失效时间<br/>
     * 失效
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @param seconds
     *            单位秒
     * @return
     */
    boolean expireInSeconds(String key, int seconds);

    /**
     * 设置指定key的失效时间<br/>
     * 失效
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @param milliSeconds
     *            毫秒
     * @return
     */
    boolean expireInMilliSeconds(String key, long milliSeconds);

    /**
     * 设置指定key在某时间失效<br/>
     * 失效后K/v不消失
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @param 毫秒
     * @return
     */
    boolean expireAt(String key, long unixTime);

    /**
     * 获取指定key的存活时间
     *
     * @param key
     * @return
     */
    Long getExpire(String key);

    /**
     * 通过正则匹配keys
     *
     * @Description
     * @author 赵俊凯
     * @param pattern
     * @return
     */
    Set<String> keys(String pattern);




    /**
     * 对某个KEY的值进行加法运算<br>
     * 1:只作用于值为数值类型，否则会出现异常
     *
     * @param key
     * @return
     */
    Double opsForValueIncrement(String key, double value);

    /**
     * 进行自增操作
     * @param key
     * @param value
     * @return
     */
    Long opsForValueIncrement(String key,long value);

    /**
     * 进行原子递减[调用redis decr命令]
     * @param key
     * @param value
     * @return
     */
    Long opsForValueDecremennt(String key,long value);



    /**
     * 如果key不存在，则将key的值设为value; 否则不做操作
     * @param key
     * @param value
     * @param timeOutSeconds
     * @return
     */
    boolean setNX(final String key, final String value,long timeOutSeconds);

    /**
     * set成功后将值返回
     * @param key
     * @param value
     * @param timeOutSeconds
     * @return
     */
    String getSet(final String key, final String value,long timeOutSeconds);


    /**
     * 获取zset的操作类
     * @return
     */
    ZSetOperations opsForZSet();


    /**
     * 获取ZSetScore
     * @param index
     * @return
     */
    Double getZSetScore(Integer index);



}
