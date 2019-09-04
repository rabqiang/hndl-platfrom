package com.hndl.cn.mghd.sys.business.wechat.service.impl;

import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.base.redis.rank.RedisFansRankKey;
import com.hndl.cn.base.redis.rank.RedisStarRankKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.mghd.sys.business.banner.service.BannerService;
import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;
import com.hndl.cn.mghd.sys.business.wechat.Vo.WechatHomeVo;
import com.hndl.cn.mghd.sys.business.wechat.service.WechatHomeService;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mongodb.manager.star.bean.StarDayRankDo;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;

/**
 * @author 曹加丽
 * @Description 用户登陆小程序, 返回小程序首页信息
 * @Date 2019/5/23 9:51
 * @Created by 湖南达联
 */
@Service
public class WechatHomeServiceImpl implements WechatHomeService {

    //查询每天的轮播图的 service层
    @Resource
    private BannerService bannerService;

    @Resource
    private RedisPageService redisPageService;

    /**
     * 查询每天的轮播图 ,查询每天日榜的前50条数据
     *
     * @return
     */
    @Override
    public Result<Object> initfindWechatGeHome() {
        //查询小程序首页的轮播图
        List<BannerVo> bannerInfo = bannerService.findBannerInfo(BannerEnums.WECHAT_HOME);
        //从redis缓存中取查询每天日榜前50条数据
        List<StarDayRankDo> list = this.gethome();
        WechatHomeVo wechatHomeVo = new WechatHomeVo();
        wechatHomeVo.setBannerVoList(bannerInfo);//将查询的banner放入vo类中
        wechatHomeVo.setStarDayRankVoList(list); //将查询明星日榜的数据

        return ResultFactory.success(wechatHomeVo);
    }

    public List<StarDayRankDo> gethome() {
        return redisPageService.getKVList
                (RedisStarRankKey.getStarDayRankKey(LocalDate.now()), MghdSysConstants.INIT_PAGE_NO, MghdSysConstants.INIT_STAR_PAGE_LIMIT);
    }

}
