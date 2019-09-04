package com.hndl.cn.mghd.admin.business.topic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description:TODO 新增话题的vo
 * @author: 易成贤
 * @create: 2019/7/30 10:31
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "新增话题vo")
public class ReceiveTopicVo implements Serializable {


    /**
     * 标题
     */
    @ApiModelProperty("标题")
    @NotNull
    @Length(min = 1,message = "标题")
    private String title;

    /**
     * 内容
     */
    @ApiModelProperty("内容")
    @Length(min = 4,message = "内容")
    private String content;


    /**
     * 话题标题图
     */
    @ApiModelProperty("图片")
    @NotNull
    private String titleImgUrl;


    /**
     * 发布时间
     */
    @ApiModelProperty("发布时间")
    @NotNull
    private Long publishTime;


    /**
     * 结束推荐时间
     */
    @ApiModelProperty("结束推荐时间")
    @NotNull
    private Long endRecommendTime;


}
