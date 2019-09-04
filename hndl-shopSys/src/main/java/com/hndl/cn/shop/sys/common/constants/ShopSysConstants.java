package com.hndl.cn.shop.sys.common.constants;

/**
 * @program:hndl-platform
 * @description:TODO 商品
 * @author: 易成贤
 * @create: 2019/7/15 16:57
 * @Created by湖南达联
 **/
public interface ShopSysConstants {


    /**
     * 中奖人名称长度限制
     * */
    Integer  NIKE_NAME_LENGTH=8;


    /**
     * 实体奖品消息Type
     * */
    Integer  TURNTABLE_MESSAGE_ENTITY=1;


    /**
     * 虚拟奖品消息Type
     * */
    Integer  TURNTABLE_MESSAGE_VIRTUAL=0;


    /**
     *  获取虚拟and实物Type
     * */
    Integer  TURNTABLE_MESSAGE_ALL=2;



    /**
     * 转盘弹幕消息LIMIT
     * */
    Integer TURNTABLE_MESSAGE_LIMIT=50;
    /**
     * 抽奖锁时间
     */
    long PRIZE_SYS_USER_LOCK_TIME = 1500L;
}
