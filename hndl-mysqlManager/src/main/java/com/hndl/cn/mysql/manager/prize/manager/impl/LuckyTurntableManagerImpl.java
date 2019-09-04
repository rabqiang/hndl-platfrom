package com.hndl.cn.mysql.manager.prize.manager.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDo;
import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDoExample;
import com.hndl.cn.dao.prize.mapper.LuckyTurntableInfoMapper;
import com.hndl.cn.mysql.manager.prize.manager.LuckyTurntableManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 奖品管理
 * @author: 易成贤
 * @create: 2019/7/5 18:15
 * @Created by湖南达联
 **/
@Service
public class LuckyTurntableManagerImpl implements LuckyTurntableManager {

    @Resource
    LuckyTurntableInfoMapper luckyTurntableInfoMapper;


    /**
     * 增加奖品信息
     *
     * @param luckyTurntableInfoDo
     * @return
     */
    @Override
    public Integer addLuckyTurntable(LuckyTurntableInfoDo luckyTurntableInfoDo) {
        return luckyTurntableInfoMapper.insertSelective(luckyTurntableInfoDo);
    }

    /**
     * 修改奖品信息
     *
     * @param luckyTurntableInfoDo
     * @return
     */
    @Override
    public Integer updateLuckyTurntable(LuckyTurntableInfoDo luckyTurntableInfoDo) {
        return luckyTurntableInfoMapper.updateByPrimaryKeySelective(luckyTurntableInfoDo);
    }

    /**
     * 根据奖品id删除奖品信息
     *
     * @param luckyTurntableInfoDo
     * @return
     */
    @Override
    public Integer deleteLuckyTurntableById(LuckyTurntableInfoDo luckyTurntableInfoDo) {
        return luckyTurntableInfoMapper.deleteByPrimaryKey(luckyTurntableInfoDo.getId());
    }

    /**
     * 查询所有奖品
     *
     * @return 奖品集合
     */
    @Override
    public List<LuckyTurntableInfoDo> findLuckyTurntable(IsValidEnums isDelete) {
        LuckyTurntableInfoDoExample luckyTurntableInfoDoExample = new LuckyTurntableInfoDoExample();
        if (null != isDelete){
            luckyTurntableInfoDoExample.createCriteria().andIsDeleteEqualTo(isDelete.getValue());
        }

        List<LuckyTurntableInfoDo> luckyTurntableInfoDos = luckyTurntableInfoMapper.selectByExample(luckyTurntableInfoDoExample);
        return CollectionUtils.isNotEmpty(luckyTurntableInfoDos) ? luckyTurntableInfoDos : new ArrayList<>(1);

    }

    @Override
    public LuckyTurntableInfoDo findLuckyTurntableById(Long id) {
        return  luckyTurntableInfoMapper.selectByPrimaryKey(id);
    }

}
