package com.hndl.cn.shop.sys.business.welfare.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpUserWelfareMappingManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.UserWelfareMappingManager;
import com.hndl.cn.mongodb.manager.user.bean.UserReceivingAddressDo;
import com.hndl.cn.mongodb.manager.user.manager.UserReceivingAddressManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.shop.sys.business.help.vo.UserWelfareMappingVo;
import com.hndl.cn.shop.sys.business.welfare.service.WelfarePrizeService;
import com.hndl.cn.shop.sys.business.welfare.vo.MyWelfareInfoVo;
import com.hndl.cn.shop.sys.business.welfare.vo.UserReceivingAddressVo;
import com.hndl.cn.shop.sys.business.welfare.vo.WelfarePrizeVo;
import com.hndl.cn.shop.sys.exception.ShopSysException;
import com.hndl.cn.shop.sys.exception.ShopSysExceptionEnums;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/1 17 33
 * @Description:
 * @Author: 资龙茂
 */
@Service
public class WelfarePrizeServiceImpl implements WelfarePrizeService {


    @Resource
    private HelpWelfareManager helpWelfareManager;

    @Resource
    private HelpUserWelfareMappingManager helpUserWelfareMappingManager;

    @Resource
    private RedisService redisService;

    @Resource
    private UserWelfareMappingManager userWelfareMappingManager;

    @Resource
    private UserReceivingAddressManager userReceivingAddressManager;

    @Override
    public Result<Object> findWelfarePrizeInfo() {
        // 一页存放十条福利奖品, 据产品说福利奖品不会太多, 故暂且只做一页
        String key = MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getCacheKey(NumberEnums.ONE.getEnglish());
        List<WelfarePrizeVo> welfarePrizeVoList = redisService.get(key);
        if (CollectionUtils.isEmpty(welfarePrizeVoList)) {
            welfarePrizeVoList = SpringCglibBeanUtils.convertByList(helpWelfareManager.findIsValidWelfarePrize(null), WelfarePrizeVo.class);
            welfarePrizeVoList = setWorkProgressByList(welfarePrizeVoList);
            redisService.set(key, welfarePrizeVoList, MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getExpireTime());
        }
        return ResultFactory.success(welfarePrizeVoList);
    }

    @Override
    public Result<Object> findWelfarePrizeInfoByPage(@NotNull String id) {
        List<WelfarePrizeVo> welfarePrizeVoList = SpringCglibBeanUtils.convertByList(helpWelfareManager.findIsValidWelfarePrize(id), WelfarePrizeVo.class);
        welfarePrizeVoList = setWorkProgressByList(welfarePrizeVoList);
        return ResultFactory.success(welfarePrizeVoList);
    }

    @Override
    public Result<Object> findMyWelfarePrizeSingle(CommonUserInfoDo commonUserInfoDo, @NotNull String welfareNumber) {
        Map<String, Object> resultMap = new HashMap<>();
        WelfarePrizeVo welfarePrizeVo = SpringCglibBeanUtils.convert(helpWelfareManager.findWelfarePrizeByWelfareNumber(welfareNumber), WelfarePrizeVo.class);
        // 福利商品VO
        resultMap.put("welfarePrizeVo", setWorkProgress(welfarePrizeVo));
        // 我的助力信息(这里有两种情况, 一种是已登录的用户、一种是未登录的用户)
        if (commonUserInfoDo == null) {
            resultMap.put("myWelfareInfo", null);
        } else {
            UserWelfareMappingDo userWelfareMappingDo = userWelfareMappingManager.queryHelpCountByUserId(welfareNumber, commonUserInfoDo.getSysUniId());
            if (userWelfareMappingDo == null) {
                resultMap.put("myWelfareInfo", null);
            } else {
                resultMap.put("myWelfareInfo", queryMyWelfareInfo(userWelfareMappingDo.getId(), welfarePrizeVo.getNowSumCount()));
            }
        }
        return ResultFactory.success(resultMap);
    }

    @Override
    public Result<Object> findFriendWelfarePrizeSingle(CommonUserInfoDo commonUserInfoDo, @NotNull String userWelfareId) {
        Map<String, Object> resultMap = new HashMap<>();
        // 1. 需要获取助力对象
        UserWelfareMappingDo userWelfareMappingDo = userWelfareMappingManager.queryUserWelfareById(userWelfareId);
        if (userWelfareMappingDo != null) {
            // 用户未登录的情况
            if (commonUserInfoDo == null) {
                resultMap.put("isMe", IsValidEnums.NO.getValue());
                resultMap.put("isPartake", IsValidEnums.NO.getValue());
                // 是否已帮助此好友助力此奖品
                resultMap.put("isHelped", IsValidEnums.NO.getValue());
            } else {
                // 2. 如果是自己看自己
                if (userWelfareMappingDo.getUserUniId().equals(commonUserInfoDo.getSysUniId())) {
                    resultMap.put("isMe", IsValidEnums.YES.getValue());
                    resultMap.put("isPartake", IsValidEnums.YES.getValue());
                } else {
                    // 3. 如果是自己看别人
                    resultMap.put("isMe", IsValidEnums.NO.getValue());
                    // 4. 查询自己有没有参与过此奖品的抢福利
                    if (userWelfareMappingManager.queryHelpCountByUserId(userWelfareMappingDo.getWelfareNumber(), commonUserInfoDo.getSysUniId()) != null) {
                        resultMap.put("isPartake", IsValidEnums.YES.getValue());
                    } else {
                        resultMap.put("isPartake", IsValidEnums.NO.getValue());
                    }
                }
                // 是否已帮助此好友助力此奖品
                resultMap.put("isHelped", helpUserWelfareMappingManager.queryHelpByUserId(userWelfareMappingDo.getWelfareNumber(), commonUserInfoDo.getSysUniId()) == null ? IsValidEnums.NO.getValue() : IsValidEnums.YES.getValue());
            }
            // 福利商品VO
            WelfarePrizeVo welfarePrizeVo = SpringCglibBeanUtils.convert(helpWelfareManager.findWelfarePrizeByWelfareNumber(userWelfareMappingDo.getWelfareNumber()), WelfarePrizeVo.class);
            resultMap.put("welfarePrizeVo", setWorkProgress(welfarePrizeVo));
            // 好友的助力信息
            resultMap.put("myWelfareInfo", queryMyWelfareInfo(userWelfareMappingDo.getId(), welfarePrizeVo.getNowSumCount()));
        } else {
            throw new ShopSysException(ShopSysExceptionEnums.YOUR_FRIEND_NOT_PARTICIPATION.getCode());
        }
        return ResultFactory.success(resultMap);
    }

    @Override
    public Result<Object> findSuccessPrizeInfo() {
//        log.info(" ----- 进入了findSuccessPrizeInfo函数 -----");
        // 第零页存放已开奖三天的奖品(原本开发者计划是只存放开奖成功的奖品, 后产品建议把开奖失败的奖品也展示出来)
        String key = MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getCacheKey(NumberEnums.ZERO.getEnglish());
//        log.info(" ----- 获取了key: " + key + " -----");
        List<WelfarePrizeVo> welfarePrizeVoList = redisService.get(key);
//        log.info(" ----- 获取了奖品列表: " + welfarePrizeVoList + " -----");
        if (CollectionUtils.isEmpty(welfarePrizeVoList)) {
//            log.info(" ----- 奖品列表为空 -----");
            welfarePrizeVoList = SpringCglibBeanUtils.convertByList(helpWelfareManager.findSuccessWelfarePrize(null, null, System.currentTimeMillis() - 259200000L), WelfarePrizeVo.class);
//            log.info(" ----- 获取了新的奖品列表: " + welfarePrizeVoList + " -----");
            welfarePrizeVoList = setWorkProgressByList(welfarePrizeVoList);
//            log.info(" ----- 奖品的开奖进度set完毕 -----");
            redisService.set(key, welfarePrizeVoList, MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getExpireTime());
//            log.info(" ----- 刷新了redis -----");
        }
        return ResultFactory.success(welfarePrizeVoList);
    }

    @Override
    public Result<Object> findMyPrizeInfo(@NotNull CommonUserInfoDo commonUserInfoDo, String id) {
        List<UserReceivingAddressVo> userReceivingAddressVoList = SpringCglibBeanUtils.convertByList(userReceivingAddressManager.findPrizeInfoByUserId(commonUserInfoDo.getSysUniId(), id), UserReceivingAddressVo.class);
        setValue(userReceivingAddressVoList);
        return ResultFactory.success(userReceivingAddressVoList);
    }

    @Override
    public Result<Object> findIsJoinUserInfo(String welfareNumber) {
        return ResultFactory.success(SpringCglibBeanUtils.convertByList(userWelfareMappingManager.findIsJoinUserInfo(welfareNumber), UserWelfareMappingDo.class));
    }

    @Override
    public Result<Object> findLuckyUserInfo(String welfareNumber) {
//        log.info("开始请求接口... 期号为 " + welfareNumber);
        // 1. 先从Redis里取结果集
        String key = MgHdRedisKeyEnums.WELFARE_USER_CACHE_KEY.getCacheKey(welfareNumber);
//        log.info("开始获取RedisKey... key为 " + key);
        List<UserWelfareMappingVo> userWelfareMappingVoList = redisService.get(key);
//        log.info("从Redis中获取到的中奖人是否为空? " + userWelfareMappingVoList);
        // 2. 如果Redis里没有中奖用户, 从库里查询此福利奖品
        if (CollectionUtils.isEmpty(userWelfareMappingVoList)) {
            HelpWelfareDo helpWelfareDo = helpWelfareManager.findWelfarePrizeByWelfareNumber(welfareNumber);
//            log.info("从库里查出的奖品 " + helpWelfareDo.toString());
            // 3. 检查该奖品是否有效
            checkHelpWelfareValue(helpWelfareDo);
            // 4. 根据福利奖品的中奖人名单, 查询参与抢福利的用户信息
            List<UserWelfareMappingVo> resultList = new ArrayList<>();
            for (Long sysUniId : helpWelfareDo.getSuccessUserUniId()) {
                UserWelfareMappingVo userWelfareMappingDo = SpringCglibBeanUtils.convert(userWelfareMappingManager.queryHelpCountByUserId(welfareNumber, sysUniId), UserWelfareMappingVo.class);
//                log.info("中奖人的助力信息 " + userWelfareMappingDo.toString());
                // 5. 添加至中奖用户列表里
                resultList.add(userWelfareMappingDo);
            }
            //6. set至Redis中
            redisService.set(key, resultList, MgHdRedisKeyEnums.WELFARE_USER_CACHE_KEY.getExpireTime());
            return ResultFactory.success(resultList);
        }
        // 7. 返回
        return ResultFactory.success(userWelfareMappingVoList);
    }

    @Override
    public Result<Object> submitAddress(@NotNull CommonUserInfoDo commonUserInfoDo, @NotNull String welfareNumber, @NotNull String phoneNumber, @NotNull String receivingName, @NotNull String receivingAddress, String reason) {
        HelpWelfareDo helpWelfareDo = helpWelfareManager.findWelfarePrizeByWelfareNumber(welfareNumber);
        if (null == helpWelfareDo.getSuccessUserUniId()) {
            //抛出异常
            throw new ShopSysException(ShopSysExceptionEnums.PRIZE_NOT_OPEN.getCode());
        }

        long count = helpWelfareDo.getSuccessUserUniId().stream().filter(val -> val.equals(commonUserInfoDo.getSysUniId())).count();

        if (count < 1){
            throw new ShopSysException(ShopSysExceptionEnums.PRIZE_NOT_FOUND.getCode());
        }

        UserReceivingAddressDo userReceivingAddressDo = userReceivingAddressManager.findAddressByWelfareNumber(commonUserInfoDo.getSysUniId(), welfareNumber);
        userReceivingAddressDo.setPhoneNumber(phoneNumber);
        userReceivingAddressDo.setReceivingAddress(receivingAddress);
        userReceivingAddressDo.setReceivingName(receivingName);
        userReceivingAddressDo.setReason(reason);
        userReceivingAddressManager.submitAddress(userReceivingAddressDo);
        return ResultFactory.success(userReceivingAddressDo);


/*        for (Long prizeUserId : helpWelfareDo.getSuccessUserUniId()) {
            if (commonUserInfoDo.getSysUniId().equals(prizeUserId)) {
                UserReceivingAddressDo userReceivingAddressDo = userReceivingAddressManager.findAddressByWelfareNumber(commonUserInfoDo.getSysUniId(), welfareNumber);
                userReceivingAddressDo.setPhoneNumber(phoneNumber);
                userReceivingAddressDo.setReceivingAddress(receivingAddress);
                userReceivingAddressDo.setReceivingName(receivingName);
                userReceivingAddressDo.setReason(reason);
                userReceivingAddressManager.submitAddress(userReceivingAddressDo);
                return ResultFactory.success(userReceivingAddressDo);
            }
        }
        throw new ShopSysException(ShopSysExceptionEnums.PRIZE_NOT_FOUND.getCode());
        */
    }

    /**
     * 计算集合中的福利奖品开奖进度
     * @param welfarePrizeVoList
     * @return
     */
    public List<WelfarePrizeVo> setWorkProgressByList(List<WelfarePrizeVo> welfarePrizeVoList) {
        welfarePrizeVoList.stream().forEach(welfarePrizeVo ->
            welfarePrizeVo.setWorkProgress(String.format("%.0f",
                welfarePrizeVo.getNowSumCount() < welfarePrizeVo.getHelpCount() ?
                    (double)welfarePrizeVo.getNowSumCount() / welfarePrizeVo.getHelpCount() * NumberEnums.ONE_HUNDERD.getNumber() : NumberEnums.ONE_HUNDERD.getNumber()))
        );
        return welfarePrizeVoList;
    }

    /**
     * 计算单个福利奖品开奖进度 & 已参与人数 & 已抢到福利人数
     * @param welfarePrizeVo
     * @return
     */
    public WelfarePrizeVo setWorkProgress(WelfarePrizeVo welfarePrizeVo) {
        // 开奖进度
        welfarePrizeVo.setWorkProgress(String.format("%.0f",
                welfarePrizeVo.getNowSumCount() < welfarePrizeVo.getHelpCount() ?
                        (double)welfarePrizeVo.getNowSumCount() / welfarePrizeVo.getHelpCount() * NumberEnums.ONE_HUNDERD.getNumber() : NumberEnums.ONE_HUNDERD.getNumber())
        );
        // 已参与此福利人数
        welfarePrizeVo.setPartakePersonCount(userWelfareMappingManager.countIsPartakePersonCount(welfarePrizeVo.getWelfareNumber()).intValue());

        // 已抢到福利人数
        String key = MgHdRedisKeyEnums.WELFARE_USER_COUNT_CACHE_KEY.getCacheKey();
        Integer gotWelfarePerson = redisService.get(key);
        if (gotWelfarePerson == null || gotWelfarePerson == 0) {
            gotWelfarePerson = userReceivingAddressManager.countLuckyUser().intValue();
            redisService.set(key, gotWelfarePerson, MgHdRedisKeyEnums.WELFARE_USER_COUNT_CACHE_KEY.getExpireTime());
        }
        welfarePrizeVo.setGotWelfarePerson(gotWelfarePerson);
        return welfarePrizeVo;
    }

    /**
     * 获取个人助力值以及得奖率
     * @param userWelfareId
     * @param nowSumCount
     * @return
     */
    public MyWelfareInfoVo queryMyWelfareInfo(String userWelfareId, Integer nowSumCount) {
        MyWelfareInfoVo myWelfareInfoVo = new MyWelfareInfoVo("", "", "", NumberEnums.ZERO.getNumber(), "0.00");
        UserWelfareMappingDo userWelfareMappingDo = userWelfareMappingManager.queryUserWelfareById(userWelfareId);
        if (userWelfareMappingDo != null) {
            myWelfareInfoVo.setNickName(userWelfareMappingDo.getUserNickName());
            myWelfareInfoVo.setHeadImg(userWelfareMappingDo.getUserImg());
            myWelfareInfoVo.setMyWelfareId(userWelfareMappingDo.getId());
            myWelfareInfoVo.setHelpCount(userWelfareMappingDo.getHelpCount());
            myWelfareInfoVo.setWinningRate(String.format("%.2f", (double)userWelfareMappingDo.getHelpCount() / nowSumCount * NumberEnums.ONE_HUNDERD.getNumber()));
            // 这里有一定几率中奖概率为NaN, 所以做个替换判断
            if (myWelfareInfoVo.getWinningRate().equals("NaN") || myWelfareInfoVo.getWinningRate().equals("Infinity")) {
                myWelfareInfoVo.setWinningRate("0.00");
            }
        }
        return myWelfareInfoVo;
    }

    /**
     * 循环赋值奖品名和奖品封面图
     * @param userReceivingAddressVoList
     * @return
     */
    public List<UserReceivingAddressVo> setValue(List<UserReceivingAddressVo> userReceivingAddressVoList) {
        for (UserReceivingAddressVo userReceivingAddressVo : userReceivingAddressVoList) {
            HelpWelfareDo helpWelfareDo = helpWelfareManager.findWelfarePrizeByWelfareNumber(userReceivingAddressVo.getWelfareNumber());
            userReceivingAddressVo.setPrizeImg(helpWelfareDo.getPrizeImg());
            userReceivingAddressVo.setPrizeName(helpWelfareDo.getPrizeName());
        }
        return userReceivingAddressVoList;
    }

    private void checkHelpWelfareValue(HelpWelfareDo helpWelfareDo) {
        // 1. 检查奖品是否存在
        if (helpWelfareDo == null) {
            throw new ShopSysException(ShopSysExceptionEnums.PRIZE_NOT_FOUND.getCode());
        }
        // 2. 检查奖品是否开奖
        if (helpWelfareDo.getIsSuccess().equals(IsValidEnums.NO.getValue())) {
            throw new ShopSysException(ShopSysExceptionEnums.PRIZE_NOT_OPEN.getCode());
        }
    }


    public static void main(String[] args) {

        int i = 1;
        i = nothing(i);
        System.out.println(i);
//        System.out.println(String.format("%.2f", (double)0/0 * 100) + "%");
        System.out.println(String.format("%.0f",
                1000 < 100 ?
                        (double)1000 / 100 * 100 : 100));
    }


    public static int nothing(int i) {
        i = i+1;
        return i;
    }

}
