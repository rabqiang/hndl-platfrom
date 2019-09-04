package com.hndl.cn.mghd.sys.business.search.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description: 查询粉丝会的vo
 * @author: 易成贤
 * @create: 2019-05-27 20:25
 * @Created by湖南达联
 **/
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel("搜索")
public class FansGroupVo implements Serializable {

    @ApiModelProperty(value = "明星id")
    private Long starId;

    @ApiModelProperty(value = "明星名称")
    private String starName;//明星名称

    @ApiModelProperty(value = "明星头像url")
    private String starImg;//明星头像

    @ApiModelProperty(value = "明星描述信息")
    private String starDescription;//明星描述

    @ApiModelProperty(value = "是加入粉丝会吗?1是0否")
    private Integer isRelation;


}
