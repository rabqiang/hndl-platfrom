package com.hndl.cn.mghd.sys.business.star.service.impl;

import com.hndl.cn.dao.star.bean.StarActivityInfoDo;
import com.hndl.cn.mghd.sys.business.star.service.StarActivityInfoService;
import com.hndl.cn.mghd.sys.business.star.vo.StarActivityVo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mysql.manager.star.manager.StarActivityInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @description: 活动相关
 * @author: 尹争鸣
 * @create: 2019年6月5日19:38:34
 * @Created by 湖南达联
 **/
@Service
public class StarActivityInfoServiceImpl implements StarActivityInfoService {

    @Resource
    private StarActivityInfoManager starActivityInfoManager;

    @Resource
    private RedisService redisService;

    @Override
    public List<StarActivityVo> findActivity(String typeKey,Long pageNo) {

        //设置key
        String key = MgHdRedisKeyEnums.ACTIVITY_CACKE_KEY.getCacheKey(pageNo);
        List<StarActivityInfoDo> starActivityInfoDos= redisService.get(key);
        if (CollectionUtils.isNotEmpty(starActivityInfoDos)){
            return SpringCglibBeanUtils.convertByList(starActivityInfoDos,StarActivityVo.class);
        }

        List<StarActivityInfoDo> activity = starActivityInfoManager.findActivity(typeKey,pageNo, MghdSysConstants.FIFTY_PAGE_LIMIT);
        List<StarActivityVo>   starActivityVos=SpringCglibBeanUtils.convertByList(activity,StarActivityVo.class);
        return CollectionUtils.isEmpty(starActivityVos)?null:starActivityVos;
    }
}
