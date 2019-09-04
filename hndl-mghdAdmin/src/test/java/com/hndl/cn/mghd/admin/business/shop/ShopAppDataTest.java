package com.hndl.cn.mghd.admin.business.shop;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.pay.PayStatusEnum;
import com.hndl.cn.base.enums.user.UserDayTaskEnums;
import com.hndl.cn.dao.coin.bean.HappyCoinBillInfoDo;
import com.hndl.cn.dao.shop.bean.ShopAppDataDo;
import com.hndl.cn.dao.shop.mapper.ShopAppDataDoMapper;
import com.hndl.cn.mghd.admin.business.shop.service.ShopAppDataService;
import com.hndl.cn.mongodb.manager.task.manager.UserDayTaskManager;
import com.hndl.cn.mongodb.manager.user.bean.UserIntegralLogDo;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mysql.manager.coin.manager.HappyCoinBillInfoManger;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.mysql.manager.pay.manager.PaySysTradeManager;
import com.hndl.cn.utils.date.DateUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @Classname
 * @Created by 湖南达联
 * @Date 2019/7/15 21 27
 * @Description:
 * @Author: 资龙茂
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class ShopAppDataTest {

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

    @Resource
    private ShopAppDataService shopAppDataService;

    @Test
    public void findCurrentShopAppData() {

        System.out.println(shopAppDataService.findCurrentShopAppData());
        //System.out.println(shopAppDataService.findShopAppDataByDate(0, 10, null, null));
    }

    @Test
    public void testInsert() {
        for (int i = 3; i > 2; i--) {

            ShopAppDataDo shopAppDataDo = new ShopAppDataDo();
            Date currentDate = DateUtil.addDays(new Date(), -i);
            Date currentBeginDate = DateUtil.beginOfDate(currentDate);
            Date currentEndDate = DateUtil.endOfDate(currentDate);

            shopAppDataDo.setCreateTime(new Date());
            shopAppDataDo.setCreateOperator("system");
            shopAppDataDo.setLastModifyTime(new Date());
            shopAppDataDo.setLastOperator("system");
            shopAppDataDo.setThirdPayHeartCount(IsValidEnums.NO.getValue());
            shopAppDataDo.setThirdPayHeartPersonCount(IsValidEnums.NO.getValue());
            shopAppDataDo.setTotalUserOrderCount(IsValidEnums.NO.getValue());
            shopAppDataDo.setTotalOrderCount(IsValidEnums.NO.getValue());
            shopAppDataDo.setDouPayCount(0D);
            shopAppDataDo.setCoinPayCount(0D);
            shopAppDataDo.setThirdPayCount(0D);
            shopAppDataDo.setItemOpenCount(0L);
            shopAppDataDo.setNewItemCount(0L);
            shopAppDataDo.setUserBuyCount(0L);
            shopAppDataDo.setTotalBuyCount(0L);
            shopAppDataDo.setIsDeleted(IsValidEnums.NO.getOldValue());

            // 统计日期
            shopAppDataDo.setCountTime(currentBeginDate);
            // 新增用户数
            shopAppDataDo.setNewUserCount(commonUserInfoManager.countNewUserByDate(currentBeginDate, currentEndDate));
            // 活跃用户数
            shopAppDataDo.setActivityUserCount(
                    userDayTaskManager.countTaskUserByDate(
                            currentBeginDate.getTime()
                            , currentEndDate.getTime()
                            , UserDayTaskEnums.LOGIN_TASK
                            , null, null).intValue()
            );
            // 比心数
            shopAppDataDo.setMangoCurrencyCount(happyCoinBillInfoManger.queryCountByExample(
                    currentBeginDate.getTime(),
                    currentEndDate.getTime(), null).intValue() / 100);
            // 比心人数
            shopAppDataDo.setMangoCurrencyPersonCount(happyCoinBillInfoManger.queryUserCount(currentBeginDate.getTime(), currentEndDate.getTime()).intValue());
            // 积分打榜数
            shopAppDataDo.setScoringCount(userIntegralLogManager.findIntegralCountAll(
                    currentBeginDate.getTime(),
                    currentEndDate.getTime()).intValue()) ;
            // 积分打榜人数
            shopAppDataDo.setScoringPersonCount(userDayTaskManager.countTaskUserByDate(
                    currentBeginDate.getTime()
                    , currentEndDate.getTime()
                    , UserDayTaskEnums.INTEGRAL_TASK
                    , null, null).intValue()
            );
            // 充值总金额
            shopAppDataDo.setRechargeCount(paySysTradeManager.findPaySysCount(
                    currentBeginDate.getTime(),
                    currentEndDate.getTime(),
                    null,
                    null,
                    PayStatusEnum.PAY
            ).doubleValue() / 100D);
            shopAppDataDoMapper.insert(shopAppDataDo);
            System.out.println(shopAppDataDo.toString());
        }
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
