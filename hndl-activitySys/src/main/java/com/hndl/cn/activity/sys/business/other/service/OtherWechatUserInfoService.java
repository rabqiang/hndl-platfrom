package com.hndl.cn.activity.sys.business.other.service;

/**
 * @author 赵俊凯
 * @Description 第三方推广
 * @Date 2019/4/28 18:55
 * @Created by 湖南达联
 */
public interface OtherWechatUserInfoService {


    /**
     * 插入推广数据
     * @param userUniId
     * @param channelName
     * @param ipAddress
     */
    void insertOtherWechatUserInfo(Long userUniId,String channelName,String ipAddress);
}
