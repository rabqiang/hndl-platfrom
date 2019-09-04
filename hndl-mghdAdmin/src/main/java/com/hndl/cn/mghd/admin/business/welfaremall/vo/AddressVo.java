package com.hndl.cn.mghd.admin.business.welfaremall.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/8/6 11:44
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "中奖收货信息的vo")
public class AddressVo implements Serializable {
    private String id;            //_id
    private String welfareNumber; //商品期号
    private String welfareName;      //商品名
    private String userUniId;//中奖人id
    private String successUserName;//中奖人昵称
    private String phoneNumber;//手机号
    private String receivingName;//收货人
    private String receivingAddress;//收货地址
    private Integer isDelivery;  //是否发货
    private Long receivingNumber;//发货单号
    private String reason;// 备注
}
