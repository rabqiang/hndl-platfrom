package com.hndl.cn.base.redis.rank;

import java.time.LocalDate;

/**
 * @author 赵俊凯
 * @Description 星粉榜排名的key
 * @Date 2019/4/26 16:00
 * @Created by 湖南达联
 */
public class RedisFansRankKey {


    private static final String FANS_DAY_RANK = "fans_day_rank_";

    private static final String FANS_WEEK_RANK = "fans_week_rank_";

    private static final String FANS_MONTH_RANK = "fans_month_rank_";

    public static final Long HISTORY_TIME_OUT = 3600L;//历史数据的过期时间



    public static String getFansDayRankKey(LocalDate localDate){
           return FANS_DAY_RANK + localDate.toString();
    }

    public static String getFansWeekRankKey(LocalDate localDate){
        return FANS_WEEK_RANK + localDate.toString();
    }

    public static String getFansMonthRankKey(LocalDate localDate){
        return FANS_MONTH_RANK + localDate.toString();
    }
}
