package com.hndl.cn.activity.sys.constants;

/**
 * @Classname 赵俊凯
 * @Description 全局相关常量
 *  *   1：常量以cache.开头，后面跟具体含义
 *  *   2：常量跟值要尽量一至，（PREFIX值可以忽略）
 *  *   3：常量值小写
 * @Date 2019/3/11 15:42
 * @Created by 湖南达联
 */
public interface ActivitySysConstants {

    Integer HAPPY_LIBRARY_NOW_COUNT = 5;//每天次数限制

    Long HAPPY_LIBRARY_VOTE_NUMBER = 1L;//每次加1


    String HAPPY_LIBRARY_REDIS_KEY = "happy_library_redis_key";//

    Long HAPPY_LIBRARY_REDIS_KEY_TIME_OUT = -1L;//默认设置不过期

    Long INIT_LONG = 0L;//初始化Long值

}
