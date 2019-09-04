package com.hndl.cn.base.enums.vote;

/**
 * @program:hndl-platform
 * @description:TODO 打榜内容枚举
 * @author: 易成贤
 * @create: 2019/8/27 17:44
 * @Created by湖南达联
 **/
public enum  VoteContentEnums {
    INTEGRAL_VOTE(1,"积分打榜","每比心+200票，+200贡献并有机会获得福利"),

    COIN_VOTE(2,"比心打榜)","每票消耗1积分，+1贡献并有机会获得福利"),

    ;

    private Integer type;
    private  String title;
    private String content;

    VoteContentEnums(Integer type, String title, String content) {
        this.type = type;
        this.title = title;
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    public static VoteContentEnums evalVal(Integer value) {
        for (VoteContentEnums enums : VoteContentEnums.values()) {
            if (enums.getType().equals(value)) {
                return enums;
            }
        }
        return null;
    }
}
