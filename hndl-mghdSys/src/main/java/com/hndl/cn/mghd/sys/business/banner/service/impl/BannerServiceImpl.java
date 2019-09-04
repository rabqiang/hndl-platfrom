package com.hndl.cn.mghd.sys.business.banner.service.impl;

import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonAdInfoDo;
import com.hndl.cn.mghd.sys.business.banner.service.BannerService;
import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mysql.manager.banner.manager.BannerManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/4/29 17:05
 * @Created by 湖南达联
 */
@Service
public class BannerServiceImpl implements BannerService {

    private static final Logger log = LoggerFactory.getLogger(BannerServiceImpl.class);

    @Resource
    private BannerManager bannerManager;

    @Resource
    private RedisService redisService;


    @Override
    public List<BannerVo> findBannerInfo(BannerEnums bannerEnums) {


        String key = MgHdRedisKeyEnums.BANNER_CACHE_KEY.getCacheKey(bannerEnums.getPath());

        List<CommonAdInfoDo> list = redisService.get(key);

        if(CollectionUtils.isEmpty(list)){
            list = bannerManager.findBannerByModel(bannerEnums);
            redisService.set(key,list,MgHdRedisKeyEnums.BANNER_CACHE_KEY.getExpireTime());
        }

        return SpringCglibBeanUtils.convertByList(list,BannerVo.class);
    }

    @Override
    public Result<Object> findBannerInfoByBannerEnums(BannerEnums bannerEnums) {

        List<BannerVo> bannerInfo = this.findBannerInfo(bannerEnums);

        if(CollectionUtils.isEmpty(bannerInfo)){
            return ResultFactory.success();
        }

        return ResultFactory.success(bannerInfo);
    }
}
