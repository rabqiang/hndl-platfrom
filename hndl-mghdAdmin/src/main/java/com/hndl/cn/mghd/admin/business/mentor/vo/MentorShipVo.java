package com.hndl.cn.mghd.admin.business.mentor.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description TODO
 * @Date 2019/6/19 16:31
 * @Created by 湖南达联
 */
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@ApiModel(value = "用户师徒数据的vo")
public class MentorShipVo implements Serializable {

    @ApiModelProperty(value = "id")
    private String id;              //_id
    @ApiModelProperty(value = "师父id(即用户id)")
    private Long userId;            //用户id
    @ApiModelProperty(value = "徒弟id")
    private Long slaveId;           //徒弟id
    @ApiModelProperty(value = "收徒时间")
    private Long slaveCreateTime; //收徒时间
    @ApiModelProperty(value = "徒弟昵称")
    private String slaveName;       //徒弟昵称
    @ApiModelProperty(value = "徒弟最后活跃时间")
    private Long slaveLastTime;    //徒弟最后活跃时间
    @ApiModelProperty(value = "用户徒弟总数")
    private Long slaveSum;        //用户徒弟总数

}
