package com.hndl.cn.base.redis.rank;

import java.time.LocalDate;

/**
 * @author 赵俊凯
 * @Description 明星排名的key
 * @Date 2019/4/26 16:00
 * @Created by 湖南达联
 */
public class RedisStarRankKey {


    private static final String STAR_DAY_RANK = "star_day_rank_";

    private static final String STAR_WEEK_RANK = "star_week_rank_";

    private static final String STAR_MONTH_RANK = "star_month_rank_";

    public static final Long HISTORY_TIME_OUT = 3600L;//历史数据的过期时间



    public static String getStarDayRankKey(LocalDate localDate){
           return STAR_DAY_RANK + localDate.toString();
    }

    public static String getStarWeekRankKey(LocalDate localDate){
        return STAR_WEEK_RANK + localDate.toString();
    }

    public static String getStarMonthRankKey(LocalDate localDate){
        return STAR_MONTH_RANK + localDate.toString();
    }
}
