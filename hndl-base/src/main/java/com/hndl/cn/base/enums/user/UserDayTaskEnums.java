package com.hndl.cn.base.enums.user;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description 用户每日任务枚举类
 * @Date 2019/4/18 15:41
 * @Created by 湖南达联
 */
public enum UserDayTaskEnums {
    //1 比心打榜 5
    GIVE_HEART_TASK(1, 5, 100,"https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/heart.png", "比心打榜"),

    //2 积分打榜 3
    INTEGRAL_TASK(2, 3, 30,"https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/coin.png", "积分打榜"),

    //3 守护 2
    GUARD_TASK(3, 2, 20, "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/guard.png","守护"),

    //4 召唤 3

    SUMMON_TASK(4, 3, 30,"https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/summon.png", "召唤"),

    //5 粉丝会发言 3 聊天室
    ROOM_TASK(5, 3, 20, "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/taskListImg/icon_fans_club_call.png","粉丝会发言"),

    //6 登录
    LOGIN_TASK(6, 1, 20, "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/login.png","登录"),

    //7 打call任务 2
    CALL_TASK(7, 1, 20, "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/publish.png","打call"),

    //每日评论
    COMMENT_TASK(8, 2, 10, "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/comment.png","评论"),

    //每日点赞
    LIKE_TASK(9, 2, 10, "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/like.png","点赞"),

    //每日公益
    LOVE_TASK(10, 5, 10, null,"公益"),

    //APP充值
    PAY_TASK(11, Integer.MAX_VALUE, 100,null ,"APP充值"),

    //观看视频
    WATCH_VIDEO(12,10,0,null,"观看视频")
    ;


    private Integer taskType;//任务类型
    private Integer dayCount;//每日次数
    private Integer integralCount;//获得积分
    private String taskImg;//任务图片
    private String description;//描述



    UserDayTaskEnums(Integer taskType, Integer dayCount, Integer integralCount, String taskImg, String description) {
        this.taskType = taskType;
        this.dayCount = dayCount;
        this.integralCount = integralCount;
        this.description = description;
        this.taskImg = taskImg;
    }

    public String getTaskImg() {
        return taskImg;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public String getDescription() {
        return description;
    }

    public Integer getIntegralCount() {
        return integralCount;
    }

     public static Map<Integer, UserDayTaskEnums> getWeChat() {

        Map<Integer, UserDayTaskEnums> map = new HashMap();
        map.put(UserDayTaskEnums.GIVE_HEART_TASK.getTaskType(), UserDayTaskEnums.GIVE_HEART_TASK);
        map.put(UserDayTaskEnums.INTEGRAL_TASK.getTaskType(), UserDayTaskEnums.INTEGRAL_TASK);
        map.put(UserDayTaskEnums.GUARD_TASK.getTaskType(), UserDayTaskEnums.GUARD_TASK);
        map.put(UserDayTaskEnums.SUMMON_TASK.getTaskType(), UserDayTaskEnums.SUMMON_TASK);
        map.put(UserDayTaskEnums.ROOM_TASK.getTaskType(), UserDayTaskEnums.ROOM_TASK);
        map.put(UserDayTaskEnums.LOGIN_TASK.getTaskType(), UserDayTaskEnums.LOGIN_TASK);

        return map;
    }
    public static Map<Integer, UserDayTaskEnums> getApp(){

        Map<Integer, UserDayTaskEnums> map = new HashMap();

        map.put(UserDayTaskEnums.GIVE_HEART_TASK.getTaskType(), UserDayTaskEnums.GIVE_HEART_TASK);
        map.put(UserDayTaskEnums.INTEGRAL_TASK.getTaskType(), UserDayTaskEnums.INTEGRAL_TASK);
        map.put(UserDayTaskEnums.GUARD_TASK.getTaskType(), UserDayTaskEnums.GUARD_TASK);
        map.put(UserDayTaskEnums.SUMMON_TASK.getTaskType(), UserDayTaskEnums.SUMMON_TASK);
       // map.put(UserDayTaskEnums.ROOM_TASK.getTaskType(), UserDayTaskEnums.ROOM_TASK);
        map.put(UserDayTaskEnums.LOGIN_TASK.getTaskType(), UserDayTaskEnums.LOGIN_TASK);
        map.put(UserDayTaskEnums.CALL_TASK.getTaskType(),UserDayTaskEnums.CALL_TASK);
        map.put(UserDayTaskEnums.COMMENT_TASK.getTaskType(),UserDayTaskEnums.COMMENT_TASK);
        map.put(UserDayTaskEnums.LIKE_TASK.getTaskType(),UserDayTaskEnums.LIKE_TASK);
       // map.put(UserDayTaskEnums.LOVE_TASK.getTaskType(),UserDayTaskEnums.LOVE_TASK);
       // map.put(UserDayTaskEnums.PAY_TASK.getTaskType(),UserDayTaskEnums.PAY_TASK);

        return map;
    }
    //是app的任务吗
    public  static  boolean isApp(Integer type){
       // include：包含
        boolean include = false;
        for (UserDayTaskEnums enums : getApp().values()) {
            include = enums.getTaskType().equals(type);
            if (include) {
                break;
            }
        }
        return include;
    }
    //是wechat的任务吗
    public  static  boolean isWeChat(Integer type){
        // include：包含
        boolean include = false;
        for (UserDayTaskEnums enums :getWeChat().values()) {
            include = enums.getTaskType().equals(type);
            if(include) {
                break;
            }
        }
        return include;
    }

    public static boolean checkVal(Integer taskType) {
        if (taskType != null) {
            for (UserDayTaskEnums c : UserDayTaskEnums.values()) {
                if (c.getTaskType().equals(taskType)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static UserDayTaskEnums evalVal(Integer taskType) {
        for (UserDayTaskEnums enums : UserDayTaskEnums.values()) {
            if (enums.getTaskType().equals(taskType)) {
                return enums;
            }
        }
        return null;
    }
}
