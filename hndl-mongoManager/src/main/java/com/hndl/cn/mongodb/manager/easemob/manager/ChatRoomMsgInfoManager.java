package com.hndl.cn.mongodb.manager.easemob.manager;

import com.hndl.cn.mongodb.manager.easemob.bean.ChatRoomMsgInfoDo;

import java.util.List;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/4/3 10:51
 * @Created by 湖南达联
 */
public interface ChatRoomMsgInfoManager {


    /**
     * 获取聊天室历史聊天记录
     * @return
     */
    List<ChatRoomMsgInfoDo>  findChatRoomMsgInfoDoByRoomId(String roomId,Integer limit);


    /**
     * 保存聊天记录
     * @param chatRoomMsgInfoDo
     */
    void insertChatRoomMsgInfoDo(ChatRoomMsgInfoDo chatRoomMsgInfoDo);
}
