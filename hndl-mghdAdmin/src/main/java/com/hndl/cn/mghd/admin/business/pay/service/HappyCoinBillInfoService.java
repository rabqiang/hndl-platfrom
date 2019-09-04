package com.hndl.cn.mghd.admin.business.pay.service;

import com.hndl.cn.base.result.Result;
import com.hndl.cn.mghd.admin.business.pay.vo.HappyCoinBillInfoVo;
import com.hndl.cn.mghd.admin.business.pay.vo.PayReasonVo;

import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 快乐币管理查询
 * @author: 易成贤
 * @create: 2019/7/1 14:17
 * @Created by湖南达联
 **/
public interface HappyCoinBillInfoService {


    /**
     * 查询消费类型
     * @return
     */
    Result<List<PayReasonVo>> findPayReason();

    /**
     *
     * @param startTime 开始时间
     * @param endTime 结束时间
     * @param userUniId 用户id
     * @param payReason 消费类型
     * @param pageNo 页码
     * @return
     */
    Result<List<HappyCoinBillInfoVo>> findHappyCoinBill(Long startTime, Long endTime, Long userUniId, Integer payReason, Integer pageNo);
}
