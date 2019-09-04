package com.hndl.cn.shop.sys.business.turntable.service.impl;

import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mongodb.manager.message.bean.TurntableMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.TurntableMessageManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.shop.sys.business.turntable.service.TurntableMessageService;
import com.hndl.cn.shop.sys.business.turntable.vo.TurntableMessageVo;
import com.hndl.cn.shop.sys.common.constants.ShopSysConstants;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.string.StringUtils;
import com.hndl.cn.utils.string.TurntableMessageUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 尹争鸣
 * @Description TODO
 * @Date 2019年7月9日19:05:44
 * @Created by 湖南达联
 */
@Service
@Slf4j
public class TurntableMessageServiceImpl implements TurntableMessageService {

    @Resource
    private TurntableMessageManager turnTableMessageManager;

    @Resource
    private RedisService redisService;

    @Override
    public void saveTurntableMessage(String nikeName, String prizeName, Integer isEntity) {
        TurntableMessageDo turntableMessageDo = new TurntableMessageDo();

        turntableMessageDo.setIsEntity(isEntity);
        turntableMessageDo.setMsgContent(TurntableMessageUtils.getTurntablePrizeMsg(StringUtils.subContent(nikeName, ShopSysConstants.NIKE_NAME_LENGTH), prizeName));

        turnTableMessageManager.insertTurnTable(turntableMessageDo);

    }

    @Override
    public List<TurntableMessageVo> findTurntableMessageByEntity(Integer isEntity) {

        //获取缓存
        String key = MgHdRedisKeyEnums.TURNTABLE_MESSAGE_CACHE_KEY.getCacheKey(isEntity);
        List<TurntableMessageDo> turnTableMessageDoList = redisService.get(key);
        //判断缓存是否存在
        if (CollectionUtils.isEmpty(turnTableMessageDoList)) {
            //判断是否获取所有类别弹幕
            if (null==isEntity){
                turnTableMessageDoList=(turnTableMessageManager.findByEntityType(ShopSysConstants.TURNTABLE_MESSAGE_VIRTUAL, ShopSysConstants.TURNTABLE_MESSAGE_LIMIT)) ;
                turnTableMessageDoList.addAll(turnTableMessageManager.findByEntityType(ShopSysConstants.TURNTABLE_MESSAGE_ENTITY, ShopSysConstants.TURNTABLE_MESSAGE_LIMIT));
            }else {
                turnTableMessageDoList = turnTableMessageManager.findByEntityType(isEntity, ShopSysConstants.TURNTABLE_MESSAGE_LIMIT);
            }
            redisService.set(key, turnTableMessageDoList, MgHdRedisKeyEnums.TURNTABLE_MESSAGE_CACHE_KEY.getExpireTime());
        }
        return CollectionUtils.isEmpty(turnTableMessageDoList) ? new ArrayList<>() :
                SpringCglibBeanUtils.convertByList(turnTableMessageDoList, TurntableMessageVo.class);
    }


}
