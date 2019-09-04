package com.hndl.cn.mghd.admin.business.topic.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:hndl-platform
 * @description:TODO 话题状态vo
 * @author: 易成贤
 * @create: 2019/7/31 10:31
 * @Created by湖南达联
 **/
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "话题状态vo")
public class TopicStatusVo {

    /**
     * 类型
     */
    @ApiModelProperty("key")
    private Integer type;
    /**
     * 描述
     */
    @ApiModelProperty("描述")
    private String description;

}
