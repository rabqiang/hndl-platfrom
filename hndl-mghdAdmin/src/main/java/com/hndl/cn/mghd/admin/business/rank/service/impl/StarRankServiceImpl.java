package com.hndl.cn.mghd.admin.business.rank.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.mghd.admin.business.rank.service.StarRankService;
import com.hndl.cn.mghd.admin.business.rank.vo.StarRankVo;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import com.hndl.cn.mongodb.manager.star.bean.StarMonthRankDo;
import com.hndl.cn.mongodb.manager.star.bean.StarWeekRankDo;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
import com.hndl.cn.mongodb.manager.star.manager.StarMonthRankManager;
import com.hndl.cn.mongodb.manager.star.manager.StarWeekRankManager;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.date.LocalDateUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:hndl-platform
 * @description: 明星排名后台
 * @author: 易成贤
 * @create: 2019-06-27 10:34
 * @Created by湖南达联
 **/
@Service
public class StarRankServiceImpl implements StarRankService {

    @Resource
    StarDayRankManager starDayRankManager;
    
    @Resource
    StarWeekRankManager starWeekRankManager;

    @Resource
    StarMonthRankManager starMonthRankManager;
    
    

    /**
     * 查询日榜数据
     *
     * @param
     * @return
     */
    @Override
    public List<StarRankVo> findStarDayRank() {
        List<StarDayRankDo> starDayRankByRank = starDayRankManager.findStarDayRankByRankDate(System.currentTimeMillis(), BaseConstants.STAR_RANK_DEFAULT_LIMIT);
        return SpringCglibBeanUtils.convertByList(starDayRankByRank,StarRankVo.class);
    }

    /**
     * 查询周榜数据
     *
     * @return
     */
    @Override
    public List<StarRankVo> findStarWeekRank() {
        List<StarWeekRankDo> starWeekRank = starWeekRankManager.findByRankDate(System.currentTimeMillis(), BaseConstants.STAR_RANK_DEFAULT_LIMIT);
        return SpringCglibBeanUtils.convertByList(starWeekRank,StarRankVo.class);
    }

    /**
     * 查询月榜数据
     *
     * @return
     */
    @Override
    public List<StarRankVo> findStarMouthRank() {

        List<StarMonthRankDo> starMonthRank = starMonthRankManager.findByRankDate(System.currentTimeMillis(), BaseConstants.STAR_RANK_DEFAULT_LIMIT);
        return SpringCglibBeanUtils.convertByList(starMonthRank,StarRankVo.class);

    }

    /**
     * 初始化日周月榜数据
     *
     * @param starRankVo
     */
    @Override
    public void initStarRank(StarRankVo starRankVo) {
        //日
        StarDayRankDo starDayRankDo = SpringCglibBeanUtils.convert(starRankVo, StarDayRankDo.class);
        starDayRankDo.setRankTime(LocalDateTimeUtil.getNowMinTimeMilli());
        ArrayList<StarDayRankDo> starDayRankDos = new ArrayList<>(1);
        starDayRankDos.add(starDayRankDo);
        starDayRankManager.insertInBatch(starDayRankDos);
        //周
        StarWeekRankDo starWeekRankDo = SpringCglibBeanUtils.convert(starRankVo, StarWeekRankDo.class);
        starWeekRankDo.setRankTime(LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfWeek(LocalDate.now())));
        ArrayList<StarWeekRankDo> starWeekRankDos = new ArrayList<>(1);
        starWeekRankDos.add(starWeekRankDo);
        starWeekRankManager.insertInBatch(starWeekRankDos);
        //月
        StarMonthRankDo starMonthRankDo = SpringCglibBeanUtils.convert(starRankVo, StarMonthRankDo.class);
        starWeekRankDo.setRankTime(LocalDateUtil.localDateToMilliSecond(LocalDateUtil.firstDayOfMonth(LocalDate.now())));
        ArrayList<StarMonthRankDo> starMonthRankDos = new ArrayList<>(1);
        starMonthRankDos.add(starMonthRankDo);
        starMonthRankManager.insertInBatch(starMonthRankDos);
    }
}
