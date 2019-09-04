package com.hndl.cn.mysql.manager.coin.manager.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.constants.BaseConstants;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.pay.PayChannelEnums;
import com.hndl.cn.base.enums.pay.PayReasonType;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDoExample;
import com.hndl.cn.dao.coin.mapper.HappyCoinBillInfoMapper;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.utils.collection.CollectionUtils;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.date.LocalDateUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @author 赵俊凯 @Description TODO @Date 2019/4/22 13:50 @Created by 湖南达联 */
@Service
public class HappyCoinBillInfoMangerImpl implements HappyCoinBillInfoManger {

  @Resource private HappyCoinBillInfoMapper happyCoinBillInfoMapper;

  @Override
  public boolean insertSelective(HappyCoinBillInfoDo record) {
    record.setIsDelete(IsValidEnums.NO.getValue());
    return happyCoinBillInfoMapper.insertSelective(record) > 0;
  }

  @Override
  public boolean checkRemoteTradeNoAndPayChannel(
      String remoteTradeNo, PayChannelEnums payChannelEnums) {
    HappyCoinBillInfoDoExample example = new HappyCoinBillInfoDoExample();
    HappyCoinBillInfoDoExample.Criteria criteria = example.createCriteria();
    criteria.andRemoteTradeNoEqualTo(remoteTradeNo);
    criteria.andPayTypeEqualTo(payChannelEnums.getChannelType());
    return happyCoinBillInfoMapper.countByExample(example) > 0;
  }

  @Override
  public HappyCoinBillInfoDo findByLocalTradeNo(Long localTradeNo, Long userUniId) {
    HappyCoinBillInfoDoExample example = new HappyCoinBillInfoDoExample();
    HappyCoinBillInfoDoExample.Criteria criteria = example.createCriteria();
    criteria.andCreateUserIdEqualTo(userUniId);
    criteria.andLocalTradeNoEqualTo(localTradeNo);
    List<HappyCoinBillInfoDo> list = happyCoinBillInfoMapper.selectByExample(example);
    return CollectionUtils.isEmpty(list) ? null : list.get(0);
  }

  /**
   * 查询用户快乐币
   *
   * @param userUniId
   * @param currentPage
   * @param isValidEnums
   * @return
   */
  @Override
  public List<HappyCoinBillInfoDo> findHappyCoinBillInfo(
      Long userUniId, Integer currentPage, IsValidEnums isValidEnums) {
    HappyCoinBillInfoDoExample example = new HappyCoinBillInfoDoExample();
    example
        .createCriteria()
        .andIsPayEqualTo(isValidEnums.getValue())
        .andCreateUserIdEqualTo(userUniId)
        .andIsDeleteEqualTo(IsValidEnums.NO.getValue());
    example.setOrderByClause("id DESC");
    PageHelper.startPage(currentPage, BaseConstants.DEFAULT_LIMIT);

    List<HappyCoinBillInfoDo> coinBillInfoDos = happyCoinBillInfoMapper.selectByExample(example);
    PageInfo<HappyCoinBillInfoDo> pageInfo = new PageInfo<>(coinBillInfoDos);

    List<HappyCoinBillInfoDo> list = pageInfo.getList();
    return CollectionUtils.isEmpty(list) ? new ArrayList<>() : list;
  }

  @Override
  public Long findCoinCountByStarId(Long startDate, Long endDate, Long starId) {
    HappyCoinBillInfoDoExample example = new HappyCoinBillInfoDoExample();
    example.createCriteria()
            .andCreateTimeBetween(new Date(startDate), new Date(endDate))
            .andReasonObjIdEqualTo(starId.toString())
            .andIsPayEqualTo(IsValidEnums.YES.getValue())
            .andIsDeleteEqualTo(IsValidEnums.NO.getValue());
    return happyCoinBillInfoMapper.queryBillSum(example);
  }

  /**
   * 根据时间段查询用户快乐币消费记录
   *
   * @param startTime 开始时间
   * @param endTime 结束时间
   * @param userUniId 用户
   * @param payReason 消费类型
   * @param pageNo 页码
   */
  @Override
  public List<HappyCoinBillInfoDo> findHappyCoinBillInfo(Long startTime, Long endTime, Long userUniId, PayReasonType payReason, Integer pageNo) {
    HappyCoinBillInfoDoExample example = new HappyCoinBillInfoDoExample();
    HappyCoinBillInfoDoExample.Criteria criteria = example.createCriteria();
    if (null != startTime  && null  != endTime){

      criteria.andCreateTimeBetween(new Date(startTime), new Date(endTime));
    }
    if (null != userUniId){
      criteria.andCreateUserIdEqualTo(userUniId);
    }
    if (null != payReason){
      criteria.andReasonTypeEqualTo(payReason.getReasonType());
    }
    example.setOrderByClause("id DESC");
    PageHelper.startPage(pageNo,BaseConstants.DEFAULT_LIMIT);
    List<HappyCoinBillInfoDo> happyCoinBillInfoDos = happyCoinBillInfoMapper.selectByExample(example);
    PageInfo<HappyCoinBillInfoDo> happyCoinBillInfoDoPageInfo = new PageInfo<>(happyCoinBillInfoDos);
    return happyCoinBillInfoDoPageInfo.getList();

  }

  @Override
  public Long countToDayVote(Long userUniId) {
    HappyCoinBillInfoDoExample example = new HappyCoinBillInfoDoExample();
    Date now = new Date();
    example.createCriteria()
            .andCreateUserIdEqualTo(userUniId)
            .andCreateTimeBetween(DateUtil.beginOfDate(now),DateUtil.endOfDate(now))
             .andReasonTypeEqualTo(PayReasonType.HAPPY_COIN_VOTE.getReasonType());

    List<HappyCoinBillInfoDo> happyCoinBillInfoDos = happyCoinBillInfoMapper.selectByExample(example);
    if(CollectionUtils.isEmpty(happyCoinBillInfoDos)){
        return 0L;
    }
    return happyCoinBillInfoDos.stream().mapToLong(info -> info.getCoinCount()).sum();
  }

  @Override
  public Long queryCountByExample(Long startDate, Long endDate, Long starId) {
    HappyCoinBillInfoDoExample example = new HappyCoinBillInfoDoExample();
    HappyCoinBillInfoDoExample.Criteria criteria = example.createCriteria();
    criteria
            .andReasonObjIdNotEqualTo("0000")
            .andCreateTimeBetween(new Date(startDate), new Date(endDate))
            .andIsPayEqualTo(IsValidEnums.YES.getValue())
            .andIsDeleteEqualTo(IsValidEnums.NO.getValue());
    if (null != starId){
      criteria.andReasonObjIdEqualTo(starId.toString());
    }
    return happyCoinBillInfoMapper.queryCountByExample(example);
  }

  @Override
  public Long queryUserCount(Long startDate, Long endDate) {
    HappyCoinBillInfoDoExample example = new HappyCoinBillInfoDoExample();
    example.createCriteria()
            .andCreateTimeBetween(new Date(startDate), new Date(endDate))
            .andIsPayEqualTo(IsValidEnums.YES.getValue())
            .andIsDeleteEqualTo(IsValidEnums.NO.getValue());
    return happyCoinBillInfoMapper.queryUserCount(example);
  }
}
