package com.hndl.cn.mghd.sys.business.task.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 曹加丽
 * @Description 徒弟信息
 * @Date 2019/5/27 14:40
 * @Created by 湖南达联
 */
@ApiModel(value = "用户徒弟信息")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SlaveUserVo implements Serializable {

    @ApiModelProperty(value = "徒弟用户id")
    private Long userUniId; //徒弟用户id
    @ApiModelProperty(value = "徒弟拜师时间")
    private Long CreateDate;//徒弟时间
    @ApiModelProperty(value = "徒弟昵称")
    private String nickName;//徒弟昵称
    @ApiModelProperty(value = "徒弟头像")
    private  String slaveImgUrl;//徒弟头像
    @ApiModelProperty(value = "徒弟给师父添加了多少额外积分")
    private Long  integralCount; //徒弟给师父添加了多少积分

}
