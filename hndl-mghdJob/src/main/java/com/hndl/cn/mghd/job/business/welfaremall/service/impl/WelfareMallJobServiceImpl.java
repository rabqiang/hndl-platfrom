package com.hndl.cn.mghd.job.business.welfaremall.service.impl;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.math.NumberEnums;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.base.redis.MgHdRedisKeyEnums;
import com.hndl.cn.mghd.job.business.welfaremall.service.MessageService;
import com.hndl.cn.mghd.job.business.welfaremall.service.WelfareMallJobService;
import com.hndl.cn.mongodb.manager.luckdraw.bean.HelpWelfareDo;
import com.hndl.cn.mongodb.manager.luckdraw.bean.UserWelfareMappingDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.FoucaultLogManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.HelpWelfareManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.UserWelfareMappingManager;
import com.hndl.cn.mongodb.manager.user.bean.UserReceivingAddressDo;
import com.hndl.cn.mongodb.manager.user.manager.UserReceivingAddressManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.nosql.redis.service.RedisService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * @author 曹加丽
 * @Description TODO  福利开奖
 * @Date 2019/7/30 15:30
 * @Created by 湖南达联
 */
@Service
public class WelfareMallJobServiceImpl implements WelfareMallJobService {
    private static final Logger log = LoggerFactory.getLogger(WelfareMallJobServiceImpl.class);
    //奖品信息
    @Resource
    HelpWelfareManager helpWelfareManager;
    //用户助力信息
    @Resource
    UserWelfareMappingManager userWelfareMappingManager;
    //用户中奖收货信息
    @Resource
    UserReceivingAddressManager userReceivingAddressManager;
    @Resource
    UserStatisticsDoManager userStatisticsDoManager;
    @Resource
    FoucaultLogManager foucaultLogManager;
    @Resource
    RedisService redisService;
    @Resource
    MessageService messageService;


    /**
     * 开奖
     * 1.查询满足开奖条件商品
     * 2 查询参与活动人数(人数根据设置前几名中奖获得)
     * 3.如果还剩余中奖次数就继续抽奖,直到抽完为止
     * 4.将商品开奖保存中奖人id信息,后\形成中奖记录和收货信息
     */
    @Override
    public void findHelpUserUpdateSuccess() {
//        1.查询满足开奖条件商品
        List<HelpWelfareDo> helpUserById = helpWelfareManager.findSuccessAll(System.currentTimeMillis());
        log.info("================已扫描到 " + helpUserById.size() + " 个达到开奖/失败条件的奖品 ================");
        for (HelpWelfareDo helpWelfareDo : helpUserById) {
            //判断当前助力值大于或者等于指定的助力值,就继续开奖操作
            if (helpWelfareDo.getNowSumCount() >= helpWelfareDo.getHelpCount()) {
                //判断没有设置前多少名可中奖,默认设置前500可中奖
                if (helpWelfareDo.getSortCount() == null && helpWelfareDo.getSortCount() == 0)
                    helpWelfareDo.setSortCount(500);
                //2 查询参与活动人数(人数根据设置前几名中奖获得),并且去除指定人数信息
                List<UserWelfareMappingDo> userWelfareByWelfareNumber = userWelfareMappingManager.findUserWelfare(helpWelfareDo.getWelfareNumber(),
                        helpWelfareDo.getSuccessUserUniId(), helpWelfareDo.getSortCount());
                if (userWelfareByWelfareNumber.size() > 0) {
                    //如果有指定人id就要奖励次数减去指定人数(奖品数最小值为1)
                    helpWelfareDo.setPrizeCount(helpWelfareDo.getPrizeCount() - helpWelfareDo.getSuccessUserUniId().size());
                    //3. 如果还剩余中奖次数就继续抽奖,直到抽完为止
                    helpWelfareDo.getSuccessUserUniId().addAll(this.getSuccessUserUniId(userWelfareByWelfareNumber, helpWelfareDo.getPrizeCount()));
                    //4.将商品开奖保存中奖人id信息,形成中奖记录和收货信息
                    if (helpWelfareManager.updateHelpUserLottery(helpWelfareDo.getWelfareNumber(), helpWelfareDo.getSuccessUserUniId())) {
                        for (Long aLong : helpWelfareDo.getSuccessUserUniId()) {
                            //创建中奖用户收货信息
                            UserReceivingAddressDo addressDo = new UserReceivingAddressDo();
                            addressDo.setUserUniId(aLong);                                  //用户id
                            addressDo.setCreateTime(System.currentTimeMillis());            //中奖时间
                            addressDo.setWelfareNumber(helpWelfareDo.getWelfareNumber()); //奖品期号
                            addressDo.setIsDelivery(IsValidEnums.NO.getValue());          //是否发货
                            addressDo.setIsDelete(IsValidEnums.NO.getValue());            //是否删除
                            userReceivingAddressManager.setUserReceiving(addressDo);
                        }
                        log.info("=================商品" + helpWelfareDo.getWelfareNumber() + "开奖成功,恭喜中奖用户:" + helpWelfareDo.getSuccessUserUniId() + "=================");
                        //推送成功信息
                        messageService.welfarePrizeLottery(helpWelfareDo.getWelfareNumber());
                    } else {
                        log.error("=================商品" + helpWelfareDo.getWelfareNumber() + "达到开奖条件,但是开奖失败====================");
                    }
                }
            }
            //判断已经达到开奖时间但是助力值小于指定助力值,就开奖失败
            else {
                if (helpWelfareManager.updateHelpUserInvalid(helpWelfareDo.getWelfareNumber())) {
                    if (helpWelfareDo.getFoucaultCount() > 0) {
                        log.info("================商品" + helpWelfareDo.getWelfareNumber() + "未满足开奖条件,修改开奖失败状态,操作成功 ================");
                        //查询参与此次活动用户信息
                        List<UserWelfareMappingDo> userWelfareByWelfareNumber = userWelfareMappingManager.findUserWelfare(helpWelfareDo.getWelfareNumber(), new ArrayList<>(), null);
                        for (UserWelfareMappingDo mappingDo : userWelfareByWelfareNumber) {
                            //将退还的福卡数添加到用户统计表中
                            userStatisticsDoManager.userAddFoucaultCount(mappingDo.getUserUniId(), helpWelfareDo.getFoucaultCount());
                            //将退还的福卡生成退还记录
                            foucaultLogManager.insertFoucaultLogs(mappingDo.getUserUniId(), FoucaultGetTypeEnums.RETURN_ROBBERY, IsValidEnums.YES, helpWelfareDo.getFoucaultCount());
                        }
                        log.info("====================已退还 " + userWelfareByWelfareNumber.size() + " 位用户每人 " + helpWelfareDo.getFoucaultCount() + " 福卡====================");
                    }
                    //推送失败信息
                    messageService.welfarePrizeLottery(helpWelfareDo.getWelfareNumber());
                } else {
                    log.error("=================商品" + helpWelfareDo.getWelfareNumber() + "未满足开奖条件,修改开奖失败状态,操作失败====================");
                }
            }
            /**
             * 刷新Redis的已开奖奖品信息
             * 这里set为null后, shopSys请求接口时就会重新查一次库并set到redis中
             * 如果在这里赋了值，那就会出现set的值是job的VO，而get的值是shopSys的VO
             * 会出现转换异常。
             */
            String key = MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getCacheKey(NumberEnums.ZERO.getEnglish());
            redisService.set(key, null, MgHdRedisKeyEnums.PRIZE_CACHE_KEY.getExpireTime());
        }
    }

    /**
     * 获取参与福利奖品中奖人id
     *
     * @param userWelfareByWelfareNumber 参与福利活动的人信息
     * @param prizeCount                 奖品数量
     * @return
     */
    public List<Long> getSuccessUserUniId(List<UserWelfareMappingDo> userWelfareByWelfareNumber, Integer prizeCount) {
        List<Long> listUserId = new ArrayList<>();
        int total = 0; //总权重
        TreeMap<Integer, UserWelfareMappingDo> map = new TreeMap<>();
        for (int i = 0; i < userWelfareByWelfareNumber.size(); i++) {
            UserWelfareMappingDo array = userWelfareByWelfareNumber.get(i); //获取用户
            //以权重区间段的后面的值作为key存当前信息
            total += array.getHelpCount();
            map.put(total, array);
        }
        for (int j = 0; j < prizeCount; j++) {
            //系统随机选取大于等于 0.0 且小于 1.0 的伪随机 double 值
            int random = (int) (Math.random() * total);
            Integer key = map.ceilingKey(random);
            //判断查询用户信息不为空并且之前没有添加过这个用户id
            if (map.get(key) != null && !listUserId.contains(map.get(key).getUserUniId())) {
                listUserId.add(map.get(key).getUserUniId()); //获取中奖用户信息
                userWelfareByWelfareNumber.remove(map.get(key)); //移除抽中用户信息
            } else {
                //如果获取不到用户信息,就重新在抽取一位
                j--;
            }
        }
        return listUserId;
    }

}
