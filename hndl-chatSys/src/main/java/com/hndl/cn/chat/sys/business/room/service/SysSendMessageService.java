package com.hndl.cn.chat.sys.business.room.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.chat.sys.business.room.vo.EaseMobMessageVo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;

/**
 * @Classname 赵俊凯
 * @Description 发送消息
 * @Date 2019/3/22 20:07
 * @Created by 湖南达联
 */
public interface SysSendMessageService {


    /**
     * 发送消息
     * @param msg
     * @return
     */
    Result<Object> sendTxtMessage(Long sysUinId,String msg,String roomId);


    /**
     * 保存消息并添加任务
     * @param commonUserInfoDo
     * @param easeMobMessageVo
     * @return
     */
    Result<Object> reportMessageRewardTask(CommonUserInfoDo commonUserInfoDo, EaseMobMessageVo easeMobMessageVo);


    /**
     * 获取历史聊天记录
     * @param roomId
     * @return
     */
    Result<Object> findHistoryChatMessageByRoomId(String roomId);
}
