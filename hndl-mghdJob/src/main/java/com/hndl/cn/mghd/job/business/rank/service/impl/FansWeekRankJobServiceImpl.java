package com.hndl.cn.mghd.job.business.rank.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.redis.rank.RedisFansRankKey;
import com.hndl.cn.mghd.job.business.rank.service.FansWeekRankJobService;
import com.hndl.cn.mongodb.manager.star.bean.StarFansWeekStatisticsDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansWeekStatisticsManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/30 14:44
 * @Created by 湖南达联
 */
@Service
public class FansWeekRankJobServiceImpl implements FansWeekRankJobService {

    @Resource
    private StarFansWeekStatisticsManager starFansWeekStatisticsManager;

    @Resource
    private RedisService redisService;


    @Override
    public void refreshFansRankWeekCache() {

        LocalDate now = LocalDateUtil.firstDayOfWeek();

        //获取到key
        String key = RedisFansRankKey.getFansWeekRankKey(now);

        //查询当天的星粉版数据
        List<StarFansWeekStatisticsDo> byDate =
                starFansWeekStatisticsManager.findByDate(now, BaseConstants.STAR_RANK_DEFAULT_LIMIT);

        LocalDate localDate = LocalDateUtil.nextDay();

        //计算到过期的时间
        Long timeOut =  LocalDateUtil.localDateToSecond(localDate) - LocalDateUtil.localDateToSecond(now) +
                RedisFansRankKey.HISTORY_TIME_OUT;

        redisService.set(key,byDate,timeOut);

    }

    @Override
    public void sendFansRankWeekReward() {

    }
}
