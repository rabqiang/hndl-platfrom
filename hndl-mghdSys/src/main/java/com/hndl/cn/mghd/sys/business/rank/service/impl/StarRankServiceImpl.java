package com.hndl.cn.mghd.sys.business.rank.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.base.redis.rank.RedisStarRankKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.base.vo.StarDayRankVo;
import com.hndl.cn.mghd.sys.business.banner.service.BannerService;
import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;
import com.hndl.cn.mghd.sys.business.rank.service.StarRankService;
import com.hndl.cn.mghd.sys.business.rank.vo.InitStarRankVo;
import com.hndl.cn.mghd.sys.business.rank.vo.MyStarVo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupDo;
import com.hndl.cn.mongodb.manager.star.bean.StarFansGroupRelationDo;
import com.hndl.cn.mongodb.manager.star.manager.*;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/28 11:53
 * @Created by 湖南达联
 */
@Service
public class StarRankServiceImpl implements StarRankService {

    @Resource
    private StarWeekRankManager starWeekRankManager;

    @Resource
    private StarDayRankManager starDayRankManager;

    @Resource
    private StarMonthRankManager starMonthRankManager;

    @Resource
    private RedisPageService redisPageService;

    @Resource
    private BannerService bannerService;

    @Resource
    private StarFansGroupManager starFansGroupManager;

    @Resource
    private StarFansGroupRelationManager starFansGroupRelationManager;


    @Resource(name = "CallableExecutePool")
    private ThreadPoolTaskExecutor executor;

    @Override
    public Result<Object> initRunTimeDayStarRank(Long userUniId) {
        InitStarRankVo initStarRankVo = null;

        Future<List<BannerVo>> banner = executor.submit(() ->
                bannerService.findBannerInfo(BannerEnums.STAR_RANK));

        Future<List<StarDayRankVo>> rank = executor.submit(() ->
                redisPageService.getKVList(RedisStarRankKey.getStarDayRankKey(LocalDate.now()),
                        MghdSysConstants.INIT_PAGE_NO, MghdSysConstants.INIT_STAR_PAGE_LIMIT));

        try {

            List<BannerVo> commonAdInfoDos = banner.get();

            List<StarDayRankVo> voList = rank.get();



             initStarRankVo = InitStarRankVo.builder().
                    bannerVoList(SpringCglibBeanUtils.convertByList(commonAdInfoDos,BannerVo.class))
                    .starDayRankVoList(voList).build();

        }catch (Exception e){
            e.printStackTrace();
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_INIT_STAR_RANK_EX.getCode());

        }
        return ResultFactory.success(initStarRankVo);
    }

    @Override
    public Result<Object> findRunTimeDayStarRank(Integer pageNo,Integer pageSize) {
        List<StarDayRankVo> kvList = redisPageService.getKVList
                (RedisStarRankKey.getStarDayRankKey(LocalDate.now()), pageNo, pageSize);

        if(CollectionUtils.isNotEmpty(kvList)){
             return  ResultFactory.success(kvList);
        }

        return ResultFactory.success(starDayRankManager.findStarDayRankByRankDate(
                LocalDateUtil.localDateToMilliSecond(LocalDate.now()),MghdSysConstants.INIT_STAR_PAGE_LIMIT));
    }

    @Override
    public Result<Object> findHistoryDayStarRank(LocalDate localDate) {
        return ResultFactory.success(starDayRankManager.findStarDayRankByRankDate(
                LocalDateUtil.localDateToMilliSecond(localDate), BaseConstants.STAR_RANK_DEFAULT_LIMIT));
    }

    @Override
    public Result<Object> findRunTimeWeekStarRank(Integer pageNo,Integer pageSize) {
        return  ResultFactory.success(redisPageService.getKVList
                (RedisStarRankKey.getStarWeekRankKey(LocalDateUtil.firstDayOfWeek()),pageNo,pageSize));
    }

    @Override
    public Result<Object> findHistoryWeekStarRank(LocalDate localDate) {
        return ResultFactory.success(starWeekRankManager.findByRankDate(
                LocalDateUtil.localDateToMilliSecond(localDate),BaseConstants.STAR_RANK_DEFAULT_LIMIT));
    }

    @Override
    public Result<Object> findRunTimeMonthStarRank(Integer pageNo,Integer pageSize) {
        return  ResultFactory.success(redisPageService.getKVList
                (RedisStarRankKey.getStarMonthRankKey(LocalDateUtil.firstDayOfMonth()),pageNo,pageSize));
    }

    @Override
    public Result<Object> findHistoryMonthStarRank(LocalDate localDate) {
        return ResultFactory.success(starMonthRankManager.findByRankDate(
                LocalDateUtil.localDateToMilliSecond(localDate),BaseConstants.STAR_RANK_DEFAULT_LIMIT));
    }
}
