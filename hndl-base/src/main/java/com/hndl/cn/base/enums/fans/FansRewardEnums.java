package com.hndl.cn.base.enums.fans;


/**
 * @author 赵俊凯
 * @Description 粉丝奖励
 * @Date 2019年5月20日10:22:38
 * @Created by 湖南达联
 */
public enum FansRewardEnums {

    FANS_REWARD(31,"星粉榜奖励")



    ;

    private  Integer rewardType;

    private String description;

    FansRewardEnums(Integer rewardType, String description) {
        this.rewardType = rewardType;
        this.description = description;
    }

    public Integer getRewardType() {
        return rewardType;
    }

    public String getDescription() {
        return description;
    }
}
