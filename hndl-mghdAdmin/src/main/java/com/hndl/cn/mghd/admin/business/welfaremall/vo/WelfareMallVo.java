package com.hndl.cn.mghd.admin.business.welfaremall.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/7/25 14:46
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "福利商城的vo,必须传递奖品图片和奖品详情图片")
public class WelfareMallVo implements Serializable {

    private String id;              //商品编号
    private String welfareNumber;//期号
    private String prizeName;    //奖品名称
    private String prizeImg;     //奖品图片
    private List<String> detailsPrizeImg;//详细奖品图片
    private String description;//福利描述
    private Integer foucaultCount;//消耗福卡数量
    private Integer prizeCount; //奖品数量(既库存)
    private Long startTime;       //抽奖开始时间
    private Long endTime;          //抽奖结束时间
    private Integer helpCount;    //开奖需要的助力值
    private Integer nowSumCount;  //当前助力值
    private Integer sortCount;  //前多少名才可以获得奖励
    private Integer participants;  //总参与人数
    private List<String> successUserUniId;//中奖人id
    private Integer isSuccess;//是否开奖成功

}
