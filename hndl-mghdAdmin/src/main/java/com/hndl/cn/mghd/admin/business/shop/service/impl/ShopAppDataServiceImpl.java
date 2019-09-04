package com.hndl.cn.mghd.admin.business.shop.service.impl;

import com.hndl.cn.base.enums.pay.PayStatusEnum;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.dao.shop.bean.ShopAppDataDo;
import com.hndl.cn.dao.shop.bean.ShopAppDataDoExample;
import com.hndl.cn.dao.shop.mapper.ShopAppDataDoMapper;
import com.hndl.cn.mghd.admin.business.shop.service.ShopAppDataService;
import com.hndl.cn.mghd.admin.business.shop.vo.ShopAppDataVo;
import com.hndl.cn.mghd.admin.exception.MghdAdminException;
import com.hndl.cn.mghd.admin.exception.MghdAdminExceptionEnums;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.mysql.manager.pay.manager.PaySysTradeManager;
import com.hndl.cn.utils.date.DateUtil;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/15 15 01
 * @Description:
 * @Author: 资龙茂
 */
@Service
public class ShopAppDataServiceImpl implements ShopAppDataService {

    @Resource
    private CommonUserInfoManager commonUserInfoManager;

    @Resource
    private HappyCoinBillInfoManger happyCoinBillInfoManger;

    @Resource
    private UserIntegralLogManager userIntegralLogManager;

    @Resource
    private PaySysTradeManager paySysTradeManager;

    @Resource
    private UserDayTaskManager userDayTaskManager;

    @Resource
    private ShopAppDataDoMapper shopAppDataDoMapper;

    @Override
    public Result<Object> findShopAppDataByDate(Integer pageNum, Integer pageSize, Long startDate, Long endDate) {
        // 查询分两种：
        // 1. 输入页码和pageSize，普通查询数据
        // 2. 输入时间段 & 页码 & pageSize，查询时间段内数据

        // 一次查询数据不能超过20条, 也不能查询0条以下数据
        if (pageSize < 0 || pageSize > 20) {
            throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_SHOP_APP_DATA_ERROR.getCode());
        }
        Map<String, Object> resultMap = new HashMap<>();
        ShopAppDataDoExample example = new ShopAppDataDoExample();
        if (startDate != null && endDate != null) {
            // 1. 校验结束时间不能小于开始时间
            if ((endDate < startDate)) {
                throw new MghdAdminException(MghdAdminExceptionEnums.MGHD_ADMIN_DATE_ERROR.getCode());
            }
            example.createCriteria().andCreateTimeBetween(new Date(startDate), new Date(endDate));
        }
        Long dataCount = shopAppDataDoMapper.countByExample(example);
        example.setLimit(pageSize);
        example.setOffset(Long.valueOf((pageNum - 1) * pageSize));
        example.setOrderByClause(" create_time DESC");

        List<ShopAppDataDo> list = shopAppDataDoMapper.selectByExample(example);
        integration(list);
        List<ShopAppDataVo> resultList = SpringCglibBeanUtils.convertByList(list, ShopAppDataVo.class);
        resultMap.put("resultList", resultList);
        resultMap.put("dataCount", dataCount);
        return ResultFactory.success(resultMap);
    }

    @Override
    public Result<Object> findCurrentShopAppData() {
        // 1. 默认页码，查询当日数据
        ShopAppDataVo shopAppDataVo = new ShopAppDataVo();
        Date currentBeginDate = DateUtil.beginOfDate(new Date());
        Date currentEndDate = DateUtil.endOfDate(new Date());
        // 统计日期
        shopAppDataVo.setCountTime(currentBeginDate);
        // 新增用户数
        shopAppDataVo.setNewUserCount(commonUserInfoManager.countNewUserByDate(currentBeginDate, currentEndDate));
        // 活跃用户数
        shopAppDataVo.setActivityUserCount(
                userDayTaskManager.countTaskUserByDate(
                        currentBeginDate.getTime()
                        , currentEndDate.getTime()
                        , UserDayTaskEnums.LOGIN_TASK
                        , null, null).intValue()
        );
        // 比心数
        shopAppDataVo.setMangoCurrencyCount(happyCoinBillInfoManger.queryCountByExample(
                currentBeginDate.getTime(),
                currentEndDate.getTime(), null).intValue() / 100);
        // 比心人数
        shopAppDataVo.setMangoCurrencyPersonCount(happyCoinBillInfoManger.queryUserCount(currentBeginDate.getTime(), currentEndDate.getTime()).intValue());
        // 积分打榜数
        shopAppDataVo.setScoringCount(userIntegralLogManager.findIntegralCountAll(
                currentBeginDate.getTime(),
                currentEndDate.getTime()).intValue()) ;
        // 积分打榜人数
        shopAppDataVo.setScoringPersonCount(userDayTaskManager.countTaskUserByDate(
                currentBeginDate.getTime()
                , currentEndDate.getTime()
                , UserDayTaskEnums.INTEGRAL_TASK
                , null, null).intValue()
        );
        // 充值总金额
        shopAppDataVo.setRechargeCount(paySysTradeManager.findPaySysCount(
                currentBeginDate.getTime(),
                currentEndDate.getTime(),
                null,
                null,
                PayStatusEnum.PAY
        ).doubleValue() / 100D);
        return ResultFactory.success(shopAppDataVo);
    }

    /**
     * 统计比心数
     * @param happyCoinBillInfoDoList
     * @return
     */
    Long setCoinCountValue(List<HappyCoinBillInfoDo> happyCoinBillInfoDoList) {
        Long coinCount = 0L;
        for (HappyCoinBillInfoDo happyCoinBillInfoDo : happyCoinBillInfoDoList
             ) {
            coinCount += happyCoinBillInfoDo.getCoinCount();
        }
        return coinCount / 100;
    }

    /**
     * 统计比心人数
     * @param happyCoinBillInfoDoList
     * @return
     */
    int setCoinUserCountValue(List<HappyCoinBillInfoDo> happyCoinBillInfoDoList) {
        for (int i = 0; i < happyCoinBillInfoDoList.size() - 1; i++) {
            for (int j = happyCoinBillInfoDoList.size() - 1; j > i; j--) {
                if (happyCoinBillInfoDoList.get(j).getCreateUserId().equals(happyCoinBillInfoDoList.get(i).getCreateUserId())) {
                    happyCoinBillInfoDoList.remove(j);
                }
            }
        }
        return happyCoinBillInfoDoList.size();
    }

    /**
     * 统计积分打榜数
     * @param userIntegralLogDoList
     * @return
     */
    Long setIntegralCountValue(List<UserIntegralLogDo> userIntegralLogDoList) {
        Long integralCount = 0L;
        for (UserIntegralLogDo userIntegralLogDo : userIntegralLogDoList
                ) {
            integralCount += userIntegralLogDo.getIntegralCount();
        }
        return integralCount;
    }

    /**
     * 统计积分打榜人数
     * @param userIntegralLogDoList
     * @return
     */
    int setIntegralUserCountValue(List<UserIntegralLogDo> userIntegralLogDoList) {
        for (int i = 0; i < userIntegralLogDoList.size() - 1; i++) {
            for (int j = userIntegralLogDoList.size() - 1; j > i; j--) {
                if (userIntegralLogDoList.get(j).getUserUniId().equals(userIntegralLogDoList.get(i).getUserUniId())) {
                    userIntegralLogDoList.remove(j);
                }
            }
        }
        return userIntegralLogDoList.size();
    }

    /**
     * 整合数据
     * @param list
     * @return
     */
    List<ShopAppDataDo> integration(List<ShopAppDataDo> list) {
        for (ShopAppDataDo shopAppDataDo : list) {
            shopAppDataDo.setMangoCurrencyCount(shopAppDataDo.getMangoCurrencyCount() + shopAppDataDo.getThirdPayHeartCount());
            shopAppDataDo.setMangoCurrencyPersonCount(shopAppDataDo.getMangoCurrencyPersonCount() + shopAppDataDo.getThirdPayHeartPersonCount());
        }
        return list;
    }
}
