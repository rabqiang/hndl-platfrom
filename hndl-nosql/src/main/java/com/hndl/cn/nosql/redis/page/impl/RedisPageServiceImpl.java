package com.hndl.cn.nosql.redis.page.impl;

import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import org.assertj.core.util.Lists;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/28 11:59
 * @Created by 湖南达联
 */
@Service
public class RedisPageServiceImpl implements RedisPageService {


    @Resource
    private RedisService redisService;

    @Override
    public <T> List<T> getKVList(String key, Integer pageNo, Integer pageSize) {

        if (pageNo < 1){
            return new ArrayList<>(1);
        }

        List<T> list = redisService.get(key);

        // 如果不存在
        if (null == list) {
            return new ArrayList<>(1);
        }

        int listSize = list.size();

        int start = pageNo * pageSize - pageSize;// 获取起始位置

        int end = pageNo * pageSize; // 获取结束位置

        if (start >= listSize) {
            return new ArrayList<>(1);
        }

        if (end > listSize) {
            end = listSize;
        }

        if(start > listSize){
            return new ArrayList<>();
        }

        return new ArrayList<>(list.subList(start, end));
    }


    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5);
        System.out.println(list.subList(0,6));
    }
}
