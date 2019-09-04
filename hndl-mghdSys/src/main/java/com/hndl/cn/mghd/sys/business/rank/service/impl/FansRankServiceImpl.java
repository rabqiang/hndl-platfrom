package com.hndl.cn.mghd.sys.business.rank.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.redis.rank.RedisFansRankKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.sys.business.rank.service.FansRankService;
import com.hndl.cn.mghd.sys.business.rank.vo.StarFansDayVo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansDayStatisticsDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansMonthStatisticsDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansWeekStatisticsDo;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansMonthStatisticsManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansWeekStatisticsManager;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description
 * @Date 2019/5/6 10:34
 * @Created by 湖南达联
 */
@Service
public class FansRankServiceImpl implements FansRankService {

    @Resource
    private RedisPageService redisPageService;

    @Resource
    private StarFansDayStatisticsManager starFansDayStatisticsManager;

    @Resource
    private StarFansWeekStatisticsManager starFansWeekStatisticsManager;

    @Resource
    private StarFansMonthStatisticsManager starFansMonthStatisticsManager;

    @Override
    public Result<Object> findRunTimeDayFansRank(Long userUniId,Integer pageNo, Integer pageSize) {
        LocalDate now = LocalDate.now();
        //获取到key
        String key = RedisFansRankKey.getFansDayRankKey(now);

        StarFansDayVo vo = new StarFansDayVo();

        List<StarFansDayStatisticsDo> kvList = redisPageService.getKVList(key, pageNo, pageSize);

        vo.setFansRankList(kvList);

        if(userUniId != null){
             StarFansDayStatisticsDo starFansDayMaxContribute = starFansDayStatisticsManager.findStarFansDayMaxContribute(userUniId);
             vo.setMyMaxContribute(starFansDayMaxContribute);
        }

        return ResultFactory.success(vo);
    }

    @Override
    public Result<Object> findRunTimeWeekFansRank(Long userUniId,Integer pageNo, Integer pageSize) {
        LocalDate now = LocalDateUtil.firstDayOfWeek();
        //获取到key
        String key = RedisFansRankKey.getFansWeekRankKey(now);

        List<StarFansMonthStatisticsDo> kvList = redisPageService.getKVList(key,pageNo,pageSize);

        StarFansDayVo vo = new StarFansDayVo();

        vo.setFansRankList(kvList);

        if(userUniId != null){
            StarFansWeekStatisticsDo starFansDayMaxContribute = starFansWeekStatisticsManager.findStarFansDayMaxContribute(userUniId);
            vo.setMyMaxContribute(starFansDayMaxContribute);
        }

        return ResultFactory.success(vo);
    }

    @Override
    public Result<Object> findRunTimeMonthFansRank(Long userUniId,Integer pageNo, Integer pageSize) {
        LocalDate now = LocalDateUtil.firstDayOfMonth();
        //获取到key
        String key = RedisFansRankKey.getFansMonthRankKey(now);

        List<StarFansMonthStatisticsDo> kvList = redisPageService.getKVList(key,pageNo,pageSize);

        StarFansDayVo vo = new StarFansDayVo();

        vo.setFansRankList(kvList);

        if(userUniId != null){
            StarFansWeekStatisticsDo starFansWeekMaxContribute = starFansWeekStatisticsManager.findStarFansDayMaxContribute(userUniId);
            vo.setMyMaxContribute(starFansWeekMaxContribute);
        }

        return ResultFactory.success(vo);
    }

    @Override
    public Result<Object> findHistoryDayFansRank(Long userUniId,LocalDate localDate) {
        StarFansDayVo vo = new StarFansDayVo();

        List<StarFansDayStatisticsDo> statisticsDos = starFansDayStatisticsManager.findByDate(localDate,BaseConstants.STAR_RANK_DEFAULT_LIMIT);
        vo.setFansRankList(statisticsDos);

        if(userUniId != null){
            StarFansDayStatisticsDo starFansDayMaxContribute = starFansDayStatisticsManager.findStarFansDayMaxContribute(userUniId);
            vo.setMyMaxContribute(starFansDayMaxContribute);
        }

        return ResultFactory.success(vo);
    }

    @Override
    public Result<Object> findHistoryWeekFansRank(Long userUniId,LocalDate localDate) {

        List<StarFansWeekStatisticsDo> byDate = starFansWeekStatisticsManager.findByDate(localDate,BaseConstants.STAR_RANK_DEFAULT_LIMIT);

        StarFansDayVo vo = new StarFansDayVo();

        vo.setFansRankList(byDate);

        if(userUniId != null){
            StarFansWeekStatisticsDo starFansWeekMaxContribute = starFansWeekStatisticsManager.findStarFansDayMaxContribute(userUniId);
            vo.setMyMaxContribute(starFansWeekMaxContribute);
        }

        return ResultFactory.success(vo);
    }

    @Override
    public Result<Object> findHistoryMonthFansRank(Long userUniId,LocalDate localDate) {
        List<StarFansMonthStatisticsDo> byDate = starFansMonthStatisticsManager.findByDate(localDate, BaseConstants.STAR_RANK_DEFAULT_LIMIT);

        StarFansDayVo vo = new StarFansDayVo();

        vo.setFansRankList(byDate);

        if(userUniId != null){
            StarFansMonthStatisticsDo starFansDayMaxContribute = starFansMonthStatisticsManager.findStarFansDayMaxContribute(userUniId);
            vo.setMyMaxContribute(starFansDayMaxContribute);
        }

        return ResultFactory.success(vo);
    }
}
