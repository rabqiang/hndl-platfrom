package com.hndl.cn.mghd.sys.business.task.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.message.MessageTypeEnums;
import com.hndl.cn.base.enums.user.UserNormalityTaskEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.lock.RedisLockKey;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.common.mapper.CommonUserInfoDoMapper;
import com.hndl.cn.mghd.sys.business.task.service.UserNormalityTaskService;
import com.hndl.cn.mghd.sys.business.task.vo.MasterUserVo;
import com.hndl.cn.mghd.sys.business.task.vo.SlaveUserVo;
import com.hndl.cn.mghd.sys.business.task.vo.UserMasterApprenticeVo;
import com.hndl.cn.mghd.sys.business.task.vo.UserTaskVo;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.message.bean.UserMessageDo;
import com.hndl.cn.mongodb.manager.message.manager.UserMessageManager;
import com.hndl.cn.mongodb.manager.task.bean.UserNormalityTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.UserNormalityTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.nosql.redis.page.RedisPageService;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.collection.MapUtils;
import com.hndl.cn.utils.number.LevelUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import com.hndl.cn.utils.text.InvitationUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/6 10:06
 * @Created by 湖南达联
 */
@Service
public class UserNormalityTaskServiceImpl implements UserNormalityTaskService {
    //打印日志
    private static final Logger log = LoggerFactory.getLogger(UserNormalityTaskServiceImpl.class);

    //用户常态 dao层
    @Resource
    private UserNormalityTaskManager userNormalityTaskManager;

    //用户统计dao层
    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    //用户基础数据 dao层
    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    //用户积分日志dao层
    @Resource
    private UserIntegralLogManager userIntegralLogManager;

    @Resource
    private CommonUserInfoDoMapper commonUserInfoDoMapper;

    //生成信息
    @Resource
    private UserMessageManager userMessageManager;

    @Resource
    private RedisService redisService;

    @Resource
    private RedisPageService redisPageService;

    /**
     * 查询常态任务的进度
     * 查询用户完成了多少条常态任务，有多少的任务没有领取
     */
    @Override
    public Map<Integer, UserTaskVo> findUserNormalityTask(Long userUinId) {
        //用户存储对象用户列表
        Map<Integer, UserTaskVo> userTaskMap = new ConcurrentHashMap<>();

        //分组查询用户列表
        Map<Integer, List<UserNormalityTaskDo>> map = userNormalityTaskManager.findByUserUniId(userUinId)
                .stream().collect(Collectors.groupingBy(UserNormalityTaskDo::getTaskType));
        //任务列表为空
        if (MapUtils.isEmpty(map)) {
            return setNoTask(userTaskMap);
        }
        map.forEach((k, val) -> {
            //判断是app还是wechat并且写入对应描述，数据错误，描述则为null
            UserNormalityTaskEnums userNormalityTaskEnums;
            userNormalityTaskEnums = UserNormalityTaskEnums.getWeChat().get(k);

            if (userNormalityTaskEnums == null) {
                userNormalityTaskEnums = UserNormalityTaskEnums.getApp().get(k);
            }

            if (null == userNormalityTaskEnums) {
                userNormalityTaskEnums = UserNormalityTaskEnums.getGeneralize().get(k);
            }

            if (null != userNormalityTaskEnums) {
                UserTaskVo vo = new UserTaskVo();
                vo.setCountTask(userNormalityTaskEnums.getTaskCount());
                vo.setTaskDescription(userNormalityTaskEnums.getDescription()); //任务描述
                vo.setTaskImg(userNormalityTaskEnums.getTaskImg()); //图片
                vo.setTaskIntegral(userNormalityTaskEnums.getIntegralCount());//积分数
                //还有多少奖励没有领取
                Long aLong = val.stream().filter(userNormalityTaskDo -> userNormalityTaskDo.getIsDelete().equals(IsValidEnums.NO.getValue())).collect(Collectors.counting());
                vo.setTaskType(k);//任务类型
                vo.setFinished(val.size() > userNormalityTaskEnums.getTaskCount() ? userNormalityTaskEnums.getTaskCount() : val.size());//完成多少条
                vo.setNoGetted(aLong.intValue());
                userTaskMap.put(k, vo);
            }
        });
        //设置没有的做过任务的数据
        return setNoTask(userTaskMap);

    }

    //设置没有做过任务的数据
    private Map<Integer, UserTaskVo> setNoTask(Map<Integer, UserTaskVo> map) {
        for (UserNormalityTaskEnums enums : UserNormalityTaskEnums.values()) {
            if (map.get(enums.getTaskType()) == null) {
                UserTaskVo vo = new UserTaskVo();
                vo.setTaskType(enums.getTaskType());//任务类型
                vo.setFinished(MghdSysConstants.ZERO);//完成多少条
                vo.setNoGetted(MghdSysConstants.ZERO);
                vo.setCountTask(enums.getTaskCount());
                vo.setTaskDescription(enums.getDescription()); //描述
                vo.setTaskImg(enums.getTaskImg());              //图片
                vo.setTaskIntegral(enums.getIntegralCount());   //积分数
                map.put(enums.getTaskType(), vo);
            }
        }
        return map;
    }

    /**
     * 查询app任务列表
     *
     * @param userUinId
     * @return
     */
    @Override
    public Map<Integer, UserTaskVo> findAppUserNormalityTask(Long userUinId) {
        //过滤不是app的任务列表
        Map<Integer, UserTaskVo> userTaskVos = new HashMap<>();
        Map<Integer, UserTaskVo> map = this.findUserNormalityTask(userUinId);
        for (UserNormalityTaskEnums enums : UserNormalityTaskEnums.getApp().values()) {
            UserTaskVo userTaskVo = map.get(enums.getTaskType());
            if (userTaskVo == null) {
                continue;
            } else {
                userTaskVos.put(userTaskVo.getTaskType(), userTaskVo);
            }
        }
        return userTaskVos;
    }


    /**
     * 查询wechat任务列表
     *
     * @param userUinId
     * @return
     */
    @Override
    public List<UserTaskVo> findWeChatUserNormalityTask(Long userUinId) {
        //过滤不是wechat的任务列表
        List<UserTaskVo> userTaskVos = new ArrayList<>();
        Map<Integer, UserTaskVo> map = this.findUserNormalityTask(userUinId);
        for (UserNormalityTaskEnums enums : UserNormalityTaskEnums.getWeChat().values()) {
            if (map.get(enums.getTaskType()) == null) {
                continue;
            } else {
                userTaskVos.add(map.get(enums.getTaskType()));
            }
        }
        return userTaskVos;
    }

    /**
     * 查询任务列表中的显示信息
     *
     * @param
     * @param userNormalityTaskEnums
     * @return
     */
    @Override
    public Result<UserTaskVo> findOneUserNormalityTask(Long userUinId, UserNormalityTaskEnums userNormalityTaskEnums) {
        List<UserNormalityTaskDo> task = userNormalityTaskManager.findTaskByUserUniIdAndTaskTypes(userUinId, userNormalityTaskEnums);
        UserTaskVo taskVo = new UserTaskVo();
        taskVo.setTaskType(userNormalityTaskEnums.getTaskType());//任务类型

        //查不到任务
        taskVo.setNoGetted(MghdSysConstants.ZERO);
        taskVo.setFinished(MghdSysConstants.ZERO);
        if (task != null) {
            taskVo.setFinished(task.size());//任务记录条数
            //计算可领取数据
            Long collect = task.stream().filter(userNormalityTaskDo -> IsValidEnums.NO.getValue().equals(userNormalityTaskDo.getIsDelete())).collect(Collectors.counting());
            taskVo.setNoGetted(collect.intValue());
        }
        //任务总数
        taskVo.setCountTask(userNormalityTaskEnums.getTaskCount());
        //任务描述
        taskVo.setTaskDescription(userNormalityTaskEnums.getDescription());
        taskVo.setTaskIntegral(userNormalityTaskEnums.getIntegralCount());
        //判断是否是收徒任务
        if (userNormalityTaskEnums.getTaskType().equals(UserNormalityTaskEnums.OBEY_SLAVE.getTaskType())) {
            //查询用户徒弟数
            Long size = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(userUinId, userNormalityTaskEnums, IsValidEnums.YES);
            //获取用户可添加的积分数
            int count = LevelUtil.getContributionLevelFraction(size.intValue());
            taskVo.setTaskIntegral(count);//将积分数设置进去
            taskVo.setGetIntegral(Long.valueOf(count));

        } else {
            taskVo.setGetIntegral(userNormalityTaskEnums.getIntegralCount().longValue());
        }
        return ResultFactory.success(taskVo);
    }


    /**
     * 用户拜师
     * 1.先查询用户是否已经拜过师
     * 2.查询用户等级是否已经大于等于三级,没有就提示
     *
     * @param commonUserInfoDo 用户id
     * @param lastId           师父id
     * @return
     */
    @Override
    @SubmitLock(keys = "commonUserInfoDo#sysUniId", sysMarkEnum = ExceptionSysMarkEnum.MGHD_SYS)
    public Result<Object> insertUserNormalityTaskAddMaster(CommonUserInfoDo commonUserInfoDo, Long lastId) {

        //判断用户是否已经完成拜师任务还领取过奖励
        Long getMaster = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(commonUserInfoDo.getSysUniId(), UserNormalityTaskEnums.OBEY_MASTER, null);
        //如果已经有师傅
        if (getMaster > 0) {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_MASTER_NOT_NULL.getCode());
        }
        //查询用户经验值
        UserStatisticsDo userUinId = userStatisticsDoManager.findUserStatisticsByUserUinId(commonUserInfoDo.getSysUniId());
        //判断用户等级是否大于等于三级
        if (LevelUtil.getContributionLevel(userUinId.getEmpirical().intValue()) >= 3) {
            //判断师傅id是不是自己
            if (commonUserInfoDo.getId().equals(lastId)) {
                log.error("========================用户:" + commonUserInfoDo.getSysUniId() + "不能拜自己为师===================");
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_MASTER_NOT_IS_ME.getCode());
            }

            CommonUserInfoDo master = commonUserInfoDoMapper.selectByPrimaryKey(lastId);
            if (master == null) {
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_LAST_ID_NOT_NULL.getCode());
            }
            //查询所有的徒弟
            List<UserNormalityTaskDo> slave = userNormalityTaskManager.getSlave(commonUserInfoDo.getSysUniId());
            for (int i = 0; i < slave.size(); i++) {
                if (slave.get(i).getObjId().equals(master.getSysUniId().toString())) {
                    log.error("========================用户:" + commonUserInfoDo.getSysUniId() + "不能拜徒弟为师===================");
                    throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_MASTER_ID_NOT_ME.getCode());
                }
            }
            //判断师父是否收过该徒弟
            if (userNormalityTaskManager.findUserIsSlave(master.getSysUniId(), String.valueOf(commonUserInfoDo.getSysUniId()))) {
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_MASTER_NOT_IS_ME.getCode());
            }

            //添加拜师记录
            //查询师父收徒是否已经超过一百个,如果没有就直接将信息添加进去,如果有就将任务设置已领取状态
            userNormalityTaskManager.insert(commonUserInfoDo.getSysUniId(), String.valueOf(master.getSysUniId()), UserNormalityTaskEnums.OBEY_MASTER, IsValidEnums.NO.getValue());

            Long slaveCount = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(master.getSysUniId(), UserNormalityTaskEnums.OBEY_SLAVE, null);
            if (slaveCount < 100) {
                //添加用户收徒记录
                userNormalityTaskManager.insert(master.getSysUniId(), String.valueOf(commonUserInfoDo.getSysUniId()), UserNormalityTaskEnums.OBEY_SLAVE, IsValidEnums.NO.getValue());
            } else {
                userNormalityTaskManager.insert(master.getSysUniId(), String.valueOf(commonUserInfoDo.getSysUniId()), UserNormalityTaskEnums.OBEY_SLAVE, IsValidEnums.YES.getValue());
            }

            CommonUserInfoDo commonUserInfo = new CommonUserInfoDo();
            commonUserInfo.setSysUniId(commonUserInfoDo.getSysUniId());
            commonUserInfo.setLastUserId(lastId.toString());
            commonUserInfoManager.updateUserInfo(commonUserInfo);
            //添加用户统计表中的徒弟数和发送信息通知用户
            insertApprentice(commonUserInfoDo, master.getSysUniId());

            //用户拜师成功,返回师父信息
            return ResultFactory.success(SpringCglibBeanUtils.convert(master, MasterUserVo.class));
        } else {
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_MASTER_LEVEL_GREATER_THREE.getCode());
        }
    }


    /**
     * 关注公众号
     *
     * @return
     */
    @Override
    public Result<Object> insertUserNormalityTaskAddPublic(Long userUniId, String objId) {
        //判断用户是否已经关注过公众号
        Long getPublic = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(userUniId, UserNormalityTaskEnums.FOLLOW_PUBLIC_NUM, null);
        if (getPublic != 0) {
            //用户已经完成公众号常态任务
            throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_USER_PUBLIC_ADDRESS_NOT_NULL.getCode());
        }
        //将公众号保存数据库(目前没有公众号这个表或这个字段 暂时不做操作)


        //增加 用户常态任务 -- 关注公众号  完成记录
        userNormalityTaskManager.insert(userUniId, objId, UserNormalityTaskEnums.FOLLOW_PUBLIC_NUM, IsValidEnums.NO.getValue());
        //用户完成关注公众号常态任务成功
        return ResultFactory.success(objId);
    }


    /**
     * 用户领取积分奖励
     */
    @Override
    public Result<UserTaskVo> insertTaskAddIntegralCount(Long userUniId, UserNormalityTaskEnums userNormalityTaskEnums) {
        String lockKey = RedisLockKey.builderRedisKey(BaseConstants.USER_TASK_GET_NOR_INTEGRAL_LOCK_KEY, userUniId);
        try {
            boolean isLock = redisService.setNX(lockKey, RedisLockKey.DEFAULT_VALUE, MghdSysConstants.TASK_SYS_GET_INTEGRAL_LOCK_TIME);

            if (!isLock) {
                log.info(
                        "================== lockKey : "
                                + lockKey
                                + ",isLock : "
                                + isLock
                                + "===================");
                throw new MghdSysException(PublicExceptionCodeEnum.EX_EXCESSIVE_ATTEMPTS.getCode());
            }

            Long noTask = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(userUniId, userNormalityTaskEnums, IsValidEnums.NO);

            if (noTask < 1) {
                log.info("用户:" + userUniId + "没有可领取的常态任务" + userNormalityTaskEnums.getTaskType() + "用户可以领取的任务次数：" + noTask);
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_GET_FAILURE_EXCEPTION.getCode());
            }

            switch (userNormalityTaskEnums) {
                case OBEY_SLAVE:
                    //如果是收徒就不需要积分翻倍处理
                    //1、判断如果完成了常态任务完成
                    Long yesTask = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(userUniId, userNormalityTaskEnums, IsValidEnums.YES);

                    Long sumTask = noTask + yesTask;

                    Long count;

                    if (sumTask < userNormalityTaskEnums.getTaskCount()) {
                        count = yesTask + 1;
                    } else {
                        count = Long.valueOf(userNormalityTaskEnums.getTaskCount()) - noTask;
                    }
                    //用户领取完奖励就要修改任务状态
                    if (userNormalityTaskManager.updateIsDelete(userUniId, userNormalityTaskEnums)) {
                        Integer levelFraction = LevelUtil.getContributionLevelFraction(count.intValue());//收徒应得积分
                        //在将获取的积分数保存到用户统计表中
                        userStatisticsDoManager.userStatisticsAddIntegralCount(userUniId, levelFraction.longValue(), IsValidEnums.NO);
                        //增加积分日志
                        userIntegralLogManager.insertUserIntegralLog(userUniId, "0", IsValidEnums.YES, userNormalityTaskEnums.getTaskType(), levelFraction);
                    }
                    break;
                case OBEY_MASTER:
                    //用户领取完奖励就要修改任务状态
                    boolean flag = userNormalityTaskManager.updateIsDelete(userUniId, userNormalityTaskEnums);
                    if (flag) {
                        //将积分添加到的用户统计表
                        userStatisticsDoManager.userStatisticsAddIntegralCount(userUniId, userNormalityTaskEnums.getIntegralCount().longValue(), IsValidEnums.NO);
                        //增加积分日志,目前没有积分日志操作
                        userIntegralLogManager.insertUserIntegralLog(userUniId, "0", IsValidEnums.YES, userNormalityTaskEnums.getTaskType(), userNormalityTaskEnums.getIntegralCount());
                    }
                    break;
                case BIND_PHONE:
                    //用户领取完奖励就要修改任务状态
                    userNormalityTaskManager.updateIsDelete(userUniId, userNormalityTaskEnums);
                    //将积分添加到的用户统计表
                    userStatisticsDoManager.userStatisticsAddIntegralCount(userUniId, userNormalityTaskEnums.getIntegralCount().longValue(), IsValidEnums.NO);
                    //增加积分日志,目前没有积分日志操作
                    userIntegralLogManager.insertUserIntegralLog(userUniId, "0", IsValidEnums.YES, userNormalityTaskEnums.getTaskType(), userNormalityTaskEnums.getIntegralCount());
                    break;
                //诛仙推广任务
                case GENERALIZE_ZHUXIAN:
                    //用户领取完奖励就要修改任务状态
                    if (userNormalityTaskManager.updateIsDelete(userUniId, userNormalityTaskEnums)) {
                        //在将获取的积分数保存到用户统计表中
                        userStatisticsDoManager.userStatisticsAddIntegralCount(userUniId, userNormalityTaskEnums.getIntegralCount().longValue(), IsValidEnums.NO);
                        //增加积分日志
                        userIntegralLogManager.insertUserIntegralLog(userUniId, "0", IsValidEnums.YES, userNormalityTaskEnums.getTaskType(), userNormalityTaskEnums.getIntegralCount());
                    }
                    break;
                default:
                    break;
            }
            return findOneUserNormalityTask(userUniId, userNormalityTaskEnums);

        } finally {
            redisService.delNX(lockKey);
        }
    }


    /**
     * 查询用户徒弟信息
     *
     * @param commonUserInfoDo
     * @return
     */
    @Override
    public Result<Object> findMasterApprentice(CommonUserInfoDo commonUserInfoDo, Integer pageNo) {
        //设置key
        String key = MgHdRedisKeyEnums.APPRENTICE_LIST_KEY.getCacheKey(commonUserInfoDo.getSysUniId());
        //获取缓存中徒弟列表的信息
        List<UserNormalityTaskDo> userNormalityTaskDoList = redisPageService.getKVList(key, pageNo, BaseConstants.DEFAULT_LIMIT);
        //判断缓存中没有数据,就重新查询
        if (userNormalityTaskDoList == null) {
            userNormalityTaskDoList = userNormalityTaskManager.findSlaves(commonUserInfoDo.getSysUniId(), UserNormalityTaskEnums.OBEY_SLAVE);
        }
        //将查询的徒弟信息再次放入缓存
        userNormalityTaskDoList = this.getUser(commonUserInfoDo.getSysUniId(), UserNormalityTaskEnums.OBEY_SLAVE);
        List<UserNormalityTaskDo> slaveList = new ArrayList<>();
        if (pageNo != 0) {
            Integer size = (pageNo - 1) * BaseConstants.DEFAULT_LIMIT;
            slaveList = userNormalityTaskDoList.stream().skip(size).limit(BaseConstants.DEFAULT_LIMIT).collect(Collectors.toList());
        } else {
            slaveList = userNormalityTaskDoList;
        }
        // 查询用户统计中的师徒奖励的积分
        UserStatisticsDo userUinId = userStatisticsDoManager.findUserStatisticsByUserUinId(commonUserInfoDo.getSysUniId());
        UserMasterApprenticeVo userMasterApprenticeVo = new UserMasterApprenticeVo();
        userMasterApprenticeVo.setNickName(commonUserInfoDo.getNickName());                                                 //用户昵称
        userMasterApprenticeVo.setImgUrl(commonUserInfoDo.getPersonImgUrlMin());                                            //用户头像
        userMasterApprenticeVo.setLevel(LevelUtil.getContributionLevel(userUinId.getEmpirical().intValue()));               //用户等级
        userMasterApprenticeVo.setRequstCode(InvitationUtils.getInvitationCode(commonUserInfoDo.getId().intValue()));       //邀请码
        userMasterApprenticeVo.setApprenticeCount(userNormalityTaskManager.getSlave(commonUserInfoDo.getSysUniId()).size());//徒弟数
        userMasterApprenticeVo.setIntegralSum(userUinId.getCumulativeReward());                                             //累计徒弟贡献
        //判断用户是否完成拜师任务,如果完成将师父的信息放入vo类返回前台
        UserNormalityTaskDo taskMaster = userNormalityTaskManager.findOne(commonUserInfoDo.getSysUniId(), UserNormalityTaskEnums.OBEY_MASTER);
        if (!ObjectUtils.isEmpty(taskMaster)) {
            //根据师父id查询师父信息
            CommonUserInfoDo master = commonUserInfoManager.findUserByUniId(Long.parseLong(taskMaster.getObjId()));
            userMasterApprenticeVo.setMasterId(master.getSysUniId()); //师父id
            userMasterApprenticeVo.setMasterImgUrl(master.getPersonImgUrlMin());//师父头像
            userMasterApprenticeVo.setMasterNickName(master.getNickName());//师父昵称
        }
        List<SlaveUserVo> slaveUserVos = new ArrayList<>();

        for (UserNormalityTaskDo userNormalityTaskDo : slaveList) {
            //查询徒弟基本信息
            CommonUserInfoDo userInfoDo = commonUserInfoManager.findUserByUniId(Long.parseLong(userNormalityTaskDo.getObjId()));
            SlaveUserVo slaveVo = new SlaveUserVo();
            slaveVo.setUserUniId(userInfoDo.getSysUniId());//徒弟id
            slaveVo.setCreateDate(userNormalityTaskDo.getCreateTime());//徒弟拜师时间
            slaveVo.setNickName(userInfoDo.getNickName());//徒弟昵称
            slaveVo.setSlaveImgUrl(userInfoDo.getPersonImgUrlMin());//徒弟头像
            slaveVo.setIntegralCount(userNormalityTaskDo.getCumulativeReward());//每日师徒系统提供师父额外奖励
            slaveUserVos.add(slaveVo);
        }
        userMasterApprenticeVo.setUserInfoDoList(slaveUserVos);//徒弟列表
        return ResultFactory.success(userMasterApprenticeVo);
    }

    /**
     * 查询推广任务
     *
     * @param commonUserInfoDo
     * @return
     */
    @Override
    public Result findGeneralizeTask(CommonUserInfoDo commonUserInfoDo) {
        List<UserTaskVo> userTaskVos = new ArrayList<>();
        for (UserNormalityTaskEnums value : UserNormalityTaskEnums.getGeneralize().values()) {
            UserTaskVo build = UserTaskVo.builder()
                    .taskImg(value.getTaskImg())
                    .taskType(value.getTaskType())
                    .finished(0)
                    .noGetted(0)
                    .countTask(value.getTaskCount())
                    .taskIntegral(value.getIntegralCount())
                    .taskDescription(value.getDescription())
                    .build();
            //设置已完成条数
            Long finished = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(commonUserInfoDo.getSysUniId(), value, null);
            build.setFinished(finished.intValue());
            //未领取条数
            Long noGetted = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(commonUserInfoDo.getSysUniId(), value, IsValidEnums.NO);
            build.setNoGetted(noGetted.intValue());
            if (value.equals(UserNormalityTaskEnums.GENERALIZE_ZHUXIAN)) {
                build.setAppid("wx4e31c81548b48574");
                build.setPath("pages/index/index?channel=honghao&scene=cxhd:472Q154010-471Q154010");
            }
            userTaskVos.add(build);
        }
        return ResultFactory.success(userTaskVos);
    }

    /**
     * 回调接口
     *
     * @param commonUserInfoDo
     * @param taskType
     * @return
     */
    @Override
    public Result reportGeneralizeTask(CommonUserInfoDo commonUserInfoDo, Integer taskType) {
        UserNormalityTaskEnums userNormalityTaskEnums = UserNormalityTaskEnums.getGeneralize().get(taskType);
        if (null == userNormalityTaskEnums) {
            throw new MghdSysException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        Long task = userNormalityTaskManager.findToNormalityTaskByUserUniIdAndObjId(commonUserInfoDo.getSysUniId(), userNormalityTaskEnums, null);

        long value = userNormalityTaskEnums.getTaskCount().longValue();
        if (value > task) {
            userNormalityTaskManager.insert(commonUserInfoDo.getSysUniId(), "0", userNormalityTaskEnums, IsValidEnums.NO.getValue());
        }

        return ResultFactory.success();
    }

    /**
     * 只增加徒弟操作加信息提示
     *
     * @param userByUniId
     * @param objId
     */
    @Override
    public void insertApprentice(CommonUserInfoDo userByUniId, Long objId) {
        //增加用户统计表中徒弟数和徒弟在粉丝会的贡献值
        UserStatisticsDo userStatisticsDo = new UserStatisticsDo();
        userStatisticsDo.setUserUniId(userByUniId.getSysUniId());
        userStatisticsDo.setSlaveCount(1);//添加徒弟数
        userStatisticsDoManager.userStatisticsAddSlaveCount(userStatisticsDo);//增加徒弟数和徒弟贡献值
        //用户增加完积分值,就要个通知用户增加一位徒弟
        UserMessageDo userMessage = new UserMessageDo();
        userMessage.setCreateUserId(IsValidEnums.NO.getValue().longValue());
        userMessage.setCreateTime(System.currentTimeMillis());//创建时间
        userMessage.setMessageType(MessageTypeEnums.SYS_MSG.getType());
        userMessage.setSendUserId(objId);
        userMessage.setTitle("恭喜，你成功邀请了一位徒弟，查看惊喜！");
        userMessage.setContent("请去【我的】页面，师徒系统里查看收徒积分奖励。");
        userMessage.setIsDelete(IsValidEnums.NO.getValue());
        userMessageManager.insertUserMessageDo(userMessage);

    }

    /**
     * 查询徒弟列表添加缓存
     *
     * @param userUniId
     * @param userNormalityTaskEnums
     * @return
     */
    public List<UserNormalityTaskDo> getUser(Long userUniId, UserNormalityTaskEnums userNormalityTaskEnums) {

        //设置key
        String key = MgHdRedisKeyEnums.FOLLOW_CACHE_KEY.getCacheKey(userUniId + userNormalityTaskEnums.getTaskType());

        //获取缓存
        List<UserNormalityTaskDo> userFollowDoList = redisService.get(key);
        if (CollectionUtils.isEmpty(userFollowDoList)) {
            userFollowDoList = userNormalityTaskManager.findSlaves(userUniId, userNormalityTaskEnums);
            redisService.set(key, userFollowDoList, MgHdRedisKeyEnums.APPRENTICE_LIST_KEY.getExpireTime());

        }
        return CollectionUtils.isEmpty(userFollowDoList) ? new ArrayList<>() : userFollowDoList;
    }


}
