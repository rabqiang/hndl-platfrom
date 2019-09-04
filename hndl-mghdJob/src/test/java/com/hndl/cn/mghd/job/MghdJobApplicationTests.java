package com.hndl.cn.mghd.job;

import com.hndl.cn.ali.jpush.service.JPushService;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.base.enums.vote.VoteTypeEnums;
import com.hndl.cn.mghd.job.business.rank.service.*;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageManager;
import com.hndl.cn.mongodb.manager.star.bean.StarFansDayStatisticsDo;
import com.hndl.cn.mongodb.manager.star.manager.StarDayRankManager;
import com.hndl.cn.mongodb.manager.star.manager.StarFansDayStatisticsManager;
import com.hndl.cn.mongodb.manager.task.bean.MasterDayReward;
import com.hndl.cn.mongodb.manager.task.bean.UserDayTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.MasterDayRewardManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.task.manager.UserNormalityTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MghdJobApplicationTests {

    @Resource
    private StarWeekRankJobService starWeekRankJobService;

    @Resource
    private StarMonthRankJobService starMonthRankJobService;

    @Resource
    private StarDayRankJobService starDayRankJobService;

    @Resource
    private RedisService redisService;

    @Resource
    private FansRewardService fansRewardService;

    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    @Resource
    private JPushService jPushService;



    @Resource
    private StarFansDayStatisticsManager starFansDayStatisticsManager;

    @Resource
    private StarDayRankManager starDayRankManager;



    @Test
    public void testDay(){
        starDayRankJobService.initNextStarFansGroupDayRank();
    }

    @Test
    public void contextLoads() {
        starDayRankJobService.refreshStarRankDayCache();
        System.out.println("==========周榜数据初始化成功==============");
    }

    @Test
    public void monthRankTest() {
        starWeekRankJobService.refreshStarRankWeekCache();
        starMonthRankJobService.refreshStarRankMonthCache();
        System.out.println("==========周榜数据初始化成功==============");
    }

    @Test
    public void redisTest(){
        redisService.set("test","12345");
    }


    @Resource
    private FansWeekRankJobService fansWeekRankJobService;

    @Test
    public void awardFansDayReward(){
        fansWeekRankJobService.refreshFansRankWeekCache();

      //  fansRewardService.awardFansDayReward();
    }


    @Test
    public void test(){
        List<StarFansDayStatisticsDo> byDate = starFansDayStatisticsManager.findByDate(LocalDate.now());
        byDate.stream().forEach(info -> {
            Integer coinCount = info.getCoinCount() == null ? 0 :info.getCoinCount() ;
            Integer count = info.getIntegralCount() == null ? 0 : info.getIntegralCount();
            starDayRankManager.increaseVote(VoteTypeEnums.INTEGRAL_VOTE,info.getStarId(),Long.valueOf(count));
            starDayRankManager.increaseVote(VoteTypeEnums.COIN_VOTE,info.getStarId(),Long.valueOf(coinCount));
            System.out.println(info);
        });
        ;
//        Map<Long, List<StarFansDayStatisticsDo>> map = byDate.stream().collect(
//                Collectors.groupingBy(StarFansDayStatisticsDo ::getStarId,Collectors.reducing(StarFansDayStatisticsDo::getVoteCount,Long ::sum)));
//
//        map.keySet().stream().forEach( key -> {
//            List<StarFansDayStatisticsDo> starFansDayStatisticsDos = map.get(key);
//            starFansDayStatisticsDos.stream().s
//        });


        System.out.println("完毕------->");

    }


    //获取用户徒弟的日常任务
    @Resource
    private UserDayTaskManager userDayTaskManager;
    //增加积分添加到积分日志表
    @Resource
    private UserIntegralLogManager userIntegralLogManager;
    //获取师父列表和徒弟id列表
    @Resource
    private MasterDayRewardManager masterDayRewardManager;

    //发送信息通知用户
    @Resource
    private UserMessageManager userMessageManager;

    //发送信息通知用户
    @Resource
    private UserNormalityTaskManager userNormalityTaskManager;

    @Test
    public void test111(){

        String id = null;

           LocalDate localDate = LocalDateUtil.addDay(-1L);

            List<MasterDayReward> byDate = null;/*masterDayRewardManager.findByDate(localDate, 10000, id);*/

        List<UserIntegralLogDo> recordByDate = userIntegralLogManager.findRecordByDate(LocalDateUtil.localDateToMilliSecond(LocalDate.now()),
                LocalDateUtil.localDateToMilliSecond(LocalDateUtil.nextDay()));



        //判断获取的值是为空,就停止
//            if (CollectionUtils.isEmpty(byDate)) {
//                break;
//            }
//            if (byDate.size() < MghdJobConstants.MENTOR_REWARD_LIMIT) {
//                flag = false;
//            }
            //拿到师父id
            Set<Long> masterSet = byDate.stream().filter(bean -> bean != null).map(bean -> bean.getMasterId()).collect(Collectors.toSet());

            Set<Long> recordId = recordByDate.stream().filter(bean -> bean != null).map(bean -> bean.getUserUniId()).collect(Collectors.toSet());

            masterSet.removeAll(recordId);

            System.out.println(masterSet.size());

            masterSet.stream().forEach(masterId -> {
                int sum = 0;//获取用户的所有徒弟的额外奖励
                //根据师父id拿到对应的徒弟列表
                List<MasterDayReward> daySlaveIdByMasterId = masterDayRewardManager.findDaySlaveIdByMasterId(localDate, masterId);
                //通过set集合去空,在通过java8特性去空对象
                Set<Long> slaveSet = daySlaveIdByMasterId.stream().filter(slave -> slave != null).map(slave -> slave.getSlaveId()).collect(Collectors.toSet());
                for (Long aLong : slaveSet) {
                    //获取用户经验值
                    Long empirical = userStatisticsDoManager.findUserStatisticsByUserUinId(aLong).getEmpirical();
//                    //获取徒弟在昨天日常任务完成的任务信息
                    List<UserDayTaskDo> toDayTaskByUserUniId = userDayTaskManager.findToYesterdayTaskByUserUniId(aLong);
                    int integral = 0;//给积分数默认值
                    for (UserDayTaskDo userDayTaskDo : toDayTaskByUserUniId) {
//                        //判断用户完成的积分类型,可获取多少积分
                        UserDayTaskEnums userDayTaskEnums = UserDayTaskEnums.evalVal(userDayTaskDo.getTaskType());
                        Long aLong1 = userIntegralLogManager.getUserIntegral(empirical, userDayTaskEnums.getIntegralCount());
                        integral += aLong1;//累计用户积分
                    }
                    integral = (int) (integral * 0.2); //计算用户可获得师徒额外的积分;
                    //用户每天最多只能获取徒弟的2000积分.
                    if (sum + integral > MghdJobConstants.MENTOR_REWARD_INTEGRAL) {
                        integral = MghdJobConstants.MENTOR_REWARD_INTEGRAL - sum;
                        sum = sum + integral;
                    } else {
                        sum += integral;
                    }
                    if (integral > 0) {
                        //增加用户统计表中的积分值和师徒额外奖励
                        userNormalityTaskManager.UserGetCumulativeReward(aLong.toString(), Long.valueOf(integral));//增加用户日常中是师徒额外奖励
                        userStatisticsDoManager.userStatisticsAddIntegralCount(masterId, Long.valueOf(integral), IsValidEnums.NO); //增加积分
                        //增加用户积分详情表中的数据
                        userIntegralLogManager.insertUserIntegralLog(masterId,"0", IsValidEnums.YES, UserNormalityTaskEnums.MENTOR_REWARD.getTaskType(), integral);
                        //用户增加完积分值,就要个通知用户
                        UserMessageDo userMessage = new UserMessageDo();
                        userMessage.setCreateUserId(IsValidEnums.NO.getValue().longValue());
                        userMessage.setCreateTime(new Date().getTime());//创建时间
                        userMessage.setMessageType(MessageTypeEnums.SYS_MSG.getType());
                        userMessage.setSendUserId(masterId);
                        userMessage.setTitle("恭喜，您的徒弟昨天给你带来" + integral + "积分奖励!");
                        userMessage.setContent("请去【我的】页面，师徒系统里查看徒弟给您带来额外奖励的具体情况。");
                        userMessage.setIsDelete(IsValidEnums.NO.getValue());
                        userMessageManager.insertUserMessageDo(userMessage);
                    }
                }
                userStatisticsDoManager.userStatisticsAddCumulativeReward(masterId, sum);//增加徒弟用户统计数中是师徒额外奖励

            });
            //用户已经完成操作就停止

        }


}
