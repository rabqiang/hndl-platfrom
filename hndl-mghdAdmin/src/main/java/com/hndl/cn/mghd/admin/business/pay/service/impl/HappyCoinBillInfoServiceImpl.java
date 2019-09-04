package com.hndl.cn.mghd.admin.business.pay.service.impl;

import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayReasonType;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.mghd.admin.business.pay.service.HappyCoinBillInfoService;
import com.hndl.cn.mghd.admin.business.pay.vo.HappyCoinBillInfoVo;
import com.hndl.cn.mghd.admin.business.pay.vo.PayReasonVo;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program:hndl-platform
 * @description:TODO 快乐币管理查询
 * @author: 易成贤
 * @create: 2019/7/1 14:18
 * @Created by湖南达联
 **/
@Service
public class HappyCoinBillInfoServiceImpl implements HappyCoinBillInfoService {

    private final Long month = 2678400000L;
    @Resource
    HappyCoinBillInfoManger happyCoinBillInfoManger;


    @Override
    public Result<List<PayReasonVo>> findPayReason() {
        List<PayReasonVo> payReasonVos = new ArrayList<>();
        for (PayReasonType value : PayReasonType.values()) {
            payReasonVos.add(PayReasonVo.builder().reasonType(value.getReasonType()).description(value.getDescription()).build());
        }
        return ResultFactory.success(payReasonVos);
    }

    /**
     *
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @param userUniId 用户id
     * @param payReason 消费类型
     * @param pageNo    页码
     * @return
     */
    @Override
    public Result<List<HappyCoinBillInfoVo>> findHappyCoinBill(Long startTime, Long endTime, Long userUniId, Integer payReason, Integer pageNo) {

        List<HappyCoinBillInfoDo> happyCoinBillInfo = happyCoinBillInfoManger.findHappyCoinBillInfo(startTime, endTime, userUniId, PayReasonType.evalVal(payReason), pageNo);
        List<HappyCoinBillInfoVo> happyCoinBillInfoVos =
                happyCoinBillInfo.stream().map(
                        val -> {
                            HappyCoinBillInfoVo convert = SpringCglibBeanUtils.convert(val, HappyCoinBillInfoVo.class);
                            convert.setCreateTime(val.getCreateTime().getTime());
                            convert.setPayType(PayChannelEnums.evalVal(val.getPayType()).getDescription());
                            convert.setReasonType(PayReasonType.evalVal(val.getReasonType()).getDescription());
                            return convert;
                     }
                ).collect(Collectors.toList());
        return ResultFactory.success(happyCoinBillInfoVos);
    }


}
