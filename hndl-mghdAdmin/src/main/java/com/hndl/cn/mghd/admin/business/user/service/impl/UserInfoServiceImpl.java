package com.hndl.cn.mghd.admin.business.user.service.impl;

import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayReasonType;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.base.redis.user.UserInfoKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.admin.business.user.service.UserInfoService;
import com.hndl.cn.mghd.admin.business.user.vo.CommonUserVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.task.bean.UserDayTaskDo;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserStatisticsDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.mobile.MobileUtil;
import com.hndl.cn.utils.number.LevelUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/19 17:59
 * @Created by 湖南达联
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {
    private static final Logger log = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    private static final Long DATA_ID = 4L;
    @Resource
    CommonUserInfoManager commonUserInfoManager;
    @Resource
    UserStatisticsDoManager userStatisticsDoManager;
    @Resource
    UserDayTaskManager userDayTaskManager;
    @Resource
    UserIntegralLogManager userIntegralLogManager;

    @Resource
    HappyCoinBillInfoManger happyCoinBillInfoManger;

    @Resource
    RedisService redisService;

    ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    /**
     * @param commonUserInfoDo 查询的条件
     * @param pageNo           分页
     * @return
     */
    @Override
    public Result<Object> findUserInByLimit(CommonUserInfoDo commonUserInfoDo, Integer pageNo) {

        List<CommonUserVo> userInfoVoList = new ArrayList<>();
        List<CommonUserInfoDo> list = commonUserInfoManager.getUserAll(commonUserInfoDo, Long.valueOf(pageNo), BaseConstants.DEFAULT_LIMIT);
        Long sum = commonUserInfoManager.getUserSum(commonUserInfoDo);
        if (list == null) {
            return null;
        }
        for (CommonUserInfoDo userInfoDo : list) {
            CommonUserVo vo = new CommonUserVo();
            UserStatisticsDo userUinId = userStatisticsDoManager.findUserStatisticsByUserUinId(userInfoDo.getSysUniId());
            if (userUinId == null) userUinId = new UserStatisticsDo();
            vo.setId(userInfoDo.getId());                                                           //用户快乐号
            vo.setUserId(userInfoDo.getSysUniId());                                                 //用户uniId
            vo.setUserName(userInfoDo.getNickName());                                               //用户昵称
            vo.setCreateTime(userInfoDo.getCreateTime().getTime());                                 //用户创建时间
            vo.setNetType(userInfoDo.getNetType());                                                 //运营商
            vo.setCellPhoneNumber(MobileUtil.validatePhoneNum(userInfoDo.getPhoneNum()));           //用户手机号
            vo.setConiCount(userInfoDo.getConiCount().longValue());                                 //用户快乐币
            vo.setIntegral(userUinId.getIntegralCount());                                           //用户积分数
            vo.setImgUrl(userInfoDo.getPersonImgUrlMin());                                          //用户头像
            vo.setAppType(userInfoDo.getAppType());                                                 //手机类型
            vo.setPhoneName(userInfoDo.getPhoneName());                                             //手机型号
            vo.setUmengChannel(userInfoDo.getUmengChannel());                                       //渠道标识
            //判断如果获取的经验值为空就重新个默认值,重新设置经验值
            if (userUinId.getEmpirical() == null) userUinId.setEmpirical(0L);
            vo.setEmpirical(userUinId.getEmpirical());                                              //用户经验值
            vo.setUserLevel(LevelUtil.getContributionLevel(userUinId.getEmpirical().intValue()));   //用户等级
            //判断用户是从第三方那个登陆进来的
            if (userInfoDo.getWeixinOpenId() != null) {
                vo.setPartyLogin("微信");
            } else if (userInfoDo.getQqOpenId() != null) {
                vo.setPartyLogin("QQ");
            } else if (userInfoDo.getWeiboOpenId() != null) {
                vo.setPartyLogin("微博");
            }
            //查询用户最近一次登陆时间
            UserDayTaskDo userLastLoginTime = userDayTaskManager.getUserLastLoginTime(userInfoDo.getSysUniId()); //最后登陆时间(最近进入时间)
            if (userLastLoginTime != null) {
                vo.setLastTime(userLastLoginTime.getCreateTime());
            }
            vo.setUserSum(sum);                                                                     //查询的用户总数
            userInfoVoList.add(vo);
        }
        return ResultFactory.success(userInfoVoList);
    }

    /**
     * 修改用户的积分值
     *
     * @param userUniId    用户id`
     * @param isValidEnums 是否减少(1.减少0,增加)
     * @param integral     积分值
     * @param integralText
     * @return
     */
    @Override
    public Result<Object> updateUserIntegral(Long userUniId, IsValidEnums isValidEnums, Long integral, String integralText) {
        //根据uinId查询获取用户信息
        UserStatisticsDo userUinId = userStatisticsDoManager.findUserStatisticsByUserUinId(userUniId);
        if (userUinId == null) {
            return null;
        }
        //判断是加积分还是减少积分
        if (IsValidEnums.YES.getValue().equals(isValidEnums) && userUinId.getIntegralCount() - integral < 0L) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_UPDATE_INTEGRAL_IS_NOT_LESS_ZERO.getCode());
        }
        if (IsValidEnums.YES.getValue().equals(isValidEnums)) {
            //获取减少后的积分数
            Long sum = userUinId.getIntegralCount() - integral;
            //判断减少后的积分大于等于0
            userStatisticsDoManager.userStatisticsAddIntegralCount(userUniId, integral, isValidEnums);
        } else {//添加积分数
            userStatisticsDoManager.userStatisticsAddIntegralCount(userUniId, integral, isValidEnums);
        }

        //因为在用户统计表与积分明细表的是否删除,是相反的所以需要判断
        if (isValidEnums.getValue().equals(IsValidEnums.YES.getValue())) {
            userIntegralLogManager.insertUserIntegralLog(userUniId, "0", IsValidEnums.NO, UserDayEmpiricalTypeEnums.SYSTEM_ADDITION.getTaskType(), integral.intValue());
        } else {
            userIntegralLogManager.insertUserIntegralLog(userUniId, "0", IsValidEnums.YES, UserDayEmpiricalTypeEnums.SYSTEM_ADDITION.getTaskType(), integral.intValue());
        }
        String key = UserInfoKey.getUserInfoCacheKey(userUniId);
        CommonUserInfoDo user = commonUserInfoManager.findUserByUniId(userUniId);
        redisService.set(key, user, UserInfoKey.OUT_TIME);

        return ResultFactory.success("操作成功");
    }

    /**
     * 修改用户的快乐币
     *
     * @param userUniId    用户id
     * @param isValidEnums 是否减少
     * @param coniCount    快乐币值
     * @return
     */
    @Override
    public Result<Object> updateUserConiCount(Long userUniId, IsValidEnums isValidEnums, Long coniCount) {
        //查询用户信息
        CommonUserInfoDo user = commonUserInfoManager.findUserByUniId(userUniId);
        if (user == null) return null;
        Long sum = 0L;//计算
        //用户操作是增加还是减少
        if (isValidEnums.getValue().equals(IsValidEnums.YES.getValue()) && user.getConiCount().longValue() - coniCount < 0) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_UPDATE_CONICOUNT_IS_NOT_LESS_ZERO.getCode());
        }

        if (isValidEnums.getValue().equals(IsValidEnums.YES.getValue())) {
            sum = user.getConiCount().longValue() - coniCount;
            //将信息保存到用户表中
            CommonUserInfoDo commonUserInfo = new CommonUserInfoDo();
            commonUserInfo.setSysUniId(userUniId);
            commonUserInfo.setConiCount(sum.doubleValue());
            commonUserInfoManager.updateUserInfo(commonUserInfo);
        } else {
            sum = user.getConiCount().longValue() + coniCount;
            CommonUserInfoDo commonUserInfo = new CommonUserInfoDo();
            commonUserInfo.setSysUniId(userUniId);
            commonUserInfo.setConiCount(sum.doubleValue());
            commonUserInfoManager.updateUserInfo(commonUserInfo);
        }

        HappyCoinBillInfoDo happyCoinBillInfoDo = new HappyCoinBillInfoDo();
        happyCoinBillInfoDo.setCreateTime(new Date());
        happyCoinBillInfoDo.setCoinCount(coniCount * 100);
        happyCoinBillInfoDo.setCreateUserId(userUniId);
        happyCoinBillInfoDo.setIsPay(isValidEnums.getValue());
        happyCoinBillInfoDo.setPayType(PayChannelEnums.HAPPY_SYS_PAY.getChannelType());
        happyCoinBillInfoDo.setOldCoinCount(user.getConiCount().longValue());
        user.setConiCount(sum.doubleValue());
        happyCoinBillInfoDo.setNewCoinCount(sum);
        happyCoinBillInfoDo.setReasonType(PayReasonType.HAPPY_SYSTEM_VOTE.getReasonType());
        //这里之前保存的是明星id,由于是后台不传
        happyCoinBillInfoDo.setReasonObjId("");
        happyCoinBillInfoDo.setLocalTradeNo(iSnowflakeIdService.nextOrderId(DATA_ID));
        happyCoinBillInfoDo.setRemoteTradeNo(PayChannelEnums.PAY_DEFAULT_ID);
        happyCoinBillInfoManger.insertSelective(happyCoinBillInfoDo);
        String key = UserInfoKey.getUserInfoCacheKey(userUniId);
        CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(userUniId);
        redisService.set(key, userByUniId, UserInfoKey.OUT_TIME);
        return ResultFactory.success();
    }

    @Override
    public Result<Object> addUserAllGetIntegral(Object[] userUniId, Long integral) {
        for (int i = 0; i < userUniId.length; i++) {
            CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(Long.parseLong(userUniId[i].toString()));
            if (userByUniId != null) {
                userStatisticsDoManager.userStatisticsAddIntegralCount(Long.parseLong(userUniId[i].toString()), integral, IsValidEnums.NO);
                userIntegralLogManager.insertUserIntegralLog(Long.parseLong(userUniId[i].toString()), "0", IsValidEnums.YES, UserDayEmpiricalTypeEnums.SYSTEM_ADDITION.getTaskType(), integral.intValue());
               //刷新用户缓存
                String key = UserInfoKey.getUserInfoCacheKey(Long.parseLong(userUniId[i].toString()));
                CommonUserInfoDo user = commonUserInfoManager.findUserByUniId(Long.parseLong(userUniId[i].toString()));
                redisService.set(key, user, UserInfoKey.OUT_TIME);
            } else {
                log.error("批量增加积分的用户:" + userUniId[i] + "不存在");
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_UPDATE_USER_INTEGRAL_IS_NULL.getCode());
            }
        }

        return ResultFactory.success();
    }

    @Override
    public Result<Object> userInfoSealNumber(Long userUniId, IsValidEnums isValidEnums) {
        CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(userUniId);
        if (userByUniId == null) {
            log.error("封号用户:" + userUniId + "不存在");
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_COLSE_USER_IS_NULL.getCode());
        }
        if (userByUniId.getIsDeleted().equals(isValidEnums.getOldValue())) {
            return ResultFactory.success("用户已经为此状态了");
        }
        userByUniId.setIsDeleted(isValidEnums.getOldValue());
        commonUserInfoManager.updateUserInfo(userByUniId);
        if (isValidEnums.getOldValue().equals(IsValidEnums.YES.getOldValue())) return ResultFactory.success("封号成功");
        else return ResultFactory.success("解封成功");
    }


}
