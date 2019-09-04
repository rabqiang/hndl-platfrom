package com.hndl.cn.chat.sys.business.room.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

/**
 * @Classname 赵俊凯
 * @Description 欢信聊天室的service
 * @Date 2019/3/22 9:30
 * @Created by 湖南达联
 */
public interface SysChatRoomService {


    /**
     * 添加聊天室并加入聊天室
     * @param commonUserInfoDo
     * @param fansGroupId
     * @return 聊天室id
     */
    Result<Object> addFansGroupChatRoomOrUserToRoom(CommonUserInfoDo commonUserInfoDo, Long fansGroupId);
}
