package com.hndl.cn.mghd.sys.business.message.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @program:hndl-platform
 * @description: 举报类型vo
 * @author: 易成贤
 * @create: 2019-06-09 21:45
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "举报类型")
public class UserFeedbackTypeVo {
    /**
     *  类型
     */
    @ApiModelProperty(value = "举报类型")
    Integer type;
    /**
     * 描述
     */
    @ApiModelProperty(value = "举报描述")
    String description;
}
