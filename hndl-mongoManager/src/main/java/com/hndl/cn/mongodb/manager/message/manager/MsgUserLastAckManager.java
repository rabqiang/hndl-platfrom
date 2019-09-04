package com.hndl.cn.mongodb.manager.message.manager;

import com.hndl.cn.mongodb.manager.message.bean.MsgUserLastAckDo;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date
 * @Created by 湖南达联
 */

public interface MsgUserLastAckManager {

    /**
     * 查询已读消息节点
     */
    MsgUserLastAckDo findMsgUserLastAck(Long sysUniId, Integer messageType);


    /**
     * 新增或修改 已读消息节点
     */
    void upsertMegUserLastAck(MsgUserLastAckDo msgUserLastAckDo);

    /**
     * 判断当前游标是否存在
     */
    long countByHaveReadMessageId(Long haveReadMessageId);
}
