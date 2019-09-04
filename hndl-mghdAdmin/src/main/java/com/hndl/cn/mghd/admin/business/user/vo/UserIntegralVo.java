package com.hndl.cn.mghd.admin.business.user.vo;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/20 20:00
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户积分数据的vo")
public class UserIntegralVo implements Serializable {

    private  String id; // _id

    private Long userId;//用户id

    private Long createTime;//创建时间

    private String getIntegralType;//积分获取途径,对应用积分的任务

    private Integer IntegralCount;//每次获取积分数

    private String  consumptionType;//消费类型

    private Long beforeOldValue ; // 操作前积分

    private Long beforeValue; //操作后积分

    private Long integralSum; //获取当前总积分数
}
