package com.hndl.cn.mghd.sys.common.constants;

/**
 * @Classname 赵俊凯
 * @Description 全局相关常量
 *  *   1：常量以cache.开头，后面跟具体含义
 *  *   2：常量跟值要尽量一至，（PREFIX值可以忽略）
 *  *   3：常量值小写
 * @Date 2019/3/11 15:42
 * @Created by 湖南达联
 */
public interface MghdSysConstants {


    Long PAY_SYS_NOTICE_LOCK_TIME = 300L;//支付通知分布式锁的时间
    /**
     * 任务领取积分分布式锁时间
     */
    Long TASK_SYS_GET_INTEGRAL_LOCK_TIME = 1500L;
    /**
     * 任务插入分布式锁时间
     */
    Long TASK_SYS_INSERT_LOCK_TIME = 1500L;

    Integer STAR_MIN_HISTORY_DAY = 6;//明星日榜历史数据

    Integer STAR_MIN_HISTORY_WEEK = 6;//明星周榜历史数据

    Integer STAR_MIN_HISTORY_MONTH = 6;//明星月榜历史数据

    Integer INIT_PAGE_NO = 1;

    Integer INIT_PAGE_LIMIT = 20;

    Integer INIT_STAR_PAGE_LIMIT = 100;

    Integer ADD_ONE_NUM = 1; //+1操作

    Integer MINUS_ONE_NUM = -1; //-1操作

    Integer INTEGRAL_VOTE_THRESHOLD = 99;//积分打榜出发弹幕的阈值

    Integer USER_FOLLOW_MAX_NUM = 15;//最大关注的用户查询条数

    Integer USER_FOLLOW_NUM = 7;

    Integer STAR_FOLLOW_NUM = 8;

    Integer ZERO = 0; //0

    Integer ONE=1;

    Integer NOW_PAGE_NUM = 10; //当前页

    Integer MAX_PAGE_NUM = 200;//最大分页条数

    Integer TWENTY_PAGE_NUM = 20; // 20页

    Integer HOME_CONTENT_LIMIT = 300;

    Integer TASK_COUNT_MASTER_REWARD_THRESHOLE = 5;//完成任务奖励阈值

    Integer POPULATION_THREE_NUM=3;//大波分弹幕人数倍数

    Integer LOVE_GAME_TEAM_NUM=11;//明星公益游戏队伍捐赠次数弹幕阈值

    Integer FIVE_PAGE_LIMIT=5;// 获取 5 条数据

    Integer FIFTY_PAGE_LIMIT=50;// 获取 50 条数据

    Integer ONE_HUNDRED_PAGE_LIMIT=100;// 获取 100 天数据

    String USER_AUTH_UPLOAD_IMG_LIMIT_TYPE = "jpg|png|jpeg|gif";

    int USER_AUTH_UPLOAD_IMG_LIMIT_SIZE = 10 * 1024;

    String DEFAULT_SIGNATURE="我就是我，不一样的风景";

    Integer LUCK_DRAW_COUNT = 800;

    Integer COIN_LUCK_DRAW_COUNT = 500;

    Integer TOPIC_COMMENT_PAGE_NUM = 10;

    Integer DAILY_TOPIC_COMMENT_LIMIT=3;

    Integer SON_TOPIC_COMMENT_LIMIT=2;


    Integer VOTE_MULTIPLE = 2;

}
