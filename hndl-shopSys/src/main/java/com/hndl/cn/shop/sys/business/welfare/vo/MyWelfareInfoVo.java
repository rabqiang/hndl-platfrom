package com.hndl.cn.shop.sys.business.welfare.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname 我的助力信息VO
 * @Created by 湖南达联
 * @Date 2019/8/4 17 36
 * @Description:
 * @Author: 资龙茂
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ApiModel(value = "我的助力信息VO类")
public class MyWelfareInfoVo implements Serializable {

    /** 我的助力信息id */
    @ApiModelProperty("我的助力信息id")
    private String myWelfareId;

    /** 头像 */
    @ApiModelProperty("头像")
    private String headImg;

    /** 昵称 */
    @ApiModelProperty("昵称")
    private String nickName;

    /** 助力值 */
    @ApiModelProperty("助力值")
    private Integer helpCount;

    /** 中奖概率 */
    @ApiModelProperty("中奖概率")
    private String winningRate;

}
