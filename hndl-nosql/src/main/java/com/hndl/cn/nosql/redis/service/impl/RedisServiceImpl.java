package com.hndl.cn.nosql.redis.service.impl;

import com.hndl.cn.nosql.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/13 16:59
 * @Created by 湖南达联
 */
@Service
public class RedisServiceImpl implements RedisService {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisServiceImpl.class);

    @Resource(name = "redisTemplate")
    private RedisTemplate redisTemplate;




    @Override
    public DataType getkeyType(String key) {
        return redisTemplate.type(key);
    }

    @Override
    public <T> Boolean setIfAbsent(String key, T value) {
        boolean isSucc = false;
        try {
            BoundValueOperations<?, T> boundValueOperations = redisTemplate.boundValueOps(key);
            isSucc = boundValueOperations.setIfAbsent(value);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSucc;
    }

    @Override
    public <T> Boolean setIfAbsent(String key, T value, long unixTime) {
        boolean isSucc = false;
        try {
            BoundValueOperations<?, T> boundValueOperations = redisTemplate.boundValueOps(key);
            isSucc = boundValueOperations.setIfAbsent(value);
            if (isSucc) {
                boundValueOperations.expire(unixTime, TimeUnit.MILLISECONDS);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSucc;
    }

    @Override
    public <T> void set(String key, T value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public <T> void set(String key, T value, Long timeout) {
        redisTemplate.opsForValue().set(key, value, timeout, TimeUnit.SECONDS);
    }

    @Override
    public <T> T get(String key) {
       return  (T)redisTemplate.opsForValue().get(key);
    }

    @Override
    public boolean del(String key) {
        return redisTemplate.delete(key);
    }

    @Override
    public boolean delNX(String key) {
        return (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.del(key.getBytes()) > 0 ? true:false;
            }
        });
    }

    @Override
    public boolean exists(String key) {
        return (Boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    @Override
    public boolean expireInSeconds(String key, int seconds) {
        return redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    @Override
    public boolean expireInMilliSeconds(String key, long milliSeconds) {
        return redisTemplate.expire(key, milliSeconds, TimeUnit.MILLISECONDS);
    }

    @Override
    public boolean expireAt(String key, long unixTime) {
        return redisTemplate.expireAt(key, new Date(unixTime * 1000));
    }

    @Override
    public Long getExpire(String key) {
        return redisTemplate.getExpire(key);
    }

    @Override
    public Set<String> keys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    @Override
    public Double opsForValueIncrement(String key, double value) {
        return redisTemplate.opsForValue().increment(key, value);
    }

    @Override
    public Long opsForValueIncrement(String key, long value) {
        return redisTemplate.opsForValue().increment(key, value);
    }

    @Override
    public Long opsForValueDecremennt(String key, long value) {
        return redisTemplate.opsForValue().decrement(key,value);
    }


    @Override
    public boolean setNX(String key, String value, long timeOutSeconds) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    Boolean success = connection.setNX(key.getBytes(), serializer.serialize(value));
                    connection.close();
                    if (success) {
                        connection.expire(serializer.serialize(key), timeOutSeconds);
                    }
                    return success;
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("setNX redis error, key : {}", key);
        }
        return obj != null ? (Boolean) obj : false;
    }

    @Override
    public String getSet(String key, String value, long timeOutSeconds) {
        Object obj = null;
        try {
            obj = redisTemplate.execute(new RedisCallback<Object>() {
                @Override
                public Object doInRedis(RedisConnection connection) throws DataAccessException {
                    StringRedisSerializer serializer = new StringRedisSerializer();
                    byte[] ret = connection.getSet(serializer.serialize(key), serializer.serialize(value));
                    if (ret != null) {
                        connection.expire(serializer.serialize(key), timeOutSeconds);
                    }
                    connection.close();
                    return serializer.deserialize(ret);
                }
            });
        } catch (Exception e) {
            LOGGER.error("setNX redis error, key : {}", key);
        }
        return obj != null ? (String) obj : null;
    }

    @Override
    public ZSetOperations opsForZSet() {
        return redisTemplate.opsForZSet();
    }

    @Override
    public Double getZSetScore(Integer index) {
        index = index + 1;
        return index.doubleValue() / 100;
    }
}
