package com.hndl.cn.mghd.admin.business.welfaremall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO  福利商场的商品vo
 * @Date 2019/7/29 14:28
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "福利商城的商品vo")
public class CommodityVo implements Serializable {
    @NonNull
    @ApiModelProperty(value = "奖品名称")
    private String prizeName;        //奖品名称
    @NotNull
    @ApiModelProperty(value = "奖品封面图片")
    private String prizeImg;         // 奖品封面图片
    @NonNull
    @Size(min = 1,max = 9)
    @ApiModelProperty(value = "商品详情图片,最少上传一张,最多9张",name = "商品详情图片,最少上传一张,最多9张")
    private List<String> detailsPrizeImg; //商品图片
    @NotNull
    @ApiModelProperty(value = "抽奖开始时间")
    private Long startTime;        //抽奖开始时间
    @NotNull
    @ApiModelProperty(value = "抽奖结束时间")
    private Long endTime;          //抽奖结束时间
    @NotNull
    @ApiModelProperty(value = "活动规则")
    private String description;          //活动规则
    @NotNull
    @ApiModelProperty(value = "奖品数量(既库存)",name = "奖品数量(既库存),最少为1")
    @Min(value = 1)
    private Integer prizeCount;     //奖品数量(既库存)
    @ApiModelProperty(value = "消耗福卡数量,也可不写,默认为零")
    private Integer foucaultCount;//消耗福卡数量
    @NotNull
    @ApiModelProperty(value = "开奖需要的助力值,不可以为空")
    private Integer helpCount;    //开奖需要的助力值
    @ApiModelProperty(value = "前多少名才可以获得奖励,也可不写")
    @NotNull
    @Min(value = 0)
    private Integer sortCount;//前多少名才可以获得奖励
}
