package com.hndl.cn.shop.sys.business.turntable.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.enums.welfare.WelfareTypeEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDo;
import com.hndl.cn.dao.system.bean.SystemParameterInfoDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.FoucaultLogDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.FoucaultLogManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.LuckyDrawCouponManager;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.prize.manager.LuckyTurntableManager;
import com.hndl.cn.mysql.manager.system.manager.SystemParameterInfoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.shop.sys.business.turntable.service.LuckyTurntableService;
import com.hndl.cn.shop.sys.business.turntable.service.TurntableMessageService;
import com.hndl.cn.shop.sys.business.turntable.vo.LuckyTurntableTaskVo;
import com.hndl.cn.shop.sys.business.turntable.vo.LuckyTurntableVo;
import com.hndl.cn.shop.sys.business.turntable.vo.PrizeRecordVo;
import com.hndl.cn.shop.sys.config.LuckyTurntableConfig;
import com.hndl.cn.shop.sys.exception.ShopSysException;
import com.hndl.cn.shop.sys.exception.ShopSysExceptionEnums;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.math.NumberUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;


/**
 *
 */
@Service
@Slf4j
public class LuckyTurntableServiceImpl implements LuckyTurntableService {


    @Resource
    LuckyDrawCouponManager luckyDrawCouponManager;

    @Resource
    UserStatisticsDoManager userStatisticsDoManager;

    @Resource
    TurntableMessageService turntableMessageService;

    @Resource
    SystemParameterInfoManager systemParameterInfoManager;

    @Resource
    LuckyTurntableManager luckyTurntableManager;

    @Resource
    UserIntegralLogManager userIntegralLogManager;

    @Resource
    FoucaultLogManager foucaultLogManager;



    /**
     * 奖品列表
     */
    @Resource
    private LuckyTurntableConfig luckyTurntableConfig;

    /**
     * 抽奖
     *
     * @return
     */
    @Override
    @SubmitLock(keys = "commonUserInfoDo#sysUniId",sysMarkEnum = ExceptionSysMarkEnum.SHOP_SYS)
    public Result<LuckyTurntableVo> prizeDraw(CommonUserInfoDo commonUserInfoDo, Integer version) {


            LuckyTurntableVo luckyTurntableVo;

            //1，获取用户可抽奖次数
            Integer drawNum = userStatisticsDoManager.findUserGetFoucaultCountsByUserUinId(commonUserInfoDo.getSysUniId());

            if (null == drawNum || drawNum < 1) {
                //用户抽奖次数不足
                throw new ShopSysException(ShopSysExceptionEnums.NUMBER_OF_DRAWS_NOT_ENOUGH.getCode());
            }

            //2，获取奖品集合并且进行抽奖
            Long prizeId = luckyTurntableConfig.luckAllDraw(version);

            //3，如果没有数据
            if (null == prizeId) {

                luckyTurntableVo = luckyTurntableConfig.getDefault();
                //3.2，把默认的放出去
                //接受奖品
                LuckyTurntableInfoDo turntableInfoDo = SpringCglibBeanUtils.convert(luckyTurntableVo, LuckyTurntableInfoDo.class);
                receivePrize(commonUserInfoDo, turntableInfoDo);
                //返回抽奖次数
                luckyTurntableVo.setDrawCount(drawNum - 1);
                //返回
                return ResultFactory.success(luckyTurntableVo);
            }

            LuckyTurntableInfoDo prize = luckyTurntableConfig.getLuckyTurntableDos().get(prizeId);

            if (null == prize) {
                luckyTurntableVo = luckyTurntableConfig.getDefault();
                return ResultFactory.success(luckyTurntableVo);
            }

            //获取奖品
            if (getPrize(commonUserInfoDo, prize.getId())) {
                //接受奖品
                receivePrize(commonUserInfoDo, prize);

                return resultVo(prize, Long.valueOf(drawNum - 1));
            } else {
                //获取不是实物的奖品抽一个
                LuckyTurntableInfoDo infinite = getInfinite(version);
                if (null == infinite) {
                    luckyTurntableVo = luckyTurntableConfig.getDefault();
                    infinite = SpringCglibBeanUtils.convert(luckyTurntableVo, LuckyTurntableInfoDo.class);
                }
                try {
                    //收取奖品
                    receivePrize(commonUserInfoDo, infinite);
                    return resultVo(infinite, Long.valueOf(drawNum - 1));

                } catch (Exception e) {
                    log.info("用户接受奖品异常！已发放默认奖品,用户：" + commonUserInfoDo.getSysUniId());
                    luckyTurntableVo = luckyTurntableConfig.getDefault();
                    infinite = SpringCglibBeanUtils.convert(luckyTurntableVo, LuckyTurntableInfoDo.class);
                    receivePrize(commonUserInfoDo, infinite);
                    luckyTurntableVo.setDrawCount(drawNum - 1);
                    return ResultFactory.success(luckyTurntableVo);
                }

            }
    }

    /**
     * 查询奖品列表
     *
     * @return
     */
    @Override
    public Result<Map<String, Object>> findPrize(CommonUserInfoDo commonUserInfoDo) {
        //1，获取用户可抽奖次数
        Integer drawNum = userStatisticsDoManager.findUserGetFoucaultCountsByUserUinId(commonUserInfoDo.getSysUniId());


        List<LuckyTurntableVo> luckyTurntableVos = luckyTurntableConfig.getLuckyTurntableVos();
        //查询用户今天所有积分记录进行分组【key是类型】
        List<FoucaultLogDo> toDayFoucaultLog = foucaultLogManager.findToDayFoucaultLog(commonUserInfoDo.getSysUniId());

        Map<Integer, List<FoucaultLogDo>> collect = toDayFoucaultLog.stream().collect(Collectors.groupingBy(FoucaultLogDo::getTaskType));

        //是否打开接口
        SystemParameterInfoDo luckyDrawStatus = systemParameterInfoManager.findByParameterName("luckyDrawStatus");

        drawNum = drawNum == null ? 0 : drawNum;

        //2，任务列表
        List<LuckyTurntableTaskVo> taskVos = new ArrayList<>();
        Arrays.stream(FoucaultGetTypeEnums.values()).filter(f -> null != FoucaultGetTypeEnums.getTurnTurntable().get(f.getTaskType())).forEach(
                val -> {
                    List<FoucaultLogDo> foucaultLogDos = collect.get(val.getTaskType());
                    //获取福卡数
                    int time = CollectionUtils.isEmpty(foucaultLogDos) ? 0 : foucaultLogDos.stream().mapToInt(FoucaultLogDo::getFoucaultCount).sum();
                    LuckyTurntableTaskVo build = LuckyTurntableTaskVo.builder()
                            .taskType(val.getTaskType())
                            .taskTitle(val.getTaskTitle() + "（" + time + "/" + val.getTimeCount() + "）")
                            .description(val.getDescription())
                            .imgUrl(val.getImgUrl())
                            .button(val.getButton())
                            .build();
                    if (FoucaultGetTypeEnums.GIVE_HEART_TASK.equals(val)) {
                        build.setTaskTitle(val.getTaskTitle() + "（" + time + "/无上限）");
                    }
                    taskVos.add(build);
                }
        );
        //两部分，1-奖品列表，2-任务列表
        Map map = new HashMap(4);
        map.put("luckyTurntableVos", luckyTurntableVos);
        map.put("taskVos", taskVos);
        map.put("drawCount", drawNum);
        map.put("isOpen", NumberUtils.toInt(luckyDrawStatus.getParameterValue()));
        return ResultFactory.success(map);
    }

    /**
     * 查询用户中将信息
     *
     * @param commonUserInfoDo
     * @return
     */
    @Override
    public Result<Map<String, Object>> findUserDraw(CommonUserInfoDo commonUserInfoDo, String id) {
        List<LuckyTurntableInfoDo> luckyTurntable = luckyTurntableManager.findLuckyTurntable(null);

        List<PrizeRecordVo> entityPrize = new ArrayList<>();
        List<PrizeRecordVo> ordinaryPrize = new ArrayList<>();
        Map<Long, List<LuckyTurntableInfoDo>> map = luckyTurntable.stream().collect(Collectors.groupingBy(LuckyTurntableInfoDo::getId));

        luckyDrawCouponManager.findUserList(null, commonUserInfoDo.getSysUniId(), IsValidEnums.YES, BaseConstants.DEFAULT_LIMIT, WelfareTypeEnums.RotaryDraw).stream().forEach(
                val -> {
                    List<LuckyTurntableInfoDo> list = map.get(val.getPrizeId());
                    entityPrize.add(PrizeRecordVo.builder()
                            .id(val.getId())
                            .prizeId(val.getPrizeId())
                            .time(val.getCreateTime())
                            .description(CollectionUtils.isNotEmpty(list) ? list.get(0).getPrizeName() : "福 利")
                            .build());
                }
        );
        luckyDrawCouponManager.findUserList(id, commonUserInfoDo.getSysUniId(), IsValidEnums.NO, BaseConstants.DEFAULT_LIMIT, WelfareTypeEnums.RotaryDraw).stream().forEach(
                val -> {
                    //指定过滤了2号再接再励
                    if (!val.getPrizeId().equals(2L)) {
                        List<LuckyTurntableInfoDo> list = map.get(val.getPrizeId());
                        ordinaryPrize.add(PrizeRecordVo.builder()
                                .id(val.getId())
                                .prizeId(val.getPrizeId())
                                .time(val.getCreateTime())
                                .description(CollectionUtils.isNotEmpty(list) ? list.get(0).getPrizeName() : "福 利")
                                .build());
                    }
                }
        );
        //两部分实物和非实物
        Map mapVo = new HashMap<>(2);
        mapVo.put("entityPrize", entityPrize);
        mapVo.put("ordinaryPrize", ordinaryPrize);
        return ResultFactory.success(mapVo);
    }

    /**
     * 视频上报接口
     *
     * @param commonUserInfoDo
     * @return
     */
    @Override
    public Result<Map<String, Object>> reportVideo(CommonUserInfoDo commonUserInfoDo) {
        Map map = new HashMap(1);
        Integer countCanDrawByDayTask = foucaultLogManager.findToDayCount(commonUserInfoDo.getSysUniId(), FoucaultGetTypeEnums.WATCH_VIDEO, IsValidEnums.YES);

        if (countCanDrawByDayTask < FoucaultGetTypeEnums.WATCH_VIDEO.getTimeCount()) {
            //增加福卡记录
            foucaultLogManager.insertFoucaultLog(commonUserInfoDo.getSysUniId(), FoucaultGetTypeEnums.WATCH_VIDEO, IsValidEnums.YES, 1);
            //加福卡数
            userStatisticsDoManager.userAddFoucaultCount(commonUserInfoDo.getSysUniId(), 1);
            // 给用户加积分
            userStatisticsDoManager.userStatisticsAddIntegralCount(
                    commonUserInfoDo.getSysUniId(),
                    30L,
                    IsValidEnums.NO);
            // 给用户增加积分记录
            userIntegralLogManager.insertUserIntegralLog(
                    commonUserInfoDo.getSysUniId(),
                    "0",
                    IsValidEnums.YES,
                    UserDayEmpiricalTypeEnums.GENERALIZE_ZHUXIAN.getTaskType(),
                    30);
            countCanDrawByDayTask++;
        }
        Integer drawNum = userStatisticsDoManager.findUserGetFoucaultCountsByUserUinId(commonUserInfoDo.getSysUniId());
        log.info("观看视频后的福卡数量:" + drawNum);
        map.put("watchVideoCount", "观看视频（" + (countCanDrawByDayTask) + "/" + FoucaultGetTypeEnums.WATCH_VIDEO.getTimeCount() + "）");
        map.put("drawCount", drawNum);

        return ResultFactory.success(map);
    }

    /**
     * 查询用户福卡相关
     *
     * @param commonUserInfoDo
     * @return
     */
    @Override
    public Result<Map<String, Object>> findUserFoucault(CommonUserInfoDo commonUserInfoDo) {
        Integer foucaultCount = userStatisticsDoManager.findUserGetFoucaultCountsByUserUinId(commonUserInfoDo.getSysUniId());
        Map map = new HashMap(1);
        map.put("foucaultCount", foucaultCount);
        return ResultFactory.success(map);
    }

    /**
     * 接收奖品
     *
     * @param commonUserInfoDo 用户
     * @param prize            奖品的id
     */
    private void receivePrize(CommonUserInfoDo commonUserInfoDo, LuckyTurntableInfoDo prize) {

        IsValidEnums isValidEnums = IsValidEnums.NO;
        if (IsValidEnums.YES.getValue().equals(prize.getIsEntity())) {
            isValidEnums = IsValidEnums.YES;
        }
        //插入一条记录
        luckyDrawCouponManager.insertLuckyDrawCoupon(commonUserInfoDo.getSysUniId(), prize.getId(), WelfareTypeEnums.RotaryDraw, isValidEnums, isValidEnums);

        //插入福利卡片消费记录
        foucaultLogManager.insertFoucaultLog(commonUserInfoDo.getSysUniId(),FoucaultGetTypeEnums.TURN_TURNTABLE, IsValidEnums.NO, 1);
        //减用户福卡数
        if (!userStatisticsDoManager.userUpdateFoucaultCount(commonUserInfoDo.getSysUniId(), 1)) {
            throw new ShopSysException(ShopSysExceptionEnums.NUMBER_OF_DRAWS_NOT_ENOUGH.getCode());
        }
        if (prize.getIntegral() > 0L) {
            //给用户加积分
            userStatisticsDoManager.userStatisticsAddIntegralCount(commonUserInfoDo.getSysUniId(), prize.getIntegral(), IsValidEnums.NO);
            //插入用户积分记录表
            userIntegralLogManager.insertUserIntegralLog(commonUserInfoDo.getSysUniId(), "0", IsValidEnums.YES, UserDayEmpiricalTypeEnums.LUCKYTURNTABLE.getTaskType(), prize.getIntegral().intValue());
        }
        //插入消息
        if (IsValidEnums.YES.getValue().equals(prize.getShowMessage())) {
            turntableMessageService.saveTurntableMessage(commonUserInfoDo.getNickName(), prize.getPrizeName(), prize.getIsEntity());
        }
    }

    /**
     * 判断用户是否可以领取奖励
     *
     * @param prizeId
     * @return
     */
    private boolean getPrize(CommonUserInfoDo commonUserInfoDo, Long prizeId) {

        //获取奖品，如果是一个不存在的

        LuckyTurntableInfoDo luckyTurntableInfoDo = luckyTurntableConfig.getLuckyTurntableDos().get(prizeId);

        if (null == luckyTurntableInfoDo) {
            return false;
        }
        //用户抽奖次数没有达到门槛
        Long drawNum = luckyDrawCouponManager.countByUserUniId(commonUserInfoDo.getSysUniId(), WelfareTypeEnums.RotaryDraw);
        if (drawNum < luckyTurntableInfoDo.getPersonMinDraw()) {
            return false;
        }
        //奖品获得记录 >= 该奖品设定的库存
        Long prizeNum = luckyDrawCouponManager.countByPrizeId(prizeId, WelfareTypeEnums.RotaryDraw);
        Integer reserveNum = luckyTurntableInfoDo.getReserveNum();
        if (prizeNum >= reserveNum) {
            return false;
        }

        //一个用户只中一次大奖
        Long userToDayWin = luckyDrawCouponManager.countToDayWinByUser(commonUserInfoDo.getSysUniId(), IsValidEnums.YES, WelfareTypeEnums.RotaryDraw);
        if (userToDayWin > 0) {
            return false;
        }
        //一个大奖一天只开一次
        Long dayByEntity = luckyDrawCouponManager.countToDayByEntity(IsValidEnums.YES, WelfareTypeEnums.RotaryDraw);
        if (dayByEntity > 0) {
            return false;
        }
        //如果用户领取次数 >= 设定的用户领取的次数
        Long userWinningCount = luckyDrawCouponManager.countWinning(commonUserInfoDo.getSysUniId(), prizeId, WelfareTypeEnums.RotaryDraw);
        Integer personMaxGet = luckyTurntableInfoDo.getPersonMaxGet();
        if (userWinningCount >= personMaxGet) {
            return false;
        }
        return true;
    }

    /**
     * 获取不是实物的奖品
     *
     * @return
     */
    private LuckyTurntableInfoDo getInfinite(Integer version) {
        Long prizeId = luckyTurntableConfig.luckIntegralDraw(version);


        if (null == prizeId) {
            return null;
        }
        LuckyTurntableInfoDo luckyTurntableInfoDo = luckyTurntableConfig.getLuckyTurntableDos().get(prizeId);
        if (null != luckyTurntableInfoDo) {
            return luckyTurntableInfoDo;
        }
        return null;
    }

    /**
     * 把奖品do转换为返回结果
     *
     * @param luckyTurntableInfoDo
     * @param drawCount            抽奖次数
     * @return
     */
    private Result<LuckyTurntableVo> resultVo(LuckyTurntableInfoDo luckyTurntableInfoDo, Long drawCount) {
        List<LuckyTurntableVo> luckyTurntableVos = luckyTurntableConfig.getLuckyTurntableVos();
        for (LuckyTurntableVo turntableVo : luckyTurntableVos) {
            if (luckyTurntableInfoDo.getId().equals(turntableVo.getId())) {
                turntableVo.setDrawCount(drawCount.intValue());
                //返回提示
                turntableVo.setHint("恭喜你获得了" + luckyTurntableInfoDo.getPrizeName() + "！");
                if (turntableVo.getId().equals(2L)) {
                    turntableVo.setHint("很遗憾，您未中奖！");
                }
                return ResultFactory.success(turntableVo);
            }
        }
        return ResultFactory.success();
    }


}
