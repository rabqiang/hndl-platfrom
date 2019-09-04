package com.hndl.cn.mongodb.manager.easemob.manager;

import com.hndl.cn.mongodb.manager.easemob.bean.EaseMobFansGroupChatRoomDo;

/**
 * @Classname 赵俊凯
 * @Description 粉丝会聊天室Manager
 * @Date 2019/3/22 14:13
 * @Created by 湖南达联
 */
public interface EaseMobFansGroupChatRoomManager {


    /**
     *  添加聊天室信息
     * @param easeMobFansGroupChatRoomDo
     */
    void insertFansGroupChatRoom(EaseMobFansGroupChatRoomDo easeMobFansGroupChatRoomDo);


    /**
     *  根据 fans group id 获取聊天室信息
     * @param fansGroupId
     * @return
     */
    EaseMobFansGroupChatRoomDo findGroupChatRoomByFansGroupId(Long fansGroupId);

    /**
     *  根据 fans group id 获取聊天室信息
     * @param roomId
     * @return
     */
    EaseMobFansGroupChatRoomDo findGroupChatRoomByRoomId(String roomId);

}
