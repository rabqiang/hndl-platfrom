package com.hndl.cn.pay.sys.business.ali.service.impl;

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
import com.hndl.cn.mysql.manager.pay.manager.PaySysTradeManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.pay.sys.business.ali.service.AliPayService;
import com.hndl.cn.pay.sys.constants.PaySysConstants;
import com.hndl.cn.pay.sys.init.AliPayConfig;
import com.hndl.cn.pay.sys.util.AliPayUtil;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.string.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Map;

/**
 * @author 赵俊凯
 * @Description TODO
 * @Date 2019/5/20 10:59
 * @Created by 湖南达联
 */
@Service
public class AliPayServiceImpl implements AliPayService {

    private static final Logger log = LoggerFactory.getLogger(AliPayServiceImpl.class);

    private static final Long ALI_PAY_DATA_ID = 2L;

    @Resource
    private AliPayConfig aliPayConfig;

    @Resource
    private PaySysTradeManager paySysTradeManager;

    @Resource
    private RedisService redisService;

    private ISnowflakeIdService iSnowflakeIdService = SnowflakeIdServiceImpl.INSTANCE;

    @Value("${is_pay_test}")
    private String test;



    @Override
    public Result<Object> preOrderByAliPay(Long userId, Long orderNumber) {

        //获取本地订单id
        Long orderId = iSnowflakeIdService.nextOrderId(ALI_PAY_DATA_ID);

        //如果开启测试模式
        String aliOrderNum = Boolean.valueOf(test) ? "0.01" : this.txfloat(orderNumber,100);

        String url = AliPayUtil.aliPay(aliPayConfig,orderId,userId,aliOrderNum);

        boolean flag = paySysTradeManager.insertPayTrade(userId,orderId,null,orderNumber,AliPayUtil.strDataToMap(url).get("sign"),PayChannelEnums.ALI_PAY);

        if(flag){
            return ResultFactory.success(url);
        }else {
            return ResultFactory.failure();
        }
    }

    @Override
    public String callBack(Map<String, String> map) {

        log.info(map.toString());

        String outTradeNo = map.get("out_trade_no");
        String tradeNo = map.get("trade_no");

        if(StringUtils.isBlank(outTradeNo) || StringUtils.isBlank(tradeNo)){
            //出现异常参数
            log.info("============ali pay map ================",map);
            return PaySysConstants.ALI_PAY_FAIL;
        }

        //校验是否存在
        PaySysTradeDo tradeByLocalTradeNo = paySysTradeManager.findTradeByLocalTradeNo(Long.valueOf(outTradeNo), PayChannelEnums.ALI_PAY);



        if(tradeByLocalTradeNo == null || tradeByLocalTradeNo.getPayState().equals(PayStatusEnum.PAY.getCode())){
            log.info("tradeByLocalTradeNo flag :  " + (tradeByLocalTradeNo == null || tradeByLocalTradeNo.getPayState().equals(PayStatusEnum.PAY.getCode())));
            return PaySysConstants.ALI_PAY_SUCCESS;
        }

        if(!map.get("app_id").equals(aliPayConfig.getAppId())){
            log.info("app_id flag : "+ !map.get("app_id").equals(aliPayConfig.getAppId()));
            return PaySysConstants.ALI_PAY_FAIL;
        }

        //校验金额 测试模式下不校验
        if(!map.get("total_amount").equals(this.txfloat(tradeByLocalTradeNo.getMoneyNumber(),100))
                &&!Boolean.valueOf(test)){
            log.info("app_id flag : "+ (!map.get("total_amount").equals(this.txfloat(tradeByLocalTradeNo.getMoneyNumber(),100))));
            return PaySysConstants.ALI_PAY_FAIL;
        }

        String payNoticeDtoKey = RedisPayKey.getPayNoticeRedisKey(PayChannelEnums.ALI_PAY.getChannelType(),Long.valueOf(outTradeNo));

        PayNoticeDto payNoticeDto = PayNoticeDto.builder().payUserId(tradeByLocalTradeNo.getCreateUserId()).payChannel(tradeByLocalTradeNo.getPayChannel())
                .payTime(new Date().getTime()).coinCount(tradeByLocalTradeNo.getMoneyNumber()).remoteTradeNo(tradeNo)
                .localTradeNo(tradeByLocalTradeNo.getLocalTradeNo()).build();

        redisService.set(payNoticeDtoKey,payNoticeDto,RedisPayKey.OUT_TIME);

//        log.info("ali pay url " + aliPayConfig.getBusinessPayNoticeUrl()+outTradeNo);

        String businessResult = HttpClientUtil.doGet(aliPayConfig.getBusinessPayNoticeUrl()+outTradeNo);

        Result resultDo = JSONObject.parseObject(businessResult,Result.class);

        if(resultDo == null){
           return PaySysConstants.ALI_PAY_FAIL;
        }

        boolean isPay = false;
        //成功后
        if(PublicExceptionCodeEnum.SUCCESS.getCode().equals(resultDo.getCode()) ||
                PublicExceptionCodeEnum.EX_EXCESSIVE_ATTEMPTS.getCode().equals(resultDo.getCode())   ){
            //修改订单状态
            isPay  = paySysTradeManager.updatePayState(Long.valueOf(outTradeNo),tradeNo,PayChannelEnums.ALI_PAY,PayStatusEnum.PAY);

            //修改成功
            if(isPay){
                return  PaySysConstants.WECHAT_PAY_RESPONSE_SUCCESS;
            }
        }else {
            //修改订单状态
            isPay  = paySysTradeManager.updatePayState(Long.valueOf(outTradeNo),tradeNo,PayChannelEnums.ALI_PAY,PayStatusEnum.FAIL_PAY);
            //修改成功
            if(isPay){
                return  PaySysConstants.WECHAT_PAY_RESPONSE_SUCCESS;
            }
        }
        return PaySysConstants.ALI_PAY_FAIL;
    }

    public String txfloat(Long a,Integer b) {
        DecimalFormat df=new DecimalFormat("0.00");//设置保留位数

        return df.format((float)a/b);

    }

    public static void main(String[] args) {
        AliPayServiceImpl aliPayService = new AliPayServiceImpl();
        String txfloat = aliPayService.txfloat(600L, 10000);
        System.out.println(txfloat);

    }

}
