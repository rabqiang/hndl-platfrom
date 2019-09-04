package com.hndl.cn.mghd.admin.business.pay.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.hndl.cn.base.dto.pay.PayNoticeDto;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.PublicExceptionCodeEnum;
import com.hndl.cn.base.enums.pay.ApplePayProductEnums;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayStatusEnum;
import com.hndl.cn.base.redis.pay.RedisPayKey;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.pay.bean.PaySysTradeDo;
import com.hndl.cn.mghd.admin.business.pay.service.RepairOderService;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.pay.bean.AppleCallLogDo;
import com.hndl.cn.mongodb.manager.pay.manager.ApppleCallExceptionLogManager;
import com.hndl.cn.mysql.manager.pay.manager.PaySysTradeManager;
import com.hndl.cn.mysql.manager.pay.manager.RepairOrderLogManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import com.hndl.cn.utils.http.HttpClientUtil;
import com.hndl.cn.utils.string.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @program:hndl-platform
 * @description:TODO 补单
 * @author: 易成贤
 * @create: 2019/8/7 14:31
 * @Created by湖南达联
 **/
@Service
@Slf4j
public class RepairOderServiceImpl implements RepairOderService {
    /**
     * 默认的第三方订单号
     */
    private final String defaultRemoteTradeNo = "0";

    @Resource
    RepairOrderLogManager repairOrderLogManager;

    @Resource
    ApppleCallExceptionLogManager apppleCallExceptionLogManager;

    @Resource
    PaySysTradeManager paySysTradeManager;

    @Resource
    RedisService redisService;


    //private final String sandBoxUrl = "https://sandbox.itunes.apple.com/verifyReceipt";


    //private final String buyUlr = "https://buy.itunes.apple.com/verifyReceipt";
     private final String buyUlr = "https://sandbox.itunes.apple.com/verifyReceipt";

    @Value("${apple.pay.business.notice.pay.url}")
    private String noticePayUrl;


    /**
     * 自动补单
     *
     * @param userUniId
     * @param localOrder
     * @return
     */
    @Override
    public Result appleRepairOder(Long adminId, Long userUniId, Long localOrder, Integer isEnforcement, String remark) {
        if (repairOrderLogManager.existReplacementOder(userUniId, localOrder)) {
            //补单信息已存在
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_REPLACEMENT_ORDER_IS_EXIST_EXCEPTION.getCode());
        }

        PaySysTradeDo tradeByLocalTradeNo = paySysTradeManager.findTradeByLocalTradeNo(localOrder, PayChannelEnums.APPLE_PAY);

        if (null == tradeByLocalTradeNo) {
            //预下单信息每找到
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_PAYSYSTRADE_NOT_FIND_EXCEPTION.getCode());
        }


        if (!PayChannelEnums.APPLE_PAY.getChannelType().equals(tradeByLocalTradeNo.getPayChannel())) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_NOT_IS_APPLE_PAY_EXCEPTION.getCode());
        }

        IsValidEnums enums = IsValidEnums.evalVal(isEnforcement);
        if (null == enums) {
            throw new MghdAdminException(PublicExceptionCodeEnum.Ex_PARAM_ERROR.getCode());
        }
        if (IsValidEnums.YES.getValue().equals(isEnforcement)) {
            log.info("用户{}正在强制补单:本地订单号=>{}", adminId, localOrder);
            //修改订单状态并且发起请求增加用户快乐币
            updatePayState(tradeByLocalTradeNo, null, enums);
            //插入记录
            remark = remark + "[强制补单]";
            if (repairOrderLogManager.insertReplacementOder(adminId, localOrder, userUniId, remark) < 1) {
                //订单修改失败
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_PAYSYSTRADE_UPDATE_FAIL_EXCEPTION.getCode());
            }
            return ResultFactory.success();
        }

        log.info("用户{}正在普通补单:本地订单号=>{}", adminId, localOrder);
        //查询回调日志
        AppleCallLogDo appleCallLogDo = apppleCallExceptionLogManager.findApppleCallExceptionLog(userUniId, localOrder);


        if (null == appleCallLogDo || StringUtils.isBlank(appleCallLogDo.getReceiptData())) {
            //票据不存在
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_RECEIPTDATA_NOT_FIND_EXCEPTION.getCode());
        }


        if (!userUniId.equals(tradeByLocalTradeNo.getCreateUserId())) {
            log.info("苹果补单发现一条预下单uniId与异常的uniId不一致！预下单用户id：{},异常数据用户id：{}", userUniId, tradeByLocalTradeNo.getCreateUserId());
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_USER_NOT_EQUALLY_EXCEPTION.getCode());
        }

        if (PayStatusEnum.PAY.getCode().equals(tradeByLocalTradeNo.getPayState())) {
            //订单已是支付状态
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_ORDER_IS_PAY_EXCEPTION.getCode());
        }
        //调用请求查询json
        String json = sendHttpsCoon(userUniId, appleCallLogDo.getReceiptData());
        //分析json获取关键数据
        Map<String, String> resultMap = appleOrder(json,tradeByLocalTradeNo);
        //修改订单状态并且发起请求增加用户快乐币
        updatePayState(tradeByLocalTradeNo, resultMap, enums);
        //插入记录
        remark = remark + "[自动补单]";
        if (repairOrderLogManager.insertReplacementOder(adminId, localOrder, userUniId, remark) < 1) {
            //订单修改失败
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_PAYSYSTRADE_UPDATE_FAIL_EXCEPTION.getCode());
        }
        return ResultFactory.success();
    }


    /**
     * 发送请求获取数据
     *
     * @return
     */
    private String sendHttpsCoon(Long userUniId, String receiptData) {
        if (StringUtils.isBlank(receiptData)) {
            return null;
        }

        JSONObject object = new JSONObject();

        object.put("receipt-data", receiptData);

        String url = buyUlr;

        String result = HttpClientUtil.doPostJson(url, object.toJSONString());
        return result;
    }

    /**
     * 从苹果服务器返回的数据中解析所要的数据
     *
     * @param result
     * @return
     */
    private Map<String, String> appleOrder(String result,PaySysTradeDo paySysTradeDo) {

        if (StringUtils.isBlank(result)) {
            //数据异常
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_APPLE_GET_PAY_STATUS_EXCEPTION.getCode());
        }
        Map resultMap = new HashMap<String, String>(2);

        //解析苹果服务器返回数据
        Map<String, Object> map = JSONObject.parseObject(result, HashMap.class);
        //获得订单支付状态
        Integer status = (Integer) map.get("status");

        if (!Integer.valueOf(0).equals(status)) {
            //订单状态非成功状态
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_APPLE_ORDER_NOT_SUCCE_EXCEPTION.getCode());
        }

        //拿到"receipt"
        String receipt = map.get("receipt").toString();
        Map<String, Object> receiptMap = JSONObject.parseObject(receipt, HashMap.class);
        //拿到"in_app"数据
        List<LinkedHashMap> inAppResult = JSONObject.parseArray(receiptMap.get("in_app").toString(), LinkedHashMap.class);

        inAppResult.stream().forEach(val ->{
            //如果该参数与付款数一致
            val.get("product_id").equals(ApplePayProductEnums.getByorderNum(paySysTradeDo.getMoneyNumber()).getProductId());
            resultMap.put("product_id", val.get("product_id"));
            resultMap.put("transaction_id", val.get("transaction_id"));
            //与最后一单一致
        });
            return resultMap;

    }

    /**
     * 苹果修改支付状态
     *
     * @param paySysTradeDo
     * @param map
     * @param isEnforcement 是否强制
     */
    private void updatePayState(PaySysTradeDo paySysTradeDo, Map<String, String> map, IsValidEnums isEnforcement) {
        String payNoticeDtoKey = RedisPayKey.getPayNoticeRedisKey(PayChannelEnums.APPLE_PAY.getChannelType(), Long.valueOf(paySysTradeDo.getLocalTradeNo()));


        String transactionId = defaultRemoteTradeNo;
        //非强制修改
        if (IsValidEnums.NO.equals(isEnforcement)) {


            String productId = map.get("product_id");
            transactionId = map.get("transaction_id");
            ApplePayProductEnums applePayProductEnums = ApplePayProductEnums.getEnumsByProductId(productId);

            if (null == applePayProductEnums) {
                //订单数据异常
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_APPLE_PRODUCTID_ERROR_EXCEPTION.getCode());
            }
            if (!applePayProductEnums.getOrderNum().equals(paySysTradeDo.getMoneyNumber())) {
                //金额不一致
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_APPLE_MONEY_EQUALLY_EXCEPTION.getCode());
            }
        }
        PayNoticeDto payNoticeDto = PayNoticeDto.builder().payUserId(paySysTradeDo.getCreateUserId()).payChannel(paySysTradeDo.getPayChannel())
                .payTime(System.currentTimeMillis()).coinCount(paySysTradeDo.getMoneyNumber()).remoteTradeNo(transactionId)
                .localTradeNo(paySysTradeDo.getLocalTradeNo()).build();
        redisService.set(payNoticeDtoKey, payNoticeDto, RedisPayKey.OUT_TIME);

        //http调用加快乐币
        String result = HttpClientUtil.doGet(noticePayUrl + paySysTradeDo.getLocalTradeNo());

        Result resultDo = JSONObject.parseObject(result, Result.class);
        if (null == resultDo || !PublicExceptionCodeEnum.SUCCESS.getCode().equals(resultDo.getCode())) {
            //订单修改失败
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_PAYSYSTRADE_UPDATE_FAIL_EXCEPTION.getCode());
        }
        //修改订单状态
        if (!paySysTradeManager.updatePayState(paySysTradeDo.getLocalTradeNo(), transactionId, PayChannelEnums.APPLE_PAY, PayStatusEnum.PAY)) {
            //订单修改失败
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_PAYSYSTRADE_UPDATE_FAIL_EXCEPTION.getCode());
        }
    }
}
