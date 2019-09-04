package com.hndl.cn.shop.admin.business.turntable.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.UserDayEmpiricalTypeEnums;
import com.hndl.cn.base.result.Result;
import com.hndl.cn.base.result.ResultFactory;
import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDo;
import com.hndl.cn.dao.prize.bean.LuckyTurntableInfoDoExample;
import com.hndl.cn.dao.prize.mapper.LuckyTurntableInfoMapper;
import com.hndl.cn.mongodb.manager.luckdraw.bean.FoucaultLogDo;
import com.hndl.cn.mongodb.manager.luckdraw.manager.FoucaultLogManager;
import com.hndl.cn.mongodb.manager.luckdraw.manager.LuckyDrawCouponManager;
import com.hndl.cn.mongodb.manager.user.manager.UserIntegralLogManager;
import com.hndl.cn.mongodb.manager.user.manager.UserStatisticsDoManager;
import com.hndl.cn.mysql.manager.common.manager.CommonUserInfoManager;
import com.hndl.cn.mysql.manager.prize.manager.LuckyTurntableManager;
import com.hndl.cn.mysql.manager.system.manager.SystemParameterInfoManager;
import com.hndl.cn.shop.admin.business.turntable.service.LuckyTurntableService;
import com.hndl.cn.shop.admin.business.turntable.vo.LuckyTurntableVo;
import com.hndl.cn.shop.admin.business.turntable.vo.TurntableInfoVo;
import com.hndl.cn.utils.spring.SpringCglibBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author 曹加丽
 * @Description 后台幸运大转盘实现类
 * @Date 2019/7/5 19:56
 * @Created by 湖南达联
 */
@Service
public class LuckyTurntableServiceImpl implements LuckyTurntableService {
    //用户中奖记录
    @Resource
    LuckyDrawCouponManager luckyDrawCouponManager;

    @Resource
    LuckyTurntableInfoMapper luckyTurntableInfoMapper;

    @Resource
    LuckyTurntableManager luckyTurntableManager;

    @Resource
    CommonUserInfoManager commonUserInfoManager;

    @Resource
    SystemParameterInfoManager systemParameterInfoManager;

    @Resource
    FoucaultLogManager foucaultLogManager;

    @Resource
    UserIntegralLogManager userIntegralLogManager;
    @Resource
    UserStatisticsDoManager userStatisticsDoManager;

    /**
     * 增加奖品
     *
     * @param turntableInfoVo
     * @param userUniId
     * @return
     */
    @Override
    public Result<Object> addLuckyTurntable(TurntableInfoVo turntableInfoVo, Long userUniId) {
        //查询未删除的奖品数小于8才能增加商品,否则一律失败
        if (luckyTurntableManager.findLuckyTurntable(IsValidEnums.NO).size() < 8) {
            LuckyTurntableInfoDo luckyDrawCouponDo = SpringCglibBeanUtils.convert(turntableInfoVo, LuckyTurntableInfoDo.class);
            luckyDrawCouponDo.setId(null);
            luckyDrawCouponDo.setIsDelete(IsValidEnums.NO.getValue());      //是否下架
            if (userUniId == null) return ResultFactory.failure();
            luckyDrawCouponDo.setCreateAdminId(userUniId);                  //创建人
            luckyDrawCouponDo.setCreateTime(new Date());                     //创建时间
            luckyDrawCouponDo.setUpateAdminId(userUniId);                    //最后修改人
            luckyDrawCouponDo.setUpdateTime(new Date());                     //最后修改时间
            luckyDrawCouponDo.setIsDelete(IsValidEnums.NO.getValue());       //是否删除
            luckyTurntableInfoMapper.insertSelective(luckyDrawCouponDo);
            return ResultFactory.success("添加成功!");
        }
        return ResultFactory.failure();
    }

    /**
     * 修改奖品信息
     *
     * @param turntableInfoVo
     * @param userUniId
     * @return
     */
    @Override
    public Result<Object> updateLuckyTurntable(TurntableInfoVo turntableInfoVo, Long userUniId) {
        LuckyTurntableInfoDo luckyDrawCouponDo = SpringCglibBeanUtils.convert(turntableInfoVo, LuckyTurntableInfoDo.class);
        luckyDrawCouponDo.setUpateAdminId(userUniId);                  //最后修改人
        luckyDrawCouponDo.setUpdateTime(new Date());                  //最后修改时间
        luckyDrawCouponDo.setIsDelete(IsValidEnums.NO.getValue());    //是否删除
        luckyTurntableManager.updateLuckyTurntable(luckyDrawCouponDo);
        return ResultFactory.success("修改成功,请刷新一下后台奖品数据!");
    }

    /**
     * 删除(下架)奖品信息
     *
     * @param prizeId
     * @param isValidEnums
     * @param userUniId
     * @return
     */
    @Override
    public Result<Object> deleteLuckyTurntable(Long prizeId, IsValidEnums isValidEnums, Long userUniId) {
        LuckyTurntableInfoDo luckyDrawCouponDo = new LuckyTurntableInfoDo();
        luckyDrawCouponDo.setId(prizeId);                           //奖品id
        //判断奖品是否存在,不存在就直接返回失败
        if (luckyTurntableInfoMapper.selectByPrimaryKey(prizeId) == null) return ResultFactory.failure();
        luckyDrawCouponDo.setUpateAdminId(userUniId);               //最后修改人
        luckyDrawCouponDo.setUpdateTime(new Date());                //最后修改时间
        luckyDrawCouponDo.setIsDelete(isValidEnums.getValue());        //是否删除
        luckyTurntableManager.updateLuckyTurntable(luckyDrawCouponDo);
        return ResultFactory.success("删除成功");
    }


    /**
     * 是否可以抽取实物(签名照,音乐专辑,门票)
     *
     * @param isValidEnums 是否可以抽取(1.是/0.否)
     * @return
     */
    @Override
    public Result<Object> luckyTurntableIsMaterialOpes(IsValidEnums isValidEnums) {
        String parameterName = "luckyDrawStatus";
        boolean b = systemParameterInfoManager.updateValueByParameterName(parameterName, isValidEnums.getValue().toString());
        System.out.println(b);
        if (b) {
            if (isValidEnums.getValue().equals(IsValidEnums.YES.getValue())) {
                return ResultFactory.success("已经成功开启可抽取实物");
            } else {
                return ResultFactory.success("已经成功关闭可抽取实物");
            }
        } else {
            return ResultFactory.failure();
        }

    }

    /**
     * 查询奖品信息
     *
     * @param prizeId 奖品id
     * @return
     */
    @Override
    public Result<Object> findPrizeLuckyById(Long prizeId) {

        return ResultFactory.success(luckyTurntableInfoMapper.selectByPrimaryKey(prizeId));
    }


    /**
     * 查询奖品信息
     *
     * @return
     */
    @Override
    public Result<Object> findPrizeLuckyTurntable(Integer pagerNo, Integer pagerSize) {
        PageHelper.startPage(pagerNo, pagerSize);
        List<LuckyTurntableInfoDo> coinBillInfoDos = luckyTurntableInfoMapper.selectByExample(new LuckyTurntableInfoDoExample());
        PageInfo<LuckyTurntableInfoDo> pageInfo = new PageInfo<>(coinBillInfoDos);
        if (pageInfo == null) return null;
        return ResultFactory.success(pageInfo.getList());
    }

    /**
     * 查询用户中奖信息
     *
     * @param userUniId 查询用户id
     * @param statTime  开始时间
     * @param endTime   结束时间
     * @param id        分页的条件
     * @return
     */
    @Override
    public Result<Object> findUserWinningThPrize(Long userUniId, Long statTime, Long endTime, String id, Integer pagerSize) {
        List<LuckyTurntableVo> list = new ArrayList<>();
        //查询用户中奖信息
        List<FoucaultLogDo> toDateGetCount = foucaultLogManager.findToDateGetCount(userUniId, id, statTime, endTime, IsValidEnums.NO, pagerSize);
        if (toDateGetCount.size() == 0) {
            return ResultFactory.success();
        }
        Map<Long, FoucaultLogDo> map = new HashMap<>();
        //去重
        for (FoucaultLogDo luckyDrawCouponDo : toDateGetCount) {
            if (map.get(luckyDrawCouponDo.getUserUniId()) != null) {
                if (!map.get(luckyDrawCouponDo.getUserUniId()).equals(luckyDrawCouponDo)) {
                    map.put(luckyDrawCouponDo.getUserUniId(), luckyDrawCouponDo);
                }
            } else {
                map.put(luckyDrawCouponDo.getUserUniId(), luckyDrawCouponDo);
            }
        }
        for (FoucaultLogDo value : map.values()) {
            list.add(this.get(value, statTime, endTime));
        }
        return ResultFactory.success(list);
    }

    /**
     * 获取用户抽奖信息
     *
     * @param luckyDrawCouponDo
     * @param statTime
     * @param endTime
     * @return
     */
    public LuckyTurntableVo get(FoucaultLogDo luckyDrawCouponDo, Long statTime, Long endTime) {
        LuckyTurntableVo vo = new LuckyTurntableVo();
        vo.setId(luckyDrawCouponDo.getId());
        vo.setUserId(luckyDrawCouponDo.getUserUniId());    //用户id
        vo.setUserName(commonUserInfoManager.findUserByUniId(luckyDrawCouponDo.getUserUniId()).getNickName()); //用户昵称
        //获取福卡记录信息
        int size = foucaultLogManager.findToDateGetCount(luckyDrawCouponDo.getUserUniId(), null, statTime, endTime, IsValidEnums.YES, null).size();
        if (size == 0) {
            //判断如果用户没有福卡记录就从用户基本信息表中查询
            size = userStatisticsDoManager.findUserStatisticsByUserUinId(luckyDrawCouponDo.getUserUniId()).getFoucaultCount();
        }
        vo.setTurntableSum(size); //获取用户总抽奖次数
        vo.setIntegralSum(userIntegralLogManager.findTeskUserAll(luckyDrawCouponDo.getUserUniId(), UserDayEmpiricalTypeEnums.LUCKYTURNTABLE));    //获取中奖积分数
        vo.setConsumeCount(foucaultLogManager.findToDateGetCount(luckyDrawCouponDo.getUserUniId(), null, statTime, endTime, IsValidEnums.NO, null).size());  //获取用户消耗的次数
        vo.setPrizeOneWinningSize(luckyDrawCouponManager.countWinning(luckyDrawCouponDo.getUserUniId(), 1L, statTime, endTime)); //获取抽中奖1的次数
        vo.setPrizeTwoWinningSize(luckyDrawCouponManager.countWinning(luckyDrawCouponDo.getUserUniId(), 2L, statTime, endTime)); //获取抽中奖2的次数
        vo.setPrizeThreeWinningSize(luckyDrawCouponManager.countWinning(luckyDrawCouponDo.getUserUniId(), 3L, statTime, endTime)); //获取抽中奖3的次数
        vo.setPrizeFiveWinningSize(luckyDrawCouponManager.countWinning(luckyDrawCouponDo.getUserUniId(), 4L, statTime, endTime)); //获取抽中奖4的次数
        vo.setPrizeFourWinningSize(luckyDrawCouponManager.countWinning(luckyDrawCouponDo.getUserUniId(), 5L, statTime, endTime)); //获取抽中奖5的次数
        vo.setPrizeSixWinningSize(luckyDrawCouponManager.countWinning(luckyDrawCouponDo.getUserUniId(), 6L, statTime, endTime)); //获取抽中奖6的次数
        vo.setPrizeSevenWinningSize(luckyDrawCouponManager.countWinning(luckyDrawCouponDo.getUserUniId(), 7L, statTime, endTime)); //获取抽中奖7的次数
        vo.setPrizeEightWinningSize(luckyDrawCouponManager.countWinning(luckyDrawCouponDo.getUserUniId(), 8L, statTime, endTime)); //获取抽中奖8的次数
        vo.setUserGetCount(foucaultLogManager.findToDateGetCount(null, null, statTime, endTime, IsValidEnums.NO, null).size());
        vo.setUserConsumeCount(foucaultLogManager.findToDateGetCount(null, null, statTime, endTime, IsValidEnums.YES, null).size());
        return vo;
    }

}
