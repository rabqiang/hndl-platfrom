package com.hndl.cn.mghd.admin;

import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.dao.admin.bean.AdminUserInfoDo;
import com.hndl.cn.mghd.admin.business.resources.service.ResourcesService;
import com.hndl.cn.mghd.admin.business.shop.service.ShopAppDataService;
import com.hndl.cn.mghd.admin.business.star.service.StarActiveDataService;
import com.hndl.cn.mghd.admin.business.star.service.StarFansGroupService;
import com.hndl.cn.mghd.admin.business.star.vo.ReceiveStarFansGroupVo;
import com.hndl.cn.mghd.admin.business.welfaremall.vo.WelfarePrizeVo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.date.LocalDateTimeUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/14 18 16
 * @Description:
 * @Author: 资龙茂
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class MyTest {
    @Resource
    private StarActiveDataService starActiveDataService;

    @Resource
    private ShopAppDataService shopAppDataService;

    @Resource
    private UserIntegralLogManager userIntegralLogManager;

    @Resource
    private UserDayTaskManager userDayTaskManager;

    @Resource
    private StarFansGroupService starFansGroupService;

    @Resource
    private HelpWelfareManager helpWelfareManager;

    @Resource
    private ResourcesService resourcesService;

    @Resource
    private RedisService redisService;

    /**
     * 查询已开奖时间不超过三天的奖品
     */
    @Test
    public void findIsSuccess() {
        String key = MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getCacheKey(NumberEnums.ZERO.getEnglish());
        List<WelfarePrizeVo> welfarePrizeVoList = redisService.get(key);
        if (CollectionUtils.isEmpty(welfarePrizeVoList)) {
            welfarePrizeVoList = SpringCglibBeanUtils.convertByList(helpWelfareManager.findSuccessWelfarePrize(null, null, System.currentTimeMillis() - 259200000L), WelfarePrizeVo.class);
            welfarePrizeVoList = setWorkProgressByList(welfarePrizeVoList);
            redisService.set(key, welfarePrizeVoList, MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getExpireTime());
        }
    }

    /**
     * 新增福利奖品
     */
    @Test
    public void getCommodity() {
        HelpWelfareDo helpWelfareDo = new HelpWelfareDo();
        //设置奖品期号
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");//获取当前的年月日
        // 1.获取当日增加了多少商品再加1
        String format = String.format("%02d", helpWelfareManager.countAddCommodity() + 1);
        helpWelfareDo.setWelfareNumber(sdf.format(new Date()) + format); //设置奖品期号
        helpWelfareDo.setPrizeName("快乐大本营门票");                                 //奖品名称
        helpWelfareDo.setStartTime(LocalDateTimeUtil.getNowMinTimeMilli());                                 //抽奖开始时间
        helpWelfareDo.setEndTime(LocalDateTimeUtil.getNowMaxTimeMilli());                                   //抽奖结束时间
        helpWelfareDo.setEndTime(1565960903000L);
        helpWelfareDo.setFoucaultCount(1);                              //消耗福卡数
        helpWelfareDo.setHelpCount(100);                                  //开奖助力阈值
        helpWelfareDo.setPrizeCount(1);                                 //奖品数量
        helpWelfareDo.setPrizeImg(resourcesService.registerHelpWelfareImg("http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-08-05/276591869566332928.jpg"));//奖品封面图
        List<String> prizeImg = new ArrayList<>();
        prizeImg.add(resourcesService.registerHelpWelfareImg("http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-08-05/276591869566332928.jpg"));
        helpWelfareDo.setDetailsPrizeImg(prizeImg);                     //奖品详情图
        helpWelfareDo.setDescription("你帮我，我帮你，大家一起抢福利~~");                               //奖品描述
        helpWelfareDo.setSortCount(0);                                  //前多少名才可以获得奖励
        helpWelfareManager.insertHelpWelfare(helpWelfareDo);
        //刷新 redis 缓存
        String key = MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getCacheKey(NumberEnums.ONE.getEnglish());
        //刷新 十条正在开抢的福利商品
        List<WelfarePrizeVo> welfarePrizeVoList = SpringCglibBeanUtils.convertByList(helpWelfareManager.findIsValidWelfarePrize(null), WelfarePrizeVo.class);
        redisService.set(key, welfarePrizeVoList, MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getExpireTime());
        System.out.println("---------------- 新增福利奖品 " + helpWelfareDo.getPrizeName() + " 成功 ----------------");
    }

    @Test
    public void findCurrentShopAppData() {

        System.out.println(shopAppDataService.findCurrentShopAppData());
        //System.out.println(shopAppDataService.findShopAppDataByDate(0, 10, null, null));
    }

    @Test
    public void getStarActiveDataTest() {
        System.out.println(starActiveDataService.findStarActiveInfoByName("孟美岐",
                1564070400000L,
                1564131600000L));
//        System.out.println(System.currentTimeMillis());
    }

    @Test
    public void nothing() {

        for (int i = 1; i < 31; i++) {
            String now = "2019-07-";
            now += i;
            String starName = "高天鹤";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            SimpleDateFormat sDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); //加上时间
            //必须捕获异常
            try {
                Date date = simpleDateFormat.parse(now);
                Long startDate = DateUtil.beginOfDate(date).getTime();
                Long endDate = DateUtil.endOfDate(date).getTime();

                System.out.println(now + "  " + starActiveDataService.findStarActiveInfoByName(starName, startDate, endDate));
            } catch(ParseException px) {
                px.printStackTrace();
            }
        }
    }

    @Test
    public void testGaotianhe() {
        System.out.println(starActiveDataService.findStarActiveInfoByName("赵毅新", 1563722800000L, 1563811200000L));
    }

    @Test
    public void nothing2 () {
        System.out.println(userIntegralLogManager.findIntegralCountByStarId(1563724800000L, 1563811200000L, "09887"));
    }
    // 1563724800000L
    @Test
    public void nothing3 () {
        System.out.println(userDayTaskManager.countTaskUserByDate(1563811000000L, 1563811200000L, UserDayTaskEnums.CALL_TASK, 1 ,null));
    }

    @Test
    public void test(){
        String starImg = "http://mghd.oss-cn-hangzhou.aliyuncs.com/temp/min_img/2019-07-26/273020805993136128.jpg";
        AdminUserInfoDo vo = new AdminUserInfoDo();
        vo.setEmail("1234567@qq.com");
        vo.setNickName("产品经理");
        vo.setLoginName("root");
        vo.setMobile("17798988888");
        vo.setId(1L);
        ReceiveStarFansGroupVo build = ReceiveStarFansGroupVo.builder()
                .starName("徐艺洋")
                .starImg(starImg)
                .voteCount(0L)
                .voteUserCount(0)
                .starDescription("要酷一点！")
                .starType("歌手")
                .sex("F")
                .fansName("卫衣")
                .weiboId("2687678670")
                .build();
        starFansGroupService.insertStarFansGroup(vo,build);
        // ReceiveStarFansGroupVo.builder();
        //starFansGroupService.upsertStarFansGroup(vo,)
    }

    /**
     * 计算集合中的福利奖品开奖进度
     * @param welfarePrizeVoList
     * @return
     */
    public List<WelfarePrizeVo> setWorkProgressByList(List<WelfarePrizeVo> welfarePrizeVoList) {
        welfarePrizeVoList.stream().forEach(welfarePrizeVo ->
                welfarePrizeVo.setWorkProgress(String.format("%.2f", (double)welfarePrizeVo.getNowSumCount() / welfarePrizeVo.getHelpCount() * 100))
        );
        return welfarePrizeVoList;
    }

}
