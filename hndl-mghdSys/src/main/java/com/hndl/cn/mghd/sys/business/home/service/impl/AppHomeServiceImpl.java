package com.hndl.cn.mghd.sys.business.home.service.impl;

import com.hndl.cn.base.enums.banner.BannerEnums;
import com.hndl.cn.base.redis.rank.RedisStarRankKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.base.vo.StarDayRankVo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.banner.service.BannerService;
import com.hndl.cn.mghd.sys.business.banner.vo.BannerVo;
import com.hndl.cn.mghd.sys.business.call.service.StarFansCircleService;
import com.hndl.cn.mghd.sys.business.call.vo.StarCallContentVo;
import com.hndl.cn.mghd.sys.business.home.service.AppHomeService;
import com.hndl.cn.mghd.sys.business.home.vo.AppHomeVo;
import com.hndl.cn.mghd.sys.business.menu.service.AppHomeMenuService;
import com.hndl.cn.mghd.sys.business.menu.vo.AppHomeMenuVo;
import com.hndl.cn.mghd.sys.business.message.service.MessageService;
import com.hndl.cn.mghd.sys.business.message.vo.VoteMessageVo;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/16 11:19
 * @Created by 湖南达联
 */
@Service
public class AppHomeServiceImpl implements AppHomeService {

    private static final Logger log = LoggerFactory.getLogger(AppHomeServiceImpl.class);

    @Resource
    private BannerService bannerService;

    @Resource
    private MessageService messageService;

    @Resource
    private RedisPageService redisPageService;

    @Resource
    private StarFansCircleService starFansCircleService;

    @Resource
    private AppHomeMenuService appHomeMenuService;

    @Resource(name = "CallableExecutePool")
    private ThreadPoolTaskExecutor executor;

    @Override
    public Result<Object> initAppHomeData(String version,String source,CommonUserInfoDo commonUserInfoDo) {
        //菜单部分
        Future<List<AppHomeMenuVo>> menu = executor.submit(() ->
                appHomeMenuService.findAppHomeMenu(source, version));

        // 查询 app Banner
        Future<List<BannerVo>> banner = executor.submit(() ->
                bannerService.findBannerInfo(BannerEnums.APP_HOME));
        // 查询弹幕消息
        Future<List<VoteMessageVo>> message = executor.submit(() ->
                messageService.findByCreateTime(System.currentTimeMillis()));

        // 查询排行榜前八
        Future<List<StarDayRankVo>> starRank = executor.submit(() -> redisPageService.getKVList
                (RedisStarRankKey.getStarDayRankKey(LocalDate.now()), 1, 8));

        // 查询所有的粉丝会 爱豆说的数据
        Future<List<StarCallContentVo>> content = executor.submit(() ->
                starFansCircleService.findAppHomeStarFansCircle(commonUserInfoDo,1));

        //组合返回
        try {
            AppHomeVo appHomeVo = AppHomeVo.builder()
                    .menuVoList(menu.get())
                    .bannerVoList(banner.get())
                    .messageVoList(message.get())
                    .starDayRankVoList(starRank.get())
                    .homeContentVoList(content.get())
                    .build();
            return ResultFactory.success(appHomeVo);
        }catch (Exception e){
            log.error("首页查询异常:{}",e);
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_INIT_APP_HOME_EX.getCode());
        }

    }

    @Override
    public Result<List<StarCallContentVo>> findAppHomeStarFansCircle(CommonUserInfoDo commonUserInfoDo, Integer pageNo) {
        List<StarCallContentVo> appHomeStarFansCircle = starFansCircleService.findAppHomeStarFansCircle(commonUserInfoDo, pageNo);
        return ResultFactory.success(appHomeStarFansCircle);
    }
}
