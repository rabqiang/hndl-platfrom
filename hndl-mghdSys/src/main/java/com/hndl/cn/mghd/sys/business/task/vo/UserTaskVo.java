package com.hndl.cn.mghd.sys.business.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program: hndl-platform
 * @description: 任务实体类
 * @author: 易成贤
 * @create: 2019-05-08 10:51
 * @Created by 湖南达联
 **/
@ApiModel(value = "任务信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserTaskVo implements Serializable {


    @ApiModelProperty("任务图片")
    private String taskImg;

    @ApiModelProperty(value = "任务类型")
    private Integer taskType;//任务类型


    @ApiModelProperty(value = "完成条数")
    private Integer finished ;//完成的条数

    @ApiModelProperty(value = "可领取条数")
    private Integer noGetted; // 可领取条数

    @ApiModelProperty(value = "任务总数")
    private Integer countTask; //任务总数

    @ApiModelProperty(value = "任务描述")
    private String taskDescription; //任务描述

    @ApiModelProperty(value = "任务积分数")
    private Integer taskIntegral;

    @ApiModelProperty(value = "领取返回领取了多少积分")
    private Long getIntegral;

    @ApiModelProperty("appId，推广任务需要")
    private String appid;

    @ApiModelProperty("路径，推广任务需要")
    private String path;
}
