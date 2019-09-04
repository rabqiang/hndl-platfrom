package com.hndl.cn.pay.sys.business.wechat.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.dto.pay.PayNoticeDto;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayStatusEnum;
import com.hndl.cn.base.plugin.snowflakeid.service.ISnowflakeIdService;
import com.hndl.cn.base.plugin.snowflakeid.service.impl.SnowflakeIdServiceImpl;
import com.hndl.cn.base.redis.pay.RedisPayKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.common.bean.CommonUserInfoDo;
import com.hndl.cn.dao.pay.bean.PaySysTradeDo;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.mysql.manager.pay.manager.PaySysTradeManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.pay.sys.business.wechat.service.WechatPayService;
import com.hndl.cn.pay.sys.constants.PaySysConstants;
import com.hndl.cn.pay.sys.exception.PaySysException;
import com.hndl.cn.pay.sys.exception.PaySysExceptionEnums;
import com.hndl.cn.pay.sys.init.WeChatPayConfig;
import com.hndl.cn.pay.sys.init.WechatAppletsPayConfig;
import com.hndl.cn.pay.sys.util.WeChatPayUtil;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;

/**
 * @Classname 赵俊凯
 * @Description TODO
 * @Date 2019/4/11 19:41
 * @Created by 湖南达联
 */
@Service
public class WechatPayServiceImpl implements WechatPayService {

    private static final Logger log = LoggerFactory.getLogger(WechatPayServiceImpl.class);

    @Resource
    private WeChatPayConfig weChatPayConfig;


    @Resource
    private PaySysTradeManager paySysTradeManager;

    @Resource
    private RedisService redisService;

    private ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    @Resource
    private WechatAppletsPayConfig wechatAppletsPayConfig;

    @Resource
    private CommonUserInfoManager commonUserInfoManager;


    @Value("${is_pay_test}")
    private String test;

    @Value("${wechat.subscription.app.id}")
    private String subscriptionAppId;

    private static final Long WECHAT_PAY_DATA_ID = 1L;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Result<Object> preOrderByWechatPay(Long userId,Long orderNumber) {
        //获取本地订单id
        Long orderId = iSnowflakeIdService.nextOrderId(WECHAT_PAY_DATA_ID);

        Long orderMoney = Boolean.valueOf(test) ? 1L: orderNumber;

        //1调用wechat 生成预支付订单
        Map<String, String> preyMap = WeChatPayUtil.getPreyId(String.valueOf(userId), String.valueOf(orderId), String.valueOf(orderMoney), weChatPayConfig);

        this.initWechatPayOrder(preyMap,userId,orderId,orderNumber);

        return ResultFactory.success(preyMap);
    }

    @Override
    public Result<Object> preOrderByWechatAppletsPay(Long userId, Long orderNumber, String openId) {

        //获取本地订单id
        Long orderId = iSnowflakeIdService.nextOrderId(WECHAT_PAY_DATA_ID);

        Long orderMoney = Boolean.valueOf(test) ? 1L: orderNumber;

        //1调用wechat 生成预支付订单
        Map<String, String> preyMap = WeChatPayUtil.getPreyIdApplets(String.valueOf(userId), String.valueOf(orderId), String.valueOf(orderMoney), openId,wechatAppletsPayConfig);

        this.initWechatPayOrder(preyMap,userId,orderId,orderNumber);

        return ResultFactory.success(preyMap);
    }

    @Override
    public Result<Object> preOrderByWechatSubscriptionPay(Long userOldId, Long orderNumber, String openId) {

        CommonUserInfoDo userByUserId = commonUserInfoManager.findUserByUserId(userOldId);

        if(userByUserId == null){
            throw new PaySysException(PublicExceptionCodeEnum.EX_USER_NOT_EXIST.getCode());
        }

        //获取本地订单id
        Long orderId = iSnowflakeIdService.nextOrderId(WECHAT_PAY_DATA_ID);

        Long orderMoney = Boolean.valueOf(test) ? 1L: orderNumber;

        //1调用wechat 生成预支付订单
        Map<String, String> preyMap = WeChatPayUtil.getPreyIdSubscription(String.valueOf(userByUserId.getSysUniId()), String.valueOf(orderId), String.valueOf(orderMoney), openId,wechatAppletsPayConfig,subscriptionAppId);

        this.initWechatPayOrder(preyMap,userByUserId.getSysUniId(),orderId,orderNumber);

        return ResultFactory.success(preyMap);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String callBack(Map<String,String> map) {

        String payNoticeDtoKey = "";
            log.info("微信回调result_data" + map.toString());
//            log.info("回调是否成功:" + map.get("result_code").equals(PaySysConstants.WECHAT_PAY_RESPONSE_SUCCESS));

            if (!map.get("result_code").equals(PaySysConstants.WECHAT_PAY_RESPONSE_SUCCESS)) {
                return PaySysConstants.WECHAT_PAY_RESPONSE_FAIL;
            }
//

            String appId = map.get("appid");

            log.info("appid : " + appId);

            if(StringUtils.isEmpty(appId)){
                throw new PaySysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
            }

            String secret = null;

            if(appId.equals(weChatPayConfig.getAppId())){
                secret = weChatPayConfig.getAppPrivateKey();
            }

//            log.info(appId.equals(weChatPayConfig.getAppId())  + "====" +appId.equals(wechatAppletsPayConfig.getAppPrivateKey()));

            if(appId.equals(wechatAppletsPayConfig.getAppId()) || appId.equals(subscriptionAppId)){
                secret = wechatAppletsPayConfig.getAppPrivateKey();
            }


            log.info("secret == " + secret);

            if(StringUtils.isEmpty(secret)){
                throw new PaySysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
            }



            if(!WeChatPayUtil.isSignatureValid(map,secret)){
                throw new PaySysException(PublicExceptionCodeEnum.EX_ILLEGAL_REQUEST.getCode());
            }
//
//            map.remove("sign");
            String localTradeNo = map.get("out_trade_no"); // 存疑


            PaySysTradeDo tradeByLocalTradeNo = paySysTradeManager.findTradeByLocalTradeNo(
                    Long.valueOf(localTradeNo), PayChannelEnums.WECHAT_PAY);

            if(tradeByLocalTradeNo == null){
//                log.info("sign =====" + map.get("sign"));
                 return PaySysConstants.WECHAT_PAY_RESPONSE_FAIL;
            }

            if(tradeByLocalTradeNo.getPayState().equals(PayStatusEnum.PAY.getCode())){
                return PaySysConstants.WECHAT_PAY_RESPONSE_SUCCESS;
            }


            payNoticeDtoKey = RedisPayKey.getPayNoticeRedisKey(PayChannelEnums.WECHAT_PAY.getChannelType(),Long.valueOf(localTradeNo));


                //如果 服务突然挂了，微信重试，不会去通知业务系统
                if(PayStatusEnum.PAY.getCode().equals(tradeByLocalTradeNo.getPayState())){
                    return PaySysConstants.WECHAT_PAY_RESPONSE_SUCCESS;
                }

                log.info("=============支付成功,微信订单号: "+ tradeByLocalTradeNo.getRemoteTradeNo() +",tradeByLocalTradeNo:"+ localTradeNo+"=====================");

                PayNoticeDto payNoticeDto = PayNoticeDto.builder().payUserId(tradeByLocalTradeNo.getCreateUserId()).payChannel(tradeByLocalTradeNo.getPayChannel())
                        .payTime(new Date().getTime()).coinCount(tradeByLocalTradeNo.getMoneyNumber()).remoteTradeNo(tradeByLocalTradeNo.getRemoteTradeNo())
                        .localTradeNo(tradeByLocalTradeNo.getLocalTradeNo()).build();

                //把支付订单数存入redis
                redisService.set(payNoticeDtoKey,payNoticeDto,RedisPayKey.OUT_TIME);

//                log.info("BusinessPayNoticeUrl : " + weChatPayConfig.getBusinessPayNoticeUrl()+localTradeNo);
                //这里要通知业务系统订单已经完成，并生成流水号
                String businessResult = HttpClientUtil.doGet(weChatPayConfig.getBusinessPayNoticeUrl()+localTradeNo);

                Result resultDo = JSONObject.parseObject(businessResult,Result.class);

                if(resultDo == null){
                    return PaySysConstants.ALI_PAY_FAIL;
                }
                boolean isPay = false;
                //这里如果操作成功，或者返回尝试次数过多时,就应该通知微信这个订单已经完成
                if(resultDo.getCode().equals(PublicExceptionCodeEnum.SUCCESS.getCode()) ||
                        PublicExceptionCodeEnum.EX_EXCESSIVE_ATTEMPTS.getCode().equals(resultDo.getCode())){
                    //修改订单状态
                    isPay  = paySysTradeManager.updatePayState(Long.valueOf(localTradeNo),null,PayChannelEnums.WECHAT_PAY,PayStatusEnum.PAY);

                }else {
                     isPay = paySysTradeManager.updatePayState(Long.valueOf(localTradeNo),null,PayChannelEnums.WECHAT_PAY,PayStatusEnum.FAIL_PAY);
                }

                //修改成功
                if(isPay){
                    return  PaySysConstants.WECHAT_PAY_RESPONSE_SUCCESS;
                }
        return PaySysConstants.WECHAT_PAY_RESPONSE_FAIL;
    }


    private void initWechatPayOrder(Map<String,String> preyMap,Long userId,Long orderId,Long orderNumber){
        //异常回滚
        if(StringUtils.isBlank(preyMap.get("prepayid"))){
            log.error("====================订单生成失败：prepayid == {} ======================",preyMap.get("prepayid"));
            throw new PaySysException(PaySysExceptionEnums.EX_PRE_ORDER_WECAHT_ERROR.getCode());
        }

//        log.info("[orderNumber" + orderNumber + "=========,is_pay_test======="+ test  + "]");

        //2系统内生成预下单订单
        boolean flag = paySysTradeManager.insertPayTrade(userId,orderId,preyMap.get("prepayid"),orderNumber,preyMap.get("sign"),PayChannelEnums.WECHAT_PAY);

        if(!flag){
            log.error("====================订单生成失败：localTradeNo == {} ======================",orderId);
            throw new PaySysException(PaySysExceptionEnums.EX_PRE_ORDER_WECAHT_ERROR.getCode());
        }

//        log.info("==========预下单成功 ：localTradeNo: "+ orderId +", prepayid : "+ preyMap.get("prepayid") + "===============");

    }

    public static void main(String[] args) {
//        String str = "transaction_id=4200000384201907256946320787, nonce_str=9TUODXj13wwxwfmsGAQdE894trkQTJdB, bank_type=CMB_DEBIT, openid=ouFc75EHGEyD-28ssN1pGe8xuwNI, sign=CC76621094747AAF1CE4B5D02015173C, fee_type=CNY, mch_id=1528644711, cash_fee=1, out_trade_no=272650191100895232, appid=wx4b09491c12b811cd, total_fee=1, trade_type=JSAPI, result_code=SUCCESS, attach=237121822057963520, time_end=20190725175438, is_subscribe=N, return_code=SUCCESS";
//        String key = "hunandalian7788hunandalian778899";
//        String[] split = str.split(",");
//        String sign = null;
//        Map<String,String> map = new HashMap<>();
//        for(String string : split ){
//            String[] split1 = string.split("=");
//            map.put(split1[0].trim(),split1[1]);
//        }
//        sign = map.get("sign");
////        System.out.println(map);
//        String sign1 = WeChatPayUtil.getSign(map, key);
//        System.out.println(sign1);
//        System.out.println(sign.equals(sign1));
//        System.out.println(WeChatPayUtil.isSignatureValid(map,key));

////        map.remove("sign");
//        sign = map.get("sign");
//        String sign1 = WeChatPayUtil.getSign(map, key);
//        System.out.println(sign1);
//        sign.equals(sign1);
//
//
//        System.out.println(map);
        String str= "wx4b09491c12b811cd";
        String str1 = "wxadec0d21568ce3dc";
        String str2 = "wx4b09491c12b811cd";
        System.out.println(str.equals(str1) + " ====== "  + str.equals(str2));
    }
}
