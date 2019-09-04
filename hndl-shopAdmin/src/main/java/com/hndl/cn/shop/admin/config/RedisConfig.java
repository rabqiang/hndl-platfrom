package com.hndl.cn.shop.admin.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/13 16:45
 * @Created by 湖南达联
 */
@Configuration
@Slf4j
public class RedisConfig {




    /**
     * 自定义redis序列化器
     * @param redisConnectionFactory
     * @return
     */
    @Bean(name = "redisTemplate")
    @ConditionalOnMissingBean(name = "redisTemplate")
    public RedisTemplate<Object,Object> billredisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        GenericJackson2JsonRedisSerializer genericJackson2JsonRedisSerializer = new GenericJackson2JsonRedisSerializer();
        // GenericJackson2JsonRedisSerializer
        template.setValueSerializer(genericJackson2JsonRedisSerializer);
        template.setHashValueSerializer(genericJackson2JsonRedisSerializer);
        // key的序列化采用StringRedisSerializer
        template.setKeySerializer(stringRedisTemplate.getKeySerializer());
        template.setHashKeySerializer(stringRedisTemplate.getHashKeySerializer());

        log.info("===============redis序列器初始化成功===================");
        return template;
    }


}
