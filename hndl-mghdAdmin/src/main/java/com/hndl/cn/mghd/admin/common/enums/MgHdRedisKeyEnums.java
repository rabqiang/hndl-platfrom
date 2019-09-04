package com.hndl.cn.mghd.admin.common.enums;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 17:19
 * @Created by 湖南达联
 */
public enum MgHdRedisKeyEnums {

    APP_HOME_CACHE_KEY("home","app_home_cache_key",600L,"app home key"),

    APP_HOME_MENU_KEY("app_home_menu","APP_HOME_MENU_KEY",1800L,"user call key"),
    WECHAT_HOME_CACHE_KEY("home","wechat_home_cache_key",600L,"wechat home key"),

    WECHAT_HOME_MENU_KEY("wechat_home_menu","WECHAT_HOME_MENU_KEY",1800L,"user call key"),
    BANNER_CACHE_KEY("banner","BANNER_SEARCH_KEY", 600L, "banner key"),

    MENU_CACHE_KEY("menu","MENU_SEARCH_KEY",1800L,"menu key"),
    //用于查询星粉圈
    CALL_CACHE_KEY("call","CALL_SEARCH_KEY",60L,"call key"),
    //存储粉丝会详细信息
    STAR_CACHE_KEY("star","STAR_SEARCH_KEY",40L,"star key"),
    //爱豆说
    STAR_SAID_CACHE_KEY("call","STAR_SAID_CACHE_KEY",60L,"starSaid key"),
    //用户打call
    USER_CALL_CACHE_KEY("call","USER_CALL_SEARCH_KEY",60L,"user call key"),
    //弹幕
    VOTE_MESSAGE_CACHE_KEY("vote","VOTE_CACHE_KEY",20L,"vote key"),
    //关注动态
    FOLLOW_CACHE_KEY("follow","FOLLOW_CACHE_KEY",300L,"follow key"),
    FOLLOW_USER_CACKE_KEY("follow","FOLLOW_USER_CACHE_KEY",30L,"follow user key"),
    FOLLOW_CALL_CACKE_KEY("follow","FOLLOW_CALL_CACHE_KEY",30L,"follow call key"),

    //活动
    ACTIVITY_CACKE_KEY("activity","ACTIVITY_CACKE_KEY",18000L,"activity key"),

    //搜索列表key
    SEARCH_FANSGROUP_CACHE_KEY("search","SEARCH_FANSGROUP_CACHE_KEY",600L,"search_fansgroup_key"),
    //查看守护时候的缓存4个小时
    GROUPMAN_CACHE_KEY("group","GROUPMAN_CACHE_KEY",18000L,"groupman_cache_key"),

    //徒弟列表
    APPRENTICE_LIST_KEY("apprentice","APPRENTICE_LIST_KEY",100L,"apprentice key")
    ;

    private String packageName;

    private String prefix;

    private Long expireTime;

    private String description;

    MgHdRedisKeyEnums(String packageName, String prefix, Long expireTime, String description) {
        this.packageName = packageName;
        this.prefix = prefix;
        this.expireTime = expireTime;
        this.description = description;
    }

    public String getPrefix() {
        return prefix;
    }

    public Long getExpireTime() {
        return expireTime;
    }

    public String getDescription() {
        return description;
    }

    private static final String SPLITTER = "_";

    /**
     * 获取对应的cacheKey
     *
     * @param args
     * @return
     */
    public String getCacheKey(Object... args) {
        StringBuilder keyBuilder = new StringBuilder(this.packageName).append(":").append(this.prefix);
        if (args != null && args.length > 0) {
            keyBuilder.append(SPLITTER);
            String joinedStr = Arrays.stream(args).map(arg -> arg == null ? "null" : arg.toString())
                    .collect(Collectors.joining(SPLITTER));
            keyBuilder.append(joinedStr);
        }
        return keyBuilder.toString();
    }
}
