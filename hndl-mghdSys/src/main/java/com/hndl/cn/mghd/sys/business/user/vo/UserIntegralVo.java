package com.hndl.cn.mghd.sys.business.user.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/5/24 9:56
 * @Created by 湖南达联
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "积分流水")
public class UserIntegralVo implements Serializable {

    @ApiModelProperty(value = "_id")
    String id;
    //积分描述
    @ApiModelProperty(value = "积分描述(任务)")
    private String description;
    //获取时间
    @ApiModelProperty(value = "获取时间")
    private Long  createTime;
    //积分
    @ApiModelProperty(value = "积分数")
    private Integer  integral;

}
