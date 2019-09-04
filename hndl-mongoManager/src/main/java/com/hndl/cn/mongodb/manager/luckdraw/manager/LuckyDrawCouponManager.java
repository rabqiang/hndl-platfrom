package com.hndl.cn.mongodb.manager.luckdraw.manager;

import com.hndl.cn.base.enums.IsValidEnums;
import com.hndl.cn.base.enums.user.FoucaultGetTypeEnums;
import com.hndl.cn.base.enums.welfare.WelfareTypeEnums;
import com.hndl.cn.mongodb.manager.luckdraw.bean.LuckyDrawCouponDo;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @program:hndl-platform
 * @description:TODO 奖品日志
 * @author: 易成贤
 * @create: 2019/7/5 18:20
 * @Created by湖南达联
 **/
public interface LuckyDrawCouponManager {
    /**
     * 统计指定渠道用户抽奖次数
     *
     * @param userUniId
     * @return
     */
    Long countByUserUniId(Long userUniId,WelfareTypeEnums welfareTypeEnums);

    /**
     * 统计用户加时间判断
     */
    List<LuckyDrawCouponDo> countLuckyDraw(Long userUniId ,Long statTime, Long endTime);

    /**
     * 根据用户id,中奖时间查询用户中奖信息
     */
    List<LuckyDrawCouponDo> findWinningByUserUniId(Long UserUniId,String id, Long statTime, Long endTime);

    /**
     * 根据用户id和中奖id获取用户中多少次
     */
    Long countWinning(Long UserUinId, Long prizeId,WelfareTypeEnums welfareTypeEnums);

    /**
     * 根据用户id和中奖id,加时间判断获取用户中多少次
     */
    Long countWinning(Long UserUinId, Long prizeId, Long statTime, Long endTime);

    /**
     * count今天获取的次数
     * @param userUniId
     * @param foucaultGetTypeEnums
     * @return
     */
    Long countWinningToDayByUserUniId(Long userUniId, FoucaultGetTypeEnums foucaultGetTypeEnums);



    /**
     * 统计渠道奖品记录
     *
     * @param prizeId
     * @return
     */
    Long countByPrizeId(@NotNull Long prizeId,WelfareTypeEnums welfareTypeEnums);



    /**
     * 通过奖品id 查询用户奖品信息
     * @param sysUniId
     * @param isEntity
     * @return
     */
    List<LuckyDrawCouponDo> findUserList(String id, @NotNull long sysUniId, @NotNull IsValidEnums isEntity, @NotNull Integer limit,@NotNull WelfareTypeEnums welfareTypeEnums);

    /**
     * 统计用户指定渠道上今天获取的的条数
     * @param sysUniId 用户id
     * @param isEntity 是不是实物
     * @param welfareTypeEnums 渠道
     * @return
     */
    Long countToDayWinByUser(@NotNull Long sysUniId, @NotNull IsValidEnums isEntity,@NotNull WelfareTypeEnums welfareTypeEnums);
    /**
     * 插入一条奖品记录
     * @param userUniId 用户
     * @param prizeId 奖品id
     * @param welfareType 福利类型
     * @param isGet 是否已经获得/领取
     */
    void insertLuckyDrawCoupon(Long userUniId, Long prizeId , WelfareTypeEnums welfareType, IsValidEnums isGet,IsValidEnums isEntity);

    /**
     * 统计渠道商当天获取实物/非实物的条数
     * @param isEntity
     * @param welfareTypeEnums
     * @return
     */
    Long countToDayByEntity( @NotNull IsValidEnums isEntity,@NotNull WelfareTypeEnums welfareTypeEnums);

    /**
     * 修改福利商场领取状态
     * @param userUniId     用户uniId
     * @param prizeId       奖品id
     * @param welfareType   福利类型
     * @return
     */
    boolean updateLuckyDrawCoupon(Long userUniId, Long prizeId , WelfareTypeEnums welfareType);

}
