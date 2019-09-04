package com.hndl.cn.mghd.admin.business.topic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:hndl-platform
 * @description:TODO 话题vo
 * @author: 易成贤
 * @create: 2019/7/29 19:58
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "话题vo")
public class TopicVo {

    /**
     * id
     */
    @ApiModelProperty(value = "id")
    private String id;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    private Long createTime;

    /**
     * 创建者
     */
    @ApiModelProperty(value = "创建人id")
    private Long createAdminId;

    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    private Long updateTime;

    /**
     * 最后更新者
     */
    @ApiModelProperty(value = "更新人id")
    private Long updateAdminId;

    /**
     * 标题
     */
    @ApiModelProperty(value = "标题")
    private String title;

    /**
     * 内容
     */
    @ApiModelProperty(value = "内容")
    private String content;

    /**
     * 审核状态【发布状态】
     */
    @ApiModelProperty(value = "发布状态")
    private Integer audit;

    @ApiModelProperty(value = "发布状态")
    private String  auditStr;

    /**
     * 话题标题图
     */
    @ApiModelProperty(value = "话题图片")
    private String titleImgUrl;

    /**
     * 点赞数
     */
    @ApiModelProperty(value = "点赞数")
    private Integer likeCount;


    /**
     * 发布时间
     */
    @ApiModelProperty(value = "发布时间")
    private Long publishTime;


    /**
     * 结束推荐时间
     */
    @ApiModelProperty(value = "结束推荐时间")
    private Long endRecommendTime;

    /**
     * 推荐
     */
    @ApiModelProperty(value = "推荐")
    private String isRecommen;

    @ApiModelProperty(value = "是否推荐判断")
    private Integer isRecommenInt;

    /**
     * 评论数
     */
    @ApiModelProperty(value = "评论数")
    private Integer commentCount;

    /**
     * 是否删除
     */
    @ApiModelProperty(value = "是否删除")
    private Integer isDelete;
}
