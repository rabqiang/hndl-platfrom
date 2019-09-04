package com.hndl.cn.base.enums.user;

/**
 * @author 曹加丽
 * @Description 完成任务获取经验值枚举
 * @Date 2019/5/9 10:12
 * @Created by 湖南达联
 */
public enum UserDayEmpiricalTypeEnums {
    //比心(不限次)
    GIVE_HEART_TASK(1, Integer.MAX_VALUE, 100, "比心"),

    // 积分打榜(经验值是1=1票,不限次)
    INTEGRAL_TASK(2, Integer.MAX_VALUE, 100, "积分打榜"),

    //守护
    GUARD_TASK(3, 2, 20, "守护"),

    // 召唤
    SUMMON_TASK(4, 2, 20, "召唤"),

    //5 粉丝会发言 3 聊天室
    ROOM_TASK(5, 3, 20, "粉丝会发言"),

    // 每日任务之首次登陆  1
    LOGIN_TASK(6, 1, 10, "每日登录"),

    //7 打cell任务 2
    CALL_TASK(7, 2, 20, "打call奖励"),

    //每日评论(每日首次评论获取积分,后评论不加)
    COMMENT_TASK(8, 1, 10, "评论"),

    //每日点赞(每日首次点赞获得积分,后点赞不加)
    LIKE_TASK(9, 1, 10, "点赞"),

    //每日公益(无限次)
    LOVE_TASK(10, Integer.MAX_VALUE, 10, "每日公益"),

    //APP充值
    PAY_TASK(11, Integer.MAX_VALUE, 100, "APP充值"),

    // 拜师  200
    OBEY_MASTER(21, 1, 50, "拜师"),

    // 收徒  100
    OBEY_SLAVE(22, 100, 50, "收徒"),

    //完善个人信息
    PERFECT_USER(24, 2, 5, "绑定手机号"),

    //师徒额外奖励
    MENTOR_REWARD(25, 0, 0, "徒弟昨日额外"),

    FANS_REWARD(31,0,0,"星粉榜"),

    SYSTEM_ADDITION(40,0,0,"系统操作"),
    /**
     * 诛仙推广任务
     */
    GENERALIZE_ZHUXIAN(UserNormalityTaskEnums.GENERALIZE_ZHUXIAN.getTaskType(),1,100,"推广任务"),

    /**
     * 抽奖奖励
     */
    LUCKYTURNTABLE(101,0,0,"抽奖")

    ;
    /**
     * 任务类型(与其他任务类型保存一致)
     */
    private Integer taskType;

    /**
     * 完成任务次数
     */
    private Integer dayCount;

    /**
     * 可获取的经验值
     */
    private Integer empirical;

    /**
     * 任务描述
     */
    private String description;

    UserDayEmpiricalTypeEnums(Integer taskType, Integer dayCount, Integer empirical, String description) {
        this.taskType = taskType;
        this.dayCount = dayCount;
        this.empirical = empirical;
        this.description = description;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getDayCount() {
        return dayCount;
    }

    public void setDayCount(Integer dayCount) {
        this.dayCount = dayCount;
    }

    public Integer getEmpirical() {
        return empirical;
    }

    public void setEmpirical(Integer empirical) {
        this.empirical = empirical;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



    public static UserDayEmpiricalTypeEnums evalVal(Integer value) {
        for (UserDayEmpiricalTypeEnums type : UserDayEmpiricalTypeEnums.values()) {
            if (type.getTaskType().equals(value)) {
                return type;
            }
        }
        return null;
    }


}
