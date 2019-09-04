package com.hndl.cn.pay.sys.business.apple.service.impl;

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
import com.hndl.cn.dao.pay.bean.PaySysTradeDo;
import com.hndl.cn.mongodb.manager.pay.manager.ApppleCallExceptionLogManager;
import com.hndl.cn.mysql.manager.pay.manager.PaySysTradeManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.pay.sys.business.apple.service.ApplePayService;
import com.hndl.cn.base.enums.pay.ApplePayProductEnums;
import com.hndl.cn.pay.sys.constants.PaySysConstants;
import com.hndl.cn.pay.sys.exception.PaySysException;
import com.hndl.cn.pay.sys.exception.PaySysExceptionEnums;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/6/26 11:52
 * @Created by 湖南达联
 */
@Service
public class ApplePayServiceImpl implements ApplePayService {

    private static final Long APPLE_PAY_DATA_ID = 3L;

    private static final Logger log = LoggerFactory.getLogger(ApplePayServiceImpl.class);

    private ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    @Resource
    private PaySysTradeManager paySysTradeManager;

    @Resource
    private ApppleCallExceptionLogManager apppleCallExceptionLogManager;

    @Resource
    private RedisService redisService;

    @Value("${apple.pay.sandbox.url}")
    private String sandBoxUrl;

    @Value("${apple.pay.buy.url}")
    private String buyUlr;

    @Value("${apple.pay.business.notice.pay.url}")
    private String noticePayUrl;

    @Value("${aplle.pay.auth.user.id}")
    private String authUserId;

    @Value("${is_pay_test}")
    private String isPayTest;

    @Override
    public Result<Object> preOrderByApplePay(Long userUniId, ApplePayProductEnums orderNum) {

        long nextOrderId = iSnowflakeIdService.nextOrderId(APPLE_PAY_DATA_ID);

        paySysTradeManager.insertApplePayTrade(userUniId,nextOrderId,null,orderNum.getOrderNum(),String.valueOf(orderNum.getActualSum()));

        return ResultFactory.success(nextOrderId);
    }

    @Override
    public Result<Object> confirmOfOrder(Long userUniId,Long orderId,String data) {

        PaySysTradeDo tradeByLocalTradeNo = paySysTradeManager.findTradeByLocalTradeNo(orderId, PayChannelEnums.APPLE_PAY);

        if(tradeByLocalTradeNo == null){
               throw new PaySysException(PaySysExceptionEnums.EX_PAY_IS_NOT_FIND.getCode());
        }

        if(tradeByLocalTradeNo.getPayState().equals(PayStatusEnum.FAIL_PAY.getCode())
           ||tradeByLocalTradeNo.getPayState().equals(PayStatusEnum.PAY.getCode())){
            throw new PaySysException(PaySysExceptionEnums.EX_PAY_STATUS_IS_NOT_FIND.getCode());
        }



        String payNoticeDtoKey = RedisPayKey.getPayNoticeRedisKey(PayChannelEnums.APPLE_PAY.getChannelType(),Long.valueOf(tradeByLocalTradeNo.getLocalTradeNo()));

        //存储数据日志

        JSONObject object = new JSONObject();

        object.put("receipt-data",data);

        String url = buyUlr;

        if(Long.valueOf(authUserId).equals(userUniId) || Boolean.valueOf(isPayTest)){
            url = sandBoxUrl;
        }


        String result = HttpClientUtil.doPostJson(url, object.toJSONString());

//        log.info("apple pay result : {}",result);

        if(StringUtils.isBlank(result)){
            log.info("http请求时候返回数据为空：orderId=>{} \n data=>{}",orderId,data);
            //插入苹果回调异常日志
            apppleCallExceptionLogManager.insertApppleCallLog(userUniId,orderId,data);

            throw new PaySysException(PaySysExceptionEnums.EX_PAY_CHECK_ORDER.getCode());
        }


        JSONObject resultObj = JSONObject.parseObject(result);
        //订单状态
        String status = resultObj.getString("status");

        if(!PaySysConstants.APPLE_PAY_SUCCESS.equals(status)){
            throw new PaySysException(PaySysExceptionEnums.EX_PAY_CHECK_ORDER.getCode());
        }

        JSONObject receipt = resultObj.getJSONObject("receipt");

        if(receipt == null){
            log.info("receipt is null!orderId=>{} \n data=>{}",orderId,data);
            //插入苹果回调异常日志
            apppleCallExceptionLogManager.insertApppleCallLog(userUniId,orderId,data);
            throw new PaySysException(PaySysExceptionEnums.EX_PAY_CHECK_ORDER.getCode());
        }

        String inApp = receipt.getString("in_app");

        if(StringUtils.isBlank(inApp)){
            log.info("in_app has bank!orderId=>{} \n data=>{}",orderId,data);
            //插入苹果回调异常日志
            apppleCallExceptionLogManager.insertApppleCallLog(userUniId,orderId,data);

            throw new PaySysException(PaySysExceptionEnums.EX_PAY_CHECK_ORDER.getCode());
        }

        List<HashMap> hashMaps = JSONObject.parseArray(inApp, HashMap.class);

        if(hashMaps == null  || hashMaps.isEmpty()){
            log.info("in_app parse error! orderId=>{} \n data=>{}",orderId,data);
            //插入苹果回调异常日志
            apppleCallExceptionLogManager.insertApppleCallLog(userUniId,orderId,data);

            throw new PaySysException(PaySysExceptionEnums.EX_PAY_CHECK_ORDER.getCode());
        }

        boolean isPay = false;

        for(HashMap map : hashMaps){
            String transactionId = (String)map.get("transaction_id");
                String productId = (String)map.get("product_id");
                //处理充值的逻辑
                ApplePayProductEnums enumsByProductId = ApplePayProductEnums.getEnumsByProductId(productId);
                if(enumsByProductId == null){
                    continue;
                }
                //订单支付与实际一致
                if(tradeByLocalTradeNo.getMoneyNumber().equals(enumsByProductId.getOrderNum())){

                    PayNoticeDto payNoticeDto = PayNoticeDto.builder().payUserId(tradeByLocalTradeNo.getCreateUserId()).payChannel(tradeByLocalTradeNo.getPayChannel())
                            .payTime(System.currentTimeMillis()).coinCount(tradeByLocalTradeNo.getMoneyNumber()).remoteTradeNo(transactionId)
                            .localTradeNo(tradeByLocalTradeNo.getLocalTradeNo()).build();

                    redisService.set(payNoticeDtoKey,payNoticeDto,RedisPayKey.OUT_TIME);

                    String businessResult = HttpClientUtil.doGet(noticePayUrl+tradeByLocalTradeNo.getLocalTradeNo());

                    Result resultDo = JSONObject.parseObject(businessResult,Result.class);

                    if(resultDo == null){
                        log.info("businessResult has null orderId=>{} \n data=>{}",orderId,data);
                        throw new PaySysException(PaySysExceptionEnums.EX_PAY_CHECK_ORDER.getCode());
                    }

                    //成功后
                    if(PublicExceptionCodeEnum.SUCCESS.getCode().equals(resultDo.getCode()) ||
                            PublicExceptionCodeEnum.EX_EXCESSIVE_ATTEMPTS.getCode().equals(resultDo.getCode())   ){
                        //修改订单状态
                        isPay  = paySysTradeManager.updatePayState(tradeByLocalTradeNo.getLocalTradeNo(),transactionId,
                                PayChannelEnums.APPLE_PAY,PayStatusEnum.PAY);

                        //修改成功
                        if(!isPay){
                            throw new PaySysException(PaySysExceptionEnums.EX_PAY_CHECK_ORDER.getCode());
                        }
                        break;
                    }else {
                        paySysTradeManager.updatePayState(tradeByLocalTradeNo.getLocalTradeNo(),transactionId,
                                PayChannelEnums.APPLE_PAY,PayStatusEnum.FAIL_PAY);
                        break;
                    }
                }
        }

        //校验订单
        return isPay? ResultFactory.success(tradeByLocalTradeNo.getMoneyNumber()) : ResultFactory.failure() ;
    }


}
