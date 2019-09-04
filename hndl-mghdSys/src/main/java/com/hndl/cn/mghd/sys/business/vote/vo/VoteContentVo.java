package com.hndl.cn.mghd.sys.business.vote.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @program:hndl-platform
 * @description:TODO 打榜内容vo
 * @author: 易成贤
 * @create: 2019/8/27 17:59
 * @Created by湖南达联
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel( "打榜内容")
public class VoteContentVo implements Serializable {
    @ApiModelProperty("类型")
    private Integer type;
    @ApiModelProperty("标题")
    private  String title;
    @ApiModelProperty("内容")
    private String content;
}
