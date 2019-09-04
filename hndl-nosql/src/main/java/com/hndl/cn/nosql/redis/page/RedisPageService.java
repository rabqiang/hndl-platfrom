package com.hndl.cn.nosql.redis.page;

import java.util.List;

/**
 * @author 赵俊凯
 * @Description 基于缓存分页
 * @Date 2019/4/28 11:58
 * @Created by 湖南达联
 */
public interface RedisPageService {

    /**
     * 基于缓存内存分页
     *
     * @Description
     * @author 赵俊凯
     * @param key
     * @param pageNo
     * @param pageSize
     * @return
     */
    <T> List<T> getKVList(String key, Integer pageNo, Integer pageSize);
}
