package com.hndl.cn.mghd.job.business.rank.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.redis.rank.RedisFansRankKey;
import com.hndl.cn.mghd.job.business.rank.service.FansDayRankJobService;
import com.hndl.cn.mongodb.manager.star.bean.StarFansDayStatisticsDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mysql.manager.system.manager.SystemJobInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 18:10
 * @Created by 湖南达联
 */
@Service
public class FansDayRankJobServiceImpl implements FansDayRankJobService {


    @Resource
    private StarFansDayStatisticsManager starFansDayStatisticsManager;


    @Resource
    private RedisService redisService;

    @Resource
    private SystemJobInfoManager systemJobInfoManager;



    @Override
    public void refreshFansRankDayCache() {

        LocalDate now = LocalDate.now();

        //获取到key
        String key = RedisFansRankKey.getFansDayRankKey(now);

        //查询当天的星粉版数据
        List<StarFansDayStatisticsDo> byDate =
                starFansDayStatisticsManager.findByDate(LocalDate.now(), BaseConstants.STAR_RANK_DEFAULT_LIMIT);

        LocalDate localDate = LocalDateUtil.nextDay();

        //计算到过期的时间
        Long timeOut =  LocalDateUtil.localDateToSecond(localDate) - LocalDateUtil.localDateToSecond(now) +
                RedisFansRankKey.HISTORY_TIME_OUT;

        redisService.set(key,byDate,timeOut);

    }




}
