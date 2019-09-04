package com.hndl.cn.mghd.sys.business.video.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description: 独家视频vo
 * @author: 易成贤
 * @create: 2019-06-10 17:43
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "独家视频vo")
public class ExclusiveVideoVo implements Serializable {

    /**
     * 标题
     */
    @ApiModelProperty(value = "视频标题")
    private String title;
    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    private String description;


    /**
     * 视频连接
     */
    @ApiModelProperty(value = "视频vid")
    private String txVid;


    @ApiModelProperty("图片")
    private String videoImg;
}
