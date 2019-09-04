package com.hndl.cn.shop.sys.business.turntable.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:hndl-platform
 * @description:TODO 大转盘vo
 * @author: 易成贤
 * @create: 2019/7/18 13:46
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("任务Vo")
public class LuckyTurntableTaskVo {

    @ApiModelProperty("类型")
    private Integer taskType;
    /**
     * 标题
     */
    @ApiModelProperty("标题")
    private String taskTitle;


    /**
     * 表述
     */
    @ApiModelProperty("描述")
    private String description;

    /**
     * 图片
     */
    @ApiModelProperty("图片")
    private String imgUrl;



    @ApiModelProperty("按钮状态")
    private String button;
}
