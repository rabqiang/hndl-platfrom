package com.hndl.cn.shop.sys.business.turntable.service;

import com.hndl.cn.shop.sys.business.turntable.vo.TurntableMessageVo;

import java.util.List;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年7月9日19:01:43
 * @Created by 湖南达联
 */

public interface TurntableMessageService {


    /**
     * 添加弹幕
     * */
    void  saveTurntableMessage(String nikeName,String prizeName,Integer isEntity);

    /**
     * 根据是否实体奖品获取弹幕
     */
    List<TurntableMessageVo> findTurntableMessageByEntity(Integer isEntity);
}
