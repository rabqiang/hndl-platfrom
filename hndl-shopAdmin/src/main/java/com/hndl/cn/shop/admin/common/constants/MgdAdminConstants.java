package com.hndl.cn.shop.admin.common.constants;

/**
 * @author 赵俊凯
 * @Description 后台常量类
 * @Date 2019/6/18 17:20
 * @Created by 湖南达联
 */
public interface MgdAdminConstants {



    String LOGIN_USER_SESSION_KEY = "login_user_session_key";//shiro session key

    String AUTHORIZATIONINFO = "authorizationinfo";

    String LOGIN_HEAD_KEY = "login_head_key";

    String LOGIN_PRIVATE_KEY = "hndl_private_key";

    String INIT_CHAT_MESSAGE_REDIS_NAME = "init_chat_message";

    Long INIT_CHAT_MESSAGE_REDIS_TIME_OUT = 3000L;

    Long   MEUN_ROOT = 0L;//根菜单

    Integer PAGE_LIMIT=50;

    Integer ZERO=0;
}
