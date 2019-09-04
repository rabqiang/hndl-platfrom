package com.hndl.cn.ali.jpush.service;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/5 17:56
 * @Created by 湖南达联
 */
public interface JPushService {


    /**
     * 指定发送
     * @param userId
     */
    void noticeToOne(long userId,String msgContent);


    /**
     * 通知全平台
     * @param ALERT
     * @param toWhere
     */
    void noticeToAll(String ALERT,String toWhere);
}
