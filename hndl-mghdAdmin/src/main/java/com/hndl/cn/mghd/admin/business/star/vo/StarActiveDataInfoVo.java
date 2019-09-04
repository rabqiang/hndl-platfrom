package com.hndl.cn.mghd.admin.business.star.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Classname 明星任务数据va
 * @Created by 湖南达联
 * @Date 2019/7/3 10 52
 * @Description:
 * @Author: 资龙茂
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "粉丝会数据")
public class StarActiveDataInfoVo implements Serializable {


    @ApiModelProperty("明星id")
    private Long starId;


    @ApiModelProperty("明星姓名")
    private String starName;


    @ApiModelProperty("积分数")
    private Long integralCount;


    @ApiModelProperty("比心数")
    private Long heartCount;


    @ApiModelProperty("守护数")
    private Integer guardCount;

    @ApiModelProperty("守护人数")
    private Integer guardUserCount;


    @ApiModelProperty("打call数")
    private Long callCount;


    @ApiModelProperty("召唤数")
    private Integer summonCount;


    @Override
    public String toString() {
        return "明星统计数据Vo{" +
                "明星ID=" + starId +
                ", 明星姓名='" + starName + '\'' +
                ", 积分打榜数=" + integralCount +
                ", 比心数=" + heartCount +
                ", 守护数=" + guardCount +
                ", 守护人数=" + guardUserCount +
                ", 打call数=" + callCount +
                ", 召唤数=" + summonCount +
                '}';
    }
}
