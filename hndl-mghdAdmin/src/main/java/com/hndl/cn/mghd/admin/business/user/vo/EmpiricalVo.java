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
 * @Date 2019/6/24 12:59
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户经验值数据的vo")
public class EmpiricalVo implements Serializable {

    private String id;  //_id

   private Long userUniId;//用户id

    private  Long createTime;//创建时间

    private String getEmpiricalType;//经验值获取途径,对应用积分的任务

    private Integer empiricalCount;//每次获取经验值

    private Long empiricalSum;// 总经验值
}
