package com.hndl.cn.mghd.job.business.rank.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.redis.rank.RedisStarRankKey;
import com.hndl.cn.base.vo.StarDayRankVo;
import com.hndl.cn.mghd.job.business.rank.job.StarInitRankJob;
import com.hndl.cn.mghd.job.business.rank.service.StarDayRankJobService;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansGroupManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/26 14:09
 * @Created by 湖南达联
 */
@Service
public class StarDayRankJobServiceImpl implements StarDayRankJobService {

    private static final Logger log = LoggerFactory.getLogger(StarInitRankJob.class);

    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private StarDayRankManager starDayRankManager;

    @Resource
    private RedisService redisService;


    @Override
    public void initNextStarFansGroupDayRank() {
        List<StarFansGroupDo> all = starFansGroupManager.findAll();

        if(CollectionUtils.isEmpty(all)){
              return;
        }

        //获取明天的日期时间
        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.nextDay());

//        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDate.now());

        //获取惊天的时间
        Long createTime = System.currentTimeMillis();

        List<StarDayRankDo> collect = all.stream().filter(bean -> bean != null).map(bean -> {
            StarDayRankDo starDayRankDo = SpringCglibBeanUtils.convert(bean, StarDayRankDo.class);
            starDayRankDo.setId(null);
            starDayRankDo.setIntegralCount(0);
            starDayRankDo.setCreateTime(createTime);
            starDayRankDo.setRankTime(rankTime);
            starDayRankDo.setCoinCount(0);
            starDayRankDo.setGettingLoveCount(0);
            starDayRankDo.setVoteCount(0L);
            starDayRankDo.setCurrentRank(0);
            return starDayRankDo;
        }).collect(Collectors.toList());

        //入库
        starDayRankManager.insertInBatch(collect);
    }

    @Override
    public void refreshStarRankDayCache() {
        //获取现在的日期
        Long rankTime = LocalDateUtil.localDateToMilliSecond(LocalDate.now());

        //获取昨天的时间
        Long yesterdayTime = LocalDateUtil.localDateToMilliSecond(LocalDateUtil.addDay(-1L));

        //查询今天的的数据
        List<StarDayRankDo> starDayRankByRankDate = starDayRankManager.findStarDayRankByRankDate(rankTime,null);

        List<StarDayRankDo> yesterdayData = starDayRankManager.findStarDayRankByRankDate(yesterdayTime, null);

        if(CollectionUtils.isEmpty(starDayRankByRankDate)){
            return;
        }

        Map<Long,Integer> yesterdayRankMap = null;

        if(CollectionUtils.isNotEmpty(yesterdayData)){
            yesterdayRankMap = yesterdayData.stream().filter(bean -> bean != null)
                    .collect(Collectors.toMap(bean -> bean.getStarId(),bean -> bean.getCurrentRank()));
        }

        //获取到当前时间的key
        String key = RedisStarRankKey.getStarDayRankKey(LocalDate.now());

        List<StarDayRankVo> voList = new ArrayList<>(starDayRankByRankDate.size());

        int currentRank = 1;//初始化当前排名

        //计算到当前排名
        for(StarDayRankDo rankDo : starDayRankByRankDate){
            if(rankDo == null){
                continue;
            }
            //添加当前排名
            StarDayRankVo starDayRankVo = SpringCglibBeanUtils.convert(rankDo,StarDayRankVo.class);
            starDayRankVo.setCurrentRank(currentRank);
            starDayRankVo.setLastRank(starDayRankVo.getCurrentRank());
            //这里是需要判断是否是前一天的数据，如果没有则是0，有的话是上一次的排名

            if(yesterdayRankMap != null){
                //拿出昨天的排名
               Integer yesterdayRank =  yesterdayRankMap.get(rankDo.getStarId());
               if(yesterdayRank == null){
                   //如果为空 就是新的数据 应该是最后一名
                   starDayRankVo.setLastRank(yesterdayData.size());
               }else {
                   //如果不为空,则是昨天的排名
                   starDayRankVo.setLastRank(yesterdayRank);
               }
            }

            voList.add(starDayRankVo);
            //跟新最新的排名
            starDayRankManager.updateCurrentRank(rankDo.getId(),currentRank);
            currentRank ++;
        }


         //计算过期时间
         Long cacheTimeOut = LocalDateUtil.localDateToSecond(LocalDateUtil.nextDay())
                 - LocalDateTimeUtil.localDateToSecond(LocalDateTime.now())
                  + RedisStarRankKey.HISTORY_TIME_OUT;

         //刷入缓存,过期时间为第二天的秒数,只取100条
         Integer subSize = voList.size();
         if(subSize > BaseConstants.STAR_RANK_DEFAULT_LIMIT){
             voList = new ArrayList( voList.subList(0, BaseConstants.STAR_RANK_DEFAULT_LIMIT));
         }

         redisService.set(key,voList,cacheTimeOut);

    }

    public static void main(String[] args) {
        Integer i = 1;
        System.out.println(i.doubleValue()/100);
    }
}
