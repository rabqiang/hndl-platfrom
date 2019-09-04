package com.hndl.cn.mongodb.manager.message.manager;


import com.hndl.cn.mongodb.manager.message.bean.TurntableMessageDo;

import java.util.List;

/**
 * @author 尹争鸣
 * @Description 转盘消息表 DAO
 * @Date 2019年7月5日17:41:20
 * @Created by 湖南达联
 */
public interface TurntableMessageManager {

    /**
     * 添加弹幕
     */
    void insertTurnTable(TurntableMessageDo turnTableMessageDo);

    /**
     * 根据是否实体奖励获取弹幕
     */
    List<TurntableMessageDo> findByEntityType(Integer isEntity, Integer limit);
}
