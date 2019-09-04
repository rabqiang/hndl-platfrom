package com.hndl.cn.mghd.job.business.rank.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.redis.rank.RedisStarRankKey;
import com.hndl.cn.mghd.job.business.rank.job.StarInitRankJob;
import com.hndl.cn.mghd.job.business.rank.service.StarWeekRankJobService;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarWeekRankDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.mongodb.manager.star.manager.StarWeekRankManager;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/26 14:12
 * @Created by 湖南达联
 */
@Service
public class StarWeekRankJobServiceImpl implements StarWeekRankJobService {

    private static final Logger log = LoggerFactory.getLogger(StarInitRankJob.class);

    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private StarWeekRankManager starWeekRankManager;

    @Resource
    private RedisService redisService;

    @Override
    public void initNextStarFansGroupWeekRank() {
        List<StarFansGroupDo> all = starFansGroupManager.findAll();

        if(CollectionUtils.isEmpty(all)){
            return;
        }

        //获取下周的星期一
        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.nextWeek().with(DayOfWeek.MONDAY));
//        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfWeek(LocalDate.now()));
        //获取当前的时间
        Long createTime = System.currentTimeMillis();

        List<StarWeekRankDo> collect = all.stream().filter(bean -> bean != null).map(bean -> {
            StarWeekRankDo starWeekRankDo = SpringCglibBeanUtils.convert(bean, StarWeekRankDo.class);
            starWeekRankDo.setId(null);
            starWeekRankDo.setIntegralCount(0);
            starWeekRankDo.setCreateTime(createTime);
            starWeekRankDo.setRankTime(rankTime);
            starWeekRankDo.setCoinCount(0);
            starWeekRankDo.setGettingLoveCount(0);
            starWeekRankDo.setVoteCount(0L);
            return starWeekRankDo;
        }).collect(Collectors.toList());

        //入库
        starWeekRankManager.insertInBatch(collect);

    }

    @Override
    public void refreshStarRankWeekCache() {
        //获取这周的第一天
        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfWeek());
        //查询当前周的数据
        List<StarWeekRankDo> byDate = starWeekRankManager.findByRankDate(rankTime,BaseConstants.STAR_RANK_DEFAULT_LIMIT);

        //对应的key是这周的第一天
        String key = RedisStarRankKey.getStarWeekRankKey(LocalDateUtil.firstDayOfWeek());

        // 计算过期时间 单位秒
        Long cacheTimeOut =LocalDateUtil.localDateToSecond(LocalDateUtil.nextWeek().with(DayOfWeek.MONDAY)) -
                LocalDateTimeUtil.localDateToSecond(LocalDateTime.now());

        redisService.set(key,byDate,cacheTimeOut);

    }
}
