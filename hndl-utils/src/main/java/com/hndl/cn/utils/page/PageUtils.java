package com.hndl.cn.utils.page;

/**
 * @author 赵俊凯
 * @Description 分页工具类
 * @Date 2019/5/6 21:09
 * @Created by 湖南达联
 */
public class PageUtils {


    public static boolean checkMongoDbObjId(String id){
        if (id == null) {
            throw new IllegalArgumentException();
        }

        int len = id.length();
        if (len != 24) {
            return false;
        }

        for (int i = 0; i < len; i++) {
            char c = id.charAt(i);
            if (c >= '0' && c <= '9') {
                continue;
            }
            if (c >= 'a' && c <= 'f') {
                continue;
            }
            if (c >= 'A' && c <= 'F') {
                continue;
            }

            return false;
        }

        return true;
    }


}
