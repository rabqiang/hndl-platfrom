package com.hndl.cn.base.enums.user;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 易成贤
 * @Description 大转盘任务枚举与每日任务和常态任务维持任务类型一致
 * @Date
 * @Created by 湖南达联
 */
public enum FoucaultGetTypeEnums {
    /**
     * 比心
     */
    GIVE_HEART_TASK(UserDayTaskEnums.GIVE_HEART_TASK.getTaskType(), "比心", Integer.MAX_VALUE, "每消耗5快乐币，获得一张福卡", "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/img/icon_lucky_wheel_heart.png", "去比心"),

    /**
     * 积分打榜 3
     */
    INTEGRAL_TASK(UserDayTaskEnums.INTEGRAL_TASK.getTaskType(), "积分打榜", 10, "每消耗800积分，获得一张福卡", "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/img/icon_lucky_wheel_rank.png", "去打榜"),
    /**
     * 收徒
      */
  //  OBEY_SLAVE(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType(),"收徒",Integer.MAX_VALUE,"每收一个徒弟，增加一次抽奖次数","https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/img/icon_lucky_wheel_logo.png","去收徒"),

    /**
     * 观看视频
     */
    WATCH_VIDEO(UserDayTaskEnums.WATCH_VIDEO.getTaskType(),"观看视频", 10 ,"观看完整的视频，获得一张福卡(10张/天)", "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/img/icon_lucky_wheel_video.png", "去观看"),

    /**
     * 转转盘
     */
    TURN_TURNTABLE(101, "转盘抽奖", Integer.MAX_VALUE, "", "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/images/icon_record_lucky_wheel.png", ""),

    /**
     * 限时抢福利
     */
    DAYLIGHT_ROBBERY(102, "限时抢福利", Integer.MAX_VALUE, "", "https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/images/icon_record_benefit_snatching.png", ""),

    /**
     * 福卡退还
     */
    RETURN_ROBBERY(103, "开奖失败，福卡退还",null, "","https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/images/icon_record_benefit_snatching.png", null),

    ;

    /**
     * 任务类型
     */
    private Integer taskType;
    /**
     * 标题
     */
    private String taskTitle;

    /**
     * 次数
     */
    private Integer timeCount;
    /**
     * 表述
     */
    private String description;

    /**
     * 图片
     */
    private String imgUrl;
    /**
     * 按钮
     */
    private String button;


    FoucaultGetTypeEnums(Integer taskType, String taskTitle, Integer timeCount, String description, String imgUrl, String button) {
        this.taskType = taskType;
        this.taskTitle = taskTitle;
        this.timeCount = timeCount;
        this.description = description;
        this.imgUrl = imgUrl;
        this.button = button;
    }

    public static FoucaultGetTypeEnums eval(Integer taskType) {
        if (taskType == null) {
            return null;
        }
        return Arrays.stream(FoucaultGetTypeEnums.values()).filter(input -> input.taskType.equals(taskType)).findFirst()
                .orElseGet(null);
    }

    public Integer getTaskType() {
        return taskType;
    }

    public String getTaskTitle() {
        return taskTitle;
    }

    public Integer getTimeCount() {
        return timeCount;
    }

    public String getDescription() {
        return description;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public String getButton() {
        return button;
    }

    //
    public static Map<Integer,FoucaultGetTypeEnums>  getTurnTurntable(){

        Map  map= new HashMap();
        map.put(GIVE_HEART_TASK.getTaskType(),GIVE_HEART_TASK);
        map.put(INTEGRAL_TASK.getTaskType(),INTEGRAL_TASK);
        map.put(WATCH_VIDEO.getTaskType(),WATCH_VIDEO);
        return map;

    }
}
