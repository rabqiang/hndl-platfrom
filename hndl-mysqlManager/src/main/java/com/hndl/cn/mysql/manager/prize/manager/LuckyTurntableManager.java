package com.hndl.cn.mysql.manager.prize.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDo;

import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 奖品管理
 * @author: 易成贤
 * @create: 2019/7/5 18:14
 * @Created by湖南达联
 **/
public interface LuckyTurntableManager {

    /**
     * 增加奖品
     * @param luckyTurntableInfoDo
     */
    Integer addLuckyTurntable(LuckyTurntableInfoDo luckyTurntableInfoDo);

    /**
     * 修改奖品设置
     * @param luckyTurntableInfoDo
     */
    Integer updateLuckyTurntable(LuckyTurntableInfoDo luckyTurntableInfoDo);


    /**
     * 根据奖品id删除奖品信息
     * @param luckyTurntableInfoDo
     * @return
     */
    Integer deleteLuckyTurntableById(LuckyTurntableInfoDo luckyTurntableInfoDo);

    /**
     * 查询所有大转盘奖品
     * @return 奖品集合
     */
    List<LuckyTurntableInfoDo> findLuckyTurntable(IsValidEnums isExist);



    /**
     *根据id查询奖品
     * @return
     */
    LuckyTurntableInfoDo findLuckyTurntableById(Long id);

}
