package com.hndl.cn.mghd.admin.business.shop.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Classname 后台统计数据Vo
 * @Created by 湖南达联
 * @Date 2019/7/10 11 24
 * @Description:
 * @Author: 资龙茂
 */
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "每日统计数据VO类")
public class ShopAppDataVo implements Serializable {

    /** 统计时间 */
    @ApiModelProperty("统计时间")
    private Date countTime;

    /** 新增用户数 */
    @ApiModelProperty("新增用户数")
    private Long newUserCount;

    /** 活跃用户数 */
    @ApiModelProperty("活跃用户数")
    private Integer activityUserCount;

    /** 快乐币比心数 */
    @ApiModelProperty("快乐币比心数")
    private Integer mangoCurrencyCount;

    /** 积分打榜数 */
    @ApiModelProperty("积分打榜数")
    private Integer scoringCount;

    /** 快乐币比心人数 */
    @ApiModelProperty("快乐币比心人数")
    private Integer mangoCurrencyPersonCount;

    /** 积分打榜人数 */
    @ApiModelProperty("积分打榜人数")
    private Integer scoringPersonCount;

    /** 充值数 */
    @ApiModelProperty("充值数")
    private Double rechargeCount;

    @Override
    public String toString() {
        return "ShopAppDataVo{" +
                "统计时间=" + countTime +
                ", 新增用户=" + newUserCount +
                ", 活跃用户=" + activityUserCount +
                ", 比心数=" + mangoCurrencyCount +
                ", 打榜数=" + scoringCount +
                ", 比心人数=" + mangoCurrencyPersonCount +
                ", 打榜人数=" + scoringPersonCount +
                ", 充值金额=" + rechargeCount +
                '}';
    }
}
