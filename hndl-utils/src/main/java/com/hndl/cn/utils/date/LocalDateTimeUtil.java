package com.hndl.cn.utils.date;

import java.time.*;
import java.util.Date;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/31 15:51
 * @Created by 湖南达联
 */
public class LocalDateTimeUtil {

    /**
     * 获取今天的初始时间
     * @return
     */
    public static Long getNowMinTimeMilli(){
        return  DateUtil.beginOfDate(new Date()).getTime();
    }

    /**
     * 获取今天的结束时间
     * @return
     */
    public static Long getNowMaxTimeMilli(){
        return  DateUtil.endOfDate(new Date()).getTime();
    }


    /**
     * 获取昨天的初始时间
     * @return
     */
    public static  Long getYesterdayMinTimeMilli(){
        return  DateUtil.beginOfDate(new Date(System.currentTimeMillis()-1000*60*60*24)).getTime();
    }

    /**
     * 获取昨天的结束时间
     * @return
     */
    public static  Long getYesterdayMaxTimeMilli(){
        return DateUtil.endOfDate(new Date(System.currentTimeMillis()-1000*60*60*24)).getTime();
    }

    public static Long localDateToSecond(LocalDateTime localDateTime){
        return localDateTime.toEpochSecond(ZoneOffset.of("+8"));
    }

    public static Long localDateToMilliSecond(LocalDateTime localDateTime){
        return localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli();
    }

    public static LocalDateTime milliSecondToLocalDateTime(Long milliSecond){
         return Instant.ofEpochMilli(milliSecond).atZone(ZoneId.systemDefault()).toLocalDateTime();
    }


    public static void main(String[] args) {
        System.out.println(getNowMinTimeMilli());
        System.out.println(getNowMaxTimeMilli());
    }

}
