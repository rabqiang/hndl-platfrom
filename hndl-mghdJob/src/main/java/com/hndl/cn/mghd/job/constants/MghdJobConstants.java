package com.hndl.cn.mghd.job.constants;

/**
 * @Classname 赵俊凯
 * @Description 全局相关常量
 * *   1：常量以cache.开头，后面跟具体含义
 * *   2：常量跟值要尽量一至，（PREFIX值可以忽略）
 * *   3：常量值小写
 * @Date 2019/3/11 15:42
 * @Created by 湖南达联
 */
public interface MghdJobConstants {

    String JOB_STATUS_WAIT = "waiting";//等待状态

    String JOB_STATUS_RUN = "running";//执行状态

    String APP_ID = "MGHD_JOB_SYS";// 系统app id
    /**
     * 设置师徒额外奖励的limit阈值
     */
    Integer MENTOR_REWARD_LIMIT = 100000;

    /**
     * 限制每个用户最多只能增加2000积分
     */
    Integer MENTOR_REWARD_INTEGRAL = 2000;


    String JOB_NAME = "AutoDayFanAwardJob";

    String VOTE_JOB_NAME = "AutoDayVoteMessageDelJob";

    String MONTH_JOB_NAME = "AutoMonthFanAwardJob";

    Long MESSAGE_SYS_ID = 0L;


    //名次
    Integer REWARD_TOP_ONE = 1;//第一名
    Integer REWARD_TOP_TWO = 2;//第二名
    Integer REWARD_TOP_THREE = 3;//第三名
    Integer REWARD_TOP_TEN = 11;//前十名
    Integer REWARD_TOP_FIFTY = 51;//前50名

    String REWARD_PUSH_URL = "";
    //每日奖励-粉丝榜 top1奖励
    Long REWARD_DAY_TOP_ONE_INTEGRAL = 1200L;
    // Long REWARD_DAY_TOP_ONE_LOVE = 1500L;

    //每日奖励-粉丝榜 top2奖励
    Long REWARD_DAY_TOP_TWO_INTEGRAL = 1000L;
    // Long REWARD_DAY_TOP_TWO_LOVE = 1000L;

    //每日奖励-粉丝榜 top3奖励
    Long REWARD_DAY_TOP_THREE_INTEGRAL = 800L;
    // Long REWARD_DAY_TOP_THREE_LOVE = 800L;

    //每日奖励-粉丝榜 top 10奖励
    Long REWARD_DAY_TOP_TEN_INTEGRAL = 600L;
    //Long REWARD_DAY_TOP_TEN_LOVE = 666L;

    //每日奖励-粉丝榜 top 50奖励
    Long REWARD_DAY_TOP_FIFTY_INTEGRAL = 300L;
    // Long REWARD_DAY_TOP_FIFTY_LOVE = 333L;


    //每月奖励-粉丝榜 top1奖励
    Long REWARD_MONTH_TOP_ONE_INTEGRAL = 10000L;


    //每月奖励-粉丝榜 top2奖励
    Long REWARD_MONTH_TOP_TWO_INTEGRAL = 8000L;


    //每月奖励-粉丝榜 top3奖励
    Long REWARD_MONTH_TOP_THREE_INTEGRAL = 6000L;

    //每月奖励-粉丝榜 top10奖励
    Long REWARD_MONTH_TOP_TEN_INTEGRAL = 5000L;

    //每月奖励-粉丝榜 top50奖励
    Long REWARD_MONTH_TOP_FIFTY_INTEGRAL = 3000L;

    Long REWARD_MONTH_LOVE = 0L;//暂无爱心奖励

}
