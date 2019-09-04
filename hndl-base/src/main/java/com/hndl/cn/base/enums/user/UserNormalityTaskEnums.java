package com.hndl.cn.base.enums.user;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description 用户常态任务枚举
 * @Date 2019/4/18 15:45
 * @Created by 湖南达联
 */
public enum UserNormalityTaskEnums {

    //1 拜师
    OBEY_MASTER(21,500,1,"https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/apprentice.png","拜师任务"),

    //2 收徒
    OBEY_SLAVE(22,50,100,"https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/recruit.png","收徒任务"),

    //3 关注公众号 500
    FOLLOW_PUBLIC_NUM(23,500,1,null,"关注公众号"),

    //4 绑定手机号 暂定
    BIND_PHONE(24,100,1,"https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/taskList/binding.png","绑定手机号"),

    //师徒额外奖励
    MENTOR_REWARD(25,0,Integer.MAX_VALUE,null,"师徒额外奖励"),
    /**
     * 推广任务 大话诛仙
     */
    //GENERALIZE_ZHUXIAN(26,100,1,"https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/img/icon_mission_dhzx.png","经典封神RPG手游，上线送VIP6!")

    GENERALIZE_ZHUXIAN(27,100,1,"https://klfshcdn.oss-cn-hangzhou.aliyuncs.com/wechatMiniProgram/img/icon_mission_yhqs.png","你没玩过的全新放置RPG,不信你试试！！")
    ;

    private Integer taskType;//任务类型

    private Integer integralCount;//获得积分

    private Integer taskCount;//任务总数

    private String taskImg;//任务图片

    private String description;//描述


    UserNormalityTaskEnums(Integer taskType, Integer integralCount, Integer taskCount, String taskImg, String description) {
        this.taskType = taskType;
        this.integralCount = integralCount;
        this.taskCount = taskCount;
        this.taskImg = taskImg;
        this.description = description;
    }

    public String getTaskImg() {
        return taskImg;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public Integer getIntegralCount() {
        return integralCount;
    }

    public String getDescription() {
        return description;
    }

    public Integer getTaskCount() {
        return taskCount;
    }

    public void setIntegralCount(Integer integralCount) {
        this.integralCount = integralCount;
    }

    public static Map<Integer,UserNormalityTaskEnums> getWeChat() {
        Map<Integer, UserNormalityTaskEnums> map = new HashMap();
        map.put(UserNormalityTaskEnums.OBEY_MASTER.getTaskType(), UserNormalityTaskEnums.OBEY_MASTER);
        map.put(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType(), UserNormalityTaskEnums.OBEY_SLAVE);
        //map.put(UserNormalityTaskEnums.FOLLOW_PUBLIC_NUM.getTaskType(), UserNormalityTaskEnums.FOLLOW_PUBLIC_NUM);
        map.put(UserNormalityTaskEnums.BIND_PHONE.getTaskType(),UserNormalityTaskEnums.BIND_PHONE);
        return map;
    }

    public static Map<Integer,UserNormalityTaskEnums> getApp(){
        Map<Integer, UserNormalityTaskEnums> map = new HashMap();
        map.put(UserNormalityTaskEnums.OBEY_MASTER.getTaskType(), UserNormalityTaskEnums.OBEY_MASTER);
        map.put(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType(), UserNormalityTaskEnums.OBEY_SLAVE);
        map.put(UserNormalityTaskEnums.BIND_PHONE.getTaskType(), UserNormalityTaskEnums.BIND_PHONE);
        return map;
    }

    /**
     * 查询推广任务
     * @return
     */
    public static Map<Integer,UserNormalityTaskEnums> getGeneralize(){
        Map<Integer, UserNormalityTaskEnums> map = new HashMap();
        map.put(UserNormalityTaskEnums.GENERALIZE_ZHUXIAN.getTaskType(),UserNormalityTaskEnums.GENERALIZE_ZHUXIAN);
        return map;
    }

    //是app的任务吗
    public  static  boolean isApp(Integer type){
        // include：包含
        boolean include = false;
        for (UserNormalityTaskEnums enums : getApp().values()) {
            include = enums.getTaskType().equals(type);
            if(include) break;
        }
        return include;
    }
    //是wechat的任务吗
    public  static  boolean isWeChat(Integer type){
        // include：包含
        boolean include = false;
        for (UserNormalityTaskEnums enums :getWeChat().values()) {
            include = enums.getTaskType().equals(type);
            if(include) break;
        }
        return include;
    }

    public static boolean checkVal(Integer taskType) {
        if (taskType != null) {
            for (UserNormalityTaskEnums c : UserNormalityTaskEnums.values()) {
                if (c.getTaskType().equals(taskType)) {
                    return true;
                }
            }
        }
        return false;
    }
    public static UserNormalityTaskEnums evalVal(Integer taskType) {
        for (UserNormalityTaskEnums enums : UserNormalityTaskEnums.values()) {
            if (enums.getTaskType().equals(taskType)) {
                return enums;
            }
        }
        return null;
    }
}
