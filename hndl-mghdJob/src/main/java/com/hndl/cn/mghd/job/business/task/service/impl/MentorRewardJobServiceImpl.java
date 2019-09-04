package com.hndl.cn.mghd.job.business.task.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.mghd.job.business.task.service.MentorRewardJobService;
import com.hndl.cn.mghd.job.constants.MghdJobConstants;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageManager;
import com.hndl.cn.mongodb.manager.task.bean.MasterDayReward;
import com.hndl.cn.mongodb.manager.task.bean.UserDayTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.MasterDayRewardManager;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.task.manager.UserNormalityTaskManager;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/16 11:33
 * @Created by 湖南达联
 */
@Service
public class MentorRewardJobServiceImpl implements MentorRewardJobService {

    private static final Logger log = LoggerFactory.getLogger(MentorRewardJobServiceImpl.class);

    //获取用户徒弟的日常任务
    @Resource
    private UserDayTaskManager userDayTaskManager;
    //增加积分添加到积分日志表
    @Resource
    private UserIntegralLogManager userIntegralLogManager;
    //增加积分添加用户统计表
    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;
    //获取师父列表和徒弟id列表
    @Resource
    private MasterDayRewardManager masterDayRewardManager;

    //发送信息通知用户
    @Resource
    private UserMessageManager userMessageManager;

    //发送信息通知用户
    @Resource
    private UserNormalityTaskManager userNormalityTaskManager;


    @Override
    public void userGetMentorReward() {

        String id = null;

        boolean flag = true;

        LocalDate localDate = LocalDateUtil.addDay(-1L);

        List<Long> list = new ArrayList<>();

        while (flag) {
            //1.查询所有的师徒额外记录
            List<MasterDayReward> byDate = masterDayRewardManager.findByDate(localDate, id, MghdJobConstants.MENTOR_REWARD_LIMIT);
            //判断获取的值是为空,就停止
            if (CollectionUtils.isEmpty(byDate)) {
                break;
            }
            if (byDate.size() < MghdJobConstants.MENTOR_REWARD_LIMIT) {
                flag = false;
            }

//            log.info("当前师傅" + (byDate.size() -1));

            //获取id
            id = byDate.get(byDate.size() -1).getId();

            //拿到师父id
            Set<Long> masterSet = byDate.stream().filter(bean -> bean != null).map(bean -> bean.getMasterId()).collect(Collectors.toSet());
            //循环师父id
//            Set<Long> masterSet = Sets.newHashSet(229667836187037696L);
            masterSet.parallelStream().forEach(masterId -> {

                if(!list.contains(masterId)){
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
                        if (sum >= MghdJobConstants.MENTOR_REWARD_INTEGRAL) {
                            break;
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
                            try {
                                //增加用户统计表中的积分值和师徒额外奖励
                                userNormalityTaskManager.UserGetCumulativeReward(aLong.toString(), Long.valueOf(integral));//增加用户日常中是师徒额外奖励
                                userStatisticsDoManager.userStatisticsAddIntegralCount(masterId, Long.valueOf(integral), IsValidEnums.NO); //增加积分
                                //增加用户积分详情表中的数据
                                userIntegralLogManager.insertUserIntegralLog(masterId, "0", IsValidEnums.YES, UserNormalityTaskEnums.MENTOR_REWARD.getTaskType(), integral);
                                //用户增加完积分值,就要个通知用户
                                UserMessageDo userMessage = new UserMessageDo();
                                userMessage.setCreateUserId(IsValidEnums.NO.getValue().longValue());
                                userMessage.setCreateTime(System.currentTimeMillis());//创建时间
                                userMessage.setMessageType(MessageTypeEnums.SYS_MSG.getType());
                                userMessage.setSendUserId(masterId);
                                userMessage.setTitle("恭喜，您的徒弟昨天给你带来" + integral + "积分奖励!");
                                userMessage.setContent("请去【我的】页面，师徒系统里查看徒弟给您带来额外奖励的具体情况。");
                                userMessage.setIsDelete(IsValidEnums.NO.getValue());
                                userMessageManager.insertUserMessageDo(userMessage);
                            } catch (Exception e) {
                                log.error("没有添加进去的积分数:" + integral + ",师父id:" + masterId + "  ___,徒弟id:+" + aLong);
                            }
                        }
                    }
                    userStatisticsDoManager.userStatisticsAddCumulativeReward(masterId, sum);//增加徒弟用户统计数中是师徒额外奖励

                }

            });
            try {
                Thread.sleep(20000L);
            } catch (InterruptedException e) {

            }
            list.addAll(masterSet);
        }
        log.info("======================当前所有用户的师徒奖励积分已经全部添加了=====================");
    }
}
