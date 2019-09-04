package com.hndl.cn.shop.admin.business.turntable.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description 后台查询 幸运转盘数据
 * @Date 2019/7/5 17:19
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "显示幸运转盘数据的vo")
public class LuckyTurntableVo implements Serializable {
    private String id;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 用户昵称
     */
    private String userName;
    /**
     * 总次数
     */
    private Integer turntableSum;

    /**
     * 消耗次数
     */
    private Integer consumeCount;

    /**
     * 用户获取的总次数
     */
    private  Integer  userGetCount;

    /**
     * 所有人消耗的总次数
     */
    private Integer userConsumeCount;


    /**
     * 获取中奖总积分值
     */
    private Long integralSum;


    /**
     * 奖品1 中奖次数
     */
    private Long prizeOneWinningSize;

    /**
     * 奖品2中奖次数
     */
    private Long prizeTwoWinningSize;
    /**
     * 奖品3 中奖次数
     */
    private Long prizeThreeWinningSize;
    /**
     * 奖品4 中奖次数
     */
    private Long prizeFiveWinningSize;
    /**
     * 奖品5 中奖次数
     */
    private Long prizeFourWinningSize;
    /**
     * 奖品6 中奖次数
     */
    private Long prizeSixWinningSize;
    /**
     * 奖品7 中奖次数
     */
    private Long prizeSevenWinningSize;
    /**
     * 奖品8 中奖次数
     */
    private Long prizeEightWinningSize;


}
