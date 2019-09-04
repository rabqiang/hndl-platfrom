package com.hndl.cn.mongodb.manager.extend.manager;

/**
 * @author 赵俊凯
 * @Description 第三方推广
 * @Date 2019/4/28 18:45
 * @Created by 湖南达联
 */
public interface OtherWechatUserInfoManager {


    /**
     * 判断是否存在
     * @param userUniId
     * @param channelName
     * @return
     */
    boolean isExist(Long userUniId,String channelName);


    /**
     * 保存数据
     * @param userUniId
     * @param channelName
     */
    void insertOtherWechatUserInfo(Long userUniId,String channelName,String ipAddress);
}
