package com.hndl.cn.shop.sys.business.welfare.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 资龙茂
 * @Description 福卡交易记录Vo
 * @Date 2019年8月1日 10:59:31
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "福卡交易记录VO类")
public class FoucaultLogVo implements Serializable {

    @ApiModelProperty("福卡交易记录ID")
    private String id;

    /** 用户唯一ID */
    @ApiModelProperty("用户唯一ID")
    private Long userUniId;

    /** 创建时间 */
    @ApiModelProperty("创建时间")
    private Long createTime;

    /** 获取/消费途径 */
    @ApiModelProperty("获取/消费途径")
    private Integer taskType;

    /** 是否收入 */
    @ApiModelProperty("是否收入")
    private Integer isIncome;

    /** 福卡数量 */
    @ApiModelProperty("福卡数量")
    private Integer foucaultCount;

    /** 是否删除 */
    @ApiModelProperty("是否删除")
    private Integer isDelete;

    /** 交易类型 */
    @ApiModelProperty("交易类型")
    private String dealType;

    /** 交易类型图片 */
    @ApiModelProperty("交易类型图片")
    private String typeImg;
}