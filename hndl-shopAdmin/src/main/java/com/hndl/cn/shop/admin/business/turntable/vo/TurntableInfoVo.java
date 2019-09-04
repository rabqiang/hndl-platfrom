package com.hndl.cn.shop.admin.business.turntable.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * @author 曹加丽
 * @Description TODO 后台 转盘信息
 * @Date 2019/7/9 18:00
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "转盘奖品数据的vo")
public class TurntableInfoVo {

    /**
     * 奖品id
     */
    @ApiModelProperty(value = "奖品id,增加不需要输入")
    private Long prizeId;

    /**
     * 奖品名称
     */
    @ApiModelProperty(value = "奖品名称")
    @NotNull
    private String prizeName;

    /**
     * 是不是实物
     */
    @ApiModelProperty(value = "是不是实物 1.是0.否")
    @NotNull
    private Integer isEntity;

    /**
     * 权重概率
     */
    @ApiModelProperty(value = "权重概率")
    @NotNull
    private Integer weightNum;

    /**
     * 排序值
     */
    @ApiModelProperty(value = "排序值")
    private Integer orderNum;

    /**
     * 库存值
     */
    @ApiModelProperty(value = "库存值")
    @NotNull
    private Integer reserveNum;

    /**
     * 用户最多获得次数
     */
    @ApiModelProperty(value = "用户最多获取次数")
    @Min(0)
    private Integer personMaxGet;
    /**
     * 用户最小抽奖次数
     */
    @ApiModelProperty(value = "用户最小抽奖次数")
    @NotNull
    @Min(0)
    private Integer personMinDraw;
    /**
     * 是否删除1.是0.否
     */
    @ApiModelProperty(value = "是否删除 1.是0.否")
    @NotNull
    private Integer isDelete;
    /**
     * 是否发送消息,1.是0.否
     */
    @ApiModelProperty(value = "是否发送消息,1.是0.否")
    @NotNull
    private Integer showMessage;
    /**
     * 积分值
     */
    @ApiModelProperty(value = "中奖积分数")
    @Min(0)
    private Long integral;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "副标题")
    private String subhead;

}
