package com.hndl.cn.base.enums.banner;

import com.hndl.cn.utils.string.StringUtils;

import java.util.Arrays;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 13:24
 * @Created by 湖南达联
 */
public enum  BannerEnums {

    APP_HOME("appHome","app首页Banner"),

    WECHAT_HOME("wechatHome","小程序首页Banner"),

    APP_START("appStart","app封面图"),

    SHOP_HOME("shopHome","商城Banner"),

    FLOAT_WINDOW("floatWindow","悬浮窗"),

    STAR_RANK("starRank","明星榜Banner"),

    STAR_FANS_RANK("starFansRank","新粉榜Banner"),

    SHOP_HOME_PAGE("home", "夺宝首页"),

    WECHAT_WINDOW("wechatWindow","小程序悬浮窗"),

    ;

    private String path;

    private String description;

    BannerEnums(String path, String description) {
        this.path = path;
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public String getDescription() {
        return description;
    }

    public static boolean checkPath(String path) {
        if (StringUtils.isNotBlank(path)) {
            for (BannerEnums c : BannerEnums.values()) {
                if (c.getPath().equals(path)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String[] description(){
        int size = BannerEnums.values().length;
        String[] arrays =  new String[size];

        int i = 0;
        for(BannerEnums c : BannerEnums.values()){
            arrays[i] = c.getDescription() + ":" + c.getPath();
            i ++;
        }

       return arrays;
    }

    public static BannerEnums eval(String path) {
        if (StringUtils.isBlank(path)) {
            return null;
        }
        return Arrays.stream(BannerEnums.values()).filter(input -> input.path.equals(path)).findFirst()
                .orElseGet(null);
    }
}
