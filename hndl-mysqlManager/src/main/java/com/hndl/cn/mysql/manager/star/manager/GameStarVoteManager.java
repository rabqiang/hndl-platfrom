package com.hndl.cn.mysql.manager.star.manager;

/**
 * @program:hndl-platform
 * @description:TODO 粉丝会表
 * @author: 易成贤
 * @create: 2019/7/17 14:35
 * @Created by湖南达联
 **/
public interface GameStarVoteManager {
    /**
     * 获取一个新的粉丝会id
     * @return 粉丝id
     */
    Long getNewStarId();
}
