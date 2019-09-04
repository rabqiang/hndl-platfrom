package com.hndl.cn.mghd.admin.business.welfaremall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/8/14 11:03
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "修改福利商品的vo")
public class HelpCommodityVo implements Serializable {
    @NotNull
    private String welfareNumber;//期号
    @ApiModelProperty(value = "奖品图片")
    private String prizeImg;     //奖品图片
    @ApiModelProperty(value = "商品详情图片,最少上传一张,最多9张")
    private List<String> detailsPrizeImg; //商品图片
    @ApiModelProperty(value = "前多少名才可以获得奖励,不能小于0")
    @Min(value = 0)
    private Integer sortCount;//前多少名才可以获得奖励
    @ApiModelProperty(value = "活动规则")
    private String description;          //活动规则
    @ApiModelProperty(value = "指定中奖用户unId")
    private List<Long> successUserUniId;//中奖人id
}
