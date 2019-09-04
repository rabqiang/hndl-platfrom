package com.hndl.cn.chat.sys.common.constants;

/**
 * @Classname 赵俊凯
 * @Description 全局相关常量
 *  *   1：常量以cache.开头，后面跟具体含义
 *  *   2：常量跟值要尽量一至，（PREFIX值可以忽略）
 *  *   3：常量值小写
 * @Date 2019/3/11 15:42
 * @Created by 湖南达联
 */
public interface ChatSysConstants {

    Integer ROOM_MAX_NUMBER = 5000;

    String INIT_CHAT_ROOM_REDIS_PACKAGE_NAME = "init_chat_room";//创建聊天室的redis lock文件夹

    Long INIT_CHAT_ROOM_REDIS_TIME_OUT = 3000L;//创建聊天室的redis lock 过期时间

    Integer TO_DAY_SEND_MSG_MAX_COUNT = 3;//每天发言三次就可以获得积分

    String  TO_DAY_REASON_MSG = "粉丝会发言-微信";

    Integer TO_DAY_REASON_REWARD_NUMBER = 20;

    String USER_ROOM_MSG_TASK_KEY = "room_task_key_";//用户发言的key

    String HISTORY_CHAT_ROOM_MSG_KEY = "history_chat_room_msg_key_";// 历史纪录缓存

    Integer HISTORY_CHAT_ROOM_LIMIT = 20;

    Long HISTORY_CHAT_ROOM_KEY_TIME_OUT = 10L;//缓存获取时间
}
