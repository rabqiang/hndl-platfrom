package com.hndl.cn.chat.sys.business.maesmob.service;

/**
 * @Classname 赵俊凯
 * @Description 环信发送消息
 * @Date 2019/3/21 15:59
 * @Created by 湖南达联
 */
public interface EaseMobSendMessageService {


     /**
      *
      * @param targetType 消息类型
      * @param roomId 聊天室id
      * @param fromNickName 用户名
      * @return
      */
     void sendTxtMessageByRoomId(String targetType,String roomId,String fromNickName,String msg);
}
