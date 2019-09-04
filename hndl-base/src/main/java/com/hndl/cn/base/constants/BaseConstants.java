package com.hndl.cn.base.constants;

/**
 * @Classname 赵俊凯
 * @Description 全局相关常量
 * *   1：常量以cache.开头，后面跟具体含义
 * *   2：常量跟值要尽量一至，（PREFIX值可以忽略）
 * *   3：常量值小写
 * @Date 2019/3/11 15:42
 * @Created by 湖南达联
 */
public interface BaseConstants {

    String SUCESS = "success";

    /**
     * 有效标志-有效
     */
    Integer VALID_SIGN_Y = 1;

    /**
     * 有效标志-无效
     */
    Integer VALID_SIGN_N = 0;

    Long DEFAULT_SYS_ID = 0L;

    //int初值
    Integer STARTING_INT_VALUE = 0;
    Long STARTING_LONG_VALUE = 0L;
    //贡献初始值
    Long CONTRIBUTE_INITIAL_VALUE = 20L;

    Integer FANS_MASTER_MAX = 5; //粉丝大咖最大数量
    Integer FANS_AMBASSADOR_MAX = 1; //守护大使最大数量
    Integer ADD_FANSGROUP_MAX = 8; //用户加入粉丝会最大上限

    String JWT_TOKEN_COOKIE_KEY = "hndl_jwt_token_cookie_key";// 登陆后cookie的token

    String HTTP_HEADER_KEY = "hndl_http_header_key";

    String JWT_TOKEN_KEY = "hndl_jwt_token_key";// jwt 加密密钥

    Long JWT_TOKEN_VALID_TIME = 2592000000L; //jwt token 有效时间

    String REQUEST_LOGIN_USER_ID_KET = "request_login_user_id_key";//Request里用户信息的key

    String PAY_NOTICE_LOCK_PACKAGE_KEY = "pay_notice";//支付锁的PACKAGE NAME

    String USER_TASK_GET_INTEGRAL_LOCK_KEY = "user_task_get_integral";//领取任务奖励锁

    String USER_TASK_GET_NOR_INTEGRAL_LOCK_KEY = "user_normality_task_get_integral";//领取任务奖励锁
    /**
     * 插入任务的锁
     */
    String USER_INSERT_TASK_LOCK_KEY = "user_insert_task_key";

    /**
     * 奖品的key
     */
    String PRIZE_BASE_KEY = "prize_base_key_id";

    String Default_personImgUrlMax = "http://mghd.oss-cn-hangzhou.aliyuncs.com/personPhoto/default/personPhotoMax.png";

    String Default_personImgUrlMin = "http://mghd.oss-cn-hangzhou.aliyuncs.com/personPhoto/default/personPhotoMin.png";

    String LOGIN_AES_SECRET_KEY = "login_aes_secret_key";

    Integer STAR_RANK_DEFAULT_LIMIT = 50;//默认榜单数据50

    Integer BARRAGE_MSG_DEFAULT_LIMIT = 100;//弹幕消息默认100条

    Integer BARRAGE_MSG_MAX_LIMIT = 200;//弹幕消息200条

    Integer UPDATE_MAX_LIMIT = 500; // 修改语句最大条数

    Integer UPDATE_MIN_LIMIT = 1; //修改语句最小条数


    Integer DEFAULT_LIMIT = 20;
    /**
     * 后台每页数量
     */
    Integer ADMIN_CALL_LIMIT = 10;

    /**
     * banner每页数量
     */
    Integer BANNER_LIMIT = 10;

    Integer USERMESSAGE_LIMIT = 30;//默认消息数据 30

    Integer FOLLOW_LIMIT = 5;//默认关注用户数据 5

    Integer DEFAULT_COMMENT_TYPE = 1;

    Long DEFAULT_STAR_ID = 1L;

    //微博access token的url
    String OAUTH2 = "https://api.weibo.com/oauth2/access_token?client_id=%s&client_secret=%s&grant_type=authorization_code&redirect_uri=https://api.weibo.com/oauth2/default.html&code=%s";
    //微博的client_id /申请应用时分配的AppKey。
    Integer CLIENT_ID = 644266243;
    //微博申请应用时分配的AppSecret
    String CLIENT_SECRET = "f916ea640fa8dc55f97f85651109e6ed";
    //微博获取数据的url//主要用于获取该用户关注的微博
    //过滤参数feature 过滤类型ID，0：全部、1：原创、2：图片、3：视频、4：音乐，默认为0。
    String HOME_TIMELINE = "https://api.weibo.com/2/statuses/home_timeline.json?access_token=%s&page=%s&count=%s&feature=1";

    //JSON KEY
    String NIKENAME_KEY = "userNickName";
    String TARGET_KEY = "targetId";
    String IMG_KEY = "userImg";

    Integer ACTIVITY_MAX_NUM = 100; //最大取一百条活动


    String VOTE_LOCK_KEY = "vote_lock";

    Integer INTEGER_VOTE_DAY_FUKA_COUNT = 10;//积分打扮的福卡数

    /**
     * 话题最大推荐数
     */
    Long MAX_RECOMMEN_TOPIC_COUNT = 10L;
    /**
     * 非推荐话题最大数
     */
    Long MAX_NOTRECOMMEN_TOPIC_COUNT = 100L;

    /**
     * 推荐call内容
     */
    Integer MAX_CALL_RCOMMEND_LIMIT = 100;

    /** 新用户助力值基数 */
    Integer NEW_USER_HELPCOUNT = 15;

    /** 老用户助力值基数 */
    Integer OLD_USER_HELPCOUNT = 10;

}
