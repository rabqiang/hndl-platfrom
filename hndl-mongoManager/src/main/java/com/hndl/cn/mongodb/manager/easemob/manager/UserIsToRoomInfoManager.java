package com.hndl.cn.mongodb.manager.easemob.manager;

import com.hndl.cn.mongodb.manager.easemob.bean.UserIsToRoomInfoDo;

/**
 * @Classname 赵俊凯
 * @Description 用户是否加入聊天室
 * @Date 2019/3/22 19:23
 * @Created by 湖南达联
 */
public interface UserIsToRoomInfoManager {

    /**
     *  添加映射关系
     * @param userIsToRoomInfoDo
     */
    void insertUserIsToRoomMapping(UserIsToRoomInfoDo userIsToRoomInfoDo);


    /**
     * 用户是否加入聊天室
     * @param sysUniUserId
     * @param roomId
     * @return
     */
    boolean userIsToRoom(Long sysUniUserId,String roomId);
}
