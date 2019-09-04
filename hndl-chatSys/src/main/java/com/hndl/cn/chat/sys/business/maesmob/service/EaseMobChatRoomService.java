package com.hndl.cn.chat.sys.business.maesmob.service;

import com.hndl.cn.chat.sys.business.maesmob.bean.EaesMobRequestRoomParam;

/**
 * @Classname 赵俊凯
 * @Description 聊天室service
 * @Date 2019/3/21 14:12
 * @Created by 湖南达联
 */
public interface EaseMobChatRoomService {

    /**
     * 创建聊天室 <br>
     * POST
     *
     * @param eaesMobRequestRoomParam
     *            <code>{name":"testchatroom","description":"server create chatroom","maxusers":300,"owner":"jma1","members":["jma2","jma3"]}</code>
     * @return
     */
    String createChatRoom(EaesMobRequestRoomParam eaesMobRequestRoomParam);




    /**
     * 获取一个聊天室详情 <br>
     * GET
     *
     * @param roomId
     *            聊天室标识
     * @return
     */
    Object getChatRoomDetail(String roomId);


    /**
     * 聊天室成员添加[单个] <br>
     * POST
     *
     * @param roomId
     *            聊天室标识
     * @param userName
     *            用户ID或用户名
     * @return
     */
    boolean addSingleUserToChatRoom(String roomId, String userName);
}
