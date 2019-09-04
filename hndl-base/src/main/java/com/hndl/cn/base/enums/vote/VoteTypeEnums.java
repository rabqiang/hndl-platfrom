package com.hndl.cn.base.enums.vote;

/**
 * @author 赵俊凯
 * @Description 投票的两种方式
 * @Date 2019/4/25 11:17
 * @Created by 湖南达联
 */
public enum VoteTypeEnums {

    INTEGRAL_VOTE("积分打榜"),

    COIN_VOTE("快乐币打榜(也就是比心打榜)"),

    LOVE_VOTE("爱心打榜"),

    ;

    private String description;


    VoteTypeEnums(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static Long convertVote(VoteTypeEnums voteTypeEnums, Long count){
        switch (voteTypeEnums){
            case COIN_VOTE:
                return count* 100;
            case LOVE_VOTE:
                return count;
            case INTEGRAL_VOTE:
                return count ;
                default:
                    throw new NullPointerException("Undefined enumeration types");
        }
    }
}
