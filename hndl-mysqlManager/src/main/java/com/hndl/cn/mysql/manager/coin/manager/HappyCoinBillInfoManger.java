package com.hndl.cn.mysql.manager.coin.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayReasonType;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;


/**
 * @author 赵俊凯
 * @Description 用户快乐币流水表
 * @Date 2019/4/22 13:48
 * @Created by 湖南达联
 */
public interface HappyCoinBillInfoManger {


    /**
     * 插入用户快乐币流水
     * @param record
     * @return
     */
    boolean insertSelective(HappyCoinBillInfoDo record);


    /**
     * 查询是否存在订单
     * @param remoteTradeNo
     * @param payChannelEnums
     * @return
     */
    boolean checkRemoteTradeNoAndPayChannel(String remoteTradeNo, PayChannelEnums payChannelEnums);


    /**
     * 查询用户订单
     * @param localTradeNo
     * @param userUniId
     * @return
     */
    HappyCoinBillInfoDo findByLocalTradeNo(Long localTradeNo,Long userUniId);

    /**
     * 查询用户快乐币
     * @param userUniId
     * @param pageNo
     * @param isValidEnums
     * @return
     */
    List<HappyCoinBillInfoDo> findHappyCoinBillInfo(Long userUniId, Integer pageNo,IsValidEnums isValidEnums);

    /**
     * 根据时间查询明星比心数据
     * @param startDate
     * @param endDate
     * @param starId
     * @return
     */
    Long findCoinCountByStarId(Long startDate, Long endDate, Long starId);

    /**
     * 根据时间段查询用户快乐币消费记录
     * @param startTime
     * @param endTime
     * @param userUniId
     * @param payReason
     * @param pageNo
     */
    List<HappyCoinBillInfoDo> findHappyCoinBillInfo(Long startTime, Long endTime, Long userUniId, PayReasonType payReason, Integer pageNo);

    /**
     * 根据时间统计比心数据
     * @param startDate
     * @param endDate
     * @return
     */
    Long queryCountByExample(Long startDate, Long endDate, Long starId);


    /**
     *
     * @param userUniId
     * @return
     */
    Long countToDayVote(Long userUniId);

    /**
     * 根据时间查询比心用户数(去重)
     * @param startDate
     * @param endDate
     * @return
     */
    Long queryUserCount(Long startDate, Long endDate);

}
