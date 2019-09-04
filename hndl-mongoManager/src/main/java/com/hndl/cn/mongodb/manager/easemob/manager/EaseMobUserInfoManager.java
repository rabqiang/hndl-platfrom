package com.hndl.cn.mongodb.manager.easemob.manager;

import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobUserInfoDo;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/3/21 11:20
 * @Created by 湖南达联
 */
public interface EaseMobUserInfoManager {


    /**
     * 添加环信用户信息
     * @param easeMobUserInfoDo
     */
    void insertEaseMobUserInfo(EaseMobUserInfoDo easeMobUserInfoDo);


    /**
     * 根据用户uni id 获取用户信息
     * @param sysUniUserId
     * @return
     */
    EaseMobUserInfoDo findEaseMobUserInfoBySysUniId(Long sysUniUserId);

}
