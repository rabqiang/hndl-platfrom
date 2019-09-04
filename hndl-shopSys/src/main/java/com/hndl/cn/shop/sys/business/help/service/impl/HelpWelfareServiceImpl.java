package com.hndl.cn.shop.sys.business.help.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.base.exception.enums.ExceptionSysMarkEnum;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpUserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.FoucaultLogManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpUserWelfareMappingManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.UserWelfareMappingManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.nosql.redis.annotation.lock.SubmitLock;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.shop.sys.business.help.service.HelpWelfareService;
import com.hndl.cn.shop.sys.exception.ShopSysException;
import com.hndl.cn.shop.sys.exception.ShopSysExceptionEnums;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.validation.constraints.NotNull;
import java.util.*;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/8/4 17 10
 * @Description:
 * @Author: 资龙茂
 */
@Service
public class HelpWelfareServiceImpl implements HelpWelfareService {

    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    @Resource
    private HelpWelfareManager helpWelfareManager;

    @Resource
    private UserWelfareMappingManager userWelfareMappingManager;

    @Resource
    private HelpUserWelfareMappingManager helpUserWelfareMappingManager;

    @Resource
    private FoucaultLogManager foucaultLogManager;

    @Resource
    private RedisService redisService;

    ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    @Value("${wecaht.app.id}")
    private String wechatAppId;

    @Value("${wechat.app.secret}")
    private String wechatAppSecret;

    @Override
    @SubmitLock(keys = ("commonUserInfoDo#sysUniId"),sysMarkEnum = ExceptionSysMarkEnum.SHOP_SYS)
    public Result<Object> askForHelp(@NotNull CommonUserInfoDo commonUserInfoDo, @NotNull String prizeId, @NotNull String formId, @NotNull String openId) {
        // 1. 获取奖品DO
        HelpWelfareDo welfarePrize = helpWelfareManager.findWelfarePrizeById(prizeId);
        checkPrizeIsValid(welfarePrize);
        // 2. 获取用户邀请助力DO
        UserWelfareMappingDo myWelfareDo = userWelfareMappingManager.queryHelpCountByUserId(welfarePrize.getWelfareNumber(), commonUserInfoDo.getSysUniId());
        // 3. 这里有三种情况, 一种是用户已经参与过抢福利
        if (myWelfareDo != null) {
            return ResultFactory.success(myWelfareDo);
        }
        //判断这个福利是否需要福卡
        if (welfarePrize.getFoucaultCount() != null && welfarePrize.getFoucaultCount() > 0){
            boolean flag = userStatisticsDoManager.userUpdateFoucaultCount(commonUserInfoDo.getSysUniId(), welfarePrize.getFoucaultCount());

            //扣除失败
            if(!flag){
                throw new ShopSysException(ShopSysExceptionEnums.FOUCAULT_COUNT_TOO_LITTLE.getCode());
            }
            // 增加福卡记录
            foucaultLogManager.insertFoucaultLogs(commonUserInfoDo.getSysUniId(), FoucaultGetTypeEnums.DAYLIGHT_ROBBERY, IsValidEnums.NO, welfarePrize.getFoucaultCount());
        }
        UserWelfareMappingDo userWelfareMappingDo = setValue(commonUserInfoDo, welfarePrize, formId, openId);
        // 成功参与抢福利
        userWelfareMappingManager.addUserWelfareMapping(userWelfareMappingDo);
        return ResultFactory.success(userWelfareMappingDo);
    }

    @Override
    @SubmitLock(keys = ("commonUserInfoDo#sysUniId"),sysMarkEnum = ExceptionSysMarkEnum.SHOP_SYS)
    public Result<Object> helpFriend(@NotNull CommonUserInfoDo commonUserInfoDo, @NotNull String userWelfareId) {
        // 1. 获取用户邀请助力DO
        UserWelfareMappingDo friendWelfareDo = userWelfareMappingManager.queryUserWelfareById(userWelfareId);
        // 2. 异常情况判断
        checkHelpIsValid(commonUserInfoDo, friendWelfareDo);
        // 助力值默认为老用户
        Random random = new Random();
        int helpCount = BaseConstants.OLD_USER_HELPCOUNT + random.nextInt(NumberEnums.SIX.getNumber());
        // 3. 判断是否为新用户. 如果是新用户, 则助力15 ~ 20点, 否则默认增加10 ~ 15点
        if ((commonUserInfoDo.getCreateTime().getTime() + 86400000L) > System.currentTimeMillis()) {
            helpCount = BaseConstants.NEW_USER_HELPCOUNT + random.nextInt(NumberEnums.SIX.getNumber());
        }
        HelpUserWelfareMappingDo helpUserWelfareMappingDo = setValue(commonUserInfoDo, helpCount, friendWelfareDo);
        // 4. 插入帮助好友助力记录
        helpUserWelfareMappingManager.addHelpUserWelfareMapping(helpUserWelfareMappingDo);
        // 5. 更新好友助力值 & 助力人数 & 最后助力值
        userWelfareMappingManager.addUserWelfareGetHelpCount(friendWelfareDo.getUserUniId(), friendWelfareDo.getWelfareNumber(), helpCount, helpCount);
        // 6. 更新福利奖品总助力值
        //HelpWelfareDo helpWelfareDo = helpWelfareManager.findWelfarePrizeByWelfareNumber(friendWelfareDo.getWelfareNumber());
        helpWelfareManager.addHelpUserNowSumCount(friendWelfareDo.getWelfareNumber(), helpCount);
        return ResultFactory.success();
    }

    @Override
    public Result<Object> findHelpMeFriend(CommonUserInfoDo commonUserInfoDo, String userWelfareId) {
        // 1. 获取用户邀请助力DO
        UserWelfareMappingDo friendWelfareDo = userWelfareMappingManager.queryUserWelfareById(userWelfareId);
        // 2. 异常情况判断
        if (friendWelfareDo == null) {
            throw new ShopSysException(ShopSysExceptionEnums.YOUR_FRIEND_NOT_PARTICIPATION.getCode());
        }
        Map<String, Object> resultMap = new HashMap<>();
        List<HelpUserWelfareMappingDo> helpUserWelfareMappingDoList = helpUserWelfareMappingManager.queryHelpMeFriend(friendWelfareDo.getUserUniId(), friendWelfareDo.getWelfareNumber());
        resultMap.put("helpUserWelfareMappingDoList", helpUserWelfareMappingDoList);
        Long helpMeFriendCount = helpUserWelfareMappingManager.queryHelpMeFriendCount(friendWelfareDo.getUserUniId(), friendWelfareDo.getWelfareNumber());
        resultMap.put("helpMeFriendCount", helpMeFriendCount);
        resultMap.put("helpCount", friendWelfareDo.getHelpCount());
        return ResultFactory.success(resultMap);
    }

    /**
     * 检查奖品DO是否异常
     */
    private void checkPrizeIsValid(HelpWelfareDo helpWelfareDo) {
        // 空值判断
        if (helpWelfareDo == null) {
            throw new ShopSysException(ShopSysExceptionEnums.PRIZE_NOT_FOUND.getCode());
        }
        // 判断奖品是否过期 & 是否已经开奖
        if (helpWelfareDo.getEndTime() < System.currentTimeMillis() || helpWelfareDo.getIsSuccess().equals(IsValidEnums.YES.getValue())) {
            throw new ShopSysException(ShopSysExceptionEnums.PRIZE_IS_OVERDUE.getCode());
        }
    }

    /**
     * 检查助力DO是否异常
     * @param commonUserInfoDo "好友"的user对象
     * @param friendWelfareDo "好友"的助力对象
     */
    private void checkHelpIsValid(CommonUserInfoDo commonUserInfoDo, UserWelfareMappingDo friendWelfareDo) {
        // 好友是否已参与过抢福利
        if (friendWelfareDo == null) {
            throw new ShopSysException(ShopSysExceptionEnums.YOUR_FRIEND_NOT_PARTICIPATION.getCode());
        }
        // 是否已帮助此好友助力此奖品
        HelpUserWelfareMappingDo helpUserWelfareMappingDo = helpUserWelfareMappingManager.queryHelpByUserId(friendWelfareDo.getWelfareNumber(), commonUserInfoDo.getSysUniId());
        if (helpUserWelfareMappingDo != null ) {
            throw new ShopSysException(ShopSysExceptionEnums.YOUR_BEEN_INVOLVED.getCode());
        }
        // 今天是否已助力三次
        if (helpUserWelfareMappingManager.queryHelpCountByUserId(commonUserInfoDo.getSysUniId()) >= 3) {
            throw new ShopSysException(ShopSysExceptionEnums.YOUR_HELP_TOO_MUCH.getCode());
        }
        // 是否为自己助力自己
        if (commonUserInfoDo.getSysUniId().equals(friendWelfareDo.getUserUniId())) {
            throw new ShopSysException(ShopSysExceptionEnums.YOU_ARE_CRAZY.getCode());
        }

    }

    /**
     * 用户参与抢福利对象初始化
     * @param commonUserInfoDo "我"的user对象
     * @param welfarePrize"我"的助力对象
     * @return
     */
    private UserWelfareMappingDo setValue(CommonUserInfoDo commonUserInfoDo, HelpWelfareDo welfarePrize, String formId, String openId) {
        UserWelfareMappingDo userWelfareMappingDo = new UserWelfareMappingDo();
        userWelfareMappingDo.setCreateTime(new Date().getTime());
        userWelfareMappingDo.setLastModifyTime(new Date().getTime());
        userWelfareMappingDo.setFromId(formId);
        userWelfareMappingDo.setHelpCount(NumberEnums.ZERO.getNumber());
        userWelfareMappingDo.setLastHelpCount(NumberEnums.ZERO.getNumber());
        userWelfareMappingDo.setIsDelete(IsValidEnums.NO.getValue());
        userWelfareMappingDo.setOpenId(openId);
        userWelfareMappingDo.setUserImg(commonUserInfoDo.getPersonImgUrlMin());
        userWelfareMappingDo.setUserNickName(commonUserInfoDo.getNickName());
        userWelfareMappingDo.setUserUniId(commonUserInfoDo.getSysUniId());
        userWelfareMappingDo.setWelfareNumber(welfarePrize.getWelfareNumber());
        userWelfareMappingDo.setId(iSnowflakeIdService.nextHelpWelfareId() + "");

        // 从缓存中取接口调用凭证
        String key = MgHdRedisKeyEnums.WECHAT_ACCESS_TOKEN_KEY.getCacheKey();
        String accessToken = redisService.get(key);
        if (StringUtils.isEmpty(accessToken)) {
            accessToken = getWeChatAccessToken();
            redisService.set(key, accessToken, MgHdRedisKeyEnums.WECHAT_ACCESS_TOKEN_KEY.getExpireTime());
        }
        // 注册二维码
//        String path = "pages/pratake/pratake?userWelfareId=" + userWelfareMappingDo.getId();

        return userWelfareMappingDo;
    }

    /**
     * 好友帮助用户助力对象初始化
     * @param commonUserInfoDo "好友"的user对象
     * @param helpCount 助力值
     * @param friendWelfareDo "我"的助力对象
     * @return
     */
    private HelpUserWelfareMappingDo setValue(CommonUserInfoDo commonUserInfoDo, Integer helpCount, UserWelfareMappingDo friendWelfareDo) {
        HelpUserWelfareMappingDo helpUserWelfareMappingDo = new HelpUserWelfareMappingDo();
        helpUserWelfareMappingDo.setCreateTime(new Date().getTime());
        helpUserWelfareMappingDo.setHelpCount(helpCount);
        helpUserWelfareMappingDo.setIsDelete(IsValidEnums.NO.getValue());
        helpUserWelfareMappingDo.setUserImg(commonUserInfoDo.getPersonImgUrlMin());
        helpUserWelfareMappingDo.setUserNickName(commonUserInfoDo.getNickName());
        helpUserWelfareMappingDo.setUserUniId(commonUserInfoDo.getSysUniId());
        helpUserWelfareMappingDo.setWelfareNumber(friendWelfareDo.getWelfareNumber());
        helpUserWelfareMappingDo.setHelpUserId(friendWelfareDo.getUserUniId());
        return helpUserWelfareMappingDo;
    }

    /**
     * 获取微信access_token
     * @return
     */
    public String getWeChatAccessToken() {
        String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + wechatAppId +
                "&secret=" + wechatAppSecret;

        String result = HttpClientUtil.doGet(url);

        JSONObject jsonObject = JSONObject.parseObject(result);

        String token = jsonObject.getString("access_token");

        return token;
    }

    /**
     * 获取二维码路径
     * @return
     */
    public String getQRcode(String accessToken, String userWelfareId) {
        String url="https://api.weixin.qq.com/cgi-bin/wxaapp/createwxaqrcode?access_token=" + accessToken +
                "&path=pages/pratake/pratake?userWelfareId=" + userWelfareId;

        String result = HttpClientUtil.doPost(url);

        JSONObject jsonObject = JSONObject.parseObject(result);

        String token = jsonObject.getString("access_token");

        return token;
    }
}
