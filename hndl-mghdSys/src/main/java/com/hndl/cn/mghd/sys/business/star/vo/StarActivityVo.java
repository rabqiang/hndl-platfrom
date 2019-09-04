package com.hndl.cn.mghd.sys.business.star.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 活动VO
 * @author: 尹争鸣
 * @create: 2019年6月5日19:36:30
 * @Created by 湖南达联
 **/
@ApiModel(value = "粉丝会与粉丝会关系数据")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StarActivityVo implements Serializable {

    /**
     * 活动名称
     */
    private String activityName;

    /**
     * 副标题
     */
    private String subtitle;

    /**
     * 显示日期
     */
    private String showDate;

    /**
     * 上架开始时间
     */
    private Date startDate;

    /**
     * 上架结束时间
     */
    private Date endDate;

    /**
     * 活动描述
     */
    private String activityDesc;

    /**
     * 图片地址
     */
    private String imgUrl;

    /**
     * 跳转类型 (h5、itemDetail/商品详情、shopHome/夺宝首页、null/不跳转)
     */
    private String toType;

    /**
     * 跳转h5地址
     */
    private String toHttpUrl;

    /**
     * 排序值
     */
    private Integer orderNum;

    /**
     * 参与人数
     */
    private Integer applyCount;

    /**
     * 状态(最新new、最热hot、已结束end)
     */
    private String activityStatus;

    /**
     * 分类名称（活动/心愿树）
     */
    private String typeName;

    /**
     * 分类redis名称（activity/wish）
     */
    private String typeKey;
}
