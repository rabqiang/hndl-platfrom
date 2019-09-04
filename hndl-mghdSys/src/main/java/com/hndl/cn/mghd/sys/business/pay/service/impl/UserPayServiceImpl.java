package com.hndl.cn.mghd.sys.business.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.dto.pay.PayNoticeDto;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayReasonType;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.lock.RedisLockKey;
import com.hndl.cn.base.redis.pay.RedisPayKey;
import com.hndl.cn.base.redis.user.UserInfoKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.mghd.sys.business.pay.service.UserPayService;
import com.hndl.cn.mghd.sys.common.constants.MghdSysConstants;
import com.hndl.cn.mghd.sys.exception.MghdSysException;
import com.hndl.cn.mghd.sys.exception.MghdSysExceptionEnums;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.number.CoinUtils;
import com.hndl.cn.utils.request.RequestUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author 赵俊凯
 * @Description 用户支付的service impl
 * @Date 2019/4/22 11:53
 * @Created by 湖南达联
 */
@Service
public class UserPayServiceImpl implements UserPayService {

    private static final Logger log = LoggerFactory.getLogger(UserPayServiceImpl.class);

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private HappyCoinBillInfoManger happyCoinBillInfoManger;

    @Resource
    private RedisService redisService;

    @Resource
    private UserStatisticsDoManager userStatisticsDoManager;

    //用户积分
    @Resource
    private UserIntegralLogManager userIntegralLogManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Object> confirmPayNotice(Integer payChannel,Long localTradeNo) {

        //获取redis key
        String payNoticeDtoKey = RedisPayKey.getPayNoticeRedisKey(payChannel,Long.valueOf(localTradeNo));
        String payLockKey = null;
        try{
            PayNoticeDto payNoticeDto = redisService.get(payNoticeDtoKey);

            log.info(JSONObject.toJSONString(payNoticeDto));

            //如果没有到通知，则是否是支付系统异常或者是 有异常调用
            if(!RequestUtil.isFieldNull(payNoticeDto)){
                log.error("=====================发现异常调用localTradeNo:{}=================================",localTradeNo);
                throw new MghdSysException(PublicExceptionCodeEnum.EX_OPERATION_FAIL.getCode());
            }

            if(happyCoinBillInfoManger.checkRemoteTradeNoAndPayChannel(payNoticeDto.getRemoteTradeNo(),PayChannelEnums.WECHAT_PAY)) {
                log.error("=====================订单已经被消费RemoteTradeNo {}=================================",payNoticeDto.getRemoteTradeNo());
                throw new MghdSysException(PublicExceptionCodeEnum.EX_EXCESSIVE_ATTEMPTS.getCode());
            }

            //校验用户是否存在
            CommonUserInfoDo userByUniId = commonUserInfoManager.findUserByUniId(payNoticeDto.getPayUserId());

            if(userByUniId == null){
                log.error("=====================充值用户不存在:{}=================================",payNoticeDto.getPayUserId());
                throw new MghdSysException(PublicExceptionCodeEnum.EX_USER_NOT_EXIST.getCode());
            }

            payLockKey =  RedisLockKey.builderRedisKey(BaseConstants.PAY_NOTICE_LOCK_PACKAGE_KEY,payNoticeDto.getPayChannel(),localTradeNo);

            //这里加个分布式锁防止并发内被穿透
            boolean isLock = redisService.setNX(payLockKey,RedisLockKey.DEFAULT_VALUE, MghdSysConstants.PAY_SYS_NOTICE_LOCK_TIME);

            if(!isLock){
                log.info("================== payLockKey : "+ payLockKey+",isLock : "+isLock+"===================");
                throw new MghdSysException(PublicExceptionCodeEnum.EX_EXCESSIVE_ATTEMPTS.getCode());
            }


            HappyCoinBillInfoDo happyCoinBillInfoDo = new HappyCoinBillInfoDo();
            happyCoinBillInfoDo.setCreateUserId(payNoticeDto.getPayUserId());
            happyCoinBillInfoDo.setCreateTime(payNoticeDto.getPayTime() == null ? new Date() : new Date(payNoticeDto.getPayTime()));
            happyCoinBillInfoDo.setCoinCount(payNoticeDto.getCoinCount());
            happyCoinBillInfoDo.setIsPay(IsValidEnums.NO.getValue());
            happyCoinBillInfoDo.setLocalTradeNo(payNoticeDto.getLocalTradeNo());
            happyCoinBillInfoDo.setPayType(payNoticeDto.getPayChannel());
            happyCoinBillInfoDo.setRemoteTradeNo(payNoticeDto.getRemoteTradeNo());
            happyCoinBillInfoDo.setReasonType(PayReasonType.HAPPY_COIN_PAY.getReasonType());
            happyCoinBillInfoDo.setReasonObjId(PayReasonType.HAPPY_COIN_PAY_ID);
            //这里需要转为分
            Long oldCoin = CoinUtils.doubleConvertLong(userByUniId.getConiCount());
            happyCoinBillInfoDo.setOldCoinCount(oldCoin);
            happyCoinBillInfoDo.setNewCoinCount(oldCoin + payNoticeDto.getCoinCount());
            //保存用户流水记录
            happyCoinBillInfoManger.insertSelective(happyCoinBillInfoDo);


            boolean flag = commonUserInfoManager.increaseCoinByUserUinId(userByUniId.getSysUniId(),CoinUtils.longConvertDouble(payNoticeDto.getCoinCount()));

            if(!flag){
                log.error("===================用户添加快乐币异常 payNoticeDto : {} ========================",JSONObject.toJSONString(payNoticeDto));
                throw new MghdSysException(MghdSysExceptionEnums.MGHD_SYS_PAY_COIN_EXCEPTION.getCode());
            }

            //是否需要刷新用户缓存，待定

            //1 直接加积分
            //userStatisticsDoManager.userStatisticsAddIntegralCount(payNoticeDto.getPayUserId(),payNoticeDto.getCoinCount()/10,IsValidEnums.NO);

            //生成用户积分日志
           // userIntegralLogManager.insertUserIntegralLog(payNoticeDto.getPayUserId(),IsValidEnums.YES,
                  //  UserDayEmpiricalTypeEnums.PAY_TASK.getTaskType(),payNoticeDto.getCoinCount().intValue()/10);

            String key = UserInfoKey.getUserInfoCacheKey(userByUniId.getSysUniId());

            userByUniId.setConiCount(CoinUtils.longConvertDouble(oldCoin + payNoticeDto.getCoinCount()));

            redisService.set(key,userByUniId,UserInfoKey.OUT_TIME);

            //8 加用户经验并生成记录
//            userNormalityTaskService.userDayTypeGetEmpirical(userInfoDo.getSysUniId(),UserDayEmpiricalTypeEnums.INTEGRAL_TASK);

            //充值成功打印日志记录一下,这里用警告来区分
            log.warn("================用户: "+userByUniId.getSysUniId()+",成功充值:"+ payNoticeDto.getCoinCount() /100 +" 快乐币=====================");

        }finally {
            redisService.del(payNoticeDtoKey);
            if(StringUtils.isNotBlank(payLockKey)){
                boolean flag = redisService.del(payLockKey);
                log.info("==================payLockKey删除：{}=========================",flag);
            }
        }



        return ResultFactory.success();
    }

    @Override
    public Result<Object> userPayConfirm(Long localTradeNo,Long userUniId) {

        HappyCoinBillInfoDo byLocalTradeNo = happyCoinBillInfoManger.findByLocalTradeNo(localTradeNo, userUniId);

        if(byLocalTradeNo == null){
              ResultFactory.failure(PublicExceptionCodeEnum.EX_PAY_NOT_FINISHED.getCode(),
                      PublicExceptionCodeEnum.EX_PAY_NOT_FINISHED.getMsg());
        }
        return ResultFactory.success(byLocalTradeNo.getNewCoinCount());
    }
}
