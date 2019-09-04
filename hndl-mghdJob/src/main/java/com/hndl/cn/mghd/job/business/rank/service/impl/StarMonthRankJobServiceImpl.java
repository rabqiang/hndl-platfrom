package com.hndl.cn.mghd.job.business.rank.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.redis.rank.RedisStarRankKey;
import com.hndl.cn.mghd.job.business.rank.job.StarInitRankJob;
import com.hndl.cn.mghd.job.business.rank.service.StarMonthRankJobService;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarMonthRankDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarMonthRankManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/26 14:12
 * @Created by 湖南达联
 */
@Service
public class StarMonthRankJobServiceImpl implements StarMonthRankJobService {

    private static final Logger log = LoggerFactory.getLogger(StarInitRankJob.class);

    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private StarMonthRankManager starMonthRankManager;

    @Resource
    private RedisService redisService;

    @Override
    public void initNextStarFansGroupDayRank() {
        List<StarFansGroupDo> all = starFansGroupManager.findAll();

        if(CollectionUtils.isEmpty(all)){
            return;
        }

        //获取明天的日期时间
        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth(LocalDateUtil.nextMonth()));

//        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth(LocalDate.now()));

        //获取当前的时间
        Long createTime = System.currentTimeMillis();

        List<StarMonthRankDo> collect = all.stream().filter(bean -> bean != null).map(bean -> {
            StarMonthRankDo starDayRankDo = SpringCglibBeanUtils.convert(bean, StarMonthRankDo.class);
            starDayRankDo.setId(null);
            starDayRankDo.setIntegralCount(0);
            starDayRankDo.setCreateTime(createTime);
            starDayRankDo.setRankTime(rankTime);
            starDayRankDo.setCoinCount(0);
            starDayRankDo.setGettingLoveCount(0);
            starDayRankDo.setVoteCount(0L);
            return starDayRankDo;
        }).collect(Collectors.toList());

        //入库
        starMonthRankManager.insertInBatch(collect);
    }

    @Override
    public void refreshStarRankMonthCache() {
        //获取这周的第一天
        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth());

        List<StarMonthRankDo> byRankDate = starMonthRankManager.findByRankDate(rankTime,BaseConstants.STAR_RANK_DEFAULT_LIMIT);

        //对应的key是这周的第一天
        String key = RedisStarRankKey.getStarMonthRankKey(LocalDateUtil.firstDayOfMonth());

        // 计算过期时间 单位秒
        Long cacheTimeOut =LocalDateUtil.localDateToSecond(LocalDateUtil.nextMonth().with(TemporalAdjusters.firstDayOfMonth())) -
                LocalDateTimeUtil.localDateToSecond(LocalDateTime.now());

        redisService.set(key,byRankDate,cacheTimeOut);

    }
}
